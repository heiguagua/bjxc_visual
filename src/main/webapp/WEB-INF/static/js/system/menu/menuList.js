var tableSelector = '#systemMenuTableId';
//1
jQuery(document).ready(function () {

    var paramsObj = {};
    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/menu/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'menuName',
            title: '菜单名称',
            align: 'left',
            width: '200px',
            valign: 'middle',
            sortable: false
        },{
            field: 'code',
            title: '编码',
            align: 'left',
            width: '150px',
            valign: 'middle',
            sortable: false
        },{
            field: 'menuType',
            title: '类型',
            align: 'left',
            width: '100px',
            valign: 'middle',
            sortable: false,
            formatter : function (value) {
                var type;
                if(value == 1){
                    type = "目录";
                }else if(value == 2){
                    type = "菜单";
                }else if(value == 3){
                    type = "功能";
                }
                return type;
            }
        }, {
            field: 'url',
            title: '访问地址',
            align: 'left',
            width: '200px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'resourceName',
            title: '资源标识',
            align: 'left',
            width: '200px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'sort',
            title: '排序',
            align: 'left',
            width: '100px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'icon',
            title: '图标',
            align: 'left',
            width: '100px',
            valign: 'middle',
            sortable: false,
            formatter : function(value){
                return '<i class="fa '+value+' "></i>';
            }
        }, {
            field: 'status',
            title: '状态',
            align: 'left',
            width: '100px',
            valign: 'middle',
            sortable: false,
            visible:false,
            formatter : function (value) {
                var statusDesc;
                if(value == 1){
                    statusDesc = "启用";
                }else if(value == 0){
                    statusDesc = "禁用";
                }
                return statusDesc;
            }
        }, {
            field: 'id',
            title: '操作',
            align: 'left',
            width: '150px',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editMenu(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteMenu(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

            return editBtn + OPERATION_SEPARATOR +  deleteBtn ;
            }
        }]
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        var searchKeyVal = $('#searchKeyId').val();
        paramsObj = {menuName : searchKeyVal};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addMenu() {
    add('新增菜单', basePathJS + '/system/menu/add');
}

function editMenu(id) {
    update('编辑菜单', basePathJS + '/system/menu/edit' , id );
}

function deleteMenu(id) {
    var url = basePathJS + "/system/menu/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}
