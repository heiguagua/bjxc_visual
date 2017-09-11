package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassifyAuthority;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyAuthorityVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 目录类别控制权限表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirClassifyAuthorityMapper extends BaseMapper<DirClassifyAuthority> {

    List<DirClassifyAuthorityVo> selectVoPage(Page<DirClassifyAuthorityVo> page, Map<String, Object> paramMap);

    DirClassifyAuthorityVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirClassifyAuthority entity);

    int baseUpdate(DirClassifyAuthority entity);

    int baseDelete(String id);
}