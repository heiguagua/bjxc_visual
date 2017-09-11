package com.chinawiserv.dsp.dir.entity.po.feedback;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据集评论记录 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@TableName("dir_data_comment")
public class DirDataComment implements Serializable {

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
     * 评论人ID
     */
	@TableField("commentator_id")
	private String commentatorId;
    /**
     * 评论时间
     */
	@TableField("comment_date")
	private Date commentDate;
    /**
     * 评论内容
     */
	@TableField("comment_content")
	private String commentContent;
    /**
     * 状态
     */
	private String satus;


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

	public String getCommentatorId() {
		return commentatorId;
	}

	public void setCommentatorId(String commentatorId) {
		this.commentatorId = commentatorId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getSatus() {
		return satus;
	}

	public void setSatus(String satus) {
		this.satus = satus;
	}

}
