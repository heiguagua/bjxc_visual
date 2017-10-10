package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDictCategory;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictCategoryVo;
import com.chinawiserv.dsp.base.mapper.system.SysDictCategoryMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysDictCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统字典表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
@Service
public class SysDictCategoryServiceImpl extends CommonServiceImpl<SysDictCategoryMapper, SysDictCategory, SysDictCategoryVo> implements ISysDictCategoryService {

    @Autowired
    private SysDictCategoryMapper mapper;


    @Override
    public boolean insertVO(SysDictCategoryVo vo) throws Exception {
		return insert(vo);
    }

    @Override
    public boolean updateVO(SysDictCategoryVo vo) throws Exception {
        return updateById(vo);
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public Page<SysDictCategoryVo> selectCategoryVoPage(Map<String, Object> paramMap) throws Exception {
        Page<SysDictCategoryVo> page = getPage(paramMap);
        List<SysDictCategoryVo> dictCategoryVos = mapper.selectCategoryVoPage(page,paramMap);
        page.setRecords(dictCategoryVos);
        return page;
    }


    @Override
    public SysDictCategoryVo selectVoById(String id) throws Exception {
		return mapper.selectVoById(id);
	}

    @Override
    public boolean updateCategoryVO(SysDictCategoryVo vo) throws Exception {
        return mapper.baseUpdate(vo);
    }

    @Override
    public int deleteByCategoryCode(Map<String , Object> map) throws Exception {
        return mapper.deleteByCategory(map);
    }


    @Override
    public Page<SysDictCategoryVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}


}
