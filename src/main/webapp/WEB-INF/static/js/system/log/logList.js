$(document).ready(function () {
    "use strict";

    var tableSelector = '#systemLogTableId';
    var paramsObj = {};

    $(tableSelector).customTable({
        url: basePathJS + '/system/log/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'operateDesc',
            title: '操作描述',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'realName',
            title: '操作人',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter : function (value, row) {
                return value + '[' + row.userName + ']';
            }
        }, {
            field: 'operateIp',
            title: '地址',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'operateTime',
            title: '操作时间',
            align: 'center',
            valign: 'middle',
            sortable: true
        }, {
            field: 'id',
            title: '操作',
            align: 'center',
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
        layer.open({
            type: 1,
            title : '查看参数',
            area: ['700px', '400px'],
            fixed: false, //不固定
            content: str //注意，如果str是object，那么需要字符拼接。
        });
    });
}


