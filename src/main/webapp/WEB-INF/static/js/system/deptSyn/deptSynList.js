var tableSelector = '#systemDeptSynTableId';

jQuery(document).ready(function () {
    "use strict";
    $("#searchKeyId").keydown(function(e){
        var curKey = e.which;
        if(curKey == 13){
        	setParams();
        	reloadTable();//此处可以是你要执行的功能
            return false;//这句非常重要。如果没有这句，那么查询出结果后，会出现刷新页面动作等，导致查询结果失效。
        }
    });
    var paramsObj = {};
    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/deptSyn/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 15,
        columns: [{
            field:'deptLevel',
            visible:false
        },{
            field:'treeIndex',
            visible:false
        },{
            field:'treeCode',
            visible:false
        },{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptName',
            title: '组织机构名称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptCode',
            title: '组织机构编码',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'isSync',
            title: '是否已同步目录',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter : function (value){
                // if(value == '0'){
                //     return "否";
                // }else if(value == '1'){
                //     return "是";
                // }
                if(value){
                    return "是";
                }else{
                    return "否";
                }
            }
        }],
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        var searchKeyVal = $('#searchKeyId').val();
        paramsObj= {searchKey: searchKeyVal};

    }

});

function syncDeptClassify(){

	    var dcmIds="";
	    var selectedRow = $(tableSelector).bootstrapTable('getSelections');
	    if(selectedRow && selectedRow.length > 0) {
	        for (var i = 0, ii = selectedRow.length; i < ii; i++) {
	            var dcmId = selectedRow[i].id;
	            dcmIds += i == 0 ? dcmId : "," + dcmId;
	        }
	        var parameter = {dcmIds: dcmIds};
	        sync(basePathJS + '/system/deptSyn/doSycn' , parameter );
	    }else{
	        errorMsgTip("请先选择要同步目录的部门");
	    }

}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}
