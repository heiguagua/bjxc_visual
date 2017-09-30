package com.chinawiserv.dsp.dir.schema;

/**
 * Created by lianrongfa on 2017/9/30.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExportExcelUtil {

    /**
     * 描述：根据文件路径获取项目中的文件
     * @param fileDir 文件路径
     * @return
     * @throws Exception
     */
    public  File getExcelDemoFile(String fileDir) throws Exception{
        String classDir = null;
        String fileBaseDir = null;
        File file = null;
        classDir = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
        fileBaseDir = classDir.substring(1);

        file = new File(fileBaseDir+fileDir);
        if(!file.exists()){
            throw new Exception("模板文件不存在！");
        }
        return file;
    }

    public  Workbook writeNewExcel(File file,String sheetName,List lis) throws Exception{
        Workbook wb = null;
        Row row = null;
        Cell cell = null;

        FileInputStream fis = new FileInputStream(file);
        wb = getWorkbook(fis, file.getName());    //获取工作薄
        Sheet sheet = wb.getSheet(sheetName);

        //循环插入数据
        int lastRow = sheet.getLastRowNum()+1;    //插入数据的数据ROW
        CellStyle cs = setSimpleCellStyle(wb);    //Excel单元格样式
        for (int i = 0; i < 10; i++) {
            row = sheet.createRow(lastRow+i); //创建新的ROW，用于数据插入

            //按项目实际需求，在该处将对象数据插入到Excel中
            /*InfoVo vo  = lis.get(i);
            if(null==vo){
                break;
            }*/
            //Cell赋值开始
            cell = row.createCell(0);
            cell.setCellValue(i);
            //cell.setCellStyle(cs);

            cell = row.createCell(1);
            cell.setCellValue(i);
            //cell.setCellStyle(cs);

            cell = row.createCell(2);
            cell.setCellValue(i);
            //cell.setCellStyle(cs);

            cell = row.createCell(3);
            cell.setCellValue(i);
            //cell.setCellStyle(cs);

            cell = row.createCell(4);
            cell.setCellValue(i);
            //cell.setCellStyle(cs);

            cell = row.createCell(5);
            cell.setCellValue(i);
            //cell.setCellStyle(cs);

            cell = row.createCell(6);
            cell.setCellValue(i);
            //cell.setCellStyle(cs);

            cell = row.createCell(7);
            cell.setCellValue(i);
            //cell.setCellStyle(cs);
        }
        return wb;
    }

    private Workbook getWorkbook(FileInputStream fis, String name) throws IOException {
        Workbook workbook=null;
        boolean isExcel2003 = name.toLowerCase().endsWith("xls")?true:false;
        if(isExcel2003){
            workbook = new HSSFWorkbook(fis);
        }else{
            workbook = new XSSFWorkbook(fis);
        }
        return workbook;
    }

    /**
     * 描述：设置简单的Cell样式
     * @return
     */
    public  CellStyle setSimpleCellStyle(Workbook wb){
        CellStyle cs = wb.createCellStyle();

        cs.setBorderBottom(CellStyle.BORDER_THIN); //下边框
        cs.setBorderLeft(CellStyle.BORDER_THIN);//左边框
        cs.setBorderTop(CellStyle.BORDER_THIN);//上边框
        cs.setBorderRight(CellStyle.BORDER_THIN);//右边框

        cs.setAlignment(CellStyle.ALIGN_CENTER); // 居中

        return cs;
    }

}
