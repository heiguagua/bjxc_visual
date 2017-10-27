<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/log/logList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@include file="/WEB-INF/views/common/menu.jsp" %>

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    <small>系统管理 > 日志查询</small>
                </h1>
            </section>
            <!-- Main content -->
            <section class="content">
                <!-- Your Page Content Here -->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="box">
                            <div class="box-header">
                                <form class="form-inline">
                                    <div class="form-group pull-right">
                                        <div class="form-group">
                                            <label class="sr-only" for="operatorRealName">operatorRealName</label>
                                            <input id="operatorRealName" type="text" name="operatorRealName" class="form-control" placeholder="操作人真实姓名">
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="operatorUserName">operatorUserName</label>
                                            <input id="operatorUserName" type="text" name="operatorUserName" class="form-control" placeholder="操作人用户名">
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="operateTimeRange">operateTimeRange</label>
                                            <input id="operateTimeRange" type="text" name="operateTimeRange" class="form-control date" readonly placeholder="操作开始日期 ~ 操作结束日期" style="width: 350px;background-color: #fff">
                                        </div>
                                        <div class="form-group">
                                            <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i> 查询</button>
                                            <button id="queryBtnReset" type="button" class="btn btn-danger btn-flat" style="margin-left: 15px;"><i class="fa fa-undo"></i> 重置</button>
                                        </div>
                                    </div>

                                </form>
                            </div>

                            <div class="box-body table-responsive ">

                                <table id="systemLogTableId" class="table table-hover">
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
