package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataset;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetExtFormat;

import java.util.List;

/**
 * <p>
 * 数据集（信息资源） Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public class DirDatasetVo extends DirDataset{

    private List<DirDataitemVo> items;

    private String classifyIds;

    private DirDatasetExtFormat ext;

    public DirDatasetExtFormat getExt() {
        return ext;
    }

    public void setExt(DirDatasetExtFormat ext) {
        this.ext = ext;
    }

    public List<DirDataitemVo> getItems() {
        return items;
    }

    public void setItems(List<DirDataitemVo> items) {
        this.items = items;
    }

    public String getClassifyIds() {
        return classifyIds;
    }

    public void setClassifyIds(String classifyIds) {
        this.classifyIds = classifyIds;
    }
}
