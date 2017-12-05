<%--
  Created by IntelliJ IDEA. 1
  User: lenovo
  Date: 2017/5/9
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/system/role/roleList.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>系统管理 > 角色管理</small>
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
                                <%--<#if permissions?seq_contains('addRole')>--%>
                                <div class="input-group">
                                    <a class="btn btn-primary btn-flat btn-myself" onclick="javascript:addRole()" >
                                        <img src="<%=context_path%>/images/userImg/addimg.png"/>
                                        创建角色</a>
                                </div>
                                <div class="input-group">
                                    <a class="btn btn-primary btn-flat btn-myself"  onclick="javascript:deleteBatchRole()" >
                                        <img src="<%=context_path%>/images/userImg/delImg.png"/>
                                        批量删除</a>
                                </div>
                                <%--</#if>--%>
                                <div class="input-group  pull-right">
                                    <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="角色名称">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i> 查询</button>
                                        </div>
                                </div>

                            </div><!-- /.box-header -->
                        </div>

                        <div class="box-body table-responsive ">
                            <table id="systemRoleTableId" class="table table-hover">

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
