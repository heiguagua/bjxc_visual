package com.chinawiserv.dsp.dir.service.catalog;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.base.service.common.ICommonService;
import com.chinawiserv.dsp.dir.entity.po.catalog.*;
import com.chinawiserv.dsp.dir.entity.vo.catalog.*;
import org.apache.poi.ss.usermodel.Sheet;

import javax.servlet.http.HttpServletRequest;
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

    Page<DirDatasetClassifyMapVo> selectRegistedClassifyMapVoPage(Map<String, Object> paramMap);

    Page<DirDatasetClassifyMapVo> selectAuditedClassifyMapVoPage(Map<String, Object> paramMap);

    Page<DirDatasetClassifyMapVo> selectReleasedClassifyMapVoPage(Map<String, Object> paramMap);

    public DrapDataset getDrapDatasetDetail(String id);

    DirDatasetSurvey selectDrapSurveyByDatasetId(String id);

    boolean checkDatasetName(String datasetName, String classifyIds);

    boolean registe(String dcmId);

    boolean audit(Map<String , Object> paramMap);

    boolean release(Map<String , Object> paramMap);

    boolean auditReject(String dcmId);

    boolean offline(String dcmId);

    boolean deleteById(String id);

    List<ExportDatasetExcel> selectExportLists(String [] tree_code, String dataset_name, String region_code);

    int insertListDataset(List<DirDataset> list);

    int transactionInsert(List<DirDataset> list, List<DirDatasetClassifyMapVo> datamapList, List<DirDataitemVo> items);

    DirDataset selectDatasetByNameAndClassifyId(String datasetName, String classifyId);
    
    
    Page<DirDatasetVo> selectDirTransferPage(Map<String, Object> paramMap);
    
    HandleResult updateDirReport(Map<String,Object> paramMap);


    boolean addDirDatasetWithOutDir(Sheet sheetAt, String regionCode, String classifyId);

    int getDatasetTotalCountForClassify(String regionCode, String classifyType);

    Map<String,Integer> getDatasetCountForClassify(String regionCode, String classifyType);

    List<Map<String,Object>> getDatasetTopCountForClassify(String regionCode, String classifyType, int topNum);

    int getDatasetTotalCount(String regionCode);

    int getServiceTotalCount(String regionCode);

    Map<String,Integer> getDatasetCountForStatus(String regionCode);

    int upLoadFile(HttpServletRequest request) throws Exception;

    DirDataRegisteVo getRegisteInfoByDcmId(String dcmId);

    DirDataAuditVo getAuditInfoByDcmId(String dcmId);

    DirDataPublishVo getReleaseInfoByDcmId(String dcmId);

    DirDataOfflineVo getOfflineInfoByDcmId(String dcmId);

    DirDatasetVo selectVoByDcmId(String dcmId);
}
