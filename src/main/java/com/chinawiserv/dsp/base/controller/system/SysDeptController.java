package com.chinawiserv.dsp.base.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.base.service.system.ISysRegionService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 组织机构表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/dept")
public class SysDeptController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysDeptService sysDeptService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRegionService sysRegionService;


    @RequiresPermissions("system:dept:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap ,Model model){
        setCurrentMenuInfo(paramMap);
        model.addAttribute("master",isMaster());
        return "system/dept/deptList";
    }

    @RequiresPermissions("system:dept:list")
    @RequestMapping("/auth")
    public  String initAuthDeptList(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
        return "system/dept/deptAuthList";
    }

    /**
     * 分页查询组织机构
     */
    @RequiresPermissions("system:dept:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            paramMap.put("excludeRoot", "1");
            //只显示一级部门
            if (null==paramMap.get("fid")){
                paramMap.put("deptLevel", 2);
            }
            Page<SysDeptVo> page = sysDeptService.selectVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询组织机构出错");
            logger.error("分页查询组织机构出错", e);
        }
        return pageResult;
    }

    /**
     * 新增组织机构
     */
    @RequiresPermissions("system:dept:add")
    @RequestMapping("/add")
    public  String add(){
        return "system/dept/deptAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("system:dept:add")
    @Log("创建组织机构")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysDeptVo dept){
        HandleResult handleResult = new HandleResult();
        try {
            sysDeptService.insertVO(dept);
            handleResult.success("创建组织机构成功");
        } catch (Exception e) {
            handleResult.error("创建组织机构失败");
            logger.error("创建组织机构失败", e);
        }
        return handleResult;
    }
    
    /**
     * 同步组织机构到目录
     */
//    @RequiresPermissions("")
//    @Log("同步组织机构到目录")
//    @RequestMapping("/doSycn")
//    @ResponseBody
//    public  HandleResult doSycn(@RequestParam String dcmIds){
//        HandleResult handleResult = new HandleResult();
//        try {
//            Map<String,Object> params = new HashMap<>();
//            params.put("dcmIds",dcmIds);
//
///*          params.put("publishType", Dataset.PublishType.ToAll.getKey());*/
//            String releaseResult = sysDeptService.insertIntoDir(params);
//            if(releaseResult.equals("0")){
//            	handleResult.success("同步完成,但存在已同步部门,请重新选择");
//            }else if(releaseResult.equals("1")) {
//            	handleResult.success("同步完成,但存在没有对应区域目录部门库分类部门，无法同步到目录");
//            }else if(releaseResult.equals("2")) {
//            	handleResult.success("同步完成,但存在父级未同步部门，无法同步到目录");
//            }else if(releaseResult.equals("3")) {
//            	handleResult.success("同步完成,但存在不能同步部委到目录");
//            }else if(releaseResult.equals("4")) {
//            	 handleResult.success("同步成功");
//            }
//        } catch (Exception e) {
//            handleResult.error("部门同步到目录失败");
//            logger.error("部门同步到目录失败", e);
//        }
//        return handleResult;
//    }
    /**
     * 同步主系统组织机构信息
     */
//    @RequiresPermissions("system:dept:add")
    @Log("获取主系统组织机构数据")
    @RequestMapping("/getMasterData")
    @ResponseBody
    public  HandleResult getMasterData(){
        HandleResult handleResult = new HandleResult();
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject("http://localhost:8080/dm/system/dept/provideData/?systemId=dm", String.class);
        try {
            String result =getDataFromMaster(ISysDeptService.synUrl);
            HandleResult jsb= JSONObject.parseObject(result,HandleResult.class);
            HashMap<String, Object> map= jsb.getContent();
            List<SysDept> list= JSONObject.parseArray(map.get("list").toString(),SysDept.class) ;
            if(sysDeptService.insertOrUpdate(list)){
                handleResult.success("更新成功");
            }else{
                handleResult.error("无需更新");
            }

        }catch (ErrorInfoException e){
            handleResult.error(e.getMessage());
            logger.error(e.getMessage(), e);
        } catch (Exception e) {
            handleResult.error("获取失败");
            logger.error("获取sys_dept表数据失败", e);
        }



        return handleResult;
    }


    @Log("提供主数据")
    @RequestMapping("/provideData")
    @ResponseBody
    public  HandleResult provideData(@RequestParam String systemId){
        HandleResult handleResult = new HandleResult();
        try {
            List<SysDept> result = sysDeptService.listBySystemId(systemId);
            handleResult.put("list", result);
        } catch (Exception e) {
            handleResult.error("获取sys_dept表数据失败");
            logger.error("获取sys_dept表数据失败", e);
        }
        return handleResult;
    }
    
    
    
    /**
     * 删除组织机构
     */
    @RequiresPermissions("system:dept:delete")
    @Log("删除组织机构")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try {
            if(sysDeptService.deleteDeptById(id)){
                handleResult.success("删除成功");
            }else{
                handleResult.error("删除组织机构失败");
            }
        }catch (Exception e){
            handleResult.error("删除组织机构失败：" + e.getMessage());
            logger.error("删除组织机构失败", e);
        }
        return handleResult;
    }

    /*
    * 批量删除组织机构
    * */

    @RequiresPermissions("system:dept:deleteBatch")
    @Log("批量删除组织机构")
    @RequestMapping("/deleteBatch")
    @ResponseBody
    public HandleResult deleteBatch(@RequestParam("idArr[]") List<String> ids){
        HandleResult handleResult = new HandleResult();
        try {
            String deptStr = "";
            for(String id : ids){
                //检查该部门是否可删
                String retId = sysDeptService.checkDeleteProperty(id);
                if(retId != null){
                    deptStr = deptStr + retId +",";
                }
            }
            if("".equals(deptStr)){
                sysDeptService.deleteBatchDeptByIds(ids);
                handleResult.success("批量删除组织机构成功！");
            }else{
                handleResult.error("批量删除组织机构失败，批量选择的组织机构有用户或有下级组织机构！");
            }
        } catch (Exception e) {
            handleResult.error("批量删除组织机构失败");
            logger.error("批量删除组织机构失败", e);
        }
        return handleResult;
    }

    /**
     * 分配下级组织机构
     */
    @RequiresPermissions("system:dept:allot")
    @RequestMapping("/allot")
    public  String allot(@RequestParam String id, Model model){
        model.addAttribute("id", id);
        return "system/dept/deptAllot";
    }

    /**
     * 编辑组织机构
     */
    @RequiresPermissions("system:dept:edit")
    @RequestMapping("/edit")
    public String edit(@RequestParam String id, Model model){
        model.addAttribute("id", id);
        return "system/dept/deptEdit";
    }

    /**
     * 编辑组织机构
     */
    @RequiresPermissions("system:dept:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try {
            SysDeptVo sysDeptVo = sysDeptService.selectVoById(id);
            handleResult.put("vo", sysDeptVo);
        } catch (Exception e) {
            handleResult.error("获取组织机构信息失败");
            logger.error("获取组织机构信息失败", e);
        }
        return handleResult;
    }

    /**
     * 执行编辑
     */
    @RequiresPermissions("system:dept:edit")
    @Log("编辑组织机构")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysDeptVo dept){
        HandleResult handleResult = new HandleResult();
        try {
            sysDeptService.updateVO(dept);
            handleResult.success("编辑组织机构成功");
        } catch (Exception e) {
            handleResult.error("编辑组织机构失败");
            logger.error("编辑组织机构失败", e);
        }
        return handleResult;
    }

    @RequestMapping("/checkDeptName")
    @ResponseBody
    public JSONObject checkDeptName(@RequestParam String deptName, String fname, String deptId){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = sysDeptService.checkDeptName(deptName, fname ,deptId);
        } catch (Exception e) {
            jsonObject.put("error", "组织机构名验证失败");
            logger.error("组织机构名称验资失败", e);
        }
        return jsonObject;
    }

    /**
     * 组织机构的下拉数据
     * @param paramMap
     * @return
     */
    @RequestMapping("/getDeptSelectDataList")
    @ResponseBody
    public HandleResult getDeptSelectDataList(@RequestParam Map<String, Object> paramMap) {
        HandleResult handleResult = new HandleResult();
        try {
            List<SysDeptVo> result = sysDeptService.getDeptSelectDataList(paramMap);
            handleResult.put("selectData", result);
        } catch (Exception e) {
            handleResult.error("获取组织机构列表失败");
            logger.error("获取组织机构列表失败", e);
        }
        return handleResult;
    }
    
    /**
     * 组织机构的下拉数据
     * @param paramMap
     * @return
     */
    @RequestMapping("/getDeptSelectDataListForLeadDept")
    @ResponseBody
    public HandleResult getDeptSelectDataListForLeadDept(@RequestParam Map<String, Object> paramMap) {
        HandleResult handleResult = new HandleResult();
        try {
        	String regionCode = ShiroUtils.getLoginUser().getRegionCode();
        	paramMap.put("regionCode", regionCode);
            List<SysDeptVo> result = sysDeptService.getDeptSelectDataList(paramMap);
            handleResult.put("selectData", result);
        } catch (Exception e) {
            handleResult.error("获取组织机构列表失败");
            logger.error("获取组织机构列表失败", e);
        }
        return handleResult;
    }
    
        /**
     * 组织机构的下拉数据 pacong
     * @param userId
     * @return
     */
//    @RequestMapping("/getDeptSelectDataList")
//    @ResponseBody
//    public HandleResult getDeptSelectDataList(String userId) {
//        HandleResult handleResult = new HandleResult();
//        try {
//            JSONArray result = sysDeptService.getDeptSelectDataList();
//            handleResult.put("selectData", result);
//        } catch (Exception e) {
//            handleResult.error("获取角色名称失败");
//            logger.error("获取角色名称失败", e);
//        }
//        return handleResult;
//    }
    

    /**
     * 根据登录用户获取部门树，用于快速添加
     * @return
     */
    @RequestMapping("/getDeptByPrivilege")
    @ResponseBody
    public HandleResult getDeptByPrivilege(){
        HandleResult handleResult=new HandleResult();
        String userId = ShiroUtils.getLoginUserId();
        if(StringUtils.isEmpty(userId)){
            handleResult.error("登录已失效，请刷新页面！");
        }else{
            int roleType = sysUserService.selectUserRoleType(userId);
            SysDeptVo sysDeptVo = DeptVoList(roleType);
            handleResult.put("result",sysDeptVo);
        }

        return handleResult;
    }

    private SysDeptVo DeptVoList(int roleType){
        Map paramMap = new HashMap<>();
        String loginUserRegionCode=ShiroUtils.getLoginUser().getRegionCode();
        String allRegionCode = sysRegionService.getAllSubRegionCodesWithSelf(loginUserRegionCode);
        if(!org.springframework.util.StringUtils.isEmpty(allRegionCode)){
            paramMap.put("allRegionCode",allRegionCode);
        }
        if(roleType==-1){//超级管理员
            List<SysDeptVo> sysDepts = sysDeptService.selectDeptListLikeTreeCode(paramMap);
            SysDeptVo sysDeptVo = treeMenuList(sysDepts, "root", new SysDeptVo());
            return sysDeptVo;
        }else if(roleType==0){//区域管理员
            return null;
        }else{//其他用户
            String treeCode = ShiroUtils.getLoginUser().getDeptTreeCode();
            List<String> treeCodes = sysDeptService.selectDeptByPrivilege(ShiroUtils.getLoginUserId());
            boolean b=true;
            for (String code:treeCodes) {
                if(code.equals(treeCode)){
                    b=false;
                    break;
                }
            }
            if(b){
                treeCodes.add(treeCode);
            }
            paramMap.put("treeCodes",treeCodes);
            List<SysDeptVo> sysDepts = sysDeptService.selectDeptListLikeTreeCode(paramMap);
            SysDeptVo sysDeptVo = new SysDeptVo();
            buildSysDeptVo(sysDepts,sysDeptVo);
            return sysDeptVo;
        }
    }

    private void buildSysDeptVo(List<SysDeptVo> list,SysDeptVo sysDeptVo){
        int level = 0;//需要循环的次数
        int count = 0;
        for (SysDeptVo item : list) {
            count = item.getDeptLevel();
            if (count > level) {
                level = count;
            }
        }
        List<SysDeptVo> listTree = new ArrayList<>();
        List<SysDeptVo> temList;
        for (int i = 1; i <= level; i++) {
            temList = new ArrayList<SysDeptVo>();
            for (SysDeptVo item : list) {
                if (i == item.getDeptLevel()) {
                    temList.add(item);
                }
            }
            for (SysDeptVo organizeCustom : temList) {
                fetchStruOrg(list, organizeCustom.getId(), organizeCustom);
                listTree.add(organizeCustom);
            }
            list.removeAll(temList);
        }
        sysDeptVo.setChilds(listTree);
    }
    private void fetchStruOrg(List<SysDeptVo> source,String org_code, SysDeptVo orgC){
        List<SysDeptVo> list =new ArrayList<SysDeptVo>();
        for (SysDeptVo org : source) {
            String code = org.getId();
            String fcode = org.getFid();
            if(fcode.equals(org_code)){
                list.add(org);
                fetchStruOrg(source,code,org);
            }
        }
        orgC.setChilds(list);
        source.removeAll(list);
    }

    /**
     * 获取当前登录人的所属部门信息
     * @return
     */
    @RequestMapping("/getDeptInfoForLoginUser")
    @ResponseBody
    public HandleResult getDeptInfoForLoginUser() {
        HandleResult handleResult = new HandleResult();
        try {
            SysUserVo userVo = ShiroUtils.getLoginUser();
            String deptId = userVo.getDeptId();
            if(!StringUtils.isEmpty(deptId)){
                SysDeptVo deptVo = sysDeptService.selectVoById(deptId);
                handleResult.put("vo", deptVo);
            }else{
                handleResult.error("当前登录人没有所属部门");
            }
        } catch (Exception e) {
            handleResult.error("获取当前登录人的组织机构信息失败");
            logger.error("获取当前登录人的组织机构信息失败", e);
        }
        return handleResult;
    }

    private SysDeptVo treeMenuList(List<SysDeptVo> objectList, String parentId, SysDeptVo dir) {
        List<SysDeptVo> rootDirects = new ArrayList<SysDeptVo>(1);
        if (objectList == null || objectList.isEmpty())
        {
            return dir;
        }
        if (parentId == null )
        {
            return dir;
        }
        String id = null;
        String pid = null;
        for (SysDeptVo object : objectList) {
            if (object == null) {
                logger.warn("入参对象为空！");
                continue;
            }
            id = object.getId(); // 组织编码
            pid = object.getFid(); // 父 编码
            if (parentId.equals(pid)) {
                if (rootDirects.contains(object)) {
                    continue;
                }
                rootDirects.add(object);
                dir.setChilds(rootDirects);
                treeMenuList(objectList, id, object);
            }
        }
        return dir;
    }

    /**
     * 根据选中的一级部门id，获取子部门的树形数据
     */
    @RequestMapping("/subDeptTreeData")
    @ResponseBody
    public HandleResult getSubDeptTreeData(@RequestParam Map<String , Object> paramMap){
        HandleResult handleResult = new HandleResult();
        try {
            String id = (String)paramMap.get("id");
            if (!org.springframework.util.StringUtils.isEmpty(id)){
                paramMap.put("fid", id);
            }
            List<SysDeptVo> sysDeptVoList = sysDeptService.selectVoList(paramMap);
            handleResult.put("vo",sysDeptVoList);
        } catch (Exception e) {
            handleResult.error("查询子部门的树形数据出错");
            logger.error("查询子部门的树形数据出错", e);
        }
        return handleResult;
    }

    /**
     * 根据部门的id，查询后获取资源提供方的部门或科室的详情
     */
    @RequestMapping("/belongTypeByDept")
    @ResponseBody
    public HandleResult getBelongTypeByDept(@RequestParam String deptId){
        HandleResult handleResult = new HandleResult();
        try {
            Map<String,Object> deptInfo = sysDeptService.getBelongTypeByDept(deptId);
            handleResult.put("vo",deptInfo);
        } catch (Exception e) {
            handleResult.error("查询资源提供方的部门或科室的详情出错");
            logger.error("查询资源提供方的部门或科室的详情出错", e);
        }
        return handleResult;
    }

}
