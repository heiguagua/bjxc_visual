/**
 * Created by Zhangm on 2017/9/27.
 */
var tableSelector = '#systemDataDictDetailsTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).customTable({
        url: basePathJS + '/sysDict/list',
        queryParams: function (params) {

            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 15,
        columns: [
            {
                field: 'id', title: '序号', width: '5%', align: 'center', formatter: function (value, row, index) {
                return index + 1;
            }
            },
            {
                field: 'category',
                title: '字典类型',
                align: 'center',
                valign: 'middle',
                // width : '150px' ,
                sortable: false
            }, {
                field: 'categoryCode',
                title: '配置项编码',
                align: 'center',
                valign: 'middle',
                // width : '150px' ,
                sortable: false
            },
            {
                field: 'categoryName',
                title: '配置项名称',
                align: 'center',
                valign: 'middle',
                // width : '400px' ,
                sortable: false
            },
            {
                field: 'status',
                title: '适用范围',
                align: 'center',
                valign: 'middle',
                sortable: false
            },
            {
                field: 'orderNumber',
                title: '顺序',
                align: 'center',
                valign: 'middle',
                sortable: false
            }, {
                field: 'status',
                title: '是否生效',
                align: 'center',
                valign: 'middle',
                // width : '400px' ,
                sortable: false
            }, {
                field: 'categoryDesc',
                title: ' 描述',
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
                    var editBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:editDictDetails(\"" + value + "\")'><i class='fa fa-times'></i> 修改</a>";
                    var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteDictDetails(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";

                    return editBtn + OPERATION_SEPARATOR +  deleteBtn ;
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


function editDictDetails(id) {
    update('编辑字典',basePathJS + '/sysDict/edit' , id );
}
function deleteDictDetails(id) {
    var url = basePathJS + "/sysDict/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}



