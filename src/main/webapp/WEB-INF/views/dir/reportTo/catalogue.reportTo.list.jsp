<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<script src="<%=context_path%>/js/dir/report/upload.dir.js"></script>
<script type="text/javascript"
	src="/js/dir/report/upload.dir.sumbform.js"></script>
<style type="text/css">
.radio {
	border-style: solid;
	border-width: 1px;
	border-color: #000;
	border-radius: 80%;
	width: 15px;
	height: 15px;
	position: absolute;
	float: left;
	margin-top: 0px;
}
span{
padding-left:20%;position:absolute
}
.no-radio {
	background-color: gray;
}

.pass-radio {
	background-color: green;
}

</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<%@include file="/WEB-INF/views/common/menu.jsp"%>

		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					<small>上报管理 > 目录/服务上报</small>
				</h1>
				<!-- <ul class="title_ul">
                	<li class="active"><i class="fa fa-television" style="font-size:20px"></i>&nbsp;常规模式</li>
                	<li><i class="fa fa-crop" aria-hidden="true"></i>&nbsp;引导模式</li>
                	<li>图谱</li>
                </ul>  -->
			</section>
			<!-- Main content -->
			<section class="content">
				<!-- Your Page Content Here -->
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<form class="form-inline" method="post">
								<div class="box-header">

									<div class="input-group">
										<a class="btn btn-default btn-flat  btn-myself"
											onclick="javascript:uploadDir()"> <img
											src="/images/userImg/addimg.png" /> <!-- <i class="fa fa-plus-circle"></i> -->上报
										</a>
									</div>
									<div class="input-group" style="float: right">
										<input class="form-control" id="searchName" placeholder="资源名称"
											type="text">
										<div class="input-group-btn">
											<button class="btn btn-primary btn-flat btn_blue"
												id="queryBtn" type="button">
												<i class="fa fa-search"></i> 查询
											</button>
										</div>
										</input>
									</div>
									<div class="input-group"
										style="float: right; margin-right: 4px; width: 240px">
										<input type="text" id="searchClassifyName"
											placeholder="请选择目录类别" class="form-control" readonly
											style="background-color: #FFFFFF"> <input
											type="hidden" id="searchClassifyId">
										<div class="menu-wrap">
											<div id="searchClassifyMenuContent" class="menuContent"
												style="display: none;">
												<ul id="searchClassifyTreeDemo" c lass="ztree"
													style="margin-top: 0; border: 1px solid #98b7a8;"></ul>
											</div>
										</div>
									</div>

								</div>
							</form>
							<div class="box-body table-responsive no-padding">
								<!-- 表格 -->
								<table class="layui-table" id="catalogueTable" lay-even=""
									lay-skin="row"></table>
								<!-- 表格 end-->
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
