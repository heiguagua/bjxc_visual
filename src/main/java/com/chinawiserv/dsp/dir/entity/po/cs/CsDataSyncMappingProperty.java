package com.chinawiserv.dsp.dir.entity.po.cs;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("cs_data_sync_mapping_property")
public class CsDataSyncMappingProperty implements Serializable {
    private static final long serialVersionUID = 5637577966909782901L;
    private String id;
    @TableField("conf_id")
    @JSONField(name = "confId")
    private String confId;//配置ID
    @TableField("cloumn_name")
    @JSONField(name = "cloumnName")
    private String cloumnName;//列名
    @TableField("cloumn_chzn")
    @JSONField(name = "cloumnChZn")
    private String cloumnChzn;//列描述
    @TableField("porperty_type")
    @JSONField(name = "porpertyType")
    private Integer porpertyType;//属性类别，0：列表属性；1：文章属性；2：tab页属性
    @TableField("property_id")
    @JSONField(name = "propertyId")
    private String propertyId;//属性id
    @TableField("update_time")
    @JSONField(name = "updateTime")
    private Long updateTime;//属性更新时间戳
    @TableField("update_user")
    @JSONField(name = "updateUser")
    private String updateUser;//更新用户

    public CsDataSyncMappingProperty() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfId() {
        return this.confId;
    }

    public void setConfId(String confId) {
        this.confId = confId;
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

    public Integer getPorpertyType() {
        return this.porpertyType;
    }

    public void setPorpertyType(Integer porpertyType) {
        this.porpertyType = porpertyType;
    }

    public String getPropertyId() {
        return this.propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}
