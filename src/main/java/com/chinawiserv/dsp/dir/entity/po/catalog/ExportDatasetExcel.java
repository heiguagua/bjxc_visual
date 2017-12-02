package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;

/**
 * Created by lianrongfa on 2017/10/2.
 */
public class ExportDatasetExcel {
    private String item_name;
    private String item_type;
    private int item_length;
    private String share_type;
    private String share_condition;
    private String share_method_category;
    private String share_method;
    private String is_open;
    private String open_condition;
    private String update_frequency;
    private String dataset_name;
    private String dataset_code;
    private String dataset_desc;
    private String region_dept_name;
    private String belong_dept_name;
    private String region_code;
    private String region_name;
    private String fname;
    private String belong_dept_no;
    private String format_category;
    private String format_type;
    private String classify_structure_name;
    private Date create_time;

    //大普查
    private int total_storage;
    private int structure_count;
    private int shared_storage;
    private int shared_structure_count;
    private int opened_storage;
    private int opened_structure_count;

    public int getTotal_storage() {
        return total_storage;
    }

    public void setTotal_storage(int total_storage) {
        this.total_storage = total_storage;
    }

    public int getStructure_count() {
        return structure_count;
    }

    public void setStructure_count(int structure_count) {
        this.structure_count = structure_count;
    }

    public int getShared_storage() {
        return shared_storage;
    }

    public void setShared_storage(int shared_storage) {
        this.shared_storage = shared_storage;
    }

    public int getShared_structure_count() {
        return shared_structure_count;
    }

    public void setShared_structure_count(int shared_structure_count) {
        this.shared_structure_count = shared_structure_count;
    }

    public int getOpened_storage() {
        return opened_storage;
    }

    public void setOpened_storage(int opened_storage) {
        this.opened_storage = opened_storage;
    }

    public int getOpened_structure_count() {
        return opened_structure_count;
    }

    public void setOpened_structure_count(int opened_structure_count) {
        this.opened_structure_count = opened_structure_count;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_type() {
        return item_type;
    }

    public int getItem_length() {
        return item_length;
    }

    public void setItem_length(int item_length) {
        this.item_length = item_length;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getShare_type() {
        return share_type;
    }

    public void setShare_type(String share_type) {
        this.share_type = share_type;
    }

    public String getShare_condition() {
        return share_condition;
    }

    public void setShare_condition(String share_condition) {
        this.share_condition = share_condition;
    }

    public String getShare_method_category() {
        return share_method_category;
    }

    public void setShare_method_category(String share_method_category) {
        this.share_method_category = share_method_category;
    }

    public String getShare_method() {
        return share_method;
    }

    public void setShare_method(String share_method) {
        this.share_method = share_method;
    }

    public String getIs_open() {
        return is_open;
    }

    public void setIs_open(String is_open) {
        this.is_open = is_open;
    }

    public String getOpen_condition() {
        return open_condition;
    }

    public void setOpen_condition(String open_condition) {
        this.open_condition = open_condition;
    }

    public String getUpdate_frequency() {
        return update_frequency;
    }

    public void setUpdate_frequency(String update_frequency) {
        this.update_frequency = update_frequency;
    }

    public String getDataset_name() {
        return dataset_name;
    }

    public void setDataset_name(String dataset_name) {
        this.dataset_name = dataset_name;
    }

    public String getRegion_dept_name() {
        return region_dept_name;
    }

    public void setRegion_dept_name(String region_dept_name) {
        this.region_dept_name = region_dept_name;
    }

    public String getDataset_desc() {
        return dataset_desc;
    }

    public void setDataset_desc(String dataset_desc) {
        this.dataset_desc = dataset_desc;
    }

    public String getFormat_category() {
        return format_category;
    }

    public void setFormat_category(String format_category) {
        this.format_category = format_category;
    }

    public String getFormat_type() {
        return format_type;
    }

    public void setFormat_type(String format_type) {
        this.format_type = format_type;
    }

    public String getClassify_structure_name() {
        return classify_structure_name;
    }

    public void setClassify_structure_name(String classify_structure_name) {
        this.classify_structure_name = classify_structure_name;
    }

    public String getDataset_code() {
        return dataset_code;
    }

    public void setDataset_code(String dataset_code) {
        this.dataset_code = dataset_code;
    }

    public String getBelong_dept_name() {
        return belong_dept_name;
    }

    public void setBelong_dept_name(String belong_dept_name) {
        this.belong_dept_name = belong_dept_name;
    }

    public String getBelong_dept_no() {
        return belong_dept_no;
    }

    public void setBelong_dept_no(String belong_dept_no) {
        this.belong_dept_no = belong_dept_no;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
