<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/dir/configure/specialapp/specialappEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=basePath%>/dirSpecialApps/doEdit">
                        <input id="appId" type="hidden" value="${id}" name="Id" />
                        <div class="box-body">
                           <div class="form-group">
                                <label for="appName">应用名称</label>
                                <input type="text" id="Eapp_name" name="appName" class="form-control"
                                       placeholder="请输入应用名称" data-rule="应用名称:required;appName;remote(<%=basePath%>/system/user/insertCheckName)">
                            </div>
                            <div class="form-group">
                                <label for="appCategory">应用种类</label>
                                <input type="text" id="Eapp_category" name="appCategory" class="form-control"
                                       placeholder="请输入应用种类" data-rule="应用种类:required;appCategory;">
                            </div>
                            <div class="form-group">
                                <label for="appUrl">url地址</label>
                                <input type="text" id="Eapp_url" name="appUrl" class="form-control"
                                       placeholder="请输入url地址" data-rule="url地址:required;appUrl; ">
                            </div>
                            <div class="form-group">
                                <label for="orderNumber">排序号</label>
                                <input type="text" id="Eorder_number" name="orderNumber" class="form-control"
                                       placeholder="请输入排序号" data-rule="排序号:required;orderNumber;">
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
