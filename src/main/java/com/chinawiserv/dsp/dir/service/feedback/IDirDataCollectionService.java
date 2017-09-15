package com.chinawiserv.dsp.dir.service.feedback;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataCollection;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirDataCollectionVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.Map;

/**
 * <p>
 * 数据集收藏记录 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface IDirDataCollectionService extends ICommonService<DirDataCollection, DirDataCollectionVo> {
    Page<DirDataCollectionVo> selectDetailByDcmId(Map<String, Object> paramMap);
}
