package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据集对应接口服务表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-26
 */
@TableName("dir_dataset_service_map")
public class DirDatasetServiceMap implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private String id;
	/**
	 * 服务ID
	 */
	@TableField("service_id")
	private String serviceId;
	/**
	 * 服务注册对象类型
	 */
	@TableField("obj_type")
	private String objType;
	/**
	 * 服务注册对象ID
	 */
	@TableField("obj_id")
	private String objId;
	/**
	 * 有效期开始
	 */
	@TableField("valid_from")
	private Date validFrom;
	/**
	 * 有效期结束
	 */
	@TableField("valid_to")
	private Date validTo;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 服务注册时间
	 */
	@TableField("operate_time")
	private Date operateTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

}
