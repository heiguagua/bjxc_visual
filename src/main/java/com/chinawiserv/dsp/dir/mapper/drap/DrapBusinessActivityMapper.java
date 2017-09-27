package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessActivity;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessActivityVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务活动表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapBusinessActivityMapper extends BaseMapper<DrapBusinessActivity> {

    List<DrapBusinessActivityVo> selectVoPage(Page<DrapBusinessActivityVo> page, Map<String, Object> paramMap);

    DrapBusinessActivityVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapBusinessActivity entity);

    int baseUpdate(DrapBusinessActivity entity);

    int baseDelete(String id);
}