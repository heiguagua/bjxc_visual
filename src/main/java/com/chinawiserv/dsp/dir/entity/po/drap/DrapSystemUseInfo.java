package com.chinawiserv.dsp.dir.entity.po.drap;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 信息系统使用信息 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@TableName("drap_system_use_info")
public class DrapSystemUseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 信息系统ID
     */
	@TableField("info_system_id")
	private String infoSystemId;
    /**
     * 系统访问地址
     */
	@TableField("visit_url")
	private String visitUrl;
    /**
     * 系统访问账号
     */
	private String username;
    /**
     * 系统访问密码
     */
	private String password;
    /**
     * 分配部门
     */
	@TableField("belong_dept")
	private String belongDept;
    /**
     * 开始使用日期
     */
	@TableField("start_use_date")
	private Date startUseDate;
    /**
     * 使用频率
     */
	@TableField("use_frequence")
	private String useFrequence;
    /**
     * 关键业务
     */
	@TableField("key_business")
	private String keyBusiness;
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

	public String getInfoSystemId() {
		return infoSystemId;
	}

	public void setInfoSystemId(String infoSystemId) {
		this.infoSystemId = infoSystemId;
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

	public String getBelongDept() {
		return belongDept;
	}

	public void setBelongDept(String belongDept) {
		this.belongDept = belongDept;
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

	public Integer getCodeIndex() {
		return codeIndex;
	}

	public void setCodeIndex(Integer codeIndex) {
		this.codeIndex = codeIndex;
	}

}
