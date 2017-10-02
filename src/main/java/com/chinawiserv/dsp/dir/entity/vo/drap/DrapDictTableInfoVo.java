package com.chinawiserv.dsp.dir.entity.vo.drap;

import java.util.List;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapDictTableInfo;

/**
 * <p>
 * 字典导入数据表信息 Vo对象
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public class DrapDictTableInfoVo extends DrapDictTableInfo{
    
    private List<DrapDictTableColumnVo> columnVos;

    public List<DrapDictTableColumnVo> getColumnVos() {
        return columnVos;
    }

    public void setColumnVos(List<DrapDictTableColumnVo> columnVos) {
        this.columnVos = columnVos;
    }
    
}
