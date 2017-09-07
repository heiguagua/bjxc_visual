package com.chinawiserv.dsp.base.service.system;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysRole;
import com.chinawiserv.dsp.base.entity.po.common.response.ListResult;
import com.chinawiserv.dsp.base.entity.vo.system.SysRoleVo;
import com.chinawiserv.dsp.base.service.common.ICommonService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface ISysRoleService extends ICommonService<SysRole, SysRoleVo> {

    Page<SysRoleVo> selectVoPage(Map<String, Object> paramMap) throws Exception;

    SysRoleVo selectVoById(String id) throws Exception;

    ListResult getAuth(String id) throws Exception;

    JSONObject checkRoleName(String roleName, String roleId) throws Exception;

    List<JSONObject> getRoleNameList(String userId) throws Exception;

    boolean deleteRoleById(String id) throws Exception;

    boolean deleteBatchRoleByIds(List<String> ids) throws Exception;

}
