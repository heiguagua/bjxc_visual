delete from sys_menu where id='11';
delete from sys_menu where id='12';
delete from sys_menu where id='1201';
delete from sys_menu where id='0108';
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('0108','01','可视化菜单管理','/system/menu','fa-list',4,2,'0105','system:menu',1);

INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('12','0','可视化分析','','fa-cogs',2,1,'10','',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('11','0','首页','/chartMenuCustom/index','fa-cogs',1,2,'11','',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('1201','12','卫生资源','/chartMenuCustom/config','fa-cogs',1,2,'1201','',1);

-- 角色菜单表
delete from sys_role_menu;
  INSERT INTO sys_role_menu SELECT uuid() AS id,(SELECT id FROM sys_role WHERE role_name='超级管理员') AS role_id,id AS menu_id FROM sys_menu;
  INSERT INTO sys_role_menu SELECT uuid() AS id,(SELECT id FROM sys_role WHERE role_name='区域管理员') AS role_id,id AS menu_id FROM sys_menu;
