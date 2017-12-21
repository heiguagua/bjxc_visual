var tableSelector = '#dirSpecialAppsTableId';

jQuery(document).ready(function () {
	$.initCategoryAppTreeSelect('treeDemol','appCategoryl','dictCodel','menuContentl');
    "use strict";
    var paramsObj = {deleteFlag:0};
    
    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirSpecialApps/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'appName',
            title: '应用名称',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'dictName',
            title: '所属类别',
            align: 'left',
            width: "10%",
            valign: 'middle',
            sortable: false
        }, {
            field: 'appUrl',
            title: '应用URL',
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
            field: 'orderNumber',
            title: '排序',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'createTime',
            title: '创建应用时间',
            align: 'left',
            valign: 'middle',
            sortable: false
        },{
            field: 'id',
            title: '操作',
            align: 'left',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:editUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='###' onclick='javascript:deleteUser(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

                return editBtn + OPERATION_SEPARATOR +  deleteBtn ;
            }
        }]
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    
    function setParams() {
    	if($('#appCategoryl').val()==""){
        	$('#dictCodel').val("");
        }
        var searchKeyVal = $('#searchKeyId').val();
        var dicCodel = $('#dictCodel').val();       
        paramsObj = {searchKey : searchKeyVal,deleteFlag:0,dicCodel:dicCodel};
    }
    
    
    
    
    
    

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addUser() {
	addPictureNews('新增应用',basePathJS + '/dirSpecialApps/add');
}

function editUser(id) {
	updateForPictureNews('编辑应用',basePathJS + '/dirSpecialApps/edit' , id);
}

function deleteUser(id) {
    var url = basePathJS + "/dirSpecialApps/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}