package com.chinawiserv.dsp.dir.entity.po.catalog;

public class DrapDatasetItem {
    private String id;//ID
    private String itemCode;//数据项编码
    private String itemName;//【国】数据项名称
    private String itemType;//【国】数据项类型
    private String itemDesc;//数据项描述
    private String belongDept;//所属组织
    private String sensitiveRemark;//敏感标识
    private String updateFrequency;//更新频率
    private String shareType;//共享类型
    private String shareRange;//共享范围
    private String shareMethod;//共享方式
    private String shareConditionDesc;//共享条件说明
    private String shareMethodDesc;//共享方式说明
    private String noShareReason;//不予共享依据
    private String isOpen;//是否开放
    private String openCondition;//开放条件
    private String storeMedia;//存储介质
    private String physicsStoreLocation;//物理存储位置
    private Integer codeIndex;//编码序号
    private String createUser;//创建人
    private java.util.Date createTime;//创建时间
    private String updateUser;//更新人
    private java.util.Date updateTime;//更新时间
    private int itemLength;//【国】数据项长度
    private int isSecret;//是否涉密
    private int itemFormat;//所属信息资源格式

    private String dept_short_name;
    private String dataset_name;
    private String system_name;
    private String system_id;

    public int getItemFormat() {
        return itemFormat;
    }

    public void setItemFormat(int itemFormat) {
        this.itemFormat = itemFormat;
    }

    public int getIsSecret() {
        return isSecret;
    }

    public void setIsSecret(int isSecret) {
        this.isSecret = isSecret;
    }

    public String getSystem_id() {
        return system_id;
    }

    public void setSystem_id(String system_id) {
        this.system_id = system_id;
    }

    public int getItemLength() {
        return itemLength;
    }

    public void setItemLength(int itemLength) {
        this.itemLength = itemLength;
    }

    public String getDept_short_name() {
        return dept_short_name;
    }

    public void setDept_short_name(String dept_short_name) {
        this.dept_short_name = dept_short_name;
    }

    public String getDataset_name() {
        return dataset_name;
    }

    public void setDataset_name(String dataset_name) {
        this.dataset_name = dataset_name;
    }

    public String getSystem_name() {
        return system_name;
    }

    public void setSystem_name(String system_name) {
        this.system_name = system_name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemCode() {
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemDesc() {
        return this.itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getBelongDept() {
        return this.belongDept;
    }

    public void setBelongDept(String belongDept) {
        this.belongDept = belongDept;
    }

    public String getSensitiveRemark() {
        return this.sensitiveRemark;
    }

    public void setSensitiveRemark(String sensitiveRemark) {
        this.sensitiveRemark = sensitiveRemark;
    }

    public String getUpdateFrequency() {
        return this.updateFrequency;
    }

    public void setUpdateFrequency(String updateFrequency) {
        this.updateFrequency = updateFrequency;
    }

    public String getShareType() {
        return this.shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getShareRange() {
        return this.shareRange;
    }

    public void setShareRange(String shareRange) {
        this.shareRange = shareRange;
    }

    public String getShareMethod() {
        return this.shareMethod;
    }

    public void setShareMethod(String shareMethod) {
        this.shareMethod = shareMethod;
    }

    public String getShareConditionDesc() {
        return this.shareConditionDesc;
    }

    public void setShareConditionDesc(String shareConditionDesc) {
        this.shareConditionDesc = shareConditionDesc;
    }

    public String getShareMethodDesc() {
        return this.shareMethodDesc;
    }

    public void setShareMethodDesc(String shareMethodDesc) {
        this.shareMethodDesc = shareMethodDesc;
    }

    public String getNoShareReason() {
        return this.noShareReason;
    }

    public void setNoShareReason(String noShareReason) {
        this.noShareReason = noShareReason;
    }

    public String getIsOpen() {
        return this.isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public String getOpenCondition() {
        return this.openCondition;
    }

    public void setOpenCondition(String openCondition) {
        this.openCondition = openCondition;
    }

    public String getStoreMedia() {
        return this.storeMedia;
    }

    public void setStoreMedia(String storeMedia) {
        this.storeMedia = storeMedia;
    }

    public String getPhysicsStoreLocation() {
        return this.physicsStoreLocation;
    }

    public void setPhysicsStoreLocation(String physicsStoreLocation) {
        this.physicsStoreLocation = physicsStoreLocation;
    }

    public Integer getCodeIndex() {
        return this.codeIndex;
    }

    public void setCodeIndex(Integer codeIndex) {
        this.codeIndex = codeIndex;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

}
