package com.chinawiserv.dsp.dir.entity.vo.configure;

import com.chinawiserv.dsp.dir.entity.po.configure.DirPolicy;

/**
 * <p>
 * 政策表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public class DirPolicyVo extends DirPolicy{
	
    private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
    
}
