<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/catalog/query/queryList.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                <small>目录管理 > 目录查询</small>
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
                                <div class="input-group">
                                    <input type="text" id="searchClassifyName" placeholder="请选择目录类别" class="form-control">
                                    <input type="hidden" id="searchClassifyId">
                                    <div class="menu-wrap">
                                        <div id="searchClassifyMenuContent" class="menuContent" style="display:none;">
                                            <ul id="searchClassifyTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="input-group">
                                    <input class="form-control" id="searchName" placeholder="资源名称" type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat" id="queryBtn" type="button">
                                            <i class="fa fa-search">
                                            </i> 查询
                                        </button>
                                    </div>
                                    </input>
                                </div>
                                <div class="input-group">
                                    <button type="button" id="downloadExcel" class="btn btn-primary btn-flat dropdown-toggle  btn-myself"
                                            data-toggle="dropdown">
                                        <!-- <i class="fa fa-plus"></i> -->导出
                                    </button>
                                </div>
                            </div>
                        </form>
                        <div class="box-body table-responsive no-padding">
                            <!-- 表格 -->
                            <table id="queryTable" class="table table-hover"></table>
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
