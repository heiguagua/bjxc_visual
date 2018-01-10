<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/catalog/catalogue/catalogueList.js"></script>
    <script src="<%=context_path%>/js/system/Encode/Encode.js"></script>
</head>
 <style>
 div.layui-layer-iframe{
	min-width:1000px;
	width:e-xpression(document.body.clientWidth < 1000? “1000px”: “auto” );
}
</style>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <%@include file="/WEB-INF/views/common/header.jsp" %>
        <%@include file="/WEB-INF/views/common/menu.jsp" %>

        <div class="content-wrapper">
            <section class="content-header">
                <h1>
                    <small>目录管理 > 目录编目</small>
                </h1>
              <!-- <ul class="title_ul">
                	<li class="active"><i class="fa fa-television" style="font-size:20px"></i>&nbsp;常规模式</li>
                	<li><i class="fa fa-crop" aria-hidden="true"></i>&nbsp;引导模式</li>
                	<li>图谱</li>
                </ul>  --> 
            </section>
            <!-- Main content -->
            <section class="content">
                <!-- Your Page Content Here -->
                <div class="row">
                    <div class="col-xs-12">
                        <div class="box clear">

                            <aside class="main-sidebar—Du sidebar-myself" style="height:816px" id="min-aside">
                                <section class="sidebar">
                                    <div class="user-panel"  style="height: 6%;">
                                        <b id="dir-Manger">目录分类</b>
                                        <div class="pull-right image">
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
                          
                          	 <form class="form-inline" method="post"   onsubmit="return false;">
                                <div class="box-header box-header-myself">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-flat dropdown-toggle btn-myself"
                                                data-toggle="dropdown"><img src="<%=context_path%>/images/userImg/addimg.png"/>
                                           <!--  <i class="fa fa-plus"></i> -->快速添加&nbsp;
                                           <img src="<%=context_path%>/images/userImg/Seciton_img@2x.png"/>
                                           <!-- <span class="caret"></span> -->
                                        </button>
                                         <ul class="dropdown-menu" role="menu" style="left:-21px;text-align:center;">
                                                    <li><a  style="width: 100%;" onclick="quickSystemAddDatasetUI()" href="###">从梳理系统(系统)</a></li>
                                                    <li><a  style="width: 100%;" onclick="quickAddDatasetUI()" href="###">从梳理系统(资源)</a></li>
                                                    <li><a  style="width: 100%;" onclick="quickCsAddDatasetUI()" href="###">从采集系统(爬虫)</a></li>
                                                    <li><a  style="width: 100%;" onclick="quickDcmAddDatasetUI()" href="###">从采集系统(关系型)</a></li>
                                                    <li><a  style="width: 100%;" onclick="quickNosqlDcmAddDatasetUI()" href="###">从采集系统(非关系型)</a></li>
                                                    <li><a  style="width: 100%;"  href="###">从处理系统</a></li>   
                                                </ul>
                                    
                                    </div>
                                    <div class="input-group">
                                        <a class="btn btn-default btn-flat  btn-myself" onclick="javascript:addCustom()">
                                        <img src="<%=context_path%>/images/userImg/addimg.png"/>
                                            <!-- <i class="fa fa-plus-circle"></i> -->自定义添加
                                        </a>
                                    </div>
                                    <div class="input-group">
                                        <%--<a class="btn btn-primary btn-flat dropdown-toggle  btn-myself" href="/catalog/download" >模板下载</a>--%>
                                       <button type="button" class="btn btn-primary btn-flat dropdown-toggle  btn-myself"
                                                data-toggle="dropdown" onclick="javascript:excelDownloadUI()">
                                            <%--<img src="<%=context_path%>/images/userImg/importimg.png"/>--%>
                                            <!-- <i class="fa fa-plus"></i> -->模板下载
                                        </button>
                                    </div>
                                    <div class="input-group">
                                        <button type="button" class="btn btn-primary btn-flat dropdown-toggle  btn-myself"
                                                data-toggle="dropdown" onclick="javascript:excelImportUI()">
                                                <img src="<%=context_path%>/images/userImg/importimg.png"/>
                                            <!-- <i class="fa fa-plus"></i> -->导入
                                        </button>
                                    </div>
                                    <div class="input-group">
                                        <button type="button" class="btn btn-primary btn-flat dropdown-toggle btn-myself"
                                                data-toggle="dropdown" id="catalogueDeleteButton">
                                                <img src="<%=context_path%>/images/userImg/delImg.png"/>
                                            <!-- <i class="fa fa-plus"></i> -->删除
                                        </button>
                                    </div>
                                    <div class="pull-right">
                                        <input type="hidden" id="searchClassifyId">
                                        <input type="hidden" id="classifyType">
	                                    <div class="input-group">
	                                        <input class="form-control"  id="searchName" placeholder="资源名称" type="text">
	                                        <div class="input-group-btn">
	                                            <button class="btn btn-primary btn-flat btn_blue" id="queryBtn" type="button">
	                                                <i class="fa fa-search"></i> 查询
	                                            </button>
	                                        </div>
	                                        </input>
	                                    </div>
                                    </div>
                                </div>
                            </form>
                           <!-- 00000 -->
                            <div class="box-body table-responsive table-myself">
                                <!-- 表格 -->
                                <table id="catalogueTable" class="table table-hover"></table>
                                <!-- 表格 end-->
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
