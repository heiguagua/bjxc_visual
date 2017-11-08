var tableSelector = '#releaseTable';
var paramsObj = {};

jQuery(document).ready(function () {
    //tab切换
    $("#releaseTab >li").click(function(){
        $(this).addClass("active").siblings().removeClass("active");
        if($(this).text().trim() == "待发布"){
        	$("div.box div.table-myself1").css("paddingLeft","240px")
            $('.box-header').css("paddingLeft","240px");
        	 $("#min-aside").css("width","230px");
             $("#dir-Manger").stop().show();
             $("#forward").stop().hide(400);
             $("#backward").stop().stop().show(500);
             $("#min-aside").css("border","1px solid #ddd");
            $("#releasedSearchDiv").hide();
            $("#unReleaseSearchDiv").show();
            initUnReleaseCss();
            initUnReleaseTable();
        }else if($(this).text().trim() === "已发布"){
        	$("div.box div.table-myself1").css("paddingLeft","240px")
            $('.box-header').css("paddingLeft","240px");
        	 $("#min-aside2").css({"width":"230px","border":"1px solid #ddd"});
             $("#dir-Manger2").stop().show();
             $("#forward2").stop().hide(400);
             $("#backward2").stop().show(500);
            $("#unReleaseSearchDiv").css("display","none");
            $("#releasedSearchDiv").css("display","block");
            initReleasedCss();
            initReleasedTable();
        }
    });
    initAllSelect();
    initButtonClickEvent();
    $("#unReleaseTab").click();
});

function initUnReleaseCss(){
    // 目录编目收缩小侧边栏,用的adminlte
    $("#forward").hide();
    $("#dir-Manger").parent("div.user-panel").css("text-align","center")
    $("#backward").click(function(){
        $("#min-aside").animate({
            width:"40px"
        },200);
        $("#dir-Manger").hide();
        $("#forward").show(400);
        $("#backward").hide(500);
        $("#treeDemo").hide(200);
        $("#min-aside").css("border","none")
        $("div.box div.table-myself1").animate({
            paddingLeft: "60px"
        })
        $('.box-header').animate({
            paddingLeft: "60px"
        })
        $(".user-panel").css("background","#f4f6f9");
    })
    $("#forward").click(function(){
        $("#min-aside").animate({
            width:"230px"
        },200);
        $("#dir-Manger").show();
        $("#forward").hide(400);
        $("#backward").show(500);
        $("#treeDemo").show(200);
        $("#min-aside").css("border","1px solid #ddd");
        $(".box-body").animate({
            paddingLeft: "240px"
        })
        $('.box-header').animate({
            paddingLeft: "240px"
        })
        $(".user-panel").css("background","none");
    })
}

function initReleasedCss(){
    // 目录编目收缩小侧边栏,用的adminlte
    $("#forward2").hide();
    $("#dir-Manger2").parent("div.user-panel").css("text-align","center")
    $("#backward2").click(function(){
        $("#min-aside2").animate({
            width:"40px"
        },200);
        $("#dir-Manger2").hide();
        $("#forward2").show(400);
        $("#backward2").hide(500);
        $("#treeDemo2").hide(200);
        $("#min-aside2").css("border","none")
        $("div.box div.table-myself1").animate({
            paddingLeft: "60px"
        })
        $('.box-header').animate({
            paddingLeft: "60px"
        })
        $(".user-panel").css("background","#f4f6f9");
    })
    $("#forward2").click(function(){
        $("#min-aside2").animate({
            width:"230px"
        },200);
        $("#dir-Manger2").show();
        $("#forward2").hide(400);
        $("#backward2").show(500);
        $("#treeDemo2").show(200);
        $("#min-aside2").css("border","1px solid #ddd");
        $(".box-body").animate({
            paddingLeft: "240px"
        })
        $('.box-header').animate({
            paddingLeft: "240px"
        })
        $(".user-panel").css("background","none");
    })
}

function initUnReleaseTable(){
    var searchName = $("#unReleaseSearchName").val();
    var searchClassify = $("#unReleaseSearchClassifyId").val();
    var regionCode = $('#unReleaseSearchRegionCode').val();
    paramsObj = {datasetName:searchName,classifyId:searchClassify,regionCode:regionCode};
    $(tableSelector).bootstrapTable("destroy");
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
            title: '信息资源提供方',
            width: '15%',
            sortable: false,
            formatter:function(value, row, index){
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'classifyStructureName',
            title: '目录分类',
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
            field: 'datasetId',
            title: '操作',
            width: '10%',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter: function(value) {
                var editBtn = [
                    "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-eye'>&#160;</i>查看详情</a>"
                ].join('');
                return editBtn;
            }
        }]
    });
}


function initReleasedTable(){
    var searchName = $("#releasedSearchName").val();
    var searchClassify = $("#releasedSearchClassifyId").val();
    var regionCode = $('#releasedSearchRegionCode').val();
    paramsObj = {datasetName:searchName,classifyId:searchClassify,regionCode:regionCode};
    $(tableSelector).bootstrapTable("destroy");
    $(tableSelector).customTable({
        url: basePathJS + '/catalog/released/list',
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
            title: '信息资源提供方',
            width: '15%',
            sortable: false,
            formatter:function(value, row, index){
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'classifyStructureName',
            title: '目录分类',
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
            field: 'publishType',
            title: '发布平台类型',
            width: '20%',
            align: 'center',
            sortable: false,
            formatter: function(value, row, index) {
                var typeHtml="";
                if(value == "1"){
                    typeHtml = '<div class="text-left"><span><i class="interNet"></i> </span>互联网&nbsp;&nbsp;<span><i class="fa fa-circle"></i> 电子政务外网</span></div>';
                }else if(value == "2"){
                    typeHtml = '<div class="text-left"><span><i class="fa fa-circle"></i> </span>互联网&nbsp;&nbsp;<span class=" interNet"> </span>电子政务外网</div>';
                }else if(value == "3"){
                    typeHtml = '<div class="text-left"><span class="interNet"> </span>互联网&nbsp;&nbsp;<span class="interNet"> </span>电子政务外网</div>';
                }
                return typeHtml;
            }
        }, {
            field: 'datasetId',
            title: '操作',
            width: '10%',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter: function(value) {
                var editBtn = [
                    "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-eye'>&#160;</i>查看详情</a>"
                ].join('');
                return editBtn;
            }
        }]
    });
}

function initAllSelect(){
    //初始化未发布中间目录分类树
    $.initClassifyTree('unReleaseTreeDemo','unReleaseSearchClassifyId','unRelease');
    //初始化已发布中间目录分类树
    $.initClassifyTree('releasedTreeDemo','releasedSearchClassifyId','released');
    //未发布区域下拉查询框
    $.initRegionQueryTreeSelect('unReleaseSearchRegionTreeDemo','unReleaseSearchRegionName','unReleaseSearchRegionCode','unReleaseSearchRegionMenuContent',true);
    //已发布区域下拉查询框
    $.initRegionQueryTreeSelect('releasedSearchRegionTreeDemo','releasedSearchRegionName','releasedSearchRegionCode','releasedSearchRegionMenuContent',true);
}


function initButtonClickEvent(){
    //点击审核驳回按钮
    invokeButton("auditRejectButton","/catalog/release/auditReject","审核驳回");
    //点击下架按钮
    invokeButton("offlineButton","/catalog/release/offline","下架");
    //发布到互联网按钮
    invokeButton("releaseToInternet","/catalog/release/releaseToInternet","发布到互联网");
    //发布到电子政务外网按钮
    invokeButton("releaseToDzzw","/catalog/release/releaseToDzzw","发布到电子政务外网");
    //同时发布按钮
    invokeButton("releaseAll","/catalog/release/releaseAll","同时发布");

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
            layer.confirm("是否要对选中的信息资源进行"+msg+"操作?", {icon: 3, title:"确认信息", zIndex: layer.zIndex}, function(index){
                $.commonAjax({
                    url:basePathJS + url,
                    data:{dcmId:selectedDcmIds},
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
        }else{
            errorMsgTip("请先选择要"+msg+"的信息资源");
        }
    });
}

function catalogueTableShow(id){
    show('信息资源详情',basePathJS + '/catalog/show' , id ,1300,700);
}

function setUnReleaseParams(){
    var searchName = $("#unReleaseSearchName").val();
    var searchClassifyId = $("#unReleaseSearchClassifyId").val();
    var regionCode = $('#unReleaseSearchRegionCode').val();
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};
}

function setReleasedParams() {
    var searchName = $("#releasedSearchName").val();
    var searchClassifyId = $("#releasedSearchClassifyId").val();
    var regionCode = $('#releasedSearchRegionCode').val();
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

