<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/catalog/release/releaseList.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                <small>目录管理 > 目录发布</small>
            </h1>
        </section>
        <!-- Main content -->
      
       <div class="btn-group btn_develop">
       		
       	 <ul class="title_ul" id="releaseTab">
                	<li class="active" id="unReleaseTab"><i class="fa fa-paper-plane-o" style="font-size:20px"></i>&nbsp;待发布</li>
                	<li id="releasedTab"><i class="fa fa-television" aria-hidden="true"></i>&nbsp;已发布</li>
                	
                </ul>
		   	<!-- <ul class="nav_ulss" id="releaseTab">
		   		<li class="active" id="unReleaseTab"><i class="fa "></i>&nbsp;待发布</li>
		   		<li id="releasedTab"><i class="fa fa-list-alt"></i>&nbsp;已发布</li>
		   	</ul> -->
		   </div>
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div id="unReleaseSearchDiv">
                            <aside class="main-sidebar—Du1 sidebar-myself" id="min-aside">
                                <section class="sidebar">
                                    <div class="user-panel" style="height: 40px">
                                        <b id="dir-Manger">目录分类</b>
                                        <div class="pull-right image">
                                            <a href="#" class="sidebar-toggle" role="button" style="right: -14px;">
                                                <i  style="color: rgb(51, 51, 51);"  class="fa fa-backward pull-right" id="backward" title="收起"></i>
                                                <i style="color: rgb(51, 51, 51);"  class="fa fa-forward pull-right" id="forward"  title="扩展"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div style="height: 40px">
                                        <div class="input-group" style="margin:2px;;min-width:200px">
                                            <input type="text" id="unReleaseSearchRegionName" placeholder="请选择区域" class="form-control" readonly style="background-color: #FFFFFF">
                                            <input type="hidden" id="unReleaseSearchRegionCode">
                                            <div class="menu-wrap">
                                                <div id="unReleaseSearchRegionMenuContent" class="menuContent" style="display:none;">
                                                    <ul id="unReleaseSearchRegionTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div style="height: 88%">
                                        <ul id="unReleaseTreeDemo" class="ztree"></ul>
                                    </div>
                                </section>
                            </aside>

                            <form class="form-inline" method="post" >
                                <div class="box-header box-header-myself1">
                                    <div class="input-group">
                                        <a class="btn btn-primary btn-flat btn-myself" id="auditRejectButton">
                                            <!-- <i class="fa fa-plus">
                                            </i> -->
                                            审核驳回
                                        </a>
                                    </div>
                                    <div class="input-group">
                                        <button class="btn btn-default btn-flat  btn-myself dropdown-toggle" data-toggle="dropdown" aria-expanded="true" id="releaseButton">
                                            <!-- <i class="fa fa-plus-circle"></i> -->发布
                                            <img src="<%=basePath%>/images/userImg/Seciton_img@2x.png"/>
                                            <!-- <span class="caret"></span> -->
                                        </button>
                                        <ul class="dropdown-menu" role="menu" style="left:-21px;text-align:center;">
                                            <li><a id="releaseAll" href="#">同时发布</a></li>
                                            <li><a id="releaseToInternet" href="#">发布到互联网</a></li>
                                            <li><a id="releaseToDzzw" href="#">发布到电子政务外网</a></li>
                                        </ul>
                                    </div>
                                    <div class="input-group pull-right">
                                        <input type="hidden" id="unReleaseSearchClassifyId">
                                        <input type="hidden" id="unReleaseClassifyType">
                                        <%--<div class="input-group" style="margin-right:4px;min-width:240px">
                                            <input type="text" id="unReleaseSearchRegionName" placeholder="请选择区域" class="form-control" readonly style="background-color: #FFFFFF">
                                            <input type="hidden" id="unReleaseSearchRegionCode">
                                            <div class="menu-wrap">
                                                <div id="unReleaseSearchRegionMenuContent" class="menuContent" style="display:none;">
                                                    <ul id="unReleaseSearchRegionTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                                </div>
                                            </div>
                                        </div>--%>
                                        <div class="input-group">
                                            <input class="form-control" id="unReleaseSearchName" placeholder="资源名称" type="text">
                                            <div class="input-group-btn">
                                                <button class="btn btn-primary btn-flat btn_blue" id="unReleaseQueryBtn" type="button">
                                                    <i class="fa fa-search">
                                                    </i> 查询
                                                </button>
                                            </div>
                                            </input>
                                        </div>
                                    </div>
                                    <%--<div class="input-group pull-right" style="margin-right:4px;width: 240px">
                                        <input type="text" id="unReleaseSearchClassifyName" placeholder="请选择目录类别" class="form-control" readonly style="background-color: #FFFFFF">
                                        <input type="hidden" id="unReleaseSearchClassifyId">
                                        <div class="menu-wrap">
                                            <div id="unReleaseSearchClassifyMenuContent" class="menuContent" style="display:none;">
                                                <ul id="unReleaseSearchClassifyTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                            </div>
                                        </div>
                                    </div>--%>

                                </div>
                            </form>
                        </div>

                        <div style="display:none" id="releasedSearchDiv">
                            <!-- 复制二级标题 已经发布 -->
                            <aside class="main-sidebar—Du1 sidebar-myself" id="min-aside2">
                                <section class="sidebar">
                                    <div class="user-panel" style="height: 40px">
                                        <b id="dir-Manger2">目录分类</b>
                                        <div class="pull-right image">
                                            <a href="#" class="sidebar-toggle" role="button" style="right: -14px;">
                                                <i style="color: rgb(51, 51, 51);"  class="fa fa-backward pull-right" id="backward2" title="收起"></i>
                                                <i style="color: rgb(51, 51, 51);"  class="fa fa-forward pull-right" id="forward2"  title="扩展"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div style="height: 40px">
                                        <div class="input-group" style="margin:2px;min-width:200px">
                                            <input type="text" id="releasedSearchRegionName" placeholder="请选择区域" class="form-control" readonly style="background-color: #FFFFFF">
                                            <input type="hidden" id="releasedSearchRegionCode">
                                            <div class="menu-wrap">
                                                <div id="releasedSearchRegionMenuContent" class="menuContent" style="display:none;">
                                                    <ul id="releasedSearchRegionTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div style="height: 88%">
                                        <ul id="releasedTreeDemo" class="ztree"></ul>
                                    </div>
                                </section>
                            </aside>

                            <form class="form-inline" method="post">
                                <div class="box-header box-header-myself1">

                                    <div class="input-group">
                                        <a class="btn btn-default btn-flat  btn-myself" id="offlineButton">
                                            <!-- <i class="fa fa-plus-circle"></i> -->下架
                                        </a>
                                    </div>
                                    <div class="input-group pull-right">
                                        <input type="hidden" id="releasedSearchClassifyId">
                                        <input type="hidden" id="releasedClassifyType">
                                        <%--<div class="input-group" style="margin-right:4px;min-width:240px">
                                            <input type="text" id="releasedSearchRegionName" placeholder="请选择区域" class="form-control" readonly style="background-color: #FFFFFF">
                                            <input type="hidden" id="releasedSearchRegionCode">
                                            <div class="menu-wrap">
                                                <div id="releasedSearchRegionMenuContent" class="menuContent" style="display:none;">
                                                    <ul id="releasedSearchRegionTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                                </div>
                                            </div>
                                        </div>--%>
                                        <div class="input-group">
                                            <input class="form-control" id="releasedSearchName" placeholder="资源名称" type="text">
                                            <div class="input-group-btn">
                                                <button class="btn btn-primary btn-flat btn_blue" id="releasedQueryBtn" type="button">
                                                    <i class="fa fa-search">
                                                    </i> 查询
                                                </button>
                                            </div>
                                            </input>
                                        </div>
                                    </div>
                                    <%--<div class="input-group pull-right" style="margin-right:4px;width: 240px">
                                        <input type="text" id="releasedSearchClassifyName" placeholder="请选择目录类别" class="form-control" readonly style="background-color: #FFFFFF">
                                        <input type="hidden" id="releasedSearchClassifyId">
                                        <div class="menu-wrap">
                                            <div id="releasedSearchClassifyMenuContent" class="menuContent" style="display:none;">
                                                <ul id="releasedSearchClassifyTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                            </div>
                                        </div>
                                    </div>--%>

                                </div>
                            </form>
                        </div>

                        <div class="box-body table-responsive table-myself1">
                            <!-- 表格 -->
                            <table id="releaseTable" class="table table-hover"></table>
                            <!-- 表格 end-->
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
