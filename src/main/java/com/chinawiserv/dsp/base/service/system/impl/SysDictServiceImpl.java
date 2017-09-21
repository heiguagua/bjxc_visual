package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDict;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import com.chinawiserv.dsp.base.mapper.system.SysDictMapper;
import com.chinawiserv.dsp.base.service.system.ISysDictService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
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
public class SysDictServiceImpl extends CommonServiceImpl<SysDictMapper, SysDict , SysDictVo> implements ISysDictService {

    @Autowired
    private SysDictMapper mapper;


    @Override
    public boolean insertVO(SysDictVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(SysDictVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public SysDictVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysDictVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public Map<String, Map<String, SysDictVo>> getDictDataForSelect(Map<String, Object> paramMap) throws Exception {
        Map<String, Map<String, SysDictVo>> dicts = new HashMap();
        List<SysDictVo> sysDictVoList = mapper.selectDictList(paramMap);
        if(!ObjectUtils.isEmpty(sysDictVoList)){
            for(SysDictVo sysDictVo : sysDictVoList){
                String category = sysDictVo.getCategory();
                String dictCode = sysDictVo.getDictCode();
                Map<String, SysDictVo> kv = dicts.get(category);//分类
                if(kv == null){
                    kv = new HashMap();
                    dicts.put(category, kv);
                }
                kv.put(dictCode, sysDictVo);
            }
        }

        return dicts;
    }
}
