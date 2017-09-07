package com.chinawiserv.dsp.base.common.util.dbutil;

import org.apache.commons.lang3.StringUtils;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/20.
 */
public class JavaToMysqlType {
    
    static final int COM_BINLOG_DUMP = 18;

    static final int COM_CHANGE_USER = 17;

    static final int COM_CLOSE_STATEMENT = 25;

    static final int COM_CONNECT_OUT = 20;

    static final int COM_END = 29;

    static final int COM_EXECUTE = 23;

    static final int COM_FETCH = 28;

    static final int COM_LONG_DATA = 24;

    static final int COM_PREPARE = 22;

    static final int COM_REGISTER_SLAVE = 21;

    static final int COM_RESET_STMT = 26;

    static final int COM_SET_OPTION = 27;

    static final int COM_TABLE_DUMP = 19;

    static final int CONNECT = 11;

    static final int CREATE_DB = 5; // Not used; deprecated?

    static final int DEBUG = 13;

    static final int DELAYED_INSERT = 16;

    static final int DROP_DB = 6; // Not used; deprecated?

    static final int FIELD_LIST = 4; // Not used; deprecated in MySQL 5.7.11 and MySQL 8.0.0.

    static final int FIELD_TYPE_BIT = 16;

    public static final int FIELD_TYPE_BLOB = 252;

    static final int FIELD_TYPE_DATE = 10;

    static final int FIELD_TYPE_DATETIME = 12;

    // Data Types
    static final int FIELD_TYPE_DECIMAL = 0;

    static final int FIELD_TYPE_DOUBLE = 5;

    static final int FIELD_TYPE_ENUM = 247;

    static final int FIELD_TYPE_FLOAT = 4;

    static final int FIELD_TYPE_GEOMETRY = 255;

    static final int FIELD_TYPE_INT24 = 9;

    static final int FIELD_TYPE_LONG = 3;

    static final int FIELD_TYPE_LONG_BLOB = 251;

    static final int FIELD_TYPE_LONGLONG = 8;

    static final int FIELD_TYPE_MEDIUM_BLOB = 250;

    static final int FIELD_TYPE_NEW_DECIMAL = 246;

    static final int FIELD_TYPE_NEWDATE = 14;

    static final int FIELD_TYPE_NULL = 6;

    static final int FIELD_TYPE_SET = 248;

    static final int FIELD_TYPE_SHORT = 2;

    static final int FIELD_TYPE_STRING = 254;

    static final int FIELD_TYPE_TIME = 11;

    static final int FIELD_TYPE_TIMESTAMP = 7;

    static final int FIELD_TYPE_TINY = 1;

    // Older data types
    static final int FIELD_TYPE_TINY_BLOB = 249;

    static final int FIELD_TYPE_VAR_STRING = 253;

    static final int FIELD_TYPE_VARCHAR = 15;

    // Newer data types
    static final int FIELD_TYPE_YEAR = 13;

    static final int FIELD_TYPE_JSON = 245;

    static final int INIT_DB = 2;

    static final long LENGTH_BLOB = 65535;

    static final long LENGTH_LONGBLOB = 4294967295L;

    static final long LENGTH_MEDIUMBLOB = 16777215;

    static final long LENGTH_TINYBLOB = 255;

    // Limitations
    static final int MAX_ROWS = 50000000; // From the MySQL FAQ

    public static Map<Integer, String> jdbcToMysqlTypesMap = new HashMap<Integer, String>();

    /**
     * Maps the given MySQL type to the correct JDBC type.
     */
    static int mysqlToJavaType(int mysqlType) {
        int jdbcType;

        switch (mysqlType) {
            case JavaToMysqlType.FIELD_TYPE_NEW_DECIMAL:
            case JavaToMysqlType.FIELD_TYPE_DECIMAL:
                jdbcType = Types.DECIMAL;

                break;

            case JavaToMysqlType.FIELD_TYPE_TINY:
                jdbcType = Types.TINYINT;

                break;

            case JavaToMysqlType.FIELD_TYPE_SHORT:
                jdbcType = Types.SMALLINT;

                break;

            case JavaToMysqlType.FIELD_TYPE_LONG:
                jdbcType = Types.INTEGER;

                break;

            case JavaToMysqlType.FIELD_TYPE_FLOAT:
                jdbcType = Types.REAL;

                break;

            case JavaToMysqlType.FIELD_TYPE_DOUBLE:
                jdbcType = Types.DOUBLE;

                break;

            case JavaToMysqlType.FIELD_TYPE_NULL:
                jdbcType = Types.NULL;

                break;

            case JavaToMysqlType.FIELD_TYPE_TIMESTAMP:
                jdbcType = Types.TIMESTAMP;

                break;

            case JavaToMysqlType.FIELD_TYPE_LONGLONG:
                jdbcType = Types.BIGINT;

                break;

            case JavaToMysqlType.FIELD_TYPE_INT24:
                jdbcType = Types.INTEGER;

                break;

            case JavaToMysqlType.FIELD_TYPE_DATE:
                jdbcType = Types.DATE;

                break;

            case JavaToMysqlType.FIELD_TYPE_TIME:
                jdbcType = Types.TIME;

                break;

            case JavaToMysqlType.FIELD_TYPE_DATETIME:
                jdbcType = Types.TIMESTAMP;

                break;

            case JavaToMysqlType.FIELD_TYPE_YEAR:
                jdbcType = Types.DATE;

                break;

            case JavaToMysqlType.FIELD_TYPE_NEWDATE:
                jdbcType = Types.DATE;

                break;

            case JavaToMysqlType.FIELD_TYPE_ENUM:
                jdbcType = Types.CHAR;

                break;

            case JavaToMysqlType.FIELD_TYPE_SET:
                jdbcType = Types.CHAR;

                break;

            case JavaToMysqlType.FIELD_TYPE_TINY_BLOB:
                jdbcType = Types.VARBINARY;

                break;

            case JavaToMysqlType.FIELD_TYPE_MEDIUM_BLOB:
                jdbcType = Types.LONGVARBINARY;

                break;

            case JavaToMysqlType.FIELD_TYPE_LONG_BLOB:
                jdbcType = Types.LONGVARBINARY;

                break;

            case JavaToMysqlType.FIELD_TYPE_BLOB:
                jdbcType = Types.LONGVARBINARY;

                break;

            case JavaToMysqlType.FIELD_TYPE_VAR_STRING:
            case JavaToMysqlType.FIELD_TYPE_VARCHAR:
                jdbcType = Types.VARCHAR;

                break;

            case JavaToMysqlType.FIELD_TYPE_JSON:
            case JavaToMysqlType.FIELD_TYPE_STRING:
                jdbcType = Types.CHAR;

                break;
            case JavaToMysqlType.FIELD_TYPE_GEOMETRY:
                jdbcType = Types.BINARY;

                break;
            case JavaToMysqlType.FIELD_TYPE_BIT:
                jdbcType = Types.BIT;

                break;
            default:
                jdbcType = Types.VARCHAR;
        }

        return jdbcType;
    }

    public static  Map<String, String> parseMysqlTypesByJDBC(int jdbcType, String length) {
        Map<String, String> result = new HashMap<>();
        switch (jdbcType){
            case Types.BIT:
//                jdbcToMysqlTypesMap.put(Types.BIT, "BIT");需要设置长度  默认为长度1
                result.put("length", length);
                result.put("type", "BIT");
                break;
            case Types.TINYINT:
//                jdbcToMysqlTypesMap.put(Types.TINYINT, "TINYINT");可以不设置长度  默认为长度4
                result.put("length", length);
                result.put("type", "TINYINT");
                break;
            case Types.SMALLINT:
//                jdbcToMysqlTypesMap.put(Types.SMALLINT, "SMALLINT");可以不设置长度  默认为长度6
                result.put("length", length);
                result.put("type", "SMALLINT");
                break;
            case Types.INTEGER:
//                jdbcToMysqlTypesMap.put(Types.INTEGER, "MEDIUMINT");
//                jdbcToMysqlTypesMap.put(Types.INTEGER, "INT");
//                jdbcToMysqlTypesMap.put(Types.INTEGER, "INTEGER");
//                jdbcToMysqlTypesMap.put(Types.INTEGER, "INT24");
                result.put("length", length);
                result.put("type", "INT");//统一用int处理
                break;
            case Types.BIGINT:
//                jdbcToMysqlTypesMap.put(Types.BIGINT, "BIGINT");可以不设置长度  默认为长度20
                result.put("length", length);
                result.put("type", "BIGINT");
                break;
            case Types.DOUBLE:
//                jdbcToMysqlTypesMap.put(Types.DOUBLE, "REAL");
//                jdbcToMysqlTypesMap.put(Types.DOUBLE, "DOUBLE");可以不设置长度  格式为(3,1)
                result.put("length", "");//todo 目前不设置长度
                result.put("type", "DOUBLE");
                break;
            case Types.REAL:
//                jdbcToMysqlTypesMap.put(Types.REAL, "FLOAT");可以不设置长度  格式为(3,1)、（3）
                result.put("length", length);
                result.put("type", "FLOAT");
                break;
            case Types.DECIMAL:
//                jdbcToMysqlTypesMap.put(Types.DECIMAL, "DECIMAL");
//                jdbcToMysqlTypesMap.put(Types.DECIMAL, "NUMERIC");可以不设置长度  格式为(3,1)、（3）
                result.put("length", length);
                result.put("type", "DECIMAL");
                break;
            case Types.CHAR:
//                jdbcToMysqlTypesMap.put(Types.CHAR, "CHAR");
//                jdbcToMysqlTypesMap.put(Types.CHAR, "ENUM");
//                jdbcToMysqlTypesMap.put(Types.CHAR, "SET");
//                jdbcToMysqlTypesMap.put(Types.CHAR, "JSON");
                result.put("length", length);//最大长度255
                result.put("type", "CHAR");
                break;
            case Types.VARCHAR:
//                jdbcToMysqlTypesMap.put(Types.VARCHAR, "VARCHAR");
//                jdbcToMysqlTypesMap.put(Types.VARCHAR, "TINYTEXT");//最大长度是 255 (2^8 – 1) 个字符
                if(StringUtils.isNotBlank(length)){//todo 21500可以21845貌似不可以
                    long length_long = Long.parseLong(length);
                    if(length_long <= 21845L){
                        result.put("length", length);
                        result.put("type", "VARCHAR");
                    }else if(length_long > 21845L && length_long <= 4294967295L){
                        result.put("length", length);
                        result.put("type", "TEXT");
                    }
                }else {
                    result.put("length", "255");//如果没有读出长度默认设置255的长度
                    result.put("type", "VARCHAR");
                }
                break;
            case Types.DATE:
//                jdbcToMysqlTypesMap.put(Types.DATE, "DATE");
//                jdbcToMysqlTypesMap.put(Types.DATE, "YEAR");
                result.put("length", "");
                result.put("type", "DATE");
                break;
            case Types.TIME:
//                jdbcToMysqlTypesMap.put(Types.TIME, "TIME");
                if(StringUtils.isNotBlank(length)){
                    int lengthInt = Integer.parseInt(length);
                    if(lengthInt > 6 || lengthInt < 0){//不在范围设置空
                        length = "";
                    }
                }
                result.put("length", length);
                result.put("type", "TIME");
                break;
            case Types.TIMESTAMP:
//                jdbcToMysqlTypesMap.put(Types.TIMESTAMP, "TIMESTAMP");
//                jdbcToMysqlTypesMap.put(Types.TIMESTAMP, "DATETIME");datetime 支持的范围为'1000-01-01 00:00:00'到'9999-12-31 23:59:59'TIMESTAMP值不能早于1970或晚于2037
                result.put("length", "");
                result.put("type", "DATETIME");
                break;
            case Types.BINARY:
//                jdbcToMysqlTypesMap.put(Types.BINARY, "TINYBLOB");
//                jdbcToMysqlTypesMap.put(Types.BINARY, "GEOMETRY");
                result.put("length", "");
                result.put("type", "TINYBLOB");
                break;
            case Types.LONGVARBINARY:
//                jdbcToMysqlTypesMap.put(Types.LONGVARBINARY, "BLOB");max = 4294967295
//                jdbcToMysqlTypesMap.put(Types.LONGVARBINARY, "MEDIUMBLOB");16M
//                jdbcToMysqlTypesMap.put(Types.LONGVARBINARY, "LONGBLOB");最大 4G
                if(StringUtils.isNotBlank(length)){
                    long length_long = Long.parseLong(length);
                    if(length_long <= 4294967295L){
                        result.put("length", length);
                        result.put("type", "BLOB");
                    }else if(length_long > 4294967295L && length_long <= 429496729500000L){
                        result.put("length", length);
                        result.put("type", "MEDIUMBLOB");
                    }else if(length_long > 429496729500000L){
                        result.put("length", length);
                        result.put("type", "LONGBLOB");
                    }
                }else{
                    result.put("length", "");
                    result.put("type", "BLOB");
                }
                break;
            case Types.LONGVARCHAR:
//                jdbcToMysqlTypesMap.put(Types.LONGVARCHAR, "TEXT");
//                jdbcToMysqlTypesMap.put(Types.LONGVARCHAR, "MEDIUMTEXT");
//                jdbcToMysqlTypesMap.put(Types.LONGVARCHAR, "LONGTEXT");
                if(StringUtils.isNotBlank(length)){
                    long length_long = Long.parseLong(length);
                    if(length_long <= 4294967295L){
                        result.put("length", "");
                        result.put("type", "MEDIUMTEXT");
                    }else if(length_long > 4294967295L && length_long <= 429496729500000L){
                        result.put("length", "");
                        result.put("type", "LONGTEXT");
                    }else if(length_long > 429496729500000L){
                        result.put("length", "");
                        result.put("type", "LONGBLOB");
                    }
                }else{
                    result.put("length", "");
                    result.put("type", "TEXT");
                }
                break;
            /**处理sqlserver特殊的数据类型**/
            case Types.NVARCHAR:
                if(StringUtils.isNotBlank(length)){
                    long length_long = Long.parseLong(length);
                    if(length_long <= 21845L){
                        result.put("length", length);
                        result.put("type", "VARCHAR");
                    }else if(length_long > 21845L && length_long <= 4294967295L){
                        result.put("length", length);
                        result.put("type", "TEXT");
                    }
                }else{//todo
                    result.put("length", length);
                    result.put("type", "VARCHAR");
                }
                break;
            case Types.NCHAR:
                if(StringUtils.isNotBlank(length)){
                    long length_long = Long.parseLong(length);
                    if(length_long <= 255L){
                        result.put("length", length);
                        result.put("type", "CHAR");
                    }else if(length_long > 255L && length_long <= 21845L){
                        result.put("length", length);
                        result.put("type", "VARCHAR");
                    }else if(length_long > 21845L && length_long <= 4294967295L){
                        result.put("length", length);
                        result.put("type", "TEXT");
                    }
                }else{//todo
                    result.put("length", length);
                    result.put("type", "CHAR");
                }
                break;
            case Types.VARBINARY:// todo  varbinary( n | max)：可变长度，n 的取值范围为 1 至 8,000，max 是指最大存储空间是 2^31-1 个字节，即最大4GB；
                if(StringUtils.isNotBlank(length)){
                    long length_long = Long.parseLong(length);
                    if(length_long <= 255L){
                        result.put("length", length);
                        result.put("type", "CHAR");
                    }else if(length_long > 255L && length_long <= 21845L){
                        result.put("length", length);
                        result.put("type", "VARCHAR");
                    }else if(length_long > 21845L && length_long <= 4294967295L){
                        result.put("length", length);
                        result.put("type", "TEXT");
                    }
                }else{//todo
                    result.put("length", length);
                    result.put("type", "VARCHAR");
                }
                break;
            case Types.LONGNVARCHAR:// todo
                if(StringUtils.isNotBlank(length)){
                    long length_long = Long.parseLong(length);
                    if(length_long <= 4294967295L){
                        result.put("length", "");
                        result.put("type", "MEDIUMTEXT");
                    }else if(length_long > 4294967295L && length_long <= 429496729500000L){
                        result.put("length", "");
                        result.put("type", "LONGTEXT");
                    }else if(length_long > 429496729500000L){
                        result.put("length", "");
                        result.put("type", "LONGBLOB");
                    }
                }else{
                    result.put("length", "");
                    result.put("type", "TEXT");
                }
                break;
            case Types.NUMERIC:// todo
                result.put("length", length);
                result.put("type", "NUMERIC");
                break;
//            case Types.NCLOB:// todo
//                break;
            default:
                result.put("length", length);
                result.put("type", jdbcType + "");
                break;
        }
        return result;
    }

    public static  Map<String, String> parseMysqlTypesByMysql(String sourceColumnType, String length) {
        Map<String, String> result = new HashMap<>();
        switch (sourceColumnType.toUpperCase()){
//            case Types.BIT:
////                jdbcToMysqlTypesMap.put(Types.BIT, "BIT");需要设置长度  默认为长度1
//                result.put("length", length);
//                result.put("type", "BIT");
//                break;
//            case Types.TINYINT:
////                jdbcToMysqlTypesMap.put(Types.TINYINT, "TINYINT");可以不设置长度  默认为长度4
//                result.put("length", length);
//                result.put("type", "TINYINT");
//                break;
//            case Types.SMALLINT:
////                jdbcToMysqlTypesMap.put(Types.SMALLINT, "SMALLINT");可以不设置长度  默认为长度6
//                result.put("length", length);
//                result.put("type", "SMALLINT");
//                break;
//            case Types.INTEGER:
////                jdbcToMysqlTypesMap.put(Types.INTEGER, "MEDIUMINT");
////                jdbcToMysqlTypesMap.put(Types.INTEGER, "INT");
////                jdbcToMysqlTypesMap.put(Types.INTEGER, "INTEGER");
////                jdbcToMysqlTypesMap.put(Types.INTEGER, "INT24");
//                result.put("length", length);
//                result.put("type", "INT");//统一用int处理
//                break;
//            case Types.BIGINT:
////                jdbcToMysqlTypesMap.put(Types.BIGINT, "BIGINT");可以不设置长度  默认为长度20
//                result.put("length", length);
//                result.put("type", "BIGINT");
//                break;
//            case Types.DOUBLE:
////                jdbcToMysqlTypesMap.put(Types.DOUBLE, "REAL");
////                jdbcToMysqlTypesMap.put(Types.DOUBLE, "DOUBLE");可以不设置长度  格式为(3,1)
//                result.put("length", length);
//                result.put("type", "DOUBLE");
//                break;
//            case Types.REAL:
////                jdbcToMysqlTypesMap.put(Types.REAL, "FLOAT");可以不设置长度  格式为(3,1)、（3）
//                result.put("length", length);
//                result.put("type", "FLOAT");
//                break;
//            case Types.DECIMAL:
////                jdbcToMysqlTypesMap.put(Types.DECIMAL, "DECIMAL");
////                jdbcToMysqlTypesMap.put(Types.DECIMAL, "NUMERIC");可以不设置长度  格式为(3,1)、（3）
//                result.put("length", length);
//                result.put("type", "DECIMAL");
//                break;
//            case Types.CHAR:
////                jdbcToMysqlTypesMap.put(Types.CHAR, "CHAR");
////                jdbcToMysqlTypesMap.put(Types.CHAR, "ENUM");
////                jdbcToMysqlTypesMap.put(Types.CHAR, "SET");
////                jdbcToMysqlTypesMap.put(Types.CHAR, "JSON");
//                result.put("length", length);//最大长度255
//                result.put("type", "CHAR");
//                break;
//            case "VARCHAR":
////                jdbcToMysqlTypesMap.put(Types.VARCHAR, "VARCHAR");
////                jdbcToMysqlTypesMap.put(Types.VARCHAR, "TINYTEXT");//最大长度是 255 (2^8 – 1) 个字符
//                if(StringUtils.isNotBlank(length)){
//                    result.put("length", length);
//                }else {
//                    result.put("length", "255");//如果没有读出长度默认设置255的长度
//                }
//                result.put("type", "VARCHAR");
//                break;
            case "DATE":
//                jdbcToMysqlTypesMap.put(Types.DATE, "DATE");
//                jdbcToMysqlTypesMap.put(Types.DATE, "YEAR");
                result.put("length", "");
                result.put("type", "DATE");
                break;
            case "TIME":
//                jdbcToMysqlTypesMap.put(Types.TIME, "TIME");
                if(StringUtils.isNotBlank(length)){
                    int lengthInt = Integer.parseInt(length);
                    if(lengthInt > 6 || lengthInt < 0){//不在范围设置空
                        length = "";
                    }
                }
                result.put("length", length);
                result.put("type", "TIME");
                break;
            case "DATETIME":
//                jdbcToMysqlTypesMap.put(Types.TIMESTAMP, "TIMESTAMP");
//                jdbcToMysqlTypesMap.put(Types.TIMESTAMP, "DATETIME");datetime 支持的范围为'1000-01-01 00:00:00'到'9999-12-31 23:59:59'TIMESTAMP值不能早于1970或晚于2037
                result.put("length", "");
                result.put("type", "DATETIME");
                break;
            case "TINYBLOB":
//                jdbcToMysqlTypesMap.put(Types.BINARY, "TINYBLOB");
//                jdbcToMysqlTypesMap.put(Types.BINARY, "GEOMETRY");
                result.put("length", "");
                result.put("type", "TINYBLOB");
                break;
            case "TEXT":
                result.put("length", "");
                result.put("type", "TEXT");
                break;
            case "MEDIUMTEXT":
                result.put("length", "");
                result.put("type", "MEDIUMTEXT");
                break;
            case "LONGTEXT":
                result.put("length", "");
                result.put("type", "LONGTEXT");
                break;
            case "LONGBLOB":
                result.put("length", "");
                result.put("type", "LONGBLOB");
                break;
//            case Types.LONGVARBINARY:
////                jdbcToMysqlTypesMap.put(Types.LONGVARBINARY, "BLOB");max = 4294967295
////                jdbcToMysqlTypesMap.put(Types.LONGVARBINARY, "MEDIUMBLOB");16M
////                jdbcToMysqlTypesMap.put(Types.LONGVARBINARY, "LONGBLOB");最大 4G
//                if(StringUtils.isNotBlank(length)){
//                    long length_long = Long.parseLong(length);
//                    if(length_long <= 4294967295L){
//                        result.put("length", length);
//                        result.put("type", "BLOB");
//                    }else if(length_long > 4294967295L && length_long <= 429496729500000L){
//                        result.put("length", length);
//                        result.put("type", "MEDIUMBLOB");
//                    }else if(length_long > 429496729500000L){
//                        result.put("length", length);
//                        result.put("type", "LONGBLOB");
//                    }
//                }else{
//                    result.put("length", "");
//                    result.put("type", "BLOB");
//                }
//                break;
//            case Types.LONGVARCHAR:
////                jdbcToMysqlTypesMap.put(Types.LONGVARCHAR, "TEXT");
////                jdbcToMysqlTypesMap.put(Types.LONGVARCHAR, "MEDIUMTEXT");
////                jdbcToMysqlTypesMap.put(Types.LONGVARCHAR, "LONGTEXT");
//                if(StringUtils.isNotBlank(length)){
//                    long length_long = Long.parseLong(length);
//                    if(length_long <= 4294967295L){
//                        result.put("length", length);
//                        result.put("type", "MEDIUMTEXT");
//                    }else if(length_long > 4294967295L && length_long <= 429496729500000L){
//                        result.put("length", "");
//                        result.put("type", "LONGTEXT");
//                    }else if(length_long > 429496729500000L){
//                        result.put("length", "");
//                        result.put("type", "LONGBLOB");
//                    }
//                }else{
//                    result.put("length", "");
//                    result.put("type", "TEXT");
//                }
//                break;
            default:
                result.put("length", length);
                result.put("type", sourceColumnType);
                break;
        }
        return result;
    }
}
