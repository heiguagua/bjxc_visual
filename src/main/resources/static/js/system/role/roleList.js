/**
 * Created by lenovo on 2017/5/9. 1
 */
var tableSelector = '#systemRoleTableId';

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
        url: basePathJS + '/system/role/list',
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
            field: 'roleName',
            title: '角色名称',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
        	 field: 'roleDesc',
             width: 320,
             title: '描述',
             align: 'left',
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
            field: 'createTime',
            title: '创建时间',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'status',
            title: '状态',
            align: 'left',
            valign: 'middle',
            sortable: false,
            formatter : function (value) {
                var result = "启用";
                if(value == -1){
                    result = "<font color='red'> 禁用</font>"
                }
                return result;
            }
        },  {
            field: 'roleLevel',
            title: '角色级别',
            align: 'left',
            valign: 'middle',
            sortable: false
        },
            {
            field: 'id',
            title: '操作',
            align: 'left',
            valign: 'middle',
            width: '18%',
            sortable: false ,
            formatter : function (value) {
                var authBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:authRole(\"" + value + "\")'><i class='fa fa-user'></i> 授权</a>";
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editRole(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteRole(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
                return authBtn + OPERATION_SEPARATOR +  editBtn + OPERATION_SEPARATOR +  deleteBtn ;
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

function addRole() {	
    add('新增角色',basePathJS + '/system/role/add');
}

function editRole(id) {
    update('编辑角色',basePathJS + '/system/role/edit' , id );
}

function deleteRole(id) {
    var url = basePathJS + "/system/role/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}

function deleteBatchRole() {
    var url = basePathJS + "/system/role/deleteBatch";
    deleteALLSelect(url , tableSelector);
}

function authRole(id){
    update('角色授权',basePathJS + '/system/role/auth' , id );
}
