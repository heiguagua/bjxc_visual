package com.chinawiserv.dsp.dir.mapper.configure;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirDevelopApis;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirDevelopApisVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 开发者工具 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirDevelopApisMapper extends BaseMapper<DirDevelopApis> {

    List<DirDevelopApisVo> selectVoPage(Page<DirDevelopApisVo> page, Map<String, Object> paramMap);

    DirDevelopApisVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDevelopApis entity);

    int baseUpdate(DirDevelopApis entity);

    int baseDelete(String id);
}