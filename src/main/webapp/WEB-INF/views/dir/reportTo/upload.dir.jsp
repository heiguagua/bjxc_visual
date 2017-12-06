<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript">
$(function(){
	$("*[name='dataUpload']:eq(1)").click(function(){
		var check=$(this).is(":checked");
		if (check){
			$("*[name='dataUpload']:eq(0)").prop("checked",true);
		}else{
			$("*[name='dataUpload']:eq(0)").prop("checked",false)
		}
	});
})

</script>
<style type="text/css">
.required {
	color: red;
}
input[name='head']{
position: absolute;
width: 8%;

}
input[name='uploadAddress']{
margin-left: 8%;
width: 80%;
}
.control-label {
    text-align: left !important;
}
.col-sm-10{
margin-left: 23% !important;
margin-top: -11%
}
</style>
</head>
<body>
	<section class="content">
		<div id="catalogueTableEditLayer">
			<div class="layer-boxs">
				<form class="form-horizontal" id="addForm" action="<%=basePath %>/dirupload/upload">
					<div class="form-group">
						<input name="scmIdArr" value="${scmIdArr}" class="hide"> <label
							for="input" class="col-sm-2 control-label">上报内容 <span
							class="required">*</span></label>
						<div class="col-sm-10">

							<label><input class="" type="checkbox" name="dataUpload"
								value="1">资源目录</label> <label><input class=""
								type="checkbox" name="dataUpload" value="2">数据服务</label>
						</div>

					</div>
<!-- 					<div class="form-group">
						<label for="input"  class="col-sm-2 control-label">上级接口地址<span
							class="required">*</span></label>
						<div class="col-sm-10">
							<input class="form-control" name="head" disabled="disabled" value="http://"><input data-rule="required" class="form-control" name="uploadAddress" type="text"
								value="">
						</div>
					</div> -->
				</form>
			</div>
		</div>
	</section>
	<!-- /.content -->
</body>
</html>