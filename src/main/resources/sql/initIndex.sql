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
call del_idx('drap_requirement_dataset_map','Index_1');


-- 在表中添加索引
ALTER TABLE drap_requirement_dataset_map ADD INDEX Index_1 (require_id);