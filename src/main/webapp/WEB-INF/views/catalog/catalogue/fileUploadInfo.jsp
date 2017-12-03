<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="/js/catalog/catalogue/fileUploadInfo.js"></script>
</head>

<body>
<section class="content">
    <div class="layer-boxs">
        <div class="form-group">
            <div class="row">
                <div class="col-sm-12">
                    <form id="upload_form" enctype="multipart/form-data" method="post">
                        <input type="hidden" id="id" name="id" value="${id}">
                        <div id="newUploadDiv">
                            <input type="file" name="file">
                            <input type="button" id="upload_btn" value="上传" >
                        </div>
                        <%--<input type="button" id="upload_add_btn" value="增加一行" >--%>

                    </form>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label  class="control-label">已上传文件列表</label>
            <div style="max-height: 300px;overflow: auto">
                <table id="uploadInfoTable" class="table table-hover" ></table>
            </div>
        </div>
    </div>
</section>

</body>
</html>
