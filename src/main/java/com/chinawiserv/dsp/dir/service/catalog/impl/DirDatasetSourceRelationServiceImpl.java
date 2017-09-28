package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirDatasetSourceRelation;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirDatasetSourceRelationVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirDatasetSourceRelationMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirDatasetSourceRelationService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 信息资源来源关系表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirDatasetSourceRelationServiceImpl extends CommonServiceImpl<DirDatasetSourceRelationMapper, DirDatasetSourceRelation, DirDatasetSourceRelationVo> implements IDirDatasetSourceRelationService {

    @Autowired
    private DirDatasetSourceRelationMapper mapper;


    @Override
    public boolean insertVO(DirDatasetSourceRelationVo vo) throws Exception {
        //todo
        return false;
    }

    @Override
    public boolean updateVO(DirDatasetSourceRelationVo vo) throws Exception {
        //todo
        return false;
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    /**
     * 传入参数删除关系
     * id：根据id删除
     * dataset_id：删除数据集下所有关系
     * @param paramMap
     * @return
     */
    @Override
    public boolean deleteByParams(Map<String, Object> paramMap){
        //todo
        boolean b = true;
        if (paramMap.containsKey("id") || paramMap.containsKey("dataset_id")) {
            int i = mapper.deleteByMap(paramMap);
            if (i <= 0) {
                b = false;
            }
        } else {
            b = false;
        }
        return b;
    }

    @Override
    public DirDatasetSourceRelationVo selectVoById(String id) throws Exception {
        return null;
    }

    @Override
    public Page<DirDatasetSourceRelationVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        //todo
        return null;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        //todo
        return 0;
    }

    /**
     * 插入关联关系
     * @param list
     * @param dataset_id
     * @return
     */
    @Override
    public int insertDatasetListRelation(List<DirDatasetSourceRelation> list, String dataset_id) {
        int i = 0;
        if (list != null && list.size() > 0) {
            List<DirDatasetSourceRelation> insertList = new ArrayList<DirDatasetSourceRelation>();
            for (DirDatasetSourceRelation relation : list) {
                if (relation != null) {
                    relation.setId(UUID.randomUUID().toString());
                    relation.setDatasetId(dataset_id);
                    insertList.add(relation);
                }
            }
            if(insertList!=null&&insertList.size()>0){
                i = mapper.insertDatasetListRelation(insertList);
            }
        }
        return i;
    }

    /**
     * 获取数据集下的所有关系
     * @param dataset_id
     * @return
     */
    @Override
    public List<DirDatasetSourceRelation> selectRelationsByDatasetId(String dataset_id) {
        List<DirDatasetSourceRelation> list=null;
        if(StringUtils.isNotEmpty(dataset_id)){
            list=mapper.selectRelationsByDatasetId(dataset_id);
        }
        return list;
    }
}
