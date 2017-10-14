package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 资源目录上报信息 Po对象
 * </p>
 *
 * @author Marke
 * @since 2017-10-14
 */
@TableName("dir_data_transfer")
public class DirDataTransfer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 信息资源ID
     */
	@TableField("dcm_id")
	private String dcmId;
    /**
     * 上报人ID
     */
	@TableField("transfer_user_id")
	private String transferUserId;
    /**
     * 上报人姓名
     */
	@TableField("transfer_user_name")
	private String transferUserName;
    /**
     * 上报时间
     */
	@TableField("transfer_time")
	private Date transferTime;
    /**
     * 上报范围
     */
	@TableField("trasnfer_scope")
	private String trasnferScope;
    /**
     * 上报状态
     */
	@TableField("transfer_status")
	private String transferStatus;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDcmId() {
		return dcmId;
	}

	public void setDcmId(String dcmId) {
		this.dcmId = dcmId;
	}

	public String getTransferUserId() {
		return transferUserId;
	}

	public void setTransferUserId(String transferUserId) {
		this.transferUserId = transferUserId;
	}

	public String getTransferUserName() {
		return transferUserName;
	}

	public void setTransferUserName(String transferUserName) {
		this.transferUserName = transferUserName;
	}

	public Date getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(Date transferTime) {
		this.transferTime = transferTime;
	}

	public String getTrasnferScope() {
		return trasnferScope;
	}

	public void setTrasnferScope(String trasnferScope) {
		this.trasnferScope = trasnferScope;
	}

	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

}
