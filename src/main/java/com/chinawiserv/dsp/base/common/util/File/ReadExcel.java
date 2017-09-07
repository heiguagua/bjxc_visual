package com.chinawiserv.dsp.base.common.util.File;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.DateTimeUtils;
import com.chinawiserv.dsp.base.entity.po.common.excel.ExcelConfig;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.*;


/**
 * Created by Administrator on 2016/3/14 0014.
 * 构建column如下：
 * "column":[
			 {
			 "colPosition":"",
			 "type":""
			 },
			 ...
			 ]
 */
public class ReadExcel {

	public enum DataXColumnType{
		LONG("long"),
		DOUBLE("double"),
		DATE("date"),
		BOOLEAN("boolean"),
		BYTES("bytes"),
		STRING("string");

		String value;

		DataXColumnType(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		public static DataXColumnType toDataCollectModeEum(String modeName) {
			for (DataXColumnType mode : DataXColumnType.values()) {
				if (mode.getValue().equals(modeName)) {
					return mode;
				}
			}
			throw new RuntimeException("no such mode :" + modeName);
		}
	}

	private static final Log LOG = LogFactory.getLog(ReadExcel.class);
	private static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
	private static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

	private static final String EMPTY = "";
	private static final String POINT = ".";

	private static final String COLUMN_POSITION ="colPosition";//列位置
	private static final String COLUMN_TYPE = "type";//列类型

	private List<String[]> title = new ArrayList<String[]>();
	private Map<String, String> titleMaper = new LinkedHashMap<>();//字段英文行(位置映射)
	private Map<String, String> headerMaper = new LinkedHashMap<String, String>();//字段备注行(位置映射)
	private List<Map<String, String>> valuer = new ArrayList<Map<String, String>>();//内容(位置字母映射)
	private List<Map<Integer, String>> valuerMaper = new ArrayList<Map<Integer, String>>();//内容(位置索引映射)
	private Map<String, Integer> colunmType = new LinkedHashMap<String, Integer>();//jdbc列类型
//	private Map<String, String> colunmDataXType = new LinkedHashMap<String, String>();//dataX列类型
	private Map<String, String> colunmLength = new LinkedHashMap<String, String>();

	public List<String[]> getTitle() {
		return title;
	}

	private List<String> colPosition = new ArrayList<String>();//列位置(与表结构顺序对应)
	private Map<Integer, String> colPositionMaper = new LinkedHashMap<Integer, String>();

	private DataFormatter dataFormatter = new DataFormatter(true);
	private StringBuffer columnError = new StringBuffer();

	private Map<String, String> sheetNameMap = new LinkedHashMap<String, String>();

	public Map<String, String> getTitleMaper() {
		return titleMaper;
	}

	public Map<String, String> getHeaderMaper() {
		return headerMaper;
	}

	public List<Map<Integer, String>> getValuerMaper() {
		return valuerMaper;
	}

	public List<Map<String, String>> getValuer() {
		return this.valuer;
	}

//    public List<String[]> getTitle() {
//        return title;
//    }


	public Map<String, Integer> getColunmType() {
		return colunmType;
	}

	public Map<String, String> getColunmLength() {
		return colunmLength;
	}

	public List<String> getColPosition() {
		return colPosition;
	}

	public void setColPosition(List<String> colPosition) {
		this.colPosition = colPosition;
	}

	public Map<Integer, String> getColPositionMaper() {
		return colPositionMaper;
	}

	public void setColPositionMaper(Map<Integer, String> colPositionMaper) {
		this.colPositionMaper = colPositionMaper;
	}

	public Map<String, String> getSheetNameMap() {
		return sheetNameMap;
	}

	public ReadExcel() {
	}

	public ReadExcel(File file) {
		try {
			readExcel(file.getPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ReadExcel(File file, String sheetName) throws IOException, ErrorInfoException {
		sheetNameMap = readExcel(file.getPath(), sheetName);
	}

	public ReadExcel(File file, ExcelConfig excelConfig, JSONArray column) throws Exception {
		readExcel(file.getPath(), excelConfig, column);
	}

	public ReadExcel(File file, ExcelConfig excelConfig) throws Exception {
		readExcel(file.getPath(), excelConfig, null);
	}

	public List<Map<String, String>> readExcel(String path) throws IOException {
		if (path == null || EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = getPostfix(path);
			if (!EMPTY.equals(postfix)) {
				if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(path);
				} else if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx(path);
				}
			} else {
				return null;
			}
		}
		return null;
	}

	public Map<String, String> readExcel(String path, String sheetName) throws IOException, ErrorInfoException {
		InputStream is = null;
		try {
			is = new FileInputStream(path);
			Workbook workbook = null;
			Sheet sheet = null;
			if (path == null || EMPTY.equals(path)) {
				return null;
			} else {
				String postfix = getPostfix(path);
				if (!EMPTY.equals(postfix)) {
					if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
						workbook = new HSSFWorkbook(is);
						return getSheetNameMap(workbook, sheetName);
					} else if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
						workbook = new XSSFWorkbook(is);
						return getSheetNameMap(workbook, sheetName);
					}
				} else {
					return null;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} catch (ErrorInfoException e) {
			e.printStackTrace();
			throw e;
		} finally {
			IOUtils.closeQuietly(is);
		}

		return null;
	}

	public List<Map<String, String>> readExcel(String path, ExcelConfig excelConfig, JSONArray column) throws Exception {
		InputStream is = new FileInputStream(path);
		Workbook workbook = null;
		FormulaEvaluator formulaEvaluator = null;
		Sheet sheet = null;
		if (path == null || EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = getPostfix(path);
			if (!EMPTY.equals(postfix)) {
				if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					workbook = new HSSFWorkbook(is);
					formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
					sheet = getSheet(workbook, excelConfig.getSheetName());//在此处 将sheet传入到具体方法内方法定义为read(Sheet sheet, ExcelConfig excelConfig, JSONArray column),或read(Sheet sheet, ExcelConfig excelConfig);
				} else if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					workbook = new XSSFWorkbook(is);
					formulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
					sheet = getSheet(workbook, excelConfig.getSheetName());
				}
				readXlsOrXlsx(is, sheet, excelConfig, column, formulaEvaluator);
			} else {
				return null;
			}
		}
		return null;
	}

	public ReadExcel(InputStream is, String fileName, ExcelConfig excelConfig, JSONArray column) throws Exception {
		Workbook workbook = null;
		FormulaEvaluator formulaEvaluator = null;
		Sheet sheet = null;
		if (is == null) {
			throw new ErrorInfoException("输入流不能为空！");
		} else {
			String postfix = getPostfix(fileName);
			if (!EMPTY.equals(postfix)) {
				if (OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					workbook = new HSSFWorkbook(is);
					formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
					sheet = getSheet(workbook, excelConfig.getSheetName());//在此处 将sheet传入到具体方法内方法定义为read(Sheet sheet, ExcelConfig excelConfig, JSONArray column),或read(Sheet sheet, ExcelConfig excelConfig);
				} else if (OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					workbook = new XSSFWorkbook(is);
					formulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
					sheet = getSheet(workbook, excelConfig.getSheetName());
				}
				readXlsOrXlsx(is, sheet, excelConfig, column, formulaEvaluator);
			}
		}
	}


	public List<Map<String, String>> readXlsOrXlsx(InputStream is, Sheet sheet, ExcelConfig excelConfig, JSONArray column, FormulaEvaluator formulaEvaluator) throws Exception {
		if (column == null) {
			return readSheetByPreview(is, sheet, excelConfig, formulaEvaluator);
		} else {
			return readSheetByColumn(is, sheet, excelConfig, column, formulaEvaluator);
		}
	}

	/**
	 * Read the Excel 2010
	 *
	 * @param path the path of the excel file
	 * @return
	 * @throws java.io.IOException
	 */
	public List<Map<String, String>> readXlsx(String path) throws IOException {
		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		FormulaEvaluator formulaEvaluator = new XSSFFormulaEvaluator(xssfWorkbook);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		int numSheet = 0;
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
		if (xssfSheet != null) {
			for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow == null) {
					continue;
				}
				if (rowNum == 0) {
//                    String[] strings=new String[xssfRow.getLastCellNum()];
					for (int cellNum = 0; cellNum < xssfRow.getLastCellNum(); cellNum++) {
						XSSFCell xssfCell = xssfRow.getCell(cellNum);
						if (xssfCell == null) {
							continue;
						}
						titleMaper.put(cellNum + "", getValue(xssfCell, formulaEvaluator));
					}
				} else {
					Map<String, String> map = new LinkedHashMap<String, String>();
					for (int cellNum = 0; cellNum < xssfRow.getLastCellNum(); cellNum++) {
						XSSFCell xssfCell = xssfRow.getCell(cellNum);
						if (xssfCell == null) {
							continue;
						}
						String key = titleMaper.get(cellNum + "");
						if (StringUtils.isNotBlank(key)) {
							map.put(key, getValue(xssfCell, formulaEvaluator));
						}
					}
					list.add(map);
				}
			}
		}
		is.close();
		valuer = list;
		return list;
	}

	/**
	 * Read the Excel 2003-2007
	 *
	 * @param path the path of the Excel
	 * @return List
	 * @throws java.io.IOException
	 */
	public List<Map<String, String>> readXls(String path) throws IOException {
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		FormulaEvaluator formulaEvaluator = new HSSFFormulaEvaluator(hssfWorkbook);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		int numSheet = 0;
		HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
		if (hssfSheet != null) {
			for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow == null) {
					continue;
				}
				if (rowNum == 0) {
					for (int cellNum = 0; cellNum < hssfRow.getLastCellNum(); cellNum++) {
						HSSFCell hssfCell = hssfRow.getCell(cellNum);
						if (hssfCell == null) {
							continue;
						}
						titleMaper.put(cellNum + "", getValue(hssfCell, formulaEvaluator));
					}
				} else {
					Map<String, String> map = new LinkedHashMap<String, String>();
					for (int cellNum = 0; cellNum < hssfRow.getLastCellNum(); cellNum++) {
						HSSFCell hssfCell = hssfRow.getCell(cellNum);
						if (hssfCell == null) {
							continue;
						}
						String key = titleMaper.get(cellNum + "");
						if (StringUtils.isNotBlank(key)) {
							map.put(key, getValue(hssfCell, formulaEvaluator));
						}
					}
					list.add(map);
				}
			}
		}
		is.close();
		valuer = list;
		return list;
	}

	//按表结构解析sheet的内容
	public List<Map<String, String>> readSheetByColumn(InputStream is, Sheet sheet, ExcelConfig excelConfig, JSONArray column, FormulaEvaluator formulaEvaluator) throws Exception {
		int titleRownum = CommonUtil.stringToInt(excelConfig.getTitleRownum()) - 1;
		int fieldRownum = CommonUtil.stringToInt(excelConfig.getFieldRownum()) - 1;
		int firstRowNum = getFirstRowNum(excelConfig.getContentRowsRange());
		List<Integer> contentRowsRange = getRangeIntList(excelConfig.getContentRowsRange(), sheet, firstRowNum);
//        List<Integer> contentColsRange = getRangeIntList(excelConfig.getContentColsRange(),sheet,firstRowNum);
		List<Integer> contentColsRange = getPosition(null, column);

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		if (sheet != null) {
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
				Row row = sheet.getRow(rowNum);
				if (row == null) {
					continue;
				}
				if (rowNum == titleRownum) {
					readTitle(row, contentColsRange, formulaEvaluator);
				} else if (rowNum == fieldRownum) {
					readField(row, contentColsRange, formulaEvaluator);
				} else if (contentRowsRange.contains(rowNum)) {
					list.add(readContent(row, contentColsRange, column, formulaEvaluator));
				}
			}
		} else {
			throw new ErrorInfoException("该EXCEL文件不存在这个SheetName！");
		}
		is.close();
		valuer = list;
		return list;
	}

	//解析sheet的预览内容
	public List<Map<String, String>> readSheetByPreview(InputStream is, Sheet sheet, ExcelConfig excelConfig, FormulaEvaluator formulaEvaluator) throws Exception {
		int titleRownum = CommonUtil.stringToInt(excelConfig.getTitleRownum()) - 1;
		int fieldRownum = CommonUtil.stringToInt(excelConfig.getFieldRownum()) - 1;
		int firstRowNum = getFirstRowNum(excelConfig.getContentRowsRange());
		List<Integer> contentRowsRange = getRangeIntList(excelConfig.getContentRowsRange(), sheet, firstRowNum);
//        List<Integer> contentColsRange = getRangeIntList(excelConfig.getContentColsRange(),sheet,firstRowNum);
		List<Integer> contentColsRange = getRangeIntList("A-", sheet, firstRowNum);
		int previewCount = CommonUtil.stringToInt(excelConfig.getPreviewCount());
		contentRowsRange = getAnalysisContentRowsRange(contentRowsRange, previewCount);//需要解析的行内容（如果预览不为0，那么解析后得到字段类型，如果为零 则按照字段类型解析字段）

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		if (sheet != null) {
			getPosition(contentColsRange, null);
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
				Row row = sheet.getRow(rowNum);
				if (row == null) {
					continue;
				}
				if (rowNum == titleRownum) {
					readTitle(row, contentColsRange, formulaEvaluator);
				} else if (rowNum == fieldRownum) {
					readField(row, contentColsRange, formulaEvaluator);
				} else if (contentRowsRange.contains(rowNum)) {
					list.add(readContent(row, contentColsRange, null, formulaEvaluator));
				}
			}
		} else {
			throw new ErrorInfoException("该EXCEL文件不存在这个SheetName！");
		}
		is.close();
		valuer = list;
		return list;
	}

	private void readTitle(Row row, List<Integer> contentColsRange, FormulaEvaluator formulaEvaluator) throws ErrorInfoException {
		int lastCellNum = row.getLastCellNum();
		for (int i : contentColsRange) {
			if (i < lastCellNum) {
				Cell cell = row.getCell(i);
				if (cell == null) {
					titleMaper.put(getColumnCharName(i), null);
					continue;
				}
				String cellValue = getValue(cell, formulaEvaluator);
				titleMaper.put(getColumnCharName(i), cellValue);
			}
		}
	}

	private void readField(Row row, List<Integer> contentColsRange, FormulaEvaluator formulaEvaluator) {
		int lastCellNum = row.getLastCellNum();
		for (int i : contentColsRange) {
			if (i < lastCellNum) {
				Cell cell = row.getCell(i);
				if (cell == null) {
					headerMaper.put(getColumnCharName(i), null);
					continue;
				}
				String cellValue = getValue(cell, formulaEvaluator);
				headerMaper.put(getColumnCharName(i), cellValue);
			}
		}
	}

	private Map<String, String> readContent(Row row, List<Integer> contentColsRange, JSONArray column, FormulaEvaluator formulaEvaluator) throws ErrorInfoException {
		Map<String, String> map = new LinkedHashMap<String, String>();
		Map<Integer, String> mapValue = new LinkedHashMap<Integer, String>();
		int titleIndex = 0;
		int lastCellNum = row.getLastCellNum();
		for (int i : contentColsRange) {
			if (i < lastCellNum) {
				Cell cell = row.getCell(i);
				if (cell == null) {
					map.put(getColumnCharName(i), null);
					mapValue.put(titleIndex, null);
					titleIndex++;
					continue;
				}
				String cellValue = null;
				if (column != null) {
					JSONObject jsonObject = (JSONObject) (column.get(titleIndex));
					cellValue = getValue(cell, jsonObject, formulaEvaluator);
				} else {
					setColunmValueTypeMap(i, getColunmValueType(cell, formulaEvaluator));
					cellValue = getValue(cell, formulaEvaluator);
				}
				map.put(getColumnCharName(i), cellValue);
				mapValue.put(titleIndex, cellValue);
				titleIndex++;
			}
		}
		if (columnError != null && columnError.length() > 0) {
			throw new ErrorInfoException(String.format("[%s]位置的字段数据类型与表结构不符！", columnError.toString()));
		}
		valuerMaper.add(mapValue);
		return map;
	}

	//获取字段位置
	private List<Integer> getPosition(List<Integer> contentColsRange, JSONArray column) throws ErrorInfoException {
		List<Integer> columnNumberNames = new ArrayList<Integer>();
		if (column != null && column.size() > 0) {
			for (int i = 0; i < column.size(); i++) {
				JSONObject jsonObject = column.getJSONObject(i);
				if (jsonObject.containsKey(COLUMN_POSITION)) {
					String position = jsonObject.getString(COLUMN_POSITION);
					colPosition.add(position);
					columnNumberNames.add(getColumnNumber(position));
					colPositionMaper.put(i, position);
				} else {
					throw new ErrorInfoException(String.format("第[%s]列配置中不包含位置信息！", i + 1));
				}
			}
		} else if(contentColsRange != null && !contentColsRange.isEmpty()) {
			for (int i = 0; i < contentColsRange.size(); i++) {
				String position = getColumnCharName(contentColsRange.get(i));
				colPosition.add(position);
				columnNumberNames.add(getColumnNumber(position));
				colPositionMaper.put(i, position);
			}
		}
		return columnNumberNames;
	}

	private String getValue(Cell cell, FormulaEvaluator formulaEvaluator) {
		String value = dataFormatter.formatCellValue(cell).trim();
		switch (cell.getCellTypeEnum()) {
			case FORMULA: // 公式
				value = parseFormula(cell, formulaEvaluator, true);
				break;
			case NUMERIC: // 数字
				value = getCellNum(cell, value);
				break;
			case STRING: // 字符串
				value = cell.getStringCellValue();
				if (value.startsWith("'")) {
					value = value.substring(1);
				}
				break;
			default:
				break;
		}
		return value;
	}

	//设置预览数据的列类型（jdbc类型）
	private void setColunmValueTypeMap(Integer cellNum, Integer colunmValueType) {
		String position = getColumnCharName(cellNum);
		if (colunmType.containsKey(position)) {
			if (Types.VARCHAR == colunmValueType) {//如果最新类型为VARCHAR，则更换为VARCHAR
				colunmType.put(position, colunmValueType);
			} else if (Types.DOUBLE == colunmValueType &&
					(Types.TIMESTAMP == colunmType.get(position)) || Types.DATE == colunmType.get(position)) {//如果最新类型为DOUBLE，则将TIMESTAMP，DATE更换为DOUBLE
				colunmType.put(position, colunmValueType);
			}
			//todo DATE与TIMESTAMP的转换
		} else {
			colunmType.put(position, colunmValueType);
		}
	}

	//获取单元格类型
	private Integer getColunmValueType(Cell cell, FormulaEvaluator formulaEvaluator) {
		Integer colunmValueType = null;
		switch (cell.getCellTypeEnum()) {
			case FORMULA: // 公式
				colunmValueType = Integer.parseInt(parseFormula(cell, formulaEvaluator, false));
				break;
			case NUMERIC: // 数字
				String formatString = cell.getCellStyle().getDataFormatString();
				boolean isDate = formatString.contains("yy") || formatString.contains(";@");
				boolean isTime = formatString.contains("h:");
				boolean isNum = formatString.contains("0.0") || formatString.contains("0_");
				if (isDate && isTime) {
					//日期时间
					colunmValueType = Types.TIMESTAMP;
				} else if (isDate) {
					//日期
					colunmValueType = Types.DATE;
				} else if (isNum) {
					//数字
					colunmValueType = Types.DOUBLE;
				} else {
					colunmValueType = Types.DOUBLE;
				}
				break;
			case STRING: // 字符串
				colunmValueType = Types.VARCHAR;
				break;
			case BLANK: // 空白
				colunmValueType = Types.VARCHAR;
				break;
			case BOOLEAN: // Boolean
				colunmValueType = Types.VARCHAR;
				break;
			case ERROR: // Error，返回错误码
				colunmValueType = Types.VARCHAR;
				break;
			default:
				colunmValueType = Types.VARCHAR;
				break;
		}


		return colunmValueType;
	}

	private String getValue(Cell cell, JSONObject jsonObject, FormulaEvaluator formulaEvaluator) {
		String column = jsonObject.get(COLUMN_POSITION).toString();
		String dataType = jsonObject.get(COLUMN_TYPE).toString();
		String value = dataFormatter.formatCellValue(cell).trim();
		switch (DataXColumnType.toDataCollectModeEum(dataType)){
			case LONG :
			case BYTES :
			case DOUBLE :
			case DATE :
				try {
					if (CellType.FORMULA == cell.getCellTypeEnum()) {
						value = parseFormula(cell, formulaEvaluator, true);
					} else {
						value = getCellNum(cell, value);//未做文本格式的数字
					}
				} catch (Exception e) {
					appendWithComma(columnError, column);
				}
				break;
//			case BOOLEAN :
//
//				break;
//			case STRING :其余全部当为string处理
//
//				break;
			default:
				value = getValue(cell, formulaEvaluator);
				break;
		}
		return value;
	}

	private String getCellNum(Cell cell, String value) {
		double doubleVal = cell.getNumericCellValue();
		String formatString = cell.getCellStyle().getDataFormatString();
		boolean isDate = formatString.contains("yy") || formatString.contains(";@");
		boolean isTime = formatString.contains("h:");
		boolean isContainSec = formatString.contains("ss");
		boolean isNum = formatString.contains("0.0") || formatString.contains("0_");
		if (isDate && isTime) {
			//日期时间
			Date date = DateUtil.getJavaDate(doubleVal);
			if (isContainSec) {
				value = DateTimeUtils.dateToString(date, DateTimeUtils.YYYY_MM_DD_HH_MM_SS);
			} else {
				value = DateTimeUtils.dateToString(date , DateTimeUtils.YYYY_MM_DD_HH_MM);
			}

		} else if (isDate) {
			//日期
			Date date = DateUtil.getJavaDate(doubleVal);
			value = DateTimeUtils.dateToString(date , DateTimeUtils.YYYY_MM_DD);
		} else if (isTime) {
			//时间
			Date date = DateUtil.getJavaDate(doubleVal);

			if (isContainSec) {
				value = DateTimeUtils.dateToString(date , DateTimeUtils.HH_MM_SS);
			} else {
				value = DateTimeUtils.dateToString(date , DateTimeUtils.HH_MM);
			}
		} else if (isNum) {
		} else {
			String tmpValue = String.valueOf(doubleVal);
			if (value.startsWith("0")) {

			} else if (value.contains("E")) {

			} else if (tmpValue.endsWith(".0")) {
				value = tmpValue.substring(0, tmpValue.length() - 2);
				if (tmpValue.equals("")) {
					value = "0";
				}
			} else if (tmpValue.contains("E")) {
				BigDecimal bigDecimal = new BigDecimal(doubleVal);
				value = bigDecimal.toString();
			}
		}
		return value;
	}

	//获取sheet（sheet的列号由1开始，行号由0开始）
	private Sheet getSheet(Workbook workbook, String sheetName) throws ErrorInfoException {
		Sheet sheet;
		if (StringUtils.isNotBlank(sheetName)) {
			sheet = workbook.getSheet(sheetName);
		} else {
			sheet = workbook.getSheetAt(0);
		}
		return sheet;
	}

	public String[] objArrayToStrArray(Object[] objArray) {
		String[] strArray = new String[objArray.length];
		for (int i = 0; i < objArray.length; i++) {
			strArray[i] = (String) objArray[i];
		}
		return strArray;
	}

	private List<Integer> getAnalysisContentRowsRange(List<Integer> contentRowsRange, int previewCount) {
		if (previewCount < contentRowsRange.size()) {
			List<Integer> newContentRowsRange = new ArrayList<Integer>(previewCount);
			for (int i = 0; i < previewCount; i++) {
				newContentRowsRange.add(contentRowsRange.get(i));
			}
			return newContentRowsRange;
		}
		return contentRowsRange;
	}

	private List<Integer> getRangeIntList(String range, Sheet sheet, int firstRowNum) throws ErrorInfoException {
		String[] ranges = range.split(",");
		List<Integer> rangesList = new ArrayList<Integer>();
		for (String str : ranges) {
			if (str.contains("-")) {
				int begin = 0;
				int end = 0;
				if (str.endsWith("-")) {
					Row row = sheet.getRow(firstRowNum);
					if (row == null) {
//						row = sheet.getRow(0);//todo  由于为空  在列类型中也无数据  那么在js中赋初值 varchar和500
						throw new ErrorInfoException("Sheet表单名称为：" + sheet.getSheetName() + "的Sheet在第" + (firstRowNum + 1) + "行无数据！");
					}
					try {//获取行号(以"-"结束的情况下)
						begin = Integer.parseInt(str.substring(0, str.length() - 1)) - 1;
						end = sheet.getLastRowNum();
					} catch (Exception e) {//获取列号（-1动作方法getColumnNumber已处理）
						begin = getColumnNumber(str.substring(0, str.length() - 1));
						end = row.getLastCellNum() - 1;
					}
				} else {
					String[] split_ = str.split("-");
					try {//获取行号
						begin = Integer.parseInt(split_[0]) - 1;
						end = Integer.parseInt(split_[split_.length - 1]) - 1;
					} catch (Exception e) {//获取列号（-1动作方法getColumnNumber已处理）
						begin = getColumnNumber(split_[0]);
						end = getColumnNumber(split_[split_.length - 1]);
					}
				}
				for (int i = begin; i <= end; i++) {
					rangesList.add(i);
				}
			} else {
				try {
					rangesList.add(Integer.parseInt(str) - 1);
				} catch (Exception e) {
					rangesList.add(getColumnNumber(str));
				}
			}
		}
		return rangesList;
	}

	private int getColumnNumber(String column) {
		int length = column.length();
		short result = 0;
		for (int i = 0; i < length; i++) {
			char letter = column.toUpperCase().charAt(i);
			int value = letter - 'A' + 1;
			result += value * Math.pow(26, length - i - 1);
		}
		return result - 1;
	}

	private int getFirstRowNum(String contentRowsRange) {
		contentRowsRange = contentRowsRange.replace("-", ",");
		String[] arr = contentRowsRange.split(",");
		return Integer.parseInt(arr[0]) - 1;
	}

	//获取列所对应的字母(该方法只能支持26*27列数据以内的，超出范围后不能满足需求)
	private static String getColumnCharName(int number) {
		String result = "";
		int a = number / 26;//十位
		int b = number % 26;//个位
		//尾数
		char s = (char) ('A' + b);
		result += s;
		//十位数
		if (a > 0) {
			char x = (char) ('A' + a - 1);
			result = x + result;
		}
		return result;
	}

	private Map<String, String> getSheetNameMap(Workbook workbook, String sheetName) throws ErrorInfoException {
		Map<String, String> map = new LinkedHashMap<String, String>();
		if (StringUtils.isBlank(sheetName)) {
			String name = workbook.getSheetName(0);
			map.put("index", "0");
			map.put("sheetName", name);
		} else {
			int index = workbook.getSheetIndex(sheetName);

			if (index == -1) {
				throw new ErrorInfoException("该文件不存在sheeName为" + sheetName + "的sheet！");
			} else {
				map.put("index", index + "");
				map.put("sheetName", sheetName);
			}
		}
		return map;
	}

	/**
	 * 解析公式的值或者值类型
	 *
	 * @param cell
	 * @param formulaEvaluator
	 * @param isParseValue     true返回值  false返回值类型
	 * @return
	 */
	private String parseFormula(Cell cell, FormulaEvaluator formulaEvaluator, boolean isParseValue) {
		String value = "";
		Integer valueType = Types.VARCHAR;
		try {
			CellValue cellValue;
			cellValue = formulaEvaluator.evaluate(cell);
			switch (cell.getCellTypeEnum()) {                //判断公式类型
				case BOOLEAN:
					value = String.valueOf(cellValue.getBooleanValue());
					break;
				case NUMERIC:
					// 处理日期
//                    if (DateUtil.isCellDateFormatted(cell)) {
//                        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//                        Date date = cell.getDateCellValue();
//                        value = format.format(date);
//                    } else {
//                        value  = String.valueOf(cellValue.getNumberValue());
//                    }
					if (!isParseValue) {
						String formatString = cell.getCellStyle().getDataFormatString();
						boolean isDate = formatString.contains("yy") || formatString.contains(";@");
						boolean isTime = formatString.contains("h:");
						boolean isNum = formatString.contains("0.0") || formatString.contains("0_");
						if (isDate && isTime) {
							//日期时间
							valueType = Types.TIMESTAMP;
						} else if (isDate) {
							//日期
							valueType = Types.DATE;
						} else if (isNum) {
							//数字
							valueType = Types.DOUBLE;
						} else {
							valueType = Types.DOUBLE;
						}
					}
					value = String.valueOf(cellValue.getNumberValue());
					value = getCellNum(cell, value);
					break;
				case STRING:
					value = cellValue.getStringValue();
					if (value.startsWith("'")) {
						value = value.substring(1);
					}
					break;
				case BLANK:
					value = "";
					break;
				case ERROR:
					value = "";
					break;
				case FORMULA:
					value = "";
					break;
			}
		} catch (Exception e) {
			value = cell.getStringCellValue().toString();
			cell.getCellFormula();
		}
		return isParseValue ? value : valueType.toString();
	}

	private String getPostfix(String path) {
		if (path == null || EMPTY.equals(path.trim())) {
			return EMPTY;
		}
		if (path.contains(POINT)) {
			return path.substring(path.lastIndexOf(POINT) + 1, path.length());
		}
		return EMPTY;
	}

	/**
	 * 在StringBuffer末尾追加逗号，然后再追加另一个字符串
	 * @param stringBuffer
	 * @param appendStr
	 * @return
	 */
	private static StringBuffer appendWithComma(StringBuffer stringBuffer , String appendStr){
		if (stringBuffer == null || stringBuffer.length() == 0) {
			stringBuffer.append(appendStr);
		} else {
			stringBuffer.append(",").append(appendStr) ;
		}

		return stringBuffer;
	}

	/**
	 * 得到excel文件的所有表名
	 * @param workbook
	 * @return
	 */
	private List<String> getSheetNameList(Workbook workbook){
		List<String> list = new ArrayList<String>();
		if (workbook != null){
			int sheetNum = workbook.getNumberOfSheets();
			for(int i = 0;i < sheetNum;i++)
			{
				Sheet sheet = workbook.getSheetAt(i);
				list.add(sheet.getSheetName());
			}
			return list;
		}
		return null;
	}

	/**
	 * 读取excel文件得到其sheetName列表
	 * @param path
	 * @return
	 */
	public List<String> readSheetNameList(String path) throws IOException {
		InputStream is = new FileInputStream(path);
		Workbook workbook =null;
		String postfix = getPostfix(path);
		if (StringUtils.equals(OFFICE_EXCEL_2003_POSTFIX,postfix)){
			workbook = new HSSFWorkbook(is);
			return getSheetNameList(workbook);
		}
		else if (StringUtils.equals(OFFICE_EXCEL_2010_POSTFIX,postfix)){
			workbook = new XSSFWorkbook(is);
			return getSheetNameList(workbook);
		}
		return null;
	}

}

