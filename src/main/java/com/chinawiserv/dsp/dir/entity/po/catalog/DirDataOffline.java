package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据下架情况 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@TableName("dir_data_offline")
public class DirDataOffline implements Serializable {

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
     * 下架人
     */
	@TableField("offline_user_id")
	private String offlineUserId;
    /**
     * 下架时间
     */
	@TableField("offline_time")
	private Date offlineTime;
    /**
     * 有效标识
     */
    @TableField("active_flag")
    private int activeFlag;


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

	public String getOfflineUserId() {
		return offlineUserId;
	}

	public void setOfflineUserId(String offlineUserId) {
		this.offlineUserId = offlineUserId;
	}

	public Date getOfflineTime() {
		return offlineTime;
	}

	public void setOfflineTime(Date offlineTime) {
		this.offlineTime = offlineTime;
	}

    public int getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(int activeFlag) {
        this.activeFlag = activeFlag;
    }
}
