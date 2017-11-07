package com.chinawiserv.dsp.base.service.system.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.common.exception.ErrorInfoException;
import com.chinawiserv.dsp.base.common.util.CommonUtil;
import com.chinawiserv.dsp.base.common.util.ShiroUtils;
import com.chinawiserv.dsp.base.entity.po.system.SysRole;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.entity.po.system.SysUserRole;
import com.chinawiserv.dsp.base.entity.vo.system.SysUserVo;
import com.chinawiserv.dsp.base.mapper.system.SysUserMapper;
import com.chinawiserv.dsp.base.mapper.system.SysUserRoleMapper;
import com.chinawiserv.dsp.base.service.common.impl.CommonServiceImpl;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类1
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
@Service
public class SysUserServiceImpl extends CommonServiceImpl<SysUserMapper,SysUser,SysUserVo> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private ISysDeptService sysDeptService;

    @Override
    public SysUser login(String userName, String password) {
        return this.selectOne(new EntityWrapper<SysUser>().eq("user_name", userName).eq("password", CommonUtil.string2MD5(password)));
    }

    @Override
    public SysUserVo selectVoById(String id) throws Exception {
        return userMapper.selectVoById(id);
    }

    @Override
    public SysUserVo selectVoByUserName(String userName) {
        return userMapper.selectVoByUserName(userName);
    }

    @Override
    public void delete(String id) throws ErrorInfoException {
        if (userMapper.checkCanBeDeletedById(id)) {
            SysUser sysUser = new SysUser();
            sysUser.setId(id);
            sysUser.setDeleteFlag(1);
            this.updateById(sysUser);
        }else{
            throw new ErrorInfoException("admin为系统内置的管理员用户，不能删除");
        }
    }

    @Override
    public int selectUsersCountByRoleId(String roleId) {
        if(StringUtils.isBlank(roleId)){
            return 0;
        }
        return userMapper.selectUsersCountByRoleId(roleId);
    }

    @Override
    public int selectUsersCountByDeptId(String deptId) {
        if(StringUtils.isBlank(deptId)){
            return 0;
        }
        return userMapper.selectUsersCountByDeptId(deptId);
    }

    @Override
    public boolean insertVO(SysUserVo sysUserVo) throws Exception {
        sysUserVo.setId(CommonUtil.get32UUID());
        sysUserVo.setCreateTime(new Date());
        sysUserVo.setPassword(CommonUtil.string2MD5(sysUserVo.getPassword()));
        //获取当前用户登陆id
        String loginUserId = ShiroUtils.getLoginUserId();
        sysUserVo.setCreateUserId(loginUserId);
        //默认用户头像
        sysUserVo.setUserImg("/images/userImg/avatar5.png");
        //保存用户
        userMapper.insert(sysUserVo);
        //绑定角色
        String[] roleIds = sysUserVo.getRoleIds();
        if(ArrayUtils.isNotEmpty(roleIds)){
            this.insertUserRoles(sysUserVo.getId(), roleIds);
        }
        return true;
    }

    @Override
    public boolean updateVO(SysUserVo sysUserVo) throws Exception {
        //更新用户
        sysUserVo.setUpdateTime(new Date());
        userMapper.updateById(sysUserVo);
        String userId = sysUserVo.getId();
        String[] roleIds = sysUserVo.getRoleIds();
        //重新绑定角色
        if(ArrayUtils.isNotEmpty(roleIds)){
            //删除已有权限
            userRoleMapper.delete(new EntityWrapper<SysUserRole>().eq("user_id", userId));

            this.insertUserRoles(userId, roleIds);
        }
        return true;
    }

    @Override
    public boolean deleteByQuery(Map<String, Object> paramMap) throws Exception {
        return false;
    }

    @Override
    public Page<SysUserVo> selectVoPage(Map<String, Object> paramMap) throws Exception {
        Map<String, Object> param = sysDeptService.getDeptCondition(null);
        if(param != null && !param.isEmpty()){
            List<SysRole> roles = ShiroUtils.getLoginUser().getSysRoleList();
            int roleLevel = -1;
            if(roles != null){
                roleLevel = roles.stream().min((o1, o2) -> o1.getRoleLevel().compareTo(o2.getRoleLevel())).get().getRoleLevel();
            }
            paramMap.put("roleLevel", roleLevel);
            paramMap.putAll(param);
            Page<SysUserVo> page = getPage(paramMap);
            //按照创建时间排序
            page.setOrderByField("create_time");
            page.setAsc(false);
            page.setTotal(userMapper.selectVoCount(paramMap));
            page.setRecords(userMapper.selectVoList(page,paramMap));
            return page;
        }
        return getPage(paramMap);
    }

    @Override
    public int selectVoCount(Map<String, Object> paramMap) throws Exception {
        return 0;
    }

    private void insertUserRoles(String userId, String[] roleIds) throws Exception {
        for(String rid : roleIds){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(rid);
            if(userRoleMapper.insert(sysUserRole) <= 0){
                throw new Exception("添加用户角色失败！");
            }
        }
    }

    @Override
    public int selectUserRoleType(String user_id) {
        return userMapper.selectUserRoleType(user_id);
    }

    @Override
    public boolean createToken(Map<String,String> paramMap) {
        return userMapper.createToken(paramMap)>0;
    }

    @Override
    public List<SysUser> listBySystemId(String systemId) {
        return userMapper.listBySystemId(systemId);
    }

    @Override
    public boolean insertOrUpdate(List<SysUser> list) {
        for (SysUser sysUser : list) {
            SysUser u= userMapper.selectById(sysUser.getId());
            if(null ==u){
                userMapper.insert(sysUser);
            }else{
                userMapper.updateById(sysUser);
            }
        }
        return true;
    }
}
