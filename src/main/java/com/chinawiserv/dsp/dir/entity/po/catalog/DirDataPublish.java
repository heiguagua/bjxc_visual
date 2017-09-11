package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据发布情况 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@TableName("dir_data_publish")
public class DirDataPublish implements Serializable {

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
     * 是否发布到互联网
     */
	@TableField("publish_to_net")
	private Integer publishToNet;
    /**
     * 是否发布到电子政务外网
     */
	@TableField("publish_to_dzzw")
	private Integer publishToDzzw;
    /**
     * 发布人
     */
	@TableField("publisher_id")
	private String publisherId;
    /**
     * 发布时间
     */
	@TableField("publish_date")
	private Date publishDate;


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

	public Integer getPublishToNet() {
		return publishToNet;
	}

	public void setPublishToNet(Integer publishToNet) {
		this.publishToNet = publishToNet;
	}

	public Integer getPublishToDzzw() {
		return publishToDzzw;
	}

	public void setPublishToDzzw(Integer publishToDzzw) {
		this.publishToDzzw = publishToDzzw;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}
