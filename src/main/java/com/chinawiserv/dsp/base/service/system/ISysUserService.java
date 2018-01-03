package com.chinawiserv.dsp.base.service.system;


import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务类1
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysUserService extends ICommonService<SysUser,SysUserVo> {

    String synUrl="/system/user/provideData";

    /**
     * 根据id查找vo用户
     */
    SysUserVo selectVoById(String id) throws Exception;

    /**
     * 根据username找vo用户
     */
    SysUserVo selectVoByUserName(String userName);

    /**
     * 登录
     */
    SysUser login(String userName, String password);

    /**
     * 删除用户
     */
    void delete(String id) throws ErrorInfoException;

    /**
     * 查询指定角色的用户数
     */
    int selectUsersCountByRoleId(String roleId);

    /**
     * 查询指定部门用户数
     */
    int selectUsersCountByDeptId(String deptId);

    /**
     * 获取用户角色类型
     * @param user_id
     * @return
     */
    int selectUserRoleType(String user_id);

    /**
     * 生成TOKEN
     * */
    boolean createToken(Map<String,String> paramMap);

    List<SysUser>  listBySystemId(String systemId);

    boolean insertOrUpdate(List<SysUser> list);

    boolean updateSXUser(SysUser sysUser);

    SysUser selectSXUser(SysUser sysUser);
}
