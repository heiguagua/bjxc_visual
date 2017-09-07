package com.chinawiserv.dsp.base.controller.common;

import com.chinawiserv.dsp.base.enums.system.UserTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by ZS on 2017/6/9.
 */
@Controller
@RequestMapping("/enums")
public class EnumsController {


    @RequestMapping("/UserType")
    @ResponseBody
    public List<Map<String,Object>> getUserTypeList(){
        return UserTypeEnum.getEnumList();
    }

}
