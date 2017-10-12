package com.chinawiserv.dsp.base.controller.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.SystemConst;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.system.ISysRegionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 行政区域表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-13
 */
@Controller
@RequestMapping("/sysRegion")
public class SysRegionController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysRegionService service;

    @RequiresPermissions("system:region:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "system/region/regionList";
    }

    /**
     * 分页查询行政区域表
     */
    @RequiresPermissions("system:region:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<SysRegionVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询行政区域表出错");
		    logger.error("分页查询行政区域表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增行政区域表
     */
    @RequiresPermissions("system:region:add")
    @RequestMapping("/add")
    public  String add(){
		return "system/region/regionAdd";
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("system:region:add")
    @Log("创建行政区域表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysRegionVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建行政区域表成功");
		} catch (Exception e) {
		    handleResult.error("创建行政区域表失败");
		    logger.error("创建行政区域表失败", e);
		}
		return handleResult;
    }

    /**
     * 删除行政区域表
     */
    @RequiresPermissions("system:region:delete")
    @Log("删除行政区域表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除行政区域表成功");
    }

    /**
     * 编辑行政区域表
     */
    @RequiresPermissions("system:region:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "system/region/regionEdit";
    }

    @RequiresPermissions("system:region:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            SysRegionVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取行政区域表信息失败");
		    logger.error("获取行政区域表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("system:region:edit")
    @Log("编辑行政区域表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(SysRegionVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑行政区域表成功");
		} catch (Exception e) {
		    handleResult.error("编辑行政区域表失败");
		    logger.error("编辑行政区域表失败", e);
		}
		return handleResult;
    }

    @RequestMapping("/getRegionSelectDataList")
    @ResponseBody
    public  HandleResult getRegionSelectDataList(@RequestParam Map<String , Object> paramMap){
        HandleResult handleResult = new HandleResult();
        try {
            List<SysRegionVo> sysRegionVoList= service.getRegionSelectDataList(paramMap);
            handleResult.put("selectData", sysRegionVoList);
        } catch (Exception e) {
            handleResult.error("获取区域列表失败");
            logger.error("获取区域列表失败", e);
        }
        return handleResult;
    }

    @RequestMapping("/getRegionListForLoginUser")
    @ResponseBody
    public  HandleResult getRegionListForLoginUser(@RequestParam Map<String , Object> paramMap){
        HandleResult handleResult = new HandleResult();
        try {
            SysUserVo loginUser = ShiroUtils.getLoginUser();
            String regionCode = loginUser.getRegionCode();
            if(!StringUtils.isEmpty(regionCode)){
                List<SysRegionVo> sysRegionVoList= service.selectAllRegionByRegionCode(regionCode);
                SysRegionVo userRegion = service.getRegionDataByCode(regionCode);
                handleResult.put("selectData", sysRegionVoList);
                handleResult.put("userRegion", userRegion);
            }else{
                handleResult.error("当前登录用户的区域编码为空");
            }
        } catch (Exception e) {
            handleResult.error("获取登录用户的区域列表失败");
            logger.error("获取登录用户的区域列表失败", e);
        }
        return handleResult;
    }

    @RequestMapping("/changeSessionRegionValue")
    @ResponseBody
    public HandleResult changeSessionRegionValue(@RequestParam String regionCode){
        HandleResult handleResult = new HandleResult();
        try {
            ShiroUtils.setSessionAttribute(SystemConst.REGION,regionCode);
        } catch (Exception e) {
            handleResult.error("设值区域的session值失败");
            logger.error("设值区域的session值失败", e);
        }
        return handleResult;
    }

}
