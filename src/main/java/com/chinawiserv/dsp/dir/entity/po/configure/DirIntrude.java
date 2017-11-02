package com.chinawiserv.dsp.dir.entity.po.configure;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 政策表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@TableName("dir_portal_content_settting")
public class DirIntrude implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
	private String id;
    /**
     * 所属类别
     */
	@TableField("category")
	private String category;
    /**
     * 发布内容
     */
	private String content;
    /**
     * 发布人
     */
	private String publisher;
    /**
     * 发布时间
     */
	@TableField("publish_date")
	private Date publishDate;
	
	private int deleteFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
