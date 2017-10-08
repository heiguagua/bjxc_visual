package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDeptMap;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * <p>
  * 目录分类表 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
public interface DirClassifyMapper extends BaseMapper<DirClassify> {

    List<DirClassifyVo> selectVoPage(Page<DirClassifyVo> page, Map<String, Object> paramMap);

    List<DirClassifyVo> selectVoListForTreeData(Map<String, Object> paramMap);

    DirClassifyVo selectVoById(String id);
    
//    String selectClassifyCodebyFid(String fid);
//    
//    int selectClassifyLevelbyFid(String fid);
//    
//    int selectClassifyIndexbyFid(String fid);
    
    void updateClassifyIndexbyFid(String fid);
    
    int selectCountLevel1();
    
    DirClassify selectFclassify(String fid);
    
//    String selectClassifyStructureNamebyFid(String fid);
    
  //逻辑删除
    
    void  updateDeleteFlag(String classifyCode);
    
    List<DirClassifyVo> getCatelogByParentCode(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirClassify entity);

    int baseUpdate(DirClassify entity);

    int baseDelete(String id);

    Set<String> selectClassifyByIds(@Param("arr")String [] arr);

    public String selectClassifyByStructrue(@Param("structure") String structure);

}