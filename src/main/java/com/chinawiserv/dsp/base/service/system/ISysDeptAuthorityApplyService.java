package com.chinawiserv.dsp.base.service.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthorityApply;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityApplyVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.Map;

/**
 * <p>
 * 数据权限申请表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
public interface ISysDeptAuthorityApplyService extends ICommonService<SysDeptAuthorityApply, SysDeptAuthorityApplyVo> {

    /**
     * 根据paramMap 对Vo进行分页查询
     * @param paramMap
     * @return 返回分页查询结果
     * @throws Exception
     */
    Page<SysDeptAuthorityApplyVo> selectVoPage4Audit(Map<String, Object> paramMap) throws Exception ;
	
}
