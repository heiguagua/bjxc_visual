package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysDeptAuthority;
import com.chinawiserv.dsp.base.entity.po.system.SysUserRole;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptAuthorityVo;
import com.chinawiserv.dsp.base.enums.system.AuthObjTypeEnum;
import com.chinawiserv.dsp.base.mapper.system.SysDeptAuthorityMapper;
import com.chinawiserv.dsp.base.service.system.ISysDeptAuthorityService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 部门数据权限分配表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
@Service
public class SysDeptAuthorityServiceImpl extends CommonServiceImpl<SysDeptAuthorityMapper, SysDeptAuthority , SysDeptAuthorityVo> implements ISysDeptAuthorityService {

    @Autowired
    private SysDeptAuthorityMapper mapper;


    @Override
    public boolean insertVO(SysDeptAuthorityVo vo) throws Exception {
        String authObjIds = vo.getAuthObjIds();
        if(StringUtils.isNotBlank(authObjIds)){
            String[] authObjIdArray = authObjIds.split(",");
            for(String authObjId : authObjIdArray){
                if(StringUtils.isNotBlank(authObjId)){
                    vo.setId(CommonUtil.get32UUID());
                    vo.setAuthObjType(AuthObjTypeEnum.DEPT.getKey());
                    vo.setAuthObjId(authObjId);
                    vo.setDistributorId(ShiroUtils.getLoginUserId());
                    vo.setDistributeDate(new Date());
                    vo.setIsFromAudit("0");
                    if(!insert(vo)){
                        throw new Exception("添加部门数据权限失败！");
                    }
                }
            }
        }
		return true;
    }

    @Override
    public boolean updateVO(SysDeptAuthorityVo vo) throws Exception {
        //删除已有权限
        mapper.delete(new EntityWrapper<SysDeptAuthority>().eq("dept_id", vo.getDeptId()));
		return this.insertVO(vo);
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		return false;
	}

    @Override
    public SysDeptAuthorityVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<SysDeptAuthorityVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
		return null;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		return 0;
	}

    @Override
    public List<SysDeptAuthorityVo> selectVoList(Map<String, Object> paramMap) {
        return mapper.selectVoList(paramMap);
    }
}
