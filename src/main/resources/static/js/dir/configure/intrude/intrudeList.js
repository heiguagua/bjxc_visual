var tableSelector = '#intrudeListId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {deleteFlag:0};

    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirIntrude/list',
        escape:false,
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [    
           {
            field: 'category',
            title: '简介分类',
            align: 'left',
            valign: 'middle',
            sortable: false,
                       
        }, {
            field: 'publisherName',
            title: '发布人',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'publishDate',
            title: '发布时间',
            align: 'left',
            valign: 'middle',
            sortable: false
        },
		{
		    field: 'content',
		    title: '内容',
		    align: 'left',
		    valign: 'middle',
		    sortable: false, 
		    formatter:function(value){
		     var str  = $(value).text().replace(/(^\s*)|(\s*$)/g, "");
		    	if(str !== "" || str !== undefined){
		    			return "<p title="+str+">"+str+"</p>"
		    	}
		    }
		}, 
        {
            field: 'id',
            title: '操作',
            align: 'left',
            valign: 'middle',
            sortable: false ,
            formatter : function (value) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:editUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
               // var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='###' onclick='javascript:deleteUser(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

                return editBtn + OPERATION_SEPARATOR  ;
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
    addPolicy('新增网站简介内容',basePathJS + '/dirIntrude/add',900,600);
}

function editUser(id) {
    updatePolicy('编辑网站简介内容',basePathJS + '/dirIntrude/edit' , id,900,600);
}

function deleteUser(id) {
    var url = basePathJS + "/dirIntrude/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}