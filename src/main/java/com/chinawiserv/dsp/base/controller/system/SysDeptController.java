package com.chinawiserv.dsp.base.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
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

    @RequiresPermissions("system:dept:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
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
            paramMap.put("excludeRoot", true);
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
            handleResult.error("删除组织机构失败");
            logger.error("删除组织机构失败", e);
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
    public  String edit(@RequestParam String id, Model model){
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
    public JSONObject checkRoleName(@RequestParam String deptName, String deptId){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = sysDeptService.checkDeptName(deptName, deptId);
        } catch (Exception e) {
            jsonObject.put("error", "角色名验证失败");
            logger.error("角色名验证失败", e);
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
        if(roleType==-1){//超级管理员
            List<SysDeptVo> sysDepts = sysDeptService.selectDeptListLikeTreeCode(null);
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
            List<SysDeptVo> sysDepts = sysDeptService.selectDeptListLikeTreeCode(treeCodes);
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
}
