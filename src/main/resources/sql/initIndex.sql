-- 创建存储过程，用于执行创建索引前先删除索引，防止该SQL无法重复执行
DROP PROCEDURE IF EXISTS del_idx;
create procedure del_idx(IN p_tablename varchar(200), IN p_idxname VARCHAR(200))
begin
	DECLARE str VARCHAR(250);

  set @str=concat(' drop index ',p_idxname,' on ',p_tablename);
  select count(*) into @cnt from information_schema.statistics where table_name=p_tablename and index_name=p_idxname ;

  if @cnt >0 then
    PREPARE stmt FROM @str;
    EXECUTE stmt ;
  end if;
end ;



-- 先删除所有的索引
call del_idx('dir_classify','Index_dirclassify_classifycode');
call del_idx('dir_classify','Index_dirclassify_fid');
call del_idx('dir_classify','Index_dirclassify_classifystructurecode');
call del_idx('dir_classify_authority','Index_dirclassifyauthority_authobjid');
call del_idx('dir_classify_authority','Index_dirclassifyauthority_classifyid');
call del_idx('dir_data_audit','Index_dirdataaudit_dcmid');
call del_idx('dir_data_collection','Index_dirdatacollection_dcmid');
call del_idx('dir_data_comment','Index_dirdatacomment_dcmid');
call del_idx('dir_data_correction','Index_dirdatacorrection_dcmid');
call del_idx('dir_data_offline','Index_dirdataoffline_dcmid');
call del_idx('dir_data_publish','Index_dirdatapublish_dcmid');
call del_idx('dir_data_rate','Index_dirdatarate_dcmid');
call del_idx('dir_data_registe','Index_dirdataregiste_dcmid');
call del_idx('dir_data_visit','Index_dirdatavisit_dcmid');
call del_idx('dir_data_visit','Index_dirdatavisit_visitip');
call del_idx('dir_dataitem','Index_dirdataitem_datasetid');
call del_idx('dir_dataitem','Index_dirdataitem_itemname');
call del_idx('dir_data_item_apply','Index_dirdataitemapply_dcmid');
call del_idx('dir_data_item_apply','Index_dirdataitemapply_itemid');
call del_idx('dir_dataitem_source_info','Index_dirdataitemsourceinfo_itemid');
call del_idx('dir_dataitem_source_info','Index_dirdataitemsourceinfo_sourceitemid');
call del_idx('dir_dataset','Index_dirdataset_datasetcode');
call del_idx('dir_dataset','Index_dirdataset_datasetname');
call del_idx('dir_dataset','Index_dirdataset_belongdeptid');
call del_idx('dir_dataset_classify_map','Index_dirdatasetclassifymap_datasetid');
call del_idx('dir_dataset_classify_map','Index_dirdatasetclassifymap_classifyid');
call del_idx('dir_dataset_classify_map','Index_dirdatasetclassifymap_inforesourcecode');
call del_idx('dir_dataset_ext_format','Index_dirdatasetextformat_datasetid');
call del_idx('dir_dataset_service_map','Index_dirdatasetservicemap_serviceid');
call del_idx('dir_dataset_service_map','Index_dirdatasetservicemap_objid');
call del_idx('dir_dataset_source_info','Index_dirdatasetsourceinfo_datasetid');
call del_idx('dir_dataset_source_info','Index_dirdatasetsourceinfo_sourceobjid');
call del_idx('dir_dataset_source_relation','Index_dirdatasetsourcerelation_datasetid');
call del_idx('dir_dataset_source_relation','Index_dirdatasetsourcerelation_sourcetableid');
call del_idx('dir_dataset_source_relation','Index_dirdatasetsourcerelation_sourcecolumnid');
call del_idx('dir_dataset_source_relation','Index_dirdatasetsourcerelation_targettableid');
call del_idx('dir_dataset_source_relation','Index_dirdatasetsourcerelation_targetcolumnid');
call del_idx('dir_news','Index_dirnews_title');
call del_idx('dir_policy','Index_dirpolicy_title');
call del_idx('dir_regist_user','Index_dirregistuser_loginname');
call del_idx('dir_regist_user','Index_dirregistuser_realname');
call del_idx('sys_dept','Index_sysdept_deptcode');
call del_idx('sys_dept','Index_sysdept_deptname');
call del_idx('sys_dept','Index_sysdept_deptshortname');
call del_idx('sys_dept','Index_sysdept_fid');
call del_idx('sys_dept_authority','Index_sysdeptauthority_authobjid');
call del_idx('sys_dept_authority_apply','Index_sysdeptauthorityapply_applicant');
call del_idx('sys_dept_contacts','Index_sysdeptcontacts_curdeptid');
call del_idx('sys_dict','Index_sysdict_dictcode');
call del_idx('sys_dict','Index_sysdict_parentcode');
call del_idx('sys_guid_dept','Index_sysguiddept_curdeptid');
call del_idx('sys_guid_dept','Index_sysguiddept_guiddeptid');
call del_idx('sys_log','Index_syslog_operatorid');
call del_idx('sys_region','Index_sysregion_regioncode');
call del_idx('sys_region','Index_sysregion_fcode');
call del_idx('sys_role_menu','Index_sysrolemenu_roleid');
call del_idx('sys_role_menu','Index_sysrolemenu_menuid');
call del_idx('sys_user','Index_sysuser_username');
call del_idx('sys_user','Index_sysuser_realname');
call del_idx('sys_user_role','Index_sysuserrole_userid');
call del_idx('sys_user_role','Index_sysuserrole_roleid');
call del_idx('drap_activity_doc_item','Index_drapactivitydocitem_docid');
call del_idx('drap_activity_doc_map','Index_drapactivitydocmap_activityid');
call del_idx('drap_activity_doc_map','Index_drapactivitydocmap_docid');
call del_idx('drap_activity_rel_depts','Index_drapactivityreldepts_activityid');
call del_idx('drap_activity_rel_depts','Index_drapactivityreldepts_deptid');
call del_idx('drap_activity_set_map','Index_drapactivitysetmap_datasetid');
call del_idx('drap_activity_set_map','Index_drapactivitysetmap_activityid');
call del_idx('drap_activity_system_map','Index_drapactivitysystemmap_activityid');
call del_idx('drap_activity_system_map','Index_drapactivitysystemmap_systemid');
call del_idx('drap_business_activity','Index_drapbusinessactivity_belongdept');
call del_idx('drap_business_activity','Index_drapbusinessactivity_activityname');
call del_idx('drap_business_doc','Index_drapbusinessdoc_belongdept');
call del_idx('drap_business_doc','Index_drapbusinessdoc_docname');
call del_idx('drap_business_requirement','Index_drapbusinessrequirement_requredeptid');
call del_idx('drap_business_requirement','Index_drapbusinessrequirement_sourcedeptid');
call del_idx('drap_data_column_map','Index_drapdatacolumnmap_datasetid');
call del_idx('drap_data_column_map','Index_drapdatacolumnmap_businessitemid');
call del_idx('drap_data_column_map','Index_drapdatacolumnmap_systemcolumnid');
call del_idx('drap_data_column_map','Index_drapdatacolumnmap_infosystemid');
call del_idx('drap_data_column_map','Index_drapdatacolumnmap_dbid');
call del_idx('drap_data_column_map','Index_drapdatacolumnmap_tableid');
call del_idx('drap_dataset','Index_drapdataset_belongdepttype');
call del_idx('drap_dataset','Index_drapdataset_belongdeptid');
call del_idx('drap_dataset','Index_drapdataset_belongactivityid');
call del_idx('drap_dataset','Index_drapdataset_datasetname');
call del_idx('drap_dataset','Index_drapdataset_datasetcode');
call del_idx('drap_dataset_item','Index_drapdatasetitem_itemname');
call del_idx('drap_dataset_item_map','Index_drapdatasetitemmap_datasetid');
call del_idx('drap_dataset_item_map','Index_drapdatasetitemmap_itemid');
call del_idx('drap_dataset_system_map','Index_drapdatasetsystemmap_datasetid');
call del_idx('drap_dataset_system_map','Index_drapdatasetsystemmap_systemid');
call del_idx('drap_db_info','Index_drapdbinfo_belongdept');
call del_idx('drap_db_info','Index_drapdbinfo_dbname');
call del_idx('drap_db_info','Index_drapdbinfo_dbcnname');
call del_idx('drap_db_system_map','Index_drapdbsystemmap_dbid');
call del_idx('drap_db_system_map','Index_drapdbsystemmap_infosystemid');
call del_idx('drap_db_table_column','Index_drapdbtablecolumn_tableid');
call del_idx('drap_db_table_column','Index_drapdbtablecolumn_columnenname');
call del_idx('drap_db_table_column','Index_drapdbtablecolumn_columncnname');
call del_idx('drap_db_table_info','Index_drapdbtableinfo_dbid');
call del_idx('drap_db_table_info','Index_drapdbtableinfo_tablename');
call del_idx('drap_db_table_info','Index_drapdbtableinfo_tablecnname');
call del_idx('drap_dict_table_column','Index_drapdicttablecolumn_tableid');
call del_idx('drap_dict_table_column','Index_drapdicttablecolumn_columncnname');
call del_idx('drap_dict_table_column','Index_drapdicttablecolumn_columnenname');
call del_idx('drap_dict_table_info','Index_drapdicttableinfo_dbid');
call del_idx('drap_dict_table_info','Index_drapdicttableinfo_tablename');
call del_idx('drap_dict_table_info','Index_drapdicttableinfo_tablecnname');
call del_idx('drap_info_system','Index_drapinfosystem_belongdept');
call del_idx('drap_info_system','Index_drapinfosystem_systemcode');
call del_idx('drap_info_system','Index_drapinfosystem_systemname');
call del_idx('drap_item_required_dept','Index_drapitemrequireddept_itemid');
call del_idx('drap_item_required_dept','Index_drapitemrequireddept_deptid');
call del_idx('drap_requirement_dataset_map','Index_draprequirementdatasetmap_requireid');
call del_idx('drap_requirement_dataset_map','Index_draprequirementdatasetmap_datasetid');
call del_idx('drap_requirement_resources','Index_draprequirementresources_requireid');
call del_idx('drap_requirement_resources','Index_draprequirementresources_docid');
call del_idx('drap_system_use_dept','Index_drapsystemusedept_systemid');
call del_idx('drap_system_use_dept','Index_drapsystemusedept_deptid');
call del_idx('drap_system_use_info','Index_drapsystemuseinfo_infosystemid');


ALTER TABLE dir_classify ADD INDEX Index_dirclassify_classifycode (classify_code);
ALTER TABLE dir_classify ADD INDEX Index_dirclassify_fid (fid);
ALTER TABLE dir_classify ADD INDEX Index_dirclassify_classifystructurecode (classify_structure_code (255));
ALTER TABLE dir_classify_authority ADD INDEX Index_dirclassifyauthority_authobjid (auth_obj_id);
ALTER TABLE dir_classify_authority ADD INDEX Index_dirclassifyauthority_classifyid (classify_id);
ALTER TABLE dir_data_audit ADD INDEX Index_dirdataaudit_dcmid (dcm_id);
ALTER TABLE dir_data_collection ADD INDEX Index_dirdatacollection_dcmid (dcm_id);
ALTER TABLE dir_data_comment ADD INDEX Index_dirdatacomment_dcmid (dcm_id);
ALTER TABLE dir_data_correction ADD INDEX Index_dirdatacorrection_dcmid (dcm_id);
ALTER TABLE dir_data_offline ADD INDEX Index_dirdataoffline_dcmid (dcm_id);
ALTER TABLE dir_data_publish ADD INDEX Index_dirdatapublish_dcmid (dcm_id);
ALTER TABLE dir_data_rate ADD INDEX Index_dirdatarate_dcmid (dcm_id);
ALTER TABLE dir_data_registe ADD INDEX Index_dirdataregiste_dcmid (dcm_id);
ALTER TABLE dir_data_visit ADD INDEX Index_dirdatavisit_dcmid (dcm_id);
ALTER TABLE dir_data_visit ADD INDEX Index_dirdatavisit_visitip (visit_ip);
ALTER TABLE dir_dataitem ADD INDEX Index_dirdataitem_datasetid (dataset_id);
ALTER TABLE dir_dataitem ADD INDEX Index_dirdataitem_itemname (item_name);
ALTER TABLE dir_data_item_apply ADD INDEX Index_dirdataitemapply_dcmid (dcm_id);
ALTER TABLE dir_data_item_apply ADD INDEX Index_dirdataitemapply_itemid (item_id);
ALTER TABLE dir_dataitem_source_info ADD INDEX Index_dirdataitemsourceinfo_itemid (item_id);
ALTER TABLE dir_dataitem_source_info ADD INDEX Index_dirdataitemsourceinfo_sourceitemid (source_item_id);
ALTER TABLE dir_dataset ADD INDEX Index_dirdataset_datasetcode (dataset_code);
ALTER TABLE dir_dataset ADD INDEX Index_dirdataset_datasetname (dataset_name);
ALTER TABLE dir_dataset ADD INDEX Index_dirdataset_belongdeptid (belong_dept_id);
ALTER TABLE dir_dataset_classify_map ADD INDEX Index_dirdatasetclassifymap_datasetid (dataset_id);
ALTER TABLE dir_dataset_classify_map ADD INDEX Index_dirdatasetclassifymap_classifyid (classify_id);
ALTER TABLE dir_dataset_classify_map ADD INDEX Index_dirdatasetclassifymap_inforesourcecode (info_resource_code);
ALTER TABLE dir_dataset_ext_format ADD INDEX Index_dirdatasetextformat_datasetid (dataset_id);
ALTER TABLE dir_dataset_service_map ADD INDEX Index_dirdatasetservicemap_serviceid (service_id);
ALTER TABLE dir_dataset_service_map ADD INDEX Index_dirdatasetservicemap_objid (obj_id);
ALTER TABLE dir_dataset_source_info ADD INDEX Index_dirdatasetsourceinfo_datasetid (dataset_id);
ALTER TABLE dir_dataset_source_info ADD INDEX Index_dirdatasetsourceinfo_sourceobjid (source_obj_id);
ALTER TABLE dir_dataset_source_relation ADD INDEX Index_dirdatasetsourcerelation_datasetid (dataset_id);
ALTER TABLE dir_dataset_source_relation ADD INDEX Index_dirdatasetsourcerelation_sourcetableid (source_table_id);
ALTER TABLE dir_dataset_source_relation ADD INDEX Index_dirdatasetsourcerelation_sourcecolumnid (source_column_id);
ALTER TABLE dir_dataset_source_relation ADD INDEX Index_dirdatasetsourcerelation_targettableid (target_table_id);
ALTER TABLE dir_dataset_source_relation ADD INDEX Index_dirdatasetsourcerelation_targetcolumnid (target_column_id);
ALTER TABLE dir_news ADD INDEX Index_dirnews_title (title (255));
ALTER TABLE dir_policy ADD INDEX Index_dirpolicy_title (title (255));
ALTER TABLE dir_regist_user ADD INDEX Index_dirregistuser_loginname (login_name);
ALTER TABLE dir_regist_user ADD INDEX Index_dirregistuser_realname (real_name);
ALTER TABLE sys_dept ADD INDEX Index_sysdept_deptcode (dept_code);
ALTER TABLE sys_dept ADD INDEX Index_sysdept_deptname (dept_name (255));
ALTER TABLE sys_dept ADD INDEX Index_sysdept_deptshortname (dept_short_name (255));
ALTER TABLE sys_dept ADD INDEX Index_sysdept_fid (fid);
ALTER TABLE sys_dept_authority ADD INDEX Index_sysdeptauthority_authobjid (auth_obj_id);
ALTER TABLE sys_dept_authority_apply ADD INDEX Index_sysdeptauthorityapply_applicant (applicant);
ALTER TABLE sys_dept_contacts ADD INDEX Index_sysdeptcontacts_curdeptid (cur_dept_id);
ALTER TABLE sys_dict ADD INDEX Index_sysdict_dictcode (dict_code);
ALTER TABLE sys_dict ADD INDEX Index_sysdict_parentcode (parent_code);
ALTER TABLE sys_guid_dept ADD INDEX Index_sysguiddept_curdeptid (cur_dept_id);
ALTER TABLE sys_guid_dept ADD INDEX Index_sysguiddept_guiddeptid (guid_dept_id);
ALTER TABLE sys_log ADD INDEX Index_syslog_operatorid (operator_id);
ALTER TABLE sys_region ADD INDEX Index_sysregion_regioncode (region_code);
ALTER TABLE sys_region ADD INDEX Index_sysregion_fcode (fcode);
ALTER TABLE sys_role_menu ADD INDEX Index_sysrolemenu_roleid (role_id);
ALTER TABLE sys_role_menu ADD INDEX Index_sysrolemenu_menuid (menu_id);
ALTER TABLE sys_user ADD INDEX Index_sysuser_username (user_name);
ALTER TABLE sys_user ADD INDEX Index_sysuser_realname (real_name);
ALTER TABLE sys_user_role ADD INDEX Index_sysuserrole_userid (user_id);
ALTER TABLE sys_user_role ADD INDEX Index_sysuserrole_roleid (role_id);
ALTER TABLE drap_activity_doc_item ADD INDEX Index_drapactivitydocitem_docid (doc_id);
ALTER TABLE drap_activity_doc_map ADD INDEX Index_drapactivitydocmap_activityid (activity_id);
ALTER TABLE drap_activity_doc_map ADD INDEX Index_drapactivitydocmap_docid (doc_id);
ALTER TABLE drap_activity_rel_depts ADD INDEX Index_drapactivityreldepts_activityid (activity_id);
ALTER TABLE drap_activity_rel_depts ADD INDEX Index_drapactivityreldepts_deptid (dept_id);
ALTER TABLE drap_activity_set_map ADD INDEX Index_drapactivitysetmap_datasetid (dataset_id);
ALTER TABLE drap_activity_set_map ADD INDEX Index_drapactivitysetmap_activityid (activity_id);
ALTER TABLE drap_activity_system_map ADD INDEX Index_drapactivitysystemmap_activityid (activity_id);
ALTER TABLE drap_activity_system_map ADD INDEX Index_drapactivitysystemmap_systemid (system_id);
ALTER TABLE drap_business_activity ADD INDEX Index_drapbusinessactivity_belongdept (belong_dept);
ALTER TABLE drap_business_activity ADD INDEX Index_drapbusinessactivity_activityname (activity_name (255));
ALTER TABLE drap_business_doc ADD INDEX Index_drapbusinessdoc_belongdept (belong_dept);
ALTER TABLE drap_business_doc ADD INDEX Index_drapbusinessdoc_docname (doc_name);
ALTER TABLE drap_business_requirement ADD INDEX Index_drapbusinessrequirement_requredeptid (requre_dept_id);
ALTER TABLE drap_business_requirement ADD INDEX Index_drapbusinessrequirement_sourcedeptid (source_dept_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_datasetid (dataset_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_businessitemid (business_item_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_systemcolumnid (system_column_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_infosystemid (info_system_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_dbid (db_id);
ALTER TABLE drap_data_column_map ADD INDEX Index_drapdatacolumnmap_tableid (table_id);
ALTER TABLE drap_dataset ADD INDEX Index_drapdataset_belongdepttype (belong_dept_type);
ALTER TABLE drap_dataset ADD INDEX Index_drapdataset_belongdeptid (belong_dept_id);
ALTER TABLE drap_dataset ADD INDEX Index_drapdataset_belongactivityid (belong_activity_id);
ALTER TABLE drap_dataset ADD INDEX Index_drapdataset_datasetname (dataset_name);
ALTER TABLE drap_dataset ADD INDEX Index_drapdataset_datasetcode (dataset_code);
ALTER TABLE drap_dataset_item ADD INDEX Index_drapdatasetitem_itemname (item_name);
ALTER TABLE drap_dataset_item_map ADD INDEX Index_drapdatasetitemmap_datasetid (dataset_id);
ALTER TABLE drap_dataset_item_map ADD INDEX Index_drapdatasetitemmap_itemid (item_id);
ALTER TABLE drap_dataset_system_map ADD INDEX Index_drapdatasetsystemmap_datasetid (dataset_id);
ALTER TABLE drap_dataset_system_map ADD INDEX Index_drapdatasetsystemmap_systemid (system_id);
ALTER TABLE drap_db_info ADD INDEX Index_drapdbinfo_belongdept (belong_dept);
ALTER TABLE drap_db_info ADD INDEX Index_drapdbinfo_dbname (db_name);
ALTER TABLE drap_db_info ADD INDEX Index_drapdbinfo_dbcnname (db_cn_name);
ALTER TABLE drap_db_system_map ADD INDEX Index_drapdbsystemmap_dbid (db_id);
ALTER TABLE drap_db_system_map ADD INDEX Index_drapdbsystemmap_infosystemid (info_system_id);
ALTER TABLE drap_db_table_column ADD INDEX Index_drapdbtablecolumn_tableid (table_id);
ALTER TABLE drap_db_table_column ADD INDEX Index_drapdbtablecolumn_columnenname (column_en_name);
ALTER TABLE drap_db_table_column ADD INDEX Index_drapdbtablecolumn_columncnname (column_cn_name);
ALTER TABLE drap_db_table_info ADD INDEX Index_drapdbtableinfo_dbid (db_id);
ALTER TABLE drap_db_table_info ADD INDEX Index_drapdbtableinfo_tablename (table_name);
ALTER TABLE drap_db_table_info ADD INDEX Index_drapdbtableinfo_tablecnname (table_cn_name);
ALTER TABLE drap_dict_table_column ADD INDEX Index_drapdicttablecolumn_tableid (table_id);
ALTER TABLE drap_dict_table_column ADD INDEX Index_drapdicttablecolumn_columncnname (column_cn_name);
ALTER TABLE drap_dict_table_column ADD INDEX Index_drapdicttablecolumn_columnenname (column_en_name);
ALTER TABLE drap_dict_table_info ADD INDEX Index_drapdicttableinfo_dbid (db_id);
ALTER TABLE drap_dict_table_info ADD INDEX Index_drapdicttableinfo_tablename (table_name);
ALTER TABLE drap_dict_table_info ADD INDEX Index_drapdicttableinfo_tablecnname (table_cn_name);
ALTER TABLE drap_info_system ADD INDEX Index_drapinfosystem_belongdept (belong_dept);
ALTER TABLE drap_info_system ADD INDEX Index_drapinfosystem_systemcode (system_code);
ALTER TABLE drap_info_system ADD INDEX Index_drapinfosystem_systemname (system_name);
ALTER TABLE drap_item_required_dept ADD INDEX Index_drapitemrequireddept_itemid (item_id);
ALTER TABLE drap_item_required_dept ADD INDEX Index_drapitemrequireddept_deptid (dept_id);
ALTER TABLE drap_requirement_dataset_map ADD INDEX Index_draprequirementdatasetmap_requireid (require_id);
ALTER TABLE drap_requirement_dataset_map ADD INDEX Index_draprequirementdatasetmap_datasetid (dataset_id);
ALTER TABLE drap_requirement_resources ADD INDEX Index_draprequirementresources_requireid (require_id);
ALTER TABLE drap_requirement_resources ADD INDEX Index_draprequirementresources_docid (doc_id);
ALTER TABLE drap_system_use_dept ADD INDEX Index_drapsystemusedept_systemid (system_id);
ALTER TABLE drap_system_use_dept ADD INDEX Index_drapsystemusedept_deptid (dept_id);
ALTER TABLE drap_system_use_info ADD INDEX Index_drapsystemuseinfo_infosystemid (info_system_id);