<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="/js/catalog/catalogue/catalogueList.js"></script>
</head>
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
                        <div class="box">
                            <form class="form-inline" method="post">
                                <div class="box-header">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-flat dropdown-toggle btn-myself"
                                                data-toggle="dropdown"><img src="/images/userImg/addimg.png"/>
                                           <!--  <i class="fa fa-plus"></i> -->快速添加&nbsp;
                                           <img src="/images/userImg/Seciton_img@2x.png"/>
                                           <!-- <span class="caret"></span> -->
                                        </button>
                                        <ul class="dropdown-menu" role="menu">
                                            <li>
                                                <button type="button" style="width: 100%;" onclick="quickSystemAddDatasetUI()" class="btn btn-primary btn-flat btn_blue">从系统梳理添加</button>
                                            </li>
                                            <li>
                                                <button type="button" style="width: 100%;" onclick="quickAddDatasetUI()" class="btn btn-primary btn-flat btn_blue">从资源梳理添加</button>
                                            </li>
                                            <li>
                                                <button type="button" style="width: 100%;" onclick="quickCsAddDatasetUI()" class="btn btn-primary btn-flat btn_blue">从爬虫系统添加</button>
                                            </li>
                                            <li>
                                                <button type="button" style="width: 100%;" onclick="quickDcmAddDatasetUI()" class="btn btn-primary btn-flat btn_blue">从关系型采集系统添加</button>
                                            </li>
                                            <li>
                                                <button type="button" style="width: 100%;" onclick="quickNosqlDcmAddDatasetUI()" class="btn btn-primary btn-flat btn_blue">从非关系型采集系统添加</button>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="input-group">
                                        <a class="btn btn-default btn-flat  btn-myself" onclick="javascript:addCustom()">
                                        <img src="/images/userImg/addimg.png"/>
                                            <!-- <i class="fa fa-plus-circle"></i> -->自定义添加
                                        </a>
                                    </div>
                                    <div class="input-group">
                                        <button type="button" class="btn btn-primary btn-flat dropdown-toggle  btn-myself"
                                                data-toggle="dropdown" onclick="javascript:excelImportUI()">
                                                <img src="/images/userImg/importimg.png"/>
                                            <!-- <i class="fa fa-plus"></i> -->导入
                                        </button>
                                    </div>
                                    <div class="input-group">
                                        <button type="button" class="btn btn-primary btn-flat dropdown-toggle btn-myself"
                                                data-toggle="dropdown" id="catalogueDeleteButton">
                                                <img src="/images/userImg/delImg.png"/>
                                            <!-- <i class="fa fa-plus"></i> -->批量删除
                                        </button>
                                    </div>
                                    <div class="input-group" style="float:right">
                                        <input class="form-control" id="searchName" placeholder="资源名称" type="text">
                                        <div class="input-group-btn">
                                            <button class="btn btn-primary btn-flat btn_blue" id="queryBtn" type="button">
                                                <i class="fa fa-search"></i> 查询
                                            </button>
                                        </div>
                                        </input>
                                    </div>
                                    <div class="input-group" style="float:right;margin-right:4px;width:240px">
                                        <input type="text" id="searchClassifyName" placeholder="请选择目录类别" class="form-control" readonly style="background-color: #FFFFFF">
                                        <input type="hidden" id="searchClassifyId">
                                        <div class="menu-wrap">
                                            <div id="searchClassifyMenuContent" class="menuContent" style="display:none;">
                                                <ul id="searchClassifyTreeDemo" c
                                                lass="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </form>
                            <div class="box-body table-responsive no-padding">
                                <!-- 表格 -->
                                <table class="layui-table" id="catalogueTable" lay-even="" lay-skin="row"></table>
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
