package com.chinawiserv.dsp.dir.schema;

/**
 * Created by lianrongfa on 2017/9/30.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import com.chinawiserv.dsp.base.common.util.DateTimeUtils;
import com.chinawiserv.dsp.dir.entity.po.catalog.ExportDatasetExcel;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExportExcelUtil {

    /**
     * 描述：根据文件路径获取项目中的文件
     * @param fileDir 文件路径
     * @return
     * @throws Exception
     */
    public  File getExcelDemoFile(String fileDir) throws Exception{
        File  file = new File(fileDir);
        if(!file.exists()){
            throw new Exception("模板文件不存在！");
        }
        return file;
    }

    public  Workbook writeNewExcel(File file,String sheetName,List<ExportDatasetExcel> list,String regionCode) throws Exception{
//        Workbook wb = null;
        SXSSFWorkbook wb = null;
        Row row = null;
        Cell cell = null;

        FileInputStream fis = new FileInputStream(file);
//        wb = getWorkbook(fis, file.getName());    //获取工作薄
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
        XSSFSheet readSheet = xssfWorkbook.getSheet(sheetName);
        wb = new SXSSFWorkbook(xssfWorkbook,500);
        SXSSFSheet sheet = wb.getSheet(sheetName);

        //循环插入数据
        int lastRow = readSheet.getLastRowNum()+1;    //插入数据的数据ROW
        //CellStyle cs = setSimpleCellStyle(wb);    //Excel单元格样式
        int i=0;
        for (ExportDatasetExcel info:list) {
            row = sheet.createRow(lastRow+i); //创建新的ROW，用于数据插入

            //按项目实际需求，在该处将对象数据插入到Excel中
            if(null==info){
                break;
            }
            //Cell赋值开始
            String structureName = info.getClassify_structure_name();
            if(StringUtils.isNotEmpty(structureName)){
                String[] split = structureName.split("->");
                for (int j=0;j<split.length;j++){
                    cell = row.createCell(j);
                    cell.setCellValue(split[j]);
                    //cell.setCellStyle(cs);
                }
            }
            cell = row.createCell(26);//数据集名称
            cell.setCellValue(info.getDataset_name());
            cell = row.createCell(27);//信息资源代码
            cell.setCellValue(info.getDataset_code());
            if(Objects.equals(regionCode, info.getRegion_code())) {
                cell = row.createCell(28);//信息资源提供方
                cell.setCellValue(info.getRegion_dept_name());
                cell = row.createCell(29);//资源提供方部门
                cell.setCellValue(info.getBelong_dept_name());
            }else{
                cell = row.createCell(28);//信息资源提供方改为数据所属行政区域
                cell.setCellValue(info.getRegion_name());
                if(StringUtils.isNotEmpty(info.getRegion_dept_name())){
                    cell = row.createCell(29);//资源提供方部门值改为资源提供方的值
                    cell.setCellValue(info.getRegion_dept_name());
                }else{
                    cell = row.createCell(29);//资源提供方部门改为上级部门
                    cell.setCellValue(info.getFname());
                }
            }
            cell = row.createCell(30);//资源提供方代码
            cell.setCellValue(info.getBelong_dept_no());

            cell = row.createCell(31);//描述
            cell.setCellValue(info.getDataset_desc());

            cell = row.createCell(32);//信息资源格式
            cell.setCellValue(info.getFormat_category());
            cell = row.createCell(33);
            cell.setCellValue(info.getFormat_type());

            cell = row.createCell(35);
            cell.setCellValue(info.getTotal_storage());
            cell = row.createCell(36);
            cell.setCellValue(info.getStructure_count());
            cell = row.createCell(37);
            cell.setCellValue(info.getShared_storage());
            cell = row.createCell(38);
            cell.setCellValue(info.getShared_structure_count());
            cell = row.createCell(39);
            cell.setCellValue(info.getOpened_storage());
            cell = row.createCell(40);
            cell.setCellValue(info.getOpened_structure_count());

            cell = row.createCell(41);
            cell.setCellValue(info.getItem_name());

            cell = row.createCell(42);
            cell.setCellValue(info.getItem_type());

            cell = row.createCell(43);
            cell.setCellValue(info.getItem_length());

            cell = row.createCell(44);
            cell.setCellValue(info.getShare_type());

            cell = row.createCell(45);
            cell.setCellValue(info.getShare_condition());

            cell = row.createCell(46);
            cell.setCellValue(info.getShare_method_category());

            cell = row.createCell(47);
            cell.setCellValue(info.getShare_method());

            cell = row.createCell(48);
            cell.setCellValue(info.getIs_open());

            cell = row.createCell(49);
            cell.setCellValue(info.getOpen_condition());

            cell = row.createCell(50);
            cell.setCellValue(info.getUpdate_frequency());

            cell = row.createCell(51);
            cell.setCellValue(DateTimeUtils.convertDateTime_YYYYMMDD_SLASHES(info.getCreate_time()));
            i++;
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

        /*cs.setBorderBottom(CellStyle.BORDER_THIN); //下边框
        cs.setBorderLeft(CellStyle.BORDER_THIN);//左边框
        cs.setBorderTop(CellStyle.BORDER_THIN);//上边框
        cs.setBorderRight(CellStyle.BORDER_THIN);//右边框

        cs.setAlignment(CellStyle.ALIGN_CENTER); // 居中*/

        return cs;
    }

}
