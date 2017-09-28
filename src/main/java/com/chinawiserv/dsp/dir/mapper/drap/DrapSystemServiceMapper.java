package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSystemService;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSystemServiceVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 系统服务表(NO) Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapSystemServiceMapper extends BaseMapper<DrapSystemService> {

    List<DrapSystemServiceVo> selectVoPage(Page<DrapSystemServiceVo> page, Map<String, Object> paramMap);

    DrapSystemServiceVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapSystemService entity);

    int baseUpdate(DrapSystemService entity);

    int baseDelete(String id);
}