package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.dir.entity.po.catalog.*;
import com.chinawiserv.dsp.dir.entity.po.service.DirServiceInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/10/16
 * Time:18:06
 * Chinawiserv Technologies Co., Ltd.
 */
public class DataTransferVo implements Serializable{

    private static final long serialVersionUID = 1L;

    private DirDatasetClassifyMap dirDatasetClassifyMap;

    private List<DirDataTransfer> dirDataTransferList;

    private DirDataset dirDataset;

    private DirClassify dirClassify;

    private List<DirDataitem> dirDataitemList;

    private SysDept sysDept;

    private List<DirDatasetServiceMap> dirDatasetServiceMapList;

    private List<DirServiceInfo> dirServiceInfoList;

    private List<DirDatasetExtCarrier> dirDatasetExtCarrierList;

    private List<DirDatasetExtFormat> dirDatasetExtFormatList;

    private List<DirDatasetExtServiceTarget> dirDatasetExtServiceTargetList;

    private List<DirDatasetExtSeviceField> dirDatasetExtSeviceFieldList;

    private List<DirDatasetExtShareConsult> dirDatasetExtShareConsultList;

    private List<DirDatasetExtSource> dirDatasetExtSourceList;

    public DirDatasetClassifyMap getDirDatasetClassifyMap() {
        return dirDatasetClassifyMap;
    }

    public void setDirDatasetClassifyMap(DirDatasetClassifyMap dirDatasetClassifyMap) {
        this.dirDatasetClassifyMap = dirDatasetClassifyMap;
    }

    public List<DirDataTransfer> getDirDataTransferList() {
        return dirDataTransferList;
    }

    public void setDirDataTransferList(List<DirDataTransfer> dirDataTransferList) {
        this.dirDataTransferList = dirDataTransferList;
    }

    public DirDataset getDirDataset() {
        return dirDataset;
    }

    public void setDirDataset(DirDataset dirDataset) {
        this.dirDataset = dirDataset;
    }

    public DirClassify getDirClassify() {
        return dirClassify;
    }

    public void setDirClassify(DirClassify dirClassify) {
        this.dirClassify = dirClassify;
    }

    public List<DirDataitem> getDirDataitemList() {
        return dirDataitemList;
    }

    public void setDirDataitemList(List<DirDataitem> dirDataitemList) {
        this.dirDataitemList = dirDataitemList;
    }

    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    public List<DirDatasetServiceMap> getDirDatasetServiceMapList() {
        return dirDatasetServiceMapList;
    }

    public void setDirDatasetServiceMapList(List<DirDatasetServiceMap> dirDatasetServiceMapList) {
        this.dirDatasetServiceMapList = dirDatasetServiceMapList;
    }

    public List<DirServiceInfo> getDirServiceInfoList() {
        return dirServiceInfoList;
    }

    public void setDirServiceInfoList(List<DirServiceInfo> dirServiceInfoList) {
        this.dirServiceInfoList = dirServiceInfoList;
    }

    public List<DirDatasetExtCarrier> getDirDatasetExtCarrierList() {
        return dirDatasetExtCarrierList;
    }

    public void setDirDatasetExtCarrierList(List<DirDatasetExtCarrier> dirDatasetExtCarrierList) {
        this.dirDatasetExtCarrierList = dirDatasetExtCarrierList;
    }

    public List<DirDatasetExtFormat> getDirDatasetExtFormatList() {
        return dirDatasetExtFormatList;
    }

    public void setDirDatasetExtFormatList(List<DirDatasetExtFormat> dirDatasetExtFormatList) {
        this.dirDatasetExtFormatList = dirDatasetExtFormatList;
    }

    public List<DirDatasetExtServiceTarget> getDirDatasetExtServiceTargetList() {
        return dirDatasetExtServiceTargetList;
    }

    public void setDirDatasetExtServiceTargetList(List<DirDatasetExtServiceTarget> dirDatasetExtServiceTargetList) {
        this.dirDatasetExtServiceTargetList = dirDatasetExtServiceTargetList;
    }

    public List<DirDatasetExtSeviceField> getDirDatasetExtSeviceFieldList() {
        return dirDatasetExtSeviceFieldList;
    }

    public void setDirDatasetExtSeviceFieldList(List<DirDatasetExtSeviceField> dirDatasetExtSeviceFieldList) {
        this.dirDatasetExtSeviceFieldList = dirDatasetExtSeviceFieldList;
    }

    public List<DirDatasetExtShareConsult> getDirDatasetExtShareConsultList() {
        return dirDatasetExtShareConsultList;
    }

    public void setDirDatasetExtShareConsultList(List<DirDatasetExtShareConsult> dirDatasetExtShareConsultList) {
        this.dirDatasetExtShareConsultList = dirDatasetExtShareConsultList;
    }

    public List<DirDatasetExtSource> getDirDatasetExtSourceList() {
        return dirDatasetExtSourceList;
    }

    public void setDirDatasetExtSourceList(List<DirDatasetExtSource> dirDatasetExtSourceList) {
        this.dirDatasetExtSourceList = dirDatasetExtSourceList;
    }
}
