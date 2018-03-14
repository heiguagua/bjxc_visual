package com.chinawiserv.dsp.base.controller.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.SystemConst;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.po.system.SysSetting;
import com.chinawiserv.dsp.base.entity.po.system.SysSettingCategory;
import com.chinawiserv.dsp.base.entity.vo.system.SysSettingCategoryVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysSettingVo;
import com.chinawiserv.dsp.base.service.system.ISysSettingCategoryService;
import com.chinawiserv.dsp.base.service.system.ISysSettingService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;


/**
 * <p>
 * 系统设置表 前端控制器1
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/setting")
public class SysSettingController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysSettingService sysSettingService;

    @Autowired
    private ISysSettingCategoryService sysSettingCategoryService;

    @RequiresPermissions("system:setting:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
        return "system/setting/settingList";
    }

    /**
     * 查询系统设置
     */
    @RequiresPermissions("system:setting:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
        final PageResult pageResult = new PageResult();
        try {
            final Page<SysSettingVo> pageData = sysSettingService.selectVoPage(paramMap);
            pageResult.setPage(pageData);
        }catch (Exception e){
            pageResult.error("分页查询系统配置出错");
            logger.error("分页查询系统配置出错", e);
        }
        return pageResult;
    }
    /**
     * 查询系统设置类型列表
     */
    @RequiresPermissions("system:setting:list")
    @RequestMapping("/categoryList")
    @ResponseBody
    public PageResult categoryList(@RequestParam Map<String , Object> paramMap){
        final PageResult pageResult = new PageResult();
        try {
            Page<SysSettingCategoryVo> pageData = sysSettingCategoryService.selectVoPage(paramMap);
            pageResult.setPage(pageData);
        }catch (Exception e){
            pageResult.error("分页查询系统配置出错");
            logger.error("分页查询系统配置出错", e);
        }
        return pageResult;
    }
    /**
     * 获取当前系统标识
     */
    @RequiresPermissions("system:setting:list")
    @RequestMapping("/getSystemId")
    @ResponseBody
    public HandleResult getSystemId(){
        HandleResult handleResult = new HandleResult();
        try {
            String systemId = sysSettingService.findValueByCode(SystemConst.SYS_INTEGRATE_NO);
            handleResult.put("systemId", systemId);
        }catch (Exception e){
            logger.error("查询系统Id出错", e);
        }
        return handleResult;
    }

    /**
     * 新增组织机构
     */
//    @RequiresPermissions("addSetting")
    @RequestMapping("/add")
    public  String add(){
        return "system/setting/settingAdd";
    }

    /**
     * 执行新增
     */
//    @RequiresPermissions("addSetting")
    @Log("创建系统配置")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysSettingVo sysSettingVo){
        try {
            sysSettingService.insertVO(sysSettingVo);
        }catch (Exception e){
            logger.error("创建系统配置出错", e);
        }
        return new HandleResult().success("创建系统配置成功");
    }

    /**
     * 编辑系统配置
     */
    @RequiresPermissions("system:setting:edit")
    @RequestMapping("/edit")
    public String edit(@RequestParam String id,Model model){
        model.addAttribute("settingId",id);
        return "system/setting/settingEdit";
    }
    /**
     * 编辑系统配置类型
     */
    @RequiresPermissions("system:setting:edit")
    @RequestMapping("/categoryEdit")
    public String categoryEdit(@RequestParam String id,Model model){
        model.addAttribute("categoryCode",id);
        return "system/setting/categorySettingEdit";
    }

    /**
     * 编辑系统配置
     */
    @RequiresPermissions("system:setting:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public HandleResult editLoad(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try {
            SysSetting setting = sysSettingService.selectById(id);
            handleResult.put("vo", setting);
        }catch (Exception e){
            logger.error("加载系统配置出错", e);
        }
        return handleResult;
    }
    /**
     * 编辑系统配置类型
     */
    @RequiresPermissions("system:setting:edit")
    @RequestMapping("/categoryEditLoad")
    @ResponseBody
    public HandleResult categoryEditLoad(@RequestParam String categoryCode){
        HandleResult handleResult = new HandleResult();
        try {
            SysSettingCategoryVo setting = sysSettingCategoryService.selectById(categoryCode);
            handleResult.put("vo", setting);
        }catch (Exception e){
            logger.error("加载系统配置出错", e);
        }
        return handleResult;
    }

    @RequiresPermissions("system:setting:edit")
    @Log("更新系统设置")
    @RequestMapping("/doEdit")
    @ResponseBody
    public HandleResult doSetting(SysSettingVo sysSettingVo){
        try {
            sysSettingVo.setUpdateUserId(ShiroUtils.getLoginUserId());
            sysSettingVo.setUpdateTime(new Date());
            sysSettingService.updateById(sysSettingVo);
        }catch (Exception e){
            logger.error("编辑系统配置出错", e);
        }
        return new HandleResult().success("编辑系统配置成功");
    }
    @RequiresPermissions("system:setting:edit")
    @Log("更新系统设置类型")
    @RequestMapping("/doCategoryEdit")
    @ResponseBody
    public HandleResult doCategoryEdit(SysSettingCategoryVo vo){
        try {
            sysSettingCategoryService.updateById(vo);
        }catch (Exception e){
            logger.error("编辑系统配置出错", e);
        }
        return new HandleResult().success("编辑系统配置成功");
    }

    /**
     * 删除系统设置
     */
//    @RequiresPermissions("deleteSetting")
    @Log("删除系统设置")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
        try {
            sysSettingService.deleteById(id);
        }catch (Exception e){
            logger.error("删除系统配置出错", e);
        }
        return new HandleResult().success("删除成功");
    }
}
