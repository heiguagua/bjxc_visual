package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.base.entity.po.system.SysIcon;
import com.chinawiserv.dsp.base.entity.vo.system.SysIconVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 系统字典表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public interface SysIconMapper extends BaseMapper<SysIcon> {

    List<SysIconVo> selectIconList(Map<String, Object> paramMap);
    
}