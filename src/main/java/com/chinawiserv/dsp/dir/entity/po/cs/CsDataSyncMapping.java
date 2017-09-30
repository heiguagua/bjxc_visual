package com.chinawiserv.dsp.dir.entity.po.cs;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

@TableName("cs_data_sync_mapping")
public class CsDataSyncMapping implements Serializable {
    private static final long serialVersionUID = 414942364501210686L;
    @JSONField(name = "confId")
    private String id;//配置id（可做唯一标识）
    @TableField("website_name")
    @JSONField(name = "websiteName")
    private String websiteName;//网站名称
    @TableField("block_url")
    @JSONField(name = "blockUrl")
    private String blockUrl;//模块URL
    @TableField("block_name")
    @JSONField(name = "blockName")
    private String blockName;//模块名称

    public CsDataSyncMapping() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebsiteName() {
        return this.websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getBlockUrl() {
        return this.blockUrl;
    }

    public void setBlockUrl(String blockUrl) {
        this.blockUrl = blockUrl;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

}
