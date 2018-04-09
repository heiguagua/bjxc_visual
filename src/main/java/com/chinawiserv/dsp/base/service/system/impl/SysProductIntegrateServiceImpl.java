package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.SystemConst;
import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.entity.po.system.SysProductIntegrate;
import com.chinawiserv.dsp.base.entity.vo.system.SysIconVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysProductIntegrateVo;
import com.chinawiserv.dsp.base.mapper.system.SysIconMapper;
import com.chinawiserv.dsp.base.mapper.system.SysProductIntegrateMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysProductIntegrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品集成表 服务实现类
 * </p>
 *
 * @author tx
 * @since 2017-11-07
 */
@Service
public class SysProductIntegrateServiceImpl extends CommonServiceImpl<SysProductIntegrateMapper, SysProductIntegrate , SysProductIntegrateVo> implements ISysProductIntegrateService {

    @Autowired
    private SysProductIntegrateMapper mapper;

    @Autowired
    private SysIconMapper iconMapper;


    @Override
    public boolean insertVO(SysProductIntegrateVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(SysProductIntegrateVo vo) throws Exception {
		return updateById(vo);
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public SysProductIntegrateVo selectVoById(String id) throws Exception {
		return mapper.selectVoById(id);
	}

    @Override
    public Page<SysProductIntegrateVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<SysProductIntegrateVo> page = getPage(paramMap);
        page.setOrderByField("order_number");
        List<SysProductIntegrateVo> pageList = mapper.selectVoPage(page, paramMap);
        page.setRecords(pageList);
        return page;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public SysProductIntegrateVo getTheMaster() throws ErrorInfoException {
        List<SysProductIntegrateVo> list = mapper.getTheMaster();
        if(list==null||list.isEmpty()){
            return null;
        }
        if(list.size()==1){
            return list.get(0);
        }
        throw  new ErrorInfoException("系统错误，主系统不止一个");
    }

    @Override
    public SysProductIntegrateVo getTheDeptMaster() throws ErrorInfoException {
        SysProductIntegrateVo vo = mapper.selectVoByProductNo(SystemConst.SYS_INTEGRATE_DEPT_HIGHT_RC);

        if(vo !=null&&vo.getIntegrateFlag().equals(1)){
            return vo;
        }

        return  this.getTheMaster();
    }

    @Override
    public List<SysIconVo> selectIcon() {
        Map paramMap = new HashMap();
        paramMap.put("iconType", "integrate_icon");
        return iconMapper.selectIconList(paramMap);
    }


}
