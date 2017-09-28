package com.chinawiserv.dsp.dir.entity.po.catalog;

public class DrapDataset {
    private String id;//ID
    private String regionCode;//所属行政区划
    private String belongDeptId;//【国】信息资源提供方ID
    private String belongActivityId;//所属业务
    private String datasetCode;//数据集编号
    private String datasetName;//【国】信息资源名称
    private String category;//业务数据类型
    private String sensitiveRemark;//敏感标识
    private String updateFrequency;//【国】信息资源更新周期
    private String datasetDesc;//【国】信息资源摘要
    private String shareType;//【国】信息资源共享类型
    private String shareConditionDesc;//【国】信息资源共享条件
    private String shareMethod;//【国】信息资源共享方式
    private String shareMethodDesc;//共享方式说明
    private String shareRange;//共享范围
    private String noShareReason;//不予共享依据
    private String isOpen;//【国】信息资源是否社会开放
    private String openCondition;//【国】信息资源开放条件
    private String relDatasetCode;//【国】信息资源关联资源代码
    private String dataLevel;//【川】信息资源最小分级单元
    private String dataIndexSystem;//【川】信息资源指标体系
    private String isSecret;//【川】信息资源涉密性
    private String storeMedia;//存储介质
    private String physicsStoreLocation;//物理存储位置
    private String extendCode;//扩展编码
    private Integer codeIndex;//编码序号
    private String createUser;//创建人
    private java.util.Date createTime;//创建时间
    private String updateUser;//更新人
    private java.util.Date updateTime;//更新时间

    private String dept_short_name;
    private String dept_code;
    private String system_name;
    private String system_id;

    public String getDept_short_name() {
        return dept_short_name;
    }

    public void setDept_short_name(String dept_short_name) {
        this.dept_short_name = dept_short_name;
    }

    public String getDept_code() {
        return dept_code;
    }

    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }

    public String getSystem_name() {
        return system_name;
    }

    public void setSystem_name(String system_name) {
        this.system_name = system_name;
    }

    public String getSystem_id() {
        return system_id;
    }

    public void setSystem_id(String system_id) {
        this.system_id = system_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegionCode() {
        return this.regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getBelongDeptId() {
        return this.belongDeptId;
    }

    public void setBelongDeptId(String belongDeptId) {
        this.belongDeptId = belongDeptId;
    }

    public String getBelongActivityId() {
        return this.belongActivityId;
    }

    public void setBelongActivityId(String belongActivityId) {
        this.belongActivityId = belongActivityId;
    }

    public String getDatasetCode() {
        return this.datasetCode;
    }

    public void setDatasetCode(String datasetCode) {
        this.datasetCode = datasetCode;
    }

    public String getDatasetName() {
        return this.datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getDatasetDesc() {
        return this.datasetDesc;
    }

    public void setDatasetDesc(String datasetDesc) {
        this.datasetDesc = datasetDesc;
    }

    public String getShareType() {
        return this.shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getShareConditionDesc() {
        return this.shareConditionDesc;
    }

    public void setShareConditionDesc(String shareConditionDesc) {
        this.shareConditionDesc = shareConditionDesc;
    }

    public String getShareMethod() {
        return this.shareMethod;
    }

    public void setShareMethod(String shareMethod) {
        this.shareMethod = shareMethod;
    }

    public String getShareMethodDesc() {
        return this.shareMethodDesc;
    }

    public void setShareMethodDesc(String shareMethodDesc) {
        this.shareMethodDesc = shareMethodDesc;
    }

    public String getShareRange() {
        return this.shareRange;
    }

    public void setShareRange(String shareRange) {
        this.shareRange = shareRange;
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

    public String getRelDatasetCode() {
        return this.relDatasetCode;
    }

    public void setRelDatasetCode(String relDatasetCode) {
        this.relDatasetCode = relDatasetCode;
    }

    public String getDataLevel() {
        return this.dataLevel;
    }

    public void setDataLevel(String dataLevel) {
        this.dataLevel = dataLevel;
    }

    public String getDataIndexSystem() {
        return this.dataIndexSystem;
    }

    public void setDataIndexSystem(String dataIndexSystem) {
        this.dataIndexSystem = dataIndexSystem;
    }

    public String getIsSecret() {
        return this.isSecret;
    }

    public void setIsSecret(String isSecret) {
        this.isSecret = isSecret;
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

    public String getExtendCode() {
        return extendCode;
    }

    public void setExtendCode(String extendCode) {
        this.extendCode = extendCode;
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
