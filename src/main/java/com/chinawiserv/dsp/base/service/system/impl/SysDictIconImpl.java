package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysIcon;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysIconVo;
import com.chinawiserv.dsp.base.mapper.system.SysIconMapper;
import com.chinawiserv.dsp.base.service.system.ISysDictIcon;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
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
public class SysDictIconImpl extends CommonServiceImpl<SysIconMapper, SysIcon, SysIconVo> implements ISysDictIcon {

    @Autowired
    private SysIconMapper mapper;

	@Override
	public boolean insertVO(SysIconVo v) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateVO(SysIconVo v) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SysIconVo selectVoById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SysIconVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Map<String, SysIconVo>> getDictIconForSelect(Map<String, Object> paramMap) throws Exception {
		Map<String, Map<String, SysIconVo>> dicts = new HashMap();
        List<SysIconVo> sysIconVoList = mapper.selectIconList(paramMap);
        if(!ObjectUtils.isEmpty(sysIconVoList)){
            for(SysIconVo sysDictIconVo : sysIconVoList){
                String IconType = sysDictIconVo.getIconType();
                String dictCode = sysDictIconVo.getIconName();
                Map<String, SysIconVo> kv = dicts.get(IconType);//分类
                if(kv == null){
                    kv = new HashMap();
                    dicts.put(IconType, kv);
                }
                kv.put(dictCode, sysDictIconVo);
            }
        }

        return dicts;
    }
    
}
