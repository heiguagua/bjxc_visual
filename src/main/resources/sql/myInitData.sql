-- 绵阳的特定初始化数据



-- 用户表
delete from sys_user;
insert into sys_user (id,region_code,dept_id,user_type,user_name,real_name,password,status,user_img,token) values
	('09f4fef9249c457ca67b4a7a45823730','510700','','1','myadmin','超级管理员','96e79218965eb72c92a549dd5a330112','1','/img/userImg/avatar5.png','123123556');
-- 国家级用户
insert into sys_user_role(id,user_id,role_id)
    values (REPLACE(uuid(),'-',''),(select id from sys_user where user_name = 'myadmin'),(select id from sys_role where role_name='超级管理员'));


insert into sys_dept (id,region_code,dept_type,dept_code,dept_name,dept_short_name,fid,fname,dept_structure_name,
		dept_level,dept_function,order_number,delete_flag,tree_index,tree_code)
select UUID(),'510700',category_code,CONCAT('510700_',category_code) as dept_code,
			REPLACE(fullname_template,'XX',(select region_name from sys_region where region_code = '510700')) as dept_name,
			REPLACE(shortname_template,'XX',(select region_name from sys_region where region_code = '510700')) as dept_short_name,
			'root','root',REPLACE(fullname_template,'XX',(select region_name from sys_region where region_code = '510700')) as dept_structure_name,
			'1' as dept_level,'' as dept_function,ASCII(category_code) - 64 as order_number,0,0,ASCII(category_code) - 64 as tree_code
from sys_dept_category_template;


update sys_setting set setting_value = '510700' where setting_code = 'localRegion' and setting_type = '1';