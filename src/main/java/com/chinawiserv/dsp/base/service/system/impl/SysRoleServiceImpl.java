package com.chinawiserv.dsp.base.service.system.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.common.response.ListResult;
import com.chinawiserv.dsp.base.entity.po.common.ztree.ZTreeNode;
import com.chinawiserv.dsp.base.entity.po.system.SysRole;
import com.chinawiserv.dsp.base.entity.po.system.SysRoleMenu;
import com.chinawiserv.dsp.base.entity.po.system.SysUserRole;
import com.chinawiserv.dsp.base.entity.vo.system.SysRoleVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.mapper.system.SysRoleMapper;
import com.chinawiserv.dsp.base.mapper.system.SysRoleMenuMapper;
import com.chinawiserv.dsp.base.mapper.system.SysUserMapper;
import com.chinawiserv.dsp.base.mapper.system.SysUserRoleMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysMenuService;
import com.chinawiserv.dsp.base.service.system.ISysRoleService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysRoleServiceImpl extends CommonServiceImpl<SysRoleMapper, SysRole, SysRoleVo> implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private ISysMenuService sysMenuService;

    @Override
    public Page<SysRoleVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        SysUserVo currentLoginUser = ShiroUtils.getLoginUser();
        List<SysRole> roles = currentLoginUser.getSysRoleList();
        int roleLevel = -1;
        if(roles != null){
            roleLevel = roles.stream().min((o1, o2) -> o1.getRoleLevel().compareTo(o2.getRoleLevel())).get().getRoleLevel();
        }
        paramMap.put("roleLevel", roleLevel);
        Page<SysRoleVo> page = getPage(paramMap);
        page.setOrderByField("create_time");
        page.setAsc(false);
        List<SysRoleVo> sysRoleVos = sysRoleMapper.selectVoPage(page, paramMap);
        page.setTotal(sysRoleMapper.selectVoCount(paramMap));
        page.setRecords(sysRoleVos);//同时得到条数
        return page;
    }

    @Override
    public SysRoleVo selectVoById(String id) throws Exception {
        return sysRoleMapper.selectVoById(id);
    }

    @Override
    public ListResult getAuth(String id) throws Exception {
        SysRole sysRole = selectById(id);
        if(sysRole == null){
            throw new RuntimeException("该角色不存在");
        }
        List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectList(new EntityWrapper<SysRoleMenu>().addFilter("role_id = {0}", id));
        List<String> menuIds = Lists.transform(sysRoleMenus, input -> input.getMenuId());
        List<ZTreeNode> zTreeNodes = sysMenuService.selectTreeMenuAllowAccessByMenuIdsAndPid(menuIds, "0");
        ListResult<ZTreeNode> listResult = new ListResult<ZTreeNode>();
        listResult.addAll(zTreeNodes);
        return listResult;
    }

    @Override
    public JSONObject checkRoleName(String roleName, String roleId) throws Exception {
        List<SysRole> list;
        JSONObject result = new JSONObject();
        if(StringUtils.isNotBlank(roleId)){
            list = selectList(new EntityWrapper<SysRole>().where("role_name = {0}", roleName).and("id != {0}", roleId).and("delete_flag = {0}", 0));//todo
        } else {
            list = selectList(new EntityWrapper<SysRole>().where("role_name = {0}", roleName).and("delete_flag = {0}", 0));//todo
        }
        if(list != null && !list.isEmpty()){
            result.put("error", "该角色名已存在");
        }
        return result;
    }

    @Override
    public List<JSONObject> getRoleNameList(String userId) throws Exception {
        List<JSONObject> result = new ArrayList<JSONObject>();
        List<SysRole> list = new ArrayList<SysRole>();
        if(StringUtils.isNotBlank(userId)){
            List<SysUserRole> userRoleList = sysUserRoleMapper.selectList(new EntityWrapper<SysUserRole>().addFilter("user_id={0} ",userId));//todo
            for(SysUserRole sysUserRole : userRoleList){
                SysRole sysRole = sysRoleMapper.selectById(sysUserRole.getRoleId());
                list.add(sysRole);
            }
        }else{
            list = sysRoleMapper.selectList(new EntityWrapper<SysRole>().addFilter("delete_flag = {0}", 0));
        }
        for(SysRole sysRole : list){
            JSONObject obj = new JSONObject();
            obj.put("id",sysRole.getId());
            obj.put("text",sysRole.getRoleName());
            result.add(obj);
        }
        return result;
    }

    @Override
    public boolean deleteRoleById(String id) throws Exception {
        int count = sysUserMapper.selectUsersCountByRoleId(id);
        if(count == 0){
            SysRole sysRole = new SysRole();
            sysRole.setId(id);
            sysRole.setDeleteFlag(1);
            return updateById(sysRole);
        }else throw new RuntimeException("Delete role failed, because some users are belong to it!");
    }

    @Override
    public boolean deleteBatchRoleByIds(List<String> ids) throws Exception {
        return retBool(sysRoleMapper.deleteBatchRoleByIds(ids));
    }

    @Override
    public boolean insertVO(SysRoleVo sysRoleVo) throws Exception {
        sysRoleVo.setId(CommonUtil.get32UUID());
        sysRoleVo.setCreateTime(new Date());
        sysRoleVo.setCreateUserId(ShiroUtils.getLoginUserId());
        sysRoleVo.setRoleType(1);
        return insert(sysRoleVo);
    }

    @Override
    public boolean updateVO(SysRoleVo sysRoleVo) throws Exception {
        sysRoleVo.setUpdateUserId(ShiroUtils.getLoginUserId());
        sysRoleVo.setUpdateTime(new Date());
        return updateById(sysRoleVo);
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return sysRoleMapper.selectVoCount(paramMap);
    }
}
