package com.chinawiserv.dsp.base.controller.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.base.entity.po.common.response.PageResult;
import com.chinawiserv.dsp.base.entity.po.system.SysLog;
import com.chinawiserv.dsp.base.entity.vo.system.SysLogVo;
import com.chinawiserv.dsp.base.service.system.ISysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Controller
@RequestMapping("/system/log")
public class SysLogController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ISysLogService sysLogService;


    @RequiresPermissions("system:log:list")
    @RequestMapping("")
    public  String init(@RequestParam Map<String , Object> paramMap){
        setCurrentMenuInfo(paramMap);
        return "system/log/logList";
    }

    /**
     * 分页查询日志
     */
    @RequiresPermissions("system:log:list")
    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam Map<String , Object> paramMap){
        PageResult pageResult = new PageResult();
        try {
            Page<SysLogVo> sysLogVoPage = sysLogService.selectVoPage(paramMap);
            pageResult.setPage(sysLogVoPage);
        } catch (Exception e) {
            e.printStackTrace();
            pageResult.error("分页查询日志出错");
        }

        return pageResult;
    }

    /**
     * 获取参数
     */
    @RequestMapping("/params")
    @ResponseBody
    public String params(@RequestParam String id){
        SysLog sysLog = sysLogService.selectById(id);
        return sysLog.getOperateDetail();
    }
}
