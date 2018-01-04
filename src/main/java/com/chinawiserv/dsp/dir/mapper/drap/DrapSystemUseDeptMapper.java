package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSystemUseDept;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSystemUseDeptVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 信息系统使用单位 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapSystemUseDeptMapper extends BaseMapper<DrapSystemUseDept> {

    List<DrapSystemUseDeptVo> selectVoPage(Page<DrapSystemUseDeptVo> page, Map<String, Object> paramMap);

    DrapSystemUseDeptVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapSystemUseDept entity);

    int baseUpdate(DrapSystemUseDept entity);

    int baseDelete(String id);

    void deleteByIds(List<String> ids);
}