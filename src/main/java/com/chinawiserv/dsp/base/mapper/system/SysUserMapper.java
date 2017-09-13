package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 系统用户表 Mapper 接口
 * </p>
 *
 * @author zhanf
 * @since 2017-05-08
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

//	List<Map<Object, Object>> selectUserList(Page<Map<Object, Object>> page, @Param("search") String search);
//	List<SysUserVo> selectVoList(Page<SysUserVo> page, @Param("ew") Wrapper<SysUserVo> wrapper);
    List<SysUserVo>	selectVoList(Page<SysUserVo> page, Map<String, Object> paramMap);
    SysUserVo selectVoById(String id);
    SysUserVo selectVoByUserName(String userName);
}
