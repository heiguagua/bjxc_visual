<%--
  Created by IntelliJ IDEA.
  User: Zhangm
  Date: 2017/10/9
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/system/dict/dataDictEdit.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
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
                    <form  class="form-inline" role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=context_path%>/sysDict/doEdit">
                        <input id="categoryId" type="hidden" value="${categoryId}" name="categoryCode" />
                        <div class="box-body box-bodyx">
                            <div class="form-group">
                                <label for="categoryCode">类型编码</label>
                                <div class="form-group">
                                <input type="text" id="categoryCode"  class="form-control" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="categoryName">类型名称</label>
                                <div class="form-group">
                                <input type="text" id="categoryName" name="categoryName" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="categoryDesc" >描述</label>

                                <div class="form-group" name="categoryDesc">
                                    <textarea class="form-control" rows="3" name="categoryDesc" id="categoryDesc"
                                              placeholder="请输入数据字典描述"></textarea>
                                </div>
                            </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
                            <%--<button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>--%>
                            <input type="submit" style="display:none;"/>
                        </div>
                    </form>
                </div>
            </div>
        </div><!--/.col (left) -->
    </div>
</section><!-- /.content -->

</body>
</html>

