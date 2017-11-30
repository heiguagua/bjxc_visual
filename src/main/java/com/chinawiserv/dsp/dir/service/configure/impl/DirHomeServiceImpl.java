package com.chinawiserv.dsp.dir.service.configure.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.*;
import com.chinawiserv.dsp.dir.entity.po.configure.DirHome;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirHomeVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirNewsVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirHomeMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirHomeService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 新闻表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirHomeServiceImpl extends CommonServiceImpl<DirHomeMapper, DirHome , DirHomeVo> implements IDirHomeService {

    @Autowired
    private DirHomeMapper mapper;
    
    @Override
	public void DeleteByFlag(String id) {		
    	mapper.updateDeleteFlag(id);
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

   

    @Override
    public Page<DirHomeVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todoPage<DirPolicyVo> page = getPage(paramMap);
    	Page<DirHomeVo> page = getPage(paramMap);
        page.setOrderByField("create_time");
        page.setAsc(false);
        List<DirHomeVo> voPage = mapper.selectVoPage(page, paramMap);
        page.setTotal(mapper.selectVoCount(paramMap));
        page.setRecords(voPage);
        return page;		
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

	@Override
	public String fileUpload(DirHomeVo entity, MultipartFile file, HttpServletRequest request) throws Exception {
		String resultStr = "";
		//创建客户端对象
//	      FTPClient ftp = new FTPClient();
//	      InputStream local=null;
//        String picTitle = request.getParameter("pic_title");
//        String picContent = request.getParameter("pic_content");
        //由于ie中上传文件时是以图片的绝对路径全称作为文件名所以必需截取后面的文件名
		
		try{
	     
	    //连接ftp服务器ftp://192.168.13.176:21
//	    ftp.connect("192.168.13.176", 21);
	    //登录
//	    ftp.login("root", "fy;2016");
	    int state = 0;
		String fileName = file.getOriginalFilename();
        String picName =((new Date()).getTime())+fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());
        List<String> listType = new ArrayList<>();
        String fileType = GetFileTypeByHead.getFileTypeByByte(file.getBytes());
        listType.add("jpg");listType.add("tif");listType.add("png");listType.add("gif");listType.add("bmp");
        for (Iterator iterator = listType.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if(string.equals(fileType)){
				state++;
			}
		}
        if(state!=1){
        	return "type";
        }
        
        String picSize = String.valueOf(file.getSize());
        //根据图片名称，查询数据库，看是否已经有相同名称的图片存在服务器上了，如果有则不能进行本次图片上传
        boolean isSamePic = hasThisPic(picName);
        if(!isSamePic && isSamePic) {
            return "samePic";
        }else{
            //上传图片
            Properties properties = new Properties();
         	
            properties.load(this.getClass().getResourceAsStream("/conf/common.properties"));
         	
        //  Properties properties = PropertiesLoaderUtils.loadAllProperties(this.getClass().getClassLoader().getResource("").getPath() + "conf/common.properties");
            String switchToFtp = properties.getProperty("datastreet.switch");
            String mapUrl = null;
            String lunboDir =null; 
            String mapUrlShow = null;
            String lunboDirShow =null; 
            if(switchToFtp.equals("yes")){
           	  mapUrl = properties.getProperty("datastreet.upload.native.image_path");
              lunboDir = properties.getProperty("datastreet.upload.native.image_path.homePage");
              
              mapUrlShow = properties.getProperty("datastreet.show.native.image_path");
              lunboDirShow = properties.getProperty("datastreet.show.native.image_path.homePage");
              
            }else{
           	  mapUrl = properties.getProperty("datastreet.upload.native.image_path.local");
              lunboDir = properties.getProperty("datastreet.upload.native.image_path.local.homePage");
            }            
            String folderName = mapUrl+"/"+ lunboDir;
            if(!StringUtils.isEmpty(mapUrl) && !StringUtils.isEmpty(lunboDir)){
                String dirPath = "";
                if(lunboDir.startsWith("/") || lunboDir.startsWith("\\")){
                    dirPath = request.getSession().getServletContext().getRealPath("")
                    		+ mapUrl+lunboDir;
                }else{
                    dirPath = request.getSession().getServletContext().getRealPath("")
                    		+ mapUrl + "/" + lunboDir;
                }
            	//检查上传路径是否存在 如果不存在返回false
//                boolean flag = ftp.changeWorkingDirectory(mapUrl + "/" + lunboDir);
//                if(!flag){
//                    //创建上传的路径  该方法只能创建一级目录，在这里如果/home/ftpuser存在则可创建image
//                    ftp.makeDirectory(mapUrl + "/" + lunboDir);
//                }
                File dirFile = new File(dirPath);
                if(!dirFile.exists()){
                    dirFile.mkdirs();
                }
                int index = 0;
                for(int i = 0; i < picName.length(); i++){
                    if (!Character.isDigit(picName.charAt(i))){
                        index = i;
                        break;
                    }
                }
//                MultipartFile[] files = {};
//                files[0] = 
                String newFileName = dirPath + "/" + picName;
                List<MultipartFile>	caseFiles = new ArrayList<MultipartFile>();	
                caseFiles.add(file);
                
                FTPUtil FtpUtil = new FTPUtil();  
//                String switchToFtp = properties.getProperty("datastreet.switch");
                //判定存储到ftp还是local
                if(switchToFtp.equals("yes")){
                	FtpUtil.uploadCaseFiles(folderName, caseFiles,picName);
                	folderName = mapUrlShow+"/"+ lunboDirShow;
                }else{
                	file.transferTo(new File(newFileName));//上传文件到指定目录
                	folderName = "/img/" + lunboDir;
                }
                
                
                
//                ftp.changeWorkingDirectory(mapUrl + "/" + lunboDir);
//                File file1 = new File(file);
//                local = new FileInputStream(file);
                //第一个参数是文件名
//                ftp.storeFile(picName, file.getInputStream());
                
                //把所有表单数据保存到数据库表中
//                Pic picObj = new Pic();
                entity.setId(UUID.randomUUID().toString());
                entity.setPicName(picName);               
                entity.setPicType(file.getContentType());  //             
                entity.setPicPath(folderName+"/"+picName);
                entity.setPicSize(picSize);
                entity.setStatus("1");
                String loginUserId = ShiroUtils.getLoginUserId();
                entity.setCreateUserId(loginUserId);
                entity.setCreateTime(new Date());
                entity.setDeleteFlag(0);
                mapper.baseInsert(entity);
            }else{
                throw new Exception("请查看common.properties配置文件中，datastreet.upload.native.image_path以及" +
                        "datastreet.upload.native.image_path.homePage的值是否配置");
            }

        }
		}catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
        return resultStr;

	}
	
	
	/**
     * 通过比较上传图片的名称和大小，来判断数据库中是否有相同的图片
     * @param picName 图片名称
     * @return 是否已存在该图片
     * @throws Exception
     */
    private boolean hasThisPic(String picName) throws Exception {
        boolean haveSamePic = false;
        Map<String,Object> params = new HashMap<>();
        params.put("picName",picName);
        List<DirNewsVo> picInfoList = mapper.selectPicBaseInfo(params);
        if(picInfoList != null && !picInfoList.isEmpty()){
            haveSamePic = true;
        }
        return haveSamePic;
    }

	@Override
	public void updateStatus(String id, String status) {
		
		if(status.equals("1")){
			mapper.forbid(id);
			
		}else if(status.equals("0")){
			mapper.lancer(id);
		}
		
	}

	@Override
	public String fileUpdate(DirHomeVo entity, MultipartFile file, HttpServletRequest request) throws Exception {
		String resultStr = "";
		
		
		String fileName = file.getOriginalFilename();
        String picName =((new Date()).getTime())+fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());     
        
        String picSize = String.valueOf(file.getSize());
        DirHomeVo dirHomeVo = mapper.selectVoById(entity.getId());
        if(file!= null && !StringUtils.isEmpty(fileName)){
        	int state = 0;
            List<String> listType = new ArrayList<>();
            String fileType = GetFileTypeByHead.getFileTypeByByte(file.getBytes());
            listType.add("jpg");listType.add("tif");listType.add("png");listType.add("gif");listType.add("bmp");
            for (Iterator iterator = listType.iterator(); iterator.hasNext();) {
    			String string = (String) iterator.next();
    			if(string.equals(fileType)){
    				state++;
    			}
    		}
            if(state!=1){
            	return "type";
            }
        	String exsitPicName = dirHomeVo.getPicName();
            String exsitPicSize = dirHomeVo.getPicSize();
            if(!exsitPicName.equals(picName) || !exsitPicSize.equals(picSize)){            
        	boolean isSamePic = hasThisPic(picName);
            if(!isSamePic && isSamePic) {
                return "samePic";
            }else{
                //上传图片
             Properties properties = new Properties();
             	
             properties.load(this.getClass().getResourceAsStream("/conf/common.properties"));
             	
            //Properties properties = PropertiesLoaderUtils.loadAllProperties(this.getClass().getClassLoader().getResource("").getPath() + "conf/common.properties");
             
             String switchToFtp = properties.getProperty("datastreet.switch");
             String mapUrl = null;
             String lunboDir =	null; 
             String mapUrlShow = null;
             String lunboDirShow = null;
             if(switchToFtp.equals("yes")){
            	  mapUrl = properties.getProperty("datastreet.upload.native.image_path");
                  lunboDir = properties.getProperty("datastreet.upload.native.image_path.homePage");
                  
                  mapUrlShow = properties.getProperty("datastreet.show.native.image_path");
                  lunboDirShow = properties.getProperty("datastreet.show.native.image_path.homePage");
                  
             }else{
            	  mapUrl = properties.getProperty("datastreet.upload.native.image_path.local");
                  lunboDir = properties.getProperty("datastreet.upload.native.image_path.local.homePage");
             }
             
             String folderName = mapUrl+"/"+ lunboDir;   
             if(!StringUtils.isEmpty(mapUrl) && !StringUtils.isEmpty(lunboDir)){
                    String dirPath = "";
                    if(lunboDir.startsWith("/") || lunboDir.startsWith("\\")){
                        dirPath =  request.getSession().getServletContext().getRealPath("")
                        		+mapUrl+lunboDir;
                    }else{
                        dirPath =  request.getSession().getServletContext().getRealPath("")
                        		+mapUrl + "/" + lunboDir;
                    }
                    File dirFile = new File(dirPath);
                    if(!dirFile.exists()){
                        dirFile.mkdirs();
                    }
                    String newFileName = dirPath + "/" + picName;
                    
                    //把所有表单数据保存到数据库表中
//                    Pic picObj = new Pic();
            	 
            	 	List<MultipartFile> caseFiles = new ArrayList<MultipartFile>();	
                 	caseFiles.add(file);
                 
                 	FTPUtil FtpUtil = new FTPUtil();         
                 	
                 	//判定存储到ftp还是local
                    if(switchToFtp.equals("yes")){
                    	FtpUtil.uploadCaseFiles(folderName, caseFiles,picName);
                    	folderName = mapUrlShow+"/"+ lunboDirShow;   
                    }else{
                    	file.transferTo(new File(newFileName));//上传文件到指定目录
                    	folderName = "/img/" + lunboDir;
                    }
                 	

                 	dirHomeVo.setPicName(picName);               
                 	dirHomeVo.setPicType(file.getContentType());               
                 	dirHomeVo.setPicPath(folderName+"/"+picName);
                 	dirHomeVo.setPicSize(picSize);
//                    dirNewsVo.setStatus("1");
                    String loginUserId = ShiroUtils.getLoginUserId();
                 	dirHomeVo.setUpdateUserId(loginUserId);
                 	dirHomeVo.setUpdateTime(new Date());
//                    dirNewsVo.setDeleteFlag(0);
//                    dirNewsVo.setNewsContent(entity.getNewsContent());
                 	dirHomeVo.setPicOrder(entity.getPicOrder());
//                    dirNewsVo.setTitle(entity.getTitle());
                    mapper.baseUpdate(dirHomeVo);
                }else{
                    throw new Exception("请查看common.properties配置文件中，datastreet.upload.native.image_path以及" +
                            "datastreet.upload.native.image_path.homePage的值是否配置");
                }        	
        }
        }  
        }else{    
        	String loginUserId = ShiroUtils.getLoginUserId();
         	dirHomeVo.setUpdateUserId(loginUserId);
         	dirHomeVo.setUpdateTime(new Date());
         	dirHomeVo.setPicOrder(entity.getPicOrder());
            mapper.baseUpdate(dirHomeVo);
//        	String loginUserId = ShiroUtils.getLoginUserId();
//            dirNewsVo.setUpdateUserId(loginUserId);
//            dirNewsVo.setUpdateTime(new Date());
//            dirNewsVo.setDeleteFlag(0);
//            dirNewsVo.setNewsContent(entity.getNewsContent());
//            dirNewsVo.setPicOrder(entity.getPicOrder());
//            dirNewsVo.setTitle(entity.getTitle());
//            mapper.baseUpdate(dirNewsVo);
        	
        }
        
		return resultStr;
	}

	@Override
	public boolean insertVO(DirHomeVo v) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVO(DirHomeVo v) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DirHomeVo selectVoById(String id) throws Exception {
		return mapper.selectVoById(id);
	}

	
}
