package com.chinawiserv.dsp.dir.service.catalog;

import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassifyAuthority;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyAuthorityVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 目录类别控制权限表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
public interface IDirClassifyAuthorityService extends ICommonService<DirClassifyAuthority, DirClassifyAuthorityVo> {

    List<DirClassifyAuthorityVo> selectVoList(Map<String, Object> paramMap);

}
