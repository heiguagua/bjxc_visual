define(['jquery','moment','daterangepicker','validator','validator.lang','zTree','bootstrapTable','bootstrapTable.lang','select2'],function($,moment,validator,select2){
var urlPrefix = "";
var specialReg = new RegExp("['\"]+");  //特殊字符的正则表达式 1
var reg_numberRange = /^[0-9\,\-]+$/g;
var reg_englishRange = /^[a-zA-Z\,\-]+$/g;
/**
 * 操作分隔符，常量1
 * @type {string}
 */
window.OPERATION_SEPARATOR = ' ';

/**
 * jdbc类型 todo 临时放在这里
 * @type {*[]}
 */
window.JDBC_TYPE_SOURCE = [
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
window.Oracle_TYPE_SOURCE = [
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
window.Sqlserver_TYPE_SOURCE = [
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
window.Mysql_TYPE_SOURCE = [
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

    /*
     * **************************************
     *              扩展方法
     * **************************************
     */
    $.extend({
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

        /**
         * 获取当前选中的区域的编码
         */
        getSelectedRegionCode:function(){
            /*var regionCode = "";
            var regionObj = JSON.parse(window.localStorage.getItem("regionObj"));
            if(regionObj){
                regionCode = regionObj.code;
            }*/
            return newRegionCode;
        },

        /**
         * 获取区域类别的下拉树对象
         * @param treeDomId         ztree对象的id
         * @param nameInputDomId    显示选中目录类别的名称的input框的id
         * @param codeInputDomId    存储选中目录类别的id的隐藏域input框的id
         * @param treeDivDomId      树形展开区域的DIV的id
         */
        initRegionTreeSelect: function (treeDomId, nameInputDomId, codeInputDomId, treeDivDomId , multiple, selectRegions,type) {
            var selectRegionCodes = "";
            var chkStyle = multiple ? "checkbox" : "radio";
            if(!selectRegions || !$.isArray(selectRegions)) selectRegions = [];
            var setting = {
                async: {
                    enable: true,
                    url: basePathJS + "/system/region/getRegionSelectDataList",
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
                                'checked': selectRegions.indexOf(nodeObjs[i].regionCode) >= 0,
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
                        if('region'==type){
                            initRegionLevelDataList(selectRegionCodes);
                        }else{
                            initDeptSelectDataList(selectRegionCodes);
                        }
                    }
                }
            };

            function initRegionLevelDataList(dd) {
                $.commonAjax({
                    url: basePathJS + "/system/regionLevel/findByRegionLevelValueGreaterThan",
                    data:{
                        regionCode : dd
                    },
                    success: function (result) {
                        if (result.state) {
                            var selectData = result.content.selectData;
                            var data = [];
                            if(selectData && selectData.length > 0){
                                for(var i in selectData){
                                    var id = selectData[i].regionLevelCode;
                                    var text = selectData[i].regionLevelName;
                                    if(id && text){
                                        data.push({id: id, text: text})
                                    }
                                }
                            }
                            $("#regionLevelCode").html("")
                            $("#regionLevelCode").select2({
                                data: data,
                                placeholder : '',
                                allowClear: true
                            });
                            // $("#fid").change(function(){
                            //     $("#fname").val($("#select2-fid-container").attr("title"))
                            // })
                            $("#regionLevelCode").val('').trigger("change");
                        }
                    }
                });
            }
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
            $.fn.zTree.init($("#" + treeDomId), setting);
            $('#' + nameInputDomId).click(function () {
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
         * @param canOrNotSelectIds 指定节点可选择
         * @param canNotSelectIds   指定节点不可选择
         */
        initDeptTreeSelect: function (treeDomId, nameInputDomId, codeInputDomId, treeDivDomId, multiple, param, selects, canSelectIds, canNotSelectIds,all,chkDisabledSelectIds) {
            var chkStyle = multiple ? "checkbox" : "radio";
            if(!param || typeof param != 'object') param = {};
            if(!selects || !$.isArray(selects)) selects = [];
            if(!canSelectIds || !$.isArray(canSelectIds)) canSelectIds = [];
            if(!canNotSelectIds || !$.isArray(canNotSelectIds)) canNotSelectIds = [];
            if(!chkDisabledSelectIds || !$.isArray(chkDisabledSelectIds)) chkDisabledSelectIds = [];
            if(!all || !$.isArray(all)) all = [];
            var selectIds = [];
            var miniSelectIds=[];//排除chkDisabledSelectIds后剩下的数组
            var miniSelects=[];
            if(selects.length > 0){
                for(var i in selects){
                    var select = selects[i];
                    if(select.id){
                        selectIds.push(select.id);
                        if(chkDisabledSelectIds.indexOf(select.id)<0){
                            miniSelectIds.push(select.id);
                            miniSelects.push(select);
                        }
                    }
                }
            }

            // $('#' + codeInputDomId).val(selectIds.join(","));
            $('#' + codeInputDomId).val(miniSelectIds.join(","));
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
                            var nocheck = nodeObjs[i].deptLevel == 1;
                            if(!nocheck){
                                if(canSelectIds.length > 0){
                                    if(nodeObjs[i].deptLevel == 2){
                                        nocheck = canSelectIds.indexOf(nodeObjs[i].id) < 0;
                                    }else if(nodeObjs[i].deptLevel > 2){
                                        nocheck = canSelectIds.indexOf(nodeObjs[i].fid) < 0;
                                        if(nocheck){
                                            nocheck = canSelectIds.indexOf(nodeObjs[i].id) < 0;
                                        }
                                    }
                                }
                                if(canNotSelectIds.length > 0){
                                    if(nodeObjs[i].deptLevel == 2){
                                        nocheck = canNotSelectIds.indexOf(nodeObjs[i].id) >= 0;
                                    }else if(nodeObjs[i].deptLevel > 2){
                                        nocheck = canNotSelectIds.indexOf(nodeObjs[i].fid) >= 0;
                                        if(!nocheck){
                                            nocheck = canNotSelectIds.indexOf(nodeObjs[i].id) >= 0;
                                        }
                                    }
                                }
                            }
                            // var aa=nodeObjs[i];
                            var checked=selectIds.indexOf(nodeObjs[i].id) >= 0;
                            if(parentNode){
                                checked=(parentNode.checked&&!parentNode.halfCheck)||checked;
                                if(nodeObjs[i].deptLevel == 1){
                                    checked=false;
                                }
                            }
                            var halfCheck=false;
                            if(all.length > 0){
                                halfCheck=all.indexOf(nodeObjs[i].id)>=0;
                                if(selectIds.indexOf(nodeObjs[i].id) >= 0){
                                    halfCheck=false;
                                }
                                if(!nocheck&&halfCheck&&!(selectIds.indexOf(nodeObjs[i].id) >= 0)){
                                    checked=true;
                                }


                            }
                            var chkDisabled=false;
                            if(chkDisabledSelectIds.indexOf(nodeObjs[i].id) >= 0){
                                chkDisabled=true;
                            }
                            if(parentNode&&parentNode.chkDisabled){
                                chkDisabled=true;
                            }
                            params[i] = {
                                'id': nodeObjs[i].id,
                                'name': nodeObjs[i].deptName,
                                'fid': nodeObjs[i].fid,
                                'checked': checked,
                                'isParent': (nodeObjs[i].isLeaf ? false : true),
                                'halfCheck':halfCheck,
                                'chkDisabled':chkDisabled,
                                'nocheck': nocheck
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
                        treeNode.halfCheck=false;
                        var p=treeNode.getParentNode();
                        if(p){
                             p.halfCheck=false;
                        }
                        var ids = [], names = [];
                        if(multiple){
                            var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId), selectNodes = zTreeObj.getCheckedNodes(true)
                            var resultList = [];
                            if(!treeNode.checked){
                                // for(var i in selects){
                                for(var i in miniSelects){
                                    // if(treeNode.id == selects[i].id){
                                    if(treeNode.id == miniSelects[i].id){
                                        // delete selects[i];
                                        delete miniSelects[i];
                                        // var selectIdIndex = selectIds.indexOf(treeNode.id);
                                        var selectIdIndex = miniSelectIds.indexOf(treeNode.id);
                                        if(selectIdIndex >= 0){
                                            // delete selectIds[selectIdIndex];
                                            delete miniSelectIds[selectIdIndex];
                                        }
                                        break;
                                    }
                                }
                                var authObjId=1;
                                var type=1;
                                if(param.withoutDept){
                                    authObjId=param.withoutDept;
                                    type="dept";
                                }
                                if(param.withoutUserDept){
                                    authObjId=param.withoutUserDept;
                                    type="user";
                                }
                                $.ajax({
                                    type : "get",
                                    url : basePathJS + "/system/deptAuthority/getSelectedNodeByCurrentNode?authObjId=" + authObjId+ "&currentDeptId=" + treeNode.id+"&type="+type,
                                    async : false,
                                    success : function(data){
                                        var dd = data.content.selected;
                                        for(var i in miniSelects){
                                            var index=dd.indexOf(miniSelects[i].id);
                                            if(index>=0){
                                                delete miniSelects[i];
                                                delete miniSelectIds[index];
                                            }
                                        }
                                    }
                                });
                            }

                            // var tempList = selects.slice();
                            var tempList = miniSelects.slice();
                            // if(treeNode.check_Child_State==0||treeNode.check_Child_State==-1){
                            //
                            // }
                            for(var i in selectNodes){
                                var node = selectNodes[i];

                                if(!node.chkDisabled&&node.checked&&!node.halfCheck && miniSelectIds.indexOf(node.id) < 0){
                                // if(!node.chkDisabled&&node.checked&&!node.halfCheck && selectIds.indexOf(node.id) < 0){
                                    tempList.push({id: node.id, fid: node.fid, name: node.name})
                                }
                                if(node.check_Child_State==1){
                                    for(var i in tempList){
                                        if(tempList[i].id==node.id){
                                            delete tempList[i];
                                        }
                                    }
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
                                    }if(!flag){
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
            $.fn.zTree.init($("#" + treeDomId), setting);
            if(nameInputDomId){
                $('#' + nameInputDomId).click(function () {
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
                    url: basePathJS + "/system/region/getRegionSelectDataList",
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

            $.fn.zTree.init($("#" + treeDomId), setting);
            $('#' + nameInputDomId).click(function () {
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
                        url: basePathJS + "/system/dept/getDeptSelectDataList?regionCode=" + dd + "&onlyLoginUserDept=1",
                        autoParam: ["id", "deptLevel"],
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
                                    'deptLevel': nodeObjs[i].deptLevel,
                                    'isParent': (nodeObjs[i].isLeaf ? false : true),
                                    'nocheck': nodeObjs[i].deptLevel == 1
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
                $.fn.zTree.init($("#" + treeDomId), setting);
                $('#' + nameInputDomId).click(function () {
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

        },

        /**
         * 拼音生成中文
         */
        getPinyin :function(inputNameId,outputNameId) {
            var inputName=$("#"+inputNameId).val();
            if(inputName){
                $.commonAjax({
                    url: basePathJS + "/system/dept/getPinyin",
                    data: {cnName: inputName},
                    success: function (result) {
                        $("#"+outputNameId).val(result);
                    }
                });
            }

        }
    });



    $.fn.extend({
        customTable: function (options) {
            var options = $.extend({
                sidePagination: 'server',
                queryParamsType: '',
                method: 'post',
                escape:true,
                url: '',
                dataType: "json",
                contentType: "application/x-www-form-urlencoded",
                cache: false,
                striped: true,
                pagination: true,
                showJump: false,
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
                 smartDisplay: false,
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

		return {
			initGlobalCustom:initGlobalCustom
		}
	})