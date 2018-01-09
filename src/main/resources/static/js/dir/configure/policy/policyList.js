var tableSelector = '#policyListId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {deleteFlag:0};

    jQuery(tableSelector).customTable({
        url: basePathJS + '/portalConfig/dirPolicy/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        escape:false,
        columns: [{
            field: 'title',
            title: '标题',
            align: 'left',
            valign: 'middle',
            sortable: false,
            formatter:function(value){
                if(value == undefined){
                    value="";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },
        {
            field: 'policyLevel',
            title: '政策级别',
            align: 'left',
            width:"10%",
            valign: 'middle',
            sortable: false,
            formatter : function (value) {            	
            	if(value =='G') {
            		return '国家级';
            	}else if(value == 'S'){            		
            		return '省级';
            	}else if(value == 'C'){
            		return '市级';
            	}else{
            		return '';
            	}                
            }            
        }, {
            field: 'userName',
            title: '创建人',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'createTime',
            title: '创建时间',
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
    	
    	var levelC = $('#levelC').val(); 
        var searchKeyVal = $('#searchKeyId').val();
        paramsObj = {searchKey : searchKeyVal,deleteFlag:0,levelC:levelC};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addUser() {
    addPolicy('新增政策',basePathJS + '/portalConfig/dirPolicy/add',"70%",600);
}

function editUser(id) {
    updatePolicy('编辑政策',basePathJS + '/portalConfig/dirPolicy/edit' , id,"70%",600);
}

function deleteUser(id) {
    var url = basePathJS + "/portalConfig/dirPolicy/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}