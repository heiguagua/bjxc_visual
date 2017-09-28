package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSxTableSync;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSxTableSyncVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据表同步记录(淞幸) Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapSxTableSyncMapper extends BaseMapper<DrapSxTableSync> {

    List<DrapSxTableSyncVo> selectVoPage(Page<DrapSxTableSyncVo> page, Map<String, Object> paramMap);

    DrapSxTableSyncVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapSxTableSync entity);

    int baseUpdate(DrapSxTableSync entity);

    int baseDelete(String id);
}