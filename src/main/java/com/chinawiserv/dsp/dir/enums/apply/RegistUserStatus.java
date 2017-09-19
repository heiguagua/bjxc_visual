package com.chinawiserv.dsp.dir.enums.apply;

/**
 * 用户状态枚举
 * 
 * @author zengpzh
 * 
 * Dec 2, 2009 2:13:46 PM
 */
public enum RegistUserStatus {
	
	DATA_0("0", "申请中"),
	
	DATA_1("1", "已通过"),

	DATA_2("2", "已拒绝");

	private String dbValue;

	private String chValue;

	private RegistUserStatus(String dbValue, String chValue) {
		this.dbValue = dbValue;
		this.chValue = chValue;
	}

	public String getDbValue() {
		return dbValue;
	}

	public String getChValue() {
		return chValue;
	}
}
