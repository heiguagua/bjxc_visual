package com.chinawiserv.dsp.dir.service.cs;

/**
 * Created by lixy on 2017/9/29.
 */
public interface ICsDataSyncService {

    int syncData(String type, String jsonObj) throws Exception;
}
