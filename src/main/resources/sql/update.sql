delete from sys_menu where id='11';
delete from sys_menu where id='12';
delete from sys_menu where id='1201';
delete from sys_menu where id='0108';
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0108','01','可视化菜单管理','/system/menu/forVm','fa-list',4,2,'0105','system:menu',1);

INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('12','0','可视化分析','','fa-cogs',2,1,'10','',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('11','0','首页','/chartMenuTemplate/index','fa-cogs',1,2,'11','',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('1201','12','卫生资源','/chartMenuCustom/config','fa-cogs',1,2,'1201','',1);

delete from sys_user;
insert into sys_user (id,region_code,dept_id,user_type,user_name,real_name,password,status,user_img) values
	('09f4fef9249c457ca67b4a7a45823730','510100','','1','admin','超级管理员','96e79218965eb72c92a549dd5a330112','1','/images/userImg/avatar5.png');

insert into sys_user_role(id,user_id,role_id)
    select REPLACE(uuid(),'-',''),id,(select id from sys_role where role_name='超级管理员')
  from sys_user where user_name in ( 'admin');

INSERT INTO `sys_user` VALUES ('9fd46ef4303746d59e6bc4ab17e6e652', '510100', '', null, 'qyadmin', '区域管理员', '96e79218965eb72c92a549dd5a330112', '5A2DE748C9257C14', '', '', '', '/images/userImg/avatar5.png', '', '', '1', '09f4fef9249c457ca67b4a7a45823730', '2018-05-07 14:48:54', null, null, '0');
insert into sys_user_role(id,user_id,role_id)
    select REPLACE(uuid(),'-',''),id,(select id from sys_role where role_name='区域管理员')
  from sys_user where user_name in ( 'qyadmin');

-- 角色菜单表
delete from sys_role_menu;
  INSERT INTO sys_role_menu SELECT uuid() AS id,(SELECT id FROM sys_role WHERE role_name='超级管理员') AS role_id,id AS menu_id FROM sys_menu;
  INSERT INTO sys_role_menu SELECT uuid() AS id,(SELECT id FROM sys_role WHERE role_name='区域管理员') AS role_id,id AS menu_id FROM sys_menu;
