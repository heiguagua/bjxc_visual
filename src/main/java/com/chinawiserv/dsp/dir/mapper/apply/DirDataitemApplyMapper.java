package com.chinawiserv.dsp.dir.mapper.apply;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataitemApply;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataitemApplyVo;
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
public interface DirDataitemApplyMapper extends BaseMapper<DirDataitemApply> {

    List<DirDataitemApplyVo> selectVoPage(Page<DirDataitemApplyVo> page, Map<String, Object> paramMap);

    DirDataitemApplyVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataitemApply entity);

    int baseUpdate(DirDataitemApply entity);

    int baseDelete(String id);

    String selectDeptNameById(String applicationId);

}