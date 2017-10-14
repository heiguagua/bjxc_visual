package com.chinawiserv.dsp.dir.entity.po.catalog;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 目录分类表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@TableName("dir_national_classify")
public class DirNationalClassify implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;

    /**
     * 【国】分类编号
     */
	@TableField("classify_code")
	private String classifyCode;
    /**
     * 【国】分类名称
     */	
	@TableField("classify_name")
	private String classifyName;	
	
    /**
     * 分类描述
     */
	@TableField("classify_desc")
	private String classifyDesc;
	
	/**
     * 上级分类编号
     */
	@TableField("fcode")
	private String fcode;

    /**
     * 级别
     */
	@TableField("classify_level")
	private Integer classifyLevel;
   
    /**
     * 显示顺序
     */
	@TableField("order_number")
	private Integer orderNumber;

   

	@TableField("classify_structure_code")
	private String classifyStructureCode;

	@TableField("classify_structure_name")
	private String classifyStructureName;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

 

    public String getClassifyCode() {
		return classifyCode;
	}

	public void setClassifyCode(String classifyCode) {
		this.classifyCode = classifyCode;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public String getClassifyDesc() {
		return classifyDesc;
	}

	public void setClassifyDesc(String classifyDesc) {
		this.classifyDesc = classifyDesc;
	}

	public Integer getClassifyLevel() {
		return classifyLevel;
	}

	public void setClassifyLevel(Integer classifyLevel) {
		this.classifyLevel = classifyLevel;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getClassifyStructureCode() {
		return classifyStructureCode;
	}

	public void setClassifyStructureCode(String classifyStructureCode) {
		this.classifyStructureCode = classifyStructureCode;
	}

	public String getClassifyStructureName() {
		return classifyStructureName;
	}

	public void setClassifyStructureName(String classifyStructureName) {
		this.classifyStructureName = classifyStructureName;
	}

	public String getFcode() {
		return fcode;
	}

	public void setFcode(String fcode) {
		this.fcode = fcode;
	}
		
	
}
