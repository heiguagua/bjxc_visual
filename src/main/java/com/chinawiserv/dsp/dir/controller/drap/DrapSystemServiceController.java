package com.chinawiserv.dsp.dir.controller.drap;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSystemServiceVo;
import com.chinawiserv.dsp.dir.service.drap.IDrapSystemServiceService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * <p>
 * 系统服务表(NO) 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Controller
@RequestMapping("/drapSystemService")
//todo 将所有的XXX修改为真实值
public class DrapSystemServiceController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDrapSystemServiceService service;

    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "XXX/XXX/XXXList";
    }

    /**
     * 分页查询系统服务表(NO)
     */
    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DrapSystemServiceVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询系统服务表(NO)出错");
		    logger.error("分页查询系统服务表(NO)出错", e);
		}
		return pageResult;
    }

    /**
     * 新增系统服务表(NO)
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
    @Log("创建系统服务表(NO)")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DrapSystemServiceVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建系统服务表(NO)成功");
		} catch (Exception e) {
		    handleResult.error("创建系统服务表(NO)失败");
		    logger.error("创建系统服务表(NO)失败", e);
		}
		return handleResult;
    }

    /**
     * 删除系统服务表(NO)
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除系统服务表(NO)")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除系统服务表(NO)成功");
    }

    /**
     * 编辑系统服务表(NO)
     */
    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id,Model model){
		model.addAttribute("id",id);
		return "XXX/XXX/XXXEdit";
    }

    @RequiresPermissions("XXX:XXX:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DrapSystemServiceVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取系统服务表(NO)信息失败");
		    logger.error("获取系统服务表(NO)信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑系统服务表(NO)")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DrapSystemServiceVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑系统服务表(NO)成功");
		} catch (Exception e) {
		    handleResult.error("编辑系统服务表(NO)失败");
		    logger.error("编辑系统服务表(NO)失败", e);
		}
		return handleResult;
    }
}
