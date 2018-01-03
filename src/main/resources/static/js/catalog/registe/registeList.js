var unRegisteTableSelector = '#unRegisteTable';
var registedTableSelector = '#registedTable';
var unRegisteParamsObj = {};
var registedParamsObj = {};
var selectedTab="tab1";
jQuery(document).ready(function () {
	 $("#tab2").hide();
		$("#chooseTab >li").click(function(){
	        $(this).addClass("active").siblings().removeClass("active");
             if($(this).index()=="1"){
                 $("#tab1").hide();
                 $("#tab2").show();
                 selectedTab = "tab2";
             }else if($(this).index()=="0"){
                 $("#tab2").hide();
                 $("#tab1").show();
                 selectedTab = "tab1";
             }
            initTable();
	    });
    initCss();
    initAllSelect();
    initButtonClickEvent();
    $("#chooseTab >li :first").click();
});

function initCss(){
    /* 目录编目收缩小侧边栏,用的adminlte */
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

function initTable(){
    var baseColumn = [{
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
    }];
    if(selectedTab =="tab1"){
        if(!$(unRegisteTableSelector).hasClass('table-striped')){
            setParams();
            var unRegisteColumns = baseColumn.slice(0);
            unRegisteColumns.push({
                field: 'datasetId',
                title: '操作',
                width: '10%',
                align: 'left',
                valign: 'middle',
                sortable: false,
                formatter: function(value) {
                    var editBtn = [
                        "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-eye'>&#160;</i>查看详情</a>"
                    ].join('');
                    return editBtn;
                }
            });
            $(unRegisteTableSelector).customTable({
                url: basePathJS + '/catalog/unRegiste/list',
                queryParams: function (params) {
                    return $.extend(params, unRegisteParamsObj);
                },
                columns: unRegisteColumns
            });
        }else{
            setParams();
            reloadTable();
        }
    }else{
        if(!$(registedTableSelector).hasClass('table-striped')){
            setParams();
            var registedColumns = baseColumn.slice(0);
            registedColumns.push({
                field: 'optUser',
                title: '注册人',
                width: '10%',
                sortable: false,
                formatter: function (value, row, index) {
                    if(value==undefined){
                        value="";
                    }
                    return '<p title="' + value + '">' + value + '</p>';
                }
            });
            registedColumns.push({
                field: 'optTime',
                title: '注册时间',
                width: '10%',
                sortable: false,
                formatter: function (value, row, index) {
                    if(value==undefined){
                        value="";
                    }
                    return '<p title="' + value + '">' + value + '</p>';
                }
            });
            registedColumns.push({
                field: 'datasetId',
                title: '操作',
                width: '10%',
                align: 'left',
                valign: 'middle',
                sortable: false,
                formatter: function(value) {
                    var editBtn = [
                        "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-eye'>&#160;</i>查看详情</a>"
                    ].join('');
                    return editBtn;
                }
            });
            $(registedTableSelector).customTable({
                url: basePathJS + '/catalog/registed/list',
                queryParams: function (params) {
                    return $.extend(params, registedParamsObj);
                },
                columns: registedColumns
            });
        }else{
            setParams();
            reloadTable();
        }
    }
}

function initAllSelect(){
    //区域下拉查询框
    /*var initClassifyTreeParam = ["treeDemo","searchClassifyId","","classifyType"];
    $.initRegionQueryTreeSelect('searchRegionTreeDemo','searchRegionName','searchRegionCode',
        'searchRegionMenuContent',false,newRegionCode,initClassifyTreeParam);*/
    //初始化中间目录分类树
    $.initClassifyTree('treeDemo','searchClassifyId','','classifyType',newRegionCode);
}


function initButtonClickEvent(){
    //点击注册按钮
    $("#registeButton").on("click",function(){
        //获取已选择的资源目录的id
        var selectedDcmIds="";
        var selectedRow = $(unRegisteTableSelector).bootstrapTable('getSelections');
        if(selectedRow && selectedRow.length > 0){
            layer.confirm("是否要对选中的信息资源进行注册操作?", {icon: 3, title:"确认信息", zIndex: layer.zIndex}, function(index){
                for(var i=0,ii=selectedRow.length;i<ii;i++){
                    var dcmId = selectedRow[i].id;
                    selectedDcmIds += i==0?dcmId:","+dcmId;
                }
                $.commonAjax({
                    url:basePathJS + "/catalog/registe/doRegiste",
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
            });
        }else{
            errorMsgTip("请先选择要注册的信息资源");
        }
    });

    //点击查询按钮
    $('#unRegisteQueryBtn').click(function () {
        setParams();
        reloadTable();
    });

    $('#registedQueryBtn').click(function () {
        setParams();
        reloadTable();
    });
    
}

function catalogueTableShow(id){
    show('信息资源详情',basePathJS + '/catalog/show' , id ,"70%",700);
}

function setParams() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(selectedTab=="tab1"){
        var searchName = $('#unRegisteSearchName').val();
        unRegisteParamsObj = {classifyId: searchClassifyId, datasetName: searchName};
    }else{
        var searchName = $('#registedSearchName').val();
        registedParamsObj = {classifyId: searchClassifyId, datasetName: searchName};
    }
}

function reloadTable() {
    if(selectedTab=="tab1"){
        $(unRegisteTableSelector).data("bootstrap.table").options.pageNumber = 1;
        $(unRegisteTableSelector).data("bootstrap.table").refresh();
    }else{
        $(registedTableSelector).data("bootstrap.table").options.pageNumber = 1;
        $(registedTableSelector).data("bootstrap.table").refresh();
    }
}



