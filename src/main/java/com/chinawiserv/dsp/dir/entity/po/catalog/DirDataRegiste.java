package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据注册情况表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
@TableName("dir_data_registe")
public class DirDataRegiste implements Serializable {

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
     * 注册人
     */
	@TableField("register_id")
	private String registerId;
    /**
     * 注册时间
     */
	@TableField("registe_date")
	private Date registeDate;
    /**
     * 注册意见
     */
	@TableField("registe_opinion")
	private String registeOpinion;


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

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public Date getRegisteDate() {
		return registeDate;
	}

	public void setRegisteDate(Date registeDate) {
		this.registeDate = registeDate;
	}

	public String getRegisteOpinion() {
		return registeOpinion;
	}

	public void setRegisteOpinion(String registeOpinion) {
		this.registeOpinion = registeOpinion;
	}

}
