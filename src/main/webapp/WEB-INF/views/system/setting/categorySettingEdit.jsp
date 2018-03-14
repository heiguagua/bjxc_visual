<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1 -->
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=context_path%>/js/system/setting/categorySettingEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=context_path%>/system/setting/doCategoryEdit">
                        <input type="hidden" id="categoryCode" value="${categoryCode}" name="categoryCode"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="categoryName">类别名称</label>
                                <input type="text" id="categoryName" name="categoryName" class="form-control"
                                       placeholder="请输入类别名称" data-rule="类别名称:required;">
                            </div>
                            <div class="form-group">
                                <label>类别描述</label>
                                <textarea class="form-control" id="categoryDesc" name="categoryDesc" rows="3"
                                          placeholder="请输入描述，最多128个字符,1个汉字按2个字符计算 ..."
                                          data-rule="系统配置描述:length[0~128, true]"></textarea>
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
