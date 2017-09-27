package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDictTableInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDictTableInfoVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 字典导入数据表信息 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDictTableInfoMapper extends BaseMapper<DrapDictTableInfo> {

    List<DrapDictTableInfoVo> selectVoPage(Page<DrapDictTableInfoVo> page, Map<String, Object> paramMap);

    DrapDictTableInfoVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDictTableInfo entity);

    int baseUpdate(DrapDictTableInfo entity);

    int baseDelete(String id);
}