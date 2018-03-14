package com.chinawiserv.dsp.base.entity.po.system;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统配置类型表 Po对象
 * </p>
 *
 * @author tx123
 * @since 2018-03-13
 */
@TableName("sys_setting_category")
public class SysSettingCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类别编号
     */
    @TableId("category_code")
	private String categoryCode;
    /**
     * 类别名称
     */
	@TableField("category_name")
	private String categoryName;
    /**
     * 类别描述
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
