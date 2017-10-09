<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
</head>
<section class="content">
    <div id="catalogueTableEditLayer">
        <div class="layer-boxs">
            <form action="<%=basePath%>/catalog/excelImport" method="post" enctype="multipart/form-data">
                <input type="file" name="file" />
            </form>
        </div>
    </div>
</section>

</body>
</html>
