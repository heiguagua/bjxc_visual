package com.chinawiserv.dsp.dir.service.api.impl;

import com.chinawiserv.dsp.dir.mapper.api.ApiMapper;
import com.chinawiserv.dsp.dir.service.api.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Author:GongJun
 * Date:2017/9/19
 * Time:16:20
 * Chinawiserv Technologies Co., Ltd.
 */
@Service
public class ApiServiceImpl implements IApiService {
    @Autowired
    private ApiMapper mapper;

    @Override
    public List<Map<String, Object>> test(Map<String, Object> paramMap) {
        return mapper.test(paramMap);
    }
    /**
     * 根据目录ID查询子目录
     * */
    @Override
    public List<Map<String, Object>> getSubDirectoryById(Map<String, Object> paramMap) {
        return mapper.getSubDirectoryById(paramMap);
    }
    /**
     * 查询数据集下面的数据项
     * */
    @Override
    public List<Map<String, Object>> getSubDataItemById(Map<String, Object> paramMap) {
        return mapper.getSubDataItemById(paramMap);
    }

    @Override
    public List<Map<String, Object>> getDatasetByClassifyId(Map<String, Object> paramMap) {
        return mapper.getDatasetByClassifyId(paramMap);
    }

    @Override
    public List<Map<String, Object>> getDbInfoByDatasetId(Map<String, Object> paramMap) {
        return mapper.getDbInfoByDatasetId(paramMap);
    }

    @Override
    public List<Map<String, Object>> getItemAndTableInfoByDatasetId(Map<String, Object> paramMap) {
        return mapper.getItemAndTableInfoByDatasetId(paramMap);
    }
    /**
     * 发布服务，往表插入数据
     * */
    @Override
    public boolean releaseService(Map<String, Object> paramMap) {
        return false;
    }
}
