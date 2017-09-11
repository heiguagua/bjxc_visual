package com.chinawiserv.dsp.dir.controller.apply;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirRegistUserVo;
import com.chinawiserv.dsp.dir.service.apply.IDirRegistUserService;
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
 * 用户注册表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Controller
@RequestMapping("/dirRegistUser")
//todo 将所有的XXX修改为真实值
public class DirRegistUserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirRegistUserService service;

    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "XXX/XXX/XXXList";
    }

    /**
     * 分页查询用户注册表
     */
    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DirRegistUserVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询用户注册表出错");
		    logger.error("分页查询用户注册表出错", e);
		}
		return pageResult;
    }

    /**
     * 新增用户注册表
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
    @Log("创建用户注册表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DirRegistUserVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建用户注册表成功");
		} catch (Exception e) {
		    handleResult.error("创建用户注册表失败");
		    logger.error("创建用户注册表失败", e);
		}
		return handleResult;
    }

    /**
     * 删除用户注册表
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除用户注册表")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除用户注册表成功");
    }

    /**
     * 编辑用户注册表
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
            DirRegistUserVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取用户注册表信息失败");
		    logger.error("获取用户注册表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑用户注册表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirRegistUserVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑用户注册表成功");
		} catch (Exception e) {
		    handleResult.error("编辑用户注册表失败");
		    logger.error("编辑用户注册表失败", e);
		}
		return handleResult;
    }
}
