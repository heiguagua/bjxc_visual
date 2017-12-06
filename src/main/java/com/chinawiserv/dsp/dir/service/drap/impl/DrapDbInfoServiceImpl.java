package com.chinawiserv.dsp.dir.service.drap.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbInfo;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbSystemMap;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDictTableColumn;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDictTableInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbInfoVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableColumnVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableInfoVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDictTableColumnVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDictTableInfoVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbInfoMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbSystemMapMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbTableColumnMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbTableInfoMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDictTableColumnMapper;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDictTableInfoMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDbInfoService;

/**
 * <p>
 * 数据库信息 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-27
 */
@Service
public class DrapDbInfoServiceImpl extends
		CommonServiceImpl<DrapDbInfoMapper, DrapDbInfo, DrapDbInfoVo> implements
		IDrapDbInfoService {

	@Autowired
	private DrapDbInfoMapper mapper;

	@Autowired
	private DrapDbTableInfoMapper dbTableInfoMapper;

	@Autowired
	private DrapDbTableColumnMapper dbTableColumnMapper;

	@Autowired
	private DrapDictTableInfoMapper dictTableInfoMapper;

	@Autowired
	private DrapDictTableColumnMapper dictTableColumnMapper;

	@Autowired
	private DrapDbSystemMapMapper systemMapper;
	@Override
	public boolean insertVO(DrapDbInfoVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean updateVO(DrapDbInfoVo vo) throws Exception {
		// todo
		return false;
	}

	@Override
	public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		// todo
		return false;
	}

	@Override
	public DrapDbInfoVo selectVoById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<DrapDbInfoVo> selectVoPage(Map<String, Object> paramMap)
			throws Exception {
		// todo
		return null;
	}

	@Override
	public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		// todo
		return 0;
	}

	@Override
	public void receiveDbInfo(List<DrapDbInfoVo> vos) {
		Map<String, Object> paramMap = null;
		List<DrapDbSystemMap> drapDbSyMapLst = null;
		for (DrapDbInfoVo drapDbInfoVo : vos) {
			if (null == drapDbInfoVo) {
				continue;
			}
			drapDbSyMapLst = drapDbInfoVo.getDbSystemMapLst();
			paramMap = new HashMap<String, Object>(0);
			//新增系统
			if (drapDbSyMapLst != null && !drapDbSyMapLst.isEmpty())
			{
				for (DrapDbSystemMap system:drapDbSyMapLst)
				{
					paramMap.put("id", system.getId());
					systemMapper.baseDelete(paramMap);
					systemMapper.insert(system);
				}
			}
			paramMap.clear();
			paramMap.put("id", drapDbInfoVo.getId());
			mapper.baseDelete(paramMap);
			mapper.insert(drapDbInfoVo);
			// 插入系统信息

			if (null != drapDbInfoVo.getSystems()) {
				mapper.deleteSysMap(paramMap);
				String[] sysIds = drapDbInfoVo.getSystems().split(",");
				for (String sysId : sysIds) {
					mapper.insertSysMap(UUID.randomUUID().toString(),
							drapDbInfoVo.getId(), sysId);
				}
			}

			// 插入表信息

			if (null != drapDbInfoVo.getTableInfoVos()) {

				for (DrapDbTableInfoVo dbTableInfoVo : drapDbInfoVo
						.getTableInfoVos()) {
					paramMap = new HashMap<String, Object>(0);
					paramMap.put("id", dbTableInfoVo.getId());
					dbTableInfoMapper.deleteByMap(paramMap);
					dbTableInfoMapper.insert(dbTableInfoVo);
					paramMap.clear();
					paramMap.put("table_id", dbTableInfoVo.getId());
					dbTableColumnMapper.deleteByMap(paramMap);
					for (DrapDbTableColumnVo columnVo : dbTableInfoVo
							.getColumnVos()) {
						dbTableColumnMapper.insert(columnVo);
					}
				}
			}

			if (null != drapDbInfoVo.getDictTableInfoVos()) {

				for (DrapDictTableInfoVo dictTableInfoVo : drapDbInfoVo
						.getDictTableInfoVos()) {
					paramMap = new HashMap<String, Object>(0);
					paramMap.put("id", dictTableInfoVo.getId());
					dbTableInfoMapper.deleteByMap(paramMap);
					dictTableInfoMapper.insert(dictTableInfoVo);
					for (DrapDictTableColumnVo columnVo : dictTableInfoVo
							.getColumnVos()) {
						paramMap.clear();
						paramMap.put("table_id", dictTableInfoVo.getId());
						dictTableColumnMapper.insert(columnVo);
					}
				}
			}

		}
	}

	@Override
	public void receiveTableChange(Map<String, Object> map) {
		System.out.println("===============================");
		System.out.println(map);
		if (null != map.get("oldTable")) {
//			@SuppressWarnings("unchecked")
			List<DrapDbTableInfoVo> list = JSON.parseArray(map.get("oldTable").toString(), DrapDbTableInfoVo.class);

			for (DrapDbTableInfoVo dbTableInfoVo : list) {
				if (null != dbTableInfoVo.getUpdateChangeType()
						&& dbTableInfoVo.getUpdateChangeType().equals("delete")) {
					dbTableInfoMapper.deleteById(dbTableInfoVo.getId());
				}
				for (DrapDbTableColumnVo columnVo : dbTableInfoVo
						.getColumnVos()) {
					if (null != columnVo.getUpdateChangeType()
							&& columnVo.getUpdateChangeType().equals("delete")) {
						dbTableColumnMapper.deleteById(columnVo.getId());
					}
				}
			}

		}

		if (null != map.get("newTable")) {
//			@SuppressWarnings("unchecked")
//			List<DrapDbTableInfoVo> list = (List<DrapDbTableInfoVo>) map
//					.get("newTable");
			List<DrapDbTableInfoVo> list = JSON.parseArray(map.get("newTable").toString(), DrapDbTableInfoVo.class);
			
			for (DrapDbTableInfoVo dbTableInfoVo : list) {
				if (null != dbTableInfoVo.getUpdateChangeType()
						&& dbTableInfoVo.getUpdateChangeType().equals("add")) {
					dbTableInfoMapper.insert(dbTableInfoVo);
				} else if (null != dbTableInfoVo.getUpdateChangeType()
						&& dbTableInfoVo.getUpdateChangeType().equals("update")) {
					dbTableInfoMapper.updateById(dbTableInfoVo);
				}

				for (DrapDbTableColumnVo columnVo : dbTableInfoVo
						.getColumnVos()) {
					if (null != columnVo.getUpdateChangeType()
							&& columnVo.getUpdateChangeType().equals("add")) {
						dbTableColumnMapper.insert(columnVo);
					} else if (null != columnVo.getUpdateChangeType()
							&& columnVo.getUpdateChangeType().equals("update")) {
						dbTableColumnMapper.updateById(columnVo);
					}
				}
			}

		}

		 if (null!=map.get("dicTable")) {
		     
		    
		     
//		 @SuppressWarnings("unchecked")
//        List<DrapDictTableInfoVo> listJson=(List<DrapDictTableInfoVo>)map.get("dicTable");
		List<DrapDictTableInfoVo> listJson = JSON.parseArray(map.get("dicTable").toString(), DrapDictTableInfoVo.class);
		 
		List<DrapDictTableInfoVo> list=JSON.parseArray(JSON.toJSONString(listJson), DrapDictTableInfoVo.class);
		 
		 //删除之前的
		 List<String>ids=new ArrayList<>();
		 
		 List<DrapDictTableInfo> oldDictTableInfos=dictTableInfoMapper.selectList(new EntityWrapper<DrapDictTableInfo>().eq("db_id",  list.get(0).getDbId()));
		 for (DrapDictTableInfo drapDictTableInfo : oldDictTableInfos) {
		     ids.add(drapDictTableInfo.getId());
        }
		 
		 dictTableColumnMapper.delete(new EntityWrapper<DrapDictTableColumn>().in("table_id", ids));
         dictTableInfoMapper.delete(new EntityWrapper<DrapDictTableInfo>().eq("db_id", list.get(0).getDbId()) );
         
		 for (DrapDictTableInfoVo drapDictTableInfoVo : list) {
            dictTableInfoMapper.insert(drapDictTableInfoVo);
            for (DrapDictTableColumnVo dictTableColumnVo : drapDictTableInfoVo.getColumnVos()) {
                dictTableColumnMapper.insert(dictTableColumnVo);
            }
        }
		 
		 }

	}

}
