<%--
  Created by IntelliJ IDEA.
  User: GongJun
  Date: 2017/9/12
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/feedback/datacorrection/datacorrectionList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                <small>门户管理 > 纠错管理</small>
            </h1>
        </section>
        <!-- Content Header (Page header) -->
        <section class="content" id="drMg">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box clear">

                        <aside class="main-sidebar—Du sidebar-myself" id="min-aside">
                            <section class="sidebar">
                                <div class="user-panel">
                                    <b id="dir-Manger">目录分类</b>
                                    <div class="pull-right image">
                                        <a href="#" class="sidebar-toggle" role="button" style="right: -14px;">

                                           <i style="color: rgb(51, 51, 51);" class="fa fa-backward pull-right" id="backward" title="收起"></i>
                                                <i style="color: rgb(51, 51, 51);"  class="fa fa-forward pull-right" id="forward"  title="扩展"></i>
                                        </a>

                                    </div>

                                </div>
                                <div>
                                    <ul id="treeDemo" class="ztree"></ul>
                                </div>
                            </section>

                        </aside>
						 <div class="content_table">
						 	     <form class="form-inline marginBot" method="post">
                            <div class="box-header">
                                <div class="input-group pull-right">
                                    <input type="hidden" id="searchClassifyId">
                                    <input class="form-control" id="editListSearch" name="searchEdit" placeholder="资源名称" type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat btn_blue" id="queryListBtnEdit" type="button">
                                            <i class="fa fa-search">
                                            </i>  搜索
                                        </button>
                                    </div>
                                    </input>
                                </div>
                            </div>
                        </form>
                        <div class="box-body table-responsive table-myself">
                            <!-- 表格 -->
                            <table class="table table-hover" id="datacorrectionListTable" lay-even="" lay-skin="row">
                            </table>
                            <!-- 表格 end-->
                        </div>
						 </div>
                   
                    </div>
                </div>
            </div>
        </section>
        <section class="content" id="drMg-dd" class="hidden">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <form class="form-inline marginBot" method="post">
                            <div class="box-header">
                                <div class="input-group">
                                    <a class="btn btn-primary  btn-flat btn-myself" onclick="javascript:retdcView()"> <i class="fa fa-reply">&#160;</i>返回纠错管理列表</a>
                                </div>
                                <div class="input-group pull-right">
                                    <input class="form-control" id="editDetailSearch" name="searchEdit" placeholder="用户名称" type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat btn_blue" id="queryDetailBtnEdit" type="button">
                                            <i class="fa fa-search">
                                            </i>  搜索
                                        </button>
                                    </div>
                                    </input>
                                </div>
                            </div>
                        </form>
                        <div class="box-body table-responsive table-myself">
                            <!-- 表格 -->
                            <table class="table table-hover" id="datacorrectionDetailTable" lay-even="" lay-skin="row">
                            </table>
                            <!-- 表格 end-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div><!-- /.content-wrapper -->

    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <div class="control-sidebar-bg"></div>
</div>
<script type="text/javascript">
    var tableSelector = '#datacorrectionListTable';
    var paramsObj = {};

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
//            onClick: function (e, treeId, treeNode) { //点击最下层子节点，获取目录类别的全名称，显示到输入框中
//
//                $('#searchClassifyId').val(treeNode.id);
//                setParams();
//                reloadTable();
//            }
        }
    };
    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), setting);
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


    $(function(){
        $("#forward").hide();
        $("#dir-Manger").parent("div.user-panel").css("text-align","center")
        $("#backward").click(function(){
            hideDirMgr();
        })
        $("#forward").click(function(){
            showDirMgr();
        })
    })


    /**
     * 纠错搜索框
     * */
    $('#queryListBtnEdit').click(function () {
        var searchKey = $('#editListSearch').val();
        var params = {
            query:{
                searchKey:searchKey
            }
        }
        $('#datacorrectionListTable').bootstrapTable('refresh', params);
    });
    /**
     * 初始化纠错列表
     * */
    $('#datacorrectionListTable').bootstrapTable({
        url:basePathJS + "/feedback/dirdatacorrection/list",
        method: 'get',
        responseHandler: function (res) {
            return res.rows;
        },
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageNum: 1,
        pageSize: 10,
        columns: [
            {
                field: 'a', title: '序号', width: '5%',
                formatter: function (value, row, index) {
                    return index + 1;
                }
            },
            {
                field: 'classifyName',
                title: '纠错目录',
                formatter:function(value){
                    if(value == undefined){
                        value="";
                    }
                    return '<p title="'+value+'">'+value+'</p>';
                }
            },
            {
                field: 'datasetName',
                title: '目录下数据集',
                formatter:function(value){
                    if(value == undefined){
                        value="";
                    }
                    return '<p title="'+value+'">'+value+'</p>';
                }
            },
            {field: 'correctDate', title: '最后纠错时间'},
            {field: 'correctorCount', title: '纠错人数'},
            {
                field: 'dcmId', title: '操作',
                align: 'center',
                valign: 'middle',
                sortable: false,
                width: '10%',
                formatter: function (value) {
                    var editBtn = [
                        "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dcView(\"" + value + "\")'><i class='fa fa-edit'>&#160;</i>点击查看</a>&#160;"
                    ].join('');
                    return editBtn;
                }
            }
        ]

//        data:Mock.mock({'list|32':[{'a|+1': 1,'b|1': '@CPARAGRAPH','c|1':'@CTITLE','e|1': '@BOOLEAN','d|+1':'@DATE @TIME'}]}).list
    });

</script>
<script type="text/javascript">
    $('#drMg-dd').addClass('hidden');
    /**
     * [dcView 点击查看]
     * @param  {[type]} v [description]
     * @return {[type]}   [description]
     */
    function dcView(v) {
        dcViewTable(v);
        $('#drMg').addClass('hidden');
        hideDirMgr();
        $('#drMg-dd').removeClass('hidden');
    }
    /**
     * [retdcView 返回]
     * @return {[type]} [description]
     */
    function retdcView() {
        $('#drMg-dd').addClass('hidden');
        $('#drMg-dd .box-body').html('<table class="table table-hover" id="datacorrectionDetailTable"></table>');
        showDirMgr();
        $('#drMg').removeClass('hidden');
    }
    /**
     * 详情搜索框
     * */
    $('#queryDetailBtnEdit').click(function () {
        var searchKey = $('#editDetailSearch').val();
        var params = {
            query:{
                searchKey:searchKey
            }
        }
        $('#datacorrectionDetailTable').bootstrapTable('refresh', params);
    });
    /**
     * 详情列表
     * */
    function dcViewTable(v) {
        $('#datacorrectionDetailTable').bootstrapTable({
            url:basePathJS + "/feedback/dirdatacorrection/detail?dcmId="+v,
            method: 'get',
            responseHandler: function (res) {
                return res.rows;
            },
            pagination: true, //分页
            pageNum: 1,
            pageSize: 10,
            columns: [
                {
                    field: 'a', title: '序号', width: '5%',
                    formatter: function (value, row, index) {
                        return index + 1;
                    }
                },
                {field: 'correctorName', title: '纠错用户'},
                {field: 'datasetName', title: '资源名称'},
                {field: 'correctContent', title: '纠错内容'},
                {field: 'correctDate', title: '最后纠错时间', width: '15%'}
            ]

        });
    }
</script>
</body>
</html>
