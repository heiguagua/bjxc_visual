<%--
  Created by IntelliJ IDEA.
  User: Zhangm
  Date: 2017/9/12
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/apply/data/userRegister.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                <small>门户数据管理 > 用户注册管理</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <form class="form-inline" method="post">
                            <div class="box-header">
                                <div class="input-group" style="float:right">
                                    <input class="form-control" id="editSearch" name="searchEdit" placeholder="资源名称"
                                           type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat btn_blue" id="queryBtnEdit" type="button">
                                            <i class="fa fa-search"></i> 查询
                                        </button>
                                    </div>
                                    </input>
                                </div>
                                <div class="input-group  pull-right mgr15 ">
                                    <select class="form-control" id="ugChangeSearch">
                                        <option value="login_name" selected>用户名</option>
                                        <option value="real_name">姓名</option>
                                    </select>
                                </div>
                                <div class="input-group  pull-right mgr15">
                                    <select class="form-control" id="ugChangeSel" onchange="ugChange(this)">
                                        <option value="100">全部</option>
                                        <option value="0">申请中</option>
                                        <option value="1">已通过</option>
                                        <option value="2">已拒绝</option>
                                    </select>
                                </div>

                            </div>
                        </form>
                        <div class="box-body table-responsive " id="userregisterBox"  style="margin-top: 20px">
                            <!-- 表格 -->
                            <table class="layui-tables" id="userregisterTable" lay-even="" lay-skin="row"></table>
                            <!-- 表格 end-->
                        </div>
                    </div>
                </div>
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <div class="control-sidebar-bg"></div>
</div>
</body>
</html>
