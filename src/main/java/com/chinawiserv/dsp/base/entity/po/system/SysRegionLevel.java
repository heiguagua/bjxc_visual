package com.chinawiserv.dsp.base.entity.po.system;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 行政级别表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-13
 */
@TableName("sys_region_level")
public class SysRegionLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 行政级别代码
     */
    @TableId("region_level_code")
	private String regionLevelCode;
    /**
     * 行政级别名称
     */
	@TableField("region_level_name")
	private String regionLevelName;
    /**
     * 行政级别
     */
	@TableField("region_level_value")
	private Integer regionLevelValue;


	public String getRegionLevelCode() {
		return regionLevelCode;
	}

	public void setRegionLevelCode(String regionLevelCode) {
		this.regionLevelCode = regionLevelCode;
	}

	public String getRegionLevelName() {
		return regionLevelName;
	}

	public void setRegionLevelName(String regionLevelName) {
		this.regionLevelName = regionLevelName;
	}

	public Integer getRegionLevelValue() {
		return regionLevelValue;
	}

	public void setRegionLevelValue(Integer regionLevelValue) {
		this.regionLevelValue = regionLevelValue;
	}

}
