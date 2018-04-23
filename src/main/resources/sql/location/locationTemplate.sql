-- 目录系统地区初始化SQL

-- 设置系统集成基本数据信息
delete from sys_product_integrate where product_no not in ('dm','rc','sw','sharedportal');

-- 修改初始化配置表信息
update sys_setting set setting_value = '510100' where setting_code = 'localRegion' and setting_type = '1';
update sys_setting set setting_value = '成都市大数据资源服务网' where setting_code = 'systemShowName' and setting_type = '1';
update sys_setting set setting_value = '成都市大数据资源服务网' where setting_code = 'projectPortalName' and setting_type = '1';
update sys_setting set setting_value = 'Chengdu Big Data Resource Service Network' where setting_code = 'projectPortalEnName' and setting_type = '1';

-- 删除不需要的菜单
delete from sys_menu where id in ('0117','08','0801');

--  用户表
delete from sys_user;
insert into sys_user (id,region_code,dept_id,user_type,user_name,real_name,password,status,user_img) values
	('09f4fef9249c457ca67b4a7a45823730','510100','','1','admin','超级管理员','96e79218965eb72c92a549dd5a330112','1','/images/userImg/avatar5.png');

insert into sys_user_role(id,user_id,role_id)
    select REPLACE(uuid(),'-',''),id,(select id from sys_role where role_name='超级管理员')
  from sys_user where user_name in ( 'admin');


-- 先初始化对应行政区域的顶级部门,不初始化，由部门修改权限系统统一管理
delete from sys_dept;
-- call initLocalRootSysDept('510100');
