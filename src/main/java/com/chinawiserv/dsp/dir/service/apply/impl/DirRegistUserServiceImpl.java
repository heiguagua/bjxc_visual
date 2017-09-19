package com.chinawiserv.dsp.dir.service.apply.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.dir.entity.po.apply.DirRegistUser;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirRegistUserVo;
import com.chinawiserv.dsp.dir.enums.EnumTools;
import com.chinawiserv.dsp.dir.enums.apply.RegistUserStatus;
import com.chinawiserv.dsp.dir.mapper.apply.DirRegistUserMapper;
import com.chinawiserv.dsp.dir.service.apply.IDirRegistUserService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户注册表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirRegistUserServiceImpl extends CommonServiceImpl<DirRegistUserMapper, DirRegistUser , DirRegistUserVo> implements IDirRegistUserService{

    @Autowired
    private DirRegistUserMapper dirRegistUserMapper;


    @Override
    public boolean insertVO(DirRegistUserVo dirRegistUserVo) throws Exception {
        dirRegistUserVo.setId(CommonUtil.get32UUID());
        dirRegistUserVo.setCreateTime(new Date());
        dirRegistUserVo.setStatus("0");
        return insert(dirRegistUserVo);
    }

    @Override
    public boolean updateVO(DirRegistUserVo vo) throws Exception {
		vo.setCreateTime(new Date());
		return updateById(vo);
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirRegistUserVo selectVoById(String id) throws Exception {
		return dirRegistUserMapper.selectVoById(id);
	}

    @Override
    public Page<DirRegistUserVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        List<DirRegistUserVo> rows;
        Page<DirRegistUserVo> page = getPage(paramMap);
        page.setOrderByField("create_time");
        page.setAsc(false);
        List<DirRegistUserVo> dirRegistUserVos = dirRegistUserMapper.selectVoPage(page,paramMap);
        if (dirRegistUserVos != null && !dirRegistUserVos.isEmpty()){
            rows = new ArrayList(dirRegistUserVos.size());
            for (DirRegistUserVo vo : dirRegistUserVos){
                String status = vo.getStatus();
                vo.setStateName(RegistUserStatus.valueOf(EnumTools.getName(status)).getChValue());
                rows.add(vo);
            }
        }else {
            rows = new ArrayList(0);
        }
        page.setRecords(rows);
		return page;
	}

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
		//todo
		return 0;
	}
}
