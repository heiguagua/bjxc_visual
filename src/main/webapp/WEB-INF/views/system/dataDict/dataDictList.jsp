<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/system/dict/dataDictList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>系统管理 > 数据字典管理</small>
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
                                <input id="category" type="hidden" value="${category}" name="category" />
                                <input id="dd" type="hidden"  name="dd" />
                                <div class="input-group">
                                    <a class="btn btn-primary btn-flat btn-myself" id="addDict1" onclick="javascript:addDict()">
                                        <img src="<%=basePath%>/images/userImg/addimg.png"/>
                                        新增
                                    </a>
                                </div>
                                <div class="input-group">
                                    <a class="btn btn-default btn-flat  btn-myself  hidden" id="back" onclick="javascript:intDict()">
                                       < 返回
                                    </a>
                                </div>
                                <div class="input-group">
                                    <a class="btn btn-default btn-flat  btn-myself hidden" id="addDict2"  onclick="javascript:addDetailDict()">
                                        <img src="<%=basePath%>/images/userImg/addimg.png"/>
                                       新增
                                    </a>
                                </div>

                                <div class="input-group  pull-right" id="search">
                                    <input id="searchKeyId" type="text" name="search" class="form-control"
                                           placeholder="类型编码">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue"><i
                                                class="fa fa-search"></i> 查询
                                        </button>
                                    </div>
                                </div>
                                <div class="input-group  pull-right hidden" id="searchDetail" >
                                    <input id="searchKeyId1" type="text" name="search" class="form-control"
                                           placeholder="配置项编码">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId1" type="button" class="btn btn-primary btn-flat btn_blue"><i
                                                class="fa fa-search"></i> 查询
                                        </button>
                                    </div>
                                </div>

                            </div><!-- /.box-header -->
                        </div>

                        <div class="box-body table-responsive no-padding" id="tableList">
                            <table id="systemDataDictTableId" class="table table-hover">

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