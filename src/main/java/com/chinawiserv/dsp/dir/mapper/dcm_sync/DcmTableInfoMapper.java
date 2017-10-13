package com.chinawiserv.dsp.dir.mapper.dcm_sync;

import com.chinawiserv.dsp.base.entity.po.system.*;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbTableInfo;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/9/19
 * Time:15:47
 * Chinawiserv Technologies Co., Ltd.
 */
public interface DcmTableInfoMapper {

    int insertBatch(List parameter);
    int updateBatch(List parameter);
}
