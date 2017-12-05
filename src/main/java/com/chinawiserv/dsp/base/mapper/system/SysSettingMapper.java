package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chinawiserv.dsp.base.entity.po.system.SysSetting;
import com.chinawiserv.dsp.base.entity.vo.system.SysSettingVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 系统设置表 Mapper 接口1
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysSettingMapper extends BaseMapper<SysSetting> {

    public List<SysSettingVo> selectVo(RowBounds rowBounds, Map<String, Object> paramMap);

    public int selectVoCount(Map<String, Object> paramMap);

    public SysSettingVo selectVoByCode(@Param("settingCode")String settingCode);

    List<SysSettingVo> listCodeAndValueByType(@Param("type") String type);
}