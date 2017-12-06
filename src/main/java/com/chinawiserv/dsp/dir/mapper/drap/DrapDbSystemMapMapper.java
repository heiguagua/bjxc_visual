package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbSystemMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbSystemMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据库业务系统关系表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDbSystemMapMapper extends BaseMapper<DrapDbSystemMap> {

    List<DrapDbSystemMapVo> selectVoPage(Page<DrapDbSystemMapVo> page, Map<String, Object> paramMap);

    DrapDbSystemMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDbSystemMap entity);

    int baseUpdate(DrapDbSystemMap entity);

    int baseDelete(Map<String,Object> paramMap);
}