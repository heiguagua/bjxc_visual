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
 * 数据权限申请表 前端控制器
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
@Controller
@RequestMapping("/system/deptAuthorityApply")
public class SysDeptAuthorityApplyController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysDeptAuthorityApplyService service;

    @RequiresPermissions("system:deptAuthorityApply:list")
    @RequestMapping("")
    public String init(@RequestParam Map<String, Object> paramMap) {
        setCurrentMenuInfo(paramMap);
        return "system/deptAuthorityApply/deptAuthorityApplyList";
    }

    /**
     * 分页查询数据权限申请表
     */
    @RequiresPermissions("system:deptAuthorityApply:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String, Object> paramMap) {
        PageResult pageResult = new PageResult();
        try {
            Page<SysDeptAuthorityApplyVo> page = service.selectVoPage(paramMap);
            pageResult.setPage(page);
        } catch (Exception e) {
            pageResult.error("分页查询数据权限申请表出错");
            logger.error("分页查询数据权限申请表出错", e);
        }
        return pageResult;
    }

    /**
     * 新增数据权限申请表
     */
    @RequiresPermissions("system:deptAuthorityApply:add")
    @RequestMapping("/add")
    public String add() {return "system/deptAuthorityApply/deptAuthorityApplyAdd";}

    /**
     * 执行新增
     */
    @RequiresPermissions("system:deptAuthorityApply:add")
    @Log("创建数据权限申请表")
    @RequestMapping("/doAdd")
    @ResponseBody
    public HandleResult doAdd(SysDeptAuthorityApplyVo entity) {
        HandleResult handleResult = new HandleResult();
        try {
            service.insertVO(entity);
            handleResult.success("创建数据权限申请表成功");
        } catch (Exception e) {
            handleResult.error("创建数据权限申请表失败：" + e.getMessage());
            logger.error("创建数据权限申请表失败", e);
        }
        return handleResult;
    }
}
