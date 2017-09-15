package com.chinawiserv.dsp.dir.service.feedback;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.feedback.DirDataCorrection;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.chinawiserv.dsp.dir.entity.vo.feedback.DirDataCorrectionVo;

import java.util.Map;

/**
 * <p>
 * 数据纠错记录 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface IDirDataCorrectionService extends ICommonService<DirDataCorrection, DirDataCorrectionVo> {
    Page<DirDataCorrectionVo> selectDetailByDcmId(Map<String, Object> paramMap);
}
