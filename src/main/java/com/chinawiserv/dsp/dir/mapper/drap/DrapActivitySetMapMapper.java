package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivitySetMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivitySetMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 信息资源关联业务表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapActivitySetMapMapper extends BaseMapper<DrapActivitySetMap> {

    List<DrapActivitySetMapVo> selectVoPage(Page<DrapActivitySetMapVo> page, Map<String, Object> paramMap);

    DrapActivitySetMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapActivitySetMap entity);

    int baseUpdate(DrapActivitySetMap entity);

    int baseDelete(String id);

    void batchInsert(List<DrapActivitySetMap> drapActivitySetMapList);
}