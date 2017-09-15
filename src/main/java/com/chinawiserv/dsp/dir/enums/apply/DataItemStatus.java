package com.chinawiserv.dsp.dir.enums.apply;

/**
 * 用户状态枚举
 * 
 * @author zengpzh
 * 
 * Dec 2, 2009 2:13:46 PM
 */
public enum DataItemStatus {

	DATA_0("0", "待审核"),

	DATA_1("1", "同意"),

	DATA_2("2", "拒绝");


	private String dbValue;

	private String chValue;

	private DataItemStatus(String dbValue, String chValue) {
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
