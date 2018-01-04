package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapSystemUseDept;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapSystemUseDeptVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapSystemUseDeptMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapSystemUseDeptService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 信息系统使用单位 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapSystemUseDeptServiceImpl extends CommonServiceImpl<DrapSystemUseDeptMapper, DrapSystemUseDept , DrapSystemUseDeptVo> implements IDrapSystemUseDeptService {

    @Autowired
    private DrapSystemUseDeptMapper mapper;


    @Override
    public boolean insertVO(DrapSystemUseDeptVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DrapSystemUseDeptVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DrapSystemUseDeptVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DrapSystemUseDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public void deleteByIds(List<String> ids) {
        mapper.deleteByIds(ids);
    }
}
