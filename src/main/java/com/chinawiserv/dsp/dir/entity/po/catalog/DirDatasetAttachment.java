package com.chinawiserv.dsp.dir.entity.po.catalog;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 *  Po对象
 * </p>
 *
 * @author tx
 * @since 2017-11-28
 */
@TableName("dir_dataset_attachment")
public class DirDatasetAttachment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 数据集ID
     */
	@TableField("dataset_id")
	private String datasetId;
    /**
     * 数据文件路径
     */
	@TableField("dataset_file_path")
	private String datasetFilePath;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public String getDatasetFilePath() {
		return datasetFilePath;
	}

	public void setDatasetFilePath(String datasetFilePath) {
		this.datasetFilePath = datasetFilePath;
	}

}
