package com.chinawiserv.dsp.dir.entity.po.apply;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户注册表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@TableName("dir_regist_user")
public class DirRegistUser implements Serializable {

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
     * 登录用户名
     */
	@TableField("login_name")
	private String loginName;
    /**
     * 真实姓名
     */
	@TableField("real_name")
	private String realName;
    /**
     * 注册邮箱
     */
	private String email;
    /**
     * 联系电话
     */
	private String phone;
    /**
     * 所属部门
     */
	@TableField("belong_dept")
	private String belongDep;
    /**t
     * 状态
     */
	private String status;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBelongDep() {
		return belongDep;
	}

	public void setBelongDep(String belongDep) {
		this.belongDep = belongDep;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
