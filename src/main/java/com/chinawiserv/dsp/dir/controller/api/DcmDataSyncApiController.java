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
        // TODO: 2017/10/13 进行错误信息提示，添加日志方面的东西
        dcmDataSyncService.synDcmDate(param);
        return null;
    }
}
