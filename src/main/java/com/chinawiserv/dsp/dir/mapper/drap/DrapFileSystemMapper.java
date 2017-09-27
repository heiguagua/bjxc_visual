package com.chinawiserv.dsp.dir.mapper.drap;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapFileSystem;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapFileSystemVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 文件系统表(NO) Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
public interface DrapFileSystemMapper extends BaseMapper<DrapFileSystem> {

    List<DrapFileSystemVo> selectVoPage(Page<DrapFileSystemVo> page, Map<String, Object> paramMap);

    DrapFileSystemVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DrapFileSystem entity);

    int baseUpdate(DrapFileSystem entity);

    int baseDelete(String id);
}