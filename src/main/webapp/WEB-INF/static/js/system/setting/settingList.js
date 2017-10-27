var tableSelector = '#systemSettingTableId';
//1
jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};
    $("#searchKeyId").keydown(function(e){
        var curKey = e.which;
        if(curKey == 13){
        	setParams();
        	reloadTable();//此处可以是你要执行的功能
            return false;//这句非常重要。如果没有这句，那么查询出结果后，会出现刷新页面动作等，导致查询结果失效。
        }
    });

    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/setting/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'settingCode',
            title: '配置编码',
            align: 'center',
            valign: 'middle',
            // width : '150px' ,
            sortable: false
        }, {
            field: 'settingName',
            title: '配置名称',
            align: 'center',
            valign: 'middle',
            // width : '150px' ,
            sortable: false
        }, {
            field: 'settingValue',
            title: '配置值',
            align: 'center',
            valign: 'middle',
            // width : '400px' ,
            sortable: false
        }, {
            field: 'regionCode',
            title: '所属区域',
            align: 'center',
            valign: 'middle',
            sortable: false
        },
            {
            field: 'settingDesc',
            title: '配置描述',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter : function (value) {
                var display = null;
                if (value && value.length > 15){
                    display = value.substring(0,15) + " ...";
                } else {
                    display = value;
                }
                return display;
            }
        }, {
            field: 'status',
            title: '状态',
            align: 'center',
            valign: 'middle',
            sortable: false
        },
            {
                field: 'createUserName',
                title: '创建人',
                align: 'center',
                valign: 'middle',
                sortable: false
            },
            {
                field: 'createTime',
                title: '创建时间',
                align: 'center',
                valign: 'middle',
                sortable: false
            },
            {
            field: 'updateUserName',
            title: '更新人',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'updateTime',
            title: '更新时间',
            align: 'center',
            valign: 'middle',
            // width : '180px' ,
            sortable: false
        }, {
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editSetting(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteSetting(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
                // return editBtn + OPERATION_SEPARATOR +  deleteBtn ;
                return editBtn ;
            }
        }]
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

function addSetting() {
    add('新增组织机构',basePathJS + '/system/setting/add');
}

function editSetting(id) {
    update('编辑系统配置',basePathJS + '/system/setting/edit' , id );
}

function deleteSetting(id) {
    var url = basePathJS + "/system/setting/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}