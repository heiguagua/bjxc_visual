-- 目录系统地区初始化SQL

-- 先初始化对应行政区域的顶级部门
delete from sys_dept;
call initLocalRootSysDept('510000');


--  用户表 密码默认为111111
delete from sys_user;
insert into sys_user (id,region_code,dept_id,user_type,user_name,real_name,password,status,user_img) values
	(REPLACE(uuid(),'-',''),'510000','','1','admin','超级管理员','96e79218965eb72c92a549dd5a330112','1','/images/userImg/avatar5.png');
insert into sys_user_role(id,user_id,role_id)
    values (REPLACE(uuid(),'-',''),(select id from sys_user where user_name = 'admin'),(select id from sys_role where role_name='超级管理员'));

-- 删除不需要的菜单
delete from sys_menu where id in ('0116','0117','08','0801');

-- 修改初始化配置表信息
update sys_setting set setting_value = '510000' where setting_code = 'localRegion' and setting_type = '1';
update sys_setting set setting_value = '四川省大数据资源服务网' where setting_code = 'systemShowName' and setting_type = '1';
update sys_setting set setting_value = '四川省大数据资源服务网' where setting_code = 'projectPortalName' and setting_type = '1';
update sys_setting set setting_value = 'Sichuan Big Data Resource Service Network' where setting_code = 'projectPortalEnName' and setting_type = '1';



-- 设置系统集成基本数据信息
delete from sys_product_integrate where product_no not in ('dm','rc','sw','sharedportal');
