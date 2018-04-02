package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysRegion;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * <p>
  * 行政区域表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-13
 */
public interface SysRegionMapper extends BaseMapper<SysRegion> {

    List<SysRegionVo> selectVoPage(Page<SysRegionVo> page, Map<String, Object> paramMap);

    SysRegionVo selectVoById(String id);

    SysRegionVo selectVoByCode(@Param("regionCode")String regionCode);

    SysRegionVo selectVoByRegionCode(@Param("regionCode")String regionCode);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysRegion entity);

    int baseUpdate(SysRegion entity);

    int baseDelete(String id);

    List<SysRegionVo> selectAllRegionByRegionCode(@Param("regionCodeCondition") String regionCode);

    List<SysRegionVo> selectVoListForTreeData(Map<String, Object> paramMap);

    Integer deleteBatchRegionByIds(List<String> ids);

    void initTopDept(String regionCode);

    List<SysRegion> listBySystemId(String systemId);

    List<SysRegion> listByList(List<String> list);

    List<String> listIdsByList(List<String> list);

    long batchInsert(List<SysRegion> list);
}