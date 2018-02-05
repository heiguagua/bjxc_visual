<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1 -->
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/system/region/regionList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>系统管理 > 区域管理</small>
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
                                <div class="input-group">
                                    <a class="btn btn-primary btn-flat btn-myself" onclick="javascript:addRegion()" id="createRegionA">
                                        <img src="<%=context_path%>/images/userImg/addimg.png"/>
                                        新建区域
                                    </a>
                                </div>
                                <div class="input-group">
                                    <a class="btn btn-primary btn-flat btn-myself"  onclick="javascript:deleteBatchRegion()" >
                                        <img src="<%=context_path%>/images/userImg/delImg.png"/>
                                        批量删除</a>
                                </div>
                                <div class="input-group">
                                    <a class="btn btn-default btn-flat  btn-myself  hidden" id="back" onclick="javascript:backPreRegionList()">
                                        < 返回
                                    </a>
                                </div>
                                <div class="input-group  pull-right">
                                    <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="区域">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i> 查询</button>
                                    </div>
                                </div>

                            </div><!-- /.box-header -->
                        </div>

                        <div class="box-body table-responsive" id="tableList">
                            <table id="systemRegionTableId" class="table table-hover">

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
