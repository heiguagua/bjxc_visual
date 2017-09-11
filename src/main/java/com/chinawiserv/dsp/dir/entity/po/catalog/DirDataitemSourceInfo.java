package com.chinawiserv.dsp.dir.entity.po.catalog;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据项来源信息表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@TableName("dir_dataitem_source_info")
public class DirDataitemSourceInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 数据项ID
     */
	@TableField("item_id")
	private String itemId;
    /**
     * 来源对象类型
     */
	@TableField("source_obj_type")
	private String sourceObjType;
    /**
     * 来源对象ID
     */
	@TableField("source_obj_id")
	private String sourceObjId;
    /**
     * 来源数据项ID
     */
	@TableField("source__item_id")
	private String sourceItemId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSourceObjType() {
		return sourceObjType;
	}

	public void setSourceObjType(String sourceObjType) {
		this.sourceObjType = sourceObjType;
	}

	public String getSourceObjId() {
		return sourceObjId;
	}

	public void setSourceObjId(String sourceObjId) {
		this.sourceObjId = sourceObjId;
	}

	public String getSourceItemId() {
		return sourceItemId;
	}

	public void setSourceItemId(String sourceItemId) {
		this.sourceItemId = sourceItemId;
	}

}
