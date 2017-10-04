package com.chinawiserv.dsp.dir.service.drap.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbInfoVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableColumnVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbTableInfoVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDictTableColumnVo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDictTableInfoVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbInfoMapper;
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
                                   CommonServiceImpl<DrapDbInfoMapper, DrapDbInfo, DrapDbInfoVo>
                                   implements IDrapDbInfoService {

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

    @Override
    public boolean insertVO(DrapDbInfoVo vo) throws Exception {
        //todo
        return false;
    }

    @Override
    public boolean updateVO(DrapDbInfoVo vo) throws Exception {
        //todo
        return false;
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        //todo
        return false;
    }

    @Override
    public DrapDbInfoVo selectVoById(String id) throws Exception {
        return null;
    }

    @Override
    public Page<DrapDbInfoVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        //todo
        return null;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        //todo
        return 0;
    }

    @Override
    public void receiveDbInfo(List<DrapDbInfoVo> vos) {
        for (DrapDbInfoVo drapDbInfoVo : vos) {
            if (null == drapDbInfoVo) {
                continue;
            }

            mapper.insert(drapDbInfoVo);

            //插入系统信息

            if (null != drapDbInfoVo.getSystems()) {
                String[] sysIds = drapDbInfoVo.getSystems().split(",");
                for (String sysId : sysIds) {
                    mapper.insertSysMap(UUID.randomUUID().toString(), drapDbInfoVo.getId(), sysId);
                }
            }

            //插入表信息
            
            if (null!=drapDbInfoVo.getTableInfoVos()) {
                for (DrapDbTableInfoVo dbTableInfoVo : drapDbInfoVo.getTableInfoVos()) {
                    dbTableInfoMapper.insert(dbTableInfoVo);
                    for (DrapDbTableColumnVo columnVo : dbTableInfoVo.getColumnVos()) {
                        dbTableColumnMapper.insert(columnVo);
                    }
                }
            }
            
            if (null!=drapDbInfoVo.getDictTableInfoVos()) {
                for (DrapDictTableInfoVo dictTableInfoVo : drapDbInfoVo.getDictTableInfoVos()) {
                    dictTableInfoMapper.insert(dictTableInfoVo);
                    for (DrapDictTableColumnVo columnVo : dictTableInfoVo.getColumnVos()) {
                        dictTableColumnMapper.insert(columnVo);
                    }
                }
            }
           

        }
    }

    @Override
    public void receiveTableChange(Map<String, Object> map) {

        if (null != map.get("oldTable")) {
            @SuppressWarnings("unchecked")
            List<DrapDbTableInfoVo> list = (List<DrapDbTableInfoVo>) map.get("oldTable");

            for (DrapDbTableInfoVo dbTableInfoVo : list) {
                if (null != dbTableInfoVo.getUpdateChangeType()
                    && dbTableInfoVo.getUpdateChangeType().equals("delete")) {
                    dbTableInfoMapper.deleteById(dbTableInfoVo.getId());
                }
                for (DrapDbTableColumnVo columnVo : dbTableInfoVo.getColumnVos()) {
                    if (null != columnVo.getUpdateChangeType()
                        && columnVo.getUpdateChangeType().equals("delete")) {
                        dbTableColumnMapper.deleteById(columnVo.getId());
                    }
                }
            }

        }

        if (null != map.get("newTable")) {
            @SuppressWarnings("unchecked")
            List<DrapDbTableInfoVo> list = (List<DrapDbTableInfoVo>) map.get("newTable");

            for (DrapDbTableInfoVo dbTableInfoVo : list) {
                if (null != dbTableInfoVo.getUpdateChangeType()
                    && dbTableInfoVo.getUpdateChangeType().equals("add")) {
                    dbTableInfoMapper.insert(dbTableInfoVo);
                } else if (null != dbTableInfoVo.getUpdateChangeType()
                           && dbTableInfoVo.getUpdateChangeType().equals("update")) {
                    dbTableInfoMapper.updateById(dbTableInfoVo);
                }

                for (DrapDbTableColumnVo columnVo : dbTableInfoVo.getColumnVos()) {
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

        //        if (null!=map.get("dicTable")) {
        //            List<DrapDictTableInfoVo> list=(List<DrapDictTableInfoVo>) map.get("dicTable");
        //        }

    }

}
