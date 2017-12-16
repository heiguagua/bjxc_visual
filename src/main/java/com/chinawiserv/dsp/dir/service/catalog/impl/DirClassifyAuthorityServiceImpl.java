package com.chinawiserv.dsp.dir.service.catalog.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityVo;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassify;
import com.chinawiserv.dsp.dir.entity.po.catalog.DirClassifyAuthority;
import com.chinawiserv.dsp.dir.entity.vo.catalog.DirClassifyAuthorityVo;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyAuthorityMapper;
import com.chinawiserv.dsp.dir.mapper.catalog.DirClassifyMapper;
import com.chinawiserv.dsp.dir.service.catalog.IDirClassifyAuthorityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private DirClassifyMapper classifyMapper;


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

    @Override
    public List<String> selectAllSuperiorIds(Map<String, Object> paramMap) {
//        List<DirClassify>  dirClassifyList= new ArrayList();
//        List<DirClassifyAuthorityVo> vos = mapper.selectVoList(paramMap);
//        List<String>  list=vos.stream().map(vo -> vo.getClassifyId()).collect(Collectors.toList());
//        while (list!=null && !list.isEmpty()){
//            List<DirClassify> existList=classifyMapper.listByList(list);
//            dirClassifyList.removeAll(existList);
//            dirClassifyList.addAll(existList);
//            list=existList.stream().map(dirClassify -> dirClassify.getFid()).collect(Collectors.toList());
//        }
//
//        return  dirClassifyList.stream().map(dirClassify -> dirClassify.getId()).collect(Collectors.toList());
        return mapper.getAllClassifyParentNode(paramMap);
    }

    @Override
    public List<String> getSelectedNodeByCurrentNode(Map<String, Object> paramMap) {
        return mapper.getSelectedNodeByCurrentNode(paramMap);
    }
}
