var urlPrefix = "";
var specialReg = new RegExp("['\"]+");  //特殊字符的正则表达式
var reg_numberRange = /^[0-9\,\-]+$/g;
var reg_englishRange = /^[a-zA-Z\,\-]+$/g;
/**
 * 操作分隔符，常量
 * @type {string}
 */
var OPERATION_SEPARATOR = ' ';

/**
 * jdbc类型 todo 临时放在这里
 * @type {*[]}
 */
var JDBC_TYPE_SOURCE = [
    {value: '-7', text: 'BIT'},
    {value: '-6', text: 'TINYINT'},
    {value: '5', text: 'SMALLINT'},
    {value: '4', text: 'INTEGER'},
    {value: '-5', text: 'BIGINT'},
    {value: '6', text: 'FLOAT'},
    {value: '7', text: 'REAL'},
    {value: '8', text: 'DOUBLE'},
    {value: '2', text: 'NUMERIC'},
    {value: '3', text: 'DECIMAL'},
    {value: '1', text: 'CHAR'},
    {value: '12', text: 'VARCHAR'},
    {value: '-1', text: 'LONGVARCHAR'},
    {value: '91', text: 'DATE'},
    {value: '92', text: 'TIME'},
    {value: '93', text: 'TIMESTAMP'},
    {value: '-2', text: 'BINARY'},
    {value: '-3', text: 'VARBINARY'},
    {value: '-4', text: 'LONGVARBINARY'},
    {value: '0', text: 'NULL'},
    {value: '1111', text: 'OTHER'},
    {value: '2000', text: 'JAVA_OBJECT'},
    {value: '2001', text: 'DISTINCT'},
    {value: '2002', text: 'STRUCT'},
    {value: '2003', text: 'ARRAY'},
    {value: '2004', text: 'BLOB'},
    {value: '2005', text: 'CLOB'},
    {value: '2006', text: 'REF'},
    {value: '70', text: 'DATALINK'},
    {value: '16', text: 'BOOLEAN'},
    //------------------------- JDBC 4.0 -----------------------------------
    {value: '-8', text: 'ROWID'},
    {value: '-15', text: 'NCHAR'},
    {value: '-9', text: 'NVARCHAR'},
    {value: '-16', text: 'LONGNVARCHAR'},
    {value: '2011', text: 'NCLOB'},
    {value: '2009', text: 'SQLXML'},
    //--------------------------JDBC 4.2 -----------------------------
    {value: '2012', text: 'REF_CURSOR'},
    {value: '2013', text: 'TIME_WITH_TIMEZONE'},
    {value: '2014', text: 'TIMESTAMP_WITH_TIMEZONE'}
];

/**
 * Oracle类型(常用) todo 临时放在这里
 * @type {*[]}
 */
var Oracle_TYPE_SOURCE = [
    {value: 'BLOB', text: 'BLOB'},
    {value: 'CLOB', text: 'CLOB'},
    {value: 'CHAR', text: 'CHAR'},
    {value: 'DATE', text: 'DATE'},
    {value: 'LONG', text: 'LONG'},
    {value: 'LONG RAW', text: 'LONG RAW'},
    {value: 'NCLOB', text: 'NCLOB'},
    {value: 'NUMBER', text: 'NUMBER'},
    {value: 'NVARCHAR2', text: 'NVARCHAR2'},
    {value: 'RAW', text: 'RAW'},
    {value: 'TIMESTAMP', text: 'TIMESTAMP'},
    {value: 'VARCHAR2', text: 'VARCHAR2'}
];

/**
 * Oracle类型(常用) todo 临时放在这里
 * @type {*[]}
 */
var Sqlserver_TYPE_SOURCE = [
    {value: 'bigint', text: 'bigint'},
    {value: 'bit', text: 'bit'},
    {value: 'date', text: 'date'},
    {value: 'datetime', text: 'datetime'},
    {value: 'decimal', text: 'decimal'},
    {value: 'float', text: 'float'},
    {value: 'int', text: 'int'},
    {value: 'nchar', text: 'nchar'},
    {value: 'ntext', text: 'ntext'},
    {value: 'numeric', text: 'numeric'},
    {value: 'nvarchar', text: 'nvarchar'},
    {value: 'nvarchar(MAX)', text: 'nvarchar(MAX)'},
    {value: 'real', text: 'real'},
    {value: 'text', text: 'text'},
    {value: 'time', text: 'time'},
    {value: 'timestamp', text: 'timestamp'},
    {value: 'tinyint', text: 'tinyint'},
    {value: 'uniqueidentifier', text: 'uniqueidentifier'},
    {value: 'varbinary', text: 'varbinary'},
    {value: 'varbinary(MAX)', text: 'varbinary(MAX)'},
    {value: 'varchar', text: 'varchar'},
    {value: 'varchar(MAX)', text: 'varchar(MAX)'}
];

/**
 * Mysql类型(常用) todo 临时放在这里
 * @type {*[]}
 */
var Mysql_TYPE_SOURCE = [
    {value: 'TINYINT', text: 'TINYINT'},
    {value: 'SMALLINT', text: 'SMALLINT'},
    {value: 'MEDIUMINT', text: 'MEDIUMINT'},
    {value: 'INT', text: 'INT'},
    {value: 'INTEGER', text: 'INTEGER'},
    {value: 'BIGINT', text: 'BIGINT'},
    {value: 'BIT', text: 'BIT'},
    {value: 'REAL', text: 'REAL'},
    {value: 'DOUBLE', text: 'DOUBLE'},
    {value: 'FLOAT', text: 'FLOAT'},
    {value: 'DECIMAL', text: 'DECIMAL'},
    {value: 'NUMERIC', text: 'NUMERIC'},
    {value: 'CHAR', text: 'CHAR'},
    {value: 'VARCHAR', text: 'VARCHAR'},
    {value: 'DATE', text: 'DATE'},
    {value: 'TIME', text: 'TIME'},
    {value: 'YEAR', text: 'YEAR'},
    {value: 'TIMESTAMP', text: 'TIMESTAMP'},
    {value: 'DATETIME', text: 'DATETIME'},
    {value: 'TINYBLOB', text: 'TINYBLOB'},
    {value: 'BLOB', text: 'BLOB'},
    {value: 'MEDIUMBLOB', text: 'MEDIUMBLOB'},
    {value: 'LONGBLOB', text: 'LONGBLOB'},
    {value: 'TINYTEXT', text: 'TINYTEXT'},
    {value: 'TEXT', text: 'TEXT'},
    {value: 'MEDIUMTEXT', text: 'MEDIUMTEXT'},
    {value: 'LONGTEXT', text: 'LONGTEXT'},
    //{value: 'ENUM', text: 'ENUM'},
    //{value: 'SET', text: 'SET'},
    {value: 'BINARY', text: 'BINARY'},
    {value: 'VARBINARY', text: 'VARBINARY'}
    //,
    //{value: 'POINT', text: 'POINT'},
    //{value: 'LINESTRING', text: 'LINESTRING'},
    //{value: 'POLYGON', text: 'POLYGON'},
    //{value: 'GEOMETRY', text: 'GEOMETRY'},
    //{value: 'MULTIPOINT', text: 'MULTIPOINT'},
    //{value: 'MULTILINESTRING', text: 'MULTILINESTRING'},
    //{value: 'MULTIPOLYGON', text: 'MULTIPOLYGON'},
    //{value: 'GEOMETRYCOLLECTION', text: 'GEOMETRYCOLLECTION'}
];

function getColumnTypeByDbType(dbType) {
    var result = [];
    switch (dbType) {
        case '101':
            result = Mysql_TYPE_SOURCE;
            break;
        case '102':
            result = Oracle_TYPE_SOURCE;
            break;
        case '103':
            result = Sqlserver_TYPE_SOURCE;
            break;
        default:
            result = [];
    }
    return result;
}

function initGlobalCustom(tempUrlPrefix) {
    if (tempUrlPrefix) urlPrefix = tempUrlPrefix;
    /*
     * **************************************
     *              扩展表单验证
     * **************************************
     */
    $.validator.config({
        rules: {
            simpleName: [/^[-\w\u4E00-\u9FA5]{2,32}$/, "请填写2-32位汉字、数字、字母、下划线、横线"],
            simpleName64: [/^[-\w\u4E00-\u9FA5]{2,64}$/, "请填写2-64位汉字、数字、字母、下划线、横线"],
            simpleCode: [/^[-\w]{2,32}$/, "请填写2-32位数字、字母、下划线、横线"],
            simpleCode64: [/^[-\w]{2,64}$/, "请填写2-64位数字、字母、下划线、横线"],
            address: [/^(?=.*?[\u4E00-\u9FA5])[\dA-Za-z\u4E00-\u9FA5]+/, "请填写汉字、数字、字母、横杠，必须包含汉字且不能以横杠开头"],
            jobName: [/^[_a-zA-Z0-9\u4e00-\u9fa5\(\)\[\]\{\}（）【】｛｝]*$/, "作业名称不能包含特殊符号"],
            taskName: [/^[_a-zA-Z0-9\u4e00-\u9fa5\(\)\[\]\{\}（）【】｛｝]*$/, "任务名称不能包含特殊符号"],
            tableName: [/^[_a-zA-Z][_a-zA-Z0-9]*$/, "请输入字母、数字、下划线，且不能以数字开头"],
            columnName: [/^[_a-zA-Z][_a-zA-Z0-9]*$/, "请输入字母、数字、下划线，且不能以数字开头"],
            tableRemark: [/^[_a-zA-Z0-9\u4e00-\u9fa5\(\)\[\]\{\}（）【】｛｝]*$/, "表注释不能包含特殊符号"],//todo 验证
            tableDesc: [/^[_a-zA-Z0-9\u4e00-\u9fa5\(\)\[\]\{\}（）【】｛｝]*$/, "表详细描述不能包含特殊符号"],
            checkDateTime: [/^\d{4}-\d{2}-\d{2}\s([01]\d|2[0-3])(:[0-5]\d){1,2}$/, "请填写有效的日期，格式:YYYY-MM-DD HH:mm:ss "],
            reg_scheduleModeDetail: [/^[1-9][0-9]*$/],//定时模式详情
            ipAddress: [/^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/, '请输入正确的ip地址'],
            ftpFilePath: [/^\/$|(^(?=\/)|^\.|^\.\.)(\/(?=[^/\0])[^/\0]+)*\/?$/, "请输入正确的ftp文件路径"]
        }
    });

    /**
     *  增加验证规则:my_email
     */
    /*    $.validator.addMethod("my_email", function (value, element, params) {
     var emailReg = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))$/i;
     if (params && (value = $.trim(value)) && !value.match(emailReg)) {
     $.validator.messages.my_email = "邮箱格式不正确！";
     return false;
     }
     return true;
     }, $.validator.messages.my_email);
     /!**
     *  增加验证规则:notEqualTo
     *  参数是一个html选择器对象
     *!/
     $.validator.addMethod("notEqualTo", function (value, element, target) {
     var isEqual = false;
     if (target && $(target)) isEqual = value == $(target).val();
     return !isEqual;
     }, "请输入不同的内容！");

     /!**
     * 增加验证规则:exists_in_db_check
     * rangelength(默认长度6-12),checkExistsUrl(如果要检查是否存在,传入验证的url),tableName(从哪张表查),column(哪个字段),excludes(除开某些值不判断)，extraCondtions(额外的判断条件,object对象{columnName: columnValue})
     *!/
     $.validator.addMethod("exists_in_db_check", function (value, element, params) {
     var rangelength = [6, 12];
     var checkExistsUrl = "checkExistsInDB.action";
     var tableName = "SYS_USER";
     var column = "USERNAME";
     var excludes = [];
     var extraCondtions = {};
     var message = "";
     if (params && typeof params == "object") {
     rangelength = params["rangelength"] && $.isArray(params["rangelength"]) && params["rangelength"].length == 2 ? params["rangelength"] : rangelength;
     checkExistsUrl = params["checkExistsUrl"] ? params["checkExistsUrl"] : checkExistsUrl;
     if (checkExistsUrl.indexOf("/") != 0) checkExistsUrl = "/" + checkExistsUrl;
     tableName = params['tableName'] ? params['tableName'] : tableName;
     column = params['column'] ? params['column'] : column;
     excludes = params['excludes'] ? params['excludes'] : excludes;
     extraCondtions = params['extraCondtions'] && typeof params['extraCondtions'] == 'object' ? params['extraCondtions'] : extraCondtions;
     message = params['message'] ? params['message'] : message;
     }
     if (value = $.trim(value)) {
     if (value.length < rangelength[0] || value.length > rangelength[1]) {
     $.validator.messages.exists_in_db_check = "长度在" + rangelength[0] + "-" + rangelength[1] + "之间！";
     return false;
     }
     if ($.isArray(excludes) && excludes.length > 0) {
     for (var i in excludes) {
     if (value == excludes[i]) return true;
     }
     }
     var errMsg = "系统错误!检查失败!";
     if (checkExistsUrl && tableName && column) {
     var status = true;
     var result = true;
     $.ajax({
     type: "POST",
     url: urlPrefix + checkExistsUrl,
     async: false,//这里使用同步,因为要等待检查完的结果再返回是否通过验证
     data: {
     check: value.replace(/'/g, "&apos;").replace(/\\/g, "\\\\"),
     tableName: tableName,
     columns: column,
     extraCondtions: JSON.stringify(extraCondtions)
     },
     dataType: "json",
     success: function (json) {
     status = json['status'] ? json['status'] : false;
     result = json['result'] ? json['result'] : false;
     message = message ? message : json['message'] ? json['message'] : status ? '该值已存在！' : errMsg;
     $.validator.messages.exists_in_db_check = message;
     },
     error: function () {
     $.validator.messages.exists_in_db_check = message;
     }
     });
     return status && !result;
     } else $.validator.messages.exists_in_db_check = message;
     }
     return true;
     }, $.validator.messages.exists_in_db_check);

     /!**
     * 增加验证规则:username_check
     *
     *!/
     $.validator.addMethod("username_check", function (value, element, params) {
     if (params == true && (value = $.trim(value))) {
     var reg = /^[A-Za-z0-9]+$/g;
     if (!value.match(reg)) {
     $.validator.messages.username_check = "用户名由字母或数字组成！";
     return false;
     }
     }
     return true;
     }, $.validator.messages.username_check);

     /!**
     * 增加验证规则:byte_length_check
     * 参数length
     *!/
     $.validator.addMethod("byte_length_check", function (value, element, params) {
     var limitLength = params['length'] && typeof params['length'] == 'number' ? params['length'] : 10;
     if (limitLength > 0 && (value = $.trim(value))) {
     var reg = /[\u4e00-\u9fa5]/g;
     var length = 0;
     for (var i = 0; i < value.length; i++) {
     var v = value.charAt(i) + "";
     if (v.match(reg)) {
     length += 2;
     } else length++;
     }
     if (length > limitLength) {
     $.validator.messages.byte_length_check = "字符个数必须小于" + limitLength + "！（中文占2个字符）";
     return false;
     }
     }
     return true;
     }, $.validator.messages.byte_length_check);

     /!**
     * 增加验证规则:password
     * level密码强度级别,1 > 2 > 3 > 0(默认0), rangelength(默认长度6-12)
     *!/
     $.validator.addMethod("password_check", function (value, element, params) {
     var level = 0;
     var rangelength = [6, 12];
     if (params && typeof params == "object") {
     level = params['level'] && typeof params['level'] == 'number' ? params['level'] : level;
     rangelength = params["rangelenth"] && $.isArray(params["rangelenth"]) && params["rangelenth"].length == 2 ? params["rangelenth"] : rangelength;
     }
     if (value = $.trim(value)) {
     if (value.length < rangelength[0] || value.length > rangelength[1]) {
     $.validator.messages.password_check = "密码在" + rangelength[0] + "-" + rangelength[1] + "个字符之间！";
     return false;
     }
     var reg;
     var errorMsg;
     switch (level) {
     case 1:
     reg = /^(.*([A-Za-z]+.*[0-9]+.*[^A-Za-z0-9]+)|([0-9]+.*[A-Za-z]+.*[^A-Za-z0-9]+)|([0-9]+.*[^A-Za-z0-9]+.*[A-Za-z]+)|([A-Za-z]+.*[^A-Za-z0-9]+).*[0-9]+|([^A-Za-z0-9].*[A-Za-z]+.*[0-9]+)|([^A-Za-z0-9].*[0-9]+.*[A-Za-z]+).*)$/g;
     errorMsg = "必须包含字符、数字、特殊字符!";
     break;
     case 2:
     reg = /^.*(([A-Za-z]+.*[0-9]+)|([0-9]+.*[A-Za-z]+)).*$/g;
     errorMsg = "密码必须包含字符、数字!";
     break;
     case 3:
     reg = /^.*[A-Za-z]+.*$/g;
     errorMsg = "密码必须包含字符!";
     break;
     default :
     reg = "";
     }
     if (reg && !value.match(reg)) {
     $.validator.messages.password_check = errorMsg;
     return false;
     }
     }
     return true;
     }, $.validator.messages.password_check);

     /!**
     * 增加验证规则:phone_number_check
     * 参数type(cellPhone:手机号，tellPhone:电话号)
     *!/
     $.validator.addMethod("phone_number_check", function (value, element, params) {
     var type = 'cellPhone';
     if (params) {
     type = params ? params : type;
     }
     if (value = $.trim(value)) {
     var name = type == 'tellPhone' ? "电话" : "手机";
     var phoneReg = type == 'tellPhone' ? /^(\+?86)?\d{3,4}-\d{7,8}(-\d{3,4})?$/g : /^(\+?86)?1\d{10}$/g;
     if (!value.match(phoneReg)) {
     $.validator.messages.phone_number_check = name + "号码格式不正确！";
     return false;
     }
     }
     return true;
     }, $.validator.messages.phone_number_check);

     /!**
     * 增加验证规则:unionpaycardsnum_check
     * 参数：错误消息
     *!/
     $.validator.addMethod("unionpaycardsnum_check", function (value, element, params) {
     var errorMsg = params ? params : "银行卡号格式不正确！";
     if (value = $.trim(value)) {
     var reg = /^((\d{16})|(\d{19}))$/g;
     if (!value.match(reg)) {
     $.validator.messages.unionpaycardsnum_check = errorMsg;
     return false;
     }
     }
     return true;
     }, $.validator.messages.unionpaycardsnum_check);

     /!**
     * 增加验证规则:keywords_check,检查是否有重复关键字
     * 参数length
     *!/
     $.validator.addMethod("keywords_check", function (value, element, params) {
     var length = params['length'] && typeof params['length'] == 'number' ? params['length'] : 10;
     if (length > 0 && (value = $.trim(value))) {
     var keywordArray = value.split(",");
     var tempKeywordArray = [];
     for (var i in keywordArray) {
     var keyword = $.trim(keywordArray[i]);
     if (!keyword) {
     $.validator.messages.keywords_check = "关键字格式不正确！";
     return false;
     }
     if (keyword.length > length) {
     $.validator.messages.keywords_check = "每个关键字长度不能大于" + length + "！";
     return false;
     }
     if (tempKeywordArray.indexOf(keyword) >= 0) {
     $.validator.messages.keywords_check = "不能有重复关键字！";
     return false;
     }
     tempKeywordArray.push(keyword);
     }
     delete tempKeywordArray;
     tempKeywordArray = null;
     }
     return true;
     }, $.validator.messages.keywords_check);

     /!**
     * 增加验证规则:val_from_source_check 根据值来源的值来验证
     * 参数source: 值来源 rules: 规则  messages: 错误消息
     *!/
     $.validator.addMethod("val_from_source_check", function (value, element, params) {
     var source = params['source'] ? params['source'] : element;
     var rules = params['rules'] ? params['rules'] : {};
     var messages = params['messages'] ? params['messages'] : {};
     for (var key in rules) {
     var result = $.validator.methods[key].call(this, source.val(), element, rules[key]);
     if (!result) {
     $.validator.messages.val_from_source_check = messages[key] ? messages[key] : $.validator.messages[key];
     return false;
     }
     }
     return true;
     }, $.validator.messages.val_from_source_check);

     /!**
     * 增加验证规则:specialCharCheck
     *
     *!/
     $.validator.addMethod("specialCharCheck", function (value, element, params) {
     if (params == true && (value = $.trim(value))) {
     if (specialReg.test(value)) {
     $.validator.messages.specialCharCheck = "不能包含英文的单引号及双引号等特殊字符！";
     return false;
     }
     }
     return true;
     }, $.validator.messages.specialCharCheck);

     /!**
     * 增加验证规则:customRegexCheck
     *
     *!/
     $.validator.addMethod("customRegexCheck", function (value, element, params) {
     var customRegex = new RegExp(params['regex']);
     if (!customRegex.test(value)) {
     var message = params['message'] ?  params['message'] : "格式不正确!";
     $.validator.messages.customRegexCheck = message;
     return false;
     }
     return true;
     }, $.validator.messages.customRegexCheck);

     /!**
     * 增加验证规则:dataBaseRegexCheck,检测是否有不符合数据库要求的表名或字段名的命名规则
     *
     *!/
     $.validator.addMethod("dataBaseRegexCheck", function (value, element, params) {
     if(params==true &&(value = $.trim(value))){
     if(value.indexOf(" ")!= -1){
     $.validator.messages.dataBaseRegexCheck = "生成表名中不能包含空格";
     return false;
     }
     var reg = /^[A-Za-z0-9_-]+$/g;
     if (!value.match(reg)) {
     $.validator.messages.dataBaseRegexCheck = "生成表名只能由字母、数字或下划线组成！";
     return false;
     }
     }

     return true;
     }, $.validator.messages.dataBaseRegexCheck);*/
    /*
     * **************************************
     *              扩展方法
     * **************************************
     */
    $.extend({
        // showPageloading: function (container, loadingLeft, loadingTop, overlayLeft, overlayTop) {
        //     if ($("#overlay").length || $("#pageloading").length) {
        //         $("#overlay").remove();
        //         $("#pageloading").remove();
        //     }
        //     if (!container) {
        //         container = $("body");
        //         loadingLeft = loadingLeft || loadingLeft == 0 ? loadingLeft : (document.body.clientWidth / 2 - 25);
        //         loadingTop = loadingTop || loadingTop == 0 ? loadingTop : (document.body.clientHeight / 2.5 - 25);
        //         overlayLeft = overlayLeft ? overlayLeft : 0;
        //         overlayTop = overlayTop ? overlayTop : 0;
        //     } else {
        //         loadingLeft = loadingLeft || loadingLeft == 0 ? loadingLeft : ($(container).width() / 2 - 25 + $(container).offset().left);
        //         loadingTop = loadingTop || loadingTop == 0 ? loadingTop : ($(container).height() / 2.5 - 25 + $(container).offset().top);
        //         overlayLeft = overlayLeft || overlayLeft == 0 ? overlayLeft : $(container).offset().left;
        //         overlayTop = overlayTop || overlayTop == 0 ? overlayTop : $(container).offset().top;
        //     }
        //     container.append('<div id="overlay" style="top:' + overlayTop + 'px;left:' + overlayLeft + 'px"></div>');
        //     container.append('<div class="pageloading" id="pageloading" style="left:' + loadingLeft + 'px;top:' + loadingTop + 'px"><span class="fa fa-spinner fa-spin fa-4x"></span></div>');
        // },
        // hidePageloading: function () {
        //     $("#overlay").remove();
        //     $("#pageloading").remove();
        // },
        commonAjax: function (options, pageloading, isLoadMsg) {
            var pgloading = pageloading == false || typeof pageloading == 'object' ? pageloading : true;
            var loadmsg = isLoadMsg == false ? isLoadMsg : true;
            var op = {
                type: "POST",
                url: "",
                async: true,
                data: {},
                dataType: "json",
                beforeSend: function () {
                    // if (pgloading) {
                    //     if (typeof pageloading == 'object') $.showPageloading(pgloading.container, pgloading.loadingLeft, pgloading.loadingTop, pgloading.overlayLeft, pgloading.overlayTop);
                    //     else $.showPageloading();
                    // }
                },
                success: function (json) {
                    //$.checkSessionInvalid(json);
                },
                error: $.ajaxError,
                complete: function () {
                    // if (pgloading) $.hidePageloading();
                    // if (loadmsg) $.MessagePusher.loadMsgToShow();
                }
            };
            if (options && typeof options == 'object') {
                for (var key in options) {
                    op[key] = options[key];
                }
            }
            $.ajax(op);
        },
        // postRequest: function (url, parms) {
        //     var form = $("<form>");//定义一个form表单
        //     form.attr("style", "display:none");
        //     form.attr("method", "post");
        //     form.attr("action", url);
        //     if (parms && typeof parms == 'object') {
        //         for (var key in parms) {
        //             if (key) {
        //                 var input = $("<input>");
        //                 input.attr("type", "hidden");
        //                 input.attr("name", key);
        //                 input.attr("value", parms[key]);
        //                 form.append(input);
        //                 $("body").append(form);//将表单放置在web中
        //             }
        //         }
        //     }
        //     form.submit();
        //     form.remove();
        // },
        // encodeHtml: function (html) {
        //     if (html) {
        //         html = $("<div></div>").text(html).html();
        //     }
        //     return html;
        // },
        // decodeHtml: function (html) {
        //     if (html) {
        //         html = $("<div></div>").html(html).text();
        //     }
        //     return html;
        // },
        // validateErr: function (lable, element) {
        //     if (!$(lable).html() || $(lable).html() == element.data('errMsg')) {
        //         return;
        //     }
        //     if (!element.attr("id")) {
        //         var eleid = new Date().getTime();
        //         element.attr("id", eleid);
        //         lable.attr("for", eleid);
        //     }
        //     var errMsg = '<span style="font-size: 11px; color: #FF7777;font-weight: bolder;margin: 0">' + $(lable).html() + '</span>';
        //     var group = element.closest('.form-group');
        //     if(group) {
        //         if (group.hasClass("has-error")) {
        //             var popover = element.data('bs.popover');
        //             if (popover) {
        //                 popover.options.content = errMsg;
        //                 popover.show();
        //             }
        //         } else {
        //             group.removeClass("has-success").addClass("has-error");
        //             element.parent().find('.form-control-feedback').remove();
        //             element.parent().prepend('<span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true" style="right: 15px;line-height: ' + element.parent().height() + 'px"></span>');
        //             element.popover({
        //                 content: errMsg,
        //                 trigger: 'hover focus',
        //                 placement: 'bottom',
        //                 container: element.attr("container") ? element.attr("container") : 'body',
        //                 html: true
        //             });
        //         }
        //         element.data('errMsg', $(lable).html());
        //     }
        // },
        // validateSucc: function (lable) {
        //     var eleId = lable.attr("for");
        //     if (!eleId) return;
        //     var element = $("#" + eleId);
        //     var group = element.closest('.form-group');
        //     if(group) {
        //         group.removeClass("has-error");
        //         element.css({"padding-right": "30px"});
        //         element.parent().find('.form-control-feedback').remove();
        //         element.popover('destroy');
        //         element.data('errMsg', null);
        //         if (element.val()) {
        //             group.addClass('has-success');
        //             element.parent().prepend('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="right: 15px;line-height: ' + element.parent().height() + 'px"></span>');
        //         }
        //     }
        //     /*group.removeClass("has-error").addClass('has-success');
        //      element.parent().find('.glyphicon').remove();
        //      element.parent().prepend('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true" style="line-height: ' + element.parent().height() + 'px"></span>');
        //      element.popover('destroy');
        //      element.data('errMsg', null);*/
        // },
        // validateReset: function(formSelector){
        //     if(formSelector){
        //         $(formSelector).find("input, textarea").each(function(i){
        //             $(this).removeClass("valid").removeClass("error");
        //             var feedBack = $(this).parent().find(".form-control-feedback");
        //             if(feedBack) feedBack.remove();
        //             var group = $(this).closest('.form-group');
        //             if(group) group.removeClass("has-error").removeClass("has-success");
        //             var popover = $(this).data('bs.popover');
        //             if(popover) $(this).popover('destroy');
        //             $(this).data('errMsg', null);
        //         });
        //     }
        // },
        ajaxError: function (XMLHttpRequest, textStatus, errorThrown) {
            var msg = textStatus + ": " + (errorThrown ? errorThrown : "系统错误，请重试！");
            tip(msg);
        },
        checkSessionInvalid: function (json, callback) {
            //todo
            return false;

            if (json && json['session_invalid']) {
                var defualt_callback;
                if (callback && typeof callback == 'function') defualt_callback = callback;
                else {
                    defualt_callback = function () {
                        var actionMsg = json["actionMsg"] ? json["actionMsg"] : "";
                        var inModal = json["inModal"] ? json["inModal"] : "";
                        $.postRequest(urlPrefix + "/manage/index.action", {actionMsg: actionMsg, inModal: inModal});
                    };
                }
                $.post(urlPrefix + "/login/logout_ajax.action", defualt_callback);
            } else if (json && json['home_session_invalid']) {
                var home_callback;
                if (callback && typeof callback == 'function') home_callback = callback;
                else {
                    home_callback = function () {
                        var inModal = json["inModal"] ? json["inModal"] : "";
                        $.postRequest(urlPrefix + "/home.action", {inModal: inModal});
                    };
                }
                $.post(urlPrefix + "/home.action", home_callback);
            }

            return json['session_invalid'] == true;
        },
        // download: function (data) {
        //     $.commonAjax({
        //         url: urlPrefix + '/downloadCheck.action',
        //         data: data,
        //         success: function (json) {
        //             if (!$.checkSessionInvalid(json)) {
        //                 if (json && json.status) {
        //                     $.postRequest(urlPrefix + "/download.action", json['download_params']);
        //                 }
        //             }
        //         },
        //         error: $.ajaxError,
        //         complete: function () {
        //             $.hidePageloading();
        //             $.MessagePusher.loadMsgToShow();
        //         }
        //     }, true);
        // },
        // checkCookieEnabled: function () {
        //     var dt = new Date();
        //     dt.setSeconds(dt.getSeconds() + 60);
        //     document.cookie = "cookietest=1; expires=" + dt.toUTCString();
        //     var cookiesenabled = document.cookie.indexOf("cookietest=") != -1;
        //     if (!cookiesenabled) {
        //         $.Box.alert('浏览器禁用了cookie，开启Cookie之后才能登录！');
        //     }
        //     return cookiesenabled;
        // },
        // my_clone: function (obj) {
        //     if (obj && typeof obj == 'object') {
        //         obj = eval("(" + JSON.stringify(obj) + ")");
        //     }
        //     return obj;
        // },
        // showDialog: function (handleType, dialogId, title, url, parms, width, height, closeFun) {
        //     var saveButton = false;
        //     var hasReset = false;
        //     var hasCancel = false;
        //     if (handleType == 'update' || handleType == 'add') {
        //         saveButton = function () {
        //             return save(dialog);
        //         };
        //         hasReset = false;
        //         hasCancel = true;
        //     }
        //     var dialog = $.Box.dialog(dialogId, title, null, url, parms, width, height, saveButton, hasReset, hasCancel, closeFun);
        // },
        // getCheckedDataIds: function (tableDom, singleFlag, allowEmpty) {
        //     var items = $(tableDom).data("bootstrap.table").getSelections();
        //     var checkedNum = items.length;
        //     if (allowEmpty && checkedNum == 0) {
        //         return "";
        //     }
        //     if (checkedNum == 0) {
        //         $.Box.alert('请选择要进行操作的数据！');
        //         return;
        //     }
        //     if (singleFlag && singleFlag == true) {
        //         if (checkedNum > 1) {
        //             $.Box.alert('只能选择一条数据进行操作！');
        //             return;
        //         }
        //     }
        //     var ids = "";
        //     for (var i in items) {
        //         if (ids) ids += ",";
        //         var item = items[i];
        //         ids += item['id'];
        //     }
        //     return ids;
        // },
        // getCheckedDataAttrs: function (tableDom, attrName, singleFlag) {
        //     var items = $(tableDom).data("bootstrap.table").getSelections();
        //     var checkedNum = items.length;
        //     if (checkedNum == 0) {
        //         $.Box.alert('请选择要进行操作的数据！');
        //         return;
        //     }
        //     if (singleFlag && singleFlag == true) {
        //         if (checkedNum > 1) {
        //             $.Box.alert('只能选择一条数据进行操作！');
        //             return;
        //         }
        //     }
        //     var attrs = "";
        //     for (var i in items) {
        //         if (attrs) attrs += ",";
        //         var item = items[i];
        //         attrs += item[attrName];
        //     }
        //     return attrs;
        // },
        // arrayToStrs: function (array) {
        //     var resultStrs = "";
        //     if (array) {
        //         if ($.isArray(array)) {
        //             for (var i in array) {
        //                 if (resultStrs) resultStrs += ",";
        //                 resultStrs += array[i];
        //             }
        //         } else if (typeof array == 'string') {
        //             resultStrs = array;
        //         }
        //     }
        //     return resultStrs;
        // },
        // strsToArray: function (strs, split) {
        //     var resultArray;
        //     if (strs) {
        //         if (!split) split = ",";
        //         resultArray = strs.split(split);
        //     } else resultArray = [];
        //     return resultArray;
        // },
        // checkSelectPickerRequired: function(itemDom,itemName){
        //     var flag = true;
        //     if (!$(itemDom).val()) {
        //         if (flag) $.Box.alert("请选择" + itemName + "！");
        //         $(itemDom).parent().parent().removeClass("has-success");
        //         $(itemDom).parent().parent().addClass("has-error");
        //         flag = false;
        //     } else {
        //         $(itemDom).parent().parent().removeClass("has-error");
        //         $(itemDom).parent().parent().addClass("has-success");
        //     }
        //     return flag;
        // },
        // checkItem: function (itemDom, itemName, rule) {
        //     if (rule.required) {
        //         if ($(itemDom).val() == "") {
        //             $.Box.alert(itemName + "不能为空！");
        //             return false;
        //         }
        //     }
        //     if (rule.maxlength) {
        //         if ($(itemDom).val().length > rule.maxlength) {
        //             $.Box.alert(itemName + "的最大长度不能超过" + rule.maxlength + "!");
        //             return false;
        //         }
        //     }
        //
        //     if (rule.minLength) {
        //         if ($(itemDom).val().length < rule.minLength) {
        //             $.Box.alert(itemName + "的最小长度不能小于" + rule.maxlength + "!");
        //             return false;
        //         }
        //     }
        //     if (rule.specialCharCheck) {
        //         if (specialReg.test($(itemDom).val())) {
        //             $.Box.alert(itemName + "不能包含英文的单引号及双引号等特殊字符!");
        //             return false;
        //         }
        //     }
        //     if (rule.numberic) {
        //         var reg = /^[0-9]*$/;
        //         if (!reg.test($(itemDom).val())) {
        //             $.Box.alert(itemName + '只能为整数！');
        //             return false;
        //         }
        //     }
        //     if (rule.numbericRange) {
        //         if (parseInt($(itemDom).val()) < rule.numbericRange[0] || parseInt($(itemDom).val()) > rule.numbericRange[1]) {
        //             $.Box.alert(itemName + '范围为' + rule.numbericRange[0] + '-' + rule.numbericRange[1] + '之间！');
        //             return false;
        //         }
        //     }
        //
        //     return true;
        // },
        // myEncode: function (code) {
        //     var c=String.fromCharCode(code.charCodeAt(0)+code.length);
        //     for(var i=1;i<code.length;i++){
        //         c+=String.fromCharCode(code.charCodeAt(i)+code.charCodeAt(i-1));
        //     }
        //     return c;
        // },
        // myDecode: function (code) {
        //     var c=String.fromCharCode(code.charCodeAt(0)-code.length);
        //     for(var i=1;i<code.length;i++){
        //         c+=String.fromCharCode(code.charCodeAt(i)-c.charCodeAt(i-1));
        //     }
        //     return c;
        // },
        // MessagePusher: {
        //     msgs: [],
        //     loadMsgToShow: function () {
        //         $.commonAjax({
        //             url: urlPrefix + "/loadMsgToShow.action",
        //             success: function (json) {
        //                 if (json && json.result) {
        //                     window.top.$.MessagePusher.msgs = json['msg_for_push'];
        //                 }
        //             },
        //             error: $.ajaxError,
        //             complete: function () {
        //                 setTimeout($.MessagePusher.showMsgs, 100);
        //             }
        //         }, false);
        //     },
        //     showMsgs: function () {
        //         while (window.top.$.MessagePusher.msgs.length > 0) {
        //             var msg = window.top.$.MessagePusher.msgs.pop();
        //             window.top.$.MessagePusher.showMsg(msg);
        //         }
        //     },
        //     showMsg: function (msg) {
        //         if (window.top != window) {
        //             window.top.$.MessagePusher.showMsg(msg);
        //             return;
        //         }
        //         if (msg) {
        //             if (typeof msg == 'string') {
        //                 msg = {
        //                     type: 'info',
        //                     message: msg
        //                 };
        //             } else if (typeof msg == 'object') {
        //                 msg = {
        //                     type: msg.type ? msg.type : 'info',
        //                     message: msg.message ? msg.message : ''
        //                 };
        //             }
        //             if(msg.type == 'error'){console.log(msg.message);return;}
        //             var notifyWidth = 300;
        //             new PNotify({
        //                 title: false,
        //                 text: msg.message,
        //                 type: msg.type, //"notice", "info", "success", or "error".
        //                 styling: "bootstrap3",//"brighttheme", "jqueryui", "bootstrap2", "bootstrap3", "fontawesome", or a custom style object
        //                 width: notifyWidth + "px",
        //                 icon: true,
        //                 animation: 'fade', //"none", "show", "fade", and "slide"
        //                 animate_speed: "slow", //"slow", "def" or "normal", "fast" or number of milliseconds.
        //                 position_animate_speed: 500,
        //                 opacity: 0.8,
        //                 shadow: true,
        //                 hide: true, //After a delay, remove the notice.
        //                 delay: 3000, //Delay in milliseconds before the notice is removed.
        //                 mouse_reset: true, //Reset the hide timer if the mouse moves over the notice.
        //                 remove: true, //Remove the notice's elements from the DOM after it is removed.
        //                 insert_brs: true, //Change new lines to br tags.
        //                 addclass: "stack-topright",
        //                 stack: {
        //                     "dir1": "down",
        //                     "dir2": "left",
        //                     "push": "bottom",
        //                     "firstpos1": 15,
        //                     "firstpos2": ($("body").width() - notifyWidth) / 2,
        //                     "context": $("body")
        //                 }, //The stack on which the notices will be placed. Also controls the direction the notices stack.
        //                 desktop: {
        //                     desktop: false, //Display the notification as a desktop notification.
        //                     fallback: true, //If desktop notifications are not supported or allowed, fall back to a regular notice.
        //                     icon: null, //The URL of the icon to display. If false, no icon will show. If null, a default icon will show.
        //                     tag: null //Using a tag lets you update an existing notice, or keep from duplicating notices between tabs. If you leave tag null, one will be generated, facilitating the "update" function.
        //                 },
        //                 nonblock: {
        //                     nonblock: false, //Create a non-blocking notice. It lets the user click elements underneath it.
        //                     nonblock_opacity: 1 //The opacity of the notice (if it's non-blocking) when the mouse is over it.
        //                 },
        //                 buttons: {
        //                     closer: true, //Provide a button for the user to manually close the notice.
        //                     closer_hover: true, //Only show the closer button on hover.
        //                     sticker: true, //Provide a button for the user to manually stick the notice.
        //                     sticker_hover: true, //Only show the sticker button on hover.
        //                     show_on_nonblock: true, //Show the buttons even when the nonblock module is in use.
        //                     labels: {close: "关闭", stick: "暂停"} // Lets you change the displayed text, facilitating internationalization.
        //                 },
        //                 history: {
        //                     history: true, //Place the notice in the history.
        //                     menu: false, //Display a pull down menu to redisplay previous notices.
        //                     fixed: false, //Make the pull down menu fixed to the top of the viewport.
        //                     maxonscreen: 3, //Maximum number of notifications to have onscreen.
        //                     labels: {redisplay: "历史消息", all: "所有", last: "最近"} //Lets you change the displayed text, facilitating internationalization.
        //                 },
        //                 reference: {
        //                     putThing: false, //Provide a thing for stuff. Turned off by default.
        //                     labels: {text: "旋转"} //If you are displaying any text, you should use a labels options to support internationalization.
        //                 },
        //                 before_init: function () {
        //                 }, //This option is called before the notice has been initialized. It accepts one argument, the options object.
        //                 after_init: function () {
        //                 }, //This option is called after the notice has been initialized. It accepts one argument, the notice object.
        //                 before_open: function () {
        //                 }, // This option is called before the notice has been displayed. It accepts one argument, the notice object.
        //                 after_open: function () {
        //                 }, //This option is called after the notice has been displayed. It accepts one argument, the notice object.
        //                 before_close: function () {
        //                 }, //This option is called before the notice closes. It accepts one argument, the notice object.
        //                 after_close: function () {
        //                 } //This option is called after the notice closes. It accepts one argument, the notice object.
        //
        //             });
        //         }
        //     }
        // },
        // Box: {
        //     Type: {
        //         DIALOG: {
        //             code: 0,
        //             ok_button_class: 'btn-primary btn-sm'
        //         },
        //         INFO: {
        //             code: 1,
        //             icon_class: 'glyphicon-info-sign',
        //             icon_color: '#1abc9c',
        //             text_class: 'text-success',
        //             ok_button_class: 'btn-primary btn-sm'
        //         },
        //         WARN: {
        //             code: 2,
        //             icon_class: 'glyphicon-exclamation-sign',
        //             icon_color: '#eea236',
        //             text_class: 'text-warning',
        //             ok_button_class: 'btn-warning btn-sm'
        //         },
        //         ERROR: {
        //             code: 3,
        //             icon_class: 'glyphicon-remove-sign',
        //             icon_color: '#d9534f',
        //             text_class: 'text-danger',
        //             ok_button_class: 'btn-danger btn-sm'
        //         },
        //         CONFIRM: {
        //             code: 4,
        //             icon_class: 'glyphicon-question-sign',
        //             icon_color: '#1abc9c',
        //             text_class: 'text-success',
        //             ok_button_class: 'btn-primary btn-sm'
        //         }
        //     },
        //     Options: {
        //         buttons: {
        //             ok: {
        //                 label: '确 认',
        //                 className: "btn-primary btn-sm",
        //                 callback: function () {
        //                 }
        //             },
        //             reset: {
        //                 label: '重 置',
        //                 className: "btn-default btn-sm",
        //                 callback: function () {
        //                 }
        //             },
        //             cancel: {
        //                 label: '取 消',
        //                 className: "btn-default btn-sm",
        //                 callback: function () {
        //                 }
        //             }
        //         },
        //         message: '',
        //         remote: '',
        //         title: '',
        //         onEscape: true,
        //         container: "body"
        //     },
        //     show: function (opt, type, id, width, height, closeFun) {
        //         var options = $.my_clone($.Box.Options);
        //         if (!opt) opt = '';
        //         if (!type || typeof type != 'object') type = $.Box.Type.DIALOG;
        //         if (!id) id = "dialog_" + new Date().getTime();
        //         if (width && (typeof width == 'number' && width <= 0)) width = null;
        //         if (height && (typeof height == 'number' && height <= 0)) height = null;
        //         if (type != $.Box.Type.DIALOG) {
        //             var content = $('<div></div>');
        //             var body = $('<div class="media" style="margin-top:5px;"></div>');
        //             var icon = $('<span class="pull-left media-object glyphicon" style="font-size: 25px;"></span>');
        //             var message = $('<div class="media-body" style="padding-top: 3px;font-size:14px;"></div>');
        //             if (type.text_class) message.addClass(type.text_class);
        //             if (type.icon_class) icon.addClass(type.icon_class);
        //             if (type.icon_color) icon.css("color", type.icon_color);
        //             body.append(icon);
        //             body.append(message);
        //             content.append(body);
        //             if (typeof opt == 'string') {
        //                 message.append(opt);
        //                 options.message = content.html();
        //             } else if (typeof opt == 'object') {
        //                 $.extend(options, opt);
        //                 message.append(options['message']);
        //                 options['message'] = content.html();
        //             }
        //         } else {
        //             if (typeof opt == 'string') {
        //                 options.message = opt;
        //             } else if (typeof opt == 'object') {
        //                 $.extend(options, opt);
        //                 if (options.remote) options.message = '加载中...';
        //             }
        //         }
        //         var dialog = bootbox.dialog(options);
        //         if (options.remote) {
        //             var modalDialog = dialog.find(".modal-dialog");
        //             var modalBody = dialog.find(".modal-body");
        //             var dialogBody = dialog.find(".bootbox-body");
        //             if (width && $(window).width() >= width) {
        //                 modalDialog.css({width: width});
        //             }
        //             if (height && $(window).height() >= height) {
        //                 dialogBody.css({height: height});
        //             }
        //             modalBody.css({padding: 0});
        //             dialogBody.css({padding: '15px', overflow: 'auto'});
        //             dialog.attr("id", id).css("overflow", "auto");
        //             dialog.find(".modal-footer > .btn").attr("disabled", true);
        //             var baseParms = {inModal: "true"};
        //             if (opt.params && typeof opt.params == 'object') $.extend(baseParms, opt.params);
        //             dialogBody.load(options.remote, baseParms, function (html, status) {
        //                 if (status == 'success' && dialog.find(".modal-footer > .btn")) dialog.find(".modal-footer > .btn").removeAttr("disabled");
        //                 if (status == 'error') dialogBody.html(html ? html : "<span style='color:red'>系统错误，请重试！<span>");
        //                 $.MessagePusher.loadMsgToShow();
        //                 dialog.animate({scrollTop: 0}, 1000);
        //             });
        //         }
        //         dialog.parent().css({"padding-right": "0"});
        //         dialog.on("hidden.bs.modal", function (e) {
        //             if (e.target === this) {
        //                 if (closeFun && typeof closeFun == "function") {
        //                     closeFun();
        //                 }
        //                 dialog.remove();
        //             }
        //         });
        //         return dialog;
        //     },
        //     alert: function (msg, type, okButton, container) {
        //         if (!type || typeof type != 'object') type = $.Box.Type.WARN;
        //         var opt = {
        //             message: msg,
        //             buttons: {
        //                 ok: {
        //                     label: '确 认',
        //                     className: type.ok_button_class ? type.ok_button_class : "btn-primary btn-sm",
        //                     callback: function () {
        //                     }
        //                 }
        //             }
        //         };
        //         if (okButton) {
        //             if (typeof okButton == 'function') {
        //                 opt.buttons.ok.callback = okButton;
        //             } else if (typeof okButton == 'object') {
        //                 opt.buttons.ok = okButton;
        //             }
        //         }
        //         if(container){
        //             opt.container = container;
        //         }
        //         return $.Box.show(opt, type, "alert");
        //     },
        //     confirm: function (msg, okButton, cancelButton, container) {
        //         var opt = {
        //             message: msg,
        //             buttons: {
        //                 ok: {
        //                     label: '确 认',
        //                     className: "btn-primary btn-sm",
        //                     callback: function () {
        //                     }
        //                 },
        //                 cancel: {
        //                     label: '取 消',
        //                     className: "btn-default btn-sm",
        //                     callback: function () {
        //                     }
        //                 }
        //             }
        //         };
        //         if (okButton) {
        //             if (typeof okButton == 'function') {
        //                 opt.buttons.ok.callback = okButton;
        //             } else if (typeof okButton == 'object') {
        //                 opt.buttons.ok = okButton;
        //             }
        //         }
        //         if (cancelButton) {
        //             if (typeof cancelButton == 'function') {
        //                 opt.buttons.cancel.callback = cancelButton;
        //             } else if (typeof cancelButton == 'object') {
        //                 opt.buttons.cancel = cancelButton;
        //             }
        //         }
        //         if(container){
        //             opt.container = container;
        //         }
        //         return $.Box.show(opt, $.Box.Type.CONFIRM, "confirm");
        //     },
        //     dialog: function (id, title, msg, remote, params, width, height, okButton, resetButton, cancelButton, closeFun, container) {
        //         var dialog;
        //         var opt = {
        //             title: title,
        //             remote: remote,
        //             params: params,
        //             message: msg,
        //             buttons: {}
        //         };
        //         if (okButton) {
        //             var ok = {
        //                 label: '确 认',
        //                 className: "btn-primary btn-sm",
        //                 callback: function () {
        //                 }
        //             };
        //             if (typeof okButton == 'function') {
        //                 ok.callback = okButton;
        //             } else if (typeof okButton == 'object') {
        //                 ok = okButton;
        //             }
        //             opt.buttons.ok = ok;
        //         }
        //         if (resetButton) {
        //             var reset = {
        //                 label: '重 置',
        //                 className: "btn-default btn-sm",
        //                 callback: function () {
        //                     dialog.find(".modal-footer > .btn").attr("disabled", true);
        //                     dialog.find(".bootbox-body").load(remote, {}, function (html, status) {
        //                         if (status) dialog.find(".modal-footer > .btn").removeAttr("disabled");
        //                         $.MessagePusher.loadMsgToShow();
        //                     });
        //                     return false;
        //                 }
        //             };
        //             if (typeof resetButton == 'function') {
        //                 reset.callback = resetButton;
        //             } else if (typeof resetButton == 'object') {
        //                 reset = resetButton;
        //             }
        //             opt.buttons.reset = reset;
        //         }
        //         if (cancelButton) {
        //             var cancel = {
        //                 label: '关 闭',
        //                 className: "btn-default btn-sm",
        //                 callback: function () {
        //                 }
        //             };
        //             if (typeof cancelButton == 'function') {
        //                 cancel.callback = cancelButton;
        //             } else if (typeof cancelButton == 'object') {
        //                 cancel = cancelButton;
        //             }
        //             opt.buttons.cancel = cancel;
        //         }
        //         if(container){
        //             opt.container = container;
        //         }
        //         return dialog = $.Box.show(opt, $.Box.Type.DIALOG, id, width, height, closeFun);
        //     }
        // },
        // dynamicLoading: {
        //     css: function (path) {
        //         if (!path || path.length === 0) {
        //             throw new Error('argument "path" is required !');
        //         }
        //         var head = document.getElementsByTagName('head')[0];
        //         var link = document.createElement('link');
        //         link.href = path;
        //         link.rel = 'stylesheet';
        //         link.type = 'text/css';
        //         head.appendChild(link);
        //     },
        //     js: function (path) {
        //         if (!path || path.length === 0) {
        //             throw new Error('argument "path" is required !');
        //         }
        //         var head = document.getElementsByTagName('head')[0];
        //         var script = document.createElement('script');
        //         script.src = path;
        //         script.type = 'text/javascript';
        //         head.appendChild(script);
        //     }
        // }


        /**
         * 获取当前选中的区域的编码
         */
        getSelectedRegionCode:function(){
            var regionCode = "";
            var regionObj = JSON.parse(window.localStorage.getItem("regionObj"));
            if(regionObj){
                regionCode = regionObj.code;
            }
            return regionCode;
        },
        /**
         * 获取目录类别的下拉树对象
         * @param treeDomId         ztree对象的id
         * @param nameInputDomId    显示选中目录类别的名称的input框的id
         * @param codeInputDomId    存储选中目录类别的id的隐藏域input框的id
         * @param treeDivDomId      树形展开区域的DIV的id
         */
        initClassifyTreeSelect: function (treeDomId, nameInputDomId, codeInputDomId, treeDivDomId) {
            var selectIds = "";
            var setting = {
                async: {
                    enable: true,
                    url: basePathJS + "/dirClassify/authorityList",
                    autoParam: ["fid"],
                    dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
                        var params = [];
                        var nodeObjs = childNodes.content.vo;
                        if (!nodeObjs) {
                            return null;
                        }
                        for (var i in nodeObjs) {
                            params[i] = {
                                'id': nodeObjs[i].id,
                                'name': nodeObjs[i].classifyName,
                                'fid': nodeObjs[i].id,
                                'isParent': (nodeObjs[i].hasLeaf == "1" ? true : false)
                            }
                        }
                        return params;
                    }
                },
                callback: {
                    beforeClick: function (treeId, treeNode) { //如果点击的节点还有下级节点，则展开该节点
                        var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId);
                        if (treeNode.isParent) {
                            if (treeNode.open) {
                                zTreeObj.expandNode(treeNode, false);
                            } else {
                                zTreeObj.expandNode(treeNode, true);
                            }
                            return false;
                        } else {
                            return true;
                        }
                    },
                    onClick: function (e, treeId, treeNode) { //点击最下层子节点，获取目录类别的全名称，显示到输入框中
                        $.commonAjax({
                            url: basePathJS + "/dirClassify/editLoad",
                            data: {id: treeNode.id},
                            success: function (result) {
                                if (result.state) {
                                    var classifyObj = result.content.vo;
                                    $('#' + nameInputDomId).val(classifyObj.classifyStructureName);
                                    if (selectIds == "") {
                                        selectIds = treeNode.id;
                                    } else {
                                        selectIds += "," + treeNode.id;
                                    }
                                    $('#' + codeInputDomId).val(selectIds);
                                }
                            }
                        });
                    }
                }
            };

            $('#' + nameInputDomId).click(function () {
                $.fn.zTree.init($("#" + treeDomId), setting);
                var cityOffset = $("#" + nameInputDomId).offset();
                $("#" + treeDivDomId).css({
                    left: cityOffset.left + "px",
                    top: cityOffset.top + $("#" + nameInputDomId).outerHeight() + "px"
                }).slideDown("fast");
                $("body").bind("mousedown", function (event) {
                    if (!(event.target.id == "menuBtn" || event.target.id == treeDivDomId || $(event.target).parents("#" + treeDivDomId).length > 0)) {
                        $("#" + treeDivDomId).fadeOut("fast");
                        $("body").unbind("mousedown");
                    }
                });
            })

        },
        
        /**
         * 获取目录类别的下拉树对象
         * @param treeDomId         ztree对象的id
         * @param nameInputDomId    显示选中目录类别的名称的input框的id
         * @param codeInputDomId    存储选中目录类别的id的隐藏域input框的id
         * @param treeDivDomId      树形展开区域的DIV的id
         */
        initCategoryAppTreeSelect: function (treeDomId, nameInputDomId, codeInputDomId, treeDivDomId) {
//            var selectIds = "";
            var setting = {
            		check: {
                        enable: true,
                        chkStyle: "radio",  //单选框
                        radioType: "all",   //对所有节点设置单选
                        chkboxType:  { "Y": "", "N": "" } //取消父子关联
                    }, 
                    
                    async: {
                    enable: true,
                    url: basePathJS + "/dirSpecialApps/categoryTree",
                    autoParam: ["parentCode"],
                    dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
                        var params = [];
                        var nodeObjs = childNodes.content.vo;
                        if (!nodeObjs) {
                            return null;
                        }
                        for (var i in nodeObjs) {
                            params[i] = {
                                'id': nodeObjs[i].id,
                                'name': nodeObjs[i].dictName,
                                'parentCode': nodeObjs[i].dictCode,
                                'isParent': (nodeObjs[i].hasLeaf == "1" ? true : false)                               
                                
                            }
                        }
                        return params;
                    }
                },
                callback: {
                    onClick: function (e, treeId, treeNode) { //点击节点，选中并触发oncheck事件
                        var zTree = $.fn.zTree.getZTreeObj(treeId);
                        zTree.checkNode(treeNode,true,true,true);
                    },
                    onCheck: function (e, treeId, treeNode) { //点击radio，获取目录类别的全名称，显示到输入框中
//                        $.commonAjax({
//                            url: basePathJS + "/dirSpecialApps/loadCategory",
//                            data: {dictCode: treeNode.dictCode},
//                            success: function (result) {
//                                if (result.state) {
//                                    var classifyObj = result.content.vo;
//                                    $('#' + nameInputDomId).val(classifyObj.dictName);
//                                    $('#' + codeInputDomId).val(treeNode.dictCode);
//                                }
//                            }
//                        });
                    	 $('#' + nameInputDomId).val(treeNode.name);
                    	 $('#' + codeInputDomId).val(treeNode.parentCode);
                    }
                }
//                callback: {
//                    beforeClick: function (treeId, treeNode) { //如果点击的节点还有下级节点，则展开该节点
//                        var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId);
//                        if (treeNode.isParent) {
//                            if (treeNode.open) {
//                                zTreeObj.expandNode(treeNode, false);
//                            } else {
//                                zTreeObj.expandNode(treeNode, true);
//                            }
//                            return false;
//                        } else {
//                            return true;
//                        }
//                    },
//                    onClick: function (e, treeId, treeNode) { //点击最下层子节点，获取目录类别的全名称，显示到输入框中
//                        $.commonAjax({
//                            url: basePathJS + "/dirSpecialApps/loadCategory",
//                            data: {dictCode: treeNode.dictCode},
//                            success: function (result) {
//                                if (result.state) {
//                                    var classifyObj = result.content.vo;
//                                    $('#' + nameInputDomId).val(classifyObj.dictName);
//                                    if (selectIds == "") {
//                                        selectIds = treeNode.dictCode;
//                                    } else {
//                                        selectIds += "," + treeNode.dictCode;
//                                    }
//                                    $('#' + codeInputDomId).val(selectIds);
//                                }
//                            }
//                        });
//                    }
//                }
            };

            $('#' + nameInputDomId).click(function () {
                $.fn.zTree.init($("#" + treeDomId), setting);
                var cityOffset = $("#" + nameInputDomId).offset();
                $("#" + treeDivDomId).css({
                    left: cityOffset.left + "px",
                    top: cityOffset.top + $("#" + nameInputDomId).outerHeight() + "px"
                }).slideDown("fast");
                $("body").bind("mousedown", function (event) {
                    if (!(event.target.id == "menuBtn" || event.target.id == treeDivDomId || $(event.target).parents("#" + treeDivDomId).length > 0)) {
                        $("#" + treeDivDomId).fadeOut("fast");
                        $("body").unbind("mousedown");
                    }
                });
            })

        },
        
        
        
        /**
         * 获取目录类别查询框的下拉树对象(单选,可以选择父级节点)
         * @param treeDomId         ztree对象的id
         * @param nameInputDomId    显示选中目录类别的名称的input框的id
         * @param codeInputDomId    存储选中目录类别的id的隐藏域input框的id
         * @param treeDivDomId      树形展开区域的DIV的id
         */
        initQueryClassifyTreeSelect: function (treeDomId, nameInputDomId, codeInputDomId, treeDivDomId) {
            var setting = {
                check: {
                    enable: true,
                    chkStyle: "radio",  //单选框
                    radioType: "all",   //对所有节点设置单选
                    chkboxType:  { "Y": "", "N": "" } //取消父子关联
                },
                async: {
                    enable: true,
                    url: basePathJS + "/dirClassify/authorityList",
                    autoParam: ["fid"],
                    dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
                        var params = [];
                        var nodeObjs = childNodes.content.vo;
                        if (!nodeObjs) {
                            return null;
                        }
                        for (var i in nodeObjs) {
                            params[i] = {
                                'id': nodeObjs[i].id,
                                'name': nodeObjs[i].classifyName,
                                'fid': nodeObjs[i].id,
                                'isParent': (nodeObjs[i].hasLeaf == "1" ? true : false)
                            }
                        }
                        return params;
                    }
                },
                callback: {
                    onClick: function (e, treeId, treeNode) { //点击节点，选中并触发oncheck事件
                        var zTree = $.fn.zTree.getZTreeObj(treeId);
                        zTree.checkNode(treeNode,true,true,true);
                    },
                    onCheck: function (e, treeId, treeNode) { //点击radio，获取目录类别的全名称，显示到输入框中
                        $.commonAjax({
                            url: basePathJS + "/dirClassify/editLoad",
                            data: {id: treeNode.id},
                            success: function (result) {
                                if (result.state) {
                                    var classifyObj = result.content.vo;
                                    $('#' + nameInputDomId).val(classifyObj.classifyStructureName);
                                    $('#' + codeInputDomId).val(treeNode.id);
                                }
                            }
                        });
                    }
                }
            };

            $('#' + nameInputDomId).click(function () {
                $.fn.zTree.init($("#" + treeDomId), setting);
                var cityOffset = $("#" + nameInputDomId).offset();
                $("#" + treeDivDomId).css({
                    left: cityOffset.left + "px",
                    top: cityOffset.top + $("#" + nameInputDomId).outerHeight() + "px"
                }).slideDown("fast");
                $("body").bind("mousedown", function (event) {
                    if (!(event.target.id == "menuBtn" || event.target.id == treeDivDomId || $(event.target).parents("#" + treeDivDomId).length > 0)) {
                        $("#" + treeDivDomId).fadeOut("fast");
                        $("body").unbind("mousedown");
                    }
                });
            })

        },

        /**
         * 获取目录类别的下拉树对象
         * @param treeDomId         ztree对象的id
         * @param nameInputDomId    显示选中目录类别的名称的input框的id
         * @param codeInputDomId    存储选中目录类别的id的隐藏域input框的id
         * @param treeDivDomId      树形展开区域的DIV的id
         * @param multiple          复选还是单选
         * @param param             异步加载url参数
         * @param selects           初始化选中值
         */
        initClassifyTreeSelect2: function (treeDomId, nameInputDomId, codeInputDomId, treeDivDomId, multiple, param, selects) {
            var chkStyle = multiple ? "checkbox" : "radio";
            if(!param || typeof param != 'object') param = {};
            if(!selects || !$.isArray(selects)) selects = [];
            var setting = {
                async: {
                    enable: true,
                    url: basePathJS + "/dirClassify/authorityList",
                    autoParam: ["fid"],
                    otherParam: param,
                    dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
                        var params = [];
                        var nodeObjs = childNodes.content.vo;
                        if (!nodeObjs) {
                            return null;
                        }
                        for (var i in nodeObjs) {
                            params[i] = {
                                'id': nodeObjs[i].id,
                                'name': nodeObjs[i].classifyName,
                                'fid': nodeObjs[i].id,
                                'pid': nodeObjs[i].fid,
                                'checked': selects.indexOf(nodeObjs[i].id) >= 0,
                                'isParent': (nodeObjs[i].hasLeaf == "1" ? true : false)
                            }
                        }
                        return params;
                    }
                },
                check: {enable: true,chkStyle: chkStyle,chkboxType: { "Y":"ps","N":"ps"}},
                callback: {
                    beforeClick: function (treeId, treeNode) { //如果点击的节点还有下级节点，则展开该节点
                        var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId);
                        if (treeNode.isParent) {
                            if (treeNode.open) {
                                zTreeObj.expandNode(treeNode, false);
                            } else {
                                zTreeObj.expandNode(treeNode, true);
                            }
                            return false;
                        } else {
                            return true;
                        }
                    },
                    onCheck: function (e, treeId, treeNode) { //选中节点，获取区域类别的名称，显示到输入框中
                        var ids = [], names = [];
                        if(multiple){
                            var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId), selectNodes = zTreeObj.getCheckedNodes(true);
                            var resultList = [];
                            var tempList = [];
                            for(var i in selectNodes){
                                var node = selectNodes[i];
                                if(node.check_Child_State!=1){
                                    tempList.push(node);
                                }
                            }
                            if(tempList.length > 0){
                                for(var i in tempList){
                                    var flag = false;
                                    var tempNode = tempList[i];
                                    for(var j in tempList){
                                        if(tempNode.pid == tempList[j].id){
                                            flag = true;
                                            break;
                                        }
                                    }
                                    if(!flag){
                                        resultList.push(tempNode);
                                    }
                                }
                            }
                            for(var i in resultList){
                                var selectedNode = resultList[i];
                                var id = selectedNode.id;
                                var name = selectedNode.name;
                                if(id && name){
                                    ids.push(id);
                                    names.push(name);
                                }
                            }
                        }else{
                            var id = treeNode.id;
                            var name = treeNode.name;
                            if(id && name){
                                ids.push(id);
                                names.push(name);
                            }
                        }
                        $('#' + codeInputDomId).val(ids.join(","));
                        if(nameInputDomId){
                            $('#' + nameInputDomId).val(names.join(","));
                        }
                    }
                }
            };
            if(nameInputDomId){
                $('#' + nameInputDomId).click(function () {
                    $.fn.zTree.init($("#" + treeDomId), setting);
                    var cityOffset = $("#" + nameInputDomId).offset();
                    $("#" + treeDivDomId).css({
                        left: cityOffset.left + "px",
                        top: cityOffset.top + $("#" + nameInputDomId).outerHeight() + "px"
                    }).slideDown("fast");
                    $("body").bind("mousedown", function (event) {
                        if (!(event.target.id == "menuBtn" || event.target.id == treeDivDomId || $(event.target).parents("#" + treeDivDomId).length > 0)) {
                            $("#" + treeDivDomId).fadeOut("fast");
                            $("body").unbind("mousedown");
                        }
                    });
                })
            }else{
                $.fn.zTree.init($("#" + treeDomId), setting);
            }

        },
        /**
         * 获取资源提供方的下拉树对象(单选,可以选择父级节点)
         * @param treeDomId         ztree对象的id
         * @param nameInputDomId    显示选中目录类别的名称的input框的id
         * @param codeInputDomId    存储选中目录类别的id的隐藏域input框的id
         * @param treeDivDomId      树形展开区域的DIV的id
         * @param showCodeInputDomId 用于联动的提供方编码显示时取值的input框的id
         */
        initRegionDeptTreeSelect: function (treeDomId, nameInputDomId, codeInputDomId, treeDivDomId, showCodeInputDomId) {
            var setting = {
                check: {
                    enable: true,
                    chkStyle: "radio",  //单选框
                    radioType: "all",   //对所有节点设置单选
                    chkboxType:  { "Y": "", "N": "" } //取消父子关联
                },
                async: {
                    enable: true,
                    url: basePathJS + "/sysRegionDept/authorityList",
                    autoParam: ["fcode"],
                    dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
                        var params = [];
                        var nodeObjs = childNodes.content.vo;
                        if (!nodeObjs) {
                            return null;
                        }
                        for (var i in nodeObjs) {
                            params[i] = {
                                'id': nodeObjs[i].id,
                                'name': nodeObjs[i].regionDeptName,
                                'fcode': nodeObjs[i].regionDeptCode,
                                'isParent': (nodeObjs[i].hasLeaf == "1" ? true : false),
                                'structureName':nodeObjs[i].structureName
                            }
                        }
                        return params;
                    }
                },
                callback: {
                    onClick: function (e, treeId, treeNode) { //点击节点，选中并触发oncheck事件
                        var zTree = $.fn.zTree.getZTreeObj(treeId);
                        zTree.checkNode(treeNode,true,true,true);
                    },
                    onCheck: function (e, treeId, treeNode) { //点击radio，获取目录类别的全名称，显示到输入框中
                        $('#' + nameInputDomId).val(treeNode.structureName);
                        $('#' + codeInputDomId).val(treeNode.id);
                        $('#' + showCodeInputDomId).val(treeNode.fcode);
                    }
                }
            };

            $('#' + nameInputDomId).click(function () {
                $.fn.zTree.init($("#" + treeDomId), setting);
                var cityOffset = $("#" + nameInputDomId).offset();
                $("#" + treeDivDomId).css({
                    left: cityOffset.left + "px",
                    top: cityOffset.top + $("#" + nameInputDomId).outerHeight() + "px"
                }).slideDown("fast");
                $("body").bind("mousedown", function (event) {
                    if (!(event.target.id == "menuBtn" || event.target.id == treeDivDomId || $(event.target).parents("#" + treeDivDomId).length > 0)) {
                        $("#" + treeDivDomId).fadeOut("fast");
                        $("body").unbind("mousedown");
                    }
                });
            })

        },

        /**
         * 获取区域类别的下拉树对象
         * @param treeDomId         ztree对象的id
         * @param nameInputDomId    显示选中目录类别的名称的input框的id
         * @param codeInputDomId    存储选中目录类别的id的隐藏域input框的id
         * @param treeDivDomId      树形展开区域的DIV的id
         */
        initRegionTreeSelect: function (treeDomId, nameInputDomId, codeInputDomId, treeDivDomId , multiple) {
            var selectRegionCodes = "";
            var chkStyle = multiple ? "checkbox" : "radio";
            var setting = {
                async: {
                    enable: true,
                    url: basePathJS + "/sysRegion/getRegionSelectDataList",
                    autoParam: ["regionCode"],
                    dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
                        var params = [];
                        var nodeObjs = childNodes.content.selectData;
                        if (!nodeObjs) {
                            return null;
                        }
                        for (var i in nodeObjs) {
                            params[i] = {
                                'id': nodeObjs[i].id,
                                'name': nodeObjs[i].regionName,
                                'regionCode': nodeObjs[i].regionCode,
                                'isParent': (nodeObjs[i].hasLeaf == "1" ? true : false)
                            }
                        }
                        return params;
                    }
                },
                check: {enable: true,chkStyle: "radio",chkboxType: { "Y":"s","N":"s"},radioType: "all"},
                callback: {
                    beforeClick: function (treeId, treeNode) { //如果点击的节点还有下级节点，则展开该节点
                        var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId);
                        if (treeNode.isParent) {
                            if (treeNode.open) {
                                zTreeObj.expandNode(treeNode, false);
                            } else {
                                zTreeObj.expandNode(treeNode, true);
                            }
                            return false;
                        } else {
                            return true;
                        }
                    },
                    onCheck: function (e, treeId, treeNode) { //选中节点，获取区域类别的全名称，显示到输入框中
                        $('#' + nameInputDomId).val(treeNode.name);
                        if(multiple){
                            if (selectRegionCodes == "") {
                                selectRegionCodes = treeNode.regionCode;
                            } else {
                                selectRegionCodes += "," + treeNode.regionCode;
                            }
                        }else{
                            selectRegionCodes = treeNode.regionCode;
                        }
                        $('#' + codeInputDomId).val(selectRegionCodes);
                        initDeptSelectDataList(selectRegionCodes);
                    }
                }
            };
            function initDeptSelectDataList(dd){
                $.commonAjax({
                    // url: basePathJS + "/system/dept/getDeptSelectDataList?regionCode=510100&onlyRoot=" + onlyRoot +"&excludeRoot="+ excludeRoot +"&checkIsLeaf="+ checkIsLeaf,
                    url: basePathJS + "/system/dept/getDeptSelectDataList",
                    data:{
                        regionCode : dd,
                        onlyRoot : "1"
                    },
                    success: function (result) {
                        if (result.state) {
                            var selectData = result.content.selectData;
                            var data = [];
                            if(selectData && selectData.length > 0){
                                for(var i in selectData){
                                    var id = selectData[i].id;
                                    var text = selectData[i].deptName;
                                    if(id && text){
                                        data.push({id: id, text: text})
                                    }
                                }
                            }
                            $("#fid").html("")
                            $("#fid").select2({
                                data: data,
                                placeholder : '',
                                allowClear: true
                            });
                            $("#fid").change(function(){
                                $("#fname").val($("#select2-fid-container").attr("title"))
                            })
                            $("#fid").val('').trigger("change");
                        }
                    }
                });
            }

            $('#' + nameInputDomId).click(function () {
                $.fn.zTree.init($("#" + treeDomId), setting);
                var cityOffset = $("#" + nameInputDomId).offset();
                $("#" + treeDivDomId).css({
                    left: cityOffset.left + "px",
                    top: cityOffset.top + $("#" + nameInputDomId).outerHeight() + "px"
                }).slideDown("fast");
                $("body").bind("mousedown", function (event) {
                    if (!(event.target.id == "menuBtn" || event.target.id == treeDivDomId || $(event.target).parents("#" + treeDivDomId).length > 0)) {
                        $("#" + treeDivDomId).fadeOut("fast");
                        $("body").unbind("mousedown");
                    }
                });
            })

        },

        /**
         *
         * 获取组织机构的下拉树对象
         * @param treeDomId         ztree对象的id
         * @param nameInputDomId    显示选中目录类别的名称的input框的id
         * @param codeInputDomId    存储选中目录类别的id的隐藏域input框的id
         * @param treeDivDomId      树形展开区域的DIV的id
         * @param multiple          复选还是单选
         * @param param             异步加载url参数
         * @param selects           初始化选中值
         */
        initDeptTreeSelect: function (treeDomId, nameInputDomId, codeInputDomId, treeDivDomId, multiple, param, selects) {
            var chkStyle = multiple ? "checkbox" : "radio";
            if(!param || typeof param != 'object') param = {};
            if(!selects || !$.isArray(selects)) selects = [];
            var setting = {
                async: {
                    enable: true,
                    url: basePathJS + "/system/dept/getDeptSelectDataList",
                    autoParam: ["id"],
                    otherParam: param,
                    dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
                        var params = [];
                        var nodeObjs = childNodes.content.selectData;
                        if (!nodeObjs) {
                            return null;
                        }
                        for (var i in nodeObjs) {
                            params[i] = {
                                'id': nodeObjs[i].id,
                                'name': nodeObjs[i].deptName,
                                'fid': nodeObjs[i].fid,
                                'checked': selects.indexOf(nodeObjs[i].id) >= 0,
                                'isParent': (nodeObjs[i].isLeaf ? false : true)
                            }
                        }
                        return params;
                    }
                },
                check: {enable: true,chkStyle: chkStyle,chkboxType: { "Y":"ps","N":"ps"}},
                callback: {
                    beforeClick: function (treeId, treeNode) { //如果点击的节点还有下级节点，则展开该节点
                        var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId);
                        if (treeNode.isParent) {
                            if (treeNode.open) {
                                zTreeObj.expandNode(treeNode, false);
                            } else {
                                zTreeObj.expandNode(treeNode, true);
                            }
                            return false;
                        } else {
                            return true;
                        }
                    },
                    onCheck: function (e, treeId, treeNode) { //选中节点，获取区域类别的名称，显示到输入框中
                        var ids = [], names = [];
                        if(multiple){
                            var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId), selectNodes = zTreeObj.getCheckedNodes(true)
                            var resultList = [];
                            var tempList = [];
                            for(var i in selectNodes){
                                var node = selectNodes[i];
                                if(node.check_Child_State!=1){
                                    tempList.push(node);
                                }
                            }
                            if(tempList.length > 0){
                                for(var i in tempList){
                                    var flag = false;
                                    var tempNode = tempList[i];
                                    for(var j in tempList){
                                        if(tempNode.fid == tempList[j].id){
                                            flag = true;
                                            break;
                                        }
                                    }
                                    if(!flag){
                                        resultList.push(tempNode);
                                    }
                                }
                            }
                            for(var i in resultList){
                                var selectedNode = resultList[i];
                                var id = selectedNode.id;
                                var name = selectedNode.name;
                                if(id && name){
                                    ids.push(id);
                                    names.push(name);
                                }
                            }
                        }else{
                            var id = treeNode.id;
                            var name = treeNode.name;
                            if(id && name){
                                ids.push(id);
                                names.push(name);
                            }
                        }
                        $('#' + codeInputDomId).val(ids.join(","));
                        if(nameInputDomId){
                            $('#' + nameInputDomId).val(names.join(","));
                        }
                    }
                }
            };
            if(nameInputDomId){
                $('#' + nameInputDomId).click(function () {
                    $.fn.zTree.init($("#" + treeDomId), setting);
                    var cityOffset = $("#" + nameInputDomId).offset();
                    $("#" + treeDivDomId).css({
                        left: cityOffset.left + "px",
                        top: cityOffset.top + $("#" + nameInputDomId).outerHeight() + "px"
                    }).slideDown("fast");
                    $("body").bind("mousedown", function (event) {
                        if (!(event.target.id == "menuBtn" || event.target.id == treeDivDomId || $(event.target).parents("#" + treeDivDomId).length > 0)) {
                            $("#" + treeDivDomId).fadeOut("fast");
                            $("body").unbind("mousedown");
                        }
                    });
                })
            }else{
                $.fn.zTree.init($("#" + treeDomId), setting);
            }
        },

        /**
         * 用户管理
         * 获取区域类别的下拉树对象
         * @param treeDomId         ztree对象的id
         * @param nameInputDomId    显示选中目录类别的名称的input框的id
         * @param codeInputDomId    存储选中目录类别的id的隐藏域input框的id
         * @param treeDivDomId      树形展开区域的DIV的id
         */
        initUserRegionTreeSelect: function (treeDomId, nameInputDomId, codeInputDomId, treeDivDomId , multiple) {
            var selectRegionCodes = "";
            var setting = {
                async: {
                    enable: true,
                    url: basePathJS + "/sysRegion/getRegionSelectDataList",
                    autoParam: ["regionCode"],
                    dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
                        var params = [];
                        var nodeObjs = childNodes.content.selectData;
                        if (!nodeObjs) {
                            return null;
                        }
                        for (var i in nodeObjs) {
                            params[i] = {
                                'id': nodeObjs[i].id,
                                'name': nodeObjs[i].regionName,
                                'regionCode': nodeObjs[i].regionCode,
                                'isParent': (nodeObjs[i].hasLeaf == "1" ? true : false)
                            }
                        }
                        return params;
                    }
                },
                check: {enable: true,chkStyle: "radio",chkboxType: { "Y":"s","N":"s"},radioType: "all"},
                callback: {
                    beforeClick: function (treeId, treeNode) { //如果点击的节点还有下级节点，则展开该节点
                        var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId);
                        if (treeNode.isParent) {
                            if (treeNode.open) {
                                zTreeObj.expandNode(treeNode, false);
                            } else {
                                zTreeObj.expandNode(treeNode, true);
                            }
                            return false;
                        } else {
                            return true;
                        }
                    },
                    onCheck: function (e, treeId, treeNode) { //选中节点，获取区域类别的全名称，显示到输入框中
                        $('#' + nameInputDomId).val(treeNode.name);
                        if(multiple){
                            if (selectRegionCodes == "") {
                                selectRegionCodes = treeNode.regionCode;
                            } else {
                                selectRegionCodes += "," + treeNode.regionCode;
                            }
                        }else{
                            selectRegionCodes = treeNode.regionCode;
                        }
                        $('#' + codeInputDomId).val(selectRegionCodes);
                        initDeptTreeSelect('treeDemo','deptName','deptId','menuContent',selectRegionCodes);
                    }
                }
            };


            $('#' + nameInputDomId).click(function () {
                $.fn.zTree.init($("#" + treeDomId), setting);
                var cityOffset = $("#" + nameInputDomId).offset();
                $("#" + treeDivDomId).css({
                    left: cityOffset.left + "px",
                    top: cityOffset.top + $("#" + nameInputDomId).outerHeight() + "px"
                }).slideDown("fast");
                $("body").bind("mousedown", function (event) {
                    if (!(event.target.id == "menuBtn" || event.target.id == treeDivDomId || $(event.target).parents("#" + treeDivDomId).length > 0)) {
                        $("#" + treeDivDomId).fadeOut("fast");
                        $("body").unbind("mousedown");
                    }
                });
            })
            /**
             * 获取组织机构下拉树
             * @param treeDomId
             * @param nameInputDomId
             * @param codeInputDomId
             * @param treeDivDomId
             * @param multiple
             * @param dd
             */
            function initDeptTreeSelect(treeDomId, nameInputDomId, codeInputDomId, treeDivDomId,dd, multiple) {
                $("#" + nameInputDomId).val("");
                $("#" + codeInputDomId).val("");
                var selectIds = "";
                var setting = {
                    async: {
                        enable: true,
                        url: basePathJS + "/system/dept/getDeptSelectDataList?regionCode=" + dd,
                        autoParam: ["id"],
                        dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
                            var params = [];
                            var nodeObjs = childNodes.content.selectData;
                            if (!nodeObjs) {
                                return null;
                            }
                            for (var i in nodeObjs) {
                                params[i] = {
                                    'id': nodeObjs[i].id,
                                    'name': nodeObjs[i].deptName,
                                    'isParent': (nodeObjs[i].isLeaf ? false : true)
                                }
                            }
                            return params;
                        }
                    },
                    check: {enable: true,chkStyle: "radio",chkboxType: { "Y":"s","N":"s"},radioType: "all"},
                    callback: {
                        beforeClick: function (treeId, treeNode) { //如果点击的节点还有下级节点，则展开该节点
                            var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId);
                            if (treeNode.isParent) {
                                if (treeNode.open) {
                                    zTreeObj.expandNode(treeNode, false);
                                } else {
                                    zTreeObj.expandNode(treeNode, true);
                                }
                                return false;
                            } else {
                                return true;
                            }
                        },
                        onCheck: function (e, treeId, treeNode) { //选中节点，获取区域类别的名称，显示到输入框中
                            $('#' + nameInputDomId).val(treeNode.name);
                            if(multiple){
                                if (selectIds == "") {
                                    selectIds = treeNode.id;
                                } else {
                                    selectIds += "," + treeNode.id;
                                }
                            }else{
                                selectIds = treeNode.id;
                            }
                            $('#' + codeInputDomId).val(selectIds);
                        }
                    }
                };

                $('#' + nameInputDomId).click(function () {
                    $.fn.zTree.init($("#" + treeDomId), setting);
                    var cityOffset = $("#" + nameInputDomId).offset();
                    $("#" + treeDivDomId).css({
                        left: cityOffset.left + "px",
                        top: cityOffset.top + $("#" + nameInputDomId).outerHeight() + "px"
                    }).slideDown("fast");
                    $("body").bind("mousedown", function (event) {
                        if (!(event.target.id == "menuBtn" || event.target.id == treeDivDomId || $(event.target).parents("#" + treeDivDomId).length > 0)) {
                            $("#" + treeDivDomId).fadeOut("fast");
                            $("body").unbind("mousedown");
                        }
                    });
                })

            }

        }

    });



    $.fn.extend({
        /*  参数
         startPage - number - 初始化当前页 visiblePages - number - 分页栏可视页数 pageSize - number 每页显示行数 url - string ajax取数据地址 parms - object ajax参数 row - object:{rowHtml: "",
         formatter: function(value){return formattedVal;}} - 行html及属性值格式
         */
        // customRowsPagination: function (startPage, visiblePages, pageSize, url, parms, row, minHeight, callBack) {
        //     var customRowsPaginationOpt = $(this)._initOpt(startPage, visiblePages, pageSize, url, parms, row, minHeight);
        //     if (customRowsPaginationOpt) {
        //         var opt = {
        //             totalPages: customRowsPaginationOpt.totalPages,
        //             startPage: customRowsPaginationOpt.page,
        //             visiblePages: customRowsPaginationOpt.visiblePages,
        //             href: false,//如果是页面刷新, 则设置该地址参数 如：?page={{number}} ,表示刷新当前页面并传递页数参数, {{number}}会被替换成页数, 变量由hrefVariable定义.如果要使用ajax,请设置为false,在onPageClick事件里自己实现
        //             hrefVariable: '{{number}}',
        //             first: '首页',
        //             prev: '上一页',
        //             next: '下一页',
        //             last: '尾页',
        //             loop: false, //是否循环显示页数
        //             paginationClass: 'pagination',
        //             nextClass: 'next',
        //             prevClass: 'prev',
        //             lastClass: 'last',
        //             firstClass: 'first',
        //             pageClass: 'page',
        //             activeClass: 'active',
        //             disabledClass: 'disabled',
        //             onPageClick: $.proxy(function (event, page) {
        //                 if (this.target) {
        //                     var customRowsPaginationOpt = this.target._initOpt(page, this.visiblePages, this.pageSize, this.url, this.parms, this.row);
        //                     if (customRowsPaginationOpt) {
        //                         this.target._showRows(customRowsPaginationOpt);
        //                         if ($("#go_page").val()) {
        //                             var goPage = parseInt($("#go_page").val());
        //                             $("#sure_go_page").unbind('click');
        //                             $("#sure_go_page").one('click', $.proxy(function (e) {
        //                                     this.target._go_page(goPage);
        //                                 }, customRowsPaginationOpt)
        //                             );
        //                         }
        //                         if (callBack && typeof callBack == "function") {
        //                             callBack(customRowsPaginationOpt);
        //                         }
        //                     }
        //                     // 跳转页面再次绑定输入框的事件
        //                     $("#go_page").keydown(function (event) {
        //                         return event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 37 || event.keyCode == 39 || (event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105);
        //                     }).bind("input propertychange", function (e) {
        //                         $("#sure_go_page").unbind('click');
        //                         $(this).val($(this).val().replace(/^0+/g, ""));
        //                         if ($(this).val()) {
        //                             var goPage = parseInt($(this).val());
        //                             if (goPage <= customRowsPaginationOpt.totalPages && goPage != customRowsPaginationOpt.target.data("currentPage")) {
        //                                 $("#sure_go_page").attr("disabled", false);
        //                                 $("#sure_go_page").one('click', function (e) {
        //                                     customRowsPaginationOpt.target._go_page(goPage);
        //                                 });
        //                             } else {
        //                                 $("#sure_go_page").attr("disabled", true);
        //                             }
        //                         } else {
        //                             $("#sure_go_page").attr("disabled", true);
        //                         }
        //                     }).keyup(function (event) {
        //                         if (event.keyCode == 13) {
        //                             $("#sure_go_page").trigger("click");
        //                         }
        //                     });
        //                 }
        //             }, customRowsPaginationOpt)
        //         };
        //         //销毁已存在的分页和跳转模块
        //         if(customRowsPaginationOpt.pagination.data("twbs-pagination")){
        //             //得到更新后的跳转模块
        //             var paginationHtml = customRowsPaginationOpt.pagination.find("div[id='paginationTotal']");
        //             customRowsPaginationOpt.pagination.twbsPagination("destroy");
        //             customRowsPaginationOpt.pagination.append(paginationHtml);
        //         }
        //         var paginator = customRowsPaginationOpt.pagination.twbsPagination(opt);
        //         $(this).find("div[name='pagination'] ul[class='pagination']").addClass("pull-right");
        //         $(this).data("paginator", paginator);
        //         $(this)._showRows(customRowsPaginationOpt);
        //         // 第一次进来绑定输入框的事件
        //         $("#go_page").keydown(function (event) {
        //             return event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 37 || event.keyCode == 39 || (event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105);
        //         }).bind("input propertychange", function (e) {
        //             $("#sure_go_page").unbind('click');
        //             $(this).val($(this).val().replace(/^0+/g, ""));
        //             if ($(this).val()) {
        //                 var goPage = parseInt($(this).val());
        //                 if (goPage <= customRowsPaginationOpt.totalPages && goPage != customRowsPaginationOpt.target.data("currentPage")) {
        //                     $("#sure_go_page").attr("disabled", false);
        //                     $("#sure_go_page").one('click', function (e) {
        //                         customRowsPaginationOpt.target._go_page(goPage);
        //                     });
        //                 } else {
        //                     $("#sure_go_page").attr("disabled", true);
        //                 }
        //             } else {
        //                 $("#sure_go_page").attr("disabled", true);
        //             }
        //         }).keyup(function (event) {
        //             if (event.keyCode == 13) {
        //                 $("#sure_go_page").trigger("click");
        //             }
        //         });
        //         $("#sure_go_page").attr("disabled", true);
        //     }
        //
        // },
        // _initOpt: function (startPage, visiblePages, pageSize, url, parms, row, minHeight) {
        //     var columns = [];
        //     var totalPages = 0;
        //     var total = 0;
        //     startPage = startPage && typeof startPage == 'number' && startPage > 0 ? startPage : 1;
        //     visiblePages = visiblePages && typeof visiblePages == 'number' && visiblePages > 0 ? visiblePages : 5;
        //     pageSize = pageSize && typeof pageSize == 'number' && pageSize > 0 ? pageSize : 10;
        //     row = row && typeof row == 'string' ? {rowHtml: row} : row;
        //     if (url) {
        //         if (parms) {
        //             if ($.isArray(parms)) {
        //                 var tempParms = [];
        //                 for (var i in parms) {
        //                     if (parms[i].name != 'offset' && parms[i].name != 'limit') {
        //                         tempParms.push(parms[i]);
        //                     }
        //                 }
        //                 tempParms.push(parms.push({name: 'offset', value: pageSize * (startPage - 1)}));
        //                 tempParms.push({name: 'limit', value: pageSize});
        //                 delete parms;
        //                 parms = tempParms;
        //             } else if (typeof parms == 'object') {
        //                 $.extend(parms, {
        //                     offset: pageSize * (startPage - 1),
        //                     limit: pageSize
        //                 });
        //             } else if (typeof parms == 'string') {
        //                 var tempParms = {};
        //                 var keyvals = parms.split("&");
        //                 if (keyvals && keyvals.length > 0) {
        //                     for (var i in keyvals) {
        //                         var keyval = keyvals[i];
        //                         if (keyval) {
        //                             var key_val = keyval.split("=");
        //                             if (key_val && key_val.length == 2) {
        //                                 tempParms[key_val[0]] = key_val[1];
        //                             }
        //                         }
        //                     }
        //                 }
        //                 delete parms;
        //                 parms = $.extend(tempParms, {
        //                     offset: pageSize * (startPage - 1),
        //                     limit: pageSize
        //                 });
        //             } else parms = {offset: pageSize * (startPage - 1), limit: pageSize};
        //         } else parms = {offset: pageSize * (startPage - 1), limit: pageSize};
        //         $.commonAjax({
        //             url: url,
        //             async: false,
        //             data: parms,
        //             success: function (json) {
        //                 if (!$.checkSessionInvalid(json)) {
        //                     if (json && json.status) {
        //                         columns = json['rows'] && $.isArray(json['rows']) ? json['rows'] : [];
        //                         total = json['total'] && typeof json['total'] == 'number' ? json['total'] : 0;
        //                         totalPages = Math.ceil(total / pageSize);
        //                     }
        //                 }
        //             }
        //         }, true);
        //     }
        //
        //     $(document).ready(function () {
        //         /*数据集条数*/
        //         $("#dataEm").html(total);
        //     });
        //
        //     if (totalPages == 0 || columns.length == 0) {//如果没有数据,则显示未找到数据
        //         $(this).html("<div name='no_data_found' style='color: red'>没有数据可展示！</div>");
        //         return;
        //     } else if ($(this).find("div[name='no_data_found']").length > 0) $(this).find("div[name='no_data_found']").remove();
        //     var rows;
        //     if ($(this).find("div[name='rows']").length > 0) {
        //         rows = $(this).find("div[name='rows']");
        //         rows.html("");
        //     } else {
        //         rows = $("<div name='rows'></div>");
        //         if(minHeight) rows.css("min-height", minHeight);
        //         $(this).append(rows);
        //     }
        //     var pagination;
        //     if ($(this).find("div[name='pagination']").length > 0) {
        //         //更新跳转模块的html
        //         $("#paginationTotal").html("跳转至&nbsp;&nbsp;<input id='go_page' type='text' class='form-control input-sm' maxlength='" + totalPages.toString().length + "' style='ime-mode:disabled;width: 50px;display:inline'>&nbsp;&nbsp;页&nbsp;&nbsp;共&nbsp;" + totalPages + "&nbsp;页&nbsp;" + total + "&nbsp;条&nbsp;&nbsp;<a id='sure_go_page' class='btn btn-primary btn-sm'>确定</a>");
        //         pagination = $(this).find("div[name='pagination']");
        //     } else {
        //         $(this).append($("<div class='row'><div name='pagination' class='pull-right'><div class='pull-right form-inline' id='paginationTotal' style='margin: 24px 0 24px 10px;'>跳转至&nbsp;&nbsp;<input id='go_page' type='text' class='form-control input-sm' maxlength='" + totalPages.toString().length + "' style='ime-mode:disabled;width: 50px;display:inline'>&nbsp;&nbsp;页&nbsp;&nbsp;共&nbsp;" + totalPages + "&nbsp;页&nbsp;" + total + "&nbsp;条&nbsp;&nbsp;<a id='sure_go_page' class='btn btn-primary btn-sm'>确定</a></div></div></div>"));
        //         pagination = $(this).find("div[name='pagination']");
        //     }
        //     if (startPage > totalPages) startPage = totalPages;
        //     var customRowsPaginationOpt = {
        //         page: startPage,
        //         visiblePages: visiblePages,
        //         pageSize: pageSize,
        //         totalPages: totalPages,
        //         url: url,
        //         parms: parms,
        //         row: row,
        //         columns: columns,
        //         target: $(this),
        //         rows: rows,
        //         pagination: pagination
        //     };
        //     return customRowsPaginationOpt;
        // },
        // _showRows: function (customRowsPaginationOpt) {
        //     var paginationObj = $(this).data('paginator').data("twbs-pagination");//暂时未用分页对象的方法
        //     if (paginationObj) {
        //         var rowHtml = customRowsPaginationOpt.row['rowHtml'];
        //         var formatter = customRowsPaginationOpt.row['formatter'];
        //         var columns = customRowsPaginationOpt.columns;
        //         var rows = customRowsPaginationOpt.rows;
        //         if (rowHtml && columns.length > 0) {
        //             for (var i in columns) {
        //                 var tempRowHtml = rowHtml;
        //                 var column = columns[i];
        //                 for (var key in column) {
        //                     var val = column[key];
        //                     if (formatter && typeof formatter == 'object' && formatter[key] && typeof formatter[key] == 'function') val = formatter[key](val, column);
        //                     tempRowHtml = tempRowHtml.replace(new RegExp("#\\[" + key + "\\]", "g"), val);
        //                 }
        //                 rows.append(tempRowHtml);
        //             }
        //         }
        //         $(this).data("currentPage", customRowsPaginationOpt.page);
        //         $(this).data("columns", customRowsPaginationOpt.columns);
        //         $("#sure_go_page").attr("disabled", $("#go_page").val() ? customRowsPaginationOpt.page == parseInt($("#go_page").val()) : true);
        //     }
        // },
        // _go_page: function (goPage) {
        //     var currentPage = $(this).data("currentPage");
        //     if (typeof currentPage == 'number' && typeof goPage == 'number' && goPage > 0 && currentPage != goPage) {
        //         $(this).data('paginator').data("twbs-pagination").show(goPage);
        //     }
        // },
        customTable: function (options) {
            var options = $.extend({
                sidePagination: 'server',
                queryParamsType: '',
                method: 'post',
                url: '',
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                cache: false,
                striped: true,
                pagination: true,
                pageSize: 10,
                pageList: [10, 25, 50, 100, 200],
                paginationVAlign: "bottom",
                paginationHAlign: "right",
                toolbarAlign: "left",
                toolbar: ".toolbar",
                buttonsAlign: "right",
                showToggle: false,
                showPaginationSwitch: false,
                search: false,
                // smartDisplay: true,
                // showColumns: true,
                // showRefresh: true,
                // mobileResponsive: true,
                minWidth: 992,
                minimumCountColumns: 1,
                // clickToSelect: true,
                columns: []
                /*responseHandler: function (json) {
                 $.MessagePusher.loadMsgToShow();
                 if (!$.checkSessionInvalid(json)) {
                 if (json && json.state) {
                 return json;
                 }
                 }
                 return {rows: [], total: 0};
                 }*/
            }, options);

            if (options.height <= 0) {
                options.height = 500;
            }
            $(this).bootstrapTable(options);
            $(this).on('post-body.bs.table', function () {
                if (options.toolbar == false) {
                    $(this).parent().parent().parent().find(".fixed-table-toolbar").remove();
                }
                if (!options.height || options.height == 'auto') {
                    var height = 0;
                    $(this).find("tr").each(function (i, item) {
                        height += $(item).height();
                    });
                    var minHeight = (document.body.clientHeight - ($(".breadcrumb").length ? ($(".breadcrumb").height() + 25) : 0) - ($(".searchBar").length ? $(".searchBar").height() : 0) - ($("#title").length ? ($("#title").height() + 10) : 0) - ($("nav").length ? $("nav").height() : 0) - ($(".fixed-table-toolbar").length ? $(".fixed-table-toolbar").height() : 0) - 160);
                    var minHeight = options.minHeight ? options.minHeight : (document.body.clientHeight - ($(".breadcrumb").length ? ($(".breadcrumb").height() + 25) : 0) - ($(".box-header").length ? ($(".box-header").height() + 20) : 0) - ($(".content-header").length ? ($(".content-header").height() + 10) : 0) - ($("nav").length ? $("nav").height() : 0) - ($(".fixed-table-toolbar").length ? $(".fixed-table-toolbar").height() : 0) - 180);
                    if (height >= minHeight) {
                        $(this).parent().css({"overflow-y": "hidden", height: 'auto'});
                        //$(this).parent().parent().css("margin-bottom",  "87px");
                    } else {
                        $(this).parent().css({"overflow-y": "auto", height: minHeight});
                    }
                    $(this).parent().parent().css("padding-bottom", "0");
                }
            });
        },
        customDateRangePicker: function (options, format, nowDate, callback) {
            format = format ? format : "YYYY-MM-DD HH:mm:ss";
            // format = format ? format : "YYYY-MM-DD";
            options = options && typeof options == 'object' ? options : {};
            var date = nowDate ? nowDate : new Date();
            options = $.extend({
                "singleDatePicker": false,//true 单个时间 false 时间范围
                "showDropdowns": true,//(boolean) 年和月是否显示下拉选择
                "showWeekNumbers": true,//(boolean) 是否显示当前周为一年当中的第几周
                // "timePicker": true,//(boolean) 是否显示时间选择
                // "timePicker24Hour": true,//(boolean) 如果显示时间选择,那么是否以24小时制方式显示小时
                // "timePickerIncrement": 1,//(boolean) 如果显示时间选择,那么小时以多少的增长从0到24;
                // "timePickerSeconds": true,//是否显示秒
                // "autoApply": false,//是否自动确定,如果否,则需要手动确定时间选择
                /*"startDate": null,//设置初始化起始时间
                 "endDate": null,//设置初始化结束时间
                 "dateLimit": {//设置对时间范围的限制,前提singleDatePicker为false,即不是单个时间时有效
                 "days": 7
                 },*/
                "ranges": {//设置快捷范围选择
                    "今天": [
                        moment(date).startOf('days'),
                        moment(date).endOf('days')
                    ],
                    "昨天": [
                        moment(date).subtract(1, 'days').startOf('days'),
                        moment(date).subtract(1, 'days').endOf('days')
                    ],
                    "最近7天": [
                        moment(date).subtract(7, 'days').startOf('days'),
                        moment(date).endOf('days')
                    ],
                    "最近30天": [
                        moment(date).subtract(30, 'days').startOf('days'),
                        moment(date).endOf('days')
                    ],
                    "本月": [
                        moment(date).startOf('months'),
                        moment(date).endOf('months')
                    ],
                    "上月": [
                        moment(date).subtract(1, 'months').startOf('months'),
                        moment(date).subtract(1, 'months').endOf('months')
                    ]
                },
                "locale": {//设置显示格式
                    "format": format,
                    "separator": " 至 ",
                    "applyLabel": "确认",
                    "cancelLabel": "取消",
                    "fromLabel": "从",
                    "toLabel": "到",
                    "customRangeLabel": "自定义",
                    "daysOfWeek": [
                        "日",
                        "一",
                        "二",
                        "三",
                        "四",
                        "五",
                        "六"
                    ],
                    "monthNames": [
                        "一月",
                        "二月",
                        "三月",
                        "四月",
                        "五月",
                        "六月",
                        "七月",
                        "八月",
                        "九月",
                        "十月",
                        "十一月",
                        "十二月"
                    ],
                    "firstDay": 1
                },
                "alwaysShowCalendars": true,
                "autoUpdateInput": false,
                "opens": "right",//时间选择器打开的位置
                "drops": "down",//是向下还是向上打开
                "buttonClasses": "btn btn-sm",//按钮的样式
                "applyClass": "btn-success",//确认按钮的样式
                "cancelClass": "btn-default"//取消按钮的样式
            }, options);
            var iconLineHeight = $(this).parent().height();
            if ($(window).width() < 768) {
                iconLineHeight = $(this).parent().height() / 2;
            }
            $(this).after('<span class="fa fa-calendar form-control-feedback" style="line-height: ' + iconLineHeight + 'px; position: relative; right: 30px" aria-hidden="true"></span>');
            if (options.singleDatePicker == false) $(this).addClass("daterangepicker_input_control");

            if (callback) {
                $(this).daterangepicker(options, callback);
            } else {
                $(this).daterangepicker(options);

                $(this).on('apply.daterangepicker', function (ev, picker) {
                    $(this).val(picker.startDate.format(format) + ' ~ ' + picker.endDate.format(format));
                });
            }
        },
        customDatePicker: function (options, format, nowDate, callback) {
            format = format ? format : "YYYY-MM-DD HH:mm:ss";
            // format = format ? format : "YYYY-MM-DD";
            options = options && typeof options == 'object' ? options : {};
            var date = nowDate ? nowDate : new Date();
            options = $.extend({
                "singleDatePicker": true,//true 单个时间 false 时间范围
                "showDropdowns": true,//(boolean) 年和月是否显示下拉选择
                "showWeekNumbers": true,//(boolean) 是否显示当前周为一年当中的第几周
                "timePicker": true,//(boolean) 是否显示时间选择
                "timePicker24Hour": true,//(boolean) 如果显示时间选择,那么是否以24小时制方式显示小时
                "timePickerIncrement": 1,//(boolean) 如果显示时间选择,那么小时以多少的增长从0到24;
                "timePickerSeconds": true,//是否显示秒
                // "autoApply": false,//是否自动确定,如果否,则需要手动确定时间选择
                /*"startDate": null,//设置初始化起始时间
                 "endDate": null,//设置初始化结束时间
                 "dateLimit": {//设置对时间范围的限制,前提singleDatePicker为false,即不是单个时间时有效
                 "days": 7
                 },*/
                //"ranges": {//设置快捷范围选择
                //    "今天": [
                //        moment(date).startOf('days'),
                //        moment(date).endOf('days')
                //    ],
                //    "昨天": [
                //        moment(date).subtract(1, 'days').startOf('days'),
                //        moment(date).subtract(1, 'days').endOf('days')
                //    ],
                //    "最近7天": [
                //        moment(date).subtract(7, 'days').startOf('days'),
                //        moment(date).endOf('days')
                //    ],
                //    "最近30天": [
                //        moment(date).subtract(30, 'days').startOf('days'),
                //        moment(date).endOf('days')
                //    ],
                //    "本月": [
                //        moment(date).startOf('months'),
                //        moment(date).endOf('months')
                //    ],
                //    "上月": [
                //        moment(date).subtract(1, 'months').startOf('months'),
                //        moment(date).subtract(1, 'months').endOf('months')
                //    ]
                //},
                "locale": {//设置显示格式
                    "format": format,
                    "separator": " 至 ",
                    "applyLabel": "确认",
                    "cancelLabel": "取消",
                    "fromLabel": "从",
                    "toLabel": "到",
                    "customRangeLabel": "自定义",
                    "daysOfWeek": [
                        "日",
                        "一",
                        "二",
                        "三",
                        "四",
                        "五",
                        "六"
                    ],
                    "monthNames": [
                        "一月",
                        "二月",
                        "三月",
                        "四月",
                        "五月",
                        "六月",
                        "七月",
                        "八月",
                        "九月",
                        "十月",
                        "十一月",
                        "十二月"
                    ],
                    "firstDay": 1
                },
                "alwaysShowCalendars": true,
                "autoUpdateInput": false,
                "opens": "right",//时间选择器打开的位置
                "drops": "down",//是向下还是向上打开
                "buttonClasses": "btn btn-sm",//按钮的样式
                "applyClass": "btn-success",//确认按钮的样式
                "cancelClass": "btn-default"//取消按钮的样式
            }, options);
            //var iconLineHeight = $(this).parent().height();
            //if ($(window).width() < 768) {
            //    iconLineHeight = $(this).parent().height() / 2;
            //}
            //$(this).after('<span class="fa fa-calendar form-control-feedback" style="line-height: ' + iconLineHeight + 'px" aria-hidden="true"></span>');
            //if (options.singleDatePicker == false) $(this).addClass("daterangepicker_input_control");

            if (callback) {
                $(this).daterangepicker(options, callback);
            } else {
                $(this).daterangepicker(options);

                $(this).on('apply.daterangepicker', function (ev, picker) {
                    $(this).val(picker.startDate.format(format));
                });
            }
        },
        // customSelectPicker: function (opt, multiNum, dropdownDataRenderer) {
        //     if (multiNum) $(this).attr("multiple", true);
        //     else multiNum = false;
        //     var baseOpt = {
        //         selectOnTab: false,
        //         dropdownAlignRight: false,
        //         liveSearch: true,
        //         liveSearchPlaceholder: '查找',
        //         liveSearchNormalize: false,
        //         actionsBox: typeof  multiNum == 'number' && multiNum > 1,
        //         selectAllText: '全选',
        //         deselectAllText: '取消',
        //         doneButton: false,
        //         doneButtonText: '关闭',
        //         multipleSeparator: ',',
        //         container: false,//appends the select to a specific element or selector, e.g., container: 'body' | '.main-body'
        //         countSelectedText: '{1}项中的{0}项被选中',//sets the format for the text displayed when selectedTextFormat is count or count > #. {0} is the selected amount. {1} is total available for selection.
        //         dropupAuto: false,//checks to see which has more room, above or below. If the dropup has enough room to fully open normally, but there is more room above, the dropup still opens normally. Otherwise, it becomes a dropup. If dropupAuto is set to false, dropups must be called manually.
        //         hideDisabled: false,//removes disabled options and optgroups from the menu data-hide-disabled: true
        //         title: '请选择',//Set the default text for bootstrap-select
        //         width: 'auto',//'auto' | '#px' | '#%' | null (where # is an integer)
        //         maxOptions: multiNum,//integer | false, When set and in a multi
        //         size: 5,//'auto' | integer | false
        //         showSubtext: false, //subtext associated with a selected option will be displayed in the button
        //         showIcon: true,//Display icon(s) associated with selected option(s) in the button. If false, icons will not be displayed in the button.
        //         showContent: true,//Display custom HTML associated with selected option(s) in the button. If false, the option value will be displayed instead.
        //         styleBase: 'btn',
        //         style: 'btn-default', //apply a class to the button, see bootstrap buttons styles
        //         header: false,//adds a header to the top of the menu; includes a close button by default
        //         mobile: false,//enables the device's native menu for select menus
        //         selectedTextFormat: 'values' //values,count,count > X: values A comma delimited list of selected values. (default); count If one item is selected, then the value is shown, if more than one is selected then the number of selected items is displayed, e.g. 2 of 6 selected;count > x Where X is the number of items selected when the display format changes from values to count
        //     };
        //     if (opt && typeof opt == 'object' && !$.isArray(opt)) {
        //         $.extend(baseOpt, opt);
        //     }
        //     $(this).selectpicker(baseOpt);
        //     $(this).renderSelectPickerDropDownData(dropdownDataRenderer);
        // },
        // renderSelectPickerDropDownData: function (dropdownDataRenderer) {
        //     var selector = $(this);
        //     if (!dropdownDataRenderer || typeof dropdownDataRenderer != 'object') dropdownDataRenderer = {};
        //     if(dropdownDataRenderer.url && (!selector.data('dropdownDataRenderer') || selector.data('dropdownDataRenderer').url != dropdownDataRenderer.url || JSON.stringify(selector.data('dropdownDataRenderer').param ? selector.data('dropdownDataRenderer').param : {}) != JSON.stringify(dropdownDataRenderer.param ? dropdownDataRenderer.param : {})) ){
        //         $.commonAjax({
        //             url: dropdownDataRenderer.url,
        //             async: dropdownDataRenderer.async == false ? dropdownDataRenderer.async : true,
        //             data: dropdownDataRenderer.param ? dropdownDataRenderer.param : {},
        //             success: function (json) {
        //                 if (!$.checkSessionInvalid(json)) {
        //                     if (json.status) {
        //                         dropdownDataRenderer.dropdownDatas = json.rows;
        //                         selector._initSelectPicker(dropdownDataRenderer);
        //                     }
        //                 }
        //             }
        //         });
        //     }else selector._initSelectPicker(dropdownDataRenderer);
        // },
        // _initSelectPicker: function(dropdownDataRenderer){
        //     var selector = $(this);
        //     if(selector.data('dropdownDataRenderer')) dropdownDataRenderer = $.extend(selector.data('dropdownDataRenderer'), dropdownDataRenderer);
        //     var datas = dropdownDataRenderer["dropdownDatas"],
        //         valueKey = dropdownDataRenderer["valueKey"] ? dropdownDataRenderer["valueKey"] : "value",
        //         textKey = dropdownDataRenderer["textKey"] ? dropdownDataRenderer["textKey"] : "text",
        //         initVal = dropdownDataRenderer['initVal'],
        //         filter = dropdownDataRenderer["dataFilter"];
        //     if (datas && valueKey && textKey) {
        //         selector.html("");
        //         for (var i in datas) {
        //             var data = datas[i];
        //             var isNeed = true;
        //             if (filter && typeof filter == 'object') {
        //                 for (var key in filter) {
        //                     if (filter[key] != data[key]) {
        //                         isNeed = false;
        //                         break;
        //                     }
        //                 }
        //             }
        //             if (!isNeed) continue;
        //             var value = data[valueKey];
        //             var text = data[textKey];
        //             selector.append('<option value="' + value + '">' + text + '</option>');
        //         }
        //         selector.selectpicker("refresh");
        //     }
        //     selector.selectpicker("val", initVal);
        //     selector.data('dropdownDataRenderer', dropdownDataRenderer);
        // },

        //自定义向导组件
        customSmartWizard: function (options) {

            var options = $.extend({
                selected: 0,
                theme: 'dots',
                transitionEffect: 'fade',
                showStepURLhash: true,
                keyNavigation: false,
                toolbarSettings: {toolbarPosition: 'none'}
            }, options);

            // Step show event
            $(this).on("showStep", function (e, anchorObject, stepNumber, stepDirection, stepPosition) {
                //alert("You are on step "+stepNumber+" now");

                //todo
                var submitBtn = parent.$(".layui-layer-btn2");
                submitBtn.hide();

                if (stepPosition === 'first') {
                    var prevBtn = parent.$(".layui-layer-btn0");
                    prevBtn.hide();
                } else if (stepPosition === 'final') {
                    var nextBtn = parent.$(".layui-layer-btn1");
                    nextBtn.hide();

                    var submitBtn = parent.$(".layui-layer-btn2");
                    submitBtn.show();
                } else {
                    var prevBtn = parent.$(".layui-layer-btn0");
                    prevBtn.show();

                    var nextBtn = parent.$(".layui-layer-btn1");
                    nextBtn.show();
                }

            });

            $(this).smartWizard(options);
        },

        customDropdownTree: function (options) {
            var target = $(this);
            var opt = {
                dropdownWidth: null,//下拉宽度,默认与输入框宽度一样
                dropdownHeight: 200,//下拉高度
                multi: true,//是否多选
                treeDatas: [],//本地data
                url: '',//远程访问数据的url
                async: true, //异步或同步方式访问url数据,默认：true 异步
                initVal: '',//初始化值
                split: ',',//勾选值的分隔符号
                filter: {},//过滤数据
                exclude: {},//过滤不需要的数据
                notSaveIds: [],//不需要保存的数据id
                canCheckParent: true,//是否可以选择父节点
                isSaveParentVal: true,//是否保存父节点值（当canCheckParent=true时生效）
                isEffertParents: false,//勾选/取消节点时是否影响父节点的勾选状态
                isEffertChildren: false,//勾选/取消节点时是否影响子节点的勾选状态
                onCheck: function (e, treeId, treeNode) {
                }//勾选时回调函数
            }
            if (options && typeof options == 'object') $.extend(opt, options);
            if (!opt.dropdownWidth) {
                opt.dropdownWidth = target.width();
            }
            var valueHiddenId = target.attr("id") ? (target.attr("id") + "_hidden") : new Date().getTime();
            var dropdownId = target.attr("id") ? (target.attr("id") + "_dropdown") : new Date().getTime();
            var treeId = target.attr("id") ? (target.attr("id") + "_tree") : new Date().getTime();
            opt.valueHiddenId = valueHiddenId;
            opt.dropdownId = dropdownId;
            opt.treeId = treeId;
            target.attr("placeholder", target.attr("disabled") ? "" : "请选择");
            target.attr("autocomplete", false);
            target.attr("readonly", true);
            target.after('<input type="hidden" id="' + opt.valueHiddenId + '"/>');
            target.after('<div id="' + opt.dropdownId + '"> <ul id="' + opt.treeId + '" class="ztree"></ul> </div>');
            $("#" + opt.dropdownId).css({
                overflow: "auto",
                display: "none",
                position: "absolute",
                "z-index": 9999,
                width: opt.dropdownWidth,
                height: opt.dropdownHeight,
                left: target.position().left,
                "background-color": "honeydew",
                "border-radius": "2px"
            });
            target.renderCustomDropdownTree(opt);
            target.click(function () {
                target._showMenu(opt);
            });
            $(window).bind("load resize", function () {
                if (target.is(':visible')) target._hideMenu(opt);
            });
        },
        renderCustomDropdownTree: function (newOpt) {
            var target = $(this);
            var opt = newOpt;
            if (target.data("opt")) opt = newOpt ? $.extend(true, target.data("opt"), newOpt) : target.data("opt");
            var zTree = opt.treeId ? $.fn.zTree.getZTreeObj(opt.treeId) : null;
            if (zTree) zTree.destroy();
            if (newOpt.url) {
                $.commonAjax({
                    url: newOpt.url,
                    async: opt.async,
                    data: newOpt.param ? newOpt.param : {},
                    success: function (json) {
                        if (!$.checkSessionInvalid(json)) {
                            if (json.state) {
                                opt.treeDatas = json.rows;
                                target._initCustomDropdownTree(opt);
                            }
                        }
                    }
                });
            } else target._initCustomDropdownTree(opt);
        },
        _initCustomDropdownTree: function (opt) {
            var target = $(this);
            target._initChecked(opt);
            var effertNodes = "";
            if (opt.isEffertParents) effertNodes += "p";
            if (opt.isEffertChildren) effertNodes += "s";
            var setting = {
                check: {
                    enable: true,
                    chkStyle: opt.multi ? "checkbox" : "radio",
                    chkboxType: {"Y": effertNodes, "N": effertNodes},
                    radioType: 'all'
                },
                view: {
                    dblClickExpand: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    beforeClick: function (treeId, treeNode) {
                        var zTree = $.fn.zTree.getZTreeObj(opt.treeId);
                        zTree.checkNode(treeNode, !treeNode.checked, true, true);
                        return false;
                    },
                    onCheck: function (e, treeId, treeNode) {
                        target._setValue(opt.notSaveIds);
                        if (opt.onCheck && typeof opt.onCheck == 'function') opt.onCheck(e, treeId, treeNode);
                    }
                }
            };
            var filteredTreeDatas = target._filterTreeDatas(opt.treeDatas, opt.filter, opt.exclude);
            $.fn.zTree.init($("#" + opt.treeId), setting, filteredTreeDatas);
            target.data("opt", opt);
            target._setValue(opt.notSaveIds);
            target.attr("title", target.val());
        },
        _filterTreeDatas: function (treeDatas, filter, exclude) {
            var target = $(this);
            var filteredTreeDatas = [];
            if (!filter || typeof filter != 'object') filter = {};
            if (!exclude || typeof exclude != 'object') exclude = {};
            if (treeDatas && $.isArray(treeDatas)) {
                for (var i in treeDatas) {
                    var flag = true;
                    for (var k in filter) {
                        if (!treeDatas[i]["data"] || treeDatas[i]["data"][k] != filter[k]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        var children = treeDatas[i]["children"];
                        if (children && $.isArray(children) && children.length > 0) {
                            treeDatas[i]["children"] = target._filterTreeDatas(children, filter);
                        }
                        if (exclude.length > 0) {
                            for (var k in exclude) {
                                if (treeDatas[i]["data"][k] != exclude[k]) {
                                    filteredTreeDatas.push(treeDatas[i]);
                                    break;
                                }
                            }
                        } else {
                            filteredTreeDatas.push(treeDatas[i]);
                        }

                    }
                }
            }
            return filteredTreeDatas;
        },
        _initChecked: function (opt) {
            var treeDatas = opt.treeDatas;
            var initDatas = opt.initVal;
            var isMulti = opt.multi;
            var split = opt.split;
            var canCheckParent = (opt.canCheckParent == true || opt.canCheckParent == false) ? opt.canCheckParent : isMulti;
            var target = $(this);
            var checkedCount = 0;
            if (!initDatas) initDatas = [];
            if (typeof initDatas == 'string') initDatas = $.strsToArray(initDatas, split);
            if (treeDatas && $.isArray(treeDatas)) {
                for (var i in treeDatas) {
                    var children = treeDatas[i]["children"];
                    if (children && $.isArray(children) && children.length > 0) {
                        var opt1 = $.my_clone(opt);
                        opt1.treeDatas = children;
                        var childrenCheckedCount = target._initChecked(opt1);
                        if (!canCheckParent) treeDatas[i]["nocheck"] = true;
                        else {
                            if ($.isArray(initDatas) && initDatas.indexOf(treeDatas[i]["id"]) >= 0) {
                                treeDatas[i]["checked"] = true;
                                isMulti ? checkedCount++ : checkedCount = 1;
                            }
                            if (childrenCheckedCount > 0) {
                                if (opt.isEffertParents && !treeDatas[i]["checked"] && childrenCheckedCount == children.length) {
                                    treeDatas[i]["checked"] = true;
                                    checkedCount++;
                                }
                            }
                        }
                    } else {
                        if ($.isArray(initDatas) && initDatas.indexOf(treeDatas[i]["id"]) >= 0) {
                            treeDatas[i]["checked"] = true;
                            isMulti ? checkedCount++ : checkedCount = 1;
                        }
                    }

                }
            }
            return checkedCount;
        },
        getCustomDropdownTreeValue: function () {
            var target = $(this);
            var opt = target.data("opt");
            return opt ? $("#" + opt.valueHiddenId).val() : "";
        },
        setCustomDropdownTreeValue: function (values) {
            var target = $(this);
            var opt = target.data("opt");
            if (opt) {
                if (values == null || values == undefined) values = [];
                if (!$.isArray(values)) values = values.split(opt.split);
                var zTree = $.fn.zTree.getZTreeObj(opt.treeId);
                var nodes = zTree.transformToArray(zTree.getNodes());
                for (var i in nodes) {
                    zTree.checkNode(nodes[i], values.indexOf(nodes[i].id) > -1, true, true);
                }
            }
        },
        _setValue: function (notSaveIds) {
            var target = $(this);
            var opt = target.data("opt");
            var zTree = $.fn.zTree.getZTreeObj(opt.treeId),
                nodes = zTree.getCheckedNodes(true),
                v = "";
            var names = "";
            for (var i = 0, l = nodes.length; i < l; i++) {
                var notNeedSave = false;
                if (notSaveIds && typeof notSaveIds == 'object') {
                    for (var k = 0, kk = notSaveIds.length; k < kk; k++) {
                        if (nodes[i].id == notSaveIds[k]) {
                            notNeedSave = true;
                            break;
                        }
                    }
                }
                if ((!opt.isSaveParentVal && !nodes[i].isParent && !notNeedSave) || (opt.isSaveParentVal && !notNeedSave)) {
                    v += nodes[i].id + ",";
                    names += nodes[i].name + ",";
                }
            }
            if (v.length > 0) v = v.substring(0, v.length - 1);
            if (names.length > 0) names = names.substring(0, names.length - 1);
            $("#" + opt.valueHiddenId).val(v);
            target.val(names);
            target.attr("title", target.val());
        },
        _showMenu: function (opt) {
            var target = $(this);
            $("#" + opt.dropdownId).css({width: target.outerWidth(), left: target.position().left});
            $("#" + opt.dropdownId).slideDown("fast");
            $("body").bind("mousedown", function (e) {
                target._onBodyDown(e, opt)
            });
        },
        _hideMenu: function (opt) {
            var target = $(this);
            $("#" + opt.dropdownId).fadeOut("fast");
            $("body").unbind("mousedown", function (e) {
                target._onBodyDown(e, opt);
            });
        },
        _onBodyDown: function (event, opt) {
            if (!(event.target.id == $(this).attr("id")
                || event.target.id == opt.dropdownId || $(event.target).parents("#" + opt.dropdownId).length > 0)) {
                $(this)._hideMenu(opt);
            }
        }
    });
}

$(function () {
    //select2
    // $(".select2").select2();
    // //iCheck for checkbox and radio inputs
    // $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
    //     checkboxClass: 'icheckbox_minimal-blue',
    //     radioClass: 'iradio_minimal-blue'
    // });

    //icheck
    var checkedBgColor = "#f5f5f5",
        unCheckedBgColor = "#fff";
    //单选
    $(".checkbox-item").on('ifChecked', function () {
        $(this).parents('tr').css('background', checkedBgColor);
    }).on('ifUnchecked', function () {
        $(this).parents("tr").css('background', unCheckedBgColor);
    });
    //全选
    $(".checkbox-toolbar").on('ifChecked', function () {
        $(".checkbox-item").iCheck('check');
        $(".checkbox-item").parents("tr").css('background', checkedBgColor);
    }).on('ifUnchecked', function () {
        $(".checkbox-item").iCheck('uncheck');
        $(".checkbox-item").parents("tr").css('background', unCheckedBgColor);
    });

    // Custom theme
    $.validator.setTheme('bootstrap', {
        validClass: 'has-success',
        invalidClass: 'has-error',
        bindClassTo: '.form-group',
        formClass: 'n-default n-bootstrap',
        msgClass: 'n-bottom'
    });
});

/**
 * 初始化部门选择器
 * @param belongDepIdSelector 下拉控件选择器
 */
function initDeptSelector(belongDepIdSelector) {
    $.commonAjax({
        type: 'get',
        url: basePathJS + "/system/dept/getDeptSelectDataList",
        dataType: 'json',
        async: false,
        success: function (json) {
            if (json.state) {
                var selectData = json.content.selectData;
                $(belongDepIdSelector).select2({
                    data: selectData
                });
            } else {
                errorMsgTip(json.msg);
            }
        }
    });
}

/**
 * 初始化同步下拉选择器
 * @param needCacheSelector 下拉控件选择器
 */
function initNeedCache(needCacheSelector) {
    $.commonAjax({
        url: basePathJS + "/enums/NeedCacheEnum",
        async: false,
        success: function (json) {
            $(needCacheSelector).select2({
                data: json,
                minimumResultsForSearch: -1
            });
        }
    });
}

/**
 * 初始化同步下拉选择器
 * @param needSyncSelector 下拉控件选择器
 */
function initNeedSync(needSyncSelector) {
    $.commonAjax({
        url: basePathJS + "/enums/NeedSyncEnum",
        async: false,
        success: function (json) {
            $(needSyncSelector).select2({
                data: json,
                minimumResultsForSearch: -1
            });
        }
    });
}


/**
 * 结构化文件列范围验证
 * @returns {boolean}
 */
function validateColumnRange() {
    var contentRowsRange = $("#contentRowsRange").val();
    var titleRownum = $("#titleRownum").val();
    var fieldRownum = $("#fieldRownum").val();
    if (contentRowsRange != "" && titleRownum != "") {
        if (contentRowsRange.match(reg_numberRange)) {
            var checkRowRange = checkRange(contentRowsRange, titleRownum, fieldRownum);
            if (contentRowsRange.startWith(',') || contentRowsRange.startWith('-')) {
                //alert("内容行号范围必须以正整数开始！");
                jQuery("#checktip_contentRowsRange ").html("<span style='color: red;'>内容行号范围必须以正整数开始！</span>");
                return false;
            } else if (contentRowsRange.indexOf("--") > 0 || contentRowsRange.indexOf(",,") > 0 || contentRowsRange.indexOf("-,") > 0 || contentRowsRange.indexOf(",-") > 0) {
                //alert("内容行号范围-或者,符号不能连续出现！");
                jQuery("#checktip_contentRowsRange ").html("<span style='color: red;'>内容行号范围-或者,符号不能连续出现！</span>");
                return false;
            } else if (checkRowRange == -1) {
                //alert("内容行号范围必须按照升序排列！");
                jQuery("#checktip_contentRowsRange ").html("<span style='color: red;'>内容行号范围必须按照升序排列！</span>");
                return false;
            } else if (checkRowRange == 0) {
                return false;
            }
        } else {
            //alert("内容行号范围只能由正整数和-（英文符号）以及,（英文符号）组成！");
            jQuery("#checktip_contentRowsRange ").html("<span style='color: red;'>内容行号范围只能由正整数和-（英文符号）以及,（英文符号）组成！</span>"); //todo 提示正确的范围输入方式
            return false;
        }
        jQuery("#checktip_contentRowsRange ").html(null);
        return true;
    }
}


/**
 * 结构化文件列范围验证
 * @returns {boolean}
 */
function checkRange(range, titleRownum, fieldRownum) {
    range = range.replace(/-/g, ",");
    if (range.endWith(",")) {
        range = range.substring(0, range.length - 1);
    }
    var rangeArr = range.split(",");
    if (rangeArr[0].match(reg_englishRange)) {
        rangeArr = parseCharArr(rangeArr);
    } else {
        if (titleRownum && parseInt(rangeArr[0]) <= parseInt(titleRownum)) {
            //alert("字段英文行号必须小于内容行号！");
            jQuery("#checktip_contentRowsRange ").html("<span style='color: red;'>字段英文行号必须小于内容行号！</span>");
            return 0;
        }
        if (fieldRownum && parseInt(rangeArr[0]) <= parseInt(fieldRownum)) {
            //alert("字段中文行号必须小于内容行号！");
            jQuery("#checktip_contentRowsRange ").html("<span style='color: red;'>字段中文行号必须小于内容行号！</span>");
            return 0;
        }
    }
    for (var i = 0; i < rangeArr.length; i++) {
        for (var j = 0; j < i; j++) {
            var rangeArr_i = parseInt(rangeArr[i]);
            var rangeArr_j = parseInt(rangeArr[j]);
            if (rangeArr_i < rangeArr_j) {
                return -1;
            }
        }
    }
    return 1;
}

/**
 * 验证结构化输出表名成都
 * @returns {boolean}
 */
function validateSfTableNameLength() {
    if (sfOutputType != "") {
        if (sfOutputType == "Mysql") {
            if ($("#outputTableName").val().length > 61) {
                jQuery("#checkTableNameLength").html("<span style='color: red;'>Mysql表名最大长度为61！</span>");
                return false;
            } else {
                jQuery("#checkTableNameLength").empty();
                return true;
            }
        } else if (sfOutputType == "Oracle") {
            if ($("#outputTableName").val().length > 27) {
                jQuery("#checkTableNameLength").html("<span style='color: red;'>Oracle表名最大长度为27！</span>");
                return false;
            } else {
                jQuery("#checkTableNameLength").empty();
                return true
            }
        }
        jQuery("#checkTableNameLength").empty();
        return true;
    }
    jQuery("#checkTableNameLength").empty();
    return true;
}

/**
 * String endwith方案
 * @param s
 * @returns {boolean}
 */
String.prototype.endWith = function (s) {
    if (s == null || s == "" || this.length == 0 || s.length > this.length)
        return false;
    if (this.substring(this.length - s.length) == s)
        return true;
    else
        return false;
    return true;
}

/**
 * String startWith方法
 * @param s
 * @returns {boolean}
 */
String.prototype.startWith = function (s) {
    if (s == null || s == "" || this.length == 0 || s.length > this.length)
        return false;
    if (this.substr(0, s.length) == s)
        return true;
    else
        return false;
    return true;
}