package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetClassifyMap;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetClassifyMapVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据集目录类别关系表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDatasetClassifyMapMapper extends BaseMapper<DirDatasetClassifyMap> {

    List<DirDatasetClassifyMapVo> selectVoPage(Page<DirDatasetClassifyMapVo> page, Map<String, Object> paramMap);

    List<DirDatasetClassifyMapVo> selectVoPageForRegisted(Page<DirDatasetClassifyMapVo> page, Map<String, Object> paramMap);

    List<DirDatasetClassifyMapVo> selectVoPageForAudited(Page<DirDatasetClassifyMapVo> page, Map<String, Object> paramMap);

    List<DirDatasetClassifyMapVo> selectVoPageForReleased(Page<DirDatasetClassifyMapVo> page, Map<String, Object> paramMap);

    List<DirDatasetClassifyMapVo> baseSelect(Map<String, Object> paramMap);

    DirDatasetClassifyMapVo selectVoById(String id);

    List<DirDatasetClassifyMapVo> checkDatasetName(@Param("datasetName") String datasetName, @Param("classifyIds")String classifyIds);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetClassifyMap entity);

    int baseUpdate(DirDatasetClassifyMap entity);

    int batchUpdateStatus(Map<String, Object> paramMap);

    int baseDelete(String id);

    int flagDelete(Map<String,Object> param);

    int insertListItem(List<DirDatasetClassifyMapVo> classifyMapVoList);

    int selectDatasetTotalCountForClassify(@Param("regionCode") String regionCode, @Param("classifyType")String classifyType);

    int selectDatasetCountForClassify(String treeCode);

    List<Map<String,Object>> selectDatasetNumWithChildClassify(@Param("regionCode") String regionCode,
                              @Param("classifyType")String classifyType, @Param("topNum")int topNum);

    Map<String, Integer> selectDatasetCountForStatus(String regionCode);
}