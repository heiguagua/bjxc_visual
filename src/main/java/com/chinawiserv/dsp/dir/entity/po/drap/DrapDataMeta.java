package com.chinawiserv.dsp.dir.entity.po.drap;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据元表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_data_meta")
public class DrapDataMeta implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 数据元类型
     */
	private String category;
    /**
     * 上级数据元编码
     */
	@TableField("fid")
	private String fid;
    /**
     * 数据元编码
     */
	@TableField("meta_code")
	private String metaCode;
    /**
     * 数据元英文名
     */
	@TableField("meta_en_name")
	private String metaEnName;
    /**
     * 数据元中文名
     */
	@TableField("meta_name")
	private String metaName;
    /**
     * 数据元定义
     */
	@TableField("meta_define")
	private String metaDefine;
    /**
     * 格式
     */
	@TableField("meta_format")
	private String metaFormat;
    /**
     * 是否显示
     */
	@TableField("is_show")
	private Integer isShow;
    /**
     * 排序号
     */
	@TableField("order_by")
	private BigDecimal orderBy;
    /**
     * 编码序号
     */
	@TableField("code_index")
	private Integer codeIndex;
    /**
     * 状态
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
    /**
     * 逻辑删除标识
     */
	@TableField("delete_flag")
	private Integer deleteFlag;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getMetaCode() {
		return metaCode;
	}

	public void setMetaCode(String metaCode) {
		this.metaCode = metaCode;
	}

	public String getMetaEnName() {
		return metaEnName;
	}

	public void setMetaEnName(String metaEnName) {
		this.metaEnName = metaEnName;
	}

	public String getMetaName() {
		return metaName;
	}

	public void setMetaName(String metaName) {
		this.metaName = metaName;
	}

	public String getMetaDefine() {
		return metaDefine;
	}

	public void setMetaDefine(String metaDefine) {
		this.metaDefine = metaDefine;
	}

	public String getMetaFormat() {
		return metaFormat;
	}

	public void setMetaFormat(String metaFormat) {
		this.metaFormat = metaFormat;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public BigDecimal getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(BigDecimal orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
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

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
