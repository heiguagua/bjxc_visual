package com.chinawiserv.dsp.dir.service.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataitem;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataitemVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 数据集对应数据项表【国】 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public interface IDirDataitemService extends ICommonService<DirDataitem, DirDataitemVo> {
    int insertListItem(List<DirDataitemVo> list);

    void deleteByDatasetId(String id);
}
