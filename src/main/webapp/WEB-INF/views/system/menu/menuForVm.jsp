<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1 -->
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/system/menu/menuForVmList.js"></script>
	<script src="<%=context_path%>/js/system/Encode/Encode.js"></script>
</head>
<style type="text/css">
/*强制解决菜单管理里面 当选择条数大于50条 删除框位置不出来问题  */
.layui-layer-dialog{
	top:340px !important;
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
                    <small>系统管理 > 菜单管理</small>
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
                                            <a class="btn btn-primary  btn-flat btn-myself" onclick="javascript:addMenu()" > <i class="fa fa-plus"></i> 创建菜单</a>
                                        </div>
                                    <%--</#if>--%>
                                    <div class="input-group pull-right">
                                        <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="菜单名称">
                                        <div class="input-group-btn">
                                            <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i> 查询</button>
                                        </div>
                                    </div>

                                </div><!-- /.box-header -->
                            </div>

                            <div class="box-body table-responsive">
                                <table id="systemMenuTableId" class="table table-hover">

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
