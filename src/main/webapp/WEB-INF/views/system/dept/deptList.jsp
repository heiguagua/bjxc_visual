<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/system/dept/deptList.js"></script>

</head>
<style type="text/css">
.layui-layer-dialog{
	top:180px !important;
}
</style>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@include file="/WEB-INF/views/common/menu.jsp" %>

        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    <small>系统管理 > 组织机构管理</small>
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
                                            <a class="btn btn-primary btn-flat btn-myself" onclick="javascript:addDept()" id="createDeptA">
                                                <img src="<%=basePath%>/images/userImg/addimg.png"/>
                                                创建一级组织机构
                                            </a>
                                        </div>
                                        <%--<div class="input-group">--%>
                                            <%--<a class="btn btn-primary btn-flat btn-myself" onclick="javascript:syncDeptClassify()" id="sysDeptA">--%>
                                                <%--<img src="<%=basePath%>/images/userImg/changeAdress.png"/>--%>
                                                <%--同步目录--%>
                                            <%--</a>--%>
                                        <%--</div>--%>
                                        <div class="input-group">
                                            <a class="btn btn-default btn-flat  btn-myself  hidden" id="back" onclick="javascript:backPreDeptList()">
                                                < 返回
                                            </a>
                                        </div>
                                        <div class="input-group">
                                            <input id="regionNameId" type="text" name="regionName" class="form-control" placeholder="行政区域" >
                                        </div>
                                    <%--</#if>--%>
                                    <div class="input-group pull-right">

                                        <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="组织机构名称" >
                                        <div class="input-group-btn">
                                            <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i> 查询</button>
                                        </div>
                                    </div>

                                </div><!-- /.box-header -->
                            </div>

                            <div class="box-body table-responsive" id="tableList">
                                <table id="systemDeptTableId" class="table table-hover">

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
