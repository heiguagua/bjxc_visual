package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysRegionDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysRegionDeptVo;
import com.chinawiserv.dsp.base.mapper.system.SysRegionDeptMapper;
import com.chinawiserv.dsp.base.service.system.ISysRegionDeptService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 行政部门表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-10-08
 */
@Service
public class SysRegionDeptServiceImpl extends CommonServiceImpl<SysRegionDeptMapper, SysRegionDept , SysRegionDeptVo> implements ISysRegionDeptService {

    @Autowired
    private SysRegionDeptMapper mapper;


    @Override
    public boolean insertVO(SysRegionDeptVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(SysRegionDeptVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public SysRegionDeptVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysRegionDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public List<SysRegionDeptVo> selectVoList(Map<String, Object> paramMap) throws Exception {
        return mapper.selectVoListForTreeData(paramMap);
    }
}
