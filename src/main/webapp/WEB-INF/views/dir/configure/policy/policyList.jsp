<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/dir/configure/policy/policyList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>配置管理 > 政策发布</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="form-inline">
                            <div class="box-header">
                                <%--<#if permissions?seq_contains('addDept')>--%>
                                <div class="input-group">
                                    <a class="btn btn-primary  btn-flat btn-myself" onclick="javascript:addUser()" > <i class="fa fa-plus"></i>新增</a>
                                </div>
                                <%--</#if>--%>
                                <div class="input-group pull-right">
                                    <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="标题">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i>查询</button>
                                    </div>
                                </div>

                            </div><!-- /.box-header -->
                        </div>

                        <div class="box-body table-responsive no-padding">
                            <table id="policyListId" class="table table-hover">

                            </table>
                        </div><!-- /.box-body -->

                    </div><!-- /.box -->
                </div>
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <div class="control-sidebar-bg"></div>
</div>

</body>
</html>
