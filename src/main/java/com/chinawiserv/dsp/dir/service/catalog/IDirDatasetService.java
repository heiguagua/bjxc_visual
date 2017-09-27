package com.chinawiserv.dsp.dir.service.catalog;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataset;
import com.chinawiserv.dsp.dir.entity.po.catalog.DrapDatasetItem;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetClassifyMapVo;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetVo;
import com.chinawiserv.dsp.dir.entity.po.catalog.DrapDataset;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据集（信息资源） 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public interface IDirDatasetService extends ICommonService<DirDataset, DirDatasetVo> {
    List<Map<String,Object>> selectActivityByDeptId(String dept_id);

    List<Map<String,Object>> selectDatasetByActivityId(String activity_id);

    List<DrapDatasetItem> selectDatasetItemByDatasetId(String dataset_id);

    List<DrapDatasetItem> selectDatasetItemByIds(List<String> list);

    Page<DirDatasetClassifyMapVo> selectClassifyMapVoPage(Map<String, Object> paramMap);

    public DrapDataset getDrapDatasetDetail(String id);

    boolean checkDatasetName(String datasetName, String classifyIds);

    boolean registe(String dcmId);

    boolean audit(Map<String , Object> paramMap);

    boolean release(Map<String , Object> paramMap);
}
