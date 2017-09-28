package com.chinawiserv.dsp.dir.service.drap.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.drap.DrapDbInfo;
import com.chinawiserv.dsp.dir.entity.vo.drap.DrapDbInfoVo;
import com.chinawiserv.dsp.dir.mapper.drap.DrapDbInfoMapper;
import com.chinawiserv.dsp.dir.service.drap.IDrapDbInfoService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
            if (null==drapDbInfoVo) {
                continue ;
            }
            
            // 插入db信息
            drapDbInfoVo.setId(UUID.randomUUID().toString());
            mapper.insert(drapDbInfoVo);
            
            //插入系统信息

            if (null!=drapDbInfoVo.getSystems()) {
                String [] sysIds=drapDbInfoVo.getSystems().split(",");
                for (String sysId : sysIds) {
                    mapper.insertSysMap(UUID.randomUUID().toString(),drapDbInfoVo.getId(),sysId);
                }
            }
            
        }
    }

}
