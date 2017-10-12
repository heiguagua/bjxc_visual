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

    <script src="<%=basePath%>/js/system/deptAuthorityApply/deptAuthorityApplyAdd.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <style>
                .box-body .pdl0{
                    padding-left: 0;
                }
                .box-bodyx label{
                    width: 120px;
                    float: left;
                }
                .box-bodyx .form-group>.form-group{
                    width: 70%;
                    float: left;}
            </style>
            <div class="row">
                <div class="col-md-6">
                    <form  class="form-inline"  role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/deptAuthorityApply/doAdd">
                        <div class="box-body box-bodyx">
                        <div class="form-group">
                            <label for="toDeptNames" style='float:left;'>所属组织机构 *</label>
                            <div class="form-group">
                            <input type="text" id="toDeptNames" required="required"
                                   data-parsley-required-message="该项为必填" class="form-control">
                            <input type="hidden" id="toDeptIds" name="toDeptIds">
                            <div class="menu-wrap">
                                <div id="menuContent" class="menuContent" style="display:none;">
                                    <ul id="treeDemo" class="ztree"
                                        style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                </div>
                            </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>申请理由</label>
                            <div class="form-group">
                            <textarea class="form-control" id="applyReason"  name="applyReason" rows="4"
                                      placeholder="请输入描述，最多300个字符 ..."></textarea>
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

