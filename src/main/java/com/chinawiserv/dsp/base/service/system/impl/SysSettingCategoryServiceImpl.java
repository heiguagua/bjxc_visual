package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysSettingCategory;
import com.chinawiserv.dsp.base.entity.vo.system.SysSettingCategoryVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysSettingVo;
import com.chinawiserv.dsp.base.mapper.system.SysSettingCategoryMapper;
import com.chinawiserv.dsp.base.service.system.ISysSettingCategoryService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * <p>
 * 系统配置类型表 服务实现类
 * </p>
 *
 * @author tx123
 * @since 2018-03-13
 */
@Service
public class SysSettingCategoryServiceImpl extends CommonServiceImpl<SysSettingCategoryMapper, SysSettingCategory , SysSettingCategoryVo> implements ISysSettingCategoryService {

    @Autowired
    private SysSettingCategoryMapper mapper;


    @Override
    public boolean insertVO(SysSettingCategoryVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(SysSettingCategoryVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public SysSettingCategoryVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysSettingCategoryVo> selectVoPage(Map<String, Object> paramMap)  {
        final Page<SysSettingCategoryVo> page = getPage(paramMap);
        page.setRecords(mapper.selectVoPage(page,paramMap));
        return page;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public SysSettingCategoryVo selectById(String categoryCode) {
        return mapper.selectVoById(categoryCode);
    }

    @Override
    public boolean updateById(SysSettingCategoryVo vo) {
        return retBool(mapper.baseUpdate(vo));
    }
}
