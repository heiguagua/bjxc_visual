DELIMITER $$ 
-- 服务器的自定义函数，被存储过程调用的【查询每个ID的tree_code】
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


-- 服务器的自定义函数，被上面存储过程调用的【查询每个ID的Structure_name】
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

-- 处理老数据存储过程
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
    ORDER BY t.`fid`;
-- 更新信息目录的TreeCode
UPDATE  dir_classify t SET t.`tree_code` = getDirClassifyTreeCode(t.`id`);
-- 更新信息目录的structure_name
UPDATE  dir_classify t SET t.`classify_structure_name` = getDirClassifyStructureName(t.`id`);

-- 更新目录分类的tree_index
update dir_classify a INNER JOIN (
	select max(rownum) as tree_index,pre_parent_id as fid from dir_classify_treeNum group by pre_parent_id) b
	 on a.id=b.fid 
	set a.classify_index = b.tree_index;
	

DROP TABLE if exists dir_classify_treeNum;
end$$
DELIMITER ;

call pro_init_dir_classify_structure();