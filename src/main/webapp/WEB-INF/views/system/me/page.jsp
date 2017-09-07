<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <link rel="stylesheet" href="<%=basePath%>/plugins/bootstrap-fileinput/css/fileinput.min.css">
    <script src="<%=basePath%>/js/system/me/changePassword.js"></script>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>系统管理 > 用户中心</small>
            </h1>
        </section>
        <!-- Main content -->
        <section class="content">
            <!-- Your Page Content Here -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li id="userSettingLiId" class="active"><a href="#tab_1" data-toggle="tab">用户设置</a></li>
                            <li id="modifyPasswordLiId"><a href="#" onclick = "changePassword()">修改密码</a></li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <div class="row">
                                    <div class="col-md-6">
                                        <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=basePath%>/system/me/uploadImage" enctype="multipart/form-data">
                                            <div class="box-body">
                                                <div class="form-group">
                                                    <label for="userName">用户名</label>
                                                    <input id="userName" type="text" name="userName" value="${(sysUser.userName)}" class="form-control" readonly="readonly">
                                                </div>
                                                <div class="form-group">
                                                    <label for="systemLogo">头像</label>
                                                    <input name="systemLogo" type="file" class="file-loading" id="systemLogo">
                                                </div>
                                            </div><!-- /.box-body -->
                                            <div class="box-footer">
                                                <button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-pane -->
                    </div><!-- /.tab-content -->
                </div>
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->

    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <div class="control-sidebar-bg"></div>
</div>

<script src="<%=basePath%>/plugins/bootstrap-fileinput/js/fileinput.min.js"></script>
<script src="<%=basePath%>/plugins/bootstrap-fileinput/js/locales/zh.js"></script>
<script>
    //初始化fileinput控件（第一次初始化）
    function initFileInput(ctrlName, uploadUrl) {
        var control = $('#' + ctrlName);

        control.fileinput({

            initialPreview: [
                basePathJS + '${(sysUser.userImg)}'
            ],
            initialPreviewAsData: true,
            initialPreviewConfig: [
                {caption: basePathJS + "${(sysUser.userImg)}", size: 930321, width: "120px", key: '${(sysUser.id)}', showDelete: false}
            ],
            deleteUrl: basePathJS + "/file/delete",

            language: 'zh', //设置语言
            uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions : ['jpg', 'png','gif'],//接收的文件后缀
            showUpload: false, //是否显示上传按钮
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary"
        });
    }

    initFileInput("systemLogo", basePathJS + "/file/upload");

</script>
<!--
<script src="/js/page.js"></script>
-->
</body>
</html>


