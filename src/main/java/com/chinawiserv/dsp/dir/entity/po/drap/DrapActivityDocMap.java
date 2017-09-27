package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 业务活动关联资料表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_activity_doc_map")
public class DrapActivityDocMap implements Serializable {

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
     * 业务资料ID
     */
	@TableField("doc_id")
	private String docId;
    /**
     * 资料类型（输入/输出）
     */
	@TableField("doc_io_type")
	private String docIoType;


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

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getDocIoType() {
		return docIoType;
	}

	public void setDocIoType(String docIoType) {
		this.docIoType = docIoType;
	}

}
