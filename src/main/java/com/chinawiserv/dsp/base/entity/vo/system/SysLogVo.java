package com.chinawiserv.dsp.base.entity.vo.system;


import com.chinawiserv.dsp.base.entity.po.system.SysLog;

/**
 * Created by zhanf on 2017/5/12.1
 */
public class SysLogVo extends SysLog {

	private String userName;

	private String realName ;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}
