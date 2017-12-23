<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/dir/configure/specialapp/specialappList.js"></script>

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
                <small>配置管理 > 专题应用管理</small>
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
                                <%--<#if permissions?seq_contains('addDept')>--%>
                                <div class="input-group">
                                    <a class="btn btn-primary  btn-flat btn-myself" onclick="javascript:addUser()" > 
                                    
                                    <!-- <i class="fa fa-plus"></i> -->
                                    <img src="<%=context_path%>/images/userImg/addimg.png"/>
                                    	 新增</a>
                                </div>
                                
                                <%--</#if>--%>
                                <div class="input-group pull-right" style="margin-left: 20px">
                                    <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="请输入标题">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i> 查询</button>
                                    </div>
                                </div>
                                <div class="form-group pull-right">
		                                <label for="appCategory">应用种类 :</label>
		                                <input type="text" id="appCategoryl" data-rule="应用分类:required;" class="form-control"
				                         placeholder="">
				                        <input type="hidden" id="dictCodel" name="appCategory">
				                        <div class="menu-wrap">
				                            <div id="menuContentl" class="menuContent" style="display:none;">
				                                <ul id="treeDemol" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
				                            </div>
				                        </div>
                            	</div>
                                

                            </div><!-- /.box-header -->
                        </div>
						
                        <div class="box-body table-responsive">
                            <table id="dirSpecialAppsTableId" class="table table-hover">

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
