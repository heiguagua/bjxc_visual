package com.chinawiserv.dsp.dir.entity.vo.drap;

import java.util.List;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableInfo;

/**
 * <p>
 * 数据表信息 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public class DrapDbTableInfoVo extends DrapDbTableInfo{
    
    private List<DrapDbTableColumnVo> columnVos;

    private String updateChangeType;
    
    public List<DrapDbTableColumnVo> getColumnVos() {
        return columnVos;
    }

    public void setColumnVos(List<DrapDbTableColumnVo> columnVos) {
        this.columnVos = columnVos;
    }

    public String getUpdateChangeType() {
        return updateChangeType;
    }

    public void setUpdateChangeType(String updateChangeType) {
        this.updateChangeType = updateChangeType;
    }
    
}
