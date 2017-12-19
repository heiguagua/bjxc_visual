package com.chinawiserv.dsp.dir.mapper.configure;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirIntrude;
import com.chinawiserv.dsp.dir.entity.po.configure.DirPolicy;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirIntrudeVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirPolicyVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 政策表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirIntrudeMapper extends BaseMapper<DirIntrude> {

    List<DirIntrudeVo> selectVoPage(Page<DirIntrudeVo> page, Map<String, Object> paramMap);

    DirIntrudeVo selectVoById(String id);
    
    List<String> listExclude(Map<String, Object> paramMap);
    //逻辑删除
    void updateDeleteFlag(String id);
    
    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirIntrudeVo entity);

    int baseUpdate(DirIntrudeVo entity);

    int baseDelete(String id);
}