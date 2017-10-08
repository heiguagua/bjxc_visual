package com.chinawiserv.dsp.dir.service.drap;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapDataset;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDatasetVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.Map;

/**
 * <p>
 * 信息资源（数据集） 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface IDrapDatasetService extends ICommonService<DrapDataset, DrapDatasetVo> {

    void insertDataset(Map<String, Object> dataObj);
}
