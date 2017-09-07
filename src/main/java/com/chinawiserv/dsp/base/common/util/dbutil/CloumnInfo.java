package com.chinawiserv.dsp.base.common.util.dbutil;

/**
 * Created by Jiest on 2015/10/23.
 */
public class CloumnInfo {
    public String tableCat ;//表目录（可能为空）
    public String tableSchemaName ;//表的架构（可能为空）
    public String tableName_ ;//表名
    public String columnName ;//列名
    public int dataType ; //对应的java.sql.Types类型
    public String dataTypeName ;//java.sql.Types类型名称
    public int columnSize ;//列大小
    public int decimalDigits ;//小数位数
    public int numPrecRadix ;//基数（通常是10或2）
    public int nullAble ;//是否允许为null
    public String remarks ;//列描述
    public String columnDef ;//默认值
    public int sqlDataType;//sql数据类型
    public int sqlDatetimeSub ;   //SQL日期时间分?
    public int charOctetLength ;   //char类型的列中的最大字节数
    public int ordinalPosition ;  //表中列的索引（从1开始）
    /**
     * ISO规则用来确定某一列的为空性。
     * 是---该参数可以包括空值;
     * 无---参数不能包含空值
     * 空字符串---如果参数为空性是未知的
     */
    public String isNullAble;
    /**
     * 指示此列是否是自动递增
     * 是---该列是自动递增
     * 无---不是自动递增列
     * 空字串---不能确定它是否
     * 列是自动递增的参数是未知
     */
    public String isAutoincrement;

    public int isPk = 0;

    public CloumnInfo(){

    }
}
