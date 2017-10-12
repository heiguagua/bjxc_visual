package com.chinawiserv.dsp.dir.controller.catalog;

import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.dir.entity.po.catalog.DrapDbTableColumn;
import com.chinawiserv.dsp.dir.mapper.catalog.CsSystemMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by lianrongfa on 2017/10/3.
 */
@Controller
@RequestMapping("/csSystem")
public class CsSystemController {
    @Autowired
    private CsSystemMapper mapper;
    /**
     * 获取项目
     */
    @RequestMapping("/selectProjectList")
    @ResponseBody
    public HandleResult selectProjectList() {
        HandleResult handleResult = new HandleResult();

        List<String> strings = mapper.selectProjectList();
        handleResult.put("list",strings);

        return handleResult;
    }

    /**
     * 根据项目获取资源
     *
     * @param project_name
     * @return
     */
    @RequestMapping("/selectSourceByProName")
    @ResponseBody
    public HandleResult selectSourceByProName(@RequestParam String project_name) {
        HandleResult handleResult = new HandleResult();
        if (StringUtils.isEmpty(project_name)) {
            handleResult.error("参数不能为空!");
        } else {
            List<String> strings = mapper.selectSourceByProName(project_name);
            handleResult.put("list",strings);
        }
        return handleResult;
    }

    /**
     * 根据资源获取表
     *
     * @param source_name
     * @return
     */
    @RequestMapping("/selectTablesBySourceName")
    @ResponseBody
    public HandleResult selectTablesBySourceName(@RequestParam String source_name) {
        HandleResult handleResult = new HandleResult();
        if (StringUtils.isEmpty(source_name)) {
            handleResult.error("参数不能为空!");
        } else {
            List<Map<String, Object>> maps = mapper.selectTablesBySourceName(source_name);
            handleResult.put("list",maps);
        }
        return handleResult;
    }

    /**
     * 根据表获取字段
     *
     * @param table_id
     * @return
     */
    @RequestMapping("/selectColumnsByTableId")
    @ResponseBody
    public HandleResult selectColumnsByTableId(@RequestParam String table_id) {
        HandleResult handleResult = new HandleResult();
        if (StringUtils.isEmpty(table_id)) {
            handleResult.error("参数不能为空!");
        } else {
            List<Map<String, Object>> strings = mapper.selectColumnsByTableId(table_id);
            handleResult.put("list",strings);
        }
        return handleResult;
    }
    
}
