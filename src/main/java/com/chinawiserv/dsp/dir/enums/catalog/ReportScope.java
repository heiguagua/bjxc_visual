package com.chinawiserv.dsp.dir.enums.catalog;

/**
 * 上报范围
 * @author Marke
 *
 */
public enum ReportScope {

	SOURCE_DIR("1","资源目录"),
	DATA_SERVICE("2","数据服务"),
	DATA_SOURCE("3","数据资源");
	 
	  /** 主键 */
    private final String key;

    /** 描述 */
    private final String desc;


    ReportScope(final String key, final String desc) {
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
