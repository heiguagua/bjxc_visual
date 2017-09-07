package com.chinawiserv.dsp.base.common.util.File;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tk on 2017/6/8.
 */
public class FileUtil {

    /**
     * 得到文件后缀名
     * @param path
     * @return
     */
    public static String getPostfix(String path) {
        if (path == null || FileCommon.EMPTY.equals(path.trim())) {
            return FileCommon.EMPTY;
        }
        if (path.contains(FileCommon.POINT)) {
            return path.substring(path.lastIndexOf(FileCommon.POINT) + 1, path.length());
        }
        return FileCommon.EMPTY;
    }

    /**
     * 保存文件到相应目录
     * @param file
     * @param parent
     * @param child
     * @return
     */
    public static File saveFile(MultipartFile file, String parent, String child) {
        if (file != null) {
            try {
                File parentFile = new File(parent);
                //先执行删除操作，防止在上传文件时生成不带后缀名的upload文件导致不能后续操作
                if(parentFile.exists()){
                    deleteDirs(parentFile);
                }

                parentFile.mkdirs();
                File targetFile = new File(parent, child);
                if (targetFile.exists()) {
                    targetFile.delete();
                }
                targetFile.createNewFile();
                file.transferTo(targetFile);
                return targetFile;
            }
            catch (Exception e) {
                return  null;
            }
        }
        else {
            return  null;
        }
    }

    /**
     * 保存多个文件到相应目录
     * @param files
     * @param parent
     * @return
     */
    public static File saveBathFile(MultipartFile[] files, String parent) {
        if (files != null) {
            File parentFile = new File(parent);
            if (parentFile.exists()) {
                deleteDirs(parentFile);
            }
            parentFile.mkdirs();
            for (MultipartFile file : files) {
                File targetFile = new File(parent, file.getOriginalFilename().toLowerCase());
                if (targetFile.exists()) {
                    targetFile.delete();
                }
                try {
                    targetFile.createNewFile();
                    file.transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return parentFile;
        }
        return null;
    }
    /**
     * 删除目录
     * @param dir
     * @return
     */
    public static boolean deleteDirs(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDirs(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * 得到服务器全路径
     * @param request
     * @return
     */
    public static String getRealPath(HttpServletRequest request) {
        if (request != null) {
            String realPath = request.getSession().getServletContext().getRealPath("/");
            if (!realPath.endsWith("/")) {
                realPath = realPath + "/";
            }
            return realPath;
        }
        else {
            return "/";
        }
    }
    /**
     *判断csv文件字符集编码
     * @param fileName
     * @return
     */
    public static String codeString(String fileName) throws Exception{
        BufferedInputStream bin = new BufferedInputStream(
                new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        bin.close();
        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }

        return code;
    }
    /**
     *判断csv文件字符集编码
     * @param range
     * @param length
     * @return
     */
    public static List<Integer> getRangeIntList(String range, int length) {
        String[] ranges = range.split(",");
        List<Integer> rangesList = new ArrayList<Integer>();
        for(String str : ranges){
            if(str.contains("-")){
                int begin = 0;
                int end = 0;
                if(str.endsWith("-")){
                    begin = Integer.parseInt(str.substring(0, str.length() - 1)) - 1;
                    end = length - 1;
                } else {
                    String[] split_ = str.split("-");
                    begin = Integer.parseInt(split_[0]) - 1;
                    end = Integer.parseInt(split_[split_.length - 1]) - 1;
                }
                for(int i = begin; i <= end; i++){
                    rangesList.add(i);
                }
            }else{
                rangesList.add(Integer.parseInt(str) - 1);
            }
        }
        return rangesList;
    }
    /**
     *去除字符串末尾的逗号
     * @param str
     * @return
     */
    public static String trimComma(String str){
        //判断字符串的最后一位是不是逗号，如果是，去除逗号，
        //如果不是，将原来的字符串返回
        final String lastChar = str.substring(str.length()-1);
        if (StringUtils.equals(lastChar,",")){
            String newStr = str.substring(0,str.length()-1);
            return newStr;
        }
        return str;
    }

    /**
     * 通过文件处理数据库类型
     * @param columnType
     * @return
     */
    public static String getJdbcTypeByFile(String columnType){
        String result;
        switch (columnType){
            case "DATETIME":
                result = "93";
                break;
            case "DATE":
                result = "91";
                break;
            case "DOUBLE":
                result = "2";
                break;
            case "VARCHAR":
                result = "12";
                break;
            default:
                result = "12";
                break;
        }
        return result;
    }

    /**
     * 将列类型转化为DataX类型
     * @param columnType
     * @return
     */
    public static String parseDataXTypeByJobColumnType(String columnType){
        columnType = columnType.toUpperCase();
        String result = ReadExcel.DataXColumnType.STRING.getValue();
        if(columnType.contains("TIME") || columnType.contains("DATE")){
            result = ReadExcel.DataXColumnType.DATE.getValue();
        } else if(columnType.contains("INT") ||//mysql
                columnType.contains("FLOAT") ||//mysql
                columnType.contains("DOUBLE") ||//mysql
                columnType.contains("DECIMAL") ||//mysql
                columnType.contains("NUMBER") ||//oracle
                columnType.contains("BIT") ||//sqlserver
                columnType.contains("REAL")){//sqlserver
            result = ReadExcel.DataXColumnType.DOUBLE.getValue();
        }
        //todo 未考虑BOOLEAN
        return result;
    }
}
