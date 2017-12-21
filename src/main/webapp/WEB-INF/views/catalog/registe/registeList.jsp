<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/catalog/registe/registeList.js"></script>
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
                    <small>目录管理 > 目录注册</small>
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
                                    <div style="height: 94%">
                                        <ul id="treeDemo" class="ztree"></ul>
                                    </div>
                                </section>
                            </aside>
                            <div class="content_table">
	                          <div class="btn-group btn_develop">

					       	 		<ul class="title_ul" id="chooseTab">
					                	<li class="active" ><i class="fa fa-paper-plane-o" style="font-size:20px"></i>&nbsp;待注册</li>
					                	<li><i class="fa fa-television" aria-hidden="true"></i>&nbsp;已注册</li>

					                </ul>
							   </div>
							   <div id="tab1">
                                        <form class="form-inline" method="post"   onsubmit="return false;">
                                                <div class="box-header box-header-myself">
                                                    <div class="input-group">
                                                        <a class="btn btn-primary btn-flat btn-myself" id="registeButton">
                                                           <!--  <i class="fa fa-plus">
                                                            </i> -->
                                                            <img src="<%=context_path%>/images/userImg/addimg.png"/>
                                                            注册
                                                        </a>
                                                    </div>
                                                    <div class="input-group pull-right">
                                                        <div class="input-group">
                                                            <input class="form-control" id="unRegisteSearchName" placeholder="资源名称" type="text">
                                                            <div class="input-group-btn">
                                                                <button class="btn btn-primary btn-flat btn_blue" id="unRegisteQueryBtn" type="button">
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
                                            <table id="unRegisteTable" class="table table-hover"></table>
                                        </div>
							   </div>
							   <div id="tab2">
							         	<form class="form-inline" method="post"   onsubmit="return false;">
                                                <div class="box-header box-header-myself">
                                                    <div class="input-group pull-right">
                                                        <div class="input-group">
                                                            <input class="form-control" id="registedSearchName" placeholder="资源名称" type="text">
                                                            <div class="input-group-btn">
                                                                <button class="btn btn-primary btn-flat btn_blue" id="registedQueryBtn" type="button">
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
                                            <table id="registedTable" class="table table-hover"></table>
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
