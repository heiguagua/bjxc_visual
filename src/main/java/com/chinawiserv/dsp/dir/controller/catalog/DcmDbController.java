package com.chinawiserv.dsp.dir.controller.catalog;

import com.chinawiserv.dsp.base.entity.po.common.response.HandleResult;
import com.chinawiserv.dsp.dir.entity.po.catalog.DcmDbTableColumn;
import com.chinawiserv.dsp.dir.mapper.catalog.DcmDbMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by lianrongfa on 2017/10/11.
 */
@Controller
@RequestMapping("/DcmDb")
public class DcmDbController {
    @Autowired
    private DcmDbMapper dcmDbMapper;

    /**
     * 根据部门获取数据库
     *
     * @param dept_id
     * @return
     */
    @RequestMapping("/selectDbByDeptId")
    @ResponseBody
    public HandleResult selectDbByDeptId(@RequestParam String dept_id) {
        HandleResult handleResult = new HandleResult();
        if (StringUtils.isEmpty(dept_id)) {
            handleResult.error("参数不能为空!");
        } else {
            List<Map<String, Object>> maps = dcmDbMapper.selectDbByDeptId(dept_id);
            handleResult.put("list",maps);
        }
        return handleResult;
    }

    /**
     * 根据数据库获取表
     *
     * @param db_id
     * @return
     */
    @RequestMapping("/selectTableByDbId")
    @ResponseBody
    public HandleResult selectTableByDbId(@RequestParam String db_id) {
        HandleResult handleResult = new HandleResult();
        if (StringUtils.isEmpty(db_id)) {
            handleResult.error("参数不能为空!");
        } else {
            List<Map<String, Object>> maps = dcmDbMapper.selectTableByDbId(db_id);
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
    @RequestMapping("/selectFieldByTableId")
    @ResponseBody
    public HandleResult selectFieldByTableId(@RequestParam String table_id) {
        HandleResult handleResult = new HandleResult();
        if (StringUtils.isEmpty(table_id)) {
            handleResult.error("参数不能为空!");
        } else {
            List<Map<String, Object>> maps = dcmDbMapper.selectFieldByTableId(table_id);
            handleResult.put("list",maps);
        }
        return handleResult;
    }

    /**
     * 根据字段ids获取字段
     *
     * @param list
     * @return
     */
    @RequestMapping("/selectFieldByIds")
    @ResponseBody
    public HandleResult selectFieldByIds(@RequestParam String[] list) {
        HandleResult handleResult = new HandleResult();
        if (list==null || list.length==0) {
            handleResult.error("参数不能为空!");
        } else {
            List<DcmDbTableColumn> tableColumns = dcmDbMapper.selectFieldByIds(list);
            handleResult.put("list",tableColumns);
        }
        return handleResult;
    }
}
