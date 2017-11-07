var tableSelector = '#productIntegrateTableId';
//1
jQuery(document).ready(function () {

    var paramsObj = {};
    jQuery(tableSelector).customTable({
        url: basePathJS + '/system/productIntegrate/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            field: 'productNo',
            title: '产品标识',
            align: 'left',
            width: '75px',
            valign: 'middle',
            sortable: false
        },{
            field: 'productName',
            title: '产品名称',
            align: 'center',
            width: '75px',
            valign: 'middle',
            sortable: false
        },{
            field: 'productShowName',
            title: '产品显示名称',
            align: 'center',
            width: '100px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'rootPath',
            title: '产品访问根路径地址',
            align: 'center',
            width: '100px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'ssoPath',
            title: '单点登录跳转地址',
            align: 'center',
            width: '100px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'orderNumber',
            title: '显示顺序',
            align: 'center',
            width: '75px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'integrateFlag',
            title: '是否集成',
            align: 'center',
            width: '75px',
            valign: 'middle',
            sortable: false,
            formatter : function (value) {
                var statusDesc;
                if(value == 1){
                    statusDesc = "是";
                }else if(value == 0){
                    statusDesc = "否";
                }
                return statusDesc;
            }
        }, {
            field: 'curOpenFlag',
            title: '前页面打开',
            align: 'center',
            width: '75px',
            valign: 'middle',
            sortable: false,
            formatter : function (value) {
                var statusDesc;
                if(value == 1){
                    statusDesc = "是";
                }else if(value == 0){
                    statusDesc = "非";
                }
                return statusDesc;
            }
        }, {
            field: 'icon',
            title: '显示图标',
            align: 'center',
            width: '100px',
            valign: 'middle',
            sortable: false

        }, {
            field: 'masterFlag',
            title: '主属节点',
            align: 'center',
            width: '75px',
            valign: 'middle',
            sortable: false,
            formatter : function (value) {
                var statusDesc;
                if(value == 1){
                    statusDesc = "主";
                }else if(value == 0){
                    statusDesc = "从";
                }
                return statusDesc;
            }
        }, {
            field: 'status',
            title: '状态',
            align: 'center',
            width: '100px',
            valign: 'middle',
            sortable: false,
            visible:false,
            formatter : function (value) {
                var statusDesc;
                if(value == 1){
                    statusDesc = "启用";
                }else if(value == 0){
                    statusDesc = "禁用";
                }
                return statusDesc;
            }
        }]
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });

    function setParams() {
        // var searchKeyVal = $('#searchKeyId').val();
        // paramsObj = {menuName : searchKeyVal};
    }

});

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addMenu() {
    add('新增菜单', basePathJS + '/system/menu/add');
}

function editMenu(id) {
    update('编辑菜单', basePathJS + '/system/menu/edit' , id );
}

function deleteMenu(id) {
    var url = basePathJS + "/system/menu/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}