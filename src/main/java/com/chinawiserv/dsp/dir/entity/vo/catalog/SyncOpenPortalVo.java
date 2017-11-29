package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataitem;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataset;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetClassifyMap;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetExtFormat;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/11/9
 * Time:16:25
 * Chinawiserv Technologies Co., Ltd.
 */
public class SyncOpenPortalVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<DirDataset> dirDatasetLsit;

    private List<DirDatasetClassifyMap> dirDatasetClassifyMapList;

    private List<DirDataitem> dirDataitemList;

    private List<DirDatasetExtFormat> dirDatasetExtFormatList;

    public List<DirDataset> getDirDatasetLsit() {
        return dirDatasetLsit;
    }

    public void setDirDatasetLsit(List<DirDataset> dirDatasetLsit) {
        this.dirDatasetLsit = dirDatasetLsit;
    }

    public List<DirDatasetClassifyMap> getDirDatasetClassifyMapList() {
        return dirDatasetClassifyMapList;
    }

    public void setDirDatasetClassifyMapList(List<DirDatasetClassifyMap> dirDatasetClassifyMapList) {
        this.dirDatasetClassifyMapList = dirDatasetClassifyMapList;
    }

    public List<DirDataitem> getDirDataitemList() {
        return dirDataitemList;
    }

    public void setDirDataitemList(List<DirDataitem> dirDataitemList) {
        this.dirDataitemList = dirDataitemList;
    }

    public List<DirDatasetExtFormat> getDirDatasetExtFormatList() {
        return dirDatasetExtFormatList;
    }

    public void setDirDatasetExtFormatList(List<DirDatasetExtFormat> dirDatasetExtFormatList) {
        this.dirDatasetExtFormatList = dirDatasetExtFormatList;
    }
}
