package com.chinawiserv.dsp.base.service.system;

import java.util.List;
import java.util.Map;

import com.chinawiserv.dsp.base.entity.po.system.SysRegion;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 行政区域表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-13
 */
public interface ISysRegionService extends ICommonService<SysRegion, SysRegionVo> {

    List<SysRegionVo> selectAllRegionByRegionCode(String regionCode);

    public String getAllSubRegionCodesWithSelf(String regionCode);

   /* JSONArray getRegionSelectDataList();*/

   public List<SysRegionVo> getRegionSelectDataList(Map<String, Object> paramMap) throws Exception;

    public SysRegionVo getRegionDataByCode(String regionCode) throws Exception;

    public List<String> getAllParentRegionCodes(String regionCode) throws Exception;
}
