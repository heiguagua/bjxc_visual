package com.chinawiserv.dsp.dir.service.drap;

import com.chinawiserv.dsp.dir.entity.po.drap.DrapInfoSystem;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapInfoSystemVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;

/**
 * <p>
 * 信息系统表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface IDrapInfoSystemService extends ICommonService<DrapInfoSystem, DrapInfoSystemVo> {
    public void updateAuditRebut(List<String> ids);

}
