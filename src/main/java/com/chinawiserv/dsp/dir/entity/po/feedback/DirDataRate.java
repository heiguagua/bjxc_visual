package com.chinawiserv.dsp.dir.entity.po.feedback;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据集评分记录 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@TableName("dir_data_rate")
public class DirDataRate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 数据集目录类别关系ID
     */
	@TableField("dcm_id")
	private String dcmId;
    /**
     * 评分人ID
     */
	@TableField("rater_id")
	private String raterId;
    /**
     * 评分人分数
     */
	@TableField("rate_score")
	private BigDecimal rateScore;
    /**
     * 评分时间
     */
	@TableField("rate_date")
	private Date rateDate;


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

	public String getRaterId() {
		return raterId;
	}

	public void setRaterId(String raterId) {
		this.raterId = raterId;
	}

	public BigDecimal getRateScore() {
		return rateScore;
	}

	public void setRateScore(BigDecimal rateScore) {
		this.rateScore = rateScore;
	}

	public Date getRateDate() {
		return rateDate;
	}

	public void setRateDate(Date rateDate) {
		this.rateDate = rateDate;
	}

}
