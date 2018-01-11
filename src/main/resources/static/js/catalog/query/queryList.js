var tableSelector = '#queryTable';
var paramsObj = {};

jQuery(document).ready(function () {
    window.Dict=new dict();
    initCss();
    initAllSelect();
    initButtonClickEvent();
    initTable();
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
    //paramsObj["regionCode"] = $('#searchRegionCode').val();
    $(tableSelector).customTable({
        url: basePathJS + '/catalog/query/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [
            /*{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        },{
            field: 'id',
            visible: false
        },*/{
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
                if(value == undefined){
                    value = "";
                }
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
            field: 'id',
            title: '操作',
            width: '10%',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter: function(value) {
                var editBtn = [
                    "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-eye'>&#160;</i>查看详情</a>"
                ].join('');
                return editBtn;
            }
        }]
    });
}

function initAllSelect(){
    //区域下拉查询框
    /*var initClassifyTreeParam = ["treeDemo","searchClassifyId","","classifyType"];
    $.initRegionQueryTreeSelect('searchRegionTreeDemo','searchRegionName','searchRegionCode',
        'searchRegionMenuContent',false,newRegionCode,initClassifyTreeParam);*/
    //初始化中间目录分类树
    $.initClassifyTree('treeDemo','searchClassifyId','','classifyType',newRegionCode);
    //初始化资源状态下拉查询框
    Dict.selects('dataSetStatus',['#searchStatus']);
}

function catalogueTableShow(id){
    show('信息资源详情',basePathJS + '/catalog/show' , id ,"70%",700);
}

function initButtonClickEvent(){
    //点击查询按钮
    $('#queryBtn').click(function () {
        setParams();
        reloadTable();
    });
    
}

function setParams() {
    var searchClassifyId = $('#searchClassifyId').val();
    var searchName = $('#searchName').val();
    var searchStatus = $('#searchStatus').val();
    //var regionCode = $('#searchRegionCode').val();
    //paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName,status:searchStatus};
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}


$(document).on("click","#downloadExcel",function(){
    //var classify_id=$('#searchClassifyId').val();
    //var dataset_name=$('#searchName').val();
    //var data={
    //    classify_id:classify_id,
    //    dataset_name:dataset_name
    //}
    //if(classify_id||dataset_name){
    //    downloadExcel(data);
    //}else{
    //    layer.confirm("未选择筛选条件时，会导致效率过低，建议增加筛选条件！确认导出？",{icon:3},function (index) {
    //        downloadExcel(data);
    //        layer.close(index);
    //    })
    //}
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    if(!checkClassifyType()){
        tip("不能在这个分类下导出!!",parent,null,null);
        return;
    }
    var dataset_name=$('#searchName').val();
    var data={
        classify_id:searchClassifyId,
        dataset_name:dataset_name
    }
    var searchStatus = $('#searchStatus').val();
    if(searchClassifyId || searchStatus || dataset_name){
            downloadExcel(data);
    }else{
        layer.confirm("未输入筛选条件时，数据量过大会导致效率过低，建议输入筛选条件！确认导出？",{icon:3},function (index) {
            downloadExcel(data);
            layer.close(index);
        })
    }
})

function checkClassfyId(searchClassifyId){
    if(searchClassifyId){
        return true;
    }
    return false;
}

function checkClassifyType(){
    var checkResult = true;
    var classifyType = $('#classifyType').val();
    if(classifyType=='1' || classifyType=='2-1' || classifyType=='2-2' || classifyType=='2-3'
        || classifyType=='3' || classifyType=='4'){
        checkResult = false;
    }
    return checkResult
}
function downloadExcel(data){
    layer.load();

    var form=$("<form>");//定义一个form表单
    form.attr("style","display:none");
    form.attr("target","");
    form.attr("method","post");
    form.attr("action",basePathJS + "/catalog/downloadDatasetExcel");
    var input1=$("<input>");
    input1.attr("type","hidden");
    input1.attr("name","classify_id");
    input1.attr("value",data.classify_id);

    var input2=$("<input>");
    input2.attr("type","hidden");
    input2.attr("name","dataset_name");
    input2.attr("value",data.dataset_name);
    $("body").append(form);//将表单放置在web中
    form.append(input1);
    form.append(input2);
    form.submit();//表单提交

    window.setTimeout(function(){
        layer.closeAll('loading');
    },2000)

}