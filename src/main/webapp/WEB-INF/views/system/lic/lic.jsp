<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- 1 -->
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script src="<%=basePath%>/js/system/menu/menuList.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/plugins/uploadFile/ajaxfileupload.js"></script>
</head>
<style type="text/css">
/*强制解决菜单管理里面 当选择条数大于50条 删除框位置不出来问题  */
.layui-layer-dialog {
	top: 340px !important;
}
.n-success {
    color: #00a65a;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	//初始化
	var isValidity="${lic.isValidity}";

	 if (isValidity == 0 || isValidity == '0') {
			var errMessage = "${lic.errorMessage}";
			$("#uploadLicense").parent().find(".msg-box").removeClass("hide");
			$("#uploadLicense").parent().find(".msg-box").find(".n-msg").text(errMessage);
			$(".form-group").addClass("has-error")
		}
		$(document).on("click", ".upload_license", function() {
			var fileName = $("input[name='licenseFile']").val();
			if (fileName == null || fileName == '' || fileName == undefined) {
				errorMsgTip("请先选择license.");
				return;
			}
			var uploadLicenseUrl = "/lic/uploadLic"
			uploadFile(uploadLicenseUrl, "uploadLicense");
		})
		$(document).on("click", ".goLogin", function() {
			window.location.href = basePathJS + "/login"
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
							$("#uploadLicense").parent().find(".msg-box").removeClass("hide");
							$("#uploadLicense").parent().find(".msg-box").find(".n-msg").text(data.msg);
							$("#uploadLicense").parent().find(".msg-box").find(".n-msg").removeClass("n-success")
							$("#uploadLicense").parent().find(".msg-box").find(".n-msg").addClass("n-error")
							$(".form-group").addClass("has-error")
							return;
						}
						var successMsg = data.msg;
						successMsg = jQuery.parseJSON(successMsg);
						if (successMsg.isValidity == 0
								|| successMsg.isValidity == '0') {
							$("#uploadLicense").parent().find(".msg-box").removeClass("hide");
							$("#uploadLicense").parent().find(".msg-box").find(".n-msg").text(successMsg.errorMessage);
							$("#uploadLicense").parent().find(".msg-box").find(".n-msg").removeClass("n-success")
							$("#uploadLicense").parent().find(".msg-box").find(".n-msg").addClass("n-error")
							$(".form-group").addClass("has-error")
						} else if (successMsg.isValidity == 1
								|| successMsg.isValidity == '1') {
							$("#uploadLicense").parent().find(".msg-box").removeClass("hide");
							$("#uploadLicense").parent().find(".msg-box").find(".n-msg").text("license上传成功。");
							$("#uploadLicense").parent().find(".msg-box").find(".n-msg").removeClass("n-error")
							$("#uploadLicense").parent().find(".msg-box").find(".n-msg").addClass("n-success")
							$(".form-group").removeClass("has-error")
							$(".form-group").addClass("has-success")
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
											<label class="form-control sysName">${lic.sysName}</label>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-sm-10 form-group">
										<label class="col-sm-2 control-label" style="width: 12.2%">license过期日期:</label>

										<div class="col-sm-10" style="width: 85.8%">
											<label class="form-control periodOfValidity">${lic.periodOfValidity}</label>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-sm-10 form-group">
										<label class="col-sm-2 control-label" style="width: 12.2%">当前系统版本:</label>

										<div class="col-sm-10" style="width: 85.8%">
											<label class="form-control sysVersion">${lic.sysVersion}</label>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-sm-10 form-group">
										<label class="col-sm-2 control-label" style="width: 12.2%">上传lincense:</label>

										<div class="col-sm-6" style="width: 75.8%">
											<input type="file" id="uploadLicense" name="licenseFile"
												class="form-control"> <span
												class="msg-box n-bottom hide" for=""><span
												role="alert" class="msg-wrap n-error"><span
													class="n-icon"></span><span class="n-msg"></span></span></span>
										</div>
										<div class="col-sm-3" style="width: 10.8%">
											<button class="btn btn-myself upload_license">上传</button>
										</div>
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
