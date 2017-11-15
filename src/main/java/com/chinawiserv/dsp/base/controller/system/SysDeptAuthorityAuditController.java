package com.chinawiserv.dsp.base.controller.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityApplyVo;
import com.chinawiserv.dsp.base.service.system.ISysDeptAuthorityApplyService;
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
 * 数据权限审批 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
@Controller
@RequestMapping("/system/deptAuthorityAudit")
public class SysDeptAuthorityAuditController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysDeptAuthorityApplyService sysDeptAuthorityApplyService;

    @RequiresPermissions("system:deptAuthorityAudit:list")
    @RequestMapping("")
    public String init(@RequestParam Map<String, Object> paramMap) {
        setCurrentMenuInfo(paramMap);
        return "system/deptAuthorityAudit/deptAuthorityAuditList";
    }

    /**
     * 分页查询数据权限申请表
     */
    @RequiresPermissions("system:deptAuthorityAudit:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String, Object> paramMap) {
        PageResult pageResult = new PageResult();
        try {
            Page<SysDeptAuthorityApplyVo> page = sysDeptAuthorityApplyService.selectVoPage4Audit(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询数据权限申请表出错");
            logger.error("分页查询数据权限申请表出错", e);
        }
        return pageResult;
    }

    /**
     * 审批数据权限申请表
     */
    @RequiresPermissions("system:deptAuthorityAudit:edit")
    @RequestMapping("/edit")
    public String edit(@RequestParam String id, Model model) {
        model.addAttribute("id", id);
        return "system/deptAuthorityAudit/deptAuthorityAuditEdit";
    }

    /**
     * 加载申请
     */
    @RequiresPermissions("system:deptAuthorityAudit:edit")
    @RequestMapping("/editLoad")
    @ResponseBody
    public  HandleResult editLoad(@RequestParam String id){
        HandleResult handleResult = new HandleResult();
        try {
            SysDeptAuthorityApplyVo vo = sysDeptAuthorityApplyService.selectVoById(id);
            handleResult.put("vo", vo);
        } catch (Exception e) {
            handleResult.error("获取组织机构信息失败");
            logger.error("获取组织机构信息失败", e);
        }
        return handleResult;
    }

    /**
     * 执行新增
     */
    @RequiresPermissions("system:deptAuthorityAudit:edit")
    @Log("审批数据权限申请表")
    @RequestMapping("/doEdit")
    @ResponseBody
    public HandleResult doEdit(SysDeptAuthorityApplyVo entity) {
        HandleResult handleResult = new HandleResult();
        try {
            sysDeptAuthorityApplyService.updateVO(entity);
            handleResult.success("审批数据权限成功");
        } catch (Exception e) {
            handleResult.error("审批数据权限失败");
            logger.error("审批数据权限审批失败", e);
        }
        return handleResult;
    }
}
