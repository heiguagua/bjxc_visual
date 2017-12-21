<%--
  Created by IntelliJ IDEA.
  User: GongJun
  Date: 2017/11/6
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=context_path%>/js/feedback/requirement/requirementDetail.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div id="catalogueTableEditLayer">
        <div class="layer-boxs">
            <form class="form-horizontal" id="showForm">
                <div class="form-group">
                    <div class="row">
                        <input type="hidden" id="requirementId" name="requirementId" value="${requirementId}">
                        <div class="col-sm-12">
                            <label for="requireName" class="col-sm-2 control-label" style="width:12.2%">需求资源名称:</label>
                            <div class="col-sm-10"  style="width:87.8%">
                                <input type="text" id="requireName"  class="form-control" readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="providerDeptName" class="col-sm-2 control-label" style="width:12.2%">提供组织:</label>
                            <div class="col-sm-10"  style="width:87.8%">
                                <input type="text" id="providerDeptName"  class="form-control" readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="requirementDeptName" class="col-sm-2 control-label" style="width:12.2%">需求组织:</label>
                            <div class="col-sm-10"  style="width:87.8%">
                                <input type="text" id="requirementDeptName"  class="form-control" readonly>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="demanderName" class="col-sm-2 control-label" style="width:12.2%">需求用户:</label>
                            <div class="col-sm-10"  style="width:87.8%">
                                <input type="text" id="demanderName"  class="form-control" readonly>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="requireType" class="col-sm-2 control-label" style="width:12.2%">需求类型:</label>
                            <div class="col-sm-10"  style="width:87.8%">
                                <input type="text" id="requireType"  class="form-control" readonly>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="otherInfo" class="col-sm-2 control-label" style="width:12.2%">其他:</label>
                            <div class="col-sm-10"  style="width:87.8%">
                                <input type="text" id="otherInfo"  class="form-control" readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="requirementDesc" class="col-sm-2 control-label" style="width:12.2%">需求描述:</label>
                            <div class="col-sm-10"  style="width:87.8%">
                                <textarea id="requirementDesc" cols="30" rows="10"   class="form-control" readonly></textarea>
                            </div>
                        </div>
                    </div>
                </div>

            </form>
        </div>
    </div>
</section><!-- /.content -->

</body>
</html>