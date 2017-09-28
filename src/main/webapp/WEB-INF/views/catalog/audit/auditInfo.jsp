<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/catalog/audit/auditInfo.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- general form elements -->
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" id="auditForm" method="post" action="<%=basePath%>/catalog/audit/doAudit">
                        <input type="hidden" id="id" name="id" value="${id}"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label class="control-label">审核意见：</label>
                                <div class="m-l-n-xxl">
                                    <label class="checkbox-inline i-checks"> <input
                                            type="radio" value="3" name="status" checked><i></i>通过
                                    </label>
                                    <label class="checkbox-inline i-checks "> <input
                                        type="radio" value="2" name="status" class=""><i></i>不通过
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <div class=" bg-light wrapper-xs">意见说明</div>
                                </div>
                                <textarea class="form-control" id="opinion" name="opinion" cols="30" rows="10"></textarea>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <input type="submit" style="display:none;"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
