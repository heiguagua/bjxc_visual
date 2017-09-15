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
        <!-- Content Header (Page header) -->
        <section class="content" id="drMg">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <form action="http://localhost:8123/Dataset_getDatasetList" class="form-inline" method="post">
                            <div class="box-header">
                                <div class="input-group">
                                    纠错管理
                                </div>
                                <div class="input-group pull-right">
                                    <input class="form-control" id="editSearch" name="searchEdit" placeholder="资源名称" type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat" id="queryBtnEdit" type="button">
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
                            <table class="layui-table" id="datacorrectionTable" lay-even="" lay-skin="row">
                            </table>
                            <!-- 表格 end-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="content" id="drMg-dd" class="hidden">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <form action="http://localhost:8123/Dataset_getDatasetList" class="form-inline" method="post">
                            <div class="box-header">
                                <div class="input-group">
                                    <a class="btn btn-primary  btn-flat" onclick="javascript:retdcView()"> <i class="fa fa-reply">&#160;</i>返回纠错管理列表</a>
                                </div>
                                <div class="input-group pull-right">
                                    <input class="form-control" id="editSearch" name="searchEdit" placeholder="资源名称" type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat" id="queryBtnEdit" type="button">
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
                            <table class="layui-table" id="datacorrectionInfoTable" lay-even="" lay-skin="row">
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
    $('#datacorrectionTable').bootstrapTable({
        pagination: true, //分页
        columns: [
            { field: 'a', title: '序号', width: '5%' },
            { field: 'b', title: '纠错目录' },
            { field: 'c', title: '目录下数据集' },
            { field: 'd', title: '最后纠错时间' },
            { field: 'e', title: '纠错详情',
                align: 'center',
                valign: 'middle',
                sortable: false,
                width: '10%',
                formatter: function(value) {
                    var editBtn = [
                        "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:dcView(\"" + value + "\",1)'><i class='fa fa-edit'>&#160;</i>点击查看</a>&#160;"
                    ].join('');
                    return editBtn;
                }
            }
        ],
        data:Mock.mock({'list|32':[{'a|+1': 1,'b|1': '@CPARAGRAPH','c|1':'@CTITLE','e|1': '@BOOLEAN','d|+1':'@DATE @TIME'}]}).list
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
        $('#drMg-dd').removeClass('hidden');
    }
    /**
     * [retdcView 返回]
     * @return {[type]} [description]
     */
    function retdcView(){
        $('#drMg-dd').addClass('hidden');
        $('#drMg-dd .box-body').html('<table class="layui-table" id="datacorrectionInfoTable" lay-even="" lay-skin="row"></table>');
        $('#drMg').removeClass('hidden');
    }

    function dcViewTable(v) {
        $('#datacorrectionInfoTable').bootstrapTable({
            pagination: true, //分页
            columns: [
                { field: 'a', title: '序号', width: '5%' },
                { field: 'b', title: '纠错用户' },
                { field: 'c', title: '最后纠错时间',width:'15%'}
            ],
            data:Mock.mock({'list|32':[{'a|+1': 1,'b|1':['普通用户','超级管理员'],'e|1': '@BOOLEAN','c|+1':'@DATE @TIME'}]}).list
        });
    }
</script>
</body>
</html>
