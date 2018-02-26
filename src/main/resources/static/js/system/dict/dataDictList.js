/**
 * Created by Zhangm on 2017/9/26.
 */
var tableSelector = '#systemDataDictTableId';
var paramsObj={};
var detailParamObj={};

jQuery(document).ready(function () {
    intDict();
    initButtonClick();
});

function intDict(param) {
    // $("#tableList").html('<table id="systemDataDictTableId" class="table table-hover"></table>');
    $("#addDict2").addClass("hidden")
    $("#addDict1").removeClass("hidden")
    $("#back").addClass("hidden")
    $("#search").removeClass("hidden")
    $("#searchDetail").addClass("hidden")
    $("#deleteBatchDivId").addClass("hidden")
    "use strict";
    paramsObj = param||{};
    if($(tableSelector).hasClass("table-striped")){
        $(tableSelector).bootstrapTable("destroy");
    }
    jQuery(tableSelector).customTable({
        url: basePathJS + '/sysDict/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        // pagination: true, //分页
        // pageSize: 15,
        columns: [
            {
                field: 'id', title: '序号', width: '5%', align: 'center', formatter: function (value, row, index) {
                return index + 1;
            }
            },
            {
                field: 'categoryCode',
                title: '类型编码',
                align: 'left',
                valign: 'middle',
                // width : '150px' ,
                sortable: false
            }, {
                field: 'categoryName',
                title: '类型名称',
                align: 'left',
                valign: 'middle',
                // width : '150px' ,
                sortable: false
            }, {
                field: 'categoryDesc',
                title: ' 描述',
                align: 'left',
                valign: 'middle',
                sortable: false
            }, {
                field: 'categoryCode',
                title: '操作',
                align: 'left',
                valign: 'middle',
                sortable: false ,
                formatter : function (value,row) {
                    var detailBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:getDictDetails(\"" + value + "\",\""+row.categoryName+"\")'><i class='fa fa-pencil-square-o'></i> 字典明细 </a>";
                    var editBtn = "<a class='btn btn-danger btn-flat btn-xs' href='###' onclick='javascript:editDict(\"" + value + "\")'><i class='fa fa-times'></i> 修改</a>";
                    var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='###' onclick='javascript:deleteDict(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
                    // return detailBtn + OPERATION_SEPARATOR + editBtn+ OPERATION_SEPARATOR + deleteBtn ;
                    return detailBtn + OPERATION_SEPARATOR + editBtn ;
                }
            }]
    });
}

function initButtonClick() {

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    jQuery('#queryBtnId1').click(function () {
        setDetailParams();
        reloadTable();
    });
}

function setParams() {
    var searchKeyVal = $('#searchKeyId').val();
    paramsObj = {searchKey : searchKeyVal};
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function setDetailParams() {
    var searchKeyVal = $('#searchKeyId1').val();
    var  category =  $("#category").val();
    detailParamObj = {searchKey : searchKeyVal,category:category};
}



function addDict() {
    add('新增字典',basePathJS + '/sysDict/add');
}
function editDict(id) {
    update('编辑字典',basePathJS + '/sysDict/edit' , id );
}


function deleteDict(categoryCode) {
    var url = basePathJS + "/sysDict/delete";
    var parameter = {categoryCode: categoryCode};
    delObj(url , parameter) ;
}
function getDictDetails(categoryCode,dd,searchKey) {
    $("#addDict1").addClass("hidden")
    $("#addDict2").removeClass("hidden")
    $("#back").removeClass("hidden")

    $("#search").addClass("hidden")
    $("#searchDetail").removeClass("hidden")
    $("#deleteBatchDivId").removeClass("hidden")
    $("#category").val(categoryCode);
    $("#dd").val(dd);


    // $("#tableList").html('<table id="systemDataDictDetailTableId" class="table table-hover"></table>');
    var url = basePathJS + '/sysDict/detailsList';
    setDetailParams();
    if($(tableSelector).hasClass("table-striped")){
        $(tableSelector).bootstrapTable("destroy");
    }
    jQuery(tableSelector).customTable({
        url:url,
        queryParams: function (params) {
            return $.extend(params, detailParamObj);
        },
        columns: [{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        },{
                field: 'id', title: '序号', width: '5%', align: 'center', formatter: function (value, row, index) {
                return index + 1;
            }
            },
            {
                field: 'categoryName',
                title: '字典类型',
                align: 'left',
                valign: 'middle',
                // width : '150px' ,
                sortable: false,
                formatter: function () {
                    return $("#dd").val();
                }
            }, {
                field: 'dictCode',
                title: '配置项编码',
                align: 'left',
                valign: 'middle',
                // width : '150px' ,
                sortable: false
            },
            {
                field: 'dictName',
                title: '配置项名称',
                align: 'left',
                valign: 'middle',
                // width : '400px' ,
                sortable: false
            },
            {
                field: 'regionName',
                title: '适用范围',
                align: 'left',
                valign: 'middle',
                sortable: false
            },
            {
                field: 'orderNumber',
                title: '顺序',
                align: 'left',
                valign: 'middle',
                sortable: false
            }, {
                field: 'stateName',
                title: '是否生效',
                align: 'left',
                valign: 'middle',
                // width : '400px' ,
                sortable: false
            }, {
                field: 'dictDesc',
                title: ' 描述',
                align: 'left',
                valign: 'middle',
                sortable: false
            }, {
                field: 'id',
                title: '操作',
                align: 'left',
                valign: 'middle',
                sortable: false ,
                formatter : function (value,row) {
                    var editBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:editDictDetails(\"" + value + "\")'><i class='fa fa-times'></i> 修改</a>";
                    var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteDictDetails(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

                    return editBtn;
                    // return editBtn + OPERATION_SEPARATOR +  deleteBtn ;
                }
            }]
    });
}

function addDetailDict() {
    var category = $("#category").val();
    add('新增字典',basePathJS + '/sysDict/detailAdd?category='+category);
}
function editDictDetails(id) {
    update('编辑字典',basePathJS + '/sysDict/detailEdit' , id );
}
function deleteDictDetails(id) {
    var url = basePathJS + "/sysDict/detailDelete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}

function deleteBatchDict() {
    var url = basePathJS + "/sysDict/detailDeleteBatch";
    deleteALLSelect(url , tableSelector);
}