package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统服务表(NO) Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_system_service")
public class DrapSystemService implements Serializable {

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
     * 服务中文名称
     */
	@TableField("doc_id")
	private String docId;
    /**
     * 服务英文名称
     */
	@TableField("activity_id")
	private String activityId;
    /**
     * 服务使用方式
     */
	@TableField("service_method")
	private String serviceMethod;
    /**
     * IP地址
     */
	@TableField("ip_address")
	private String ipAddress;
    /**
     * 用户名
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 服务说明
     */
	@TableField("service_desc")
	private String serviceDesc;
    /**
     * 所属系统
     */
	@TableField("belong_system")
	private String belongSystem;
    /**
     * 调用参数详细说明
     */
	@TableField("params_desc")
	private String paramsDesc;
    /**
     * 样例描述
     */
	private String samples;
    /**
     * 编码序号
     */
	@TableField("code_index")
	private Integer codeIndex;


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

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getServiceMethod() {
		return serviceMethod;
	}

	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public String getBelongSystem() {
		return belongSystem;
	}

	public void setBelongSystem(String belongSystem) {
		this.belongSystem = belongSystem;
	}

	public String getParamsDesc() {
		return paramsDesc;
	}

	public void setParamsDesc(String paramsDesc) {
		this.paramsDesc = paramsDesc;
	}

	public String getSamples() {
		return samples;
	}

	public void setSamples(String samples) {
		this.samples = samples;
	}

	public Integer getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
	}

}
