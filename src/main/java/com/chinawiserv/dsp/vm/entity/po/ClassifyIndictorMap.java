package com.chinawiserv.dsp.vm.entity.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 图表分类与指标关系表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-25
 */
@TableName("vm_classify_indictor_map")
public class ClassifyIndictorMap implements Serializable {

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
     * 指标编号
     */
	@TableField("indictor_code")
	private String indictorCode;
    /**
     * 指标显示名称
     */
	@TableField("indictor_show_name")
	private String indictorShowName;
    /**
     * 是否高亮显示
     */
	@TableField("highlight_flag")
	private String highlightFlag;
    /**
     * 保留小数点位数
     */
	@TableField("point_num")
	private String pointNum;


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

	public String getIndictorCode() {
		return indictorCode;
	}

	public void setIndictorCode(String indictorCode) {
		this.indictorCode = indictorCode;
	}

	public String getIndictorShowName() {
		return indictorShowName;
	}

	public void setIndictorShowName(String indictorShowName) {
		this.indictorShowName = indictorShowName;
	}

	public String getHighlightFlag() {
		return highlightFlag;
	}

	public void setHighlightFlag(String highlightFlag) {
		this.highlightFlag = highlightFlag;
	}

	public String getPointNum() {
		return pointNum;
	}

	public void setPointNum(String pointNum) {
		this.pointNum = pointNum;
	}

}
