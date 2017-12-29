-- 创建存储过程，用于执行创建索引前先删除索引，防止该SQL无法重复执行
DELIMITER $$

DROP PROCEDURE IF EXISTS `del_idx`$$

CREATE PROCEDURE `del_idx`(IN p_dbname VARCHAR(200), IN p_tablename VARCHAR(200), IN p_idxname VARCHAR(200))
BEGIN
	DECLARE str VARCHAR(250);

  SET @str=CONCAT(' drop index ',p_idxname,' on ',p_tablename);
  SELECT COUNT(*) INTO @cnt FROM information_schema.statistics WHERE table_name=p_tablename AND index_name=p_idxname AND index_schema=p_dbname;

  IF @cnt >0 THEN
    PREPARE stmt FROM @str;
    EXECUTE stmt ;
  END IF;
END$$

DELIMITER ;

-- 通过以下SQL，来检查生成服务器上的所有索引（PK索引除外）
-- -- 先删除
-- select concat('call del_idx(''',TABLE_SCHEMA,''',''', table_name,''',''', INDEX_NAME,''');') AS delete_SQL
-- from (
-- 	SELECT  TABLE_SCHEMA,table_name,INDEX_TYPE_NAME,index_name,GROUP_CONCAT(COLUMN_NAME  ORDER BY seq_in_index) as column_groups
-- 	FROM (
-- 		SELECT  case NON_UNIQUE when 0 then ' ADD UNIQUE ' WHEN 1 THEN ' ADD INDEX ' END AS INDEX_TYPE_NAME,seq_in_index,
-- 					TABLE_NAME,INDEX_NAME,COLUMN_NAME,TABLE_SCHEMA
-- 		  FROM
-- 		    INFORMATION_SCHEMA.STATISTICS t
-- 		WHERE
-- 		    TABLE_SCHEMA ='dsp_dir' and INDEX_NAME <> 'PRIMARY'
-- 	) A
-- 	group by table_name,index_name
-- ) b order by table_name,index_name;
-- -- 再生成索引
-- select concat('ALTER TABLE ',TABLE_NAME, INDEX_TYPE_NAME, INDEX_NAME,' (',column_groups,');') AS S_SQL
-- from (
-- 	SELECT  table_name,INDEX_TYPE_NAME,index_name,GROUP_CONCAT(COLUMN_NAME  ORDER BY seq_in_index) as column_groups
-- 	FROM (
-- 		SELECT  case NON_UNIQUE when 0 then ' ADD UNIQUE ' WHEN 1 THEN ' ADD INDEX ' END AS INDEX_TYPE_NAME,seq_in_index,
-- 					TABLE_NAME,INDEX_NAME,COLUMN_NAME
-- 		  FROM
-- 		    INFORMATION_SCHEMA.STATISTICS t
-- 		WHERE
-- 		    TABLE_SCHEMA ='dsp_dir' and INDEX_NAME <> 'PRIMARY'
-- 	) A
-- 	group by table_name,index_name
-- ) b order by table_name,index_name;

-- -- 先删除所有的索引
--
-- call del_idx('dsp_dir','dir_classify','Index_dirclassify_classifycode');
-- call del_idx('dsp_dir','dir_classify','Index_dirclassify_classifytype_region');
-- call del_idx('dsp_dir','dir_classify','Index_dirclassify_fid');
-- call del_idx('dsp_dir','dir_classify','Index_dirclassify_treecode_csname_cname');
-- call del_idx('dsp_dir','dir_classify','Index_dirclassify_treecode_id');
-- call del_idx('dsp_dir','dir_classify','Index_dirclassify_treecode_region');
-- call del_idx('dsp_dir','dir_classify_authority','Index_dirclassifyauthority_authobjid');
-- call del_idx('dsp_dir','dir_classify_authority','Index_dirclassifyauthority_classifyid');
-- call del_idx('dsp_dir','dir_classify_dept_map','Index_dirclassifydeptmap_deptid');
-- call del_idx('dsp_dir','dir_dataitem','Index_dirdataitem_datasetid');
-- call del_idx('dsp_dir','dir_dataitem','Index_dirdataitem_itemname');
-- call del_idx('dsp_dir','dir_dataitem_source_info','Index_dirdataitemsourceinfo_itemid');
-- call del_idx('dsp_dir','dir_dataitem_source_info','Index_dirdataitemsourceinfo_sourceitemid');
-- call del_idx('dsp_dir','dir_dataset','Index_dirdataset_belongdeptid');
-- call del_idx('dsp_dir','dir_dataset','Index_dirdataset_cdeptId_dname');
-- call del_idx('dsp_dir','dir_dataset','Index_dirdataset_datasetcode');
-- call del_idx('dsp_dir','dir_dataset','Index_dirdataset_name_open_share');
-- call del_idx('dsp_dir','dir_dataset','Index_dirdataset_name_open_share1');
-- call del_idx('dsp_dir','dir_dataset','Index_dirdataset_name_open_share2');
-- call del_idx('dsp_dir','dir_dataset_classify_map','Index_dirdatasetclassifymap_classifyid_datasetid_status');
-- call del_idx('dsp_dir','dir_dataset_classify_map','Index_dirdatasetclassifymap_datasetid_classifyid_status');
-- call del_idx('dsp_dir','dir_dataset_ext_format','Index_dirdatasetextformat_datasetid_formatCategory');
-- call del_idx('dsp_dir','dir_dataset_service_map','Index_dirdatasetservicemap_objid');
-- call del_idx('dsp_dir','dir_dataset_service_map','Index_dirdatasetservicemap_serviceid');
-- call del_idx('dsp_dir','dir_dataset_source_info','Index_dirdatasetsourceinfo_datasetid');
-- call del_idx('dsp_dir','dir_dataset_source_info','Index_dirdatasetsourceinfo_datasetid_sourceobjid');
-- call del_idx('dsp_dir','dir_dataset_source_info','Index_dirdatasetsourceinfo_sourceobjid');
-- call del_idx('dsp_dir','dir_dataset_source_relation','Index_dirdatasetsourcerelation_datasetid');
-- call del_idx('dsp_dir','dir_dataset_source_relation','Index_dirdatasetsourcerelation_sourcecolumnid');
-- call del_idx('dsp_dir','dir_dataset_source_relation','Index_dirdatasetsourcerelation_sourcetableid');
-- call del_idx('dsp_dir','dir_dataset_source_relation','Index_dirdatasetsourcerelation_targetcolumnid');
-- call del_idx('dsp_dir','dir_dataset_source_relation','Index_dirdatasetsourcerelation_targettableid');
-- call del_idx('dsp_dir','dir_data_audit','Index_dirdataaudit_dcmid');
-- call del_idx('dsp_dir','dir_data_collection','Index_dirdatacollection_dcmid');
-- call del_idx('dsp_dir','dir_data_comment','Index_dirdatacomment_dcmid');
-- call del_idx('dsp_dir','dir_data_correction','Index_dirdatacorrection_dcmid');
-- call del_idx('dsp_dir','dir_data_item_apply','Index_dirdataitemapply_dataapplyid');
-- call del_idx('dsp_dir','dir_data_item_apply','Index_dirdataitemapply_itemid');
-- call del_idx('dsp_dir','dir_data_offline','Index_dirdataoffline_dcmid');
-- call del_idx('dsp_dir','dir_data_publish','Index_dirdatapublish_dcmid_ptype');
-- call del_idx('dsp_dir','dir_data_rate','Index_dirdatarate_dcmid');
-- call del_idx('dsp_dir','dir_data_registe','Index_dirdataregiste_dcmid');
-- call del_idx('dsp_dir','dir_data_visit','Index_dirdatavisit_dcmid');
-- call del_idx('dsp_dir','dir_data_visit','Index_dirdatavisit_visitip');
-- call del_idx('dsp_dir','dir_news','Index_dirnews_title');
-- call del_idx('dsp_dir','dir_policy','Index_dirpolicy_title');
-- call del_idx('dsp_dir','dir_regist_user','Index_dirregistuser_loginname');
-- call del_idx('dsp_dir','dir_regist_user','Index_dirregistuser_realname');
-- call del_idx('dsp_dir','drap_activity_doc_item','Index_drapactivitydocitem_docid');
-- call del_idx('dsp_dir','drap_activity_doc_map','Index_drapactivitydocmap_activityid');
-- call del_idx('dsp_dir','drap_activity_doc_map','Index_drapactivitydocmap_docid');
-- call del_idx('dsp_dir','drap_activity_rel_depts','Index_drapactivityreldepts_activityid');
-- call del_idx('dsp_dir','drap_activity_rel_depts','Index_drapactivityreldepts_deptid');
-- call del_idx('dsp_dir','drap_activity_set_map','Index_drapactivitysetmap_activityid');
-- call del_idx('dsp_dir','drap_activity_set_map','Index_drapactivitysetmap_datasetid');
-- call del_idx('dsp_dir','drap_activity_system_map','Index_drapactivitysystemmap_activityid');
-- call del_idx('dsp_dir','drap_activity_system_map','Index_drapactivitysystemmap_systemid');
-- call del_idx('dsp_dir','drap_business_activity','Index_drapbusinessactivity_activityname');
-- call del_idx('dsp_dir','drap_business_activity','Index_drapbusinessactivity_name_target_uptime');
-- call del_idx('dsp_dir','drap_business_doc','Index_drapbusinessdoc_belongdept');
-- call del_idx('dsp_dir','drap_business_doc','Index_drapbusinessdoc_docname');
-- call del_idx('dsp_dir','drap_business_requirement','Index_drapbusinessrequirement_rd_sd_up');
-- call del_idx('dsp_dir','drap_business_requirement','Index_drapbusinessrequirement_requredeptid');
-- call del_idx('dsp_dir','drap_business_requirement','Index_drapbusinessrequirement_sourcedeptid');
-- call del_idx('dsp_dir','drap_dataset','Index_drapdataset_belongactivityid');
-- call del_idx('dsp_dir','drap_dataset','Index_drapdataset_belongdeptid');
-- call del_idx('dsp_dir','drap_dataset','Index_drapdataset_belongdepttype');
-- call del_idx('dsp_dir','drap_dataset','Index_drapdataset_datasetcode');
-- call del_idx('dsp_dir','drap_dataset','Index_drapdataset_datasetname');
-- call del_idx('dsp_dir','drap_dataset_item','Index_drapdatasetitem_itemname');
-- call del_idx('dsp_dir','drap_dataset_item_map','Index_drapdatasetitemmap_datasetid');
-- call del_idx('dsp_dir','drap_dataset_item_map','Index_drapdatasetitemmap_itemid');
-- call del_idx('dsp_dir','drap_dataset_system_map','Index_drapdatasetsystemmap_datasetid');
-- call del_idx('dsp_dir','drap_dataset_system_map','Index_drapdatasetsystemmap_datasetid_systemid');
-- call del_idx('dsp_dir','drap_dataset_system_map','Index_drapdatasetsystemmap_systemid');
-- call del_idx('dsp_dir','drap_data_column_map','Index_drapdatacolumnmap_businessitemid');
-- call del_idx('dsp_dir','drap_data_column_map','Index_drapdatacolumnmap_datasetid');
-- call del_idx('dsp_dir','drap_data_column_map','Index_drapdatacolumnmap_dbid');
-- call del_idx('dsp_dir','drap_data_column_map','Index_drapdatacolumnmap_infosystemid');
-- call del_idx('dsp_dir','drap_data_column_map','Index_drapdatacolumnmap_systemcolumnid');
-- call del_idx('dsp_dir','drap_data_column_map','Index_drapdatacolumnmap_tableid');
-- call del_idx('dsp_dir','drap_db_info','Index_drapdbinfo_belongdept');
-- call del_idx('dsp_dir','drap_db_info','Index_drapdbinfo_dbcnname');
-- call del_idx('dsp_dir','drap_db_info','Index_drapdbinfo_dbname');
-- call del_idx('dsp_dir','drap_db_system_map','Index_drapdbsystemmap_dbid');
-- call del_idx('dsp_dir','drap_db_system_map','Index_drapdbsystemmap_infosystemid');
-- call del_idx('dsp_dir','drap_db_table_column','Index_drapdbtablecolumn_columncnname');
-- call del_idx('dsp_dir','drap_db_table_column','Index_drapdbtablecolumn_columnenname');
-- call del_idx('dsp_dir','drap_db_table_column','Index_drapdbtablecolumn_tableid');
-- call del_idx('dsp_dir','drap_db_table_info','Index_drapdbtableinfo_dbid');
-- call del_idx('dsp_dir','drap_db_table_info','Index_drapdbtableinfo_tablecnname');
-- call del_idx('dsp_dir','drap_db_table_info','Index_drapdbtableinfo_tablename');
-- call del_idx('dsp_dir','drap_dict_table_column','Index_drapdicttablecolumn_columncnname');
-- call del_idx('dsp_dir','drap_dict_table_column','Index_drapdicttablecolumn_columnenname');
-- call del_idx('dsp_dir','drap_dict_table_column','Index_drapdicttablecolumn_tableid');
-- call del_idx('dsp_dir','drap_dict_table_info','Index_drapdicttableinfo_dbid');
-- call del_idx('dsp_dir','drap_dict_table_info','Index_drapdicttableinfo_tablecnname');
-- call del_idx('dsp_dir','drap_dict_table_info','Index_drapdicttableinfo_tablename');
-- call del_idx('dsp_dir','drap_info_system','Index_drapinfosystem_belongdept');
-- call del_idx('dsp_dir','drap_info_system','Index_drapinfosystem_systemcode');
-- call del_idx('dsp_dir','drap_info_system','Index_drapinfosystem_systemname');
-- call del_idx('dsp_dir','drap_item_required_dept','Index_drapitemrequireddept_deptid');
-- call del_idx('dsp_dir','drap_item_required_dept','Index_drapitemrequireddept_itemid');
-- call del_idx('dsp_dir','drap_requirement_dataset_map','Index_draprequirementdatasetmap_datasetid');
-- call del_idx('dsp_dir','drap_requirement_dataset_map','Index_draprequirementdatasetmap_requireid');
-- call del_idx('dsp_dir','drap_requirement_resources','Index_draprequirementresources_docid');
-- call del_idx('dsp_dir','drap_requirement_resources','Index_draprequirementresources_requireid');
-- call del_idx('dsp_dir','drap_system_use_dept','Index_drapsystemusedept_deptid');
-- call del_idx('dsp_dir','drap_system_use_dept','Index_drapsystemusedept_systemid');
-- call del_idx('dsp_dir','sys_dept','Index_sysdept_deptcode');
-- call del_idx('dsp_dir','sys_dept','Index_sysdept_fid');
-- call del_idx('dsp_dir','sys_dept','Index_sysdept_id_treecode_deptname');
-- call del_idx('dsp_dir','sys_dept','Index_sysdept_treeCode_deptName');
-- call del_idx('dsp_dir','sys_dept_authority','Index_sysdeptauthority_authobjid');
-- call del_idx('dsp_dir','sys_dept_authority_apply','Index_sysdeptauthorityapply_applicant');
-- call del_idx('dsp_dir','sys_dept_contacts','Index_sysdeptcontacts_curdeptid');
-- call del_idx('dsp_dir','sys_dict','Index_sysdict_category_dictcode');
-- call del_idx('dsp_dir','sys_dict','Index_sysdict_parentcode');
-- call del_idx('dsp_dir','sys_guid_dept','Index_sysguiddept_curdeptid');
-- call del_idx('dsp_dir','sys_guid_dept','Index_sysguiddept_guiddeptid');
-- call del_idx('dsp_dir','sys_log','Index_syslog_operatorid');
-- call del_idx('dsp_dir','sys_menu','Index_sysmenu_meun_info');
-- call del_idx('dsp_dir','sys_menu','Index_sysmenu_pid_id');
-- call del_idx('dsp_dir','sys_region','Index_sysregion_fcode');
-- call del_idx('dsp_dir','sys_region','Index_sysregion_info');
-- call del_idx('dsp_dir','sys_role','Index_sys_role_id_delete');
-- call del_idx('dsp_dir','sys_role_menu','Index_sysrolemenu_roleid_menuid');
-- call del_idx('dsp_dir','sys_setting','Index_syssetting_settingtype');
-- call del_idx('dsp_dir','sys_setting','Index_sys_setting_settingcode_value');
-- call del_idx('dsp_dir','sys_user','Index_sysuser_id_username');
-- call del_idx('dsp_dir','sys_user','Index_sysuser_username_info');
-- call del_idx('dsp_dir','sys_user','Index_sysuser_username_password');
-- call del_idx('dsp_dir','sys_user_role','Index_sysuserrole_roleid');
-- call del_idx('dsp_dir','sys_user_role','Index_sysuserrole_userid');

ALTER TABLE dir_classify ADD INDEX Index_dirclassify_classifycode (classify_code);
ALTER TABLE dir_classify ADD INDEX Index_dirclassify_classifytype_region (classify_type,region_code);
ALTER TABLE dir_classify ADD UNIQUE Index_dirclassify_fid (fid,order_number,classify_name,tree_code,id);
ALTER TABLE dir_classify ADD INDEX Index_dirclassify_treecode_csname_cname (tree_code,classify_name,classify_structure_name);
ALTER TABLE dir_classify ADD INDEX Index_dirclassify_treecode_id (tree_code,id);
ALTER TABLE dir_classify ADD UNIQUE Index_dirclassify_treecode_region (tree_code,id);
ALTER TABLE dir_classify_authority ADD INDEX Index_dirclassifyauthority_authobjid (auth_obj_id);
ALTER TABLE dir_classify_authority ADD INDEX Index_dirclassifyauthority_classifyid (classify_id);
ALTER TABLE dir_classify_dept_map ADD INDEX Index_dirclassifydeptmap_deptid (dept_id);
ALTER TABLE dir_dataitem ADD INDEX Index_dirdataitem_datasetid (dataset_id);
ALTER TABLE dir_dataitem ADD INDEX Index_dirdataitem_itemname (item_name);
ALTER TABLE dir_dataitem_source_info ADD INDEX Index_dirdataitemsourceinfo_itemid (item_id);
ALTER TABLE dir_dataitem_source_info ADD INDEX Index_dirdataitemsourceinfo_sourceitemid (source_item_id);
ALTER TABLE dir_dataset ADD INDEX Index_dirdataset_belongdeptid (belong_dept_id);
ALTER TABLE dir_dataset ADD INDEX Index_dirdataset_cdeptId_dname (id,charge_dept_id,dataset_name,share_type,is_open,update_time);
ALTER TABLE dir_dataset ADD INDEX Index_dirdataset_datasetcode (dataset_code);
ALTER TABLE dir_dataset ADD INDEX Index_dirdataset_name_open_share (dataset_name,share_type,is_open,update_time);
ALTER TABLE dir_dataset ADD INDEX Index_dirdataset_name_open_share1 (share_type,is_open,dataset_name,update_time);
ALTER TABLE dir_dataset ADD INDEX Index_dirdataset_name_open_share2 (is_open,share_type,dataset_name,update_time);
ALTER TABLE dir_dataset_classify_map ADD UNIQUE Index_dirdatasetclassifymap_classifyid_datasetid_status (classify_id,dataset_id,status,id,delete_flag);
ALTER TABLE dir_dataset_classify_map ADD UNIQUE Index_dirdatasetclassifymap_datasetid_classifyid_status (dataset_id,classify_id,status,id,delete_flag);
ALTER TABLE dir_dataset_ext_format ADD INDEX Index_dirdatasetextformat_datasetid_formatCategory (dataset_id,format_category);
ALTER TABLE dir_dataset_service_map ADD INDEX Index_dirdatasetservicemap_objid (obj_id);
ALTER TABLE dir_dataset_service_map ADD INDEX Index_dirdatasetservicemap_serviceid (service_id);
ALTER TABLE dir_dataset_source_info ADD INDEX Index_dirdatasetsourceinfo_datasetid (dataset_id);
ALTER TABLE dir_dataset_source_info ADD INDEX Index_dirdatasetsourceinfo_datasetid_sourceobjid (dataset_id,source_obj_id);
ALTER TABLE dir_dataset_source_info ADD INDEX Index_dirdatasetsourceinfo_sourceobjid (source_obj_id);
ALTER TABLE dir_dataset_source_relation ADD INDEX Index_dirdatasetsourcerelation_datasetid (dataset_id);
ALTER TABLE dir_dataset_source_relation ADD INDEX Index_dirdatasetsourcerelation_sourcecolumnid (source_column_id);
ALTER TABLE dir_dataset_source_relation ADD INDEX Index_dirdatasetsourcerelation_sourcetableid (source_table_id);
ALTER TABLE dir_dataset_source_relation ADD INDEX Index_dirdatasetsourcerelation_targetcolumnid (target_column_id);
ALTER TABLE dir_dataset_source_relation ADD INDEX Index_dirdatasetsourcerelation_targettableid (target_table_id);
ALTER TABLE dir_data_audit ADD INDEX Index_dirdataaudit_dcmid (dcm_id);
ALTER TABLE dir_data_collection ADD INDEX Index_dirdatacollection_dcmid (dcm_id);
ALTER TABLE dir_data_comment ADD INDEX Index_dirdatacomment_dcmid (dcm_id);
ALTER TABLE dir_data_correction ADD INDEX Index_dirdatacorrection_dcmid (dcm_id);
ALTER TABLE dir_data_item_apply ADD INDEX Index_dirdataitemapply_dataapplyid (data_apply_id);
ALTER TABLE dir_data_item_apply ADD INDEX Index_dirdataitemapply_itemid (item_id);
ALTER TABLE dir_data_offline ADD INDEX Index_dirdataoffline_dcmid (dcm_id);
ALTER TABLE dir_data_publish ADD INDEX Index_dirdatapublish_dcmid_ptype (dcm_id,publish_type);
ALTER TABLE dir_data_rate ADD INDEX Index_dirdatarate_dcmid (dcm_id);
ALTER TABLE dir_data_registe ADD INDEX Index_dirdataregiste_dcmid (dcm_id);
ALTER TABLE dir_data_visit ADD INDEX Index_dirdatavisit_dcmid (dcm_id);
ALTER TABLE dir_data_visit ADD INDEX Index_dirdatavisit_visitip (visit_ip);
ALTER TABLE dir_news ADD INDEX Index_dirnews_title (title);
ALTER TABLE dir_policy ADD INDEX Index_dirpolicy_title (title);
ALTER TABLE dir_regist_user ADD INDEX Index_dirregistuser_loginname (login_name);
ALTER TABLE dir_regist_user ADD INDEX Index_dirregistuser_realname (real_name);
ALTER TABLE drap_activity_doc_item ADD INDEX Index_drapactivitydocitem_docid (doc_id);
ALTER TABLE drap_activity_doc_map ADD INDEX Index_drapactivitydocmap_activityid (activity_id);
ALTER TABLE drap_activity_doc_map ADD INDEX Index_drapactivitydocmap_docid (doc_id);
ALTER TABLE drap_activity_rel_depts ADD INDEX Index_drapactivityreldepts_activityid (activity_id);
ALTER TABLE drap_activity_rel_depts ADD INDEX Index_drapactivityreldepts_deptid (dept_id);
ALTER TABLE drap_activity_set_map ADD INDEX Index_drapactivitysetmap_activityid (activity_id);
ALTER TABLE drap_activity_set_map ADD INDEX Index_drapactivitysetmap_datasetid (dataset_id);
ALTER TABLE drap_activity_system_map ADD INDEX Index_drapactivitysystemmap_activityid (activity_id);
ALTER TABLE drap_activity_system_map ADD INDEX Index_drapactivitysystemmap_systemid (system_id);
ALTER TABLE drap_business_activity ADD INDEX Index_drapbusinessactivity_activityname (activity_name);
ALTER TABLE drap_business_activity ADD INDEX Index_drapbusinessactivity_name_target_uptime (belong_dept,activity_name,update_time,service_target);
ALTER TABLE drap_business_doc ADD INDEX Index_drapbusinessdoc_belongdept (belong_dept);
ALTER TABLE drap_business_doc ADD INDEX Index_drapbusinessdoc_docname (doc_name);
ALTER TABLE drap_business_requirement ADD INDEX Index_drapbusinessrequirement_rd_sd_up (requre_dept_id,source_dept_id,create_time,delete_flag);
ALTER TABLE drap_business_requirement ADD INDEX Index_drapbusinessrequirement_requredeptid (requre_dept_id);
ALTER TABLE drap_business_requirement ADD INDEX Index_drapbusinessrequirement_sourcedeptid (source_dept_id);
ALTER TABLE drap_dataset ADD INDEX Index_drapdataset_belongactivityid (belong_activity_id);
ALTER TABLE drap_dataset ADD INDEX Index_drapdataset_belongdeptid (belong_dept_id);
ALTER TABLE drap_dataset ADD INDEX Index_drapdataset_belongdepttype (belong_dept_type);
ALTER TABLE drap_dataset ADD INDEX Index_drapdataset_datasetcode (dataset_code);
ALTER TABLE drap_dataset ADD INDEX Index_drapdataset_datasetname (dataset_name);
ALTER TABLE drap_dataset_item ADD INDEX Index_drapdatasetitem_itemname (item_name);
ALTER TABLE drap_dataset_item_map ADD INDEX Index_drapdatasetitemmap_datasetid (dataset_id);
ALTER TABLE drap_dataset_item_map ADD INDEX Index_drapdatasetitemmap_itemid (item_id);
ALTER TABLE drap_dataset_system_map ADD INDEX Index_drapdatasetsystemmap_datasetid (dataset_id);
ALTER TABLE drap_dataset_system_map ADD INDEX Index_drapdatasetsystemmap_datasetid_systemid (dataset_id,system_id);
ALTER TABLE drap_dataset_system_map ADD INDEX Index_drapdatasetsystemmap_systemid (system_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_businessitemid (business_item_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_datasetid (dataset_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_dbid (db_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_infosystemid (info_system_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_systemcolumnid (system_column_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_tableid (table_id);
ALTER TABLE drap_db_info ADD INDEX Index_drapdbinfo_belongdept (belong_dept);
ALTER TABLE drap_db_info ADD INDEX Index_drapdbinfo_dbcnname (db_cn_name);
ALTER TABLE drap_db_info ADD INDEX Index_drapdbinfo_dbname (db_name);
ALTER TABLE drap_db_system_map ADD INDEX Index_drapdbsystemmap_dbid (db_id);
ALTER TABLE drap_db_system_map ADD INDEX Index_drapdbsystemmap_infosystemid (info_system_id);
ALTER TABLE drap_db_table_column ADD INDEX Index_drapdbtablecolumn_columncnname (column_cn_name);
ALTER TABLE drap_db_table_column ADD INDEX Index_drapdbtablecolumn_columnenname (column_en_name);
ALTER TABLE drap_db_table_column ADD INDEX Index_drapdbtablecolumn_tableid (table_id);
ALTER TABLE drap_db_table_info ADD INDEX Index_drapdbtableinfo_dbid (db_id);
ALTER TABLE drap_db_table_info ADD INDEX Index_drapdbtableinfo_tablecnname (table_cn_name);
ALTER TABLE drap_db_table_info ADD INDEX Index_drapdbtableinfo_tablename (table_name);
ALTER TABLE drap_dict_table_column ADD INDEX Index_drapdicttablecolumn_columncnname (column_cn_name);
ALTER TABLE drap_dict_table_column ADD INDEX Index_drapdicttablecolumn_columnenname (column_en_name);
ALTER TABLE drap_dict_table_column ADD INDEX Index_drapdicttablecolumn_tableid (table_id);
ALTER TABLE drap_dict_table_info ADD INDEX Index_drapdicttableinfo_dbid (db_id);
ALTER TABLE drap_dict_table_info ADD INDEX Index_drapdicttableinfo_tablecnname (table_cn_name);
ALTER TABLE drap_dict_table_info ADD INDEX Index_drapdicttableinfo_tablename (table_name);
ALTER TABLE drap_info_system ADD INDEX Index_drapinfosystem_belongdept (belong_dept);
ALTER TABLE drap_info_system ADD INDEX Index_drapinfosystem_systemcode (system_code);
ALTER TABLE drap_info_system ADD INDEX Index_drapinfosystem_systemname (system_name);
ALTER TABLE drap_item_required_dept ADD INDEX Index_drapitemrequireddept_deptid (dept_id);
ALTER TABLE drap_item_required_dept ADD INDEX Index_drapitemrequireddept_itemid (item_id);
ALTER TABLE drap_requirement_dataset_map ADD INDEX Index_draprequirementdatasetmap_datasetid (dataset_id);
ALTER TABLE drap_requirement_dataset_map ADD INDEX Index_draprequirementdatasetmap_requireid (require_id);
ALTER TABLE drap_requirement_resources ADD INDEX Index_draprequirementresources_docid (doc_id);
ALTER TABLE drap_requirement_resources ADD INDEX Index_draprequirementresources_requireid (require_id);
ALTER TABLE drap_system_use_dept ADD INDEX Index_drapsystemusedept_deptid (dept_id);
ALTER TABLE drap_system_use_dept ADD INDEX Index_drapsystemusedept_systemid (system_id);
ALTER TABLE sys_dept ADD INDEX Index_sysdept_deptcode (dept_code);
ALTER TABLE sys_dept ADD INDEX Index_sysdept_fid (fid);
ALTER TABLE sys_dept ADD UNIQUE Index_sysdept_id_treecode_deptname (id,tree_code,dept_name);
ALTER TABLE sys_dept ADD UNIQUE Index_sysdept_treeCode_deptName (tree_code,dept_name);
ALTER TABLE sys_dept_authority ADD INDEX Index_sysdeptauthority_authobjid (auth_obj_id);
ALTER TABLE sys_dept_authority_apply ADD INDEX Index_sysdeptauthorityapply_applicant (applicant);
ALTER TABLE sys_dept_contacts ADD INDEX Index_sysdeptcontacts_curdeptid (cur_dept_id);
ALTER TABLE sys_dict ADD INDEX Index_sysdict_category_dictcode (category,dict_code,dict_name);
ALTER TABLE sys_dict ADD INDEX Index_sysdict_parentcode (parent_code);
ALTER TABLE sys_guid_dept ADD INDEX Index_sysguiddept_curdeptid (cur_dept_id);
ALTER TABLE sys_guid_dept ADD INDEX Index_sysguiddept_guiddeptid (guid_dept_id);
ALTER TABLE sys_log ADD INDEX Index_syslog_operatorid (operator_id);
ALTER TABLE sys_menu ADD INDEX Index_sysmenu_meun_info (menu_type,sort,menu_name,pid,url,icon,id,delete_flag);
ALTER TABLE sys_menu ADD INDEX Index_sysmenu_pid_id (pid,id);
ALTER TABLE sys_region ADD INDEX Index_sysregion_fcode (fcode);
ALTER TABLE sys_region ADD UNIQUE Index_sysregion_info (region_code,id,region_name,fcode,fname,region_level_code,status);
ALTER TABLE sys_role ADD INDEX Index_sys_role_id_delete (id,role_name,delete_flag,role_level,status,create_time,update_time);
ALTER TABLE sys_role_menu ADD INDEX Index_sysrolemenu_roleid_menuid (role_id,menu_id);
ALTER TABLE sys_setting ADD UNIQUE Index_syssetting_settingtype (setting_type,setting_code,setting_value,id);
ALTER TABLE sys_setting ADD UNIQUE Index_sys_setting_settingcode_value (setting_code,setting_value);
ALTER TABLE sys_user ADD UNIQUE Index_sysuser_id_username (id,user_name);
ALTER TABLE sys_user ADD INDEX Index_sysuser_username_info (user_name,delete_flag,dept_id,region_code,create_user_id);
ALTER TABLE sys_user ADD UNIQUE Index_sysuser_username_password (user_name,password,dept_id);
ALTER TABLE sys_user_role ADD INDEX Index_sysuserrole_roleid (role_id,user_id);
ALTER TABLE sys_user_role ADD INDEX Index_sysuserrole_userid (user_id,role_id);