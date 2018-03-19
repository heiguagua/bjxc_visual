package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptContacts;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptContactsVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 部门联系人 Mapper 接口
 * </p>
 *
 * @author tx123
 * @since 2018-03-19
 */
public interface SysDeptContactsMapper extends BaseMapper<SysDeptContacts> {

    List<SysDeptContactsVo> selectVoPage(Page<SysDeptContactsVo> page, Map<String, Object> paramMap);

    SysDeptContactsVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(SysDeptContacts entity);

    int baseUpdate(SysDeptContacts entity);

    int baseDelete(String id);
}