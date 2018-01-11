package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataOffline;

/**
 * <p>
 * 数据下架情况 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public class DirDataOfflineVo extends DirDataOffline{

    private String offlineUserName;

    public String getOfflineUserName() {
        return offlineUserName;
    }

    public void setOfflineUserName(String offlineUserName) {
        this.offlineUserName = offlineUserName;
    }
}
