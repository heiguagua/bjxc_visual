package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthorityApply;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityApplyVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据权限申请表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
public interface SysDeptAuthorityApplyMapper extends BaseMapper<SysDeptAuthorityApply> {

    List<SysDeptAuthorityApplyVo> selectVoPage(Page<SysDeptAuthorityApplyVo> page, Map<String, Object> paramMap);

    SysDeptAuthorityApplyVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysDeptAuthorityApply entity);

    int baseUpdate(SysDeptAuthorityApply entity);

    int baseDelete(String id);
}