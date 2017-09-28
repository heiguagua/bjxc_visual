package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapBusinessDoc;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapBusinessDocVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务活动资料 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapBusinessDocMapper extends BaseMapper<DrapBusinessDoc> {

    List<DrapBusinessDocVo> selectVoPage(Page<DrapBusinessDocVo> page, Map<String, Object> paramMap);

    DrapBusinessDocVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapBusinessDoc entity);

    int baseUpdate(DrapBusinessDoc entity);

    int baseDelete(String id);
}