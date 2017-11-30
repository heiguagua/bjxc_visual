package com.chinawiserv.dsp.dir.service.configure.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirSpecialApps;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirDevelopApisVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirSpecialAppsVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirSpecialAppsMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirSpecialAppsService;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.FTPUtil;
import com.chinawiserv.dsp.base.common.util.GetFileTypeByHead;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 专题应用表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirSpecialAppsServiceImpl extends CommonServiceImpl<DirSpecialAppsMapper, DirSpecialApps , DirSpecialAppsVo> implements IDirSpecialAppsService {

    @Autowired
    private DirSpecialAppsMapper mapper;

    
    
    

    @Override
    public boolean insertVO(DirSpecialAppsVo vo) throws Exception {
    	vo.setId(CommonUtil.get32UUID());
    	vo.setCreateTime(new Date());
    	String loginUserId = ShiroUtils.getLoginUserId();
    	vo.setCreateUserId(loginUserId);
    	vo.setDeleteFlag(0);
    	vo.setStatus("1");
    	mapper.baseInsert(vo);
		return true;
    }

    @Override
    public boolean updateVO(DirSpecialAppsVo vo) throws Exception {
    	vo.setUpdateTime(new Date());
		String loginUserId = ShiroUtils.getLoginUserId();
		vo.setUpdateUserId(loginUserId);
    	mapper.baseUpdate(vo);
		return false;
	}
    
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
    public DirSpecialAppsVo selectVoById(String id) throws Exception {
		return mapper.selectVoById(id);
	}

    @Override
    public Page<DirSpecialAppsVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
    	Page<DirSpecialAppsVo> page = getPage(paramMap);
        //按照创建时间排序
        page.setOrderByField("create_time");
        page.setAsc(false);
        page.setTotal(mapper.selectVoCount(paramMap));
        page.setRecords(mapper.selectVoPage(page, paramMap));
        return page;
		
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

	@Override
	public String fileUpload(DirSpecialAppsVo entity, MultipartFile file, HttpServletRequest request) throws Exception {

		String resultStr = "";
		//创建客户端对象
//	      FTPClient ftp = new FTPClient();
//	      InputStream local=null;
//        String picTitle = request.getParameter("pic_title");
//        String picContent = request.getParameter("pic_content");
        //由于ie中上传文件时是以图片的绝对路径全称作为文件名所以必需截取后面的文件名
		
		try{
//			InputStream	is = new FileInputStream(filePath);
	     
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
//        boolean isSamePic = hasThisPic(picName);
//        if(!isSamePic && isSamePic) {
//            return "samePic";
//        }else{
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
              lunboDir = properties.getProperty("datastreet.upload.native.image_path.app");
              
              mapUrlShow = properties.getProperty("datastreet.show.native.image_path");
              lunboDirShow = properties.getProperty("datastreet.show.native.image_path.app");
              
            }else{
           	  mapUrl = properties.getProperty("datastreet.upload.native.image_path.local");
              lunboDir = properties.getProperty("datastreet.upload.native.image_path.local.app");
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
//                entity.setPicName(picName);               
//                entity.setPicType(file.getContentType());  //             
                  entity.setIcon(folderName+"/"+picName);
//                entity.setPicSize(picSize);             
            	  insertVO(entity);
//                entity.setStatus("1");
//                String loginUserId = ShiroUtils.getLoginUserId();
//                entity.setCreateUserId(loginUserId);
//                entity.setCreateTime(new Date());
//                entity.setDeleteFlag(0);
//                mapper.baseInsert(entity);
            }else{
                throw new Exception("请查看common.properties配置文件中，datastreet.upload.native.image_path以及" +
                        "datastreet.upload.native.image_path.app的值是否配置");
            }

        
		}catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
        return resultStr;
	
	}

	@Override
	public String fileUpdate(DirSpecialAppsVo entity, MultipartFile file, HttpServletRequest request) throws Exception {


		String resultStr = "";
		
		
		String fileName = file.getOriginalFilename();
        String picName =((new Date()).getTime())+fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());     
        
        String picSize = String.valueOf(file.getSize());
//        DirDevelopApisVo dirDevelopApisVo = mapper.selectVoById(entity.getId());
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
//        	String exsitPicName = dirDevelopApisVo.getPicName();
//            String exsitPicSize = dirDevelopApisVo.getPicSize();
//            if(!exsitPicName.equals(picName) || !exsitPicSize.equals(picSize)){            
//        	boolean isSamePic = hasThisPic(picName);
//            if(!isSamePic && isSamePic) {
//                return "samePic";
//            }else{
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
                  lunboDir = properties.getProperty("datastreet.upload.native.image_path.app");
                  
                  mapUrlShow = properties.getProperty("datastreet.show.native.image_path");
                  lunboDirShow = properties.getProperty("datastreet.show.native.image_path.app");
                  
             }else{
            	  mapUrl = properties.getProperty("datastreet.upload.native.image_path.local");
                  lunboDir = properties.getProperty("datastreet.upload.native.image_path.local.app");
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
                 	

//                 	dirHomeVo.setPicName(picName);               
//                 	dirHomeVo.setPicType(file.getContentType());               
                 	entity.setIcon(folderName+"/"+picName);
//                 	dirHomeVo.setPicSize(picSize);
//                    dirNewsVo.setStatus("1");
//                    String loginUserId = ShiroUtils.getLoginUserId();
                    entity.setUpdateTime(new Date());
            		String loginUserId = ShiroUtils.getLoginUserId();
            		entity.setUpdateUserId(loginUserId);
//                 	dirHomeVo.setUpdateUserId(loginUserId);
//                 	dirHomeVo.setUpdateTime(new Date());
//                    dirNewsVo.setDeleteFlag(0);
//                    dirNewsVo.setNewsContent(entity.getNewsContent());
//                 	dirHomeVo.setPicOrder(entity.getPicOrder());
//                    dirNewsVo.setTitle(entity.getTitle());
                    mapper.baseUpdate(entity);
                }else{
                    throw new Exception("请查看common.properties配置文件中，datastreet.upload.native.image_path以及" +
                            "datastreet.upload.native.image_path.app的值是否配置");
                }        	
        
        
        }else{    
        	String loginUserId = ShiroUtils.getLoginUserId();
         	entity.setUpdateUserId(loginUserId);
         	entity.setUpdateTime(new Date());
//         	entity.setPicOrder(entity.getPicOrder());
            mapper.baseUpdate(entity);
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

	
}
