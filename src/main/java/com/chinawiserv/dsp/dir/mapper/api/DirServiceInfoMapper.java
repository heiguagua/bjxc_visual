package com.chinawiserv.dsp.dir.mapper.api;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.service.DirServiceInfo;
import com.chinawiserv.dsp.dir.entity.vo.service.DirServiceInfoVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 发布服务信息表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-26
 */
public interface DirServiceInfoMapper extends BaseMapper<DirServiceInfo> {

    List<DirServiceInfoVo> selectVoPage(Page<DirServiceInfoVo> page, Map<String, Object> paramMap);

    DirServiceInfoVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirServiceInfo entity);

    int baseUpdate(DirServiceInfo entity);

    int baseDelete(String id);
}