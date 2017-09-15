package com.chinawiserv.dsp.dir.entity.vo.feedback;


import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataCollection;

/**
 * <p>
 * 数据集收藏记录 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public class DirDataCollectionVo extends DirDataCollection {
    /**
     * 目录名称
     * */
    private String classifyName;
    /**
     * 信息资源名称
     * */
    private String datasetName;
    /**
     * 收藏者
     * */
    private String collectorName;

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }
}
