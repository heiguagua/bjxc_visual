package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthorityApply;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityApplyVo;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;
import com.chinawiserv.dsp.base.mapper.system.SysDeptAuthorityApplyMapper;
import com.chinawiserv.dsp.base.service.system.ISysDeptAuthorityApplyService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据权限申请表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-25
 */
@Service
public class SysDeptAuthorityApplyServiceImpl extends CommonServiceImpl<SysDeptAuthorityApplyMapper, SysDeptAuthorityApply , SysDeptAuthorityApplyVo> implements ISysDeptAuthorityApplyService {

    @Autowired
    private SysDeptAuthorityApplyMapper mapper;


    @Override
    public boolean insertVO(SysDeptAuthorityApplyVo vo) throws Exception {
        String applicant = vo.getApplicant();
        if(StringUtils.isBlank(applicant)){
            applicant = ShiroUtils.getLoginUserId();
        }
        String toDeptIds = vo.getToDeptIds();
        if(StringUtils.isNoneBlank(applicant, toDeptIds)) {
            String[] toDeptIdArray = toDeptIds.split(",");
            Map paramMap = new HashMap();
            paramMap.put("applicant", applicant);
            paramMap.put("toDeptIds", toDeptIdArray);
            int count = selectVoCount(paramMap);
            if(count <= 0){
                for (String toDeptId : toDeptIdArray) {
                    SysDeptAuthorityApply apply = new SysDeptAuthorityApply();
                    apply.setId(CommonUtil.get32UUID());
                    apply.setApplicant(applicant);
                    apply.setToDeptId(toDeptId);
                    apply.setApplyTime(new Date());
                    apply.setAuditStatus("0");
                    if (!insert(apply)) {
                        throw new Exception("添加部门数据权限申请失败！");
                    }
                }
                return true;
            }else throw new Exception("重复添加部门数据权限申请！");
        }
        return false;
    }

    @Override
    public boolean updateVO(SysDeptAuthorityApplyVo vo) throws Exception {
        return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		return false;
	}

    @Override
    public SysDeptAuthorityApplyVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysDeptAuthorityApplyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        paramMap.put("applicant", ShiroUtils.getLoginUserId());
        Page<SysDeptAuthorityApplyVo> page = getPage(paramMap);
        page.setOrderByField("apply_time");
        page.setAsc(false);
        List<SysDeptAuthorityApplyVo> sysDeptAuthorityApplyVos = mapper.selectVoPage(page, paramMap);
        page.setRecords(sysDeptAuthorityApplyVos);
        page.setTotal(mapper.selectVoCount(paramMap));
		return page;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		return mapper.selectVoCount(paramMap);
	}
}
