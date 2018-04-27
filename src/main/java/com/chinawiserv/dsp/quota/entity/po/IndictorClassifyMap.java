package com.chinawiserv.dsp.quota.entity.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 指标分类方式关系表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@TableName("im_indictor_classify_map")
public class IndictorClassifyMap implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 分类ID
     */
	@TableField("classify_id")
	private String classifyId;
    /**
     * 指标ID
     */
	@TableField("indictor_id")
	private String indictorId;


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

	public String getIndictorId() {
		return indictorId;
	}

	public void setIndictorId(String indictorId) {
		this.indictorId = indictorId;
	}

}
