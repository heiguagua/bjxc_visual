var tableSelector = '#systemAuthDeptTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/dept/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 15,
        columns: [{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptName',
            title: '组织机构名称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptAlias',
            title: '组织机构简称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptCode',
            title: '组织机构编码',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptContactMan',
            title: '联系人',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptContactPhone',
            title: '联系电话',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptAddress',
            title: '地址',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptDesc',
            title: '描述',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            width: '18%',
            formatter : function (value) {
                var allotBtn =   "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dirAndDeptAllot(\"" + value + "\",\"dir\")'><i class='fa fa-chain'></i>目录分配</a>";
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dirAndDeptAllot(\"" + value + "\",\"dept\")'><i class='fa fa-pencil-square-o'></i> 部门分配</a>";
                // var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteDept(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
                return allotBtn + OPERATION_SEPARATOR + editBtn + OPERATION_SEPARATOR   ;
            }
        }],
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

function  dirAndDeptAllot(id,authType) {
    update('分配数据权限', basePathJS + '/system/deptAuthority/edit?authType=' + authType, id, 500, 300);
}