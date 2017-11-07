var tableSelector = '#systemDeptTableId';
var paramsObj = {};
var ids=new Array();
//1
jQuery(document).ready(function () {
    "use strict";
    $("#searchKeyId").keydown(function(e){
        var curKey = e.which;
        if(curKey == 13){
        	// setParams();
        	// reloadTable();//此处可以是你要执行的功能
            initDept();
            return false;//这句非常重要。如果没有这句，那么查询出结果后，会出现刷新页面动作等，导致查询结果失效。
        }
    });
    $("#regionNameId").keydown(function(e){
        var curKey = e.which;
        if(curKey == 13){
        	// setParams();
        	// reloadTable();//此处可以是你要执行的功能
            initDept();
            return false;//这句非常重要。如果没有这句，那么查询出结果后，会出现刷新页面动作等，导致查询结果失效。
        }
    });
    initDept();

    jQuery('#queryBtnId').click(function () {
        // setParams();
        // reloadTable();
        initDept();
    });



});

function setParams(pid) {

    // paramsObj= {searchKey: searchKeyVal};

    if(pid){
        //查看下级时，清空searchKeyId
        $('#searchKeyId').val("");
        $('#regionNameId').val("");
        paramsObj.fid=pid;
    }else{
        paramsObj.fid=undefined;
    }
    var searchKeyVal = $('#searchKeyId').val();
    var regionName = $('#regionNameId').val();
    paramsObj.searchKey=searchKeyVal;
    paramsObj.regionName=regionName;
}
function showOrHideButton(pid) {
    if(pid){
        $("#createDeptA").addClass("hidden");
        // $("#sysDeptA").addClass("hidden");
        $("#back").removeClass("hidden");
    }else{
        $("#back").addClass("hidden");
        // $("#sysDeptA").removeClass("hidden");
        $("#createDeptA").removeClass("hidden");
    }

}

function listChildDept(pid) {
    ids.push(pid);
    initDept(pid);
}

function backPreDeptList() {
    var id=ids.pop();
    var pid= ids[ids.length-1];
    initDept(pid);
}

function initDept(pid) {

    $("#tableList").html('<table id="systemDeptTableId" class="table table-hover"></table>');
    showOrHideButton(pid);
    setParams(pid);
    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/dept/list',
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
            sortable: false,
            visible:false
        }, {
            field: 'deptShortName',
            title: '组织机构简称',
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
            field: 'regionName',
            title: '所属行政区域',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'fname',
            title: '上级组织机构名称',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'cNum',
            title: '下级机构数量',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'updateTime',
            title: '更新时间',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptContactMan',
            title: '联系人',
            align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false,
            formatter: function (value) {
                var desc;
                if (value) {
                    if (value.length > 10) {
                        desc = value.substring(0, 10);
                        desc += ' ...';
                    } else {
                        desc = value;
                    }
                }
                return desc;
            }
        }, {
            field: 'deptContactPhone',
            title: '联系电话',
            align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false
        }, {
            field: 'deptAddress',
            title: '地址',
            align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false,
            formatter: function (value) {
                var desc;
                if (value) {
                    if (value.length > 10) {
                        desc = value.substring(0, 10);
                        desc += ' ...';
                    } else {
                        desc = value;
                    }
                }
                return desc;
            }
        }, {
            field: 'deptDesc',
            title: '描述',
            width: 250,
            align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false,
            formatter: function (value) {
                var desc;
                if (value) {
                    if (value.length > 15) {
                        desc = value.substring(0, 15);
                        desc += ' ...';
                    } else {
                        desc = value;
                    }
                }
                return desc;
            }
        }, {
            field: 'isSync',
            title: '是否已同步目录',
            align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false,
            formatter : function (value){
                if(value == '0'){
                    return "否";
                }else if(value == '1'){
                    return "是";
                }
            }
        },{
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            sortable: false ,
            width: '20%',
            formatter : function (value) {
                var allotBtn =   "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:allotDept(\"" + value + "\")'><i class='fa fa-chain'></i>创建下级</a>";
                var showBtn =   "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:showDept(\"" + value + "\")'><i class='fa fa-chain'></i>查看下级</a>";
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editDept(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteDept(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
                return allotBtn + OPERATION_SEPARATOR + showBtn + OPERATION_SEPARATOR + editBtn + OPERATION_SEPARATOR +  deleteBtn  ;
                // return allotBtn + OPERATION_SEPARATOR + editBtn + OPERATION_SEPARATOR +  deleteBtn  ;
            }
        }],
    });
}


// function syncDeptClassify(){
//
// 	    var dcmIds="";
// 	    var selectedRow = $(tableSelector).bootstrapTable('getSelections');
// 	    if(selectedRow && selectedRow.length > 0) {
// 	        for (var i = 0, ii = selectedRow.length; i < ii; i++) {
// 	            var dcmId = selectedRow[i].id;
// 	            dcmIds += i == 0 ? dcmId : "," + dcmId;
// 	        }
// 	        var parameter = {dcmIds: dcmIds};
// 	        sync(basePathJS + '/system/dept/doSycn' , parameter );
// 	    }else{
// 	        errorMsgTip("请先选择要同步目录的部门");
// 	    }
//
// }

function reloadTable() {
//    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addDept() {
    add('新增组织机构',basePathJS + '/system/dept/add',900,600);
}

function allotDept(id) {
    update('创建下级组织机构',basePathJS + '/system/dept/allot', id);
}
function showDept(id) {
    listChildDept(id);
}



function editDept(id) {
    update('编辑组织机构',basePathJS + '/system/dept/edit', id ,900,600);
    // update('编辑组织机构',basePathJS + '/system/dept/edit?deptLevel=1&treeIndex=0&treeCode=', id );
}

function deleteDept(id) {
    var url = basePathJS + "/system/dept/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}
function deleteBatchDept() {
    var url = basePathJS + "/system/dept/deleteBatch";
    deleteALLSelect(url , tableSelector);
}