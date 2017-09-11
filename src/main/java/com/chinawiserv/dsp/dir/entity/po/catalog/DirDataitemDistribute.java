package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据项权限分配表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@TableName("dir_dataitem_distribute")
public class DirDataitemDistribute implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 分配信息资源ID
     */
	@TableField("dcm_id")
	private String dcmId;
    /**
     * 分配数据项ID
     */
	@TableField("item_id")
	private String itemId;
    /**
     * 分配对象类型
     */
	@TableField("obj_type")
	private String objType;
    /**
     * 分配对象ID
     */
	@TableField("obj_id")
	private String objId;
    /**
     * 分配操作人
     */
	@TableField("distributor_id")
	private String distributorId;
    /**
     * 分配意见
     */
	@TableField("distribute_opinion")
	private String distributeOpinion;
    /**
     * 分配操作时间
     */
	@TableField("distribute_date")
	private Date distributeDate;


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

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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

	public String getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}

	public String getDistributeOpinion() {
		return distributeOpinion;
	}

	public void setDistributeOpinion(String distributeOpinion) {
		this.distributeOpinion = distributeOpinion;
	}

	public Date getDistributeDate() {
		return distributeDate;
	}

	public void setDistributeDate(Date distributeDate) {
		this.distributeDate = distributeDate;
	}

}
