/*
	1、需要将Mysql数据库修改为支持跨库查询（添加federated 引擎）。修改方法可参考 http://huqiji.iteye.com/blog/2068613，这里简单说下操作步骤。
		1.1 在mysql的配置文件 my.cnf 中添加一行：federated
		1.2 重启mysql服务，登录进mysql的shell后，用下面命令查询验证：
				mysql>show engines;
				如显示有：| FEDERATED  | YES      | Federated MySQL storage engine                                 |  则表示安装成功
	2、将新产品的数据库建立在和软中数据库同库的服务器上，这里我们假定软中的数据库名为rz_dir(如果现场的软中老数据库名不一致，则需要将下面所有的rz_dir替换为对应的数据库名)
	3、在产品新建的数据库中，先执行基础数据的SQL后，最后执行本文件，即可将软中老数据导入到产品数据库中
 */
-- -- 系统管理模块
-- 	-- 顶级组织机构表
-- 	delete from sys_dept;
-- 	delete from sys_guid_dept;
-- 	insert into sys_dept(id,region_code,dept_type,dept_code,dept_name,dept_short_name,dept_alias,dept_desc,dept_function,fid,fname)
-- 		select uuid,region_code,SUBSTR(organs_code,8) ,organs_code,organs_fullname,organs_shortname,'','','','root','root'
-- 		from  rz_dir.ADMINI_ORGANS;
--
-- 	-- 普通组织机构表
-- 	insert into sys_dept(id,region_code,dept_type,dept_code,dept_name,dept_short_name,dept_alias,dept_desc,dept_function,fid,fname,order_number)
-- 		select uuid,region_code,org_category_code,org_code,org_fullname,org_shortname,org_alias,'',org_function,
-- 		(select b.uuid from rz_dir.ADMINI_ORGANS b,rz_dir.ORGANS_ORGANIZE_MAP c where b.uuid=c.organs_id and t.uuid=c.organize_id) as old_fid,
-- 		(select b.organs_fullname from rz_dir.ADMINI_ORGANS b,rz_dir.ORGANS_ORGANIZE_MAP c where b.uuid=c.organs_id and t.uuid=c.organize_id) as old_fname,
-- 		order_number
-- 		from rz_dir.DIR_ORGANIZE t where t.org_fcode='root';
-- 	-- 普通组织机构子部门
-- 	insert into sys_dept(id,region_code,dept_type,dept_code,dept_name,dept_short_name,dept_alias,dept_desc,dept_function,fid,fname,order_number)
-- 		select uuid,region_code,org_category_code,org_code,org_fullname,org_shortname,org_alias,'',org_function,
-- 		(select a.uuid from rz_dir.DIR_ORGANIZE a where a.org_code = t.org_fcode) as old_fid,org_fname,order_number
-- 		from rz_dir.DIR_ORGANIZE t where t.org_fcode <> 'root';
--
-- 	 update sys_dept set fid='root' where fid is null;
-- 	-- 业务指导部门
-- 	insert into sys_guid_dept(id,cur_dept_id,guid_dept_id)
-- 		select uuid,organize_id,director_organize_id from rz_dir.account_director ;



-- 目录类型相关表
	-- 先修改目标数据表结构,添加old_code,old_fcode,
	--	 alter table dir_classify add column old_code varchar(64);
	--	 alter table dir_classify add column old_fcode varchar(64);
	-- 目录类型表
--
-- 	delete from dir_classify;
-- 	insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number, -- classify_structure_code,classify_structure_name,
-- 	status)
-- 		select uuid,'510100','',dir_name,description, -- fcode,
-- 			(select a.uuid from rz_dir.dir_lists a where a.dir_code = t.fcode) as old_fid,
-- 			fname,dir_level,0,0,dir_order,
-- 			-- (select a.dir_struct_codes from rz_dir.dir_lists_datasetmap a where a.dir_code = t.dir_code and a.dir_struct_codes is not null limit 0,1) as old_dir_struct_codes
-- 			-- (select a.dir_structure from rz_dir.dir_lists_datasetmap a where a.dir_code = t.dir_code and a.dir_structure is not null limit 0,1) as old_dir_structure
-- 			status
-- 		from rz_dir.dir_lists t ;
-- -- 重置顶级目录分类的值
-- -- 	update dir_classify set classify_code='1',fid='root',order_number='1' where classify_name = '政务基础信息资源目录';
-- -- 	update dir_classify set classify_code='2',fid='root',order_number='2' where classify_name = '政务主题信息资源目录';
--
-- -- INSERT INTO dir_classify (id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number,icon,classify_structure_code,classify_structure_name,status,tree_code)
-- -- 	VALUES ('3','510100','3','政务部门信息资源目录','','root','root',1,1,0,3,NULL,'','政务部门信息资源目录','Y','3');
-- -- INSERT INTO dir_classify (id, region_code, classify_code, classify_name, classify_desc, fid, fname, classify_level, classify_index, dcm_index, order_number, icon, classify_structure_code, classify_structure_name, status, tree_code)
-- -- 	VALUES ('301', '510100', '301', '省（自治区、直辖市）和计划单列市', '', '3', '政务部门信息资源目录', 1, 1, 0, NULL, NULL, '', '政务部门信息资源目录->省（自治区、直辖市）和计划单列市', 'Y', '3;301');
-- -- INSERT INTO dir_classify (id, region_code, classify_code, classify_name, classify_desc, fid, fname, classify_level, classify_index, dcm_index, order_number, icon, classify_structure_code, classify_structure_name, status, tree_code)
-- -- 	VALUES ('30101', '510100', '30101', '四川省成都市', '', '301', '省（自治区、直辖市）和计划单列市', 1, 1, 0, NULL, NULL, '3', '政务部门信息资源目录->省（自治区、直辖市）和计划单列市->四川省成都市', 'Y', '3;301;30101');
--
-- INSERT INTO dir_classify (id, region_code, classify_code, classify_name, classify_desc, fid, fname, classify_level, classify_index, dcm_index, order_number, icon, classify_structure_code, classify_structure_name, status, tree_code)
--   select id,region_code,dept_code,dept_name,'','30101','四川省成都市','4',0,0,order_number,icon,'','','Y',''
--  from sys_dept where fid in (select id from sys_dept where fid = 'root');
--
-- insert into dir_classify_dept_map (id,classify_id,dept_id)
-- 	select REPLACE(uuid(),'-',''),id,id from sys_dept where fid in (select id from sys_dept where fid = 'root');
--

-- -- 最新导入目录分类的sql 20171021
-- -- 政务基础信息资源目录
-- -- 1级 基础库
-- -- insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number,status,classify_type)
-- -- 	select uuid,'510100','',dir_name,description,
-- -- 			(select id from dir_classify dc where dc.region_code='510100' and dc.classify_name='政务基础信息资源目录') as old_fid,fname,
-- -- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '2-1' ) + 1 as classify_level,
-- -- 			0,0,dir_order,status,'5'
-- -- 		from rz_dir.dir_lists t where t.fname='政务基础信息资源目录' order by t.dir_level,t.dir_order;
-- -- 2级 基础库
-- insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number,status,classify_type)
-- 	select uuid,'510100','',dir_name,description,
-- 			(select a.uuid from rz_dir.dir_lists a where a.dir_code = t.fcode) as old_fid,fname,
-- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '2-1' ) + 2 as classify_level,
-- 			0,0,dir_order,status,'5'
-- 		from rz_dir.dir_lists t where t.fcode in
-- 			(select dir_code from rz_dir.dir_lists where fname ='政务基础信息资源目录') order by t.dir_level,t.dir_order;
-- -- 3级 基础库
-- insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number,status,classify_type)
-- 	select uuid,'510100','',dir_name,description,
-- 			(select a.uuid from rz_dir.dir_lists a where a.dir_code = t.fcode) as old_fid,fname,
-- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '2-1' ) + 3 as classify_level,
-- 			0,0,dir_order,status,'5'
-- 		from rz_dir.dir_lists t where t.fcode in
-- 			(select dir_code from rz_dir.dir_lists where fcode in
-- 				(select dir_code from rz_dir.dir_lists where fname ='政务基础信息资源目录')) order by t.dir_level,t.dir_order;
-- -- 4级 基础库
-- insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number,status,classify_type)
-- 	select uuid,'510100','',dir_name,description,
-- 			(select a.uuid from rz_dir.dir_lists a where a.dir_code = t.fcode) as old_fid,fname,
-- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '2-1' ) + 4 as classify_level,
-- 			0,0,dir_order,status,'5'
-- 		from rz_dir.dir_lists t where t.fcode in
-- 			(select dir_code from rz_dir.dir_lists where fcode in
-- 				(select dir_code from rz_dir.dir_lists where fcode in
-- 					(select dir_code from rz_dir.dir_lists where fname ='政务基础信息资源目录'))) order by t.dir_level,t.dir_order;
-- -- 5级 基础库（无）
--
-- -- 	政务主题信息资源目录
-- -- 1级 主题库
-- -- insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number,status,classify_type)
-- -- 	select uuid,'510100','',dir_name,description,
-- -- 			(select id from dir_classify dc where dc.region_code='510100' and dc.classify_name='政务主题信息资源目录') as old_fid,fname,
-- -- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '2-2' ) + 1 as classify_level,
-- -- 			0,0,dir_order,status,'6'
-- -- 		from rz_dir.dir_lists t where t.fname='政务主题信息资源目录' order by t.dir_level,t.dir_order;
-- -- 2级 主题库
-- insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number,status,classify_type)
-- 	select uuid,'510100','',dir_name,description,
-- 			(select a.uuid from rz_dir.dir_lists a where a.dir_code = t.fcode) as old_fid,fname,
-- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '2-2' ) + 2 as classify_level,
-- 			0,0,dir_order,status,'6'
-- 		from rz_dir.dir_lists t where t.fcode in
-- 			(select dir_code from rz_dir.dir_lists where fname ='政务主题信息资源目录') order by t.dir_level,t.dir_order;
-- -- 3级 主题库
-- insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number,status,classify_type)
-- 	select uuid,'510100','',dir_name,description,
-- 			(select a.uuid from rz_dir.dir_lists a where a.dir_code = t.fcode) as old_fid,fname,
-- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '2-2' ) + 3 as classify_level,
-- 			0,0,dir_order,status,'6'
-- 		from rz_dir.dir_lists t where t.fcode in
-- 			(select dir_code from rz_dir.dir_lists where fcode in
-- 				(select dir_code from rz_dir.dir_lists where fname ='政务主题信息资源目录')) order by t.dir_level,t.dir_order;
-- -- 4级 主题库
-- insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number,status,classify_type)
-- 	select uuid,'510100','',dir_name,description,
-- 			(select a.uuid from rz_dir.dir_lists a where a.dir_code = t.fcode) as old_fid,fname,
-- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '2-2' ) + 4 as classify_level,
-- 			0,0,dir_order,status,'6'
-- 		from rz_dir.dir_lists t where t.fcode in
-- 			(select dir_code from rz_dir.dir_lists where fcode in
-- 				(select dir_code from rz_dir.dir_lists where fcode in
-- 					(select dir_code from rz_dir.dir_lists where fname ='政务主题信息资源目录'))) order by t.dir_level,t.dir_order;
--
-- -- 5级 主题库
-- insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number,status,classify_type)
-- 	select uuid,'510100','',dir_name,description,
-- 			(select a.uuid from rz_dir.dir_lists a where a.dir_code = t.fcode) as old_fid,fname,
-- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '2-2' ) + 5 as classify_level,
-- 			0,0,dir_order,status,'6'
-- 		from rz_dir.dir_lists t where t.fcode in
-- 			(select dir_code from rz_dir.dir_lists where fcode in
-- 				(select dir_code from rz_dir.dir_lists where fcode in
-- 					(select dir_code from rz_dir.dir_lists where fcode in
-- 						(select dir_code from rz_dir.dir_lists where fname ='政务主题信息资源目录')))) order by t.dir_level,t.dir_order;
-- -- 6级 主题库（无）
--
-- -- 政务部门信息资源目录
-- -- 1级 部门库
-- -- INSERT INTO dir_classify (id, region_code, classify_code, classify_name, classify_desc, fid, fname, classify_level, classify_index, dcm_index, order_number, icon, classify_structure_code, classify_structure_name, status, classify_type)
-- -- 	select id,region_code,'',dept_name,'',
-- -- 			(select id from dir_classify where region_code='510100' and classify_type = '3' ) as fid,
-- -- 			(select classify_name from dir_classify where region_code='510100' and classify_type = '3' ) as fname,
-- -- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '3' ) + 1 as classify_level,
-- -- 			0,0,order_number,icon,'','','Y','7'
-- -- 		from sys_dept where fid in
-- -- 			(select id from sys_dept where fid = 'root') order by dept_code;
-- -- 2级 部门库
-- INSERT INTO dir_classify (id, region_code, classify_code, classify_name, classify_desc, fid, fname, classify_level, classify_index, dcm_index, order_number, icon, classify_structure_code, classify_structure_name, status, classify_type)
-- 	select id,region_code,'',dept_name,'',fid,fname,
-- 			(select classify_level from dir_classify where region_code='510100' and classify_type = '2-3' ) + 2 as classify_level,
-- 			0,0,order_number,icon,'','','Y','7'
-- 		from sys_dept where fid in
-- 			(select id from sys_dept where fid in
-- 				(select id from sys_dept where fid = 'root')) order by dept_code;
-- -- 3级 部门库（无）
-- -- 查询验证
-- select id,fid,region_code,classify_code,classify_index,classify_name,classify_type,classify_level,order_number,icon,classify_structure_name,tree_code,national_code,status
-- from dir_classify where region_code = '510100' and classify_type in ('5','6','7')
--  order by classify_type,classify_level,fid,order_number;
-- 以上为基础数据，以下为业务数据，需要转的
-- 现场的用户数据
delete from sys_user;
delete from sys_user_role;
insert into sys_user (id,region_code,dept_id,user_type,user_name,real_name,password,status)
		select uuid,region_code,(select o.uuid from rz_dir.dir_organize o where o.org_code=t.organize_code), '1',login_name,user_name,`password`,status
		from rz_dir.DIR_USER t;
update sys_user set region_code = '510100' where region_code is null or region_code = '';
insert into sys_user_role(id,user_id,role_id)
    select REPLACE(uuid(),'-',''),id,(select id from sys_role where role_name='超级管理员')
    from sys_user where user_name in ('admin','sysadmin');


	-- 目录系统的信息资源（数据集）
	delete from dir_dataset;
	insert into dir_dataset(id,region_code,dataset_code,dataset_name,alias,belong_dept_type,belong_dept_id,belong_dept_no,dataset_desc,
			share_type,share_condition,share_method,is_open,open_condition,update_frequency,rel_dataset_code,storage_medium,storage_location,
			source_type,status,create_user_id,create_time,update_time)
		select uuid,(select a.region_code from rz_dir.dir_organize a where a.org_code = t.org_code) as old_region_code,
				set_code,set_name,alias,(select region_dept_code from v_sys_region_dept where region_code='510100' and category = '1') as belong_dept_type,
				(select a.uuid from rz_dir.dir_organize a where a.org_code = t.org_code) as old_belong_dep_id,'' as belong_dept_no,
				description,share_type,share_condi_explain,share_way,whether_open,open_condition,update_cycle,'' as rel_dataset_code,
				storage_medium,storage_location,type,status,create_user,create_time ,last_operation_time
		from rz_dir.dir_dataset t;
			-- 对应从资源梳理添加
		update dir_dataset set source_type = '3' where source_type = 'Q';
		update dir_dataset set status = '0' where status = 'Y';

	-- dir_dataset_ext_format 信息资源格式表

	-- 目录系统的数据项表
	delete from dir_dataitem;
	insert into dir_dataitem(id,dataset_id,item_code,item_name,item_length,item_desc,item_type,belong_dept_id,
			share_type,share_method,share_condition,is_open,open_condition,update_frequency,storage_medium,storage_location,
			status,create_user_id,create_time,update_user_id,update_time,delete_flag)
		select uuid,(select a.uuid from rz_dir.dir_dataset a where a.set_code = t.set_code ) as old_set_id,item_code,item_name,null as item_length,description,'' as item_type,
			t.org_code as old_belong_dep_id,
			share_type,share_way,share_condi_explain,whether_open,open_condition,update_cycle,storage_medium,storage_location,
			'0' as status,create_user,create_time,'' as update_user_id,null as update_time,0
			from rz_dir.dir_dataitem t;

	 -- 目录系统的目录与数据集的关系表
	delete from dir_dataset_classify_map;
	insert into dir_dataset_classify_map(id,dataset_id,classify_id,info_resource_code,status,update_user_id,update_time)
		select uuid,(select a.uuid from rz_dir.dir_dataset a where a.set_code=t.set_code) as dataset_id,
			(select a.uuid from rz_dir.dir_lists a where a.dir_code=t.dir_code) as classify_id,
			'' as info_resource_code,'5' as status,create_user,create_time
	from rz_dir.dir_lists_datasetmap t;
	update dir_dataset_classify_map t set rel_flag = '1' where t.classify_id in (select id from dir_classify where classify_type = '7' and region_code = '510100');


-- 数据集来源信息(new)
delete from dir_dataitem_source_info;


	-- 目录注册、审核、发布、下架表
	delete from dir_data_registe;
	delete from dir_data_audit;
	delete from dir_data_publish;
	delete from dir_data_offline;

	insert into dir_data_registe(id,dcm_id,register_id,registe_date,registe_opinion)
		select REPLACE(uuid(),'-',''),uuid,(select id from sys_user where user_name = 'admin'),regist_time,'' from rz_dir.dir_lists_datasetmap;
	insert into dir_data_audit (id,dcm_id,auditor_id,audit_date,audit_status,audit_opinion)
		select REPLACE(uuid(),'-',''),uuid,(select id from sys_user where user_name = 'admin'),null,'3' as audit_status,audit_opinion from rz_dir.dir_lists_datasetmap;
	insert into dir_data_publish (id,dcm_id,publisher_id,publish_date,publish_type)		-- ???
		select REPLACE(uuid(),'-',''),uuid,(select id from sys_user where user_name = 'admin'),null,release_status from rz_dir.dir_lists_datasetmap;	-- ???
	-- 下架表怎么取 ？？？？


-- 数据访问记录(new)
delete from dir_data_visit;
insert into dir_data_visit (id,obj_type,obj_id,visitor_id,visit_ip,visit_date)
		select id,type,resource_id,visitor_id,null,visit_time
		from rz_dir.PORTAL_RESOURCE_VISIT_LOG;

-- 数据集权限申请记录(new)
delete from dir_data_item_apply;
delete from dir_data_apply;
  --  status值需要再确认 ？
insert into dir_data_apply(id,dcm_id,applicant_id,apply_info,apply_date,limit_visit_cnt,
				limit_visit_date_period,auditor_id,
				status,audit_visit_cnt,audit_visit_date_period,audit_opinion,audit_date)
		select  uuid(),m.uuid,t.applicant_id,null as apply_info,t.apply_datetime,0,null as limit_period,t.audit_user_id,'1' as status,
			0,null as audit_period,null,t.last_update_datetime as audit_time
		from rz_dir.DIR_DATAITEM_APPLYINFO t left join rz_dir.dir_lists_datasetmap m on t.set_code=m.set_code
		group by m.uuid,t.applicant_id,t.apply_datetime		order by m.uuid ;

 -- status ? 需要再确认
insert into dir_data_item_apply (id,data_apply_id,item_id,status)
		select uuid(),(select a.id from dir_data_apply a
							where a.applicant_id = t.applicant_id and a.dcm_id = m.uuid  ) as data_apply_id,
				(select uuid from rz_dir.dir_dataitem a where a.item_code = t.item_code) as item_id,status
		from rz_dir.DIR_DATAITEM_APPLYINFO t left join rz_dir.dir_lists_datasetmap m on t.set_code=m.set_code  ;


	-- 数据纠错、收藏、浏览、评分、评论表
	delete from dir_data_correction;
	delete from dir_data_collection;
	delete from dir_data_visit;
	delete from dir_data_rate;

	insert into dir_data_correction(id,dcm_id,corrector_id,correct_content,correct_date,auditor_id,audit_date,audit_status,audit_opinion)
		select id,(select a.uuid from rz_dir.dir_lists_datasetmap a where a.dir_code = t.dir_code and a.set_code = t.correction_code) as old_dcm_id,
			user_id,correction_content,correction_time,'' as auditor_id,null,null,null
		from rz_dir.DATA_CORRECTION t;
	insert into dir_data_collection(id,dcm_id,collector_id,collect_date)
		select id,(select a.uuid from rz_dir.dir_lists_datasetmap a where a.dir_code = t.dir_code and a.set_code = t.collection_code) as old_dcm_id,
			user_id,collection_time
		from rz_dir.DATA_COLLECTION t;

	insert into dir_data_rate(id,dcm_id,rater_id,rate_score,rate_date)
		select id,(select a.uuid from rz_dir.dir_lists_datasetmap a where a.dir_code = t.dir_code and a.set_code = t.SET_CODE) as old_dcm_id,
			USER_ID,RATING_POINT,CREATE_TIME
		from rz_dir.USER_RATING_DATASET t;




-- 其他门户相关信息表
	delete from dir_news;
	delete from dir_policy;
	delete from dir_special_apps;
	delete from dir_develop_apis;
	delete from dir_suggestion;
	delete from dir_regist_user;


	-- 新闻表
	insert into dir_news(id,region_code,title,news_pic,pic_name,pic_type,pic_order,pic_size,news_content,publisher,publish_date,status,create_user_id,create_time,update_user_id,update_time,delete_flag)
		select  id,'510100',TITLE,PIC_PATH,pic_name,pic_type,pic_order,pic_size,CONTENT,UPLOAD_USER,UPLOAD_TIME,PIC_STATUS,UPLOAD_USER,UPLOAD_TIME,UPDATE_USER,UPDATE_TIME,0
		from rz_dir.DIR_PIC_MANAGE t;
	-- 政策表  ? 缺少字段 visit_count
	insert into dir_policy(id,region_code,policy_level,title,content,publisher,publish_date,visit_count,status,create_user_id,create_time,update_user_id,update_time,delete_flag)
		select  uuid,'510100',policy_type,policy_title,policy_content,create_user,create_date,visit_count,'1' as status,create_user,create_date,update_user,update_date,0
		from rz_dir.dir_policy t;

	-- 专题应用表
	insert into dir_special_apps(id,region_code,app_category,app_name,app_url,order_number,status,create_user_id,create_time,update_user_id,update_time,delete_flag)
		select  uuid,'510100',category_code,app_name,app_url,order_by,'1' as status,'' as create_user_id,create_time,'' as update_user_id,update_time,0
		from rz_dir.Category_app t;

	-- 开发者工具表
	insert into dir_develop_apis(id,region_code,api_name,api_category,api_url,api_desc,parent_id,parent_name,order_number,status,create_user_id,create_time,update_user_id,update_time,delete_flag)
		select  id,'510100',name,type,url_adress,description,fcode,fname,privilege,'1' as status,'' as create_user_id,create_date,null,null,0
		from rz_dir.Dir_apis t;

	-- 咨询建议表
	insert into dir_suggestion(id,region_code,title,content,contact_name,contact_email,contact_phone,submit_date,response_content,response_date,responser)
		select  id,'510100',title,content,'' as contact_name,email,phone_no,last_update_time,reply,null,null
		from rz_dir.PORTAL_CONSULTATION_AND_SUGGESTION t;

	-- 用户注册表
	insert into dir_regist_user(id,region_code,login_name,real_name,email,phone,belong_dept,status,create_time)
		select  id,'510100',login_name,real_name,email,phone_number,(select a.uuid from rz_dir.dir_organize a where a.org_code = t.org_code) as old_dept_id,
			status,create_time
		from rz_dir.user_register t;




-- 梳理的表整理
 -- 状态枚举 ： 1未提交，2已经提交，3审核通过，4审核不通过
	-- 业务活动表
	delete from drap_business_activity;
	insert into drap_business_activity(id,region_code,belong_dept,category,activity_code,handle_basis,activity_desc,activity_name,extend_code,short_name,
				parent_code,parent_guid_activity,function_keywords,is_run,service_target,legal_deploy_dept,actual_deploy_dept,is_cooperate_business,
				handle_condition,handle_result,validity_from,validity_end,is_in_gc,handle_method,is_open,charge_standard,handle_address,legal_time_limit,
				promise_time_limit,handler,handler_phone,supervise_phone,handle_online,online_address,handle_online_desc,handle_program,handle_flowsheet,
				year_business_volume,order_by,is_show,code_index,status,create_user_id,create_time,update_user_id,update_time,delete_flag,tree_index,tree_code)
		select
			id,'510100',belong_dep,category,activity_code,handle_basis,activity_desc,activity_name,'' as extend_code,short_name,
			null as parent_code,'' as parent_guid_activity,'' as function_keywords,is_run,service_target,LEGAL_DEPLOY_DEP,actual_deploy_dep,is_cooperate_business,
			handle_condition,handle_result,validity_from,validity_end,is_in_gc,handle_method,is_open,charge_standard,handle_address,legal_time_limit,
			promise_time_limit,handler,handler_phone,supervise_phone,handle_online,online_address,handle_online_desc,handle_program,handle_flowsheet,
			year_business_volume,order_by,is_show,code_index,	3 as status,create_user,create_time,update_user,update_time,0 as delete_flag,0 as tree_index,'' as tree_code
		from rz_dir.BUSINESS_ACTIVITY  t;


	-- 业务活动关联部门表
	delete from drap_activity_rel_depts;
	insert into drap_activity_rel_depts(id,activity_id,dept_id)
		select
			id,activity_id,dep_id
		from rz_dir.ACTIVITY_REL_DEPS  t;

	-- 信息资源关联业务表
	delete from drap_activity_set_map;
	insert into drap_activity_set_map(id,dataset_id,activity_id)
		select
			id,set_id,activity_id
		from rz_dir.ACTIVITY_SET_MAP t;

	-- 业务活动关联信息系统表
	delete from drap_activity_system_map;
	insert into drap_activity_system_map(id,system_id,activity_id)
		select
			id,system_id,activity_id
		from rz_dir.ACTIVITY_SYSTEM_MAP  t;
--
-- -- 资料相关表 ??? 资料的名称怎么来的，怎么会有那么长？
--  delete from drap_business_doc;
--  insert into drap_business_doc (id,region_code,belong_dept,source_type,doc_code,doc_name,doc_desc,category,doc_sample,
-- 				sync_flag,template_flag,code_index,status,create_user,create_time,update_user,update_time,delete_flag)
--  		select
-- 				id,'510100',null as belong_dept,null as source_type,doc_code,doc_name,doc_desc,category,null as doc_sample,
-- 				null as sync_flag, template_flag,0 as code_index,3 as status,create_user,create_time,update_user,update_time,0 as delete_flag
-- -- 		select *
-- 		from rz_dir.BUSINESS_DOC  t ;
-- -- 		 order by length(doc_name) desc
-- -- 	业务活动关联资料表
--  	delete from drap_activity_doc_map;
--  	insert into drap_activity_doc_map(id,activity_id,doc_id,doc_io_type)
-- 		select
-- 				id,activity_id,doc_id,doc_io_type
-- 		from rz_dir.ACTIVITY_DOC_MAP t;


	-- 数据集
	delete from drap_dataset;
	insert into drap_dataset(id,region_code,belong_dept_id,belong_activity_id,dataset_code,dataset_name,category,sensitive_remark,update_frequency,dataset_desc,
			share_type,share_condition_desc,share_method,share_method_desc,share_range,no_share_reason,is_open,open_condition,rel_dataset_code,data_level,
			data_index_system,is_secret,store_media,physics_store_location,extend_code,code_index,status,create_user,create_time,update_user,update_time)
		select
			id,'510100',belong_dep,activity_id,dataset_code,dataset_name,category,sensitive_remark,update_frequency,dataset_desc,
			share_type,share_condition_desc,share_method,share_method_desc,share_range,no_share_reason,is_open,open_condition,'' as rel_dataset_code,'' as data_level,
			'' as data_index_system,'' as is_secret,store_media,physics_store_location,extend_code,code_index,3 as status,create_user,create_time,update_user,update_time
		from rz_dir.DATASET t;


	-- 	业务数据项【国】
	delete from drap_dataset_item;
	insert into drap_dataset_item(id,item_code,item_name,item_type,item_desc,belong_dept,sensitive_remark,update_frequency,
			share_type,share_range,share_method,share_condition_desc,share_method_desc,no_share_reason,is_open,open_condition,
			store_media,physics_store_location,code_index,create_user,create_time,update_user,update_time)
		select
			m.id,t.item_code,t.item_name,'' as item_type,t.item_desc,t.belong_dep,t.sensitive_remark,m.update_frequency,
			m.share_type,m.share_range,m.share_method,m.share_condition_desc,m.share_method_desc,m.no_share_reason,m.is_open,m.open_condition,
			m.store_media,m.physics_store_location,0,t.create_user,t.create_time,t.update_user,t.update_time
		from rz_dir.BUSINESS_DATA_ITEM t
		right join  rz_dir.DATASET_ITEM_MAP m on t.ID=m.ITEM_ID;
	-- 	数据集数据项关联表
	delete from drap_dataset_item_map;
	insert into drap_dataset_item_map(id,dataset_id,item_id)
		select
			REPLACE(uuid(),'-',''),dataset_id,id
		from rz_dir.DATASET_ITEM_MAP t;


	-- 	信息资源关联信息系统
	delete from drap_dataset_system_map;
	insert into drap_dataset_system_map(id,system_id,dataset_id)
		select
			id,system_id,dataset_id
		from rz_dir.DATASET_SYSTEM_MAP  t;
	-- 	信息资源梳理表关系记录表
	delete from drap_dataset_table_relation;
	insert into drap_dataset_table_relation(id,dataset_id,source_table,source_column,target_table,target_column,relation_type)
		select
			id,data_set_id,source_table,source_column,target_table,target_column,relation_type
		from rz_dir.INFO_TABLE_RELATION  t;

	-- 	信息系统表  ?BUILD_TYPE  Deployment_LOCATION
	delete from drap_info_system;
	insert into drap_info_system(id,region_code,source_type,system_code,system_name,system_phase,system_phase_desc,main_feature,main_data,enable_time,
			disable_time,system_level,belong_network,phisical_location,create_dept,self_build_flag,build_dept,system_structure,login_type,
			system_usage_info,system_usage_desc,support_company,support_contacts,support_contacts_phone,support_contacts_email,support_other_contacts,
			maintain_dept,maintain_contacts,maintain_contacts_phone,maintain_contacts_email,maintain_other_contacts,customer_service_info,
			data_range_begin,data_range_end,calculate_date,data_storage,year_increment,visit_url,visit_username,visit_password,has_interface,
			is_online_external,is_service_called,is_service_standard,is_export,has_old_system,old_system_name,old_system_desc,system_desc,code_index, status,
			create_user,create_time,update_user,update_time)
		select
			id,'510100','' as source_type,system_code,system_name,system_phase,system_phase_desc,main_feature,main_data,enable_time,
			disable_time,system_level,belong_network,phisical_location,'' as create_dept,self_build_flag,build_dep,system_structure,login_type,
			system_usage_info,system_usage_desc,support_company,support_contacts,support_contacts_phone,support_contacts_email,support_other_contacts,
			maintain_dep,maintain_contacts,maintain_contacts_phone,maintain_contacts_email,maintain_other_contacts,customer_service_info,
			data_range_begin,data_range_end,null,data_storage,year_increment,'' as visit_url,'' as visit_username,'' as visit_password,'' as has_interface,
			is_online_external,is_service_called,is_service_standard,is_export,has_old_system,old_system_name,old_system_desc,system_desc,code_index,3  as status,
			create_user,create_time,update_user,update_time
		from rz_dir.INFO_SYSTEM  t;


	-- 	信息系统使用单位
	delete from drap_system_use_dept;
	insert into drap_system_use_dept(id,system_id,dept_id)
		select
			id,system_id,dep_id
		from rz_dir.SYSTEM_USE_DEP  t;
	-- 	信息系统使用信息
-- 	delete from drap_system_use_info;
-- 	insert into drap_system_use_info(id,info_system_id,visit_url,username,password,belong_dept,start_use_date,use_frequence,key_business,code_index)
-- 		select
-- 			id,info_system_id,visit_url,username,password,belong_dep,start_use_date,use_frequence,key_business,code_index
-- 		from rz_dir.SYSTEM_USE_INFO t;

	-- 	数据库业务系统关系表
	delete from drap_db_system_map;
	insert into drap_db_system_map(id,db_id,info_system_id)
		select
			id,db_id,info_system_id
		from rz_dir.DB_SYSTEM_MAP t;
	-- 	数据库信息
	delete from drap_db_info;
	insert into drap_db_info(id,region_code,belong_dept,db_code,db_cn_name,category,db_type,db_name,version,ip_address,port,sid,service_name,
			param1,param2,param3,param4,param5,cur_storage,month_increment,year_increment,is_backup,backup_desc,network,room_addr,user_name,password,order_by,
			is_show,delete_flag,code_index,cur_connect_status,cur_update_status,cur_monitor_time,status,create_user,create_time,update_user,update_time)
		select
			id,'510100',belong_dep,db_code,db_cn_name,category,db_type,db_name,version,ip_address,port,sid,service_name,
			param1,param2,param3,param4,param5,cur_storage,month_increment,year_increment,is_backup,backup_desc,network,room_addr,user_name,password,order_by,
			is_show,0,code_index,cur_connect_status,cur_update_status,cur_monitor_time,3 as status,create_user,create_time,update_user,update_time
		from rz_dir.db_info  t;
	-- 	数据表信息
	delete from drap_db_table_info;
	insert into drap_db_table_info(id,db_id,table_source_type,table_type,table_code,table_name,table_cn_name,table_desc,code_index,status)
		select
			id,db_id,table_source,table_type,table_code,table_name,table_cn_name,table_desc,code_index,3 as status
		from rz_dir.TABLE_INFO t;
	-- 	数据表字段信息
	delete from drap_db_table_column;
	insert into drap_db_table_column(id,table_id,column_code,column_cn_name,default_value,column_length,column_en_name,is_business_data,
			is_pk,is_null,column_type,sensitive_remark,update_frequency,column_desc,data_precision,code_index)
		select
			id,table_id,column_code,column_cn_name,default_value,column_length,column_en_name,is_business_data,
			is_pk,is_null,column_type,sensitive_remark,update_frequency,column_desc,data_precision,code_index
		from rz_dir.TABLE_COLUMN t;
	-- 	字典导入数据表信息
	delete from drap_dict_table_info;
	insert into drap_dict_table_info(id,db_id,table_type,table_code,table_name,table_cn_name,table_desc,code_index,status,table_source_type,real_table_id)
		select
			id,db_id,table_type,table_code,table_name,table_cn_name,table_desc,code_index,3 as status,table_source,''
		from rz_dir.Dictionary_table_info t;
	-- 	字典导入数据表字段信息
	delete from drap_dict_table_column;
	insert into drap_dict_table_column(id,table_id,column_code,column_cn_name,default_value,column_length,column_en_name,is_business_data,is_pk,is_null,
			column_type,sensitive_remark,update_frequency,column_desc,data_precision,code_index)
		select
			id,table_id,column_code,column_cn_name,default_value,column_length,column_en_name,is_business_data,is_pk,is_null,
			column_type,sensitive_remark,update_frequency,column_desc,data_precision,code_index
		from rz_dir.Dictionary_table_column  t;

-- 梳理的数据集与数据表的关系
delete from drap_data_column_map;
insert into drap_data_column_map (id,dataset_id,business_item_id,system_column_id,info_system_id,db_id,table_id)
		select
			id,BUSINESS_DATASET_ID,business_item_id,system_column_id,info_system_id,db_info_id,table_info_id
		from rz_dir.DATA_COLUMN_MAP t;


	-- 	业务资源需求表
	delete from drap_business_requirement;
	insert into drap_business_requirement(id,region_code,requre_dept_id,source_dept_id,status,create_user,create_time,update_user,update_time)
		select
			id,'510100',requre_dep_id,source_dep_id,3 as status,create_user,create_time,update_user,update_time
		from rz_dir.BUSINESS_REQUIREMENT  t;

	-- 	需求资源信息表
	delete from drap_requirement_resources;
	insert into drap_requirement_resources(id,require_id,require_combing_type,doc_id,require_code,require_name,requirement_desc,brace_activity_id,is_get,
	expect_get_type,source_type,require_type,require_remark,other_info,expect_update_frequence,brace_app,status)
		select
			m.id,m.requirement_id,t.require_combing_type,null,t.require_code,m.set_name,t.requirement_desc,t.activity_id,t.is_get,
			t.expect_get_type,t.require_name_source,t.require_type,t.require_source_remark,t.others,t.expect_update_frequence,'' as brace_app,3 as status
		from rz_dir.business_requirement t
		right join  rz_dir.requirement_dataset_map m on t.id=m.requirement_id;

