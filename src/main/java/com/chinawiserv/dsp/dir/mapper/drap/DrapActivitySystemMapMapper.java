package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivitySystemMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivitySystemMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务活动关联信息系统表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapActivitySystemMapMapper extends BaseMapper<DrapActivitySystemMap> {

    List<DrapActivitySystemMapVo> selectVoPage(Page<DrapActivitySystemMapVo> page, Map<String, Object> paramMap);

    DrapActivitySystemMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapActivitySystemMap entity);

    int baseUpdate(DrapActivitySystemMap entity);

    int baseDelete(String id);

	int batchInsertPO(List<DrapActivitySystemMap> drapActivitySystemMapPos);
}