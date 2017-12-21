package com.chinawiserv.dsp.dir.mapper.configure;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirHome;
import com.chinawiserv.dsp.dir.entity.po.configure.DirNews;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirHomeVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirNewsVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 新闻表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirHomeMapper extends BaseMapper<DirHome> {

    List<DirHomeVo> selectVoPage(Page<DirHomeVo> page, Map<String, Object> paramMap);

    DirHomeVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);
    
    List<DirNewsVo> selectPicBaseInfo(Map<String, Object> paramMap);
    
  //逻辑删除
    void updateDeleteFlag(String id);
    //禁用图片
    void forbid(String id);
    //启用图片
    void lancer(String id);
    
    int baseInsert(DirHome entity);

    int baseUpdate(DirHome entity);

    int baseDelete(String id);
}