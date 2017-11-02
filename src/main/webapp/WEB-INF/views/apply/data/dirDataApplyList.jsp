<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/9
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/apply/data/dirDataApplyList.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>门户管理 > 共享审核管理</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">

                        <aside class="main-sidebar—Du sidebar-myself" id="min-aside">
                            <section class="sidebar">
                                <div class="user-panel">
                                    <b id="dir-Manger">目录分类</b>
                                    <div class="pull-right image">
                                        <a href="#" class="sidebar-toggle" role="button" style="right: -14px;">

                                            <i class="fa fa-backward pull-right" id="backward" title="收起"></i>
                                            <i class="fa fa-forward pull-right" id="forward"  title="扩展"></i>
                                        </a>

                                    </div>

                                </div>
                                <div>
                                    <ul id="treeDemo" class="ztree"></ul>
                                </div>
                            </section>

                        </aside>

                        <div class="form-inline">
                            <div class="box-header">
                            	<div class="input-group pull-right">
                                    <input type="hidden" id="searchClassifyId">
                                    <input id="searchKeyId" type="text" name="searchKey" class="form-control" placeholder="信息资源名称">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i> 查询</button>
                                    </div>
                                </div>
                                <div class="input-group pull-right" style="margin-right:4px;">
                                    <select class="form-control"  name="isAudited" id="isAudited">
                                        <option value="0">待审核</option>
                                        <option value="1">已审核</option>
                                    </select>
                                </div>
                                

                            </div><!-- /.box-header -->
                        </div>

                        <div class="box-body table-responsive table-myself">
                            <table id="dirDataApplyTableId" class="table table-hover">

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
