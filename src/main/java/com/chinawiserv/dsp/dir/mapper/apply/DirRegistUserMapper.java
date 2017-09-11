package com.chinawiserv.dsp.dir.mapper.apply;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.apply.DirRegistUser;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirRegistUserVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 用户注册表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirRegistUserMapper extends BaseMapper<DirRegistUser> {

    List<DirRegistUserVo> selectVoPage(Page<DirRegistUserVo> page, Map<String, Object> paramMap);

    DirRegistUserVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirRegistUser entity);

    int baseUpdate(DirRegistUser entity);

    int baseDelete(String id);
}