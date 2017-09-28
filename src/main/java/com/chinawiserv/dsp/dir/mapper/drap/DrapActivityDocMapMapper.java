package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapActivityDocMap;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapActivityDocMapVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 业务活动关联资料表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapActivityDocMapMapper extends BaseMapper<DrapActivityDocMap> {

    List<DrapActivityDocMapVo> selectVoPage(Page<DrapActivityDocMapVo> page, Map<String, Object> paramMap);

    DrapActivityDocMapVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapActivityDocMap entity);

    int baseUpdate(DrapActivityDocMap entity);

    int baseDelete(String id);

	int batchInsertPO(List<DrapActivityDocMap> drapActivityDocMapPos);
}