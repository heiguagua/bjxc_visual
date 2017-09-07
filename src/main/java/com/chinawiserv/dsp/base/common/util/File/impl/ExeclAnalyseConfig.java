package com.chinawiserv.dsp.base.common.util.File.impl;

import com.alibaba.fastjson.JSONArray;
import com.chinawiserv.dsp.base.common.util.File.FileCommon;
import com.chinawiserv.dsp.base.common.util.File.ReadExcel;
import com.chinawiserv.dsp.base.common.util.File.StructureFileAnalyse;
import com.chinawiserv.dsp.base.entity.po.common.excel.ExcelConfig;
import com.chinawiserv.dsp.base.entity.po.common.excel.ExcelObj;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tk on 2017/6/14.
 */

@Configuration
public class ExeclAnalyseConfig {

    @Bean(name = {"xls", "xlsx"})
    StructureFileAnalyse xslProcess(){
        return new ExcelAnalyse();
    }
}

class ExcelAnalyse implements StructureFileAnalyse {

    @Override
    public ExcelObj analyse(File temFile, ExcelConfig excelConfig,JSONArray tableDetail) throws Exception {

          //取一次表明：（已经没有必要了）
//        ReadExcel readExcel = new ReadExcel(temFile, excelConfig.getSheetName());
//        Map<String, String> sheetMap = readExcel.getSheetNameMap();
//        Assert.isTrue("-1".equals(sheetMap.get("index")), "该文件不存在sheeName为" + sheetMap.get("sheetName") + "的sheet！");
//        excleConfig.setSheetName(sheetMap.get("sheetName"));
        ExcelObj excelObj = new ExcelObj();
        ReadExcel reader = null;
        String temFilePath = temFile.toString();
        File file = new File(temFilePath);
        if (StringUtils.isNotBlank(temFilePath)) {
            if (tableDetail != null && tableDetail.size() > 0){
                //有tableDetail参数的情况
                reader = new ReadExcel(file, excelConfig, tableDetail);
            }else {
                //没有tableDetail参数的情况
                excelConfig.setPreviewCount(FileCommon.PreviewCount);
                reader = new ReadExcel(file, excelConfig);
            }
            if (reader.getValuer().size() > 0) {
                //处理类型：
                Map<String,Integer> jdbcColumnType = reader.getColunmType();
                Map<String,String> jdbcColumnTypeStr = new LinkedHashMap<>();
                for (String key:jdbcColumnType.keySet()){
                    jdbcColumnTypeStr.put(key, jdbcColumnType.get(key).toString());
                }
                excelObj.setTitleMaper(reader.getTitleMaper());
                excelObj.setHeaderMaper(reader.getHeaderMaper());
                excelObj.setList(reader.getValuer());
                excelObj.setColunmType(jdbcColumnTypeStr);//添加列类型
                excelObj.setColPosition(reader.getColPosition());
                excelObj.setStatus(true);
                excelObj.setTableName(excelConfig.getSheetName() + "_" + System.currentTimeMillis());
            }
            excelObj.setExcelConfig(excelConfig);
            //excelObj.setFileAliasName(fileName);
            return excelObj;
        }

        return null;

    }
}
