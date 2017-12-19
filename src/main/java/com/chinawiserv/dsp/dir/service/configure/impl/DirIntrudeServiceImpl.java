package com.chinawiserv.dsp.dir.service.configure.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirIntrude;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirIntrudeVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirIntrudeMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirIntrudeService;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 政策表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirIntrudeServiceImpl extends CommonServiceImpl<DirIntrudeMapper, DirIntrude , DirIntrudeVo> implements IDirIntrudeService {

    @Autowired
    private DirIntrudeMapper mapper;

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
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

	@Override
	public boolean insertVO(DirIntrudeVo vo) throws Exception {
		//todo
		if(vo.getContent().length()>32116){
    		throw new Exception("内容太长，无法保存");
    	}
        boolean b=true;
        vo.setId(CommonUtil.get32UUID());
        vo.setPublishDate(new Date());
        String loginUserId = ShiroUtils.getLoginUserId();
    	vo.setPublisher(loginUserId);
    	vo.setDeleteFlag(0);
    	
        int i = mapper.baseInsert(vo);
        if(i<1){
            b=false;
        }
        return b;
	}

	@Override
	public boolean updateVO(DirIntrudeVo vo) throws Exception {
		//todo
		if(vo.getContent().length()>32116){
    		throw new Exception("内容太长，无法保存");
    	}
        boolean b=true;
        vo.setPublishDate(new Date());
        String loginUserId = ShiroUtils.getLoginUserId();
    	vo.setPublisher(loginUserId);
        int i = mapper.baseUpdate(vo);
        
        if(i<1){
            b=false;
        }
        return b;
	}


	@Override
	public DirIntrudeVo selectVoById(String id) throws Exception {
		return mapper.selectVoById(id);
	}


	@Override
	public Page<DirIntrudeVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		Page<DirIntrudeVo> page = getPage(paramMap);
//        page.setOrderByField("create_time");
        page.setAsc(false);
        List<DirIntrudeVo> voPage = mapper.selectVoPage(page, paramMap);
        page.setTotal(mapper.selectVoCount(paramMap));
        page.setRecords(voPage);
        return page;
	}

	
	
}
