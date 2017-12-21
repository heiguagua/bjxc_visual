<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/dir/configure/policy/policyList.js"></script>

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
                <small>配置管理 > 政策发布</small>
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
                                	
                                    <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="标题">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i>查询</button>
                                    </div>
                                </div>
                                
                                <div class="form-group pull-right" style="margin-left: 10px">
                                
			                                 <select id="levelC" name="icon" class="form-control select2" style="width: 100%;" >             
		                                		  <option value ="">--请选择--</option>
		                                		  <option value ="G">国家级</option>
												  <option value ="S">省级</option>
												  <option value="C">市级</option>										  
                                			</select>
			                    </div>
			                    <label class="pull-right" style="margin-top: 8px" for="policy">政策级别 :</label>

                            </div><!-- /.box-header -->
                        </div>

                        <div class="box-body table-responsive ">
                            <table id="policyListId" class="table table-hover">

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
