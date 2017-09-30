package com.chinawiserv.dsp.dir.entity.po.cs;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("cs_data_sync_collect_db")
public class CsDataSyncCollectDb implements Serializable {
    private static final long serialVersionUID = -7230762524986271784L;
    @JSONField(name = "storeDbid")
    private String id;//数据库id
    @TableField("db_ip")
    @JSONField(name = "dbIp")
    private String dbIp;//数据库 IP
    @TableField("db_port")
    @JSONField(name = "dbPort")
    private String dbPort;//数据库端口
    @TableField("db_user")
    @JSONField(name = "dbUser")
    private String dbUser;//数据库用户
    @TableField("db_pass")
    @JSONField(name = "dbPass")
    private String dbPass;//数据库密码
    @TableField("db_name")
    @JSONField(name = "dbName")
    private String dbName;//数据库名称
    @TableField("db_desc")
    @JSONField(name = "dbDesc")
    private String dbDesc;//数据库描述
    @TableField("db_type")
    @JSONField(name = "dbType")
    private String dbType;//数据库类型

    public CsDataSyncCollectDb() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDbIp() {
        return this.dbIp;
    }

    public void setDbIp(String dbIp) {
        this.dbIp = dbIp;
    }

    public String getDbPort() {
        return this.dbPort;
    }

    public void setDbPort(String dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbUser() {
        return this.dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPass() {
        return this.dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    public String getDbName() {
        return this.dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbDesc() {
        return this.dbDesc;
    }

    public void setDbDesc(String dbDesc) {
        this.dbDesc = dbDesc;
    }

    public String getDbType() {
        return this.dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

}
