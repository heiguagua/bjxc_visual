<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/catalog/audit/auditList.js"></script>
</head>
<style>
div.layui-layer-iframe{
	min-width:1000px;
}
</style>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                <small>目录管理 > 目录审核</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box clear">
                        <aside class="main-sidebar—Du sidebar-myself" id="min-aside">
                            <section class="sidebar">
                                <div class="user-panel" style="height: 6%">
                                    <b id="dir-Manger">目录分类</b>
                                    <div class="pull-right image">
                                        <input type="hidden" id="searchClassifyId">
                                        <input type="hidden" id="classifyType">
                                        <a href="#" class="sidebar-toggle" role="button" style="right: -14px;">
                                            <i style="color: rgb(51, 51, 51);" class="fa fa-backward pull-right" id="backward" title="收起"></i>
                                                <i style="color: rgb(51, 51, 51);"  class="fa fa-forward pull-right" id="forward"  title="扩展"></i>
                                        </a>
                                    </div>
                                </div>
                                <%--<div style="height: 6%" id="regionDiv">
                                    <div class="input-group" style="margin:2px;">
                                        <input type="text" id="searchRegionName" placeholder="请选择区域"
                                               class="form-control" readonly style="background-color: #FFFFFF">
                                        <input type="hidden" id="searchRegionCode">

                                        <div class="menu-wrap">
                                            <div id="searchRegionMenuContent" class="menuContent"
                                                 style="display:none;">
                                                <ul id="searchRegionTreeDemo" class="ztree"
                                                    style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>--%>
                                <div style="height: 94%;">
                                    <ul id="treeDemo" class="ztree"></ul>
                                </div>
                            </section>
                        </aside>
						<div class="content_table">

                                <div class="btn-group btn_develop">
                                        <ul class="title_ul" id="releaseTab">
                                            <li class="active" ><i class="fa fa-paper-plane-o" style="font-size:20px"></i>&nbsp;待审核</li>
                                            <li><i class="fa fa-television" aria-hidden="true"></i>&nbsp;已审核</li>
                                        </ul>
						        </div>

                                <div id="tab1">
                                        <form class="form-inline" method="post"    onsubmit="return false;">
                                                <div class="box-header box-header-myself">
                                                        <div class="input-group">
                                                            <a class="btn btn-primary btn-flat btn-myself" id="auditButton">
                                                                <!-- <i class="fa fa-plus">
                                                                </i> -->
                                                                <img src="<%=context_path%>/images/userImg/subCheckimg.png"/>
                                                                审核
                                                            </a>
                                                        </div>
                                                        <div class="input-group pull-right">
                                                            <div class="input-group">
                                                                <input class="form-control" id="unAuditSearchName" placeholder="资源名称" type="text">
                                                                <div class="input-group-btn">
                                                                    <button class="btn btn-primary btn-flat btn_blue" id="unAuditQueryBtn" type="button">
                                                                        <i class="fa fa-search">
                                                                        </i> 查询
                                                                    </button>
                                                                </div>
                                                                </input>
                                                            </div>
                                                        </div>
				                                </div>
				                        </form>
				                        <div class="box-body table-responsive table-myself">
				                            <table id="unAuditTable" class="table table-hover"></table>
				                        </div>
						        </div>

						        <div id="tab2">
                                        <form class="form-inline" method="post"    onsubmit="return false;">
                                                <div class="box-header box-header-myself">
                                                        <div class="input-group pull-right">
                                                            <div class="input-group">
                                                                <input class="form-control" id="auditedSearchName" placeholder="资源名称" type="text">
                                                                <div class="input-group-btn">
                                                                    <button class="btn btn-primary btn-flat btn_blue" id="auditedQueryBtn" type="button">
                                                                        <i class="fa fa-search">
                                                                        </i> 查询
                                                                    </button>
                                                                </div>
                                                                </input>
                                                            </div>
                                                        </div>
				                                </div>
				                        </form>
				                        <div class="box-body table-responsive table-myself">
				                            <table id="auditedTable" class="table table-hover"></table>
				                        </div>
						        </div>
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
