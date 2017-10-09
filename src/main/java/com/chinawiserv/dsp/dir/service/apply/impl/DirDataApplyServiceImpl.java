package com.chinawiserv.dsp.dir.service.apply.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataApply;
import com.chinawiserv.dsp.dir.entity.po.apply.DirDataItemApply;
import com.chinawiserv.dsp.dir.entity.vo.apply.DirDataApplyVo;
import com.chinawiserv.dsp.dir.enums.apply.DataItemStatus;
import com.chinawiserv.dsp.dir.mapper.apply.DirDataApplyMapper;
import com.chinawiserv.dsp.dir.mapper.apply.DirDataItemApplyMapper;
import com.chinawiserv.dsp.dir.service.apply.IDirDataApplyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DirDataApplyServiceImpl extends CommonServiceImpl<DirDataApplyMapper, DirDataApply, DirDataApplyVo> implements IDirDataApplyService {

    @Autowired
    private DirDataApplyMapper mapper;

    @Autowired
    private DirDataItemApplyMapper dirDataItemApplyMapper;

    @Override
    public boolean insertVO(DirDataApplyVo dirDataApplyVo) throws Exception {
        return false;
    }

    @Override
    public boolean updateVO(DirDataApplyVo dirDataApplyVo) throws Exception {
        dirDataApplyVo.setAuditorId(ShiroUtils.getLoginUserId());
        dirDataApplyVo.setAuditDate(new Date());
        boolean result = updateById(dirDataApplyVo);
        if(result){
            List<DirDataItemApply> dirDataItemApplyList = dirDataApplyVo.getDirDataItemApplyList();
            if(dirDataItemApplyList != null && !dirDataItemApplyList.isEmpty()){
                for(DirDataItemApply dirDataItemApply : dirDataItemApplyList){
                    String status = dirDataItemApply.getStatus();
                    if(StringUtils.isBlank(status)){
                        dirDataItemApply.setStatus(dirDataApplyVo.getStatus());
                    }
                    result &= dirDataItemApplyMapper.updateById(dirDataItemApply) > 0;
                }
            }
        }
        if(!result) throw new Exception("编辑数据权限申请表失败");
        return result;
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    @Override
    public DirDataApplyVo selectVoById(String id) throws Exception {
        return mapper.selectVoById(id);
    }

    @Override
    public Page<DirDataApplyVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Page<DirDataApplyVo> page = getPage(paramMap);
        page.setOrderByField("apply_date");
        page.setAsc(false);
        page.setTotal(mapper.selectVoCount(paramMap));
        page.setRecords(mapper.selectVoPage(page, paramMap));
        return page;
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return 0;
    }
}
