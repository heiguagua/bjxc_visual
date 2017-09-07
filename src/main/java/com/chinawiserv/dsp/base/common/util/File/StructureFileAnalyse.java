package com.chinawiserv.dsp.base.common.util.File;

import com.alibaba.fastjson.JSONArray;
import com.chinawiserv.dsp.base.entity.po.common.excel.ExcelConfig;
import com.chinawiserv.dsp.base.entity.po.common.excel.ExcelObj;

import java.io.File;

/**
 * Created by tk on 2017/6/14.
 */
public interface StructureFileAnalyse {

    public ExcelObj analyse(File temFile, ExcelConfig excelConfig, JSONArray tableDetail) throws Exception;
}
