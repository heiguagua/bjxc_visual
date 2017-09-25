package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyService;
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
		
		return false;
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
