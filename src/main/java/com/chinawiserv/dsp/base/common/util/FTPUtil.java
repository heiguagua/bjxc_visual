package com.chinawiserv.dsp.base.common.util;

import java.io.*;
import java.net.ConnectException;
import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;


public class FTPUtil {

    private FTPClient ftp;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private FTPClient connect(String addr, int port, String username, String password) throws Exception {
        FTPClient ftp = new FTPClient();
        int reply;
        ftp.connect(addr, port);
        ftp.login(username, password);
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new ConnectException("get connection fail!");
        }
        return ftp;
    }

    @Deprecated
    public boolean uploadCaseFiles(String folderName, List<MultipartFile> caseFiles, String fileName) throws Exception {
        if (StringUtils.isNotBlank(folderName) && null != caseFiles && caseFiles.size() > 0) {
//            Properties properties = PropertiesUtil.load("cors.properties");
//            String url = properties.getProperty("ftp.case.url", "192.168.13.176");
//            String portStr = properties.getProperty("ftp.case.port", "21");
//            int port = Integer.parseInt(portStr);
//            String username = properties.getProperty("ftp.case.username", "ftp");
//            String password = properties.getProperty("ftp.case.password", "");
        	Properties properties = new Properties();
        	properties.load(this.getClass().getResourceAsStream("/conf/common.properties"));
        	String url =  properties.getProperty("datastreet.adress");
        	String portStr =  properties.getProperty("datastreet.port");
        	int port = Integer.parseInt(portStr);
        	String username =  properties.getProperty("datastreet.username");
        	String password =  properties.getProperty("datastreet.password");
            FTPClient ftp = null;
            try {
                ftp = connect(url, port, username, password);
                String[] folderNames = folderName.split("/");
                if (!ftp.changeWorkingDirectory(folderName)) {
                    for (String str : folderNames) {
                        String folderNameFtp = new String(str.getBytes("utf-8"), "8859_1");
                        ftp.makeDirectory(folderNameFtp);
                        ftp.changeWorkingDirectory(folderNameFtp);
                    }
                }

                for (MultipartFile file : caseFiles) {
                    try(InputStream fileInputStream = file.getInputStream()){
//                        String fileName = file.getOriginalFilename();
                        ftp.storeFile(new String(fileName.getBytes("utf-8"), "8859_1"), fileInputStream);
                    }
//                    String fileName = file.getOriginalFilename();//URLEncoder.encode(file.getOriginalFilename(), "utf-8");

                }
                return true;
            } catch (Exception e) {

                return false;
            }finally {
                if(ftp!=null){
                    ftp.logout();
                    ftp.disconnect();
                }
            }
        }
        return false;
    }

    public boolean uploadOtherCaseFiles(String folderName, File file) throws Exception {
        if (StringUtils.isNotBlank(folderName) && null != file) {
//            Properties properties = PropertiesUtil.load("cors.properties");
//            String url = properties.getProperty("ftp.case.url", "150.101.64.31");
//            String portStr = properties.getProperty("ftp.case.port", "21");
//            int port = Integer.parseInt(portStr);
//            String username = properties.getProperty("ftp.case.username", "root");
//            String password = properties.getProperty("ftp.case.password", "dell@2017");
        	Properties properties = new Properties();
        	properties.load(this.getClass().getResourceAsStream("/conf/common.properties"));
        	String url =  properties.getProperty("datastreet.adress");
        	String portStr =  properties.getProperty("datastreet.port");
        	int port = Integer.parseInt(portStr);
        	String username =  properties.getProperty("datastreet.username");
        	String password =  properties.getProperty("datastreet.password");
            try {
                FTPClient ftp = connect(url, port, username, password);
                String[] folderNames = folderName.split("/");
                if (!ftp.changeWorkingDirectory(folderName)) {
                    for (int i = 1; i < folderNames.length; i++) {
                        String folderNameFtp = new String(folderNames[i].getBytes("utf-8"), "8859_1");
                        ftp.makeDirectory(folderNameFtp);
                        ftp.changeWorkingDirectory(folderNameFtp);
                    }
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                String fileName = file.getName();
                ftp.storeFile(new String((((new Date()).getTime())+fileName).getBytes("utf-8"), "8859_1"), fileInputStream);
                fileInputStream.close();
                ftp.disconnect();
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public boolean deleteFile(String filePath) throws Exception {
        if (StringUtils.isNotBlank(filePath)) {
//            Properties properties = PropertiesUtil.load("cors.properties");
//            String url = properties.getProperty("ftp.case.url", "192.168.13.176");
//            String portStr = properties.getProperty("ftp.case.port", "21");
//            int port = Integer.parseInt(portStr);
//            String username = properties.getProperty("ftp.case.username", "ftp");
//            String password = properties.getProperty("ftp.case.password", "");
        	Properties properties = new Properties();
        	properties.load(this.getClass().getResourceAsStream("/conf/common.properties"));
        	String url =  properties.getProperty("datastreet.adress");
        	String portStr =  properties.getProperty("datastreet.port");
        	int port = Integer.parseInt(portStr);
        	String username =  properties.getProperty("datastreet.username");
        	String password =  properties.getProperty("datastreet.password");
            try {
                FTPClient ftp = connect(url, port, username, password);
                filePath = new String(filePath.getBytes("utf-8"), "8859_1");
                boolean flag = false;
                if (ftp.deleteFile(filePath)) {
                    flag = true;
                }
                ftp.disconnect();
                return flag;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        FTPUtil ftpUtil = new FTPUtil();
        try {
            // ftpUtil.deleteFile("asdf/images/wsswe.jpg");
            // FTPClient f =  ftpUtil.connect("150.101.64.31",21,"root","dell@2017");
            //System.out.println(f);
            File file = new File("C:\\Users\\zx\\Desktop\\传票.jpg");

            ftpUtil.uploadOtherCaseFiles("150.102.64.31:21/asdasdas", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private FTPClient getFTPClient() throws Exception{
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/conf/common.properties"));
        String url =  properties.getProperty("datastreet.adress");
        String portStr =  properties.getProperty("datastreet.port");
        int port = Integer.parseInt(portStr);
        String username =  properties.getProperty("datastreet.username");
        String password =  properties.getProperty("datastreet.password");
        return connect(url, port, username, password);
    }

    private void checkFtpPath(String folderName, FTPClient ftp)throws Exception{
        if(!org.springframework.util.StringUtils.isEmpty(folderName)){
            String[] folderNames = folderName.split("/");
            if (!ftp.changeWorkingDirectory(folderName)) {
                for (String str : folderNames) {
                    String folderNameFtp = new String(str.getBytes("utf-8"), "8859_1");
                    ftp.makeDirectory(folderNameFtp);
                    ftp.changeWorkingDirectory(folderNameFtp);
                }
            }
        }else{
            throw new Exception("ftp上传路径不能为空!!");
        }
    }

    private void close(FTPClient ftp){
        if(ftp !=null){
            try {
                ftp.logout();
                ftp.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 上传多个文件到ftp指定目录下
     * @param ftpPath ftp指定目录(如/ftp/a/b)
     * @param localFileList 文件集合
     * @return
     */
    public boolean uploadMutilFiles(String ftpPath, List<MultipartFile> localFileList){
        try {
            if(!ObjectUtils.isEmpty(localFileList)){
                FTPClient ftp = getFTPClient();
                checkFtpPath(ftpPath, ftp);
                for (MultipartFile file : localFileList) {
                    try(InputStream fileInputStream = file.getInputStream()){
                        String fileName = file.getOriginalFilename();
                        ftp.storeFile(new String(fileName.getBytes("utf-8"), "8859_1"), fileInputStream);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            logger.error("上传文件报错：",e);
            return false;
        }finally {
            close(ftp);
        }
    }

    /**
     * 上传多个文件到ftp指定目录下,且自定义上传文件的文件名
     * @param ftpPath ftp指定目录(如/ftp/a/b)
     * @param localFileMap 文件集合,key为文件名
     * @return
     */
    public boolean uploadMutilFilesWithName(String ftpPath, Map<String,MultipartFile> localFileMap){
        try {
            if(!ObjectUtils.isEmpty(localFileMap)){
                FTPClient ftp = getFTPClient();
                checkFtpPath(ftpPath, ftp);
                Set<String> fileNameSet = localFileMap.keySet();
                for(String fileName : fileNameSet){
                    MultipartFile file = localFileMap.get(fileName);
                    try(InputStream fileInputStream = file.getInputStream()){
                        ftp.storeFile(new String(fileName.getBytes("utf-8"), "8859_1"), fileInputStream);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            logger.error("上传文件报错：",e);
            return false;
        }finally {
            close(ftp);
        }
    }

    /**
     * 从ftp指定目录下下载指定文件(单个文件)
     * @param ftpPath ftp指定目录(如/ftp/a/b)
     * @param fileName 文件名称
     * @param localPath 本地保存路径(包含文件名)
     * @return
     */
    public boolean downLoadFile(String ftpPath, String fileName, String localPath){
        try {
            if(!org.springframework.util.StringUtils.isEmpty(ftpPath)
                    && !org.springframework.util.StringUtils.isEmpty(fileName)
                    && !org.springframework.util.StringUtils.isEmpty(localPath)){
                FTPClient ftp = getFTPClient();
                boolean ftpPathExsit = ftp.changeWorkingDirectory(ftpPath);
                if(ftpPathExsit){
                    FTPFile[] ftpFiles = ftp.listFiles();
                    for(FTPFile ftpFile : ftpFiles){
                        String ftpFileName = ftpFile.getName();
                        if(fileName.equals(ftpFileName)){
                            OutputStream ios = new FileOutputStream(new File(localPath));
                            ftp.retrieveFile(ftpFileName, ios);
                            ios.close();
                            break;
                        }
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.error("下载文件报错：",e);
            return false;
        }finally {
            close(ftp);
        }
    }

}
