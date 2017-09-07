package com.chinawiserv.dsp.base.common.util.File.impl;

import com.alibaba.fastjson.JSONArray;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.File.CsvReader;
import com.chinawiserv.dsp.base.common.util.File.FileCommon;
import com.chinawiserv.dsp.base.common.util.File.FileUtil;
import com.chinawiserv.dsp.base.common.util.File.StructureFileAnalyse;
import com.chinawiserv.dsp.base.entity.po.common.excel.ExcelConfig;
import com.chinawiserv.dsp.base.entity.po.common.excel.ExcelObj;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tk on 2017/6/14.
 */
@Component("csv")
public class CsvAnalyse implements StructureFileAnalyse {

    @Override
    public ExcelObj analyse(File temFile, ExcelConfig excelConfig,JSONArray tableDetail) throws Exception {

//        CsvReader csvReader = new CsvReader(tempFile);
        String tempFilePath = temFile.toString();
        File file = null;
        if(StringUtils.isNotBlank(tempFilePath)){
            file = new File(tempFilePath);
        }
        if(file != null) {
            String fileName = file.getAbsolutePath();
            CsvReader csvReader = new CsvReader(fileName, FileCommon.COMMA, Charset.forName(FileUtil.codeString(fileName)));
            ExcelObj excelObj = new ExcelObj();
            if (csvReader != null) {
                if (csvReader.readHeaders()) {
                    List<String[]> allRecords = new ArrayList<String[]>();//所有的数据
                    Map<String, String> titleMaper = new HashMap<String, String>();
                    Map<String, String> headerMaper = new HashMap<String, String>();//字段备注行
                    List<Map<String, String>> listValuer = new ArrayList<Map<String, String>>();
                    List<String> colPosition = new ArrayList<String>();

                    String[] clone = csvReader.getHeaders();//第一行数据
                    if (clone == null) {
                        throw new Exception(" 文件无数据！");
                    }
                    allRecords.add(clone);
                    int titleRownum = CommonUtil.stringToInt(excelConfig.getTitleRownum()) - 1;
                    int fieldRownum = CommonUtil.stringToInt(excelConfig.getFieldRownum()) - 1;
                     List<Integer> contentColsRange = FileUtil.getRangeIntList("1-", clone.length);

                    for (int i = 0; i < clone.length; i++) {
                        if (contentColsRange.contains(i)) {
                            colPosition.add(i + "");
                        }
                    }
                    //csv解析内容行赋值
                    int rowNum = 1;
                    while (csvReader.readRecord()) {
                        String[] value = csvReader.getValues();
                        allRecords.add(value);
                        rowNum++;
                    }
                    List<Integer> contentRowsRange = FileUtil.getRangeIntList(excelConfig.getContentRowsRange(), rowNum);
                    for (int i = 0; i < allRecords.size(); i++) {
                        String[] value = allRecords.get(i);
                        if (titleRownum == i) {
                            for (int j = 0; j < value.length; j++) {
                                if (contentColsRange.contains(j)) {
                                    titleMaper.put(j + "", value[j]);
                                }
                            }
                        } else if (fieldRownum == i) {
                            for (int j = 0; j < value.length; j++) {
                                if (contentColsRange.contains(j)) {
                                    headerMaper.put(j + "", value[j]);
                                }
                            }
                        } else if (contentRowsRange.contains(i)) {
                            Map<String, String> valueList = new HashMap<String, String>();
                            for (int j = 0; j < value.length; j++) {
                                if (contentColsRange.contains(j)) {
                                    valueList.put(j + "", value[j]);
                                }
                            }
                            listValuer.add(valueList);
                        }
                    }
                    csvReader.close();
                    excelObj.setTitleMaper(titleMaper);
                    excelObj.setHeaderMaper(headerMaper);
                    excelObj.setList(listValuer);
                    excelObj.setColPosition(colPosition);
                    excelObj.setColunmType(new HashMap<String, String>());
                    excelObj.setStatus(true);
                }
            }
            excelObj.setExcelConfig(excelConfig);
            //excelObj.setFileAliasName(fileAliasName);
            //FileUtil.deleteDirs(file);
            if (excelObj.getList() != null) {
                return excelObj;
            } else {
                //clearTempAttributeFromSession(request);
                return null;
            }
        }
        return  null;
    }
}
