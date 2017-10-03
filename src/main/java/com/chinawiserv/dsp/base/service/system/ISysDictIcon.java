package com.chinawiserv.dsp.base.service.system;

import com.chinawiserv.dsp.base.entity.po.system.SysIcon;
import com.chinawiserv.dsp.base.entity.vo.system.SysIconVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import java.util.Map;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public interface ISysDictIcon extends ICommonService<SysIcon, SysIconVo> {

	public Map<String, Map<String, SysIconVo>> getDictIconForSelect(Map<String, Object> paramMap) throws Exception;
	
}
