package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysGuidDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUserRole;
import com.chinawiserv.dsp.base.entity.vo.system.SysGuidDeptVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.mapper.system.SysGuidDeptMapper;
import com.chinawiserv.dsp.base.service.system.ISysGuidDeptService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 业务指导部门记录表 服务实现类
 * </p>
 *
 * @author tx123
 * @since 2018-04-09
 */
@Service
public class SysGuidDeptServiceImpl extends CommonServiceImpl<SysGuidDeptMapper, SysGuidDept , SysGuidDeptVo> implements ISysGuidDeptService {

    @Autowired
    private SysGuidDeptMapper mapper;


    @Override
    public boolean insertVO(SysGuidDeptVo vo) throws Exception {
        vo.setId(CommonUtil.get32UUID());
        insert(vo);
        return true;
    }

    @Override
    public boolean updateVO(SysGuidDeptVo vo) throws Exception {
        updateById(vo);
        return true;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public SysGuidDeptVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysGuidDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public List<SysGuidDeptVo> selectVoList(String curDeptId) {
        return mapper.selectVoList(curDeptId);
    }

}
