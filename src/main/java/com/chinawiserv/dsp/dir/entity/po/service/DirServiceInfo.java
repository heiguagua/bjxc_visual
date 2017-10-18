package com.chinawiserv.dsp.dir.entity.po.service;

import java.util.Date;
 
import com.baomidou.mybatisplus.annotations.TableField;
 
import com.baomidou.mybatisplus.annotations.TableName;
	 
import java.io.Serializable;
	 
 
@TableName("dir_service_info")
public class DirServiceInfo implements Serializable {
 
 private static final long serialVersionUID = 1L;

	private String id;
 
    /**
	 
     * 服务名称
	 
     */
	 
@TableField("service_name")
private String serviceName;
	 
   /**
	 
     * 服务类型
	 
   */
	 
	@TableField("service_type")
	 
	private String serviceType;
	 
   /**
	 
    * 服务URL
	 
    */
	 
	@TableField("service_url")
	 
	private String serviceUrl;
	 
    /**
	 
     * 服务请求方式
	 
     */
	 
	@TableField("request_method")
	 
	private String requestMethod;
	 
    /**
	 
     * 服务请求格式
	 
     */
	 
	@TableField("request_format")	 
	private String requestFormat;
	 
    /**
	 
    * 请求信息
	 
     */
	 
	@TableField("request_info")	 
	private String requestInfo;
	 
    /**
	 
     * 操作时间
     * 	     
     *  
     *  */
	 
	@TableField("operate_date")	 
	private Date operateDate;
	 

	 
	 
	public String getId() {
	 
		return id;
	 
	}
	 

	 
	public void setId(String id) {
	 
		this.id = id;
	 
	}
	 

	 
	public String getServiceName() {
	 
		return serviceName;
	 
	}
	 
	 
	public void setServiceName(String serviceName) {
	 
		this.serviceName = serviceName;
	 
	}
	 

	 
	public String getServiceType() {
	 
		return serviceType;
	 
	}
	 
	 
	public void setServiceType(String serviceType) {
	 
		this.serviceType = serviceType;
	 
	}
	 

	 
	public String getServiceUrl() {
	 
		return serviceUrl;
	 
	}
	 

	 
	public void setServiceUrl(String serviceUrl) {
	 
		this.serviceUrl = serviceUrl;
	 
	}
	 

	 
	public String getRequestMethod() {
	 
		return requestMethod;
 
	}
	 

	 
	public void setRequestMethod(String requestMethod) {
	 
		this.requestMethod = requestMethod;
	 
	}
 

 
	public String getRequestFormat() {
 
		return requestFormat;
 
	}
 

 
	public void setRequestFormat(String requestFormat) {
 
		this.requestFormat = requestFormat;
 
	}
 
 
	public String getRequestInfo() {
	 
		return requestInfo;
	 
	}
 
	public void setRequestInfo(String requestInfo) {
 
		this.requestInfo = requestInfo;
	 
}
	 
 
	public Date getOperateDate() {
 
		return operateDate;
 
	}
 
	public void setOperateDate(Date operateDate) {
 
		this.operateDate = operateDate;
	 
	}
 
 
}