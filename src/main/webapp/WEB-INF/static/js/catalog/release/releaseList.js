var tableSelector = '#releaseTable';
var paramsObj = {};

jQuery(document).ready(function () {
    //tab切换
    $("#releaseTab >li").click(function(){
        $(this).addClass("active").siblings().removeClass("active");
        if($(this).text().trim() == "待发布"){
            $("#releasedSearchDiv").hide();
            $("#unReleaseSearchDiv").show();
            initUnReleaseTable();
        }else if($(this).text().trim() === "已发布"){
            $("#unReleaseSearchDiv").css("display","none");
            $("#releasedSearchDiv").css("display","block");
            initReleasedTable();
        }
    })
    initAllSelect();
    initButtonClickEvent();
});


function initUnReleaseTable(){
    var searchName = $("#unReleaseSearchName").val();
    var searchClassify = $("#unReleaseSearchClassifyId").val();
    paramsObj = {datasetName:searchName,classifyId:searchClassify};
    $(tableSelector).customTable({
        url: basePathJS + '/catalog/unRelease/list',
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
            width: '15%',
            sortable: false,
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
        },{
            field: 'datasetName',
            title: '信息资源名称',
            sortable: true, //启用排序
            width: '20%',
            sortable: false,
            formatter:function(value, row, index){
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'status',
            title: '状态',
            width: '10%',
            sortable: false,
            formatter: function(value, row, index) {
                if (row['status'] == 0) {
                    return '待注册'
                }else if (row['status'] == 1) {
                    return '待审核';
                }else if (row['status'] == 2) {
                    return '审核不通过';
                }else if (row['status'] == 3) {
                    return '待发布';
                }else if (row['status'] == 4) {
                    return '驳回审核';
                }else if (row['status'] == 5) {
                    return '已发布';
                }else if (row['status'] == 6) {
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
            formatter: function(value) {
                var editBtn = [
                    "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableEdit(\"" + value + "\")'><i class='fa fa-edit'>&#160;</i>查看详情</a>"
                ].join('');
                return editBtn;
            }
        }]
    });
}


function initReleasedTable(){
    var searchName = $("#releasedSearchName").val();
    var searchClassify = $("#releasedSearchClassifyId").val();
    paramsObj = {datasetName:searchName,classifyId:searchClassify};
    $(tableSelector).customTable({
        url: basePathJS + '/catalog/unRelease/list',
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
            width: '15%',
            sortable: false,
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
        },{
            field: 'datasetName',
            title: '信息资源名称',
            sortable: true, //启用排序
            width: '20%',
            sortable: false,
            formatter:function(value, row, index){
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'status',
            title: '状态',
            width: '10%',
            sortable: false,
            formatter: function(value, row, index) {
                if (row['status'] == 0) {
                    return '待注册'
                }else if (row['status'] == 1) {
                    return '待审核';
                }else if (row['status'] == 2) {
                    return '审核不通过';
                }else if (row['status'] == 3) {
                    return '待发布';
                }else if (row['status'] == 4) {
                    return '驳回审核';
                }else if (row['status'] == 5) {
                    return '已发布';
                }else if (row['status'] == 6) {
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
            formatter: function(value) {
                var editBtn = [
                    "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableEdit(\"" + value + "\")'><i class='fa fa-edit'>&#160;</i>查看详情</a>"
                ].join('');
                return editBtn;
            }
        }]
    });
}

function initAllSelect(){
    //未发布目录类别下拉查询框
    $.initClassifyTreeSelect('unReleaseSearchClassifyTreeDemo','unReleaseSearchClassifyName','unReleaseSearchClassifyId','unReleaseSearchClassifyMenuContent');
    //已发布目录类别下拉查询框
    $.initClassifyTreeSelect('releasedSearchClassifyTreeDemo','releasedSearchClassifyName','releasedSearchClassifyId','releasedSearchClassifyMenuContent');
}


function initButtonClickEvent(){
    //点击审核驳回按钮
    invokeButton("auditRejectButton","/catalog/release/auditReject","审核驳回");
    //点击下架按钮
    invokeButton("offlineButton","/catalog/release/offline","下架");
    //点击发布按钮
    invokeButton("releaseButton","/catalog/release/doRelease","发布");

    //点击未发布的查询按钮
    $('#unReleaseQueryBtn').click(function () {
        setUnReleaseParams();
        reloadTable();
    });

    //点击已发布的查询按钮
    $('#releasedQueryBtn').click(function () {
        setReleasedParams();
        reloadTable();
    });
}

function invokeButton(buttonId, url, msg){
    $("#"+buttonId).on("click",function(){
        var selectedDcmIds="";
        var selectedRow = $(tableSelector).bootstrapTable('getSelections');
        if(selectedRow && selectedRow.length > 0) {
            for (var i = 0, ii = selectedRow.length; i < ii; i++) {
                var dcmId = selectedRow[i].id;
                selectedDcmIds += i == 0 ? dcmId : "," + dcmId;
            }
            $.commonAjax({
                url:basePathJS + url,
                data:{dcmIds:selectedDcmIds},
                success:function(result){
                    if(result.state){
                        successMsgTip(result.msg);
                        reloadTable();
                    }else{
                        errorMsgTip(result.msg);
                    }
                }
            });
        }else{
            errorMsgTip("请先选择要"+msg+"的信息资源");
        }
    });
}

function setUnReleaseParams(){
    var searchName = $("#unReleaseSearchName").val();
    var searchClassify = $("#unReleaseSearchClassifyId").val();
    paramsObj = {classifyId:searchClassify,datasetName:searchName};
}

function setReleasedParams() {
    var searchName = $("#releasedSearchName").val();
    var searchClassify = $("#releasedSearchClassifyId").val();
    paramsObj = {classifyId:searchClassify,datasetName:searchName};
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

