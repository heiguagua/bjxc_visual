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
                	<li class="active" id="unReleaseTab"><i class="fa fa-desktop" style="font-size:20px"></i>&nbsp;待发布</li>
                	<li id="releasedTab"><i class="fa fa-crop" aria-hidden="true"></i>&nbsp;已发布</li>
                	
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
                        <form class="form-inline" method="post" id=unReleaseSearchDiv>
                            <div class="box-header">
                                <div class="input-group">
                                    <a class="btn btn-primary btn-flat btn-myself" id="auditRejectButton">
                                        <!-- <i class="fa fa-plus">
                                        </i> -->
                                      审核驳回
                                    </a>
                                </div>
                                  <div class="input-group">
                                        <button class="btn btn-default btn-flat  btn-myself dropdown-toggle" data-toggle="dropdown" aria-expanded="true" id="releaseButton">
                                            <!-- <i class="fa fa-plus-circle"></i> -->&emsp;发布&emsp;<span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" role="menu" style="left:-21px;text-align:center;">
                                            <li><a id="releaseAll" href="#">同时发布</a></li>
                                            <li><a id="releaseToInternet" href="#">发布到互联网</a></li>
                                            <li><a id="releaseToDzzw" href="#">发布到电子政务外网</a></li>
                                        </ul>
                                    </div>    
                                <div class="input-group pull-right">
                                    <input class="form-control" id="unReleaseSearchName" placeholder="资源名称" type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat btn_blue" id="unReleaseQueryBtn" type="button">
                                            <i class="fa fa-search">
                                            </i> 查询
                                        </button>
                                    </div>
                                    </input>
                                </div>
                                <div class="input-group pull-right" style="margin-right:4px;width: 240px">
                                    <input type="text" id="unReleaseSearchClassifyName" placeholder="请选择目录类别" class="form-control" readonly style="background-color: #FFFFFF">
                                    <input type="hidden" id="unReleaseSearchClassifyId">
                                    <div class="menu-wrap">
                                        <div id="unReleaseSearchClassifyMenuContent" class="menuContent" style="display:none;">
                                            <ul id="unReleaseSearchClassifyTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                        </div>
                                    </div>
                                </div>
                              
                            </div>
                        </form>
                        <!-- 复制二级标题 已经发布 -->
                        <form class="form-inline" method="post"  style="display:none" id="releasedSearchDiv">
                            <div class="box-header">
                       
                                  <div class="input-group">
                                        <a class="btn btn-default btn-flat  btn-myself" id="offlineButton">
                                            <!-- <i class="fa fa-plus-circle"></i> -->下架
                                        </a>
                                    </div>    
                                <div class="input-group pull-right">
                                    <input class="form-control" id="releasedSearchName" placeholder="资源名称" type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat btn_blue" id="releasedQueryBtn" type="button">
                                            <i class="fa fa-search">
                                            </i> 查询
                                        </button>
                                    </div>
                                    </input>
                                </div>
                                <div class="input-group pull-right" style="margin-right:4px;width: 240px">
                                    <input type="text" id="releasedSearchClassifyName" placeholder="请选择目录类别" class="form-control" readonly style="background-color: #FFFFFF">
                                    <input type="hidden" id="releasedSearchClassifyId">
                                    <div class="menu-wrap">
                                        <div id="releasedSearchClassifyMenuContent" class="menuContent" style="display:none;">
                                            <ul id="releasedSearchClassifyTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                        </div>
                                    </div>
                                </div>
                              
                            </div>
                        </form>
                        <div class="box-body table-responsive no-padding">
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
