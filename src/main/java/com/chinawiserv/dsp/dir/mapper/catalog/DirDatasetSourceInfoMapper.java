package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetSourceInfo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetSourceInfoVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 信息资源来源信息 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDatasetSourceInfoMapper extends BaseMapper<DirDatasetSourceInfo> {

    List<DirDatasetSourceInfoVo> selectVoPage(Page<DirDatasetSourceInfoVo> page, Map<String, Object> paramMap);

    DirDatasetSourceInfoVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDatasetSourceInfo entity);

    int baseUpdate(DirDatasetSourceInfo entity);

    int baseDelete(String id);

    void batchInsert(List<DirDatasetSourceInfo> dirDatasetSourceInfoList);
}