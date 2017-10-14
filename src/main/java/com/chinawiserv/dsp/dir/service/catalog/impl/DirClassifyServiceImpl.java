package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyService;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Striped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;


/**
 * <p>
 * 目录分类表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirClassifyServiceImpl extends CommonServiceImpl<DirClassifyMapper, DirClassify , DirClassifyVo> implements IDirClassifyService {

    @Autowired
    private DirClassifyMapper mapper;

    private Striped<Lock> locks = Striped.lazyWeakLock(100);


    @Override
    public boolean insertVO(DirClassifyVo vo) throws Exception {
    	
    	vo.setId(CommonUtil.get32UUID());
    	vo.setCreateTime(new Date());
    	String loginUserId = ShiroUtils.getLoginUserId();
    	vo.setCreateUserId(loginUserId);
    	vo.setDeleteFlag(0);
    	vo.setClassifyIndex(0);
    	vo.setDcmIndex(0);
    	DirClassify fclassify = mapper.selectFclassify(vo.getFid());
    	String fclassifyStructureName = fclassify.getClassifyStructureName();
    	String fcode = fclassify.getClassifyCode();
    	String regionCode = fclassify.getRegionCode();
//    	String fid = fclassify.getId();
    	String ftreecode = fclassify.getTreeCode();
    	int flevel = fclassify.getClassifyLevel();
    	int fclassifyIndex = 0;
    	if(mapper.selectMaxIndexByFcode(fclassify.getId())!=null){
    		 fclassifyIndex = (int) mapper.selectMaxIndexByFcode(fclassify.getId()); 
    	}else{
    		
    		 fclassifyIndex = 0;
    	}
    	int level = flevel+1;
    	
    	if(!vo.getFid().equals("root")){
    		
    	if(level == 2){
    		 vo.setClassifyLevel(2);
    		 if(fclassifyIndex<9){
    			 
    			vo.setClassifyCode(fcode.substring(0,1)+0+(fclassifyIndex+1));
    			vo.setTreeCode(ftreecode+";"+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
//    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			vo.setClassifyIndex(fclassifyIndex+1);
    			vo.setRegionCode(regionCode);
    			mapper.baseInsert(vo);
    		 }else{
    			 
    			vo.setClassifyCode(fcode.substring(0,1)+(fclassifyIndex+1));
    			vo.setTreeCode(ftreecode+";"+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
//    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			vo.setClassifyIndex(fclassifyIndex+1);
    			vo.setRegionCode(regionCode);
    			mapper.baseInsert(vo);
    		 }
    		 
    		  
    	}else if(level >= 3 ){
    		vo.setClassifyLevel(flevel+1);
    		if(fclassifyIndex<9){
   			 
    			vo.setClassifyCode(fcode+0+0+(fclassifyIndex+1));
    			vo.setTreeCode(ftreecode+";"+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
//    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			vo.setClassifyIndex(fclassifyIndex+1);
    			vo.setRegionCode(regionCode);
    			mapper.baseInsert(vo);
    		 }else if(fclassifyIndex < 99 && fclassifyIndex >= 9 ){
    			 
    			 vo.setClassifyCode(fcode+0+(fclassifyIndex+1));
    			 vo.setTreeCode(ftreecode+";"+(fclassifyIndex+1));
    			 vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
//    			 mapper.updateClassifyIndexbyFid(vo.getFid());
    			 vo.setClassifyIndex(fclassifyIndex+1);
    			 vo.setRegionCode(regionCode);
    			 mapper.baseInsert(vo);
    		 }
    		 else{
    			 
    			vo.setClassifyLevel(flevel+1); 
    			vo.setClassifyCode(fcode+(fclassifyIndex+1));
    			vo.setTreeCode(ftreecode+";"+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
//    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			vo.setClassifyIndex(fclassifyIndex+1);
    			vo.setRegionCode(regionCode);
    			mapper.baseInsert(vo);    			
    		 }
    		
    	}
    			
    	}else{
    		
    		vo.setClassifyLevel(1);
    		vo.setClassifyStructureName(vo.getClassifyName());
    		vo.setClassifyCode(""+(mapper.selectCountLevel1()+1));
    		vo.setTreeCode(""+(mapper.selectCountLevel1()+1));
    		vo.setClassifyIndex((int)mapper.selectMaxIndexByFcode("root")+1);
    		vo.setRegionCode(regionCode);
    		mapper.baseInsert(vo);
    	}
    	
		return true;
    }

    @Override
    public boolean updateVO(DirClassifyVo vo) throws Exception {
    	vo.setUpdateTime(new Date());
    	String loginUserId = ShiroUtils.getLoginUserId();
    	vo.setUpdateUserId(loginUserId);
    	mapper.baseUpdate(vo);
    	return true;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}
    
	@Override
	public void DeleteByFlag(String id) {
		mapper.updateDeleteFlag(id);
		
	}

    @Override
    public DirClassifyVo selectVoById(String id) throws Exception {
//    	DirClassifyVo s = mapper.selectVoById(id);
		return mapper.selectVoById(id);
	}

    @Override
    public Page<DirClassifyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public List<DirClassifyVo> selectVoList(Map<String, Object> paramMap) throws Exception {
    	
    	List<String> listClassifyIds  = getFdir_codes((String)paramMap.get("dir_code"));
    	paramMap.put("listClassifyIds", listClassifyIds);
    	return mapper.selectVoListForTreeData(paramMap);
    	
    }
    
    public List<String> getFdir_codes(String dir_code){
	  	List<String> listfdir = Lists.newArrayList();
        listfdir.add(dir_code);
      	 
      	 if(!(mapper.selectDirectoryByFcode(dir_code).equals("root"))){
      		      		
      		listfdir.addAll(getFdir_codes(mapper.selectDirectoryByFcode(dir_code)));      		 
      		      		 
      	 }      		
      	return listfdir;
      }


    @Override
    public String generateDatasetCode(String classifyId){
        Lock lock =  locks.get(classifyId);
        lock.lock();
        try{
            int newDcmIndex = 0;
            String datasetCode = null;
            DirClassifyVo classifyVo =  mapper.selectVoById(classifyId);
            String classifyCode = classifyVo.getClassifyCode();
            int dcmIndex = classifyVo.getDcmIndex();
            newDcmIndex = dcmIndex + 1;
            classifyVo.setDcmIndex(newDcmIndex);
            int updateResult = mapper.baseUpdate(classifyVo);
            if(updateResult > 0){
                datasetCode = classifyCode+"/"+newDcmIndex;
            }
            return datasetCode;
        }finally {
            lock.unlock();
        }
    }

}
