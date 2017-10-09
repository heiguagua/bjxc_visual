package com.chinawiserv.dsp.dir.service.configure.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.configure.DirSpecialApps;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import com.chinawiserv.dsp.dir.entity.vo.configure.DirSpecialAppsVo;
import com.chinawiserv.dsp.dir.mapper.configure.DirSpecialAppsMapper;
import com.chinawiserv.dsp.dir.service.configure.IDirSpecialAppsService;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

	
}
