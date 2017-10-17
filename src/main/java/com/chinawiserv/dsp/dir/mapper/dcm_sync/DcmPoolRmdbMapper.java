package com.chinawiserv.dsp.dir.mapper.dcm_sync;



import java.util.List;


/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/9/19
 * Time:15:47
 * Chinawiserv Technologies Co., Ltd.
 */
public interface DcmPoolRmdbMapper {

    int insertBatch(List parameter);
    int updateBatch(List parameter);
}
