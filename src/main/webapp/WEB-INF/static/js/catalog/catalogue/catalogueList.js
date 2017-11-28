var tableSelector = '#catalogueTable';
var paramsObj = {};

jQuery(document).ready(function () {
    initTable();
    //initAllSelect();
    initButtonClickEvent();
});

var setting = {
    async: {
        enable: true,
        url: basePathJS + "/dirClassify/subAuthorityList",
        autoParam: ["fid","treeCode","authorityNode"],
        dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
            var params = [];
            var nodeObjs = childNodes.content.vo;
            if (!nodeObjs) {
                return null;
            }
            for (var i in nodeObjs) {
                params[i] = {
                    'id': nodeObjs[i].id,
                    'name': nodeObjs[i].classifyName,
                    'fid': nodeObjs[i].id,
                    'treeCode': nodeObjs[i].treeCode,
                    'isParent': (nodeObjs[i].hasLeaf == "1" ? true : false),
                    'authorityNode':nodeObjs[i].authorityNode
                }
            }
            return params;
        }
    },
    callback: {
        beforeClick: function (treeId, treeNode) { //如果点击的节点还有下级节点，则展开该节点
            var zTreeObj = $.fn.zTree.getZTreeObj("treeDemo");
            if (treeNode.isParent) {
                if (treeNode.open) {
                    zTreeObj.expandNode(treeNode, false);
                } else {
                    zTreeObj.expandNode(treeNode, true);
                }
                return false;
            } else {
                return true;
            }
        },
        onClick: function (e, treeId, treeNode) { //点击最下层子节点，获取目录类别的全名称，显示到输入框中

                //var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                //treeObj.cancelSelectedNode();

            $('#searchClassifyId').val(treeNode.id);
            setParams();
            reloadTable();
            /*$.commonAjax({
                url: basePathJS + "/dirClassify/editLoad",
                data: {id: treeNode.id},
                success: function (result) {
                    if (result.state) {
                        var classifyObj = result.content.vo;
                        $('#' + nameInputDomId).val(classifyObj.classifyStructureName);
                        $('#' + codeInputDomId).val(treeNode.id);
                    }
                }
            });*/
        }
    }
};
$(document).ready(function(){
    $.fn.zTree.init($("#treeDemo"), setting);
});
function initTable(){
    var regionCode = $.getSelectedRegionCode();
    paramsObj["regionCode"] = regionCode;
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
            field: 'deptName',
            title: '信息资源提供方',
            sortable: false,
            width: '15%',
            formatter:function(value, row, index){
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'classifyName',
            title: '目录分类',
            sortable: false,
            formatter:function(value, row, index){
                if(value == undefined){
                    value = "";
                }
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
        },{
            field: 'itemNums',
            title: '信息项数',
            sortable: false,
            width: '10%'
        },{
            field: 'datasetSourceTypeName',
            title: '添加方式',
            sortable: false,
            width: '10%',
            formatter:function(value, row, index){
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'classifyStatus',
            title: '状态',
            width: '10%',
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
            field: 'id',
            title: '操作',
            width: '120px',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter: function(value, row, index) {
                var editBtn ="";
                if(row.classifyStatus==0 || row.classifyStatus==2 || row.classifyStatus==4 || row.classifyStatus==6){
                    editBtn = [
                        "<p><a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:catalogueTableEdit(\"" + value + "\")'><i class='fa fa-pencil'>&#160;</i>编辑</a>&#160;",
                        "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-eye'>&#160;</i>查看</a></p>"
                    ].join('');
                }else{
                    editBtn = [
                        "<p><a class='btn btn-danger btn-flat btn-xs' disabled=true style='opacity: 0.2'><i class='fa fa-pencil'>&#160;</i>编辑</a>&#160;",
                        "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-eye'>&#160;</i>查看</a></p>"
                    ].join('');
                }
                return editBtn;
            }
        }]
    });
}


function initAllSelect(){
    //目录类别下拉查询框
    $.initQueryClassifyTreeSelect('searchClassifyTreeDemo','searchClassifyName','searchClassifyId','searchClassifyMenuContent');
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
    var regionCode = $.getSelectedRegionCode();
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addCustom() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    add('新增信息资源',basePathJS + '/catalog/catalogue/add'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}

function catalogueTableEdit(id) {
    update('编辑信息资源',basePathJS + '/catalog/edit' , id ,"70%",700);
}

function catalogueTableShow(id){
    show('信息资源详情',basePathJS + '/catalog/show' , id ,"70%",700);
}

function quickAddDatasetUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    add('从资源梳理添加',basePathJS + '/catalog/catalogue/quickAddDatasetUI'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}

function quickSystemAddDatasetUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    add('从系统梳理添加',basePathJS + '/catalog/catalogue/quickSystemAddDatasetUI'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}
function quickCsAddDatasetUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    add('从爬虫系统添加',basePathJS + '/catalog/catalogue/quickCsAddDatasetUI'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}
function quickDcmAddDatasetUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    add('从关系型采集系统添加',basePathJS + '/catalog/catalogue/quickDcmAddDatasetUI'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}
function quickNosqlDcmAddDatasetUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    add('从非关系型采集系统添加',basePathJS + '/catalog/catalogue/quickDcmNosqlAddDatasetUI'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}
function excelImportUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    detail('导入',basePathJS +'/catalog/catalogue/excelImportUI?classifyId='+ $('#searchClassifyId').val(),"70%",350,parent);
}
function excelDownloadUI() {
    detail('模板下载',basePathJS +'/catalog/catalogue/excelDownloadUI',"70%",350,parent);
}
function checkClassfyId(searchClassifyId){
    if(searchClassifyId){
        return true;
    }
    return false;
}

