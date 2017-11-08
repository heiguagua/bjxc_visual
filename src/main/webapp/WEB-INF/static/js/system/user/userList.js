var tableSelector = '#systemUserTableId';
//1
jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};
    var isMaster=$("#masterId").val();

    $("#searchKeyId").keydown(function(e){
        var curKey = e.which;
        if(curKey == 13){
        	setParams();
        	reloadTable();//此处可以是你要执行的功能
            return false;//这句非常重要。如果没有这句，那么查询出结果后，会出现刷新页面动作等，导致查询结果失效。
        }
    });
    $("#regionNameId").keydown(function(e){
        var curKey = e.which;
        if(curKey == 13){
        	setParams();
        	reloadTable();//此处可以是你要执行的功能
            return false;//这句非常重要。如果没有这句，那么查询出结果后，会出现刷新页面动作等，导致查询结果失效。
        }
    });
    $("#deptNameId").keydown(function(e){
        var curKey = e.which;
        if(curKey == 13){
        	setParams();
        	reloadTable();//此处可以是你要执行的功能
            return false;//这句非常重要。如果没有这句，那么查询出结果后，会出现刷新页面动作等，导致查询结果失效。
        }
    });
    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/user/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
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
//            field: 'userType',
//            title: '用户类型',
//            align: 'center',
//            valign: 'middle',
//            sortable: false,
//            formatter: function (value) {
//                var ret = '';
//                if (value === 1) {
//                    ret = '管理员';
//                } else if (value === 2) {
//                    ret = '普通用户';
//                }
//                return ret;
//            }
//        }, {
            field: 'userDesc',
            title: '描述',
            align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false
        },
            {
                field: 'regionName',
                title: '行政区域',
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
                        res = "<font color='red'> 禁用</font>";
                    }
                    return res;
                }
            }, {
                field: 'telephoneNumber',
                title: '电话号码',
                align: 'center',
                valign: 'middle',
                sortable: false,
                visible:false
            },{
                field: 'cellPhoneNumber',
                title: '手机号码',
                align: 'center',
                valign: 'middle',
                sortable: false,
                visible:false
            },
            {
                field: 'createName',
                title: '创建者',
                align: 'center',
                valign: 'middle',
                sortable: false
            }, {
                field: 'updateTime',
                title: '更新时间',
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
                    var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                    var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteUser(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
                    if(isMaster==="true") {
                        return editBtn + OPERATION_SEPARATOR + deleteBtn;
                    }else{
                        return "子系统只能同步";
                    }
                }
            }]
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        var searchKeyVal = $('#searchKeyId').val();
        var regionName = $('#regionNameId').val();
        var deptName = $('#deptNameId').val();
        paramsObj = {searchKey: searchKeyVal,regionName: regionName,deptName:deptName};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function synRemoteData(){
    getMasterData(basePathJS + '/system/user/getMasterData');
}

function addUser() {
    add('新增用户', basePathJS + '/system/user/add',900,600);
}

function editUser(id) {
    update('编辑用户', basePathJS + '/system/user/edit', id,900,600);
}

function deleteUser(id) {
    var url = basePathJS + "/system/user/delete";
    var parameter = {id: id};
    delObj(url, parameter);
}

function deleteBatchUser() {
    var url = basePathJS + "/system/user/deleteBatch";
    deleteALLSelect(url , tableSelector);
}