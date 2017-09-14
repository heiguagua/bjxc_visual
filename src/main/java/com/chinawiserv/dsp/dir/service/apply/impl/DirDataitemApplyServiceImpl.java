package com.chinawiserv.dsp.dir.service.apply.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataitemApply;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataitemApplyVo;
import com.chinawiserv.dsp.dir.enums.EnumTools;
import com.chinawiserv.dsp.dir.enums.apply.DataItemStatus;
import com.chinawiserv.dsp.dir.mapper.apply.DirDataitemApplyMapper;
import com.chinawiserv.dsp.dir.service.apply.IDirDataitemApplyService;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据项权限申请表 服务实现类
 * </p>
 *
 * @author wuty
 * @since 2017-09-11
 */
@Service
public class DirDataitemApplyServiceImpl extends CommonServiceImpl<DirDataitemApplyMapper, DirDataitemApply , DirDataitemApplyVo> implements IDirDataitemApplyService {

    @Autowired
    private DirDataitemApplyMapper dirDataitemApplyMapper;


    @Override
    public boolean insertVO(DirDataitemApplyVo vo) throws Exception {
		//todo
		return false;
    }

    @Override
    public boolean updateVO(DirDataitemApplyVo vo) throws Exception {
		//todo
		return false;
	}

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
		//todo
		return false;
	}

    @Override
    public DirDataitemApplyVo selectVoById(String id) throws Exception {
		return null;
	}

    @Override
    public Page<DirDataitemApplyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        List<DirDataitemApplyVo> rows;
        Page<DirDataitemApplyVo> page = getPage(paramMap);
        page.setOrderByField("apply_date");
        page.setAsc(false);
        List<DirDataitemApplyVo> dirRegistUserVos = dirDataitemApplyMapper.selectVoPage(page,paramMap);
        if (dirRegistUserVos != null && !dirRegistUserVos.isEmpty()){
            rows = new ArrayList(dirRegistUserVos.size());
            for (DirDataitemApplyVo vo : dirRegistUserVos){
                String status = vo.getStatus();
                String applicationId = vo.getApplicantId();
                String appilicatinDept = dirDataitemApplyMapper.selectDeptNameById(applicationId);
                vo.setAppilicatinDept(appilicatinDept);
//                vo.setStateName("待审核");
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
