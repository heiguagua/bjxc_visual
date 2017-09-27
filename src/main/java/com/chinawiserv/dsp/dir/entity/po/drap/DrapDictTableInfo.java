package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 字典导入数据表信息 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_dict_table_info")
public class DrapDictTableInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 数据库ID
     */
	@TableField("db_id")
	private String dbId;
    /**
     * 数据表类型
     */
	@TableField("table_type")
	private String tableType;
    /**
     * 数据表编号
     */
	@TableField("table_code")
	private String tableCode;
    /**
     * 数据表英文名称
     */
	@TableField("table_name")
	private String tableName;
    /**
     * 数据表中文名称
     */
	@TableField("table_cn_name")
	private String tableCnName;
    /**
     * 数据表描述
     */
	@TableField("table_desc")
	private String tableDesc;
    /**
     * 编码序号
     */
	@TableField("code_index")
	private Integer codeIndex;
    /**
     * 表来源
     */
	@TableField("table_source_type")
	private String tableSourceType;
    /**
     * 对应实际数据表ID
     */
	@TableField("real_table_id")
	private String realTableId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDbId() {
		return dbId;
	}

	public void setDbId(String dbId) {
		this.dbId = dbId;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableCnName() {
		return tableCnName;
	}

	public void setTableCnName(String tableCnName) {
		this.tableCnName = tableCnName;
	}

	public String getTableDesc() {
		return tableDesc;
	}

	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}

	public Integer getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
	}

	public String getTableSourceType() {
		return tableSourceType;
	}

	public void setTableSourceType(String tableSourceType) {
		this.tableSourceType = tableSourceType;
	}

	public String getRealTableId() {
		return realTableId;
	}

	public void setRealTableId(String realTableId) {
		this.realTableId = realTableId;
	}

}
