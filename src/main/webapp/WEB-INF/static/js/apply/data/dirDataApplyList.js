/**
 * Created by lenovo on 2017/5/9.
 */
var tableSelector = '#dirDataApplyTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirDataApply/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 15,
        columns: [{
            field: 'classifyStructureName',
            title: '所属目录分类',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'datasetName',
            title: '所属信息资源',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'limitVisitCnt',
            title: '期望使用次数',
            align: 'center',
            valign: 'middle',
            width: '120',
            sortable: false
        }, {
            field: 'limitVisitDatePeriod',
            title: '期望使用时间',
            align: 'center',
            valign: 'middle',
            width: '300',
            sortable: false
        }, {
            field: 'realName',
            title: '申请人',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter : function (value, row) {
                return value + '[' + row.userName + ']';
            }
        }, {
            field: 'deptName',
            title: '申请人所属组织',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'applyDate',
            title: '提交时间',
            align: 'center',
            valign: 'middle',
            width: '160',
            sortable: false
        }, {
            field: 'status',
            title: '状态',
            align: 'center',
            valign: 'middle',
            width: '60',
            sortable: false,
            formatter : function (value) {
                if(value == "1"){
                    return "审核通过";
                }else if(value == "2"){
                    return "审核不通过"
                }else{
                    return "待审核";
                }
            }
        }, {
                field: 'id',
                title: '操作',
                align: 'center',
                valign: 'middle',
                width: '80',
                sortable: false ,
                formatter : function (value) {
                    var auditBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:audit(\"" + value + "\")'><i class='fa fa-user'></i> 开始审核</a>";
                    return auditBtn;
                }
            }
        ]
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        var searchKeyVal = $('#searchKeyId').val();
        paramsObj = {searchKey: searchKeyVal};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function audit(id){
    update('共享审核', basePathJS + '/dirDataApply/edit' , id );
}