package com.chinawiserv.dsp.base.entity.po.system;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 行政区划版本记录表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-13
 */
@TableName("sys_region_version")
public class SysRegionVersion implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId("ID")
	private String id;
    /**
     * 版本号
     */
	@TableField("version_code")
	private String versionCode;
    /**
     * 版本来源
     */
	private String source;
    /**
     * 版本发布时间
     */
	@TableField("publish_date")
	private String publishDate;
    /**
     * 版本来源适应说明
     */
	@TableField("apply_desc")
	private String applyDesc;
    /**
     * 版本记录描述
     */
	@TableField("version_info")
	private String versionInfo;
    /**
     * 版本有效期开始
     */
	@TableField("validate_from")
	private Date validateFrom;
    /**
     * 版本有效期结束
     */
	@TableField("validate_to")
	private Date validateTo;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getApplyDesc() {
		return applyDesc;
	}

	public void setApplyDesc(String applyDesc) {
		this.applyDesc = applyDesc;
	}

	public String getVersionInfo() {
		return versionInfo;
	}

	public void setVersionInfo(String versionInfo) {
		this.versionInfo = versionInfo;
	}

	public Date getValidateFrom() {
		return validateFrom;
	}

	public void setValidateFrom(Date validateFrom) {
		this.validateFrom = validateFrom;
	}

	public Date getValidateTo() {
		return validateTo;
	}

	public void setValidateTo(Date validateTo) {
		this.validateTo = validateTo;
	}

}
