package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableColumn;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableColumnVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据表字段信息 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapDbTableColumnMapper extends BaseMapper<DrapDbTableColumn> {

    List<DrapDbTableColumnVo> selectVoPage(Page<DrapDbTableColumnVo> page, Map<String, Object> paramMap);

    DrapDbTableColumnVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapDbTableColumn entity);

    int baseUpdate(DrapDbTableColumn entity);

    int baseDelete(String id);
}