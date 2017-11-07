var tableSelector = '#dirHomeTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {deleteFlag:"0"};
    
    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirHome/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [ {
            field: 'picName',
            title: '图片名称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'picType',
            title: '图片类型',
            align: 'center',
            valign: 'middle',
            sortable: false,           
        }, {
            field: 'picOrder',
            title: '播放顺序',
            align: 'center',
            valign: 'middle',
            sortable: false,           
        },{
            field: 'status',
            title: '启用状态',
            align: 'center',
            valign: 'middle',
            sortable: false, 
            formatter : function (value) {
            	if(value=="1"){
            		return "启用";
            	}else if(value == "0"){
            		return "禁用";
            	}
            }
        },{
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
            formatter : function (value,row) {
            	if(row.status=="1"){
            		var statusBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:statusUser(\"" + value + "\",\"" + row.status + "\")'><i class='fa fa-pencil-square-o'></i> 禁用</a>";
            	}else if(row.status=="0"){
            		var statusBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:statusUser(\"" + value + "\",\"" + row.status + "\")'><i class='fa fa-pencil-square-o'></i> 启用</a>";
            	}
            	var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteUser(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

                return statusBtn + OPERATION_SEPARATOR + editBtn + OPERATION_SEPARATOR + deleteBtn ;
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
	addNews('新增图片',basePathJS + '/dirHome/add',500,300);
}

function statusUser(id,status) {
	var url = basePathJS + "/dirHome/updateStatus";
    var parameter = {id: id,status:status};
    updateStatus(url , parameter) ;
}

function editUser(id) {
	updateForNews('编辑图片',basePathJS + '/dirHome/edit' , id,900,600);
}

function deleteUser(id) {
    var url = basePathJS + "/dirHome/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}