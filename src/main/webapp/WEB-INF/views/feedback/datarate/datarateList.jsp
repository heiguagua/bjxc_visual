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
    <script src="<%=basePath%>/js/feedback/datarate/datarateList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                <small>门户管理 > 评分管理</small>
            </h1>
        </section>
        <!-- Content Header (Page header) -->
        <section class="content" id="duMg">
            <div class="row">
                <div class="col-xs-12 seventy-percent-height">
                    <div class="box">
                        <form class="form-inline marginBot" method="post">
                            <div class="box-header">
                                <div class="input-group pull-right">
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
                        <div class="box-body table-responsive no-padding">
                            <!-- 表格 -->
                            <table class="table-striped" id="datarateListTable" lay-even="" lay-skin="row">
                            </table>
                            <!-- 表格 end-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="content" id="duMg-dd" class="hidden">
            <div class="row">
                <div class="col-xs-12 seventy-percent-height">
                    <div class="box">
                        <form class="form-inline marginBot" method="post">
                            <div class="box-header">
                                <div class="input-group">
                                    <a class="btn btn-primary  btn-flat btn-myself" onclick="javascript:retdcView()"> <i class="fa fa-reply">&#160;</i>返回评分管理列表</a>
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
                        <div class="box-body table-responsive no-padding">
                            <!-- 表格 -->
                            <table class="table-striped" id="datarateDetailTable" lay-even="" lay-skin="row">
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
     * 纠错搜索框
     * */
    $('#queryListBtnEdit').click(function () {
        var searchKey = $('#editListSearch').val();
        var params = {
            query:{
                searchKey:searchKey
            }
        }
        $('#datarateListTable').bootstrapTable('refresh', params);
    });
    /**
     * 初始化纠错列表
     * */
    $('#datarateListTable').bootstrapTable({
        url:basePathJS + "/feedback/dirdatarate/list",
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
            {field: 'classifyName', title: '评分目录'},
            {field: 'datasetName', title: '目录下数据集'},
            {field: 'rateDate', title: '最后评分时间'},
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
    $('#duMg-dd').addClass('hidden');
    /**
     * [dcView 点击查看]
     * @param  {[type]} v [description]
     * @return {[type]}   [description]
     */
    function dcView(v) {
        dcViewTable(v);
        $('#duMg').addClass('hidden');
        $('#duMg-dd').removeClass('hidden');
    }
    /**
     * [retdcView 返回]
     * @return {[type]} [description]
     */
    function retdcView() {
        $('#duMg-dd').addClass('hidden');
        $('#duMg-dd .box-body').html('<table class="layui-table" id="datarateDetailTable" lay-even="" lay-skin="row"></table>');
        $('#duMg').removeClass('hidden');
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
        $('#datarateDetailTable').bootstrapTable('refresh', params);
    });
    /**
     * 详情列表
     * */
    function dcViewTable(v) {
        $('#datarateDetailTable').bootstrapTable({
            url:basePathJS + "/feedback/dirdatarate/detail?dcmId="+v,
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
                {field: 'raterName', title: '评分用户'},
                {field: 'datasetName', title: '资源名称'},
                {field: 'rateScore', title: '评分值', width: '15%'},
                {field: 'rateDate', title: '最后评分时间', width: '15%'}
            ]

        });
    }
</script>
</body>
</html>
