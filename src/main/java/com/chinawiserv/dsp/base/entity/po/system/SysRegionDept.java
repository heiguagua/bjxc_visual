package com.chinawiserv.dsp.base.entity.po.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 行政部门表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-10-08
 */
//@TableName("sys_region_dept")
public class SysRegionDept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
	private String id;
    /**
     * 区域编码
     */
    private String regionCode;
    /**
     * 上级行政部门编号
     */
    private String category;
    /**
     * 行政部门编号
     */
	private String regionDeptCode;
    /**
     * 行政部门名称
     */
	private String regionDeptName;
    /**
     * 上级行政部门编号
     */
	private String fcode;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegionDeptCode() {
        return regionDeptCode;
    }

    public void setRegionDeptCode(String regionDeptCode) {
        this.regionDeptCode = regionDeptCode;
    }

    public String getRegionDeptName() {
        return regionDeptName;
    }

    public void setRegionDeptName(String regionDeptName) {
        this.regionDeptName = regionDeptName;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }
}
