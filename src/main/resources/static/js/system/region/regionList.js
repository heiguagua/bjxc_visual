var tableSelector = '#systemRegionTableId';
var paramsObj = {};
var regionCodes=new Array();
jQuery(document).ready(function () {
    "use strict";
    $("#searchKeyId").keydown(function(e){
        var curKey = e.which;
        if(curKey == 13){
            initDept();
            return false;//这句非常重要。如果没有这句，那么查询出结果后，会出现刷新页面动作等，导致查询结果失效。
        }
    });
    initDept();
    jQuery('#queryBtnId').click(function () {
        var fcode = "";
        if(regionCodes.length>0){
            fcode= regionCodes[regionCodes.length-1];
        }
        initDept(fcode,"subQuery");
    });
});

function setParams(fcode,subQueryFlag) {
    if(fcode){
        //查看下级时，清空searchKeyId
        if(subQueryFlag!="subQuery"){
            $('#searchKeyId').val("");
        }
        paramsObj.fcode=fcode;
    }else{
        paramsObj.fcode=undefined;
    }
    var searchKeyVal = $('#searchKeyId').val();
    paramsObj.searchKey=searchKeyVal;
}
function showOrHideButton(fcode) {
    if(fcode){
        $("#createRegionA").addClass("hidden");
        $("#back").removeClass("hidden");
    }else{
        $("#back").addClass("hidden");
        $("#createRegionA").removeClass("hidden");
    }

}

function listChildRegion(fcode) {
    regionCodes.push(fcode);
    initDept(fcode);
}

function backPreRegionList() {
    var id=regionCodes.pop();
    var fcode= regionCodes[regionCodes.length-1];
    initDept(fcode);
}

function initDept(fcode,subQueryFlag) {

    $("#tableList").html('<table id="systemRegionTableId" class="table table-hover"></table>');
    showOrHideButton(fcode);
    setParams(fcode,subQueryFlag);
    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/region/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 15,
        columns: [{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'regionName',
            title: '行政区域',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'regionCode',
            title: '区域编码',
            align: 'left',
            valign: 'middle',
            sortable: false,
            formatter:function(value, row, index){
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'pinyin',
            title: '拼音',
            align: 'left',
            valign: 'middle',
            sortable: false,
            formatter:function(value, row, index){
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'cNum',
            title: '下级区域数量',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'versionId',
            title: '版本号',
            align: 'left',
            valign: 'middle',
            sortable: false
        }, {
            field: 'status',
            title: '状态',
            align: 'left',
            valign: 'middle',
            sortable: false,
            formatter: function (value) {
                var res;
                if (value == 1) {
                    res = "启用";
                }
                else {
                    res = "<font color='red'> 禁用</font>";
                }
                return res;
            }
        }, {
            field: 'id',
            title: '操作',
            align: 'left',
            valign: 'middle',
            width: '8%',
            sortable: false,
            formatter: function (value, row, index) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:editRegion(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var showBtn =   "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:showRegion(\"" + row.regionCode + "\")'><i class='fa fa-chain'></i>查看下级</a>";
                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='###' onclick='javascript:deleteRegion(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
                var initDeptBtn = "<a class='btn btn-danger btn-flat btn-xs' href='###' onclick='javascript:initTopDept(\"" + value + "\")'><i class='fa fa-times'></i>初始化顶级部门</a>";
                return editBtn + OPERATION_SEPARATOR +showBtn+OPERATION_SEPARATOR+ deleteBtn+OPERATION_SEPARATOR+initDeptBtn;
            }
        }]
    });
}

function showRegion(fcode) {
    listChildRegion(fcode);
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addRegion() {
    add('新增区域', basePathJS + '/system/region/add',900,600);
}

function editRegion(id) {
    update('编辑区域', basePathJS + '/system/region/edit', id,900,600);
}

function deleteRegion(id) {
    var url = basePathJS + "/system/region/delete";
    var parameter = {id: id};
    delObj(url, parameter);
}

function deleteBatchRegion() {
    var url = basePathJS + "/system/region/deleteBatch";
    deleteALLSelect(url , tableSelector);
}

function initTopDept(id){
    var url = basePathJS + "/system/region/initDept";
    var parameter = {id: id};
    confirmMsg("初始化确认","你确定要初始化当前区域的顶级部门吗？",url , parameter) ;
}