package com.chinawiserv.dsp.dir.entity.po.catalog;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 部门分类关联表 Po对象
 * </p>
 *
 * @author wuty
 * @since 2017-11-08
 */
@TableName("dir_classify_dept_map")
public class DirClassifyDeptMap implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 部门分类ID
     */
	@TableField("classify_id")
	private String classifyId;
    /**
     * 部门ID
     */
	@TableField("dept_id")
	private String deptId;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

}
