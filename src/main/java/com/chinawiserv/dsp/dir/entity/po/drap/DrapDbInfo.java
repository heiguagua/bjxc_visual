package com.chinawiserv.dsp.dir.entity.po.drap;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 数据库信息 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_db_info")
public class DrapDbInfo implements Serializable { 

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 所属行政区划
     */
	@TableField("region_code")
	private String regionCode;
    /**
     * 所属组织
     */
	@TableField("belong_dept")
	private String belongDept;
    /**
     * 数据库编码
     */
	@TableField("db_code")
	private String dbCode;
    /**
     * 数据库中文名称
     */
	@TableField("db_cn_name")
	private String dbCnName;
    /**
     * 数据库类型
     */
	private String category;
    /**
     * 数据库小类
     */
	@TableField("db_type")
	private String dbType;
    /**
     * 数据库英文名称
     */
	@TableField("db_name")
	private String dbName;
    /**
     * 版本号
     */
	private String version;
    /**
     * 数据库IP地址
     */
	@TableField("ip_address")
	private String ipAddress;
    /**
     * 数据库端口号
     */
	private String port;
    /**
     * 实例名
     */
	private String sid;
    /**
     * 服务名
     */
	@TableField("service_name")
	private String serviceName;
    /**
     * 参数1
     */
	private String param1;
    /**
     * 参数2
     */
	private String param2;
    /**
     * 参数3
     */
	private String param3;
    /**
     * 参数4
     */
	private String param4;
    /**
     * 参数5
     */
	private String param5;
    /**
     * 当前数据存储量
     */
	@TableField("cur_storage")
	private BigDecimal curStorage;
    /**
     * 每月数据增量
     */
	@TableField("month_increment")
	private BigDecimal monthIncrement;
    /**
     * 年增量
     */
	@TableField("year_increment")
	private BigDecimal yearIncrement;
    /**
     * 是否备份
     */
	@TableField("is_backup")
	private Integer isBackup;
    /**
     * 备份说明
     */
	@TableField("backup_desc")
	private String backupDesc;
    /**
     * 所属网络
     */
	private String network;
    /**
     * 所属机房地址
     */
	@TableField("room_addr")
	private String roomAddr;
    /**
     * 用户名
     */
	@TableField("user_name")
	private String userName;
    /**
     * 密码
     */
	private String password;
    /**
     * 排序号
     */
	@TableField("order_by")
	private BigDecimal orderBy;
    /**
     * 是否显示
     */
	@TableField("is_show")
	private Integer isShow;
    /**
     * 编码序号
     */
	@TableField("code_index")
	private Integer codeIndex;
    /**
     * 本次连接状态
     */
	@TableField("cur_connect_status")
	private String curConnectStatus;
    /**
     * 本次更新状态
     */
	@TableField("cur_update_status")
	private String curUpdateStatus;
    /**
     * 本次监控时间
     */
	@TableField("cur_monitor_time")
	private Date curMonitorTime;
    /**
     * 状态
     */
	private Integer status;
    /**
     * 创建人
     */
	@TableField("create_user")
	private String createUser;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新人
     */
	@TableField("update_user")
	private String updateUser;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 逻辑删除标识
     */
	@TableField("delete_flag")
	private Integer deleteFlag;
	
    @TableField("auditor")
    private String auditor;
    
    @TableField("audit_time")
    private Date auditTime;
    
    @TableField("audit_opinion")
    private String auditOpinion;
	

	public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getBelongDept() {
		return belongDept;
	}

	public void setBelongDept(String belongDept) {
		this.belongDept = belongDept;
	}

	public String getDbCode() {
		return dbCode;
	}

	public void setDbCode(String dbCode) {
		this.dbCode = dbCode;
	}

	public String getDbCnName() {
		return dbCnName;
	}

	public void setDbCnName(String dbCnName) {
		this.dbCnName = dbCnName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getParam3() {
		return param3;
	}

	public void setParam3(String param3) {
		this.param3 = param3;
	}

	public String getParam4() {
		return param4;
	}

	public void setParam4(String param4) {
		this.param4 = param4;
	}

	public String getParam5() {
		return param5;
	}

	public void setParam5(String param5) {
		this.param5 = param5;
	}

	public BigDecimal getCurStorage() {
		return curStorage;
	}

	public void setCurStorage(BigDecimal curStorage) {
		this.curStorage = curStorage;
	}

	public BigDecimal getMonthIncrement() {
		return monthIncrement;
	}

	public void setMonthIncrement(BigDecimal monthIncrement) {
		this.monthIncrement = monthIncrement;
	}

	public BigDecimal getYearIncrement() {
		return yearIncrement;
	}

	public void setYearIncrement(BigDecimal yearIncrement) {
		this.yearIncrement = yearIncrement;
	}

	public Integer getIsBackup() {
		return isBackup;
	}

	public void setIsBackup(Integer isBackup) {
		this.isBackup = isBackup;
	}

	public String getBackupDesc() {
		return backupDesc;
	}

	public void setBackupDesc(String backupDesc) {
		this.backupDesc = backupDesc;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getRoomAddr() {
		return roomAddr;
	}

	public void setRoomAddr(String roomAddr) {
		this.roomAddr = roomAddr;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(BigDecimal orderBy) {
		this.orderBy = orderBy;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
	}

	public String getCurConnectStatus() {
		return curConnectStatus;
	}

	public void setCurConnectStatus(String curConnectStatus) {
		this.curConnectStatus = curConnectStatus;
	}

	public String getCurUpdateStatus() {
		return curUpdateStatus;
	}

	public void setCurUpdateStatus(String curUpdateStatus) {
		this.curUpdateStatus = curUpdateStatus;
	}

	public Date getCurMonitorTime() {
		return curMonitorTime;
	}

	public void setCurMonitorTime(Date curMonitorTime) {
		this.curMonitorTime = curMonitorTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
