package com.chinawiserv.dsp.base.common.util.dbutil;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Jiest on 2015/10/23.
 */
public interface DBHandler {

    public enum DB_TYPE{
        MYSQL("0"), SQLSERVER("1"), ORACLE("2"), ACCESS("4");
        private String code;
        DB_TYPE(String code){
            this.code = code;
        }
        public static DB_TYPE getEnumByCode(String code){
            if(MYSQL.code.equals(code)) return MYSQL;
            if(SQLSERVER.code.equals(code)) return SQLSERVER;
            if(ORACLE.code.equals(code)) return ORACLE;
            if(ACCESS.code.equals(code)) return ACCESS;
            return null;
        }
    }

    public Connection getDbConnection();
    public List<TableInfo> getListTables(String tableNamePattern, String columnNamePattern, boolean isInCludeColomnInfo, String[] types) throws Exception;
    public List<CloumnInfo> getColumnInfoList(String tableNamePattern, String columnNamePattern) throws Exception;

    public List<CloumnInfo> getColumnInfoList(String tableNamePattern, String columnNamePattern, boolean isPkOnly) throws Exception;

    List<CloumnInfo> getColumnInfoList(String customSql) throws Exception;

    /**
     * 判断指定表是否存在
     * @param tableNamePattern
     * @return true：存在；false ：不存在
     * @throws Exception
     */
    public boolean isExistsTable(String tableNamePattern) throws Exception;
    /**
     * 获取指定表的主键列名
     * @param tableNamePattern
     * @return
     * @throws Exception
     */
    public List<String> getPkNameList(String tableNamePattern) throws Exception;

    public void close() throws Exception;
}
