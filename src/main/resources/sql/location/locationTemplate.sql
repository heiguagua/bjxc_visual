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

-- 共享门户几个特殊信息的处理
delete from dir_portal_content_setting where category in ('footer','aboutUs');
INSERT INTO dir_portal_content_setting (id, category, content, publisher, publish_date, delete_flag) VALUES ('6d238c7d312c4388bb48243b7f0d0c96', 'footer', '<p>&nbsp; &nbsp;主办：成都市人民政府 &nbsp; &nbsp; &nbsp;承办：成都市大数据和电子政务管理办公室 &nbsp; &nbsp; &nbsp;承建维护：成都市软件产业发展中心</p>', NULL, NULL, 0);
INSERT INTO dir_portal_content_setting (id, category, content, publisher, publish_date, delete_flag) VALUES ('a568d7e2dc694e99ba919fb5aab4f86f', 'aboutUs', '<p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;成都市政务数据资源服务网是成都市各部门政务信息资源共享网站，由成都市大数据和电子政务管理办公室主办，成都市软件产业发展中心承办并负责运维工作。 </p> <p> <br/> </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; 成都市政务信息资源服务网于2017年8月上线试运行，于2018年1月正式上线运行，是成都市各部门用户对政务信息资源梳理、发布、更新、申请以及获取的统一平台，更是是集目录、资源、工具、应用、目录可视化等一体的综合平台。 </p> <p> <br/> </p> <p> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;成都市政务信息资源服务网致力于提升市级政府部门信息资源共享的质量和效率，在加快政府职能转变步伐，提高行政效率，推进跨部门协调，为促进政府数据共享开放，建成国家中心城市发挥着日益重要的作用。 </p> <p> <br/> </p> <p> </p> <p> <strong>联系方式 </strong> </p> <p> <br/> </p> <p></p> <p> 电话：028-85336899 </p> <p> <br/> </p> <p></p> <p> 传真：028-85336899 </p> <p> <br/> </p> <p></p> <p> 邮箱：editor@chengdu.gov.cn </p> <p> <br/> </p>', NULL, NULL, 0);
