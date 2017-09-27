package com.chinawiserv.dsp.dir.controller.drap;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSxTableFeedbackVo;
import com.chinawiserv.dsp.dir.service.drap.IDrapSxTableFeedbackService;
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
 * 数据表反馈记录(淞幸) 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Controller
@RequestMapping("/drapSxTableFeedback")
//todo 将所有的XXX修改为真实值
public class DrapSxTableFeedbackController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDrapSxTableFeedbackService service;

    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "XXX/XXX/XXXList";
    }

    /**
     * 分页查询数据表反馈记录(淞幸)
     */
    @RequiresPermissions("XXX:XXX:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
		PageResult pageResult = new PageResult();
		try {
		    Page<DrapSxTableFeedbackVo> page = service.selectVoPage(paramMap);
		    pageResult.setPage(page);
		} catch (Exception e) {
		    pageResult.error("分页查询数据表反馈记录(淞幸)出错");
		    logger.error("分页查询数据表反馈记录(淞幸)出错", e);
		}
		return pageResult;
    }

    /**
     * 新增数据表反馈记录(淞幸)
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
    @Log("创建数据表反馈记录(淞幸)")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(DrapSxTableFeedbackVo entity){
		HandleResult handleResult = new HandleResult();
		try {
		    service.insertVO(entity);
		    handleResult.success("创建数据表反馈记录(淞幸)成功");
		} catch (Exception e) {
		    handleResult.error("创建数据表反馈记录(淞幸)失败");
		    logger.error("创建数据表反馈记录(淞幸)失败", e);
		}
		return handleResult;
    }

    /**
     * 删除数据表反馈记录(淞幸)
     */
    @RequiresPermissions("XXX:XXX:delete")
    @Log("删除数据表反馈记录(淞幸)")
    @RequestMapping("/delete")
    @ResponseBody
    public HandleResult delete(@RequestParam String id){
		//todo 逻辑删除
    	//service.deleteById(id);
		return new HandleResult().success("删除数据表反馈记录(淞幸)成功");
    }

    /**
     * 编辑数据表反馈记录(淞幸)
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
            DrapSxTableFeedbackVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取数据表反馈记录(淞幸)信息失败");
		    logger.error("获取数据表反馈记录(淞幸)信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("XXX:XXX:edit")
    @Log("编辑数据表反馈记录(淞幸)")
    @RequestMapping("/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DrapSxTableFeedbackVo entity,Model model){
		HandleResult handleResult = new HandleResult();
		try {
		    service.updateVO(entity);
		    handleResult.success("编辑数据表反馈记录(淞幸)成功");
		} catch (Exception e) {
		    handleResult.error("编辑数据表反馈记录(淞幸)失败");
		    logger.error("编辑数据表反馈记录(淞幸)失败", e);
		}
		return handleResult;
    }
}
