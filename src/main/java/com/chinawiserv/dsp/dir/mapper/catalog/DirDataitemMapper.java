package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataitem;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataitemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集对应数据项表【国】 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataitemMapper extends BaseMapper<DirDataitem> {

    List<DirDataitemVo> selectVoPage(Page<DirDataitemVo> page, Map<String, Object> paramMap);

    DirDataitemVo selectVoById(String id);

    List<DirDataitemVo> selectInfoList(Map<String, Object> paramMap);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataitem entity);

    int baseUpdate(DirDataitem entity);

    int batchUpdate(@Param("list") List<DirDataitemVo> list);

    int baseDelete(Map<String,Object> param);

    int flagDelete(Map<String,Object> param);

    /**
     * 批量新增数据项
     * @param list
     * @return
     */
    int insertListItem(@Param("list") List<DirDataitemVo> list);

    void batchInsert(List<DirDataitem> dirDataitemList);

    void deleteByDatasetId(String id);
}