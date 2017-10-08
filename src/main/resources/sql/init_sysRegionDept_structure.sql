DELIMITER $$
/*
* 服务器的自定义函数，被上面存储过程调用的【查询每个ID的Structure_name】
*/
DROP FUNCTION IF EXISTS getSysRegionDeptStructureName$$
CREATE FUNCTION `getSysRegionDeptStructureName` (code VARCHAR(38)) RETURNS VARCHAR (4000) CHARSET utf8
BEGIN
DECLARE str VARCHAR (4000);
DECLARE fcode VARCHAR (38);
SET str = (SELECT region_dept_name FROM sys_region_dept a WHERE a.region_dept_code = code );

SELECT t.fcode INTO fcode FROM `sys_region_dept` t WHERE t.region_dept_code = code;

WHILE fcode != '000000' DO
	SET str = concat((SELECT region_dept_name FROM sys_region_dept a WHERE a.region_dept_code = fcode ),
		'->',
		str
	);
	SELECT t.fcode INTO fcode FROM `sys_region_dept` t WHERE t.region_dept_code = fcode;
	END
WHILE;
RETURN str;
END$$

/*
* 服务器的自定义函数，被上面存储过程调用的【查询每个ID的Structure_name】
*/
DROP FUNCTION IF EXISTS getSysRegionDeptStructureCode$$
CREATE FUNCTION `getSysRegionDeptStructureCode` (code VARCHAR(38)) RETURNS VARCHAR (4000) CHARSET utf8
BEGIN
DECLARE str VARCHAR (4000);
DECLARE fcode VARCHAR (38);
SET str = (SELECT region_dept_code FROM sys_region_dept a WHERE a.region_dept_code = code );

SELECT t.fcode INTO fcode FROM `sys_region_dept` t WHERE t.region_dept_code = code;

WHILE fcode != '000000' DO
	SET str = concat((SELECT region_dept_code FROM sys_region_dept a WHERE a.region_dept_code = fcode ),
		';',
		str
	);
	SELECT t.fcode INTO fcode FROM `sys_region_dept` t WHERE t.region_dept_code = fcode;
	END
WHILE;
RETURN str;
END$$

/*
* 查询每个ID对应的级别
*/
DROP FUNCTION IF EXISTS getSysRegionDeptLevel$$
CREATE FUNCTION `getSysRegionDeptLevel` (code VARCHAR(38)) RETURNS VARCHAR (4000) CHARSET utf8
BEGIN
DECLARE fcode VARCHAR (38);
declare deptLevel int default 1;

SELECT t.fcode INTO fcode FROM `sys_region_dept` t WHERE t.region_dept_code = code;

WHILE fcode != '000000' DO
	SET deptLevel = deptLevel + 1;
	SELECT t.fcode INTO fcode FROM `sys_region_dept` t WHERE t.region_dept_code = fcode;
	END
WHILE;
RETURN deptLevel;
END$$



/*
*  处理老数据存储过程
*/
drop PROCEDURE  IF EXISTS  pro_init_sys_region_dept_structure$$
CREATE PROCEDURE `pro_init_sys_region_dept_structure`()
begin
-- 更新信息目录的dept_level
UPDATE  sys_region_dept t SET t.`region_dept_level` = getSysRegionDeptLevel(t.`region_dept_code`);
-- 更新信息目录的TreeCode
UPDATE  sys_region_dept t SET t.`structure_code` = getSysRegionDeptStructureCode(t.`region_dept_code`);
-- 更新信息目录的structure_name
UPDATE  sys_region_dept t SET t.`structure_name` = getSysRegionDeptStructureName(t.`region_dept_code`);
end$$
DELIMITER ;

call pro_init_sys_region_dept_structure();