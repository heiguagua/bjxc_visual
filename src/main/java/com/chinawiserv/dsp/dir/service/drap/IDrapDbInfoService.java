package com.chinawiserv.dsp.dir.service.drap;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbInfoVo;

import java.util.List;
import java.util.Map;

import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 数据库信息 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface IDrapDbInfoService extends ICommonService<DrapDbInfo, DrapDbInfoVo> {

    void receiveDbInfo(List<DrapDbInfoVo> vos);

    void receiveTableChange(Map<String, Object> map);

    void deleteDb(String id);
	
}
