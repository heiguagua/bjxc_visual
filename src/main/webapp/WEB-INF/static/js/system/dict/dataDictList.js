/**
 * Created by Zhangm on 2017/9/26.
 */
var tableSelector = '#systemDataDictTableId';

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
            title: '类型编码',
            align: 'center',
            valign: 'middle',
            // width : '150px' ,
            sortable: false
        }, {
            field: 'dictName',
            title: '类型名称',
            align: 'center',
            valign: 'middle',
            // width : '150px' ,
            sortable: false
        }, {
            field: 'status',
            title: '是否生效',
            align: 'center',
            valign: 'middle',
            // width : '400px' ,
            sortable: false
        }, {
            field: 'dictDesc',
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
                    var detailBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dictDetails(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 字典明细 </a>";
                    var editBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:editDict(\"" + value + "\")'><i class='fa fa-times'></i> 修改</a>";
                    // return editBtn + OPERATION_SEPARATOR +  deleteBtn ;
                    return detailBtn + OPERATION_SEPARATOR + editBtn ;
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


function editDict(id) {
    update('编辑字典',basePathJS + '/sysDict/edit' , id );
}

function dictDetails(id) {

}

function deleteSetting(id) {
    var url = basePathJS + "/system/setting/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}
