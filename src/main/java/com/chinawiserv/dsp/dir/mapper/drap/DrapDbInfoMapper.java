package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbInfoVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据库信息 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDbInfoMapper extends BaseMapper<DrapDbInfo> {

    List<DrapDbInfoVo> selectVoPage(Page<DrapDbInfoVo> page, Map<String, Object> paramMap);

    DrapDbInfoVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDbInfo entity);

    int baseUpdate(DrapDbInfo entity);

    int baseDelete(String id);
}