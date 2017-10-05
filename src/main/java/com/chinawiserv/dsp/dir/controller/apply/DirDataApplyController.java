package com.chinawiserv.dsp.dir.controller.apply;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataApplyVo;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataitemApplyVo;
import com.chinawiserv.dsp.dir.enums.EnumTools;
import com.chinawiserv.dsp.dir.enums.apply.DataItemStatus;
import com.chinawiserv.dsp.dir.service.apply.IDirDataApplyService;
import com.chinawiserv.dsp.dir.service.apply.IDirDataitemApplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dirDataApply")
public class DirDataApplyController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirDataApplyService service;

    @RequiresPermissions("apply:dirDataApply:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "apply/data/dirDataApplyList";
    }

    /**
     * 分页查询共享审核消息申请表
     */
    @RequiresPermissions("apply:dirDataApply:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<DirDataApplyVo> page = service.selectVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询共享审核消息申请表出错");
            logger.error("分页查询共享审核消息申请表出错", e);
        }
        return pageResult;
    }

    /**
     * 编辑数据项权限申请表
     */
    @RequiresPermissions("apply:dirDataApply:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id, Model model){
		model.addAttribute("id",id);
		return "apply/data/dirDataEdit";
    }

    @RequiresPermissions("apply:dirDataApply:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
		HandleResult handleResult = new HandleResult();
		try {
            DirDataApplyVo vo = service.selectVoById(id);
		    handleResult.put("vo", vo);
		} catch (Exception e) {
		    handleResult.error("获取数据权限申请表信息失败");
		    logger.error("获取数据权限申请表信息失败", e);
		}
		return handleResult;
		}

    /**
     * 执行编辑
     */
    @RequiresPermissions("apply:dirDataApply:edit")
    @Log("编辑数据权限申请表")
    @RequestMapping(value = "/doEdit",method = RequestMethod.PUT)
    @ResponseBody
    public  HandleResult doEdit(@RequestBody DirDataApplyVo dirDataApplyVo){
		HandleResult handleResult = new HandleResult();
		try {

		} catch (Exception e) {
		    handleResult.error("编辑数据权限申请表失败");
		    logger.error("编辑数据权限申请表失败", e);
		}
		return handleResult;
    }
}
