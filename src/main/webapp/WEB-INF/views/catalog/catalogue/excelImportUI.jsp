<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
	<script src="<%=context_path%>/js/custom/ajaxfileupload.js"></script>
	<script src="<%=context_path%>/js/catalog/catalogue/excelImportUI.js"></script>
	<style>
		.pull-left{
			margin-right: 20px;
		}
	</style>
</head>

<section class="content">
    <%--<div id="catalogueTableEditLayer">--%>
        <%--<div class="layer-boxs">--%>
		<input type="hidden" id="classifyId" value="${classifyId}">
		<div>
			<%--<form class="form-horizontal pull-left" action="" method="POST" enctype="multipart/form-data">--%>
				<%--<a href="javascript:;" class="btn a-upload">--%>
					<%--<input type="file" name="excelFile" id="excelFile">--%>
					<%--导入含有目录分类的excel文件--%>
				<%--</a>--%>
			<%--</form>--%>
			<form class="form-horizontal pull-left" action="" method="POST" enctype="multipart/form-data">
				<a href="javascript:;" class="btn a-upload">
					<input type="file" name="excelWithOutDir" id="excelWithOutDir">
					导入没有目录分类的excel文件
				</a>
			</form>
			<label style="padding-top: 10px"><span style="color: red; font-size: 10px">（标题如有版本号，请严格参照模式:V1-1）</span></label>
			
		</div>


            <%--<form action="<%=context_path%>/catalog/excelImport" method="post" enctype="multipart/form-data" style="text-align:center">--%>
           	<%--<a href="javascript:;" class="&lt;%&ndash;a-upload&ndash;%&gt;">--%>
			    <%--<input type="file" name="file" id="">--%>
			<%--</a>--%>
			<%--<input type="hidden" id="regionCodeId" name="regionCode">--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
</section>

</body>

<%--<script>--%>
    <%--$(function(){--%>
        <%--$('#regionCodeId').val($.getSelectedRegionCode());--%>
    <%--})--%>

<%--</script>--%>
</html>
