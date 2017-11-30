$(document).ready(function () {
    "use strict";
//1
    var tableSelector = '#systemLogTableId';
    var paramsObj = {};
    $("#operatorRealName,#operatorUserName").keydown(function(e){
        var curKey = e.which;
        if(curKey == 13){
        	setParams();
        	reloadTable();//此处可以是你要执行的功能
            return false;//这句非常重要。如果没有这句，那么查询出结果后，会出现刷新页面动作等，导致查询结果失效。
        }
    });
    $(tableSelector).customTable({
        url: basePathJS + '/system/log/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'operateDesc',
            title: '操作描述',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'realName',
            title: '操作人真实姓名[用户名]',
            align: 'left',
            valign: 'middle',
            sortable: false,
            formatter : function (value, row) {
                var final = "";
                if(value && row.userName){
                    final = value + '[' + row.userName + ']'
                }else{
                    if(!value && !row.userName){
                        final = "-";
                    }else {
                        if(value){
                            final += value;
                        }else{
                            final += "-";
                        }
                        final += "[";
                        if(row.userName){
                            final += row.userName;
                        }else{
                            final += "-";
                        }
                        final += "]";
                    }
                }
                return final;
            }
        }, {
            field: 'operateIp',
            title: '地址',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'operateTime',
            title: '操作时间',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'id',
            title: '操作',
            align: 'left',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:queryLogDetail(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 查看参数</a>";
               return editBtn ;
            }
        }]
    });

    $('#operateTimeRange').customDateRangePicker();

    $('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });
    $('#queryBtnReset').click(function () {
        $('#operateTimeRange').val('');
        $('#operatorUserName').val('');
        $('#operatorRealName').val('');
    });
    function setParams() {
        var operatorUserName = $('#operatorUserName').val();
        var operatorRealName = $('#operatorRealName').val();
        var operateTimeRange = $('#operateTimeRange').val();
        paramsObj = {operatorUserName : operatorUserName ,operatorRealName : operatorRealName, operateTimeRange : operateTimeRange};
    }

    function reloadTable() {
        $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
        $(tableSelector).data("bootstrap.table").refresh();
    }

});

function queryLogDetail(id) {
    var url = basePathJS + '/system/log/params';

    $.post(url,{id : id}, function(str){
    	try{
            str = formatJson(str);
            str = str.replace(/\r\n/g,"<br/>");
            str = str.replace(/ /g,"&nbsp;");
        } catch (error){
            console.log(error);
        }
        layer.open({
            type: 1,
            skin: 'layui-layer-rim',
            title : '查看参数',
            area: ['500px', '320px'],
            offset :getOffset(280),
            fixed: false, //不固定
            content: str //注意，如果str是object，那么需要字符拼接。
        });
    });
}


