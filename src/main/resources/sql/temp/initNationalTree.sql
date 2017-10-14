
DELIMITER $$
/*
* 获取国家目录分类级别
*/
DROP FUNCTION IF EXISTS getNationalClassifyLevel$$
CREATE FUNCTION `getNationalClassifyLevel` (cur_code VARCHAR(38)) RETURNS VARCHAR (4000) CHARSET utf8
BEGIN
DECLARE fcode VARCHAR (38);
declare deptLevel int default 1;

SELECT t.fcode INTO fcode FROM `dir_national_classify` t WHERE t.classify_code = cur_code;

WHILE fcode != 'root' DO
	SET deptLevel = deptLevel + 1;
	SELECT t.fcode INTO fcode FROM `dir_national_classify` t WHERE t.classify_code = fcode;
	END
WHILE;
RETURN deptLevel;
END$$


/*
 * 获取国家目录分类结构名称
*/
DROP FUNCTION IF EXISTS getNationalClassifyTreeCode$$
CREATE FUNCTION `getNationalClassifyTreeCode` (cur_code VARCHAR(38)) RETURNS VARCHAR (4000) CHARSET utf8
BEGIN
DECLARE str VARCHAR (4000);
DECLARE fcode VARCHAR (38);
SET str = (SELECT classify_code FROM dir_national_classify a WHERE a.classify_code = cur_code);

SELECT t.fcode INTO fcode FROM `dir_national_classify` t WHERE t.classify_code = cur_code;

WHILE fcode != 'root' DO
	SET str = concat((SELECT classify_code FROM dir_national_classify a WHERE a.classify_code = fcode),
		';',
		str
	);
	SELECT t.fcode INTO fcode FROM `dir_national_classify` t WHERE t.classify_code = fcode;
	END
WHILE;
RETURN str;
END$$

/*
 * 获取国家目录分类结构名称
*/
DROP FUNCTION IF EXISTS getNationalClassifyTreeName$$
CREATE FUNCTION `getNationalClassifyTreeName` (cur_code VARCHAR(38)) RETURNS VARCHAR (4000) CHARSET utf8
BEGIN
DECLARE str VARCHAR (4000);
DECLARE fcode VARCHAR (38);
SET str = (SELECT classify_name FROM dir_national_classify a WHERE a.classify_code = cur_code);

SELECT t.fcode INTO fcode FROM `dir_national_classify` t WHERE t.classify_code = cur_code;

WHILE fcode != 'root' DO
	SET str = concat((SELECT classify_name FROM dir_national_classify a WHERE a.classify_code = fcode),
		'->',
		str
	);
	SELECT t.fcode INTO fcode FROM `dir_national_classify` t WHERE t.classify_code = fcode;
	END
WHILE;
RETURN str;
END$$
DELIMITER ;

UPDATE  dir_national_classify t SET t.`classify_level` = getSysDeptLevel(t.`classify_code`);
UPDATE  dir_national_classify t SET t.`classify_structure_name` = getNationalClassifyTreeName(t.`classify_code`);
UPDATE  dir_national_classify t SET t.`classify_structure_code` = getNationalClassifyTreeCode(t.`classify_code`);

select * from dir_national_classify order by classify_code;