<%--
  Created by IntelliJ IDEA.
  User: Zhangm
  Date: 2017/9/28
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/system/deptAuthorityAudit/deptAuthorityAuditList.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>系统管理 > 组织机构数据权限审核管理</small>
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
                                <div class="input-group" style="float:right;margin-right:4px;width:240px">
                                    <input id="searchKeyId" type="text" name="search" class="form-control" placeholder="组织机构数据权限审核名称" style="width: 200px">
                                    <div class="input-group-btn">
                                        <button id="queryBtnId" type="button" class="btn btn-primary btn-flat btn_blue" ><i class="fa fa-search"></i> 查询</button>
                                    </div>
                                </div>
                               <div class="input-group"  style="float:right">
                                    <%--<a class="btn btn-primary  btn-flat" onclick="javascript:authorityAudit()" > <i class="fa fa-plus"></i>审核部门数据权限</a>--%>
                                        <select  class="form-control"  name="audited" id="audited">
                                            <option value="0">待审核</option>
                                            <option value="1">已审核</option>
                                        </select>
                                </div>


                            </div><!-- /.box-header -->
                        </div>

                        <div class="box-body table-responsive">
                            <table id="deptAuthorityAuditTableId" class="table table-hover">

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
