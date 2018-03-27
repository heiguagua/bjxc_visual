package com.chinawiserv.dsp.base.service.system;

import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.entity.po.system.SysProductIntegrate;
import com.chinawiserv.dsp.base.entity.vo.system.SysIconVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysProductIntegrateVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;

/**
 * <p>
 * 产品集成表 服务类
 * </p>
 *
 * @author tx
 * @since 2017-11-07
 */
public interface ISysProductIntegrateService extends ICommonService<SysProductIntegrate, SysProductIntegrateVo> {

    String synUrl="/system/productIntegrate/postData";

    SysProductIntegrateVo getTheMaster() throws ErrorInfoException;

    SysProductIntegrateVo getTheDeptMaster() throws ErrorInfoException;

    List<SysIconVo>  selectIcon();

}
