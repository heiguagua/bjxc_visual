package com.chinawiserv.dsp.dir.entity.vo.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataAudit;

/**
 * <p>
 * 数据审核情况表 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public class DirDataAuditVo extends DirDataAudit{

    private String auditorName;

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }
}
