package com.chinawiserv.dsp.quota.entity.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 指标数据来源表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@TableName("im_indictor_data_source")
public class IndictorDataSource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 指标数据表ID
     */
	@TableField("indictor_data_id")
	private String indictorDataId;
    /**
     * 来源导入历史表ID
     */
	@TableField("import_history_id")
	private String importHistoryId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndictorDataId() {
		return indictorDataId;
	}

	public void setIndictorDataId(String indictorDataId) {
		this.indictorDataId = indictorDataId;
	}

	public String getImportHistoryId() {
		return importHistoryId;
	}

	public void setImportHistoryId(String importHistoryId) {
		this.importHistoryId = importHistoryId;
	}

}
