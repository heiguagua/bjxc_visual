package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataOffline;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataOfflineVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据下架情况 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataOfflineMapper extends BaseMapper<DirDataOffline> {

    List<DirDataOfflineVo> selectVoPage(Page<DirDataOfflineVo> page, Map<String, Object> paramMap);

    DirDataOfflineVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataOffline entity);

    int baseUpdate(DirDataOffline entity);

    int baseDelete(String id);
}