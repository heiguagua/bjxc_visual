package com.chinawiserv.dsp.dir.entity.po.catalog;

public class DrapDbTableColumn {
    private String id;//ID
    private String table_id;//数据表ID
    private String column_code;//字段编码
    private String column_cn_name;//字段中文名
    private String default_value;//默认值
    private Double column_length;//字段长度
    private String column_en_name;//字段英文名
    private Integer is_business_data;//是否业务数据
    private Integer is_pk;//是否为主键
    private Integer is_null;//是否为空
    private String column_type;//字段类型
    private String sensitive_remark;//敏感标识
    private String update_frequency;//更新频率
    private String column_desc;//字段描述
    private String data_precision;//字段数据精度
    private Integer code_index;//编码序号
    private Integer status;//状态
    private Integer delete_flag;//逻辑删除标识

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

    public String getTable_id() {
        return this.table_id;
    }

    public void setTable_id(String table_id) {
        this.table_id = table_id;
    }

    public String getColumn_code() {
        return this.column_code;
    }

    public void setColumn_code(String column_code) {
        this.column_code = column_code;
    }

    public String getColumn_cn_name() {
        return this.column_cn_name;
    }

    public void setColumn_cn_name(String column_cn_name) {
        this.column_cn_name = column_cn_name;
    }

    public String getDefault_value() {
        return this.default_value;
    }

    public void setDefault_value(String default_value) {
        this.default_value = default_value;
    }

    public Double getColumn_length() {
        return this.column_length;
    }

    public void setColumn_length(Double column_length) {
        this.column_length = column_length;
    }

    public String getColumn_en_name() {
        return this.column_en_name;
    }

    public void setColumn_en_name(String column_en_name) {
        this.column_en_name = column_en_name;
    }

    public Integer getIs_business_data() {
        return this.is_business_data;
    }

    public void setIs_business_data(Integer is_business_data) {
        this.is_business_data = is_business_data;
    }

    public Integer getIs_pk() {
        return this.is_pk;
    }

    public void setIs_pk(Integer is_pk) {
        this.is_pk = is_pk;
    }

    public Integer getIs_null() {
        return this.is_null;
    }

    public void setIs_null(Integer is_null) {
        this.is_null = is_null;
    }

    public String getColumn_type() {
        return this.column_type;
    }

    public void setColumn_type(String column_type) {
        this.column_type = column_type;
    }

    public String getSensitive_remark() {
        return this.sensitive_remark;
    }

    public void setSensitive_remark(String sensitive_remark) {
        this.sensitive_remark = sensitive_remark;
    }

    public String getUpdate_frequency() {
        return this.update_frequency;
    }

    public void setUpdate_frequency(String update_frequency) {
        this.update_frequency = update_frequency;
    }

    public String getColumn_desc() {
        return this.column_desc;
    }

    public void setColumn_desc(String column_desc) {
        this.column_desc = column_desc;
    }

    public String getData_precision() {
        return this.data_precision;
    }

    public void setData_precision(String data_precision) {
        this.data_precision = data_precision;
    }

    public Integer getCode_index() {
        return this.code_index;
    }

    public void setCode_index(Integer code_index) {
        this.code_index = code_index;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelete_flag() {
        return this.delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

}
