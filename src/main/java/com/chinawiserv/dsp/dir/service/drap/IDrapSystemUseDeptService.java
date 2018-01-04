package com.chinawiserv.dsp.dir.service.drap;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapSystemUseDept;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSystemUseDeptVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;

/**
 * <p>
 * 信息系统使用单位 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface IDrapSystemUseDeptService extends ICommonService<DrapSystemUseDept, DrapSystemUseDeptVo> {

    public void deleteByIds(List<String> ids);

}
