package com.chinawiserv.dsp.dir.entity.vo.feedback;


import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataRate;

/**
 * <p>
 * 数据集评分记录 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public class DirDataRateVo extends DirDataRate {
    /**
     * 目录名称
     * */
    private String classifyName;
    /**
     * 信息资源名称
     * */
    private String datasetName;
    /**
     * 评分者名称
     * */
    private String raterName;

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

    public String getRaterName() {
        return raterName;
    }

    public void setRaterName(String raterName) {
        this.raterName = raterName;
    }
}
