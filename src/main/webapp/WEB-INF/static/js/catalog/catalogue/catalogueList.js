var tableSelector = '#catalogueTable';
var paramsObj = {};

jQuery(document).ready(function () {
    initTable();
    initAllSelect();
    initButtonClickEvent();
});

function initTable(){
    jQuery(tableSelector).customTable({
        url: basePathJS + '/catalog/catalogue/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        },{
            field: 'id',
            visible: false
        },{
            field: 'deptName',
            title: '牵头部门',
            sortable: false,
            width: '15%',
            formatter:function(value, row, index){
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'datasetName',
            title: '信息资源名称',
            sortable: false,
            width: '20%',
            formatter:function(value, row, index){
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'classifyName',
            title: '所属目录类别',
            sortable: false,
            formatter:function(value, row, index){
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'classifyStatus',
            title: '状态',
            width: '5%',
            sortable: false,
            formatter: function(value, row, index) {
                if (value == 0) {
                    return '待注册'
                }else if (value == 1) {
                    return '待审核';
                }else if (value == 2) {
                    return '审核不通过';
                }else if (value == 3) {
                    return '待发布';
                }else if (value == 4) {
                    return '驳回审核';
                }else if (value == 5) {
                    return '已发布';
                }else if (value == 6) {
                    return '已下架';
                }
            }
        }, {
            field: 'uuid',
            title: '操作',
            width: '10%',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter: function(value, row, index) {
                var editBtn ="";
                if(row.classifyStatus==0 || row.classifyStatus==2 || row.classifyStatus==4 || row.classifyStatus==6){
                    editBtn = [
                        "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:catalogueTableEdit(\"" + value + "\")'><i class='fa fa-close'>&#160;</i>编辑</a>&#160;",
                        "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-edit'>&#160;</i>查看</a>"
                    ].join('');
                }else{
                    editBtn = [
                        "<a class='btn btn-danger btn-flat btn-xs' disabled=true style='opacity: 0.2'><i class='fa fa-close'>&#160;</i>编辑</a>&#160;",
                        "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-edit'>&#160;</i>查看</a>"
                    ].join('');
                }
                return editBtn;
            }
        }]
    });
}


function initAllSelect(){
    //目录类别下拉查询框
    $.initClassifyTreeSelect('searchClassifyTreeDemo','searchClassifyName','searchClassifyId','searchClassifyMenuContent');
}


function initButtonClickEvent(){
    //点击查询按钮
    $('#queryBtn').click(function () {
        setParams();
        reloadTable();
    });
    //点击删除按钮
    $('#catalogueDeleteButton').click(function () {
        //获取已选择的资源目录的id
        var selectedIds="";
        var selectedRow = $(tableSelector).bootstrapTable('getSelections');
        if(selectedRow && selectedRow.length > 0) {
            var isDealing = false;
            for (var i = 0, ii = selectedRow.length; i < ii; i++) {
                var id = selectedRow[i].id;
                var classifyStatus = selectedRow[i].classifyStatus;
                if(classifyStatus==1 || classifyStatus==3 || classifyStatus==5){
                    isDealing = true;
                    break;
                }else{
                    selectedIds += i == 0 ? id : "," + id;
                }
            }
            if(isDealing){
                errorMsgTip("只能删除状态为：待注册、审核不通过、审核驳回、已下架 的信息资源！！")
            }else{
                layer.confirm("删除信息资源,同时会删除其所有的信息项,确认要删除吗?", {icon: 3, title:"确认信息", zIndex: layer.zIndex}, function(index){
                    $.commonAjax({
                        url:basePathJS + "/catalog/doDelete",
                        data:{id:selectedIds},
                        success:function(result){
                            if(result.state){
                                successMsgTip(result.msg);
                                reloadTable();
                            }else{
                                errorMsgTip(result.msg);
                            }
                        }
                    });
                    layer.close(index);
                });
            }
        }else{
            errorMsgTip("请先选择要删除的信息资源");
        }
    });

}

function setParams() {
    var searchClassifyId = $('#searchClassifyId').val();
    var searchName = $('#searchName').val();
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName};
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