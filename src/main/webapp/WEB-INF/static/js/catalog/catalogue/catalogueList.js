var tableSelector = '#catalogueTable';
var paramsObj = {};

jQuery(document).ready(function () {
    "use strict";

    initTable();
    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        var searchKeyVal = $('#searchKeyId').val();
        paramsObj = {searchKey : searchKeyVal};
    }

});

function initTable(){
    jQuery(tableSelector).customTable({
        url: basePathJS + '/catalog/catalogue/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'set_name',
            title: '信息资源名称',
            sortable: true, //启用排序
            width: '20%'
        }, {
            field: 'dir_structure',
            title: '所属目录类别'
        }, {
            field: 'audit_status',
            title: '状态',
            width: '5%',
            formatter: function(value, row, index) {
                if (row['audit_status'] === 0) {
                    return '待注册'
                }
                if (row['audit_status'] === 1) {
                    return '已注册';
                }
                if (row['audit_status'] === 2) {
                    return '待审核';
                }
                if (row['audit_status'] === 3) {
                    return '待发布';
                }
                if (row['audit_status'] === 4) {
                    return '已发布';
                }
            }
        }, {
            field: 'uuid',
            title: '操作',
            width: '10%',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter: function(value) {
                var editBtn = [
                    "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:catalogueTableDel(\"" + value + "\")'><i class='fa fa-close'>&#160;</i>删除</a>&#160;",
                    "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableEdit(\"" + value + "\")'><i class='fa fa-edit'>&#160;</i>编辑</a>"
                ].join('');
                return editBtn;
            }
        }]
    });
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addCustom() {
    add('新增信息资源',basePathJS + '/catalog/catalogue/add',1300,700);
}

function editDept(id) {
    update('编辑组织机构',basePathJS + '/system/dept/edit' , id );
}

function deleteDept(id) {
    var url = basePathJS + "/system/dept/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}

function quickAddDatasetUI() {
    add('从资源梳理添加',basePathJS + '/catalog/catalogue/quickAddDatasetUI',1300,800);
}
function quickSystemAddDatasetUI() {
    add('从系统梳理添加',basePathJS + '/catalog/catalogue/quickSystemAddDatasetUI',1300,800);
}