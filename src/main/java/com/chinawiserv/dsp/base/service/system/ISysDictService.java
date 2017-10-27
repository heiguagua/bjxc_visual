package com.chinawiserv.dsp.base.service.system;

import java.util.List;
import java.util.Map;

import com.chinawiserv.dsp.base.entity.po.system.SysDict;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public interface ISysDictService extends ICommonService<SysDict, SysDictVo> {

    Map<String, Map<String, SysDictVo>> getDictDataForSelect(Map<String, Object> paramMap) throws Exception;
    List<SysDictVo> selectVoCategoryList(Map<String, Object> paramMap);
    String selectDictcodeByCategoryAndName(String dict_name, String category);
    boolean updateDetailVO(SysDictVo vo) throws Exception;
    SysDictVo selectVoDetailById(String id) throws Exception;
    boolean deleteDictById(String id) throws Exception;


}
