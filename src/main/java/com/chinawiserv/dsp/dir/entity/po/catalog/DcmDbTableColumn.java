package com.chinawiserv.dsp.dir.entity.po.catalog;

public class DcmDbTableColumn {
    private String id;//ID
    private String tableId;//表ID
    private String columnName;//字段名
    private String columnType;//字段类型
    private String columnLength;//字段长度
    private String emptyfFlag;//字段是否为空
    private String pkFlag;//字段是否为主键
    private String refFlag;//字段是否外部路径
    private String defaultValue;//字段默认值
    private String columnRemark;//字段备注
    private String columnDetail;//字段详细描述
    private Integer columnOrder;//列顺序
    private Integer status;//状态
    private String createUserId;//创建人
    private java.util.Date createTime;//创建时间
    private String updateUserId;//更新人
    private java.util.Date updateTime;//更新时间
    private Integer deleteFlag;//逻辑删除标识

    private String table_cn_name;
    private String table_name;
    private String dept_name;
    private String dept_id;

    public String getTable_cn_name() {
        return table_cn_name;
    }

    public void setTable_cn_name(String table_cn_name) {
        this.table_cn_name = table_cn_name;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return this.columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnLength() {
        return this.columnLength;
    }

    public void setColumnLength(String columnLength) {
        this.columnLength = columnLength;
    }

    public String getEmptyfFlag() {
        return this.emptyfFlag;
    }

    public void setEmptyfFlag(String emptyfFlag) {
        this.emptyfFlag = emptyfFlag;
    }

    public String getPkFlag() {
        return this.pkFlag;
    }

    public void setPkFlag(String pkFlag) {
        this.pkFlag = pkFlag;
    }

    public String getRefFlag() {
        return this.refFlag;
    }

    public void setRefFlag(String refFlag) {
        this.refFlag = refFlag;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getColumnRemark() {
        return this.columnRemark;
    }

    public void setColumnRemark(String columnRemark) {
        this.columnRemark = columnRemark;
    }

    public String getColumnDetail() {
        return this.columnDetail;
    }

    public void setColumnDetail(String columnDetail) {
        this.columnDetail = columnDetail;
    }

    public Integer getColumnOrder() {
        return this.columnOrder;
    }

    public void setColumnOrder(Integer columnOrder) {
        this.columnOrder = columnOrder;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUserId() {
        return this.updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}
