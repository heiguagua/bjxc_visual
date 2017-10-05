package com.chinawiserv.dsp.dir.mapper.apply;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataApply;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataApplyVo;

import java.util.List;
import java.util.Map;

public interface DirDataApplyMapper extends BaseMapper<DirDataApply> {

    List<DirDataApplyVo> selectVoPage(Page<DirDataApplyVo> page, Map<String, Object> paramMap);

    DirDataApplyVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

}
