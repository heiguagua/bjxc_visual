var tableSelector = '#systemAuthDeptDirTableId';

jQuery(document).ready(function () {
    "use strict";
    var paramsObj = {};

    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/deptAuthority/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 15,
        columns: [{
            checkbox: true,
            //align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptName',
            title: '组织机构名称',
            //align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptAlias',
            title: '组织机构简称',
            //align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false
        }, {
            field: 'deptCode',
            title: '组织机构编码',
            //align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'regionName',
            title: '所属行政区域',
            //align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'deptContactMan',
            title: '联系人',
            //align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false
        }, {
            field: 'deptContactPhone',
            title: '联系电话',
            //align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false
        }, {
            field: 'deptAddress',
            title: '地址',
            //align: 'center',
            valign: 'middle',
            sortable: false,
            visible:false
        }, {
        	 field: 'deptDesc',
             title: '描述',
             width: 250,
             //align: 'center',
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
            field: 'id',
            title: '操作',
            //align: 'center',
            valign: 'middle',
            sortable: false ,
            width: '220',
            formatter : function (value) {
                var allotBtn =   "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dirAllot(\"" + value + "\")'><i class='fa fa-chain'></i>目录数据分配</a>";
                return allotBtn + OPERATION_SEPARATOR ;
            }
        }]
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        var searchKeyVal = $('#searchKeyId').val();
        var regionName = $('#regionNameId').val();
        paramsObj = {searchKey : searchKeyVal,regionName:regionName};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function  dirAllot(id) {
    update('分配数据权限', basePathJS + '/system/deptDirAuthority/edit', id, 500, 300);
}