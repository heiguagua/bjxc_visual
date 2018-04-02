package com.chinawiserv.dsp.base.service.system;

import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptContacts;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptContactsVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;

/**
 * <p>
 * 部门联系人 服务类
 * </p>
 *
 * @author tx123
 * @since 2018-03-30
 */
public interface ISysDeptContactsService extends ICommonService<SysDeptContacts, SysDeptContactsVo> {

    List<SysDeptContacts> listBySystemId(String systemId);

    boolean insertOrUpdate(List<SysDeptContacts> list);
}
