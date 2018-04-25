delete from sys_menu where id='11';
delete from sys_menu where id='12';
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('11','0','总览','/chartMenuCustom/index','fa-cogs',1,1,'11','',1);
INSERT INTO sys_menu (id,pid,menu_name,url,icon,sort,menu_type,code,resource_name,status) VALUES ('12','0','图表配置','/chartMenuCustom/config','fa-cogs',2,1,'12','',1);

-- 角色菜单表
delete from sys_role_menu;
  INSERT INTO sys_role_menu SELECT uuid() AS id,(SELECT id FROM sys_role WHERE role_name='超级管理员') AS role_id,id AS menu_id FROM sys_menu;
  INSERT INTO sys_role_menu SELECT uuid() AS id,(SELECT id FROM sys_role WHERE role_name='区域管理员') AS role_id,id AS menu_id FROM sys_menu;
