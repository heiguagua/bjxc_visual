<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- 1 -->
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>

<style>
.tree {
	max-height: 280px;
    overflow: auto;
}

form .form-group label {
	display: inline-block;
}
.chart-item-wrap{
	display: inline-block;
	position: relative;
	width: 500px;
	height: 400px;
	border: 1px solid #DDD;
	margin: 10px;
	padding: 10px;
	background: #f9f9f9;
}
.tool-box{
	position:absolute;
	right:10px;
	top:14px;
}
.tool-box span.fa{
	padding: 2px 10px;
    color: #0082c1;
    cursor: pointer;
}
.chart-box {
	
	width:100%;
	height: 100%;
	
}

.tree-wrap {
    height: 400px;
	border: 1px solid #DDD;
	margin: 10px;
}

.tree-title {
	font-weight: normal;
	padding: 10px 0;
}

.detail_info {
	position: absolute;
	top: 18%;
	left: 60%;
	display: block;
}

.info-item {
	padding: 0 0 10px 18px;
}

#timeselect {
	width: 130px;
}
#timeRange{
    display: inline-block;
}
.select2-container--default .select2-selection--single{
	
    height: 34px !important;
    padding: 6px 12px !important;
    font-size: 14px !important;
    line-height: 1.42857143 !important;
    color: #555 !important;
    background-color: #fff !important;
    background-image: none !important;
    border: 1px solid #ccc !important;
    border-radius: 4px !important;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075) !important;
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075) !important;
    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s !important;
    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s !important;
    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s !important;
}
.tool {
	float: right;
}
.update-dir,.update-detail-dir{
display:none;}
.selected-title{
	padding-bottom:5px;
	border-bottom:1px solid #DDD;
	margin-bottom: 5px;
}
.selected-title a{
	color:#2196F3;
	text-decoration:underline;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<%@include file="/WEB-INF/views/common/header.jsp"%>
		<%@include file="/WEB-INF/views/common/menu.jsp"%>

		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					<small>首页</small><input id="menuId" type="hidden"value="${menuId}">
				</h1>
			</section>
			<section class="content">
				<!-- Your Page Content Here -->
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="form-inline">
<%-- 								<div class="box-header">
									<div class="input-group">
										<a class="btn btn-primary btn-flat btn-myself"
											 id="addChartBtn"> <img
											src="<%=context_path%>/images/userImg/addimg.png" /> 新增图表
										</a>
									</div>
									<div class="tool">
										<a class="btn btn-primary btn-flat btn-myself"
											 id="preview"> <img
											src="<%=context_path%>/images/userImg/addimg.png" /> 预览
										</a>
										<a class="btn btn-primary btn-flat btn-myself"
											 id="edit"> <img
											src="<%=context_path%>/images/userImg/addimg.png" /> 编辑
										</a>
										<a class="btn btn-primary btn-flat btn-myself"
											 id="save"> <i class="fa fa-save"></i>&nbsp; 保存
										</a>
									</div>


								</div>
								<!-- /.box-header -->
							</div> --%>

							<div class="box-body table-responsive" id="tableList">
								<div id="chartWrapper" style="width: 100%; min-height: 500px;position: relative;"></div>
							</div>
							<!-- /.box-body -->

						</div>
						<!-- /.box -->
					</div>
				</div>
			</section>
			<!-- /.content -->

		</div>
		<!-- /.content-wrapper -->

		<%@include file="/WEB-INF/views/common/footer.jsp"%>
		<div class="control-sidebar-bg"></div>
	</div>

	<script src="<%=context_path%>/js/vm/indexForCharTemplate.js"></script>
	<%-- <script src="<%=context_path%>/plugins/echarts3/echarts.min.js"></script> --%>
	<script>
	// 全局变量
	window.NOW_DATE = 'now_date';		  // 当前时间,  传参：""
	window.LAST_DATE = 'last_date';		  // 当前时间-1,	传参：""
	window.CUSTOM_DATE = 'custom_date';   // 自定义时间段 ,  传参如：2018-05-08 ~ 2018-06-19
	window.RECENT_YEARS = 'recent_years'; // 最近x年/月/日 , 传参如："3 Y", "3 M", "3 D"
	window.ADD_OR_UPDATE = 'add';
	</script>
</body>
</html>
