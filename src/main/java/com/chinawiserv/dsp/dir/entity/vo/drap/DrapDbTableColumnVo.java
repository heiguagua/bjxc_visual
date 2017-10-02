package com.chinawiserv.dsp.dir.entity.vo.drap;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableColumn;

/**
 * <p>
 * 数据表字段信息 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public class DrapDbTableColumnVo extends DrapDbTableColumn{
    
    private String updateChangeType;

    public String getUpdateChangeType() {
        return updateChangeType;
    }

    public void setUpdateChangeType(String updateChangeType) {
        this.updateChangeType = updateChangeType;
    }
    
}
