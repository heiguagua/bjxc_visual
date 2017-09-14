package com.chinawiserv.dsp.base.entity.po.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 行政区域表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-13
 */
@TableName("sys_region")
public class SysRegion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private String id;
    /**
     * 行政区划编号
     */
	@TableField("region_code")
	private String regionCode;
    /**
     * 行政区划名称
     */
	@TableField("region_name")
	private String regionName;
    /**
     * 上级行政区划编号
     */
	private String fcode;
    /**
     * 上级行政区划名称
     */
	private String fname;
    /**
     * 首字母
     */
	@TableField("first_charact")
	private String firstCharact;
    /**
     * 行政区划级别代码
     */
	@TableField("region_level_code")
	private String regionLevelCode;
    /**
     * 状态
     */
	private String status;
    /**
     * 版本信息表ID
     */
	@TableField("version_id")
	private String versionId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getFcode() {
		return fcode;
	}

	public void setFcode(String fcode) {
		this.fcode = fcode;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFirstCharact() {
		return firstCharact;
	}

	public void setFirstCharact(String firstCharact) {
		this.firstCharact = firstCharact;
	}

	public String getRegionLevelCode() {
		return regionLevelCode;
	}

	public void setRegionLevelCode(String regionLevelCode) {
		this.regionLevelCode = regionLevelCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

}
