package com.chinawiserv.dsp.quota.entity.po;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 指标统计口径 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@TableName("im_indictor_calibre")
public class IndictorCalibre implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 口径标准类型
     */
	private String category;
    /**
     * 统计时间
     */
	@TableField("calibre_date")
	private Date calibreDate;
    /**
     * 口径编码
     */
	private String code;
    /**
     * 口径名称
     */
	private String name;
    /**
     * 上级口径
     */
	private String fid;
    /**
     * 描述
     */
	private String description;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCalibreDate() {
		return calibreDate;
	}

	public void setCalibreDate(Date calibreDate) {
		this.calibreDate = calibreDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
