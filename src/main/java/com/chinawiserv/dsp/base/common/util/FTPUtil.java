package com.chinawiserv.dsp.base.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ConnectException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;


public class FTPUtil {

    private FTPClient ftp;

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

    public boolean uploadCaseFiles(String folderName, List<MultipartFile> caseFiles) throws Exception {
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
            try {
                FTPClient ftp = connect(url, port, username, password);
                String[] folderNames = folderName.split("/");
                if (!ftp.changeWorkingDirectory(folderName)) {
                    for (String str : folderNames) {
                        String folderNameFtp = new String(str.getBytes("utf-8"), "8859_1");
                        ftp.makeDirectory(folderNameFtp);
                        ftp.changeWorkingDirectory(folderNameFtp);
                    }
                }

                for (MultipartFile file : caseFiles) {
                    InputStream fileInputStream = file.getInputStream();
                    String fileName = file.getOriginalFilename();//URLEncoder.encode(file.getOriginalFilename(), "utf-8");
                    ftp.storeFile(new String(fileName.getBytes("utf-8"), "8859_1"), fileInputStream);
                    fileInputStream.close();
                }
                ftp.disconnect();
                return true;
            } catch (Exception e) {
                return false;
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


    private void disconnect() throws Exception {
        ftp.logout();
        ftp.disconnect();
    }

}
