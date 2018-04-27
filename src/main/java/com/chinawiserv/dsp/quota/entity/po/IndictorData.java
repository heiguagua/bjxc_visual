package com.chinawiserv.dsp.quota.entity.po;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 指标数据表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@TableName("im_indictor_data")
public class IndictorData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 指标ID
     */
	@TableField("indictor_id")
	private String indictorId;
    /**
     * 指标统计时间
     */
	@TableField("report_date")
	private Date reportDate;
    /**
     * 指标数值
     */
	private BigDecimal val;
    /**
     * 上报人
     */
	private String uploader;
    /**
     * 上报时间
     */
	@TableField("upload_time")
	private Date uploadTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndictorId() {
		return indictorId;
	}

	public void setIndictorId(String indictorId) {
		this.indictorId = indictorId;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public BigDecimal getVal() {
		return val;
	}

	public void setVal(BigDecimal val) {
		this.val = val;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}
