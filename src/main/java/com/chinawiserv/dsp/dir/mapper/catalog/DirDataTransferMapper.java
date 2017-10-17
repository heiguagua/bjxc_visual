package com.chinawiserv.dsp.dir.mapper.catalog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDataTransfer;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDataTransferVo;
import java.util.List;
import java.util.Map;


/**
 * <p>
  * 资源目录上报信息 Mapper 接口
 * </p>
 *
 * @author wuty
 * @since 2017-10-16
 */
public interface DirDataTransferMapper extends BaseMapper<DirDataTransfer> {

    List<DirDataTransferVo> selectVoPage(Page<DirDataTransferVo> page, Map<String, Object> paramMap);

    DirDataTransferVo selectVoById(String id);

    int selectVoCount(Map<String, Object> paramMap);

    int baseInsert(DirDataTransfer entity);

    int baseUpdate(DirDataTransfer entity);

    int baseDelete(String id);
}