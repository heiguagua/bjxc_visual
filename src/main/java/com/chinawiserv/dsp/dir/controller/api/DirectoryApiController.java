package com.chinawiserv.dsp.dir.controller.api;

import com.chinawiserv.dsp.base.controller.common.BaseController;
import com.chinawiserv.dsp.dir.service.api.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:目录查询相关API
 * Author:GongJun
 * Date:2017/9/19
 * Time:15:30
 * Chinawiserv Technologies Co., Ltd.
 */
@Controller
@RequestMapping("api/directory")
public class DirectoryApiController extends BaseController {
    @Autowired
    private IApiService service;
    @RequestMapping("test")
    @ResponseBody
    public List<Map<String,Object>> test(@RequestParam Map<String,Object> paramMap){
        return service.test(paramMap);
    }
}
