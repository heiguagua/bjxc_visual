package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysLog;
import com.chinawiserv.dsp.base.entity.vo.system.SysLogVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 系统操作日志表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-12
 */
public interface SysLogMapper extends BaseMapper<SysLog> {

    List<SysLogVo> selectVoPage(Page<SysLogVo> page, Map<String, Object> paramMap);
    //TODO 爬虫代码
    List<SysLogVo> selectVoList(Page<SysLogVo> page, Map<String, Object> paramMap)  throws Exception;

    SysLogVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysLog entity);

    int baseUpdate(SysLog entity);

    int baseDelete(String id);
}