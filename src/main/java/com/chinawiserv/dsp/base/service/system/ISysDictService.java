package com.chinawiserv.dsp.base.service.system;

import com.chinawiserv.dsp.base.entity.po.system.SysDict;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public interface ISysDictService extends ICommonService<SysDict, SysDictVo> {

    public Map<String, Map<String, SysDictVo>> getDictDataForSelect(Map<String, Object> paramMap) throws Exception;

    String selectDictcodeByCategoryAndName(String dict_name, String category);
}
