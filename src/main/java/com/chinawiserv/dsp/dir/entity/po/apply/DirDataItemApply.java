package com.chinawiserv.dsp.dir.entity.po.apply;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("dir_data_item_apply")
public class DirDataItemApply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;

	private String dataApplyId;

	private String itemId;

	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDataApplyId() {
		return dataApplyId;
	}

	public void setDataApplyId(String dataApplyId) {
		this.dataApplyId = dataApplyId;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
