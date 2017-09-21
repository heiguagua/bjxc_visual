var tableSelector = '#policyListId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {deleteFlag:0};

    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirPolicy/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'title',
            title: '标题',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'user_name',
            title: '创建人',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'createTime',
            title: '创建时间',
            align: 'center',
            valign: 'middle',
            sortable: false
        },{
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteUser(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

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
        paramsObj = {searchKey : searchKeyVal,deleteFlag:0};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addUser() {
    add('新增政策',basePathJS + '/dirPolicy/add');
}

function editUser(id) {
    update('编辑政策',basePathJS + '/dirPolicy/edit' , id);
}

function deleteUser(id) {
    var url = basePathJS + "/dirPolicy/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}