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
 * @since 2017-09-08
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
     * 信息资源ID
     */
	@TableField("dcm_id")
	private String dcmId;
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

	public String getDcmId() {
		return dcmId;
	}

	public void setDcmId(String dcmId) {
		this.dcmId = dcmId;
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

}
