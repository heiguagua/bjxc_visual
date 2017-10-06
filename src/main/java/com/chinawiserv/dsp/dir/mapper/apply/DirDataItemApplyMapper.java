package com.chinawiserv.dsp.dir.mapper.apply;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataItemApply;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataItemApplyVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 数据项权限申请表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDataItemApplyMapper extends BaseMapper<DirDataItemApply> {

    List<DirDataItemApplyVo> selectVoPage(Page<DirDataItemApplyVo> page, Map<String, Object> paramMap);

    DirDataItemApplyVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

}