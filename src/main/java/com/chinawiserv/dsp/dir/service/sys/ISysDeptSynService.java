package com.chinawiserv.dsp.dir.service.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.vo.system.SysDeptVo;

import java.util.Map;

/**
 * Created by tangxiong on 2017/10/31.
 */
public interface ISysDeptSynService {

    Page<SysDeptVo> selectVoPage(Map<String, Object> paramMap) throws Exception;

    String insertIntoDir(Map<String, Object> paramMap);
}
