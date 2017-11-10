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
            title: '标识',
            align: 'left',
            width: '75px',
            valign: 'middle',
            sortable: false
        },{
            field: 'productName',
            title: '名称',
            align: 'center',
            width: '75px',
            valign: 'middle',
            sortable: false
        },{
            field: 'productShowName',
            title: '显示名称',
            align: 'center',
            width: '100px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'rootPath',
            title: '根路径',
            align: 'center',
            width: '100px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'ssoPath',
            title: '单点登录地址',
            align: 'center',
            width: '100px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'orderNumber',
            title: '顺序',
            align: 'center',
            width: '75px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'integrateFlag',
            title: '集成否',
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
            title: '本页打开',
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
            title: '图标',
            align: 'center',
            width: '50px',
            valign: 'middle',
            sortable: false,
            formatter : function (value) {
                var url=basePathJS+value;
                return '<img src="'+url+'"/>';
            }

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
            field: 'jumpUrl',
            title: '跳转URL',
            align: 'center',
            width: '100px',
            valign: 'middle',
            sortable: false,
            visible:false
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