package com.chinawiserv.dsp.base.service.system.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.enums.system.AuthObjTypeEnum;
import com.chinawiserv.dsp.base.mapper.system.SysDeptAuthorityMapper;
import com.chinawiserv.dsp.base.mapper.system.SysDeptMapper;
import com.chinawiserv.dsp.base.mapper.system.SysRegionMapper;
import com.chinawiserv.dsp.base.mapper.system.SysUserMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDeptMap;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirNationalClassifyVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDeptMapMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 * 组织机构表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysDeptServiceImpl extends CommonServiceImpl<SysDeptMapper, SysDept, SysDeptVo> implements ISysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRegionMapper sysRegionMapper;
    
    //TODO 以下内容需要再检查下，删掉
    @Autowired
    private DirClassifyMapper dirClassifyMapper;
    
    @Autowired
    private DirDeptMapMapper dirDeptMapMapper;
    
    @Autowired
    private IDirClassifyService dirService;
    //TODO end
    @Autowired
    private SysDeptAuthorityMapper sysDeptAuthorityMapper;

    @Override
    public Page<SysDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Map<String, Object> param = this.getDeptCondition(null);
        //regionCodeCondition =5101是否合理？
        if (param != null && !param.isEmpty()) {
            paramMap.putAll(param);
            Page<SysDeptVo> page = getPage(paramMap);
            page.setOrderByField("update_time");
            page.setAsc(false);
            List<SysDeptVo> sysDeptVos = sysDeptMapper.selectVoPage(page, paramMap);
            page.setTotal(sysDeptMapper.selectVoCount(paramMap));
            page.setRecords(sysDeptVos);
            return page;
        }
        return getPage(paramMap);
    }

    @Override
    public Page<SysDeptVo> selectBaseVoPage(Map<String, Object> paramMap) throws Exception {
        Map<String, Object> param = this.getDeptCondition(null);
        if (param != null && !param.isEmpty()) {
            paramMap.putAll(param);
            Page<SysDeptVo> page = getPage(paramMap);
            page.setOrderByField("update_time");
            page.setAsc(false);
            List<SysDeptVo> sysDeptVos = sysDeptMapper.selectBaseVoPage(page, paramMap);
            page.setTotal(sysDeptMapper.selectBaseVoCount(paramMap));
            page.setRecords(sysDeptVos);
            return page;
        }
        return getPage(paramMap);
    }

    @Override
    public SysDeptVo selectVoById(String id) throws Exception {
        return sysDeptMapper.selectVoById(id);
    }

    @Override
    public JSONObject checkDeptName(String deptName, String fname, String deptId) {
        List<SysDept> list;
        JSONObject result = new JSONObject();
        list = selectList(new EntityWrapper<SysDept>().where("dept_name = {0}", deptName).and("fname = {0}", fname).and("id != {0}", deptId).and("delete_flag = {0}", "0"));
        if (list != null && !list.isEmpty()) {
            result.put("error", "该组织机构名称已存在");
        }
        return result;
    }

    @Override
    public List<SysDeptVo> getDeptSelectDataList(Map<String, Object> paramMap) throws Exception {
        if (paramMap == null) paramMap = new HashMap();
        String onlyRoot = (String) paramMap.get("onlyRoot");
        String regionCode = (String) paramMap.get("regionCode");
        if (StringUtils.isBlank(onlyRoot)) {
            onlyRoot = "0";
        }
        List<SysDeptVo> list = new ArrayList();
        Map<String, Object> param = new HashMap();
        if ("1".equals(onlyRoot)) {
            param.put("onlyRoot", onlyRoot);
            param.put("regionCode", regionCode);
        } else {
            boolean onlyLoginUserDept = "1".equals(paramMap.get("onlyLoginUserDept"));
            boolean showCurrDeptChildren = !onlyLoginUserDept;
            if(onlyLoginUserDept){
                Integer minRoleLevel = ShiroUtils.getLoginUser().getMinRoleLevel();
                if(minRoleLevel > 0){
                    String deptId = ShiroUtils.getLoginUserDeptId();
                    if(StringUtils.isNotBlank(deptId)){
                        String deptLevel = (String) paramMap.get("deptLevel");
                        if(StringUtils.isBlank(deptLevel)){
                            deptLevel = "0";
                        }
                        String topDeptId = findParentDeptId(Integer.valueOf(deptLevel) + 1, deptId);
                        showCurrDeptChildren = StringUtils.isBlank(topDeptId);
                        if(!showCurrDeptChildren){
                            param.put("id", topDeptId);
                        }
                    }else return list;
                }else showCurrDeptChildren = true;
            }
            if(showCurrDeptChildren){
                String id = (String) paramMap.get("id");
                if (StringUtils.isNotBlank(id)) {
                    param.put("fid", id);
                } else {
                    Map deptConditionMap = getDeptCondition(regionCode, true);
                    if (deptConditionMap != null && !deptConditionMap.isEmpty()) {
                        param.put("hasChildrenTopDept", "1");
                        param.putAll(deptConditionMap);
                    } else return list;
                }
            }
        }
        String withoutLoginUserDept = (String) paramMap.get("withoutLoginUserDept");
        if ("1".equals(withoutLoginUserDept)) {
            String loginUserDeptId = ShiroUtils.getLoginUserDeptId();
            if (StringUtils.isNotBlank(loginUserDeptId)) {
                param.put("withoutDept", loginUserDeptId);
            }
        }
        String withoutDept = (String) paramMap.get("withoutDept");
        if (StringUtils.isBlank(withoutDept)) {
            String withoutUserDept = (String) paramMap.get("withoutUserDept");
            if (StringUtils.isNotBlank(withoutUserDept)) {
                SysUserVo sysUserVo = sysUserMapper.selectVoById(withoutUserDept);
                if (sysUserVo != null) {
                    String userDeptId = sysUserVo.getDeptId();
                    if (StringUtils.isNotBlank(userDeptId)) {
                        param.put("withoutDept", userDeptId);
                    }
                }
            }
        } else {
            param.put("withoutDept", withoutDept);
        }
        String withoutAuthDept = (String) paramMap.get("withoutAuthDept");
        if ("1".equals(withoutAuthDept)) {
            param.put("withoutAuthDept", withoutAuthDept);
            param.put("applicant", ShiroUtils.getLoginUserId());
        }
        if (!param.isEmpty()) {
            list.addAll(sysDeptMapper.selectVoListForTreeData(param));
        }
        return list;
    }
    
    @Override
    public JSONArray getDeptSelectDataList() throws Exception {
        JSONArray jsonArray = new JSONArray();
        List<SysDept> list = new ArrayList<SysDept>();

        list = sysDeptMapper.selectList(new EntityWrapper<SysDept>());

        for(SysDept sysDept : list){
            JSONObject obj = new JSONObject();
            obj.put("id",sysDept.getId());
            obj.put("text",sysDept.getDeptName());

            jsonArray.add(obj);
        }
        return jsonArray;
    }

    private String findParentDeptId(int parentDeptLevel, String deptId){
        String parentDeptId = deptId;
        SysDeptVo sysDeptVo = sysDeptMapper.selectVoById(deptId);
        if(sysDeptVo != null){
            int deptLevel = sysDeptVo.getDeptLevel();
            if(deptLevel < parentDeptLevel){
                parentDeptId = null;
            }else if(deptLevel > parentDeptLevel){
                String fid = sysDeptVo.getFid();
                if(StringUtils.isNotBlank(fid)){
                    parentDeptId = findParentDeptId(parentDeptLevel, fid);
                }
            }
        }
        return parentDeptId;
    }

    @Override
    public boolean deleteDeptById(String id) throws Exception {
        SysDeptVo sysDeptVo = sysDeptMapper.selectVoById(id);
        if (sysDeptVo != null) {
            if (!sysDeptMapper.isParentDept(sysDeptVo.getId())) {
                int count = sysUserMapper.selectUsersCountByDeptId(id);
                if (count == 0) {
                    SysDept sysDept = new SysDept();
                    sysDept.setId(id);
                    sysDept.setDeleteFlag(1);
                    return updateById(sysDept);
                }else throw new Exception("有用户所属该组织机构");
            }else throw new Exception("该组织机构有下级组织机构");
        }
        return false;
    }

    @Override
    public List<SysDeptVo> selectVoList(Map<String, Object> paramMap) {
        return sysDeptMapper.selectVoList(paramMap);
    }
    
//    @Override
//    public String insertIntoDir(Map<String, Object> params){
//
//
//    	String Ids = (String) params.get("dcmIds");
//    	String [] dcmIdArray = Ids.split(",");
//    	List<String> dcmIds = Arrays.asList(dcmIdArray);
//
//    	String messageInfo = "";
//    	for (Iterator iterator = dcmIds.iterator(); iterator.hasNext();) {
//
//			String dcmId = (String) iterator.next();
//
//			if(dirClassifyMapper.selectMapByDeptId(dcmId)!= null){
//
//				    messageInfo= "0";
//					break;
//
//			}else if(dirClassifyMapper.selectBy23Region(sysDeptMapper.selectById(dcmId).getRegionCode())==null){
//
//					messageInfo= "1";
//					break;
//
//			}else if(dirClassifyMapper.selectMapByDeptId(dirClassifyMapper.selectFidById(dcmId))==null && !dirClassifyMapper.selectFidById(dcmId).equals("root") && !dirClassifyMapper.selectFidById(dirClassifyMapper.selectFidById(dcmId)).equals("root") ){
//					messageInfo= "2";
//					break;
//
//			}else if(dirClassifyMapper.selectFidById(dcmId).equals("root")){
//					messageInfo= "3";
//					break;
//
//			}else{
////					dirService.
//				String fid = "";
//				if(dirClassifyMapper.selectMapByDeptId(dirClassifyMapper.selectFidById(dcmId))!=null){
//					 fid = dirClassifyMapper.selectMapByDeptId(dirClassifyMapper.selectFidById(dcmId)).getClassifyId();
//				}else{
//					 fid = dirClassifyMapper.selectBy3Region(sysDeptMapper.selectById(dcmId).getRegionCode()).getId();
//				}
//					SysDept sysDept = dirClassifyMapper.selectDeptById(dcmId);
////					DirNationalClassifyVo dirNationalClassifyVo = mapper2.selectFclassify(fcode);
//			  		DirClassifyVo dirclassifyVo = new DirClassifyVo();
//
//			  		dirclassifyVo.setClassifyName(sysDept.getDeptName());
//			  		dirclassifyVo.setFid(fid);
//
//			  		DirClassifyVo vo = dirService.prepareClassifyVo(dirclassifyVo);
////				  		if(type.equals("2-1")){
////				  			vo.setClassifyType("5");
////				  		}else if(type.equals("2-2")){
////				  			vo.setClassifyType("6");
////				  		}else if(type.equals("3")){
////				  			vo.setClassifyType("7");
////				  		}
//			  		vo.setClassifyType("7");
//
//			  		dirClassifyMapper.baseInsert(vo);
//
//			  		DirDeptMap d = new DirDeptMap();
//			  		d.setClassifyId(vo.getId());
//			  		d.setDeptId(dcmId);
//			  		d.setId(CommonUtil.get32UUID());
//			  		dirDeptMapMapper.baseInsert(d);
//
//			  		messageInfo = "4";
//
//			}
//
//		}
//
//	    return messageInfo;
//
//    }

    @Override
    public boolean insertVO(SysDeptVo sysDeptVo) throws Exception {
        String fid = sysDeptVo.getFid();
        if (StringUtils.isBlank(fid)) {
            throw new Exception("未能找到父节点id");
        }
        SysDeptVo parent = sysDeptMapper.selectVoById(fid);
        if (parent != null) {
            Integer deptLevel = parent.getDeptLevel();
            if (deptLevel != null) {
                sysDeptVo.setDeptLevel(deptLevel + 1);
            } else {
                sysDeptVo.setDeptLevel(2);
            }
            String treeCode = parent.getTreeCode();
            if (treeCode == null) {
                treeCode = "";
            }
            Integer treeIndex = parent.getTreeIndex();
            if (treeIndex == null) {
                treeIndex = 1;
            } else {
                treeIndex++;
            }
            sysDeptVo.setTreeCode(treeCode + ";" + treeIndex);
            Integer status = sysDeptVo.getStatus();
            if (status == null) {
                status = 1;
            }
            if (status == 0) {
                sysDeptVo.setValidateTo(new Date());
            } else {
                sysDeptVo.setValidateFrom(new Date());
            }
            sysDeptVo.setDeptType(parent.getDeptType());
            sysDeptVo.setId(CommonUtil.get32UUID());
            sysDeptVo.setTreeIndex(0);
            String userId = ShiroUtils.getLoginUserId();
            Date time = new Date();
            sysDeptVo.setCreateUserId(userId);
            sysDeptVo.setCreateTime(time);
            sysDeptVo.setUpdateUserId(userId);
            sysDeptVo.setUpdateTime(time);
            if (insert(sysDeptVo)) {
                SysDept updateParent = new SysDept();
                updateParent.setId(parent.getId());
                updateParent.setTreeIndex(treeIndex);
                if (sysDeptMapper.updateById(updateParent) == 1) {
                    return true;
                }
            }
            throw new Exception("添加组织机构失败");
        } else {
            throw new Exception("未能找到父节点");
        }
    }

    @Override
    public boolean updateVO(SysDeptVo sysDeptVo) throws Exception {
        Integer status = sysDeptVo.getStatus();
        if (status == null) {
            status = 1;
        }
        if (status == 0) {
            sysDeptVo.setValidateTo(new Date());
        } else {
            sysDeptVo.setValidateFrom(new Date());
        }
        sysDeptVo.setUpdateUserId(ShiroUtils.getLoginUserId());
        sysDeptVo.setUpdateTime(new Date());
        return updateById(sysDeptVo);
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return sysDeptMapper.selectVoCount(paramMap);
    }

    @Override
    public Map<String, Object> getDeptCondition(String regionCode) {
        return getDeptCondition(regionCode, false);
    }

    @Override
    public Map<String, Object> getDeptCondition(String regionCode, boolean excludeTreeCodeCondition) {
        Map<String, Object> paramMap = new HashMap();
        SysUserVo loginUser = ShiroUtils.getLoginUser();
        String deptTreeCode = loginUser.getDeptTreeCode();
        int minRoleLevel = loginUser.getMinRoleLevel();
        if(minRoleLevel > 0 && StringUtils.isBlank(deptTreeCode)){
            return null;
        }else{
            if(!excludeTreeCodeCondition && StringUtils.isNotBlank(deptTreeCode)){
                paramMap.put("deptTreeCodeCondition", deptTreeCode);
            }
            if (StringUtils.isBlank(regionCode)) {
                regionCode = ShiroUtils.getLoginUser().getRegionCode();
            }
            SysRegionVo sysRegionVo = sysRegionMapper.selectVoByRegionCode(regionCode);
            if (sysRegionVo != null) {
                paramMap.put("regionCodeCondition", this.getRegionCodeCondition(regionCode, sysRegionVo.getRegionLevel()));
            }
            return paramMap;
        }
    }

    @Override
    public boolean isParentDept(String id) {
        if (StringUtils.isBlank(id)) {
            return true;
        } else {
            return sysDeptMapper.isParentDept(id);
        }
    }

    @Override
    public List<SysDeptVo> selectDeptListLikeTreeCode(List<String> list) {
        List<SysDeptVo> depts = null;
        if (list != null && list.size() > 0) {
            depts = sysDeptMapper.selectDeptListLikeTreeCode(list);
        } else {
            depts = sysDeptMapper.selectDeptListLikeTreeCode(null);
        }
        return depts;
    }

    @Override
    public List<String> selectDeptByPrivilege(String user_id) {
        return sysDeptMapper.selectDeptByPrivilege(user_id);
    }
}
