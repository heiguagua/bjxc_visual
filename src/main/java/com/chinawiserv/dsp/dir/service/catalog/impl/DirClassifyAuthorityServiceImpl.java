package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassifyAuthority;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyAuthorityVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyAuthorityMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyAuthorityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 目录类别控制权限表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-08
 */
@Service
public class DirClassifyAuthorityServiceImpl extends CommonServiceImpl<DirClassifyAuthorityMapper, DirClassifyAuthority , DirClassifyAuthorityVo> implements IDirClassifyAuthorityService {

    @Autowired
    private DirClassifyAuthorityMapper mapper;


    @Override
    public boolean insertVO(DirClassifyAuthorityVo vo) throws Exception {
        String classifyIds = vo.getClassifyIds();
        if(StringUtils.isNotBlank(classifyIds)){
            String[] classifyIdArray = classifyIds.split(",");
            for(String classifyId : classifyIdArray){
                if(StringUtils.isNotBlank(classifyId)){
                    vo.setId(CommonUtil.get32UUID());
                    vo.setClassifyId(classifyId);
                    vo.setDistributorId(ShiroUtils.getLoginUserId());
                    vo.setDistributeDate(new Date());
                    if(!insert(vo)){
                        throw new Exception("添加用户数据权限失败！");
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean updateVO(DirClassifyAuthorityVo vo) throws Exception {
        //删除已有权限
        mapper.deleteByVo(vo);
        String classifyIds = vo.getClassifyIds();
        if(StringUtils.isNotBlank(classifyIds)){
            vo.setClassifyIdArray(classifyIds.split(","));
            return this.insertVO(vo);
        }
        return true;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) {
		//todo
		return false;
	}

    @Override
    public DirClassifyAuthorityVo selectVoById(String id) {
		return null;
	}

    @Override
    public Page<DirClassifyAuthorityVo> selectVoPage(Map<String, Object> paramMap) {
		//todo
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) {
		//todo
		return 0;
	}

    @Override
    public List<DirClassifyAuthorityVo> selectVoList(Map<String, Object> paramMap) {
        return mapper.selectVoList(paramMap);
    }
}
