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
        depts.stream().forEach(e -> {
            SysDept idExist = this.sysDeptService.selectById(e.getId());
            if(idExist == null) {
                this.sysDeptService.insert(e);
            }else{
                SysDept entityExist = this.sysDeptService.selectSXDept(e);
                if(entityExist == null) this.sysDeptService.updateSXDept(e);
            }
        });

    }


    public void insertOrUpdateSysUser(List<SysUser> users) {

        if (CollectionUtils.isEmpty(users)) return;
        users.stream().forEach(e -> {
            SysUser idExist = this.sysUserService.selectById(e.getId());
            if(idExist == null){
                this.sysUserService.insert(e);
            }else{
                SysUser entityExist = this.sysUserService.selectSXUser(e);
                if(entityExist == null) this.sysUserService.updateSXUser(e);
            }
        });

    }
}

