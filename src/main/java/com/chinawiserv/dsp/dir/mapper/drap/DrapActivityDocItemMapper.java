package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityDocItem;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivityDocItemVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务活动资料数据项表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapActivityDocItemMapper extends BaseMapper<DrapActivityDocItem> {

    List<DrapActivityDocItemVo> selectVoPage(Page<DrapActivityDocItemVo> page, Map<String, Object> paramMap);

    DrapActivityDocItemVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapActivityDocItem entity);

    int baseUpdate(DrapActivityDocItem entity);

    int baseDelete(String id);
}