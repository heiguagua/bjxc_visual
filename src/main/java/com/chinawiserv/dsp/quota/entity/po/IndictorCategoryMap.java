package com.chinawiserv.dsp.quota.entity.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 指标分类关系表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@TableName("im_indictor_category_map")
public class IndictorCategoryMap implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 分类ID
     */
	@TableField("category_id")
	private String categoryId;
    /**
     * 指标ID
     */
	@TableField("indictor_id")
	private String indictorId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getIndictorId() {
		return indictorId;
	}

	public void setIndictorId(String indictorId) {
		this.indictorId = indictorId;
	}

}
