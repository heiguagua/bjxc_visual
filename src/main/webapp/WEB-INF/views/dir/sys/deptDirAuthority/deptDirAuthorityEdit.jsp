<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/dir/sys/deptDirAuthority/deptDirAuthorityEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content" style="padding-top:0">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=basePath%>/system/deptDirAuthority/doEdit">
                        <input id="authObjId" type="hidden" value="${id}" name="authObjId" />
                        <div class="box-body">
                            <div class="form-group">
                                <ul id="treeDemo" class="ztree" style="margin-top:0;"></ul>
                                <input type="hidden" id="deptIds" name="deptIds">
                                <input type="hidden" id="classifyIds" name="classifyIds">
                            </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
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
