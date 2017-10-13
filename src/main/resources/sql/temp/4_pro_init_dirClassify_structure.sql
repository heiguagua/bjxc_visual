DELIMITER $$ 
/*
 * 服务器的自定义函数，被存储过程调用的【查询每个ID的tree_code】
 */
DROP FUNCTION IF EXISTS getDirClassifyTreeCode$$
CREATE FUNCTION `getDirClassifyTreeCode` (id VARCHAR(38)) RETURNS VARCHAR (21845) CHARSET utf8
BEGIN
DECLARE str VARCHAR (1000);
DECLARE fid VARCHAR (38);
SET str = (SELECT rownum FROM dir_classify_treeNum a WHERE a.id = id );

SELECT t.fid INTO fid FROM `dir_classify` t WHERE t.id = id;

WHILE fid != 'root' DO
	SET str = concat((SELECT rownum FROM dir_classify_treeNum a WHERE a.id = fid ),
		';',
		str
	);
	SELECT t.fid INTO fid FROM `dir_classify` t WHERE t.id = fid;
	END
WHILE;
RETURN str;
END$$


/*
 服务器的自定义函数，被上面存储过程调用的【查询每个ID的Structure_name】
  */
DROP FUNCTION IF EXISTS getDirClassifyStructureName$$
CREATE FUNCTION `getDirClassifyStructureName` (id VARCHAR(38)) RETURNS VARCHAR (4000) CHARSET utf8
BEGIN
DECLARE str VARCHAR (4000);
DECLARE fid VARCHAR (38);
SET str = (SELECT classify_name FROM dir_classify a WHERE a.id = id );

SELECT t.fid INTO fid FROM `dir_classify` t WHERE t.id = id;

WHILE fid != 'root' DO
	SET str = concat((SELECT classify_name FROM dir_classify a WHERE a.id = fid ),
		'->',
		str
	);
	SELECT t.fid INTO fid FROM `dir_classify` t WHERE t.id = fid;
	END
WHILE;
RETURN str;
END$$


/*
获取生成目录分类编码的函数
 */
DROP FUNCTION IF EXISTS getDirClassifyCode$$
CREATE FUNCTION `getDirClassifyCode` (id VARCHAR(38)) RETURNS VARCHAR (21845) CHARSET utf8
BEGIN
DECLARE str VARCHAR (1000);
DECLARE fid VARCHAR (38);
DECLARE classify_level int(6);

set classify_level = (select t.classify_level from dir_classify t WHERE t.id = id);
SET str = lpad((SELECT rownum FROM dir_classify_treeNum a WHERE a.id = id ),classify_level,'0');
SELECT t.fid INTO fid FROM `dir_classify` t WHERE t.id = id;

set str = concat((select t.classify_code from dir_classify t WHERE t.id = fid),str);

RETURN str;
END$$

/*
处理老数据的classfyCode的存储过程
 */
drop PROCEDURE  IF EXISTS  pro_init_dir_classify_code$$
CREATE PROCEDURE `pro_init_dir_classify_code`()
begin
	DECLARE _id varchar(36);
	DECLARE _curClassifyCode varchar(100);
	DECLARE _done int;

	declare rs_cursor CURSOR FOR select t.id from dir_classify t where t.fid <> 'root';
	-- 在游标循环到最后会将 _done 设置为 1
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET _done=1;

-- 更新classifyCode的值
open rs_cursor;
		cursor_loop:loop
			FETCH rs_cursor into _id; -- 取数据
			if _done=1 then		-- 跳出循环
				leave cursor_loop;
			end if;
			 -- 更新表
			set _curClassifyCode = concat((select t.classify_code from dir_classify t WHERE t.id = (select fid from dir_classify where id = _id)),
						lpad((SELECT rownum FROM dir_classify_treeNum a WHERE a.id = _id ),(select t.classify_level from dir_classify t WHERE t.id = _id),'0'));
			update dir_classify set classify_code = _curClassifyCode where id = _id;
		end loop cursor_loop;
		close rs_cursor;
end$$


/* **************************************************
 处理老数据存储过程
  ***************************************************/
drop PROCEDURE  IF EXISTS  pro_init_dir_classify_structure$$
CREATE PROCEDURE `pro_init_dir_classify_structure`()
begin
DROP TABLE if exists dir_classify_treeNum;
CREATE TEMPORARY TABLE dir_classify_treeNum
AS SELECT 
      t.id,
      t.classify_level,
      (
        @row := 
        CASE
          WHEN t.`fid` = @pre_parent_id 
          THEN @row + 1 
          ELSE 1 
        END
      ) rownum,
      (@pre_parent_id := t.`fid`) pre_parent_id 
    FROM
      `dir_classify` t 
    ORDER BY t.`fid`,t.order_number,t.classify_code;

-- 更新信息目录的TreeCode
UPDATE  dir_classify t SET t.`tree_code` = getDirClassifyTreeCode(t.`id`);
-- 更新信息目录的structure_name
UPDATE  dir_classify t SET t.`classify_structure_name` = getDirClassifyStructureName(t.`id`);

-- 更新目录分类的tree_index
update dir_classify a INNER JOIN (
	select max(rownum) as tree_index,pre_parent_id as fid from dir_classify_treeNum group by pre_parent_id) b
	 on a.id=b.fid 
	set a.classify_index = b.tree_index;
-- 更新classifyCode的值
call pro_init_dir_classify_code();
-- UPDATE  dir_classify t SET t.`classify_code` = getDirClassifyCode(t.`id`) where t.fid <> 'root';

DROP TABLE if exists dir_classify_treeNum;
end$$

DELIMITER ;

call pro_init_dir_classify_structure();



select id,region_code,classify_code,classify_name,fid,fname,classify_level,classify_index,order_number,icon,classify_structure_name,status,tree_code
	from dir_classify order by region_code, tree_code;