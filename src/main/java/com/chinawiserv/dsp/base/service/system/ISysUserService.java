package com.chinawiserv.dsp.base.service.system;


import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysUserService extends ICommonService<SysUser,SysUserVo> {
    /**
     * 根据id查找vo用户
     */
    SysUserVo selectVoById(String id) throws Exception;
    /**
     * 登录
     */
    SysUser login(String userName, String password);

    /**
     * 删除用户
     */
    void delete(String id);
}
