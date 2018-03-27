package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysProductIntegrate;
import com.chinawiserv.dsp.base.entity.vo.system.SysProductIntegrateVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 产品集成表 Mapper 接口
 * </p>
 *
 * @author tx
 * @since 2017-11-07
 */
public interface SysProductIntegrateMapper extends BaseMapper<SysProductIntegrate> {

    List<SysProductIntegrateVo> selectVoPage(Page<SysProductIntegrateVo> page, Map<String, Object> paramMap);

    SysProductIntegrateVo selectVoById(String id);

    SysProductIntegrateVo selectVoByProductNo(String productNo);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysProductIntegrate entity);

    int baseUpdate(SysProductIntegrate entity);

    int baseDelete(String id);

    List<SysProductIntegrateVo> getTheMaster();

}