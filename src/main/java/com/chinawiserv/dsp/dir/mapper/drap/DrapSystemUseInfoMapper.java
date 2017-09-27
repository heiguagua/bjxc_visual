package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSystemUseInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSystemUseInfoVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 信息系统使用信息 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapSystemUseInfoMapper extends BaseMapper<DrapSystemUseInfo> {

    List<DrapSystemUseInfoVo> selectVoPage(Page<DrapSystemUseInfoVo> page, Map<String, Object> paramMap);

    DrapSystemUseInfoVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapSystemUseInfo entity);

    int baseUpdate(DrapSystemUseInfo entity);

    int baseDelete(String id);
}