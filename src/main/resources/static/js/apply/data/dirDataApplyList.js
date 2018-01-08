/**
 * Created by lenovo on 2017/5/9.
 */
var tableSelector = '#dirDataApplyTableId';
var isAudited = '0';
$('#isAudited').val(isAudited);
var paramsObj = {isAudited: isAudited};

jQuery(document).ready(function () {
    "use strict";
    $(document).ready(function(){
        initAllSelect();
        hideAndShow();
    });

    function initAllSelect(){
        //区域下拉查询框
        var initClassifyTreeParam = ["treeDemo","searchClassifyId","","classifyType"];
        $.initRegionQueryTreeSelect('searchRegionTreeDemo','searchRegionName','searchRegionCode',
            'searchRegionMenuContent',false,newRegionCode,initClassifyTreeParam);
        //初始化中间目录分类树
        $.initClassifyTree('treeDemo','searchClassifyId','','classifyType',newRegionCode);
    }

    function hideDirMgr() {
   	 $("#min-aside").animate({
         width:"2%"
     },200);
     $("#dir-Manger").hide();
     $("#regionDiv").hide();
     $("#forward").show(400);
     $("#backward").hide(500);
     $("#treeDemo").hide(200);
     $("#min-aside").css("border","none")
     $("div.box div.content_table").animate({
         width: "98%"
     })

     $(this).parents("div.user-panel").css("background","#f4f6f9");
    }

    function showDirMgr() {
    	 $("div.box div.content_table").animate({
             width: "86%"
         },400)
         $("#min-aside").animate({
             width:"14%"
         },500);
         $("#dir-Manger").show();
         $("#regionDiv").show();
         $("#forward").hide(400);
         $("#backward").show(500);
         $("#treeDemo").show(200);
         $("#min-aside").css("border","1px solid #ddd");

         $(".user-panel").css("background","none");
    }


    function hideAndShow(){
        $("#forward").hide();
        $("#dir-Manger").parent("div.user-panel").css("text-align","left")
        $("#backward").click(function(){
            hideDirMgr();
        })
        $("#forward").click(function(){
            showDirMgr();
        })
    }



    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirDataApply/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 10,
        smartDisplay: false,
        onRefresh: function(){
            var isAudited = $('#isAudited').val();
            if(isAudited == '0'){
                $(tableSelector).data("bootstrap.table").showColumn('id');
            }else{
                $(tableSelector).data("bootstrap.table").hideColumn('id');
            }
        },
        columns: [{
            field: 'classifyStructureName',
            title: '所属目录分类',
            align: 'left',
            valign: 'middle',
            width: '160',
            sortable: false,
            formatter:function(value){
                if(value == undefined){
                    value="";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'datasetName',
            title: '所属信息资源',
            align: 'left',
            valign: 'middle',
            width: '120',
            sortable: false,
            formatter:function(value){
                if(value == undefined){
                    value="";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },
            // {
            // field: 'limitVisitCnt',
            // title: '期望使用次数',
            // align: 'left',
            // valign: 'middle',
            // width: '120',
            // sortable: false
            // },
            // {
            // field: 'limitVisitDatePeriod',
            // title: '期望使用时限',
            // align: 'left',
            // valign: 'middle',
            // width: '300',
            // sortable: false
            // },
            {
            field: 'realName',
            title: '申请人',
            align: 'left',
            valign: 'middle',
            sortable: false,
            width: '120',
            formatter: function (value, row) {
            	if(value == undefined){
            		return ""
            	}else{
            		return  "<p title="+value + "[" + row.userName + "]"+">"+value + "[" + row.userName + "]"+"</p>"
            	}
            }
        }, {
            field: 'deptName',
            title: '申请人所属组织',
            align: 'left',
            valign: 'middle',
            width: '120',
            sortable: false
        }, {
            field: 'applyDate',
            title: '提交时间',
            align: 'left',
            valign: 'middle',
            width: '160',
            sortable: false
        }, {
            field: 'status',
            title: '状态',
            align: 'left',
            valign: 'middle',
            width: '60',
            sortable: false,
            formatter: function (value) {
                var result = "待审核";
                if (value == "1") {
                    result = "<font > 同意</font>"
                } else if (value == "2") {
                    result = "<font > 拒绝</font>"
                }
                return result;
            }
        }, {
            field: 'id',
            title: '操作',
            align: 'left',
            valign: 'middle',
            width: '10%',
            sortable: false,
            formatter: function (value) {
                var auditBtn = "<a class='btn btn-primary btn-flat btn-xs' href='###' onclick='javascript:audit(\"" + value + "\")'><i class='fa fa-user'></i> 开始审核</a>";
                return auditBtn;
            }
        }
        ]
    });

    $('#isAudited').change(function(){
        setParams();
        reloadTable();
    });

    jQuery('#queryBtnId').click(function () {
        setParams();
        reloadTable();
    });
});

function audit(id) {
    update('共享审核', basePathJS + '/dirDataApply/edit', id, 900, 700);
}

function setParams() {
    var searchKeyVal = $('#searchKeyId').val();
    var isAudited = $('#isAudited').val();
    var searchClassifyId = $('#searchClassifyId').val();
    var regionCode = $.getSelectedRegionCode();
    paramsObj = {classifyId:searchClassifyId,regionCode:regionCode,isAudited: isAudited, searchKey: searchKeyVal};
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}