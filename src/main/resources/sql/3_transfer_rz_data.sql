
-- 目录类型相关表
	-- 先修改目标数据表结构,添加old_code,old_fcode,
	--	 alter table dir_classify add column old_code varchar(64);
	--	 alter table dir_classify add column old_fcode varchar(64);
	-- 目录类型表
	delete from dir_classify;
	insert into dir_classify(id,region_code,classify_code,classify_name,classify_desc,fid,fname,classify_level,classify_index,dcm_index,order_number, -- classify_structure_code,classify_structure_name,
	status)
		select uuid,'510100',dir_code,dir_name,description, -- fcode,
			(select a.uuid from rz_dir.dir_lists a where a.dir_code = t.fcode) as old_fid,
			fname,dir_level,0,0,dir_order,
			-- (select a.dir_struct_codes from rz_dir.dir_lists_datasetmap a where a.dir_code = t.dir_code and a.dir_struct_codes is not null limit 0,1) as old_dir_struct_codes
			-- (select a.dir_structure from rz_dir.dir_lists_datasetmap a where a.dir_code = t.dir_code and a.dir_structure is not null limit 0,1) as old_dir_structure
			status
		from rz_dir.dir_lists t ;
	 update dir_classify set fid='root' where fid is null;

	-- 目录系统的信息资源（数据集）
	delete from dir_dataset;
	insert into dir_dataset(id,region_code,dataset_code,dataset_name,alias,belong_dept_id,dataset_desc,
			share_type,share_condition,share_method,is_open,open_condition,update_frequency,rel_dataset_code,storage_medium,storage_location,
			source_type,status,create_user_id,create_time,update_time)
		select uuid,(select a.region_code from rz_dir.dir_organize a where a.org_code = t.org_code) as old_region_code,
				set_code,set_name,alias,(select a.uuid from rz_dir.dir_organize a where a.org_code = t.org_code) as old_belong_dep_id,
				description,share_type,share_condi_explain,share_way,whether_open,open_condition,update_cycle,'',
				storage_medium,storage_location,type,status,create_user,create_time ,last_operation_time
		from rz_dir.dir_dataset t;
	-- dir_dataset_ext_format 信息资源格式表

	-- 目录系统的数据项表
	delete from dir_dataitem;
	insert into dir_dataitem(id,dataset_id,item_code,item_name,item_desc,item_type,belong_dept_id,
			share_type,share_method,share_condition,is_open,open_condition,update_frequency,storage_medium,storage_location,
			status,create_user_id,create_time,update_user_id,update_time,delete_flag)
		select uuid,(select a.uuid from rz_dir.dir_dataset a where a.set_code = t.set_code ) as old_set_id,item_code,item_name,description,'item_type?',
			t.org_code as old_belong_dep_id,
			share_type,share_way,share_condi_explain,whether_open,open_condition,update_cycle,storage_medium,storage_location,
			'status?',create_user,create_time,'',null,0
			from rz_dir.dir_dataitem t;

	 -- 目录系统的目录与数据集的关系表
	delete from dir_dataset_classify_map;
	insert into dir_dataset_classify_map(id,dataset_id,classify_id,info_resource_code,status,update_user_id,update_time)
		select uuid,(select a.uuid from rz_dir.dir_dataset a where a.set_code=t.set_code) as dataset_id,
			(select a.uuid from rz_dir.dir_lists a where a.dir_code=t.dir_code) as classify_id,
			dir_set_code,'?status',create_user,create_time
		from rz_dir.dir_lists_datasetmap t;

	-- 目录注册、审核、发布、下架表
	delete from dir_data_registe;
	delete from dir_data_audit;
	delete from dir_data_publish;
	delete from dir_data_offline;

	insert into dir_data_registe(id,dcm_id,register_id,registe_date,registe_opinion)
		select REPLACE(uuid(),'-',''),uuid,'',regist_time,'' from rz_dir.dir_lists_datasetmap;
	insert into dir_data_audit (id,dcm_id,auditor_id,audit_date,audit_status,audit_opinion)
		select REPLACE(uuid(),'-',''),uuid,'',null,audit_status,audit_opinion from rz_dir.dir_lists_datasetmap;
	insert into dir_data_publish (id,dcm_id,publisher_id,publish_date,publish_type)		-- ???
		select REPLACE(uuid(),'-',''),uuid,'',null,release_status from rz_dir.dir_lists_datasetmap;	-- ???
	-- 下架表怎么取 ？？？？


	-- 数据纠错、收藏、浏览、评分、评论表
	delete from dir_data_correction;
	delete from dir_data_collection;
	delete from dir_data_visit;
	delete from dir_data_rate;

	insert into dir_data_correction(id,dcm_id,corrector_id,correct_content,correct_date,auditor_id,audit_date,audit_status,audit_opinion)
		select id,(select a.uuid from rz_dir.dir_lists_datasetmap a where a.dir_code = t.dir_code and a.set_code = t.correction_code) as old_dcm_id,
			user_id,correction_content,correction_time,'',null,null,null
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
		select  uuid,'510100',policy_type,policy_title,policy_content,create_user,create_date,visit_count,'1',create_user,create_date,update_user,update_date,0
		from rz_dir.dir_policy t;

	-- 专题应用表
	insert into dir_special_apps(id,region_code,app_category,app_name,app_url,order_number,status,create_user_id,create_time,update_user_id,update_time,delete_flag)
		select  uuid,'510100',category_code,app_name,app_url,order_by,'1','',create_time,'',update_time,0
		from rz_dir.Category_app t;

	-- 开发者工具表
	insert into dir_develop_apis(id,region_code,api_name,api_category,api_url,api_desc,parent_id,parent_name,order_number,status,create_user_id,create_time,update_user_id,update_time,delete_flag)
		select  id,'510100',name,type,url_adress,description,fcode,fname,privilege,'1','',create_date,null,null,0
		from rz_dir.Dir_apis t;

	-- 咨询建议表
	insert into dir_suggestion(id,region_code,title,content,contact_name,contact_email,contact_phone,submit_date,response_content,response_date,responser)
		select  id,'510100',title,content,'',email,phone_no,last_update_time,reply,null,null
		from rz_dir.PORTAL_CONSULTATION_AND_SUGGESTION t;

	-- 用户注册表
	insert into dir_regist_user(id,region_code,login_name,real_name,email,phone,belong_dept,status,create_time)
		select  id,'510100',login_name,real_name,email,phone_number,(select a.uuid from rz_dir.dir_organize a where a.org_code = t.org_code) as old_dept_id,
			status,create_time
		from rz_dir.user_register t;



-- 系统管理模块
	-- 顶级组织机构表
	delete from sys_dept;
	delete from sys_guid_dept;
	insert into sys_dept(id,region_code,dept_type,dept_code,dept_name,dept_short_name,dept_alias,dept_desc,dept_function,fid,fname)
		select uuid,region_code,SUBSTR(organs_code,8) ,organs_code,organs_fullname,organs_shortname,'','','','root','root'
		from  rz_dir.ADMINI_ORGANS;

	-- 普通组织机构表
	insert into sys_dept(id,region_code,dept_type,dept_code,dept_name,dept_short_name,dept_alias,dept_desc,dept_function,fid,fname,order_number)
		select uuid,region_code,org_category_code,org_code,org_fullname,org_shortname,org_alias,'',org_function,
		(select b.uuid from rz_dir.ADMINI_ORGANS b,rz_dir.ORGANS_ORGANIZE_MAP c where b.uuid=c.organs_id and t.uuid=c.organize_id) as old_fid,
		(select b.organs_fullname from rz_dir.ADMINI_ORGANS b,rz_dir.ORGANS_ORGANIZE_MAP c where b.uuid=c.organs_id and t.uuid=c.organize_id) as old_fname,
		order_number
		from rz_dir.DIR_ORGANIZE t where t.org_fcode='root';
	-- 普通组织机构子部门
	insert into sys_dept(id,region_code,dept_type,dept_code,dept_name,dept_short_name,dept_alias,dept_desc,dept_function,fid,fname,order_number)
		select uuid,region_code,org_category_code,org_code,org_fullname,org_shortname,org_alias,'',org_function,
		(select a.uuid from rz_dir.DIR_ORGANIZE a where a.org_code = t.org_fcode) as old_fid,org_fname,order_number
		from rz_dir.DIR_ORGANIZE t where t.org_fcode <> 'root';

	 update sys_dept set fid='root' where fid is null;
	-- 业务指导部门
	insert into sys_guid_dept(id,cur_dept_id,guid_dept_id)
		select uuid,organize_id,director_organize_id from rz_dir.account_director ;




-- 梳理的表整理
delete from drap_business_activity;
delete from drap_activity_rel_depts;
delete from drap_activity_set_map;
delete from drap_activity_system_map;
delete from drap_dataset;
delete from drap_dataset_item;
delete from drap_dataset_item_map;
delete from drap_dataset_system_map;
delete from drap_dataset_table_relation;
delete from drap_info_system;
delete from drap_system_use_dept;
delete from drap_system_use_info;
delete from drap_db_system_map;
delete from drap_db_info;
-- delete from drap_db_table_info;
-- delete from drap_db_table_column;
delete from drap_dict_table_info;
delete from drap_dict_table_column;
delete from drap_business_requirement;
delete from drap_requirement_resources;

	-- 业务活动表
	insert into drap_business_activity(id,region_code,belong_dept,category,activity_code,handle_basis,activity_desc,activity_name,extend_code,short_name,parent_code,parent_guid_activity,function_keywords,is_run,service_target,legal_deploy_dept,actual_deploy_dept,is_cooperate_business,handle_condition,handle_result,validity_from,validity_end,is_in_gc,handle_method,is_open,charge_standard,handle_address,legal_time_limit,promise_time_limit,handler,handler_phone,supervise_phone,handle_online,online_address,handle_online_desc,handle_program,handle_flowsheet,year_business_volume,order_by,is_show,code_index,status,create_user_id,create_time,update_user_id,update_time,delete_flag,tree_index,tree_code)
		select
			id,'510100',belong_dep,category,activity_code,handle_basis,activity_desc,activity_name,'',short_name,parent_code,'','',is_run,service_target,LEGAL_DEPLOY_DEP,actual_deploy_dep,is_cooperate_business,handle_condition,handle_result,validity_from,validity_end,is_in_gc,handle_method,is_open,charge_standard,handle_address,legal_time_limit,promise_time_limit,handler,handler_phone,supervise_phone,handle_online,online_address,handle_online_desc,handle_program,handle_flowsheet,year_business_volume,order_by,is_show,code_index,1,create_user,create_time,update_user,update_time,0,0,''
		from rz_dir.BUSINESS_ACTIVITY  t;


	-- 业务活动关联部门表
	insert into drap_activity_rel_depts(id,activity_id,dept_id)
		select
			id,activity_id,dep_id
		from rz_dir.ACTIVITY_REL_DEPS  t;

	-- 信息资源关联业务表
	insert into drap_activity_set_map(id,dataset_id,activity_id)
		select
			id,set_id,activity_id
		from rz_dir.ACTIVITY_SET_MAP t;

	-- 业务活动关联信息系统表
	insert into drap_activity_system_map(id,system_id,activity_id)
		select
			id,system_id,activity_id
		from rz_dir.ACTIVITY_SYSTEM_MAP  t;

	-- 数据集

	insert into drap_dataset(id,region_code,belong_dept_id,belong_activity_id,dataset_code,dataset_name,category,sensitive_remark,update_frequency,dataset_desc,share_type,share_condition_desc,share_method,share_method_desc,share_range,no_share_reason,is_open,open_condition,rel_dataset_code,data_level,data_index_system,is_secret,store_media,physics_store_location,extend_code,code_index,create_user,create_time,update_user,update_time)
		select
			id,'510100',belong_dep,activity_id,dataset_code,dataset_name,category,sensitive_remark,update_frequency,dataset_desc,share_type,share_condition_desc,share_method,share_method_desc,share_range,no_share_reason,is_open,open_condition,'','','','',store_media,physics_store_location,extend_code,code_index,create_user,create_time,update_user,update_time
		from rz_dir.DATASET t;


	-- 	业务数据项【国】
	insert into drap_dataset_item(id,item_code,item_name,item_type,item_desc,belong_dept,sensitive_remark,update_frequency,share_type,share_range,share_method,share_condition_desc,share_method_desc,no_share_reason,is_open,open_condition,store_media,physics_store_location,code_index,create_user,create_time,update_user,update_time)
		select
			m.id,t.item_code,t.item_name,'',t.item_desc,t.belong_dep,t.sensitive_remark,m.update_frequency,m.share_type,m.share_range,m.share_method,m.share_condition_desc,m.share_method_desc,m.no_share_reason,m.is_open,m.open_condition,m.store_media,m.physics_store_location,0,t.create_user,t.create_time,t.update_user,t.update_time
		from rz_dir.BUSINESS_DATA_ITEM t
		right join  rz_dir.DATASET_ITEM_MAP m on t.ID=m.ITEM_ID;
	-- 	数据集数据项关联表
	insert into drap_dataset_item_map(id,dataset_id,item_id)
		select
			REPLACE(uuid(),'-',''),dataset_id,id
		from rz_dir.DATASET_ITEM_MAP t;


	-- 	信息资源关联信息系统
	insert into drap_dataset_system_map(id,system_id,dataset_id)
		select
			id,system_id,dataset_id
		from rz_dir.DATASET_SYSTEM_MAP  t;
	-- 	信息资源梳理表关系记录表
	insert into drap_dataset_table_relation(id,dataset_id,source_table,source_column,target_table,target_column,relation_type)
		select
			id,data_set_id,source_table,source_column,target_table,target_column,relation_type
		from rz_dir.INFO_TABLE_RELATION  t;

	-- 	信息系统表  ?BUILD_TYPE  Deployment_LOCATION
	insert into drap_info_system(id,region_code,source_type,system_code,system_name,system_phase,system_phase_desc,main_feature,main_data,enable_time,disable_time,system_level,belong_network,phisical_location,create_dept,self_build_flag,build_dept,system_structure,login_type,system_usage_info,system_usage_desc,support_company,support_contacts,support_contacts_phone,support_contacts_email,support_other_contacts,maintain_dept,maintain_contacts,maintain_contacts_phone,maintain_contacts_email,maintain_other_contacts,customer_service_info,data_range_begin,data_range_end,calculate_date,data_storage,year_increment,visit_url,visit_username,visit_password,has_interface,is_online_external,is_service_called,is_service_standard,is_export,has_old_system,old_system_name,old_system_desc,system_desc,code_index,create_user,create_time,update_user,update_time)
		select
			id,'510100','',system_code,system_name,system_phase,system_phase_desc,main_feature,main_data,enable_time,disable_time,system_level,belong_network,phisical_location,'',self_build_flag,build_dep,system_structure,login_type,system_usage_info,system_usage_desc,support_company,support_contacts,support_contacts_phone,support_contacts_email,support_other_contacts,maintain_dep,maintain_contacts,maintain_contacts_phone,maintain_contacts_email,maintain_other_contacts,customer_service_info,data_range_begin,data_range_end,null,data_storage,year_increment,'','','','',is_online_external,is_service_called,is_service_standard,is_export,has_old_system,old_system_name,old_system_desc,system_desc,code_index,create_user,create_time,update_user,update_time
		from rz_dir.INFO_SYSTEM  t;


	-- 	信息系统使用单位
	insert into drap_system_use_dept(id,system_id,dept_id)
		select
			id,system_id,dep_id
		from rz_dir.SYSTEM_USE_DEP  t;
	-- 	信息系统使用信息
	insert into drap_system_use_info(id,info_system_id,visit_url,username,password,belong_dept,start_use_date,use_frequence,key_business,code_index)
		select
			id,info_system_id,visit_url,username,password,belong_dep,start_use_date,use_frequence,key_business,code_index
		from rz_dir.SYSTEM_USE_INFO t;

	-- 	数据库业务系统关系表
	insert into drap_db_system_map(id,db_id,info_system_id)
		select
			id,db_id,info_system_id
		from rz_dir.DB_SYSTEM_MAP t;
	-- 	数据库信息
	insert into drap_db_info(id,region_code,belong_dept,db_code,db_cn_name,category,db_type,db_name,version,ip_address,port,sid,service_name,param1,param2,param3,param4,param5,cur_storage,month_increment,year_increment,is_backup,backup_desc,network,room_addr,user_name,password,order_by,is_show,delete_flag,code_index,cur_connect_status,cur_update_status,cur_monitor_time,create_user,create_time,update_user,update_time)
		select
			id,'510100',belong_dep,db_code,db_cn_name,category,db_type,db_name,version,ip_address,port,sid,service_name,param1,param2,param3,param4,param5,cur_storage,month_increment,year_increment,is_backup,backup_desc,network,room_addr,user_name,password,order_by,is_show,0,code_index,cur_connect_status,cur_update_status,cur_monitor_time,create_user,create_time,update_user,update_time
		from rz_dir.db_info  t;
	-- 	数据表信息
	insert into drap_db_table_info(id,db_id,table_source_type,table_type,table_code,table_name,table_cn_name,table_desc,code_index)
		select
			id,db_id,table_source,table_type,table_code,table_name,table_cn_name,table_desc,code_index
		from rz_dir.TABLE_INFO t;
	-- 	数据表字段信息
	insert into drap_db_table_column(id,table_id,column_code,column_cn_name,default_value,column_length,column_en_name,is_business_data,is_pk,is_null,column_type,sensitive_remark,update_frequency,column_desc,data_precision,code_index)
		select
			id,table_id,column_code,column_cn_name,default_value,column_length,column_en_name,is_business_data,is_pk,is_null,column_type,sensitive_remark,update_frequency,column_desc,data_precision,code_index
		from rz_dir.TABLE_COLUMN t;
	-- 	字典导入数据表信息
	insert into drap_dict_table_info(id,db_id,table_type,table_code,table_name,table_cn_name,table_desc,code_index,table_source_type,real_table_id)
		select
			id,db_id,table_type,table_code,table_name,table_cn_name,table_desc,code_index,table_source,''
		from rz_dir.Dictionary_table_info t;
	-- 	字典导入数据表字段信息
	insert into drap_dict_table_column(id,table_id,column_code,column_cn_name,default_value,column_length,column_en_name,is_business_data,is_pk,is_null,column_type,sensitive_remark,update_frequency,column_desc,data_precision,code_index)
		select
			id,table_id,column_code,column_cn_name,default_value,column_length,column_en_name,is_business_data,is_pk,is_null,column_type,sensitive_remark,update_frequency,column_desc,data_precision,code_index
		from rz_dir.Dictionary_table_column  t;



	-- 	业务资源需求表
	insert into drap_business_requirement(id,region_code,requre_dept_id,source_dept_id,create_user,create_time,update_user,update_time)
		select
			id,'510100',requre_dep_id,source_dep_id,create_user,create_time,update_user,update_time
		from rz_dir.BUSINESS_REQUIREMENT  t;

	-- 	需求资源信息表
	insert into drap_requirement_resources(id,require_id,require_combing_type,doc_id,require_code,require_name,requirement_desc,brace_activity_id,is_get,expect_get_type,source_type,require_type,require_remark,other_info,expect_update_frequence,brace_app)
		select
			m.id,m.REQUIREMENT_ID,t.require_combing_type,null,t.require_code,m.SET_NAME,t.requirement_desc,t.activity_id,t.is_get,t.expect_get_type,t.REQUIRE_NAME_SOURCE,t.require_type,t.REQUIRE_SOURCE_REMARK,t.OTHERS,t.EXPECT_UPDATE_FREQUENCE,''
		from rz_dir.BUSINESS_REQUIREMENT t
		RIGHT JOIN  rz_dir.requirement_dataset_map m on t.id=m.REQUIREMENT_ID;


	delete from drap_db_monitor_task;
	-- 	数据库监控任务表	is_open->cur_status
	insert into drap_db_monitor_task(id,db_id,monitor_period,monitor_period_unit,monitor_start,monitor_end,next_start_time,auto_update_flag,cur_status)
		select
			id,db_id,monitor_period,monitor_period_unit,monitor_start,monitor_end,next_start_time,auto_update,is_open
		from rz_dir.DB_MONITOR_TASK t;

