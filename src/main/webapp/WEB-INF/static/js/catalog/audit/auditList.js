var tableSelector = '#auditTable';
var paramsObj = {};

jQuery(document).ready(function () {
    initCss();
    initTable();
    initAllSelect();
    initButtonClickEvent();
});

function initCss(){
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
        $("div.box div.table-myself").animate({
            paddingLeft: "50px"
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
            paddingLeft: "270px"
        })
        $(".user-panel").css("background","none");
    })
}

function initTable(){
    var regionCode = $.getSelectedRegionCode();
    paramsObj["regionCode"] = regionCode;
    $(tableSelector).customTable({
        url: basePathJS + '/catalog/audit/list',
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

function initAllSelect(){
    //初始化中间目录分类树
    $.initClassifyTree('treeDemo','searchClassifyId');
    //区域下拉查询框
    $.initRegionQueryTreeSelect('searchRegionTreeDemo','searchRegionName','searchRegionCode','searchRegionMenuContent',true);
}


function initButtonClickEvent(){
    //点击审核按钮
    $("#auditButton").on("click",function(){
        var selectedDcmIds="";
        var selectedRow = $(tableSelector).bootstrapTable('getSelections');
        if(selectedRow && selectedRow.length > 0) {
            for (var i = 0, ii = selectedRow.length; i < ii; i++) {
                var dcmId = selectedRow[i].id;
                selectedDcmIds += i == 0 ? dcmId : "," + dcmId;
            }
            update('目录审核',basePathJS + '/catalog/auditInfo' , selectedDcmIds );
        }else{
            errorMsgTip("请先选择要审核的信息资源");
        }

        //获取已选择的资源目录的id
       /* var selectedDcmIds="";
        var selectedRow = $(tableSelector).bootstrapTable('getSelections');
        if(selectedRow && selectedRow.length > 0){
            for(var i=0,ii=selectedRow.length;i<ii;i++){
                var dcmId = selectedRow[i].id;
                selectedDcmIds += i==0?dcmId:","+dcmId;
            }
            $.commonAjax({
                url:basePathJS + "/catalog/audit/doAudit",
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
            errorMsgTip("请先选择要审核的信息资源");
        }*/
    });

    //点击查询按钮
    $('#auditQueryBtn').click(function () {
        setParams();
        reloadTable();
    });
}


function catalogueTableShow(id){
    show('信息资源详情',basePathJS + '/catalog/show' , id ,1300,700);
}

function setParams() {
    var searchClassifyId = $('#searchClassifyId').val();
    var searchName = $('#searchName').val();
    var regionCode = $('#searchRegionCode').val();
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

