package com.chinawiserv.dsp.dir.schema;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chinawiserv.dsp.base.entity.po.system.SysDept;
import com.chinawiserv.dsp.base.entity.po.system.SysUser;
import com.chinawiserv.dsp.base.service.system.ISysDeptService;
import com.chinawiserv.dsp.base.service.system.ISysUserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class SyncToLoacalService {

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ISysDeptService sysDeptService;


	public void insertOrUpdateSysDept(List<SysDept> depts) {

		if (CollectionUtils.isEmpty(depts)) return;

		List<SysDept> existDeptsByIds = this.sysDeptService.selectList(new EntityWrapper<SysDept>().in("id", depts.stream().map(e -> e.getId()).collect(Collectors.toList())));

		if (!CollectionUtils.isEmpty(existDeptsByIds)) {

			existDeptsByIds.stream().forEach(e -> {
				if (depts.contains(e)) depts.remove(e);
			});

			List<String> updateIds = existDeptsByIds.stream().map(e -> e.getId()).collect(Collectors.toList());

			List<SysDept> updateDepts = Lists.newArrayList();
			depts.stream().forEach(e -> {
				if (updateIds.contains(e.getId())) updateDepts.add(e);
			});

			if (!CollectionUtils.isEmpty(updateDepts)) {
				this.sysDeptService.updateBatchById(updateDepts);
				depts.removeAll(updateDepts);
			}

		}

		if (!CollectionUtils.isEmpty(depts)) this.sysDeptService.insertBatch(depts);

	}


	public void insertOrUpdateSysUser(List<SysUser> users) {

		if (CollectionUtils.isEmpty(users)) return;

		List<SysUser> existUersByIds = this.sysUserService.selectList(new EntityWrapper<SysUser>().in("id", users.stream().map(e -> e.getId()).collect(Collectors.toList())));

		if (!CollectionUtils.isEmpty(existUersByIds)) {

			existUersByIds.stream().forEach(e -> {
				if (users.contains(e)) users.remove(e);
			});

			List<String> updateIds = existUersByIds.stream().map(e -> e.getId()).collect(Collectors.toList());

			List<SysUser> updateUsers = Lists.newArrayList();
			users.stream().forEach(e -> {
				if (updateIds.contains(e.getId())) updateUsers.add(e);
			});

			if (!CollectionUtils.isEmpty(updateUsers)) {
				this.sysUserService.updateBatchById(updateUsers);
				users.removeAll(updateUsers);
			}

		}

		if (!CollectionUtils.isEmpty(users)) this.sysUserService.insertBatch(users);
	}
}

