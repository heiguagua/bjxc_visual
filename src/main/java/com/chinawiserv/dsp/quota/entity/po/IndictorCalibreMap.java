package com.chinawiserv.dsp.quota.entity.po;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 指标统计口径关系表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-26
 */
@TableName("im_indictor_calibre_map")
public class IndictorCalibreMap implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 口径ID
     */
	@TableField("calibre_id")
	private String calibreId;
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

	public String getCalibreId() {
		return calibreId;
	}

	public void setCalibreId(String calibreId) {
		this.calibreId = calibreId;
	}

	public String getIndictorId() {
		return indictorId;
	}

	public void setIndictorId(String indictorId) {
		this.indictorId = indictorId;
	}

}
