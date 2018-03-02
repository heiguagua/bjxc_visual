package com.chinawiserv.dsp.base.entity.po.system;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		SysDictCategory that = (SysDictCategory) o;

		return new EqualsBuilder()
				.append(categoryCode, that.categoryCode)
				.append(categoryName, that.categoryName)
				.append(categoryDesc, that.categoryDesc)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(categoryCode)
				.append(categoryName)
				.append(categoryDesc)
				.toHashCode();
	}
}
