package com.chinawiserv.dsp.base.mapper.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.chinawiserv.dsp.base.entity.po.system.SysMenu;
import com.chinawiserv.dsp.base.entity.vo.system.SysMenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 菜单表 Mapper 接口
 * </p>
 *
 * @author zhanf
 * @since 2017-04-16
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenuVo> select(Page<SysMenuVo> page, Map<String, Object> paramMap) throws Exception;

	List<String> selectMenuIdsByuserId(String uid) throws Exception;

    List<SysMenu> selectTreeMenuForLoginUser(@Param("loginUserId") String loginUserId) throws Exception;

    SysMenuVo selectMenuById(String id) throws Exception;

    SysMenuVo selectCatalogByMenuId(String id) throws Exception;

    SysMenuVo selectCatalogByFunctionId(String id) throws Exception;

    List<SysMenuVo> selectMenusByFunctionId(String id) throws Exception;
	//TODO 爬虫
	Boolean deleteSysRoleMenu(String id) throws Exception;
	//TODO 爬虫
    List<SysMenuVo> selectChildren(String id) throws Exception;
}