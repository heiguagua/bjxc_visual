package com.chinawiserv.dsp.quota.entity.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 统计指标来源指标关系表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@TableName("im_indictor_compose_map")
public class IndictorComposeMap implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 指标ID
     */
	@TableField("indictor_id")
	private String indictorId;
    /**
     * 来源指标ID
     */
	@TableField("source_indictor_id")
	private String sourceIndictorId;
    /**
     * 来源指标变量定义
     */
	@TableField("source_indictor_variable")
	private String sourceIndictorVariable;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIndictorId() {
		return indictorId;
	}

	public void setIndictorId(String indictorId) {
		this.indictorId = indictorId;
	}

	public String getSourceIndictorId() {
		return sourceIndictorId;
	}

	public void setSourceIndictorId(String sourceIndictorId) {
		this.sourceIndictorId = sourceIndictorId;
	}

	public String getSourceIndictorVariable() {
		return sourceIndictorVariable;
	}

	public void setSourceIndictorVariable(String sourceIndictorVariable) {
		this.sourceIndictorVariable = sourceIndictorVariable;
	}

}
