package com.chinawiserv.dsp.base.entity.po.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统字典表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
@TableName("sys_dict_category")
public class SysDictCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * 类型编码
	 */
	@TableField("category_code")
	private String categoryCode;
	/**
	 * 类型名称
	 */
	@TableField("category_name")
	private String categoryName;
	/**
	 * 描述
	 */
	@TableField("category_desc")
	private String categoryDesc;


	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
}
