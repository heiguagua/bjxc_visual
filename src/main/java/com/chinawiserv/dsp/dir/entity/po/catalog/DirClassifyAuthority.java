package com.chinawiserv.dsp.dir.entity.po.catalog;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 目录类别控制权限表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@TableName("dir_classify_authority")
public class DirClassifyAuthority implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 权限对象类型
     */
	@TableField("auth_obj_type")
	private String authObjType;
    /**
     * 权限对象ID
     */
	@TableField("auth_obj_id")
	private String authObjId;
    /**
     * 目录类别ID
     */
	@TableField("classify_id")
	private String classifyId;
    /**
     * 权限说明
     */
	@TableField("auth_detail")
	private String authDetail;

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

	public String getAuthObjType() {
		return authObjType;
	}

	public void setAuthObjType(String authObjType) {
		this.authObjType = authObjType;
	}

	public String getAuthObjId() {
		return authObjId;
	}

	public void setAuthObjId(String authObjId) {
		this.authObjId = authObjId;
	}

	public String getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}

	public String getAuthDetail() {
		return authDetail;
	}

	public void setAuthDetail(String authDetail) {
		this.authDetail = authDetail;
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
