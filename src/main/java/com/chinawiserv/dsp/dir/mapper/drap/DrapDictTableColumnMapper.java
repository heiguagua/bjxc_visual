package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDictTableColumn;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDictTableColumnVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 字典导入数据表字段信息 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDictTableColumnMapper extends BaseMapper<DrapDictTableColumn> {

    List<DrapDictTableColumnVo> selectVoPage(Page<DrapDictTableColumnVo> page, Map<String, Object> paramMap);

    DrapDictTableColumnVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDictTableColumn entity);

    int baseUpdate(DrapDictTableColumn entity);

    int baseDelete(String id);
}