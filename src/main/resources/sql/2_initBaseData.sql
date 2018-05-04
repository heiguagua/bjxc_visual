
-- 菜单表
-- select id,menu_name,pid,url,icon,sort,menu_type,code,resource_name,status from sys_menu order by pid ;
delete from sys_menu;
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('01','0','系统管理','','fa-cogs',5,1,'01','',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0104','01','字典管理','/sysDict','fa-cogs',9,2,'0104','system:dict',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('010401','0104','字典列表','','',2,3,'010401','',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('010402','0104','字典修改','','',2,3,'010402','',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0105','01','菜单管理','/system/menu','fa-list',4,2,'0105','system:menu',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('010501','0105','删除菜单','','',4,3,'010501','system:menu:delete',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('010502','0105','创建菜单','','',1,3,'010502','system:menu:add',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('010503','0105','查看菜单列表','','',0,3,'010503','system:menu:list',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('010504','0105','编辑菜单','','',3,3,'010504','system:menu:edit',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0106','01','系统配置','/system/setting',' fa-cog',10,2,'0106','system:setting',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('010601','0106','查询系统设置','','',0,3,'010601','system:setting:list',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('010602','0106','操作系统设置','','',1,3,'010602','system:setting:edit',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0107','01','业务日志','/system/log','fa-info-circle',11,2,'0107','system:log',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('010701','0107','查看日志列表','','',0,3,'010701','system:log:list',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0116','01','系统集成管理','/system/productIntegrate','fa fa-cogs',15,2,'0116','system:productIntegrate',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0117','01','License管理','/lic/licPage','',2,2,'0117','lic:licPage',1);
insert into sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) values ( '0118','01','行政区域管理','/system/region','fa fa-cogs',16,2,'0118','system:region', 1);

INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('09','0','用户管理','','fa-cogs',5,1,'09','',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0901','09','用户管理','/system/user','fa-user-circle-o',2,2,'0901','system:user',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090101','0901','编辑用户','','',2,3,'090101','system:user:edit',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090102','0901','删除用户','','',3,3,'090102','system:user:delete',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090103','0901','新增用户','','',1,3,'090103','system:user:add',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090104','0901','查看用户列表','','',0,3,'090104','system:user:list',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090106','0901','批量删除用户','','',5,3,'090106','system:user:deleteBatch',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0902','09','角色管理','/system/role','fa-users',3,2,'0902','system:role',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090201','0902','查看角色列表','','',0,3,'090201','system:role:list',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090202','0902','新增角色','','',1,3,'090202','system:role:add',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090203','0902','编辑角色','','',2,3,'090203','system:role:edit',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090204','0902','角色授权','','',4,3,'090204','system:role:auth',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090205','0902','删除角色','','',3,3,'090205','system:role:delete',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('090206','0902','批量删除角色','','',5,3,'090206','system:role:deleteBatch',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0910','09','用户数据权限管理','/system/userAuthority','fa-cogs',6,2,'0910','system:userAuthority',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('091001','0910','编辑用户数据权限','','',2,3,'091001','system:userAuthority:edit',1);

INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('10','0','部门管理','','fa-cogs',5,1,'10','',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('1003','10','组织机构管理','/system/dept','fa-graduation-cap',1,2,'1003','system:dept',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('100301','1003','编辑组织机构','','',2,3,'100301','system:dept:edit',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('100302','1003','编辑用户注册','','',2,3,'100302','system:registUser:allot',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('100303','1003','新增组织机构','','',1,3,'100303','system:dept:add',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('100304','1003','查看组织机构列表','','',0,3,'100304','system:dept:list',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('100305','1003','删除组织机构','','',3,3,'100305','system:dept:delete',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('100306','1003','批量删除组织机构','','',5,3,'100306','system:dept:deleteBatch',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('1009','10','部门数据权限管理','/system/deptAuthority','fa fa-cogs',5,2,'1009','system:deptAuthority',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('100901','1009','编辑组织机构数据权限','','',2,3,'100901','system:deptAuthority:edit',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('1011','10','部门数据权限申请','/system/deptAuthorityApply','fa-cogs',7,2,'1011','system:deptAuthorityApply',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('101101','1011','组织机构数据权限申请列表','','',2,3,'101101','system:deptAuthorityApply:list',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('101102','1011','申请组织机构数据权限','','',2,3,'101102','system:deptAuthorityApply:add',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('1012','10','部门数据权限审核','/system/deptAuthorityAudit','fa-cogs',8,2,'1012','system:deptAuthorityAudit',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('101201','1012','组织机构数据权限审核列表','','',2,3,'101201','system:deptAuthorityAudit:list',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('101202','1012','审核组织机构数据权限','','',2,3,'101202','system:deptAuthorityAudit:edit',1);


-- 暂时删除不需要的功能性菜单
delete FROM  sys_menu where menu_type='3';

-- 角色表
delete from sys_role;
  INSERT INTO sys_role(id,role_name,role_desc,role_level,status) VALUES ('737933bffef640329a4f864c4e2746ba', '超级管理员', '超级管理员', -1,1);
  INSERT INTO sys_role(id,role_name,role_desc,role_level,status) VALUES ('dab7f9219c4611e78cf200ffe04ac734', '区域管理员', '区域管理员', 0,1);


-- 角色菜单表
delete from sys_role_menu;
  INSERT INTO sys_role_menu SELECT uuid() AS id,(SELECT id FROM sys_role WHERE role_name='超级管理员') AS role_id,id AS menu_id FROM sys_menu;
  INSERT INTO sys_role_menu SELECT uuid() AS id,(SELECT id FROM sys_role WHERE role_name='区域管理员') AS role_id,id AS menu_id FROM sys_menu;

-- 系统配置类别表
  delete from sys_setting_category;
  insert into sys_setting_category (category_code,category_name) values	('1','系统基本配置');
	insert into sys_setting_category (category_code,category_name) values('2','接口配置');



