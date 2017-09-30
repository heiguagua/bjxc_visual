DELIMITER $$ 
-- 服务器的自定义函数，被存储过程调用的【查询每个ID的tree_code】
DROP FUNCTION IF EXISTS getSysDeptTreeCode$$
CREATE FUNCTION `getSysDeptTreeCode` (_region_code varchar(12),id VARCHAR(38)) RETURNS VARCHAR (21845) CHARSET utf8
BEGIN
DECLARE str VARCHAR (1000);
DECLARE fid VARCHAR (38);
SET str = (SELECT rownum FROM sys_dept_treeNum a WHERE a.id = id and a.region_code = _region_code);

SELECT t.fid INTO fid FROM `sys_dept` t WHERE t.id = id  and t.region_code = _region_code;

WHILE fid != 'root' DO
	SET str = concat((SELECT rownum FROM sys_dept_treeNum a WHERE a.id = fid and a.region_code = _region_code),
		';',
		str
	);
	SELECT t.fid INTO fid FROM `sys_dept` t WHERE t.id = fid and t.region_code = _region_code;
	END
WHILE;
RETURN str;
END$$


-- 服务器的自定义函数，被上面存储过程调用的【查询每个ID的Structure_name】
DROP FUNCTION IF EXISTS getSysDeptStructureName$$
CREATE FUNCTION `getSysDeptStructureName` (_region_code varchar(12),id VARCHAR(38)) RETURNS VARCHAR (4000) CHARSET utf8
BEGIN
DECLARE str VARCHAR (4000);
DECLARE fid VARCHAR (38);
SET str = (SELECT dept_name FROM sys_dept a WHERE a.id = id and a.region_code = _region_code);

SELECT t.fid INTO fid FROM `sys_dept` t WHERE t.id = id and t.region_code = _region_code;

WHILE fid != 'root' DO
	SET str = concat((SELECT dept_name FROM sys_dept a WHERE a.id = fid and a.region_code = _region_code),
		'->',
		str
	);
	SELECT t.fid INTO fid FROM `sys_dept` t WHERE t.id = fid;
	END
WHILE;
RETURN str;
END$$

-- 服务器的自定义函数，被上面存储过程调用的【用来查询部门级别】
DROP FUNCTION IF EXISTS getSysDeptLevel$$
CREATE FUNCTION `getSysDeptLevel` (id VARCHAR(38)) RETURNS VARCHAR (4000) CHARSET utf8
BEGIN
DECLARE fid VARCHAR (38);
declare deptLevel int default 1;

SELECT t.fid INTO fid FROM `sys_dept` t WHERE t.id = id;

WHILE fid != 'root' DO
	SET deptLevel = deptLevel + 1;
	SELECT t.fid INTO fid FROM `sys_dept` t WHERE t.id = fid;
	END
WHILE;
RETURN deptLevel;
END$$

-- 处理老数据存储过程
drop PROCEDURE  IF EXISTS  pro_init_sys_dept_structure$$
CREATE PROCEDURE `pro_init_sys_dept_structure`(in _region_code varchar(12))
begin
-- 更新信息目录的dept_level
UPDATE  sys_dept t SET t.`dept_level` = getSysDeptLevel(t.`id`);

-- 创建临时表，用于生成部门Tree_index序号
DROP TABLE if exists sys_dept_treeNum;
CREATE TEMPORARY TABLE sys_dept_treeNum
AS SELECT 
      t.id,
      t.dept_level,
	  t.region_code,
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
      `sys_dept` t 
	  where t.region_code = _region_code
    ORDER BY t.`fid`;
-- 更新信息目录的TreeCode
UPDATE  sys_dept t SET t.`tree_code` = getSysDeptTreeCode(_region_code,t.`id`);
-- 更新目录分类的tree_index
update sys_dept a INNER JOIN (
	select max(rownum) as tree_index,pre_parent_id as fid from sys_dept_treeNum group by pre_parent_id) b
	 on a.id=b.fid 
	set a.tree_index = b.tree_index;
	
-- 更新信息目录的structure_name
UPDATE  sys_dept t SET t.`dept_structure_name` = getSysDeptStructureName(_region_code,t.`id`);
DROP TABLE if exists sys_dept_treeNum;
end$$
DELIMITER ;

call pro_init_sys_dept_structure('510100');