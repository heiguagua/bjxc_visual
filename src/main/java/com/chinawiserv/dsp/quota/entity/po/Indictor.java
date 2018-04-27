package com.chinawiserv.dsp.quota.entity.po;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 指标表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@TableName("im_indictor")
public class Indictor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 指标类型（原始指标、统计指标）
     */
	private Integer type;
    /**
     * 指标编码
     */
	private String code;
    /**
     * 指标名称
     */
	private String name;
    /**
     * 指标显示名称
     */
	@TableField("show_name")
	private String showName;
    /**
     * 指标分类ID
     */
	@TableField("category_id")
	private String categoryId;
    /**
     * 来源单位
     */
	@TableField("source_dept")
	private String sourceDept;
    /**
     * 计量单位
     */
	@TableField("measure_unit")
	private Integer measureUnit;
    /**
     * 更新频率
     */
	@TableField("update_frequency")
	private Integer updateFrequency;
    /**
     * 指标描述
     */
	@TableField("indictor_desc")
	private String indictorDesc;
    /**
     * 来源关系定义
     */
	@TableField("source_conf")
	private String sourceConf;
    /**
     * 指标状态
     */
	private Integer status;
    /**
     * 创建人
     */
	@TableField("create_user_id")
	private String createUserId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新人
     */
	@TableField("update_user_id")
	private String updateUserId;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSourceDept() {
		return sourceDept;
	}

	public void setSourceDept(String sourceDept) {
		this.sourceDept = sourceDept;
	}

	public Integer getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(Integer measureUnit) {
		this.measureUnit = measureUnit;
	}

	public Integer getUpdateFrequency() {
		return updateFrequency;
	}

	public void setUpdateFrequency(Integer updateFrequency) {
		this.updateFrequency = updateFrequency;
	}

	public String getIndictorDesc() {
		return indictorDesc;
	}

	public void setIndictorDesc(String indictorDesc) {
		this.indictorDesc = indictorDesc;
	}

	public String getSourceConf() {
		return sourceConf;
	}

	public void setSourceConf(String sourceConf) {
		this.sourceConf = sourceConf;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
