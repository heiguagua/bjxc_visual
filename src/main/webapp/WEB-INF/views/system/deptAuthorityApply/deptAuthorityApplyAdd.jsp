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
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/deptAuthorityApply/doAdd">
                        <div class="form-group">
                            <label for="deptName" style='float:left;'>所属组织机构 *</label>
                            <%--<input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">--%>
                            <input type="text" id="deptName" required="required"
                                   data-parsley-required-message="该项为必填" class="form-control">
                            <input type="hidden" id="deptId" name="toDeptIds">
                            <div class="menu-wrap">
                                <div id="menuContent" class="menuContent" style="display:none;">
                                    <ul id="treeDemo" class="ztree"
                                        style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>申请理由</label>
                            <textarea class="form-control" id="applyReason"  name="applyReason" rows="4"
                                      placeholder="请输入描述，最多300个字符 ..."></textarea>
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

