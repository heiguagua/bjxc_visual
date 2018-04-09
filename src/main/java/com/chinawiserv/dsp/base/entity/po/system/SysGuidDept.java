package com.chinawiserv.dsp.base.entity.po.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 业务指导部门记录表 Po对象
 * </p>
 *
 * @author tx123
 * @since 2018-04-09
 */
@TableName("sys_guid_dept")
public class SysGuidDept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 当前部门ID
     */
	@TableField("cur_dept_id")
	private String curDeptId;
    /**
     * 业务指导部门ID
     */
	@TableField("guid_dept_id")
	private String guidDeptId;


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

	public String getGuidDeptId() {
		return guidDeptId;
	}

	public void setGuidDeptId(String guidDeptId) {
		this.guidDeptId = guidDeptId;
	}

}
