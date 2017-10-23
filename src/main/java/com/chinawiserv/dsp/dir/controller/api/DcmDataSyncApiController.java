package com.chinawiserv.dsp.dir.controller.api;


import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.dir.service.api.IDcmDataSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * Created by tk on 2017/10/12.
 */
@RestController
@RequestMapping("dcm/data")
public class DcmDataSyncApiController {

    @Autowired
    IDcmDataSyncService dcmDataSyncService;

    @PostMapping(value = "/sync")
    public HandleResult syncData(@RequestParam Map<String, Object> param) {
        HandleResult result = new HandleResult();
        try{
            result.setState(true);
            result.setMsg("数据同步成功!");
            dcmDataSyncService.synDcmDate(param);
        }catch (Exception e){
            result.setState(false);
            result.setMsg("数据同步失败，" + e.getMessage());
        }
        return result;
    }
}
