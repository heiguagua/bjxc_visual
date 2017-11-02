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
    <script src="<%=basePath%>/js/feedback/datacollection/datacollectionList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">

        <section class="content-header">
            <h1>
                <small>门户管理 > 收藏管理</small>
            </h1>
            <!-- <ul class="title_ul">
                <li class="active"><i class="fa fa-desktop" style="font-size:20px"></i>&nbsp;常规模式</li>
                <li>引导模式</li>
                <li>图谱</li>
            </ul> -->
        </section>


        <!-- Content Header (Page header) -->
        <section class="content" id="dcMg">
            <div class="row">
                <div class="col-xs-12 seventy-percent-height">
                    <div class="box">

                        <aside class="main-sidebar—Du sidebar-myself" id="min-aside">
                            <section class="sidebar">
                                <div class="user-panel">
                                    <b id="dir-Manger">目录分类</b>
                                    <div class="pull-right image">
                                        <a href="#" class="sidebar-toggle" role="button" style="right: -14px;">

                                            <i class="fa fa-backward pull-right" id="backward" title="收起"></i>
                                            <i class="fa fa-forward pull-right" id="forward"  title="扩展"></i>
                                        </a>

                                    </div>

                                </div>
                                <div>
                                    <ul id="treeDemo" class="ztree"></ul>
                                </div>
                            </section>

                        </aside>

                        <form class="form-inline marginBot" method="post">
                            <div class="box-header">
                                <div class="input-group pull-right">
                                    <input type="hidden" id="searchClassifyId">
                                    <input class="form-control" id="editListSearch" name="searchEdit" placeholder="资源名称"
                                           type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat btn_blue" id="queryListBtnEdit" type="button">
                                            <i class="fa fa-search">
                                            </i> 搜索
                                        </button>
                                    </div>
                                    </input>
                                </div>
                            </div>
                        </form>
                        <div class="box-body table-responsive table-myself">
                            <!-- 表格 -->
                            <table class="table table-hover" id="datacollectionListTable" lay-even="" lay-skin="row">
                            </table>
                            <!-- 表格 end-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="content" id="dcMg-dd" class="hidden">
            <div class="row">
                <div class="col-xs-12 seventy-percent-height">
                    <div class="box">
                        <form class="form-inline marginBot" method="post">
                            <div class="box-header">
                                <div class="input-group">
                                    <a class="btn btn-primary  btn-flat btn-myself" onclick="javascript:retdcView()"> <i
                                            class="fa fa-reply">&#160;</i>返回收藏管理列表</a>
                                </div>
                                <div class="input-group pull-right">
                                    <input class="form-control" id="editDetailSearch" name="searchDetailEdit"
                                           placeholder="用户名称" type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat btn_blue" id="queryDetailBtnEdit" type="button">
                                            <i class="fa fa-search">
                                            </i> 搜索
                                        </button>
                                    </div>
                                    </input>
                                </div>
                            </div>
                        </form>
                        <div class="box-body table-responsive table-myself">
                            <!-- 表格 -->
                            <table class="table table-hover" id="datacollectionDetailTable" lay-even="" lay-skin="row">
                            </table>
                            <!-- 表格 end-->
                        </div>

                        <!-- 00000 -->
                        <div class="box-body table-responsive table-myself">
                            <!-- 表格 -->
                            <table id="datacollectionDetailTable" class="table table-hover"></table>
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
    var tableSelector = '#datacollectionListTable';
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


    //目录类别下拉查询框
    $.initQueryClassifyTreeSelect('searchClassifyTreeDemo','searchClassifyName','searchClassifyId','searchClassifyMenuContent');

    function hideDirMgr() {
        $("#min-aside").animate({
            width:"40px",
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
    }

    function showDirMgr() {
        $("#min-aside").animate({
            width:"230px",
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
     * 收藏搜索框
     * */
    $('#queryListBtnEdit').click(function () {
        var searchKey = $('#editListSearch').val();
        var params = {
            query:{
                searchKey:searchKey
            }
        }
        $('#datacollectionListTable').bootstrapTable('refresh', params);
    });
    /**
     * 初始化收藏列表
     * */
    $('#datacollectionListTable').bootstrapTable({
        url:basePathJS + "/feedback/dirdatacollection/list",
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
            {field: 'classifyName',
                title: '收藏目录',
                formatter:function(value){
                    if(value == undefined){
                        value="";
                    }
                    return '<p title="'+value+'">'+value+'</p>';
                }
            },
            {field: 'datasetName', title: '目录下数据集'},
            {field: 'collectDate', title: '最后收藏时间'},
            {field: 'collectorCount', title: '收藏人数'},
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
    $('#dcMg-dd').addClass('hidden');
    /**
     * [dcView 点击查看]
     * @param  {[type]} v [description]
     * @return {[type]}   [description]
     */
    function dcView(v) {
        dcViewTable(v);
        $('#dcMg').addClass('hidden');
        hideDirMgr();
        $('#dcMg-dd').removeClass('hidden');
    }
    /**
     * [retdcView 返回]
     * @return {[type]} [description]
     */
    function retdcView() {
        $('#dcMg-dd').addClass('hidden');
        $('#dcMg-dd .box-body').html('<table class="layui-table" id="datacollectionDetailTable" lay-even="" lay-skin="row"></table>');
        showDirMgr();
        $('#dcMg').removeClass('hidden');
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
        $('#datacollectionDetailTable').bootstrapTable('refresh', params);
    });
    /**
     * 详情列表
     * */
    function dcViewTable(v) {
        $('#datacollectionDetailTable').bootstrapTable({
            url:basePathJS + "/feedback/dirdatacollection/detail?dcmId="+v,
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
                {field: 'collectorName', title: '收藏用户'},
                {field: 'datasetName', title: '资源名称'},
                {field: 'collectDate', title: '最后收藏时间', width: '15%'}
            ]

//            data: Mock.mock({
//                'list|32': [{
//                    'a|+1': 1,
//                    'b|1': ['普通用户', '超级管理员'],
//                    'e|1': '@BOOLEAN',
//                    'c|+1': '@DATE @TIME'
//                }]
//            }).list
        });
    }
</script>
</body>
</html>
