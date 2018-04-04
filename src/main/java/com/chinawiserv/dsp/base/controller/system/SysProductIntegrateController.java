package com.chinawiserv.dsp.base.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysProductIntegrate;
import com.chinawiserv.dsp.base.entity.vo.system.SysIconVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysProductIntegrateVo;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.base.service.system.ISysProductIntegrateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品集成表 前端控制器
 * </p>
 *
 * @author tx
 * @since 2017-11-07
 */
@Controller
@RequestMapping("/system/productIntegrate")
public class SysProductIntegrateController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysProductIntegrateService service;

    @RequiresPermissions("system:productIntegrate:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap,Model model){
		setCurrentMenuInfo(paramMap);
        model.addAttribute("master",isMaster());
    	return "system/productIntegrate/productIntegrateList";
    }

    /**
     * 分页查询产品集成表,
     *
     * 普通用户不具有当前页面访问功能，但是需要获取单点登录tab，故注释掉权限限制
     */
//    @RequiresPermissions("system:productIntegrate:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<SysProductIntegrateVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询产品集成表出错");
		    logger.error("分页查询产品集成表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增产品集成表
     */
    @RequiresPermissions("XXX:XXX:add")
    @RequestMapping("/add")
    public  String add(){
		return "XXX/XXX/XXXAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("XXX:XXX:add")
    @Log("创建产品集成表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysProductIntegrateVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建产品集成表成功");
		} catch (Exception e) {
		    handleResult.error("创建产品集成表失败");
		    logger.error("创建产品集成表失败", e);
		}
		return handleResult;
    }

    /**
     * 删除产品集成表
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除产品集成表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除产品集成表成功");
    }

    /**
     * 编辑产品集成表
     */
    @RequiresPermissions("system:productIntegrate:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "system/productIntegrate/productIntegrateEdit";
    }

    @RequiresPermissions("system:productIntegrate:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            SysProductIntegrateVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取产品集成表信息失败");
		    logger.error("获取产品集成表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("system:productIntegrate:edit")
    @Log("编辑产品集成表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysProductIntegrateVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑产品集成表成功");
		} catch (Exception e) {
		    handleResult.error("编辑产品集成表失败");
		    logger.error("编辑产品集成表失败", e);
		}
		return handleResult;
    }

    /**
     * 获取菜单图标下拉框内容(封装成json数组的格式)
     */
    @RequiresPermissions("system:productIntegrate:list")
    @RequestMapping("/iconSelect")
    @ResponseBody
    public HandleResult getIconSelectData(@RequestParam Map<String, Object> paramMap){
        HandleResult result = new HandleResult();
        List<SysIconVo> selectDataList;
        try {
            selectDataList = service.selectIcon();
            result.put("selectData",selectDataList);
        } catch (Exception e) {
            e.printStackTrace();
            result.error("获取菜单图标的信息列表出错");
        }
        return result;
    }

    /**
     * 推送系统集成表到指定系统
     */
//    @RequiresPermissions("system:dept:add")
    @Log("推送操作")
    @RequestMapping("/send")
    @ResponseBody
    public  HandleResult send(@RequestParam String id){
        HandleResult handleResult = new HandleResult();

        try {
            SysProductIntegrateVo sysProductIntegrateVo = service.selectVoById(id);
            if(sysProductIntegrateVo.getMasterFlag().equals(1)){
                handleResult.error("主系统无需同步");
                return handleResult;
            }
            List<SysProductIntegrate> selectList = service.selectList(new EntityWrapper<SysProductIntegrate>());
            ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(sysProductIntegrateVo.getRootPath() +ISysProductIntegrateService.synUrl, selectList, String.class);
            handleResult.success(responseEntity.getBody());
        } catch (Exception e) {
            handleResult.error("获取失败");
            logger.error("获取sys_dept表数据失败", e);
        }
        return handleResult;
    }

    @Log("收到推送")
    @RequestMapping("/postData")
    @ResponseBody
    public  String postData(@RequestBody List<SysProductIntegrate> list){
        try {
            service.delete(new EntityWrapper<SysProductIntegrate>());
            service.insertBatch(list);
        } catch (Exception e) {
            logger.error("更新数据失败", e);
            return "更新数据失败";
        }
        return "更新数据成功";
    }
}
