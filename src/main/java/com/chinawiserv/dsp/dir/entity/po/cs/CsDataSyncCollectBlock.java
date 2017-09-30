package com.chinawiserv.dsp.dir.entity.po.cs;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.poi.ss.formula.functions.Na;

import java.io.Serializable;

@TableName("cs_data_sync_collect_block")
public class CsDataSyncCollectBlock implements Serializable {
    private static final long serialVersionUID = -5903971487923399923L;
    private String id;
    @TableField("block_name")
    @JSONField(name = "blockName")
    private String blockName;//块名称
    @TableField("block_url")
    @JSONField(name = "blockUrl")
    private String blockUrl;//块URL
    @TableField("table_id")
    @JSONField(name = "tableId")
    private String tableId;//对应表id
    @TableField("website_name")
    @JSONField(name = "websiteName")
    private String websiteName;//网站名称

    public CsDataSyncCollectBlock() {
        super();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlockName() {
        return this.blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getBlockUrl() {
        return this.blockUrl;
    }

    public void setBlockUrl(String blockUrl) {
        this.blockUrl = blockUrl;
    }

    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getWebsiteName() {
        return this.websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

}
