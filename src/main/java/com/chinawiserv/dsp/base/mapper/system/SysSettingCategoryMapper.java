package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysSettingCategory;
import com.chinawiserv.dsp.base.entity.vo.system.SysSettingCategoryVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 系统配置类型表 Mapper 接口
 * </p>
 *
 * @author tx123
 * @since 2018-03-13
 */
public interface SysSettingCategoryMapper extends BaseMapper<SysSettingCategory> {

    List<SysSettingCategoryVo> selectVoPage(Page<SysSettingCategoryVo> page, Map<String, Object> paramMap);

    SysSettingCategoryVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysSettingCategory entity);

    int baseUpdate(SysSettingCategory entity);

    int baseDelete(String id);
}