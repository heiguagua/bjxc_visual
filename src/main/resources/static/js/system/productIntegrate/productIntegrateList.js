var tableSelector = '#productIntegrateTableId';
//1
jQuery(document).ready(function () {

    var paramsObj = {};

    var isMaster=$("#masterId").val();
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
            sortable: false,
            formatter:function(value){
                if(value == undefined){
                    value="";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'productName',
            title: '名称',
            align: 'left',
            width: '75px',
            valign: 'middle',
            sortable: false
        },{
            field: 'productShowName',
            title: '显示名称',
            align: 'left',
            width: '100px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'rootPath',
            title: '根路径',
            align: 'left',
            width: '100px',
            valign: 'middle',
            sortable: false,
            formatter:function(value){
            	if(value !==""){
            		return '<p title="'+value+'">'+value+'</p>'
            	}
            }
        }, {
            field: 'ssoPath',
            title: '单点登录地址',
            align: 'left',
            width: '100px',
            valign: 'middle',
            sortable: false,
            formatter:function(value){
            	if(value !==""){
            		return '<p title="'+value+'">'+value+'</p>'
            	}
            }
        }, {
            field: 'orderNumber',
            title: '顺序',
            align: 'left',
            width: '75px',
            valign: 'middle',
            sortable: false
        }, {
            field: 'integrateFlag',
            title: '集成否',
            align: 'left',
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
            align: 'left',
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
            align: 'left',
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
            align: 'left',
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
            field: 'id',
            title: '操作',
            align: 'left',
            valign: 'middle',
            width: '8%',
            sortable: false,
            formatter: function (value) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:editProInt(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
                var synBtn = "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:sendEndPoint(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i>推送</a>";
                if(isMaster==="true") {
                    return editBtn+OPERATION_SEPARATOR+synBtn;
                // }else{
                //     return "子系统只能同步";
                }
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


function editProInt(id) {
    update('编辑', basePathJS + '/system/productIntegrate/edit' , id );
}

function sendEndPoint(id){
    var url = basePathJS + "/system/productIntegrate/send";
    var parameter = {id: id};
    send(url , parameter) ;
}