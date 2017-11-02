<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- 1 -->
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script src="<%=basePath%>/js/system/menu/menuList.js"></script>

</head>
<style type="text/css">
/*强制解决菜单管理里面 当选择条数大于50条 删除框位置不出来问题  */
.layui-layer-dialog {
	top: 340px !important;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	$(document).on("click", ".upload_license", function() {
		var fileName = $("input[name='licenseFile']").val();
		if (fileName == null || fileName == '' || fileName == undefined) {
			errorMsgTip("请先选择license.");
			return;
		}
		var uploadLicenseUrl = "/lic/uploadLic"
		uploadFile(uploadLicenseUrl, "uploadLicense");
	})
	$(document).on("click",".goLogin",function(){
		window.location.href=basePathJS+"/login"
	})
})

function uploadFile(url, inputId) {
	$.ajaxFileUpload({
				fileElementId : inputId, //需要上传的文件域的ID，即<input type="file">的ID。
				url : basePathJS + url, //后台方法的路径
				type : 'post', //当要提交自定义参数时，这个参数要设置成post
				dataType : 'json', //服务器返回的数据类型。可以为xml,script,json,html。如果不填写，jQuery会自动判断。
				secureuri : false, //是否启用安全提交，默认为false。
				async : true, //是否是异步
				success : function(data) { //提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
					if (!data.state) {
						errorMsgTip(data.msg);
						return;
					}
					var successMsg = data.msg;
					successMsg = jQuery.parseJSON(successMsg);
					if (successMsg.isValidity == 0
							|| successMsg.isValidity == '0') {
						errorMsgTip(successMsg.errorMessage);
					} else if (successMsg.isValidity == 1
							|| successMsg.isValidity == '1') {
						tip("license上传成功。");
						$(".periodOfValidity").text(
								successMsg.periodOfValidity);
						$(".sysName").text(successMsg.sysName);
						$(".sysVersion").text(successMsg.sysVersion);
					}
					console.log(successMsg);
				},
				error : function(data, status, e) { //提交失败自动执行的处理函数。
					console.error(e);
				}
			});
}

var lic = ${lic};
if (lic.isValidity == 0 || lic.isValidity == '0') {
	errorMsgTip(lic.errorMessage);
} else {
	$(".periodOfValidity").text(successMsg.periodOfValidity);
	$(".sysName").text(successMsg.sysName);
	$(".sysVersion").text(successMsg.sysVersion);
}
</script>
</script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<%@include file="/WEB-INF/views/common/menu.jsp"%>

		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					<small>系统管理 > License管理</small>
				</h1>
			</section>
			<!-- Main content -->
			<section class="content">
				<div class="continer">
					<div class="row-fluid">
						<div class="col-sm-12">
							<div class="box-body" style="font-size: medium;">
								<div class="row">
									<div class="col-sm-10 form-group">
										<label class="col-sm-2 control-label" style="width: 12.2%">当前系统名称:</label>

										<div class="col-sm-10" style="width: 85.8%">
											<label class="form-control sysName"></label>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-sm-10 form-group">
										<label class="col-sm-2 control-label" style="width: 12.2%">license过期日期:</label>

										<div class="col-sm-10" style="width: 85.8%">
											<label class="form-control periodOfValidity"></label>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-sm-10 form-group">
										<label class="col-sm-2 control-label" style="width: 12.2%">当前系统版本:</label>

										<div class="col-sm-10" style="width: 85.8%">
											<label class="form-control sysVersion"></label>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-sm-10 form-group">
										<c:choose>
											<c:when test="${status=='ok' }">
												<label class="col-sm-2 control-label" style="width: 12.2%">上传lincense:</label>

												<div class="col-sm-6" style="width: 75.8%">
													<input type="file" id="uploadLicense" name="licenseFile"
														class="form-control">

												</div>
												<div class="col-sm-3" style="width: 10.8%">
													<button class="btn btn-myself upload_license">上传</button>
												</div>
											</c:when>
											<c:otherwise>
												<label class="col-sm-2 control-label" style="width: 12.2%">上传lincense:</label>

												<div class="col-sm-6"
													style="width: 65.8%; margin-right: 0px; padding-right: 0px">
													<input type="file" id="uploadLicense" name="licenseFile"
														class="form-control">

												</div>
												<div class="col-sm-3"
													style="width: 5.8%; margin-left: 0px; padding-left: 0px">
													<button class="btn btn-myself upload_license">上传</button>
												</div>
												<div class="col-sm-3" style="width: 5.8%">
													<button class="btn btn-myself goLogin">返回登录</button>
												</div>
											</c:otherwise>
										</c:choose>
									</div>

								</div>
							</div>

						</div>
					</div>

				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<div class="control-sidebar-bg"></div>
	</div>

</body>
</html>
