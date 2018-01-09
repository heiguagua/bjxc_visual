var tableSelector = '#dirNewsTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {deleteFlag:"0"};
    
    jQuery(tableSelector).customTable({
        url: basePathJS + '/portalConfig/dirNews/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
        	field: 'title',
            title: '新闻标题',
            align: 'left',
            valign: 'middle',
            sortable: false,
            formatter:function(value){
                if(value == undefined){
                    value="";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'newsPic',
            title: '图片名称',
            align: 'left',
            valign: 'middle',
            sortable: false,
            formatter:function(value){
                if(value == undefined){
                    value="";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'picType',
            title: '图片类型',
            align: 'left',
            width:"10%",
            valign: 'middle',
            sortable: false,       
        }, {
            field: 'picOrder',
            title: '播放顺序',
            align: 'left',
            width:"10%",
            valign: 'middle',
            sortable: false,           
        },{
            field: 'status',
            title: '启用状态',
            align: 'left',
            width:"10%",
            valign: 'middle',
            sortable: false,           
        },{
            field: 'createTime',
            title: '创建时间',
            align: 'left',
            width:"16%",
            valign: 'middle',
            sortable: false,
            formatter:function(value){
                if(value == undefined){
                    value="";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'id',
            title: '操作',
            align: 'left',
            width:"20%",
            valign: 'middle',
            sortable: false ,
            formatter : function (value,row) {
            	if(row.status=="1"){
            		var statusBtn = "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:statusUser(\"" + value + "\",\"" + row.status + "\")'><i class='fa fa-pencil-square-o'></i> 禁用</a>";
            	}else if(row.status=="0"){
            		var statusBtn = "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:statusUser(\"" + value + "\",\"" + row.status + "\")'><i class='fa fa-pencil-square-o'></i> 启用</a>";
            	}
            	var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:editUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='###' onclick='javascript:deleteUser(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

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
	addPictureNews('新增图片',basePathJS + '/portalConfig/dirNews/add',"70%",600);
}

function statusUser(id,status) {
	var url = basePathJS + "/portalConfig/dirNews/updateStatus";
    var parameter = {id: id,status:status};
    updateStatus(url , parameter) ;
}

function editUser(id) {
	updateForPictureNews('编辑图片',basePathJS + '/portalConfig/dirNews/edit' , id,"70%",600);
}

function deleteUser(id) {
    var url = basePathJS + "/portalConfig/dirNews/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}