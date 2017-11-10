package com.chinawiserv.dsp.dir.entity.po.drap;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 信息系统使用单位 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_system_use_dept")
public class DrapSystemUseDept implements Serializable {

    private static final long serialVersionUID = 1L;

	
	private String id;

	@TableField(exist = false)
	private String index;
    /**
     * 系统ID
     */
	@TableField("system_id")
	private String systemId;
    public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getVisitUrl() {
		return visitUrl;
	}

	public void setVisitUrl(String visitUrl) {
		this.visitUrl = visitUrl;
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

	public Date getStartUseDate() {
		return startUseDate;
	}

	public void setStartUseDate(Date startUseDate) {
		this.startUseDate = startUseDate;
	}

	public String getUseFrequence() {
		return useFrequence;
	}

	public void setUseFrequence(String useFrequence) {
		this.useFrequence = useFrequence;
	}

	public String getKeyBusiness() {
		return keyBusiness;
	}

	public void setKeyBusiness(String keyBusiness) {
		this.keyBusiness = keyBusiness;
	}

	public String getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(String codeIndex) {
		this.codeIndex = codeIndex;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
     * 使用单位ID
     */
	@TableField("dept_id")
	private String deptId;

	private String depName;

	@TableField("visit_url")
	private String visitUrl;

	@TableField("username")
	private String username;

	@TableField("password")
	private String password;

	@TableField("start_use_date")
	private Date startUseDate;

	@TableField("use_frequence")
	private String useFrequence;

	@TableField("key_business")
	private String keyBusiness;

	@TableField("code_index")
	private String codeIndex;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}
