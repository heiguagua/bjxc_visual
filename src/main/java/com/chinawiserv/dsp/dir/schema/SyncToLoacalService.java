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
			SysUser sysUserIfExist = null;
		    EntityWrapper ew = new EntityWrapper();
		    ew.eq("id",sysUser.getId());
		    ew.eq("user_name",sysUser.getUserName());
		    sysUserIfExist = sysUserService.selectOne(ew);
			if(sysUserIfExist == null){
				sysUserService.insert(sysUser);
			}else{
                int localRoleId = sysUserIfExist.getUserType();
                sysUser.setUserType(localRoleId);
				sysUserService.update(sysUser,null);
				
			}
			
		
		}
	 private void insertOrUpdateDirOrganize(SysDept sysDept){
         if(null == sysDept){
         	return;
		 }
		 SysDept sysDeptIfExist = null;
		 EntityWrapper ew = new EntityWrapper();
		 ew.eq("id",sysDept.getId());
		 ew.eq("dept_code",sysDept.getDeptCode());
		 sysDeptIfExist = sysDeptService.selectOne(ew);
			if(sysDeptIfExist == null){
				sysDeptService.insert(sysDept);
			}else{
				sysDeptService.update(sysDept,null);
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

