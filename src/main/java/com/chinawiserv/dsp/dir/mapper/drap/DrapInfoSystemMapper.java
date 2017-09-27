package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapInfoSystem;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapInfoSystemVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 信息系统表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapInfoSystemMapper extends BaseMapper<DrapInfoSystem> {

    List<DrapInfoSystemVo> selectVoPage(Page<DrapInfoSystemVo> page, Map<String, Object> paramMap);

    DrapInfoSystemVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapInfoSystem entity);

    int baseUpdate(DrapInfoSystem entity);

    int baseDelete(String id);
}