package com.chinawiserv.dsp.dir.entity.vo.feedback;


import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataCorrection;

/**
 * <p>
 * 数据纠错记录 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public class DirDataCorrectionVo extends DirDataCorrection {
    /**
     * 目录名称
     * */
    private String classifyName;
    /**
     * 信息资源名称
     */
    private String datasetName;
    /**
     * 纠错者
     */
    private String correctorName;
    /**
     * 审核者
     * */
    private String auditorName;

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

    public String getCorrectorName() {
        return correctorName;
    }

    public void setCorrectorName(String correctorName) {
        this.correctorName = correctorName;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }
}
