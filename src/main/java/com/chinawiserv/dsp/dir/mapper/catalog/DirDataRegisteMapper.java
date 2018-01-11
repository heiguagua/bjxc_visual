package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataRegiste;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataRegisteVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据注册情况表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
public interface DirDataRegisteMapper extends BaseMapper<DirDataRegiste> {

    List<DirDataRegisteVo> selectVoPage(Page<DirDataRegisteVo> page, Map<String, Object> paramMap);

    DirDataRegisteVo selectVoById(String id);

    DirDataRegisteVo selectVoByDcmId(String dcmId);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataRegiste entity);

    int baseUpdate(DirDataRegiste entity);

    int baseDelete(String id);

    int insertListData(@Param("list") List<DirDataRegisteVo> list);

    int batchUpdateActiveFlag(Map<String, Object> paramMap);
}