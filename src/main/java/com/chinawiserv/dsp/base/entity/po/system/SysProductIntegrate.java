package com.chinawiserv.dsp.base.entity.po.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 产品集成表 Po对象
 * </p>
 *
 * @author tx
 * @since 2017-11-07
 */
@TableName("sys_product_integrate")
public class SysProductIntegrate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 产品标识
     */
	@TableField("product_no")
	private String productNo;
    /**
     * 产品名称
     */
	@TableField("product_name")
	private String productName;
    /**
     * 产品显示名称
     */
	@TableField("product_show_name")
	private String productShowName;
    /**
     * 产品描述
     */
	@TableField("product_desc")
	private String productDesc;
    /**
     * 产品访问根路径地址
     */
	@TableField("root_path")
	private String rootPath;
    /**
     * 单点登录跳转地址
     */
	@TableField("sso_path")
	private String ssoPath;
    /**
     * 显示顺序
     */
	@TableField("order_number")
	private Integer orderNumber;
    /**
     * 是否集成
     */
	@TableField("integrate_flag")
	private Integer integrateFlag;
    /**
     * 是否在当前页面打开
     */
	@TableField("cur_open_flag")
	private Integer curOpenFlag;
    /**
     * 显示图标
     */
	private String icon;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductShowName() {
		return productShowName;
	}

	public void setProductShowName(String productShowName) {
		this.productShowName = productShowName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getSsoPath() {
		return ssoPath;
	}

	public void setSsoPath(String ssoPath) {
		this.ssoPath = ssoPath;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getIntegrateFlag() {
		return integrateFlag;
	}

	public void setIntegrateFlag(Integer integrateFlag) {
		this.integrateFlag = integrateFlag;
	}

	public Integer getCurOpenFlag() {
		return curOpenFlag;
	}

	public void setCurOpenFlag(Integer curOpenFlag) {
		this.curOpenFlag = curOpenFlag;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
