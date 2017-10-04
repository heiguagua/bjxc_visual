package com.chinawiserv.dsp.dir.service.configure.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirNews;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirNewsVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirPolicyVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirNewsMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirNewsService;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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
public class DirNewsServiceImpl extends CommonServiceImpl<DirNewsMapper, DirNews , DirNewsVo> implements IDirNewsService {

    @Autowired
    private DirNewsMapper mapper;


    @Override
    public boolean insertVO(DirNewsVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirNewsVo vo) throws Exception {
		//todo
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
    public DirNewsVo selectVoById(String id) throws Exception {
    	
    	return mapper.selectVoById(id);
    	
	}

    @Override
    public Page<DirNewsVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todoPage<DirPolicyVo> page = getPage(paramMap);
    	Page<DirNewsVo> page = getPage(paramMap);
        page.setOrderByField("create_time");
        page.setAsc(false);
        List<DirNewsVo> voPage = mapper.selectVoPage(page, paramMap);
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
	public String fileUpload(DirNewsVo entity, MultipartFile file, HttpServletRequest request) throws Exception {
		String resultStr = "";
//        String picTitle = request.getParameter("pic_title");
//        String picContent = request.getParameter("pic_content");
        //由于ie中上传文件时是以图片的绝对路径全称作为文件名所以必需截取后面的文件名
		String fileName = file.getOriginalFilename();
        String picName =fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());
        String picSize = String.valueOf(file.getSize());
        //根据图片名称，查询数据库，看是否已经有相同名称的图片存在服务器上了，如果有则不能进行本次图片上传
        boolean isSamePic = hasThisPic(picName);
        if(isSamePic) {
            return "samePic";
        }else{
            //上传图片
            Properties properties = PropertiesLoaderUtils.loadAllProperties("/conf/common.properties");
            String mapUrl = properties.getProperty("datastreet.upload.native.image_path");
            String lunboDir = properties.getProperty("datastreet.upload.native.image_path.lunboDir");
            if(!StringUtils.isEmpty(mapUrl) && !StringUtils.isEmpty(lunboDir)){
                String dirPath = "";
                if(lunboDir.startsWith("/") || lunboDir.startsWith("\\")){
                    dirPath = mapUrl+lunboDir;
                }else{
                    dirPath = mapUrl + "/" + lunboDir;
                }
                File dirFile = new File(dirPath);
                if(!dirFile.exists()){
                    dirFile.mkdirs();
                }
                String newFileName = dirPath + "/" + picName;
                file.transferTo(new File(newFileName));//上传文件到指定目录
                //把所有表单数据保存到数据库表中
//                Pic picObj = new Pic();
                entity.setId(UUID.randomUUID().toString());
                entity.setPicName(picName);               
                entity.setPicType(file.getContentType());               
                entity.setNewsPic("/"+lunboDir+"/"+picName);
                entity.setPicSize(picSize);
                entity.setStatus("1");
                String loginUserId = ShiroUtils.getLoginUserId();
                entity.setCreateUserId(loginUserId);
                entity.setCreateTime(new Date());
                entity.setDeleteFlag(0);
                mapper.baseInsert(entity);
            }else{
                throw new Exception("请查看common.properties配置文件中，datastreet.upload.native.image_path以及" +
                        "datastreet.upload.native.image_path.lunboDir的值是否配置");
            }

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
	public String fileUpdate(DirNewsVo entity, MultipartFile file, HttpServletRequest request) throws Exception {
		String resultStr = "";
		String fileName = file.getOriginalFilename();
        String picName =fileName.substring(fileName.lastIndexOf("\\")+1,fileName.length());
        String picSize = String.valueOf(file.getSize());
        DirNewsVo dirNewsVo = mapper.selectVoById(entity.getId());
        if(file!= null && !StringUtils.isEmpty(fileName)){
        	
        	boolean isSamePic = hasThisPic(picName);
            if(isSamePic) {
                return "samePic";
            }else{
                //上传图片
                Properties properties = PropertiesLoaderUtils.loadAllProperties("/conf/common.properties");
                String mapUrl = properties.getProperty("datastreet.upload.native.image_path");
                String lunboDir = properties.getProperty("datastreet.upload.native.image_path.lunboDir");
                if(!StringUtils.isEmpty(mapUrl) && !StringUtils.isEmpty(lunboDir)){
                    String dirPath = "";
                    if(lunboDir.startsWith("/") || lunboDir.startsWith("\\")){
                        dirPath = mapUrl+lunboDir;
                    }else{
                        dirPath = mapUrl + "/" + lunboDir;
                    }
                    File dirFile = new File(dirPath);
                    if(!dirFile.exists()){
                        dirFile.mkdirs();
                    }
                    String newFileName = dirPath + "/" + picName;
                    file.transferTo(new File(newFileName));//上传文件到指定目录
                    //把所有表单数据保存到数据库表中
//                    Pic picObj = new Pic();
                    entity.setId(UUID.randomUUID().toString());
                    entity.setPicName(picName);               
                    entity.setPicType(file.getContentType());               
                    entity.setNewsPic("/"+lunboDir+"/"+picName);
                    entity.setPicSize(picSize);
                    entity.setStatus("1");
                    String loginUserId = ShiroUtils.getLoginUserId();
                    entity.setCreateUserId(loginUserId);
                    entity.setCreateTime(new Date());
                    entity.setDeleteFlag(0);
                    mapper.baseInsert(entity);
                }else{
                    throw new Exception("请查看common.properties配置文件中，datastreet.upload.native.image_path以及" +
                            "datastreet.upload.native.image_path.lunboDir的值是否配置");
                }
        	
        	
        	
        	
        	
        }
            
        }else{
        	
        	
        }
        
		return null;
	}
}
