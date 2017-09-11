package com.chinawiserv.dsp.dir.mapper.configure;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirNews;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirNewsVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 新闻表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirNewsMapper extends BaseMapper<DirNews> {

    List<DirNewsVo> selectVoPage(Page<DirNewsVo> page, Map<String, Object> paramMap);

    DirNewsVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirNews entity);

    int baseUpdate(DirNews entity);

    int baseDelete(String id);
}