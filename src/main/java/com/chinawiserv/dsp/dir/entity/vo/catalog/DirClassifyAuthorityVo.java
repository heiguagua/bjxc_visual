package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassifyAuthority;

/**
 * <p>
 * 目录类别控制权限表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public class DirClassifyAuthorityVo extends DirClassifyAuthority{

    private String fid;

    private String classifyName;

    private String classifyIds;

    private String[] classifyIdArray;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public String getClassifyIds() {
        return classifyIds;
    }

    public void setClassifyIds(String classifyIds) {
        this.classifyIds = classifyIds;
    }

    public String[] getClassifyIdArray() {
        return classifyIdArray;
    }

    public void setClassifyIdArray(String[] classifyIdArray) {
        this.classifyIdArray = classifyIdArray;
    }
}
