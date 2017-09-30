package com.chinawiserv.dsp.dir.entity.po.cs;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("cs_data_sync_collect")
public class CsDataSyncCollect implements Serializable {

    private static final long serialVersionUID = -8586243690552578118L;
    @JSONField(name = "tableId")
    private String id;//表ID（唯一标识）
    @TableField("db_id")
    @JSONField(name = "storeDbid")
    private String dbId;//数据库id
    @TableField("table_name")
    @JSONField(name = "storeTableName")
    private String tableName;//表名
    @TableField("update_time")
    @JSONField(name = "updateTime")
    private Long updateTime;//更新时间
    @TableField("sourceName")
    @JSONField(name = "sourceName")
    private String sourceName;//资源名称
    @TableField("project_name")
    @JSONField(name = "projectName")
    private String projectName;//项目名称
    @JSONField(name = "dbType")
    private String dbType;
    @JSONField(name = "dbDesc")
    private String dbDesc;

    public CsDataSyncCollect() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDbId() {
        return this.dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getDbDesc() {
        return dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc;
    }
}
