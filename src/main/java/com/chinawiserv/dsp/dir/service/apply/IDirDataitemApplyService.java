package com.chinawiserv.dsp.dir.service.apply;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataitemApply;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataitemApplyVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.Map;

/**
 * <p>
 * 数据项权限申请表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface IDirDataitemApplyService extends ICommonService<DirDataitemApply, DirDataitemApplyVo> {
    Page<DirDataitemApplyVo> selectVoPageDetails(Map<String, Object> paramMap) throws Exception;
	
}
