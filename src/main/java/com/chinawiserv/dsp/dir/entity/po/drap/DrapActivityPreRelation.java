package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 业务活动前置关系表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_activity_pre_relation")
public class DrapActivityPreRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 业务活动ID
     */
	@TableField("activity_id")
	private String activityId;
    /**
     * 前置活动节点ID
     */
	@TableField("pre_activity_id")
	private String preActivityId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getPreActivityId() {
		return preActivityId;
	}

	public void setPreActivityId(String preActivityId) {
		this.preActivityId = preActivityId;
	}

}
