package com.chinawiserv.dsp.dir.controller.apply;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataApplyVo;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataItemApplyVo;
import com.chinawiserv.dsp.dir.service.apply.IDirDataApplyService;
import com.chinawiserv.dsp.dir.service.apply.IDirDataItemApplyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/feedback/dirDataApply")
public class DirDataApplyController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDirDataApplyService service;

    @Autowired
    private IDirDataItemApplyService dirDataItemApplyService;

    @RequiresPermissions("feedback:dirDataApply")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
    	return "apply/data/dirDataApplyList";
    }

    /**
     * 分页查询共享审核消息申请表
     */
    @RequiresPermissions("feedback:dirDataApply:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        int minRoleLevl  = ShiroUtils.getLoginUser().getMinRoleLevel();
        String depId = ShiroUtils.getLoginUserDeptId();
        //非超管和区域管理员，则要做权限过滤
        if(minRoleLevl>0){
            if(!StringUtils.isEmpty(depId)){
                //查找当前用户拥有权限的目录类别的数据集，以及本部门及子部门的数据集，以及分配了其他部门权限的数据集
                paramMap.put("userId",ShiroUtils.getLoginUserId());
            }else{ //非超管和区域管理员,又没部门,直接不让看所有数据
                return null;
            }
        }
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
    @RequiresPermissions("feedback:dirDataApply:edit")
    @RequestMapping("/edit")
    public  String edit(@RequestParam String id, Model model){
		model.addAttribute("id",id);
		return "apply/data/dirDataApplyEdit";
    }

    @RequiresPermissions("feedback:dirDataApply:edit")
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
    @RequiresPermissions("feedback:dirDataApply:edit")
    @Log("审核数据权限")
    @RequestMapping(value = "/doEdit")
    @ResponseBody
    public  HandleResult doEdit(DirDataApplyVo dirDataApplyVo){
		HandleResult handleResult = new HandleResult();
		try {
            service.updateVO(dirDataApplyVo);
		} catch (Exception e) {
		    handleResult.error("审核数据权限失败");
		    logger.error("审核数据权限失败", e);
		}
		return handleResult.success("审核数据权限成功");
    }

    /**
     * 分页查询共享审核数据项申请表
     */
    @RequiresPermissions("feedback:dirDataApply:list")
    @RequestMapping("/listItem")
    @ResponseBody
    public PageResult listItem(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<DirDataItemApplyVo> page = dirDataItemApplyService.selectVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询共享审核数据项申请表出错");
            logger.error("分页查询共享审核数据项申请表出错", e);
        }
        return pageResult;
    }

}
