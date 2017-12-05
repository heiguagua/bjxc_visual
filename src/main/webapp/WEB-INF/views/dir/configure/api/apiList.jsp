<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/dir/configure/api/apiList.js"></script>
    <%-- <script src="<%=context_path%>/plugins/jquery.ztree.exedit.js"></script> --%>
    <script src="<%=context_path%>/plugins/jquery.ztree.all.js"></script>
    <%-- <script src="<%=context_path%>/plugins/jquery.ztree.core.js"></script> --%>
	<link rel="stylesheet" href="<%=context_path%>/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>

<style type="text/css">
.layui-layer-dialog{
	top:180px !important;
}
.ztree li ul {
    margin: 0;
    padding: 0 0 5 18px !important;
}
</style>


<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>配置管理 > 开发者工具管理</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <%-- <div class="form-inline">
                            <div class="box-header">
                                <#if permissions?seq_contains('addDept')>
                                <div class="input-group">
                                    <a class="btn btn-primary  btn-flat" onclick="javascript:addUser()" > <i class="fa fa-plus"></i> 创建用户</a>
                                </div>
                                </#if>
                                <div class="input-group">
                                    <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="用户名称">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat" ><i class="fa fa-search"></i> 查询</button>
                                    </div>
                                </div>

                            </div><!-- /.box-header -->
                        </div> --%>
						<div>		                    
					          <div class="navi-wrap">
					                 <div class="" style="min-height: 300px;">				
					                       <div class="padder-v">
					                           <%@include file="/WEB-INF/views/common/ztree.jsp" %>
					                      </div>
					                 </div>
					           </div>
					     </div>
                        <!-- <div class="box-body table-responsive">
                            <table id="systemUserTableId" class="table table-hover">

                            </table>
                        </div>/.box-body -->

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
