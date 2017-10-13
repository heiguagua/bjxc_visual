package com.chinawiserv.dsp.dir.entity.po.cs;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("cs_data_sync_collect_column")
public class CsDataSyncCollectColumn implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 2744778232141825485L;
    private String id;
    @TableField("cloumn_name")
    @JSONField(name="cloumnName")
    private String cloumnName;//列名
    @TableField("cloumn_chzn")
    @JSONField(name="cloumnChZn")
    private String cloumnChzn;//列描述
    @TableField("table_id")
    @JSONField(name="tableId")
    private String tableId;//表ID

    public CsDataSyncCollectColumn() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCloumnName() {
        return this.cloumnName;
    }

    public void setCloumnName(String cloumnName) {
        this.cloumnName = cloumnName;
    }

    public String getCloumnChzn() {
        return this.cloumnChzn;
    }

    public void setCloumnChzn(String cloumnChzn) {
        this.cloumnChzn = cloumnChzn;
    }

    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

}
