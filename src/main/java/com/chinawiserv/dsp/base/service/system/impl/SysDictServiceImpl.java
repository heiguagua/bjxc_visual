package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysDict;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import com.chinawiserv.dsp.base.enums.system.DictEnum;
import com.chinawiserv.dsp.base.mapper.system.SysDictMapper;
import com.chinawiserv.dsp.base.service.system.ISysDictService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.enums.EnumTools;
import com.chinawiserv.dsp.dir.schema.DictConstantMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * <p>
 * 系统字典表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
@Service
public class SysDictServiceImpl extends CommonServiceImpl<SysDictMapper, SysDict, SysDictVo> implements ISysDictService {

    @Autowired
    private SysDictMapper mapper;


    @Override
    public boolean insertVO(SysDictVo vo) throws Exception {
        vo.setId(CommonUtil.get32UUID());
        vo.setCreateUserId(ShiroUtils.getLoginUserId());
        vo.setCreateTime(new Date());
		return insert(vo);
    }

    @Override
    public boolean updateVO(SysDictVo vo) throws Exception {
        return false;
    }

    @Override
    public boolean updateDetailVO(SysDictVo vo) throws Exception {
        vo.setUpdateUserId(ShiroUtils.getLoginUserId());
        vo.setUpdateTime(new Date());
        return updateById(vo);
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
    public SysDictVo selectVoDetailById(String id) throws Exception {
        return mapper.selectDetailVoById(id);
    }

    @Override
    public Page<SysDictVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        List<SysDictVo> rows;
        Page<SysDictVo> page = getPage(paramMap);
        List<SysDictVo> dictVos = mapper.selectVoPage(page,paramMap);
        if (dictVos != null && !dictVos.isEmpty()){
            rows = new ArrayList(dictVos.size());
            for (SysDictVo vo : dictVos){
                String status = vo.getStatus().toString();
                vo.setStateName(DictEnum.valueOf(EnumTools.getName(status)).getChValue());
                rows.add(vo);
            }
        }else {
            rows = new ArrayList(0);
        }
        page.setRecords(rows);
        return page;
	}
    @Override
    public boolean deleteDictById(String id) throws Exception {
            SysDict sysDict = new SysDict();
            sysDict.setId(id);
            sysDict.setDeleteFlag(1);
            return updateById(sysDict);

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

    @Override
	public List<SysDictVo> selectVoCategoryList(Map<String, Object> paramMap) {
		return mapper.selectVoListForTreeData(paramMap);
	}
    @Override
    public String selectDictcodeByCategoryAndName(String dict_name,String category){
        String dictCode=null;
        String code = DictConstantMap.getDictCode(dict_name + ':' + category);
        if(""==code){
            if(!StringUtils.isEmpty(dict_name)&&!StringUtils.isEmpty(category)){
                dictCode= mapper.selectDictcodeByCategoryAndName(dict_name, category);
                DictConstantMap.putKeyValue(dict_name + ':' + category,dictCode);
            }
        }else{
            dictCode=code;
        }
        return dictCode;
    }
}
