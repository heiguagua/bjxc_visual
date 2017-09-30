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
                        <form class="form-inline marginBot" method="post">
                            <div class="box-header">
                                <div class="input-group pull-right">
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
                        <div class="box-body table-responsive no-padding">
                            <!-- 表格 -->
                            <table class="table-striped" id="datacollectionListTable" lay-even="" lay-skin="row">
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
                        <div class="box-body table-responsive no-padding">
                            <!-- 表格 -->
                            <table class="table-striped" id="datacollectionDetailTable" lay-even="" lay-skin="row">
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
            {field: 'classifyName', title: '收藏目录'},
            {field: 'datasetName', title: '目录下数据集'},
            {field: 'collectDate', title: '最后收藏时间'},
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
        $('#dcMg-dd').removeClass('hidden');
    }
    /**
     * [retdcView 返回]
     * @return {[type]} [description]
     */
    function retdcView() {
        $('#dcMg-dd').addClass('hidden');
        $('#dcMg-dd .box-body').html('<table class="layui-table" id="datacollectionDetailTable" lay-even="" lay-skin="row"></table>');
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
