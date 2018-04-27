package com.chinawiserv.dsp.quota.entity.po;

import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 指标分类表 Po对象
 * </p>
 *
 * @author cranky123
 * @since 2018-04-27
 */
@TableName("im_indictor_category")
public class IndictorCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 分类编码
     */
	private String code;
    /**
     * 分类名称
     */
	private String name;
    /**
     * 上级分类
     */
	private String fid;
    /**
     * 分类描述
     */
	private String description;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
