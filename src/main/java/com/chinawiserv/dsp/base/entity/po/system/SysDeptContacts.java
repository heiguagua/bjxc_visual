package com.chinawiserv.dsp.base.entity.po.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 部门联系人 Po对象
 * </p>
 *
 * @author tx123
 * @since 2018-03-19
 */
@TableName("sys_dept_contacts")
public class SysDeptContacts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 部门ID
     */
	@TableField("cur_dept_id")
	private String curDeptId;
    /**
     * 部门联系人类型
     */
	@TableField("contacts_type")
	private String contactsType;
    /**
     * 联系人姓名
     */
	@TableField("contacts_name")
	private String contactsName;
    /**
     * 联系人处室
     */
	@TableField("contacts_dept")
	private String contactsDept;
    /**
     * 联系人职务
     */
	@TableField("contacts_post")
	private String contactsPost;
    /**
     * 联系人座机
     */
	@TableField("contacts_fixed_phone")
	private String contactsFixedPhone;
    /**
     * 联系人手机
     */
	@TableField("contacts_phone")
	private String contactsPhone;
    /**
     * 联系人邮箱
     */
	@TableField("contacts_email")
	private String contactsEmail;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurDeptId() {
		return curDeptId;
	}

	public void setCurDeptId(String curDeptId) {
		this.curDeptId = curDeptId;
	}

	public String getContactsType() {
		return contactsType;
	}

	public void setContactsType(String contactsType) {
		this.contactsType = contactsType;
	}

	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsDept() {
		return contactsDept;
	}

	public void setContactsDept(String contactsDept) {
		this.contactsDept = contactsDept;
	}

	public String getContactsPost() {
		return contactsPost;
	}

	public void setContactsPost(String contactsPost) {
		this.contactsPost = contactsPost;
	}

	public String getContactsFixedPhone() {
		return contactsFixedPhone;
	}

	public void setContactsFixedPhone(String contactsFixedPhone) {
		this.contactsFixedPhone = contactsFixedPhone;
	}

	public String getContactsPhone() {
		return contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	public String getContactsEmail() {
		return contactsEmail;
	}

	public void setContactsEmail(String contactsEmail) {
		this.contactsEmail = contactsEmail;
	}

}
