package com.chinawiserv.dsp.base.entity.po.common.excel;

/**
 * Created by tk on 2017/6/8.
 */
public class ExcelConfig {

    /**
     * Sheet表单名称
     */
    private String sheetName;

    /**
     *英文标题行
     */
    private String titleRownum;

    /**
     *中文标题行
     */
    private String fieldRownum;

    /**
     *设置预览总行数
     */
    private String previewCount;

    /**
     *内容列范围
     */
    private String contentColsRange;

    /**
     *内容行范围
     */
    private String contentRowsRange;

    /**
     *是否是excel文件否则为csv文件
     */
    private String isExcel;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getTitleRownum() {
        return titleRownum;
    }

    public void setTitleRownum(String titleRownum) {
        this.titleRownum = titleRownum;
    }

    public String getFieldRownum() {
        return fieldRownum;
    }

    public void setFieldRownum(String fieldRownum) {
        this.fieldRownum = fieldRownum;
    }

    public String getPreviewCount() {
        return previewCount;
    }

    public void setPreviewCount(String previewCount) {
        this.previewCount = previewCount;
    }

    public String getContentColsRange() {
        return contentColsRange;
    }

    public void setContentColsRange(String contentColsRange) {
        this.contentColsRange = contentColsRange;
    }

    public String getContentRowsRange() {
        return contentRowsRange;
    }

    public void setContentRowsRange(String contentRowsRange) {
        this.contentRowsRange = contentRowsRange;
    }

    public String getIsExcel() {
        return isExcel;
    }

    public void setIsExcel(String isExcel) {
        this.isExcel = isExcel;
    }
}
