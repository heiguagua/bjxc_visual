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
