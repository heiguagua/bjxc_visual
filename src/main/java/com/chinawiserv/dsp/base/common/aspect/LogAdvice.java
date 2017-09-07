package com.chinawiserv.dsp.base.common.aspect;

import com.alibaba.fastjson.JSON;
import com.chinawiserv.dsp.base.common.anno.Log;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysLog;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.service.system.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 正常业务日志记录
 * @author Administrator
 *
 */
@Aspect
@Component
public class LogAdvice {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ISysLogService sysLogService;
	
	@Pointcut("@annotation(com.chinawiserv.dsp.base.common.anno.Log)")
	public void controllerAspect() {
		
	}
	/**
	 * 当方法正常返回是执行
	 * @param joinPoint
	 */
	@AfterReturning("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();  
		Log log =  method.getAnnotation(Log.class);
		SysUser loginUser = ShiroUtils.getLoginUser();
		if(log != null){
			SysLog sysLog  =new SysLog();
			sysLog.setOperator((loginUser != null )? loginUser.getId() : "systemUserId");
			sysLog.setOperateTime(new Date());
			//todo
			sysLog.setOperateType("1");
			sysLog.setOperateDesc(log.value());
			sysLog.setOperateDetail(JSON.toJSONString(request.getParameterMap()));
			sysLogService.insert(sysLog);
			logger.debug("记录日志:"+sysLog.toString());
		}
	}
}
