<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/catalog/catalogue/catalogueList.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@include file="/WEB-INF/views/common/menu.jsp" %>

        <div class="content-wrapper">
            <section class="content-header">
                <h1>
                    <small>目录管理 > 目录编目</small>
                </h1>
            </section>
            <!-- Main content -->
            <section class="content">
                <!-- Your Page Content Here -->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="box">
                            <form action="http://localhost:8123/Dataset_getDatasetList" class="form-inline" method="post">
                                <div class="box-header">
                                    <div class="input-group">
                                        <a class="btn btn-primary btn-flat" onclick="javascript:addQuick()">
                                            <i class="fa fa-plus"></i>快速添加
                                        </a>
                                    </div>
                                    <div class="input-group">
                                        <a class="btn btn-default btn-flat" onclick="javascript:addCustom()">
                                            <i class="fa fa-plus-circle"></i>自定义添加
                                        </a>
                                    </div>
                                    <div class="input-group">
                                        <input class="form-control" id="editSelect" name="selectEdit" placeholder="请选择" type="text" />
                                    </div>
                                    <div class="input-group">
                                        <input class="form-control" id="editSearch" name="searchEdit" placeholder="资源名称" type="text">
                                        <div class="input-group-btn">
                                            <button class="btn btn-primary btn-flat" id="queryBtnEdit" type="button">
                                                <i class="fa fa-search"></i> 查询
                                            </button>
                                        </div>
                                        </input>
                                    </div>
                                </div>
                            </form>
                            <div class="box-body table-responsive no-padding">
                                <!-- 表格 -->
                                <table class="layui-table" id="catalogueTable" lay-even="" lay-skin="row"></table>
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
