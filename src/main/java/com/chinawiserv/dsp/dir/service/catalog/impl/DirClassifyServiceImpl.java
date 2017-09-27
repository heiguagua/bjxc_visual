package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyService;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.google.common.util.concurrent.FakeTimeLimiter;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.Striped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
    	DirClassify fclassify = mapper.selectFclassify(vo.getFid());
    	String fclassifyStructureName = fclassify.getClassifyStructureName();
    	String fcode = fclassify.getClassifyCode();
    	int flevel = fclassify.getClassifyLevel();
    	int fclassifyIndex = fclassify.getClassifyIndex(); 	
    	int level = flevel+1;
    	
    	if(!vo.getFid().equals("root")){
    		
    	if(level == 2){
    		 vo.setClassifyLevel(2);
    		 if(fclassifyIndex<9){
    			 
    			vo.setClassifyCode(fcode.substring(0,1)+0+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			
    		 }else{
    			 
    			vo.setClassifyCode(fcode.substring(0,1)+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			
    		 }
    		 
    		  
    	}else if(level == 3 ){
    		vo.setClassifyLevel(3);
    		if(fclassifyIndex<9){
   			 
    			vo.setClassifyCode(fcode.substring(0,3)+0+0+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			
    		 }else if(fclassifyIndex < 99 && fclassifyIndex >= 9 ){
    			 
    			 vo.setClassifyCode(fcode.substring(0,3)+0+(fclassifyIndex+1));
    			 vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
    			 mapper.updateClassifyIndexbyFid(vo.getFid());
    		 }
    		 else{
    			 
    			vo.setClassifyLevel(flevel+1); 
    			vo.setClassifyCode(fcode.substring(0,3)+(fclassifyIndex+1));
    			vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
    			mapper.updateClassifyIndexbyFid(vo.getFid());
    			
    		 }
    		
    	}else{
    		vo.setClassifyLevel(flevel+1);
    		vo.setClassifyCode(fcode+(fclassifyIndex+1));
    		vo.setClassifyStructureName(fclassifyStructureName+"->"+vo.getClassifyName());
    		mapper.updateClassifyIndexbyFid(vo.getFid());
    	}
    			
    	}else{
    		
    		vo.setClassifyLevel(1);
    		vo.setClassifyStructureName(vo.getClassifyName());
    		vo.setClassifyCode(""+(mapper.selectCountLevel1()+1));
    		
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
	public void DeleteByFlag(String classifyCode) {
		mapper.updateDeleteFlag(classifyCode);
		
	}

    @Override
    public DirClassifyVo selectVoById(String id) throws Exception {
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
        return mapper.selectVoListForTreeData(paramMap);
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
