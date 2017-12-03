<%--
  Created by IntelliJ IDEA.
  User: Zhangm
  Date: 2017/9/28
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="/js/system/deptAuthorityAudit/deptAuthorityAuditEdit.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form class="form-horizontal" role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="/system/deptAuthorityAudit/doEdit">
                        <input type="hidden" id="authAuditId" name="id" value="${id}"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="applicantName" class="col-sm-3">申请人： <span id="applicantName"></span></label>
                                <%--<label for="applicantName" class="col-sm-3">申请人：</label>--%>
                                <%--<div class="col-sm-9">--%>
                                    <%--<input type="text" class="form-control"  name="applicantName" id="applicantName" />--%>
                                <%--</div>--%>
                            </div>
                            <div class="form-group">
                                <label for="deptName" class="col-sm-3">申请权限对应部门： <span id="deptName"></span></label>
                                <%--<label for="deptName" class="col-sm-3">申请权限对应部门：</label>--%>
                                <%--<div class="col-sm-9">--%>
                                    <%--<input type="text" class="form-control" name="deptName" id="deptName" />--%>
                                <%--</div>--%>
                            </div>
                            <div class="form-group">
                                <label for="applyReason" class="col-sm-3">申请理由： <span id="applyReason"></span></label>
                                <%--<label for="applyReason" class="col-sm-3 ">申请理由：</label>--%>
                                <%--<div class="col-sm-9">--%>
                                    <%--<input type="text" class="form-control"  name="applyReason" id="applyReason" />--%>
                                <%--</div>--%>
                            </div>
                            <div class="form-group">
                                <%--<label for="sourceSelect" class="col-sm-3">审核意见: </label>--%>
                                <div class="col-sm-7">
                                    <label>审核意见: </label>
                                    <span class="radio-inlinex">
				                           <input  type="radio" value="1" name="auditStatus" checked><i></i>通过
				                        </span>
                                    <span class="radio-inlinex">
				                         <input type="radio" value="2" name="auditStatus" class=""><i></i>不通过
				                        </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="auditOpinion" class="col-sm-3">意见说明:</label>
                                <div class="col-sm-9">
                                    <textarea class="form-control" id="auditOpinion" name="auditOpinion" cols="10" rows="3"></textarea>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="submit" style="display:none;"/>
                        </div>
                    </form>
                </div>
            </div>
        </div><!--/.col (left) -->
    </div>
</section><!-- /.content -->
</body>
</html>

