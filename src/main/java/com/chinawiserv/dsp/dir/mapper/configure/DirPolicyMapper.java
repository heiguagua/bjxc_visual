package com.chinawiserv.dsp.dir.mapper.configure;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirPolicy;
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
public interface DirPolicyMapper extends BaseMapper<DirPolicy> {

    List<DirPolicyVo> selectVoPage(Page<DirPolicyVo> page, Map<String, Object> paramMap);

    DirPolicyVo selectVoById(String id);
    
    //逻辑删除
    void updateDeleteFlag(String id);
    
    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirPolicy entity);

    int baseUpdate(DirPolicy entity);

    int baseDelete(String id);
}