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
/**
 * @author admin
 *
 */
@TableName("dir_classify_dept_map")
public class DirDeptMap implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;

    @TableField("classify_id")
    private String classifyId;
    /**
     * 【国】分类编号
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
