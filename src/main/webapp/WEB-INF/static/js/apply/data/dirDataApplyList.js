/**
 * Created by lenovo on 2017/5/9.
 */
var tableSelector = '#dirDataApplyTableId';

jQuery(document).ready(function () {
    "use strict";
    var isAudited = '0';
    $('#isAudited').val(isAudited);
    var paramsObj = {isAudited: isAudited};
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
                if($('#searchClassifyId').val() != treeNode.id){
                    $('#searchClassifyId').val(treeNode.id);
                    setParams();
                    reloadTable();
                }
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
            // onClick: function (e, treeId, treeNode) { //点击最下层子节点，获取目录类别的全名称，显示到输入框中
            //
            //     $('#searchClassifyId').val(treeNode.id);
            //     setParams();
            //     reloadTable();
            // }
        }
    };
    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), setting);
        hideAndShow();
    });


    //目录类别下拉查询框
    $.initQueryClassifyTreeSelect('searchClassifyTreeDemo','searchClassifyName','searchClassifyId','searchClassifyMenuContent');

    function hideDirMgr() {
   	 $("#min-aside").animate({
         width:"2%"
     },200);
     $("#dir-Manger").hide();
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
         $("#forward").hide(400);
         $("#backward").show(500);
         $("#treeDemo").show(200);
         $("#min-aside").css("border","1px solid #ddd");

         $(".user-panel").css("background","none");
    }


    function hideAndShow(){
        $("#forward").hide();
        $("#dir-Manger").parent("div.user-panel").css("text-align","center")
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
            align: 'center',
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
            align: 'center',
            valign: 'middle',
            width: '120',
            sortable: false,
            formatter:function(value){
                if(value == undefined){
                    value="";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'limitVisitCnt',
            title: '期望使用次数',
            align: 'center',
            valign: 'middle',
            width: '120',
            sortable: false
        }, {
            field: 'limitVisitDatePeriod',
            title: '期望使用时限',
            align: 'center',
            valign: 'middle',
            width: '300',
            sortable: false
        }, {
            field: 'realName',
            title: '申请人',
            align: 'center',
            valign: 'middle',
            sortable: false,
            width: '120',
            formatter: function (value, row) {
                return value + '[' + row.userName + ']';
            }
        }, {
            field: 'deptName',
            title: '申请人所属组织',
            align: 'center',
            valign: 'middle',
            width: '120',
            sortable: false
        }, {
            field: 'applyDate',
            title: '提交时间',
            align: 'center',
            valign: 'middle',
            width: '160',
            sortable: false
        }, {
            field: 'status',
            title: '状态',
            align: 'center',
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
            align: 'center',
            valign: 'middle',
            width: '80',
            sortable: false,
            formatter: function (value) {
                var auditBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:audit(\"" + value + "\")'><i class='fa fa-user'></i> 开始审核</a>";
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

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function audit(id) {
    update('共享审核', basePathJS + '/dirDataApply/edit', id, 900, 700);
}