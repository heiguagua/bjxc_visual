var tableSelector = '#systemAuthUserTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {"defaultAuth": $("#defaultAuth").val()};

    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/user/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'userName',
            title: '用户名',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'realName',
            title: '真实姓名',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'userType',
            title: '用户类型',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter: function (value) {
                var ret = '';
                if (value === 1) {
                    ret = '管理员';
                } else if (value === 2) {
                    ret = '普通用户';
                }
                return ret;
            }
        }, {
                field: 'userDesc',
                title: '描述',
                align: 'center',
                valign: 'middle',
                sortable: false
        }, {
                field: 'regionName',
                title: '区域名称',
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
                field: 'status',
                title: '用户状态',
                align: 'center',
                valign: 'middle',
                sortable: false,
                formatter: function (value) {
                    var res;
                    if (value === 1) {
                        res = "启用";
                    }
                    else {
                        res = "禁用";
                    }
                    return res;
                }
            }, {
                field: 'telephoneNumber',
                title: '电话号码',
                align: 'center',
                valign: 'middle',
                sortable: false
            }, {
                field: 'cellPhoneNumber',
                title: '手机号码',
                align: 'center',
                valign: 'middle',
                sortable: false
            },
            {
                field: 'createName',
                title: '创建者',
                align: 'center',
                valign: 'middle',
                sortable: false
            }, {
                field: 'createTime',
                title: '创建用户时间',
                align: 'center',
                valign: 'middle',
                sortable: false
            }, {
                field: 'id',
                title: '操作',
                align: 'center',
                valign: 'middle',
                width: '12%',
                sortable: false,
                formatter: function (value) {
                    var allotBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dirAndDeptAllot(\"" + value + "\",\"dir\")'><i class='fa fa-chain'></i> 分配目录</a>";
                    var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dirAndDeptAllot(\"" + value + "\",\"dept\")'><i class='fa fa-pencil-square-o'></i> 分配部门</a>";
                    return allotBtn + OPERATION_SEPARATOR + editBtn + OPERATION_SEPARATOR   ;
                }
            }]
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        var defaultAuth = $('#defaultAuth').val();
        var searchKeyVal = $('#searchKeyId').val();
        paramsObj = {"defaultAuth": defaultAuth, searchKey: searchKeyVal};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function  dirAndDeptAllot(id,authType) {
    update('分配数据权限', basePathJS + '/system/userAuthority/edit?authType=' + authType, id, 500, 300);
}