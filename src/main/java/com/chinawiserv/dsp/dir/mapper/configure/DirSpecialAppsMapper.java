package com.chinawiserv.dsp.dir.mapper.configure;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirSpecialApps;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirSpecialAppsVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 专题应用表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirSpecialAppsMapper extends BaseMapper<DirSpecialApps> {

    List<DirSpecialAppsVo> selectVoPage(Page<DirSpecialAppsVo> page, Map<String, Object> paramMap);

    DirSpecialAppsVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirSpecialApps entity);

    int baseUpdate(DirSpecialApps entity);

    int baseDelete(String id);
}