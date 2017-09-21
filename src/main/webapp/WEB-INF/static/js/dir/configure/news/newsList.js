var tableSelector = '#dirSpecialAppsTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {deleteFlag:"0"};
    
    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirNews/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
        	field: 'title',
            title: '新闻标题',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'newsPic',
            title: '图片名称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'newsContent',
            title: '新闻内容',
            align: 'center',
            valign: 'middle',
            sortable: false,           
        }, {
            field: 'createTime',
            title: '创建时间',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
            	var statusBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:statusUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 禁用</a>";
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteUser(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

                return statusBtn + OPERATION_SEPARATOReditBtn + OPERATION_SEPARATOR + deleteBtn ;
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

function addUser() {
    add('新增应用',basePathJS + '/dirSpecialApps/add');
}

function statusUser(id) {
    update('禁用应用',basePathJS + '/dirSpecialApps/edit' , id);
}

function editUser(id) {
    update('编辑应用',basePathJS + '/dirSpecialApps/edit' , id);
}

function deleteUser(id) {
    var url = basePathJS + "/dirSpecialApps/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}