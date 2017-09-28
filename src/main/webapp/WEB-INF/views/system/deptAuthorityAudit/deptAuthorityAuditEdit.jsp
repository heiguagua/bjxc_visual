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

    <script src="<%=basePath%>/js/system/deptAuthorityAudit/deptAuthorityAuditEdit.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/deptAuthorityAudit/doEdit">
                        <input type="hidden" id="authAuditId" name="id" value="${id}"/>
                        <div class="box-body">
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <div class=" bg-light wrapper-xs">申请人:</div>
                                </div>
                                <input type="text"  name="applicantName" id="applicantName" />
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <div class=" bg-light wrapper-xs">申请权限对应部门:</div>
                                </div>
                                <input type="text"  name="deptName" id="deptName" />
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <div class=" bg-light wrapper-xs">申请理由:</div>
                                </div>
                                <input type="text"  name="applyReason" id="applyReason" />
                            </div>
                            <div class="form-group">
                                <label class="control-label control-Reslabel">审核意见：</label>
                                <div class="m-l-n-xxl">
                                    <label class="checkbox-inline i-checks"> <input
                                            type="radio" value="1" name="auditStatus" checked><i></i>通过
                                    </label>
                                    <label class="checkbox-inline i-checks "> <input
                                            type="radio" value="2" name="auditStatus" class=""><i></i>不通过
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <div class=" bg-light wrapper-xs">意见说明</div>
                                </div>
                                <textarea class="form-control" id="auditOpinion" name="auditOpinion" cols="30" rows="10"></textarea>
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

