package com.chinawiserv.dsp.base.service.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysSetting;
import com.chinawiserv.dsp.base.entity.vo.system.SysSettingVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.Map;

/**
 * <p>
 * 系统设置表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysSettingService extends ICommonService<SysSetting,SysSettingVo> {

    public Page<SysSettingVo> selectVoPage(Map<String, Object> paramMap) throws Exception;

    String findValueByCode(String code) throws Exception;
}
