<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1 -->
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/system/user/userList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>系统管理 > 用户管理</small>
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
                                <input id="masterId" type="hidden" name="master" value="${master}" />
                                <%--<#if permissions?seq_contains('addDept')>--%>
                                <c:if test="${master}">
                                <div class="input-group">
                                    <a class="btn btn-primary btn-flat btn-myself" onclick="javascript:addUser()" >
                                        <img src="<%=context_path%>/images/userImg/addimg.png"/>
                                        创建用户
                                    </a>
                                </div>
                                <div class="input-group">
                                    <a class="btn btn-primary btn-flat btn-myself"  onclick="javascript:deleteBatchUser()" >
                                        <img src="<%=context_path%>/images/userImg/delImg.png"/>
                                        批量删除</a>
                                </div>
                                </c:if>
                                <c:if test="${!master}">
                                <%--<div class="input-group">--%>
                                    <%--<a class="btn btn-primary btn-flat btn-myself" onclick="javascript:synRemoteData()" id="synRemoteDataId">--%>
                                        <%--<img src="<%=context_path%>/images/userImg/changeAdress.png"/>--%>
                                        <%--获取用户信息--%>
                                    <%--</a>--%>
                                <%--</div>--%>
                                </c:if>
                                <div class="input-group">
                                    <input id="regionNameId" type="text" name="regionName" class="form-control" placeholder="区域">
                                </div>
                                <div class="input-group">
                                    <input id="deptNameId" type="text" name="deptName" class="form-control" placeholder="部门">
                                </div>
                                <%--</#if>--%>
                                <div class="input-group  pull-right">
                                    <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="用户名称">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i> 查询</button>
                                    </div>
                                </div>

                            </div><!-- /.box-header -->
                        </div>

                        <div class="box-body table-responsive">
                            <table id="systemUserTableId" class="table table-hover">

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
