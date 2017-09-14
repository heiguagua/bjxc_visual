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
     * 收藏目录Code
     * */
    private String dirCode;
    /**
     * 收藏目录
     * */
    private String dirName;
    /**
     * 数据集名称
     * */
    private String dcmName;
    /**
     * 修改者
     * */
    private String correctorName;
    /**
     * 审核者
     * */
    private String auditorName;

    public String getDirCode() {
        return dirCode;
    }

    public void setDirCode(String dirCode) {
        this.dirCode = dirCode;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getDcmName() {
        return dcmName;
    }

    public void setDcmName(String dcmName) {
        this.dcmName = dcmName;
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
