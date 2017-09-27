package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableInfoVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据表信息 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDbTableInfoMapper extends BaseMapper<DrapDbTableInfo> {

    List<DrapDbTableInfoVo> selectVoPage(Page<DrapDbTableInfoVo> page, Map<String, Object> paramMap);

    DrapDbTableInfoVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDbTableInfo entity);

    int baseUpdate(DrapDbTableInfo entity);

    int baseDelete(String id);
}