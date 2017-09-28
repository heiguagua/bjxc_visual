/**
 * Created by Zhangm on 2017/9/28.
 */
var tableSelector = '#deptAuthorityAuditTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/deptAuthorityAudit/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 15,
        columns: [{
            field: 'id', title: '序号', width: '5%', align: 'center', formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            field: 'applicantName',
            title: '申请人',
            align: 'center',
            valign: 'middle',
            sortable: false
        },   {
            field: 'deptName',
            title: '申请权限对应部门',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'applyReason',
            title: '申请理由',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'auditorName',
            title: '审核人',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'auditOpinion',
            title: '审核意见',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'auditTime',
            title: '审核时间',
            align: 'center',
            valign: 'middle',
            sortable: false
        },{
            field: 'auditStatus',
            title: '审核状态',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter : function (value) {
                var result = "通过";
                if(value == "0"){
                    result = "<font > 待审核</font>"
                } else if (value == "2"){
                    result = "<font > 拒绝</font>"
                }
                return result;
            }
        },{
            field: 'applyTime',
            title: '申请时间',
            align: 'center',
            valign: 'middle',
            sortable: false
        },{
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            width: '18%',
            formatter : function (value) {
                var auditBtn =   "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:authorityAudit(\"" + value + "\")'><i class='fa fa-chain'></i>审核</a>";
                return  OPERATION_SEPARATOR + auditBtn  ;
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
        paramsObj = {searchKey : searchKeyVal};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function authorityAudit(id) {
    update('审核部门权限',basePathJS + '/system/deptAuthorityAudit/edit',id);
}

