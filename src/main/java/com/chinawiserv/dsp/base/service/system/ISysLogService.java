package com.chinawiserv.dsp.base.service.system;


import com.chinawiserv.dsp.base.entity.po.system.SysLog;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysLogVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 日志表 服务类1
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysLogService extends ICommonService<SysLog, SysLogVo> {

	/**
	 * 记录日志
	 * @param title
	 * @param sysUser
	 * @param url
	 * @param parms
	 */
	void insertLog(String title, SysUser sysUser, String url, String parms);

}
