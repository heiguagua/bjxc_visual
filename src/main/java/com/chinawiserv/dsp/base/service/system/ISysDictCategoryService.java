package com.chinawiserv.dsp.base.service.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysDictCategory;
import com.chinawiserv.dsp.base.entity.vo.system.SysDictCategoryVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.Map;

/**
 * <p>
 * 系统字典表 服务类
 * </p>
 *
 * @author wuty
 * @since 2017-09-19
 */
public interface ISysDictCategoryService extends ICommonService<SysDictCategory, SysDictCategoryVo> {
    Page<SysDictCategoryVo> selectCategoryVoPage(Map<String, Object> paramMap) throws Exception ;
    SysDictCategoryVo selectVoById(String id) throws Exception;
    boolean updateCategoryVO(SysDictCategoryVo vo) throws Exception;
    int deleteByCategoryCode(Map<String , Object> map) throws Exception;


}
