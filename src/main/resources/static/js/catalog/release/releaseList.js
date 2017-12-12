var tableSelector = '#releaseTable';
var paramsObj = {};

jQuery(document).ready(function () {
	 $("#tab2").hide();
		$("#releaseTab >li").click(function(){
	        $(this).addClass("active").siblings().removeClass("active");
	     if($(this).index()=="1"){
	    	 $("#tab1").hide();
	    	 $("#tab2").show();
	     }else if($(this).index()=="0"){
	    	 $("#tab2").hide();
	    	 $("#tab1").show();
	    	 initUnReleaseCss();
	         initUnReleaseTable();
	     }
	    });
    //tab切换
/*    $("#releaseTab >li").click(function(){
        $(this).addClass("active").siblings().removeClass("active");
        if($(this).text().trim() == "待发布"){
        	
            initUnReleaseCss();
            initUnReleaseTable();
        }else if($(this).text().trim() === "已发布"){
            initReleasedCss();
            initReleasedTable();
        }
    });*/
    initAllSelect();
    initButtonClickEvent();
    $("#unReleaseTab").click();
});

function initUnReleaseCss(){
    // 目录编目收缩小侧边栏,用的adminlte
	 $(function(){
	        $("#forward").hide();
	        $("#dir-Manger").parent("div.user-panel").css("text-align","center")
	        $("#backward").click(function(){
	            $("#min-aside").animate({
	                width:"2%"
	            },200);
	            $("#dir-Manger").hide();
	            //$("#regionDiv").hide();
	            $("#forward").show(400);
	            $("#backward").hide(500);
	            $("#treeDemo").hide(200);
	            $("#min-aside").css("border","none")
	            $("div.box div.content_table").animate({
	                width: "98%"
	            })

	            $(this).parents("div.user-panel").css("background","#f4f6f9");
	        })
	        $("#forward").click(function(){
	            $("div.box div.content_table").animate({
	                width: "86%"
	            },400)
	            $("#min-aside").animate({
	                width:"14%"
	            },500);
	            $("#dir-Manger").show();
	            //$("#regionDiv").show();
	            $("#forward").hide(400);
	            $("#backward").show(500);
	            $("#treeDemo").show(200);
	            $("#min-aside").css("border","1px solid #ddd");

	            $(".user-panel").css("background","none");
	        })
	    })
}

function initReleasedCss(){
	 // 目录编目收缩小侧边栏,用的adminlte
	 $(function(){
	        $("#forward").hide();
	        $("#dir-Manger").parent("div.user-panel").css("text-align","center")
	        $("#backward").click(function(){
	            $("#min-aside").animate({
	                width:"2%"
	            },200);
	            $("#dir-Manger").hide();
	            //$("#regionDiv").hide();
	            $("#forward").show(400);
	            $("#backward").hide(500);
	            $("#treeDemo").hide(200);
	            $("#min-aside").css("border","none")
	            $("div.box div.content_table").animate({
	                width: "98%"
	            })

	            $(this).parents("div.user-panel").css("background","#f4f6f9");
	        })
	        $("#forward").click(function(){
	            $("div.box div.content_table").animate({
	                width: "86%"
	            },400)
	            $("#min-aside").animate({
	                width:"14%"
	            },500);
	            $("#dir-Manger").show();
	            //$("#regionDiv").show();
	            $("#forward").hide(400);
	            $("#backward").show(500);
	            $("#treeDemo").show(200);
	            $("#min-aside").css("border","1px solid #ddd");

	            $(".user-panel").css("background","none");
	        })
	    })
}

function initUnReleaseTable(){
    var searchName = $("#unReleaseSearchName").val();
    var searchClassifyId = $("#unReleaseSearchClassifyId").val();
    //var regionCode = $('#unReleaseSearchRegionCode').val();
    //paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName};
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
    var searchClassifyId = $("#releasedSearchClassifyId").val();
    //var regionCode = $('#releasedSearchRegionCode').val();
    //paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName};
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
    //未发布区域下拉查询框
    var initUnReleaseClassifyTreeParam = ["unReleaseTreeDemo","unReleaseSearchClassifyId","unRelease","unReleaseClassifyType"];
    $.initRegionQueryTreeSelect('unReleaseSearchRegionTreeDemo','unReleaseSearchRegionName','unReleaseSearchRegionCode',
        'unReleaseSearchRegionMenuContent',false,newRegionCode,initUnReleaseClassifyTreeParam,'unRelease');
    //初始化未发布中间目录分类树
    $.initClassifyTree('unReleaseTreeDemo','unReleaseSearchClassifyId','unRelease','unReleaseClassifyType',newRegionCode);

    //已发布区域下拉查询框
    var initReleasedClassifyTreeParam = ["releasedTreeDemo","releasedSearchClassifyId","released","releasedClassifyType"];
    $.initRegionQueryTreeSelect('releasedSearchRegionTreeDemo','releasedSearchRegionName','releasedSearchRegionCode',
        'releasedSearchRegionMenuContent',false,newRegionCode,initReleasedClassifyTreeParam,'released');
    //初始化已发布中间目录分类树
    $.initClassifyTree('releasedTreeDemo','releasedSearchClassifyId','released','releasedClassifyType',newRegionCode);
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
    show('信息资源详情',basePathJS + '/catalog/show' , id ,"70%",700);
}

function setUnReleaseParams(){
    var searchName = $("#unReleaseSearchName").val();
    var searchClassifyId = $("#unReleaseSearchClassifyId").val();
    //var regionCode = $('#unReleaseSearchRegionCode').val();
    //paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName};
}

function setReleasedParams() {
    var searchName = $("#releasedSearchName").val();
    var searchClassifyId = $("#releasedSearchClassifyId").val();
    //var regionCode = $('#releasedSearchRegionCode').val();
    //paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName};
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

