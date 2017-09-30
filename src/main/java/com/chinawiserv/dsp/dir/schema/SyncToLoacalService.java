package com.chinawiserv.dsp.dir.schema;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;


@Component
public class SyncToLoacalService {
	
    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysDeptService sysDeptService;

	private void insertOrUpdateDirUser(SysUser sysUser){
		    if(null == sysUser){
		    	return;
			}
		    EntityWrapper ewId = new EntityWrapper();
		    EntityWrapper ewEntity = new EntityWrapper();
		    ewId.eq("id",sysUser.getId());
		    SysUser sysUserIfById = sysUserService.selectOne(ewId);
		    ewEntity.setEntity(sysUser);
		    SysUser sysUserIfByEntity = sysUserService.selectOne(ewEntity);
			if(sysUserIfById == null){
				sysUserService.insert(sysUser);
			}else if(sysUserIfById != null && sysUserIfByEntity == null){
				sysUserService.updateById(sysUser);
			}else if(sysUserIfByEntity != null){
				return;
			}
			
		
		}
	 private void insertOrUpdateDirOrganize(SysDept sysDept){
         if(null == sysDept){
         	return;
		 }
		 EntityWrapper ewId = new EntityWrapper();
		 EntityWrapper ewEntity = new EntityWrapper();
		 ewId.eq("id",sysDept.getId());
		 SysDept sysDeptIfById = sysDeptService.selectOne(ewId);
		 ewEntity.setEntity(sysDept);
		 SysDept sysDeptIfByEntity = sysDeptService.selectOne(ewEntity);
		 if(sysDeptIfById == null){
			 sysDeptService.insert(sysDept);
		 }else if(sysDeptIfById != null && sysDeptIfByEntity == null){
			 sysDeptService.updateById(sysDept);
		 }else if(sysDeptIfByEntity != null){
			 return;
		 }
		}
	
	public void insertOrUpdateSysDept(List<SysDept> depts){
		if(depts != null && !depts.isEmpty()){
			for (Iterator<SysDept> iterator = depts.iterator(); iterator.hasNext();) {
				SysDept sysDept = (SysDept) iterator.next();
				insertOrUpdateDirOrganize(sysDept);
			}
			
			}
		}
	
	
	public void insertOrUpdateSysUser(List<SysUser> users){
		if(users != null && !users.isEmpty()){
			for (Iterator<SysUser> iterator = users.iterator(); iterator.hasNext();) {
				SysUser sysUser = (SysUser) iterator.next();
				insertOrUpdateDirUser(sysUser);
			}
			
			}
		}
	}

