package com.chinawiserv.dsp.dir.enums.catalog;

/**
 * 上报状态
 * @author Marke
 *
 */
public enum ReportStatus {

	REPORT_SUCCESS("1","上报成功"),
	REPORT_FAIL("2","上报失败"),
	REPORT_EXCEPTION("3","上报异常");
	  /** 主键 */
    private final String key;

    /** 描述 */
    private final String desc;


    ReportStatus(final String key, final String desc) {
        this.key = key;
        this.desc = desc;
    }

    public String getKey() {
        return this.key;
    }

    public String getDesc() {
        return this.desc;
    }
}
