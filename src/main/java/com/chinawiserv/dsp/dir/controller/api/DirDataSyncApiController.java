package com.chinawiserv.dsp.dir.controller.api;

import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.dir.service.cs.ICsDataSyncService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * Created with IntelliJ IDEA
 * Description:目录数据同步
 * Author:lixy
 * Date:2017/9/29.
 * Time:15:31
 * Chinawiserv Technologies Co., Ltd.
 */
@RestController
@RequestMapping("api/data")
public class DirDataSyncApiController {

    @Autowired
    private ICsDataSyncService csDataSyncService;

    Logger logger = LoggerFactory.getLogger(DirDataSyncApiController.class);

    /**
     * 目录 数据同步
     * <p>
     * type 类型（collect：抓取、mapping：映射）
     * data json数据
     *
     * @return
     */
    @RequestMapping(value = "/sync", method = RequestMethod.POST)
    public HandleResult syncData(@RequestParam Map<String, Object> param) {
        HandleResult result = new HandleResult();
        String type = "";
        String data = "";
        if (param != null && !param.isEmpty()) {
            type = param.get("type") != null ? param.get("type").toString() : "";
            data = param.get("data") != null ? param.get("data").toString() : "";
            if (StringUtils.isEmpty(type) || StringUtils.isEmpty(data)) {
                result.setState(false);
                result.setMsg("参数不合法!");
            } else {
                try {
                    csDataSyncService.syncData(type, data);
                    result.setState(true);
                    result.setMsg("数据同步成功!");
                } catch (Exception e) {
                    logger.warn(e.getMessage());
                    result.setState(false);
                    result.setMsg("系统错误!");
                }
            }
        } else {
            result.setState(false);
            result.setMsg("参数不能为空!");
        }
        return result;
    }

}
