<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript"
	src="/plugins/uploadFile/ajaxfileupload.js"></script>
<style type="text/css">
.n-success {
	color: #00a65a;
}

.content {
	width: 80%;
}

.part1 {
	margin-bottom: 20px;
	border: 1px solid #d2d6de;
	font-size: 28px;
	text-align: center;
	line-height: 2.5;
	box-shadow: 1px 2px 2px #d2d6de;
}

.part2 {
	border: 1px solid #d2d6de;
	box-shadow: 1px 2px 2px #d2d6de;
}

.part2-header {
	margin: 10px;
	line-height: 2.0;
	font-size: 18px;
	text-align: center;
}

.part3 {
	border: 1px solid #d2d6de;
	margin-top: 20px;
	box-shadow: 1px 2px 2px #d2d6de;
}
</style>
<title>licen管理</title>
<script type="text/javascript">
	$(document).ready(
			function() {

				var isValidity = "${lic.isValidity}";

				if (isValidity == 0 || isValidity == '0') {
					var errMessage = "${lic.errorMessage}";
					$("#uploadLicense").parent().find(".msg-box").removeClass(
							"hide");
					$(".part1").text(errMessage);
					$(".part1").css({"color":"#c33"})
                    $(".goLogin").attr("disabled",true);

                }else if (isValidity=="1" || isValidity==1){
                    $(".part1").text("license证书有效。");
                    $(".part1").css({"color":"#00a65a"});
                    $(".goLogin").attr("disabled",true);

                }
				$(document).on(
								"click",
								".upload_license",
								function() {
									var fileName = $(
											"input[name='licenseFile']").val();
									if (fileName == null || fileName == ''
											|| fileName == undefined) {
										errorMsgTip("请先选择license文件.");
										return;
									}
									var uploadLicenseUrl = "/lic/uploadLic"
									uploadFile(uploadLicenseUrl,
											"uploadLicense");
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
							$("#uploadLicense").parent().find(".msg-box")
									.removeClass("hide");
							$("#uploadLicense").parent().find(".msg-box").find(
									".n-msg").text(data.msg);
							$("#uploadLicense").parent().find(".msg-box").find(
									".n-msg").removeClass("n-success")
							$("#uploadLicense").parent().find(".msg-box").find(
									".n-msg").addClass("n-error")
                            $(".goLogin").attr("disabled",true);
                            return;
						}
						var successMsg = data.msg;
						successMsg = jQuery.parseJSON(successMsg);
						if (successMsg.isValidity == 0
								|| successMsg.isValidity == '0') {
							$("#uploadLicense").parent().find(".msg-box")
									.removeClass("hide");
							console.log(successMsg.errorMessage)
							$(".part1").text(successMsg.errorMessage);
							$(".part1").css({"color":"#c33"})
                            $("#uploadLicense").parent().find(".msg-box").find(
                                ".n-msg").text("license文件上传成功。")
                            $(".periodOfValidity").text("-");
                            $(".sysName").text("-");
                            $(".sysVersion").text("-");
							$("#uploadLicense").parent().find(".msg-box").find(
									".n-msg").removeClass("n-error");
                            $("#uploadLicense").parent().find(".msg-box").find(
                                ".n-msg").addClass("n-success");
                            $(".goLogin").attr("disabled",true);
						} else if (successMsg.isValidity == 1
								|| successMsg.isValidity == '1') {
							$("#uploadLicense").parent().find(".msg-box")
									.removeClass("hide");
                            $(".part1").text("license验证有效。");
                            $("#uploadLicense").parent().find(".msg-box").find(
                                ".n-msg").text("license上传成功。")
							$(".part1").css({"color":"#00a65a"})
							$("#uploadLicense").parent().find(".msg-box").find(
									".n-msg").removeClass("n-error")
							$("#uploadLicense").parent().find(".msg-box").find(
									".n-msg").addClass("n-success")
							$(".periodOfValidity").text(
									successMsg.periodOfValidity);
							$(".sysName").text(successMsg.sysName);
							$(".sysVersion").text(successMsg.sysVersion);
                            $(".goLogin").attr("disabled",false);

                        }
						console.log(successMsg);
					},
					error : function(data, status, e) { //提交失败自动执行的处理函数。
						console.error(e);
					}
				});
	}
</script>
</head>
<body>
	<section class="content">
		<div class="continer">
			<div class="row-fluid">
				<div class="col-md-12">
					<div class="box-body" style="font-size: medium;">
						<div class="row part1 n-success"></div>
						<div class="row part2 ">
							<div class="col-md-12 part2-header">license信息</div>
							<div class="col-md-12">
								<div class="row">
									<div class="col-sm-12 form-group">
										<label class="col-sm-2 control-label" style="width: 16%">当前系统名称:</label>

										<div class="col-sm-10" style="width: 84%">
											<label class="form-control sysName"></label>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-sm-12 form-group">
										<label class="col-sm-2 control-label" style="width: 16%">当前系统版本:</label>

										<div class="col-sm-10" style="width: 84%">
											<label class="form-control sysVersion"></label>
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-sm-12 form-group">
										<label class="col-sm-2 control-label" style="width: 16%">license过期日期:</label>

										<div class="col-sm-10" style="width: 84%">
											<label class="form-control periodOfValidity"></label>
										</div>
									</div>

								</div>
							</div>
						</div>
						<div class="row part3">
							<div class="col-md-12 part2-header"></div>

							<div class="col-sm-12 form-group">
								<label class="col-sm-2 control-label" style="width: 16%">上传license:</label>

								<div class="col-sm-6"
									style="width: 65.8%; margin-right: 0px; padding-right: 0px">
									<input type="file" id="uploadLicense" data-rule="required"
										name="licenseFile" class="form-control"> <span
										class="msg-box n-bottom hide" for=""><span role="alert"
										class="msg-wrap n-error"><span class="n-icon"></span><span
											class="n-msg"></span></span></span>
								</div>
								<div class="col-sm-3"
									style="width: 5.8%; margin-left: 0px; padding-left: 0px">
									<button class="btn btn-myself upload_license">上传</button>
								</div>
								<div class="col-sm-3" style="width: 5.8%">
									<button class="btn btn-myself goLogin">返回登录</button>
								</div>
							</div>

						</div>
					</div>

				</div>
			</div>

		</div>
	</section>
</body>
</html>