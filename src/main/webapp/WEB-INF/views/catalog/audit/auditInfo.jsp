<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/catalog/audit/auditInfo.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- general form elements -->
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" id="auditForm" method="post" action="<%=context_path%>/catalog/audit/doAudit">
                        <input type="hidden" id="id" name="id" value="${id}"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label class="control-label control-Reslabel">审核意见：</label>
                                <div class="m-l-n-xxl">
                                
                                <div class="redio-box">
                                    <input type="radio" name="status" checked value="3"><span></span>
                                </div>
                                <label style="display: inline-block;" >通过</label>
                                <div class="redio-box">
                                    <input type="radio" name="status"  value="2"><span></span>
                                </div>
                                <label style="display: inline-block;">不通过</label> 
                                <!--  <label class="checkbox-inline i-checks"> <input
                                            type="radio" value="3" name="status" checked><i></i>通过
                                    </label>
                                    <label class="checkbox-inline i-checks "> <input
                                        type="radio" value="2" name="status" class=""><i></i>不通过
                                    </label>  -->
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
