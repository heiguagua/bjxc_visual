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
     * 收藏人姓名
     * */
    private String collectorName;

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }
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
}
