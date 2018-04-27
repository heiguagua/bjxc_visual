package com.chinawiserv.dsp.quota.entity.po;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 指标分类方式 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@TableName("im_indictor_classify")
public class IndictorClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 分类方式类型
     */
	private String category;
    /**
     * 分类编码
     */
	private String code;
    /**
     * 分类名称
     */
	private String name;
    /**
     * 上级分类
     */
	private String fid;
    /**
     * 有效期起
     */
	@TableField("validate_from")
	private Date validateFrom;
    /**
     * 有效期止
     */
	@TableField("validate_to")
	private Date validateTo;
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

	public Date getValidateFrom() {
		return validateFrom;
	}

	public void setValidateFrom(Date validateFrom) {
		this.validateFrom = validateFrom;
	}

	public Date getValidateTo() {
		return validateTo;
	}

	public void setValidateTo(Date validateTo) {
		this.validateTo = validateTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
