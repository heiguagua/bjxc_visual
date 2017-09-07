package com.chinawiserv.dsp.base.controller.system;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 监控
 * @author Gaojun.Zhou
 * @date 2017年2月5日 下午3:38:19
 */
@Controller
@RequestMapping("/system/monitor")
public class MonitorController extends BaseController {
	
	/**
	 * 系统监控列表
	 */
	@RequiresPermissions("system:monitor")
    @RequestMapping("")
    public  String list(@RequestParam Map<String , Object> paramMap){
		setCurrentMenuInfo(paramMap);
		return "system/monitor/monitorList";
    } 
}
