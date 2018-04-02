package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptContacts;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptContactsVo;
import com.chinawiserv.dsp.base.mapper.system.SysDeptContactsMapper;
import com.chinawiserv.dsp.base.service.system.ISysDeptContactsService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 部门联系人 服务实现类
 * </p>
 *
 * @author tx123
 * @since 2018-03-30
 */
@Service
public class SysDeptContactsServiceImpl extends CommonServiceImpl<SysDeptContactsMapper, SysDeptContacts , SysDeptContactsVo> implements ISysDeptContactsService {

    @Autowired
    private SysDeptContactsMapper mapper;


    @Override
    public boolean insertVO(SysDeptContactsVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(SysDeptContactsVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public SysDeptContactsVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysDeptContactsVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}

    @Override
    public List<SysDeptContacts> listBySystemId(String systemId) {
        return mapper.listBySystemId(systemId);
    }

    @Override
    public boolean insertOrUpdate(List<SysDeptContacts> list) {
        //1获取Ids集合
        List<String> firstds=list.stream().map(e -> e.getId()).collect(Collectors.toList());
        //2删除已被删除的数据（逻辑删除无需此操作）

        //3获取已经存在的数据
        List<SysDeptContacts> existList=mapper.listByList(firstds);
        //4删除无需操作的数据
        list.removeAll(existList);
        if (list.size()==0){
            return false;
        }
        List<String> secondIds=list.stream().map(e -> e.getId()).collect(Collectors.toList());

        //5获取需要更新的Id
        List<String> needUpdateIds=mapper.listIdsByList(secondIds);

        if (needUpdateIds!=null&&needUpdateIds.size()>0){
            for (SysDeptContacts dept : list) {
                if (needUpdateIds.contains(dept.getId())){
                    mapper.updateById(dept);
                }else{
                    mapper.insert(dept);
                }
            }
        }else{
            //批量插入
            mapper.batchInsert(list);
        }

        return true;
    }
}
