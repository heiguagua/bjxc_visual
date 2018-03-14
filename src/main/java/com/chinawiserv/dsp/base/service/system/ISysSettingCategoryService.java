package com.chinawiserv.dsp.base.service.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysSettingCategory;
import com.chinawiserv.dsp.base.entity.vo.system.SysSettingCategoryVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysSettingVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.Map;

/**
 * <p>
 * 系统配置类型表 服务类
 * </p>
 *
 * @author tx123
 * @since 2018-03-13
 */
public interface ISysSettingCategoryService extends ICommonService<SysSettingCategory, SysSettingCategoryVo> {

     Page<SysSettingCategoryVo> selectVoPage(Map<String, Object> paramMap);

     SysSettingCategoryVo selectById(String categoryCode);

     boolean updateById(SysSettingCategoryVo vo);
	
}
