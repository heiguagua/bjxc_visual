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