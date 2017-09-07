package com.chinawiserv.dsp.base.entity.po.common.excel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tk on 2017/6/12.
 */
public class ExcelObj implements Serializable {
    /**
     * 处理成功与失败的标志
     * true 处理成功
     * false 处理失败
     */
    private boolean status;

    private String fileAliasName;//文件别名

    /**
     * 表名
     */
    private String tableName;

    /**
     * MAP形式数据行
     */
    private List<Map<String, String>> list;

    /**
     * LIST形式数据行
     */
    private List<List<String>> listValue;

    /**
     * 字段备注行
     */
    private List<String> listTitle = new ArrayList<String>();

    /**
     * 字段备注行
     */
    private List<String> listHeader = new ArrayList<String>();//字段备注行

    /**
     * 配置信息
     */
    private ExcelConfig excelConfig;

    /**
     * 标题行(字段行)
     */
    private Map<String,String> titleMaper;

    /**
     * 标题行(字段行)
     */
    private Map<String,String> headerMaper;

    /**
     * 数据行
     */
    private List<Map<Integer,String>> valuerMaper;

    /**
     * 错误信息
     */
    private List<String> errors;

    /**
     * 字段类型
     * */
    private Map<String,String> colunmType;

    /**
     * 字段长度
     * */
    private Map<String,String> colunmLength;

    /**
     * 字段列位置
     * */
    private List<String> colPosition;

    /**
     * 字段列位置
     * */
    private Map<Integer,String> colPositionMaper;

    public ExcelConfig getExcelConfig() {
        return excelConfig;
    }

    public void setExcelConfig(ExcelConfig excelConfig) {
        this.excelConfig = excelConfig;
    }

    public String getFileAliasName() {
        return fileAliasName;
    }

    public void setFileAliasName(String fileAliasName) {
        this.fileAliasName = fileAliasName;
    }

    public List<String> getListTitle() {
        return listTitle;
    }

    public void setListTitle(List<String> listTitle) {
        this.listTitle = listTitle;
    }

    public List<String> getListHeader() {
        return listHeader;
    }

    public void setListHeader(List<String> listHeader) {
        this.listHeader = listHeader;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Map<String, String>> getList() {
        return list;
    }

    public void setList(List<Map<String, String>> list) {
        this.list = list;
    }

    public List<List<String>> getListValue() {
        return listValue;
    }

    public void setListValue(List<List<String>> listValue) {
        this.listValue = listValue;
    }

    public Map<String, String> getTitleMaper() {
        return titleMaper;
    }

    public void setTitleMaper(Map<String, String> titleMaper) {
        this.titleMaper = titleMaper;
    }

    public Map<String, String> getHeaderMaper() {
        return headerMaper;
    }

    public void setHeaderMaper(Map<String, String> headerMaper) {
        this.headerMaper = headerMaper;
    }

    public List<Map<Integer, String>> getValuerMaper() {
        return valuerMaper;
    }

    public void setValuerMaper(List<Map<Integer, String>> valuerMaper) {
        this.valuerMaper = valuerMaper;
    }

    public Map<String, String> getColunmType() {
        return colunmType;
    }

    public void setColunmType(Map<String, String> colunmType) {
        this.colunmType = colunmType;
    }

    public Map<String, String> getColunmLength() {
        return colunmLength;
    }

    public void setColunmLength(Map<String, String> colunmLength) {
        this.colunmLength = colunmLength;
    }

    public List<String> getColPosition() {
        return colPosition;
    }

    public Map<Integer, String> getColPositionMaper() {
        return colPositionMaper;
    }

    public void setColPositionMaper(Map<Integer, String> colPositionMaper) {
        this.colPositionMaper = colPositionMaper;
    }

    public void setColPosition(List<String> colPosition) {
        this.colPosition = colPosition;

    }
}
