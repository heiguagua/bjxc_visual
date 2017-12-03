<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="/js/system/userAuthority/userAuthorityList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>系统管理 > 用户数据权限管理</small>
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

                                <div class="input-group" style="float:right;margin-right:4px;width:240px">
                                    <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="用户名称">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i> 查询</button>
                                    </div>
                                </div>
                                <div class="input-group">
                                    <input id="regionNameId" type="text" name="regionName" class="form-control" placeholder="区域">
                                </div>
                                <div class="input-group">
                                    <input id="deptNameId" type="text" name="deptName" class="form-control" placeholder="部门">
                                </div>
                                <div class="input-group" style="float:right">
                                    <select  class="form-control"  name="defaultAuth" id="defaultAuth">
                                        <option value="1">默认数据权限用户</option>
                                        <option value="0">自定义数据权限用户</option>
                                    </select>
                                </div>

                            </div><!-- /.box-header -->
                        </div>

                        <div class="box-body table-responsive">
                            <table id="systemAuthUserTableId" class="table table-hover">

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
