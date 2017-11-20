var tableSelector = '#systemAuthUserDirTableId';

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
            //align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'realName',
            title: '真实姓名',
            //align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'userType',
            title: '用户类型',
            //align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false,
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
                //align: 'center',
                valign: 'middle',
                sortable: false,
                visible:false
        }, {
                field: 'regionName',
                title: '区域名称',
                //align: 'center',
                valign: 'middle',
                sortable: false
            }, {
                field: 'deptName',
                title: '组织机构名称',
                //align: 'center',
                valign: 'middle',
                sortable: false
            }, {
                field: 'status',
                title: '用户状态',
                //align: 'center',
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
                //align: 'center',
                valign: 'middle',
                sortable: false,
                visible:false
            }, {
                field: 'cellPhoneNumber',
                title: '手机号码',
                //align: 'center',
                valign: 'middle',
                sortable: false,
                visible:false
            },
            {
                field: 'createName',
                title: '创建者',
                //align: 'center',
                valign: 'middle',
                sortable: false
            }, {
                field: 'updateTime',
                title: '更新时间',
                //align: 'center',
                valign: 'middle',
                width: '160',
                sortable: false
            }, {
                field: 'id',
                title: '操作',
                //align: 'center',
                valign: 'middle',
                width: '220',
                sortable: false,
                formatter: function (value) {
                    var allotBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dirAllot(\"" + value + "\")'><i class='fa fa-chain'></i> 目录数据分配</a>";
                    return allotBtn + OPERATION_SEPARATOR;
                }
            }]
    });

    $('#defaultAuth').change(function () {
        setParams();
        reloadTable();
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        var defaultAuth = $('#defaultAuth').val();
        var searchKeyVal = $('#searchKeyId').val();
        var regionName = $('#regionNameId').val();
        var deptName = $('#deptNameId').val();
        paramsObj = {"defaultAuth": defaultAuth, searchKey: searchKeyVal,regionName: regionName,deptName:deptName};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function  dirAllot(id) {
    update('分配数据权限', basePathJS + '/system/userDirAuthority/edit', id, 500, 300);
}