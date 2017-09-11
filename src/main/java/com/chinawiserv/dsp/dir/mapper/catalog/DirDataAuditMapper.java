package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataAudit;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataAuditVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据审核情况表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataAuditMapper extends BaseMapper<DirDataAudit> {

    List<DirDataAuditVo> selectVoPage(Page<DirDataAuditVo> page, Map<String, Object> paramMap);

    DirDataAuditVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataAudit entity);

    int baseUpdate(DirDataAudit entity);

    int baseDelete(String id);
}