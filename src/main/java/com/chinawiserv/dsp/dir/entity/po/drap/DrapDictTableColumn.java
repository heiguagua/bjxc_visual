package com.chinawiserv.dsp.dir.entity.po.drap;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 字典导入数据表字段信息 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_dict_table_column")
public class DrapDictTableColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 数据表ID
     */
	@TableField("table_id")
	private String tableId;
    /**
     * 字段编码
     */
	@TableField("column_code")
	private String columnCode;
    /**
     * 字段中文名
     */
	@TableField("column_cn_name")
	private String columnCnName;
    /**
     * 默认值
     */
	@TableField("default_value")
	private String defaultValue;
    /**
     * 字段长度
     */
	@TableField("column_length")
	private BigDecimal columnLength;
    /**
     * 字段英文名
     */
	@TableField("column_en_name")
	private String columnEnName;
    /**
     * 是否业务数据
     */
	@TableField("is_business_data")
	private Integer isBusinessData;
    /**
     * 是否为主键
     */
	@TableField("is_pk")
	private Integer isPk;
    /**
     * 是否为空
     */
	@TableField("is_null")
	private Integer isNull;
    /**
     * 字段类型
     */
	@TableField("column_type")
	private String columnType;
    /**
     * 敏感标识
     */
	@TableField("sensitive_remark")
	private String sensitiveRemark;
    /**
     * 更新频率
     */
	@TableField("update_frequency")
	private String updateFrequency;
    /**
     * 字段描述
     */
	@TableField("column_desc")
	private String columnDesc;
    /**
     * 字段数据精度
     */
	@TableField("data_precision")
	private String dataPrecision;
    /**
     * 编码序号
     */
	@TableField("code_index")
	private Integer codeIndex;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getColumnCode() {
		return columnCode;
	}

	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode;
	}

	public String getColumnCnName() {
		return columnCnName;
	}

	public void setColumnCnName(String columnCnName) {
		this.columnCnName = columnCnName;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public BigDecimal getColumnLength() {
		return columnLength;
	}

	public void setColumnLength(BigDecimal columnLength) {
		this.columnLength = columnLength;
	}

	public String getColumnEnName() {
		return columnEnName;
	}

	public void setColumnEnName(String columnEnName) {
		this.columnEnName = columnEnName;
	}

	public Integer getIsBusinessData() {
		return isBusinessData;
	}

	public void setIsBusinessData(Integer isBusinessData) {
		this.isBusinessData = isBusinessData;
	}

	public Integer getIsPk() {
		return isPk;
	}

	public void setIsPk(Integer isPk) {
		this.isPk = isPk;
	}

	public Integer getIsNull() {
		return isNull;
	}

	public void setIsNull(Integer isNull) {
		this.isNull = isNull;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getSensitiveRemark() {
		return sensitiveRemark;
	}

	public void setSensitiveRemark(String sensitiveRemark) {
		this.sensitiveRemark = sensitiveRemark;
	}

	public String getUpdateFrequency() {
		return updateFrequency;
	}

	public void setUpdateFrequency(String updateFrequency) {
		this.updateFrequency = updateFrequency;
	}

	public String getColumnDesc() {
		return columnDesc;
	}

	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
	}

	public String getDataPrecision() {
		return dataPrecision;
	}

	public void setDataPrecision(String dataPrecision) {
		this.dataPrecision = dataPrecision;
	}

	public Integer getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
	}

}
