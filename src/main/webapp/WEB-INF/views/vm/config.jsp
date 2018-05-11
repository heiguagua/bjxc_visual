<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!-- 1 -->
<html>
<head>
<%@include file="/WEB-INF/views/common/head.jsp"%>

<style>
.checkbox{
	padding-left:0 !important;
	display: inline-block !important;
}
.checkbox label::after{
	left:-1px !important;
	top:1px !important;
}
.checkbox label::before,.checkbox label::after {
	margin-left:-10px !important;
}
.checkbox label{
	padding-left:10px !important;
}
.radio{
	display:inline-block;
	    padding: 0 10px;
}    
.radio label::before{
	width: 16px !important;
    height: 16px !important;
}
.radio label::after{
	width: 10px !important;
    height: 10px !important;
    top:10px !important;
}
.radio input[type="radio"]{
outline:none;
width:20px;
height:20px;}

.tree {
	max-height: 360px;
    overflow: auto;
}

form .form-group label {
	display: inline-block;
}
#tableList{
    overflow: inherit;
}
.chart-item-wrap{
	display: inline-block;
	position: relative;
	width: 500px;
	height: 500px;
	border: 1px solid #EFF1F4;
	overflow: hidden;
	padding: 10px;
	background: #FFF;
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
	height: 75%;
	
}

.tree-wrap {
    height: 400px;
	    background: #F8F9FA;
	margin: 10px;
}

.tree-title {
	font-weight: 600;
	padding: 10px 0;
}

.detail_info {
    width: 100%;
	position: absolute;
	padding-top:4px;
	display: block;
}

.info-item {
    display: inline-block;
    width: 49%;
	padding: 0 0 20px 0;
}
.info-item-name{
	text-align: center;
	padding-bottom: 6px;
}
.info-item-num{
	font-size:18px;
	color:#494949;
	font-weight:600;
	text-align: center;
}
.info-item-unit{
	font-size:14px;
	font-weight:normal;
	colro:#333;
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

.ztree li span.button.chk.checkbox_false_full,.ztree li span.button.chk.checkbox_false_full_focus{
	border: 1px solid #D9D9D9;
    background-color: #fff;
    background: none;
    width: 14px;
    height: 14px;
    background: rgba(255,255,255,1);
    border-radius: 2px;
}
.ztree li span.button.chk.checkbox_true_full,.ztree li span.button.chk.checkbox_true_full_focus{
	    width: 14px;
    height: 14px;
    background: rgba(0,188,255,1) !important;
    border-radius: 2px;
    background:none;
    position:relative;
}
.ztree li span.button.chk.checkbox_true_full:after,.ztree li span.button.chk.checkbox_true_full_focus:after{
    display: inline-block;
    position: absolute;
    width: 16px;
    height: 16px;
    left: 18px;
    top: 6px;
    margin-left: -20px;
    padding-left: 3px;
    padding-top: 1px;
    font-size: 11px;
    color: #fff;
        font-family: "FontAwesome";
    content: "\f00c";
}
.ztree li span.button.center_close,.ztree li span.button.roots_close,.ztree li span.button.bottom_close,.ztree li span.button.roots_open,.ztree li span.button.bottom_open,.ztree li span.button.center_open{
	background:none !important;
	position:relative;
}
.ztree li span.button.center_close:before,.ztree li span.button.roots_close:before,.ztree li span.button.bottom_close:before{
    color: #333;
    display: inline-block;
    width: 14px;
    height: 14px;
    position: absolute;
    top: 8px;
    left: 6px;
    font-family:"FontAwesome";
	content: "\f0da";
    color: #333;
}
.ztree li span.button.center_open:before,.ztree li span.button.roots_open:before,.ztree li span.button.bottom_open:before{
	color: #333;
    display: inline-block;
    width: 14px;
    height: 14px;
    position: absolute;
    top: 8px;
    left: 6px;
    font-family:"FontAwesome";
	content: "\f0d7";
    color: #333;
}
.indi-datas li{
    padding: 4px 0 4px 12px;
    position: relative;
}
.indi-datas li:before{
	position:absolute;
	content:'';
	display:inline-block;
	width:6px;
	height:6px;
	top: 10px;
    left: 0;
	background:#00BCFF;
	border-radius:50%;
}
.ztree li a.curSelectedNode{
	background-color:inherit !important;
	border:inherit !important;
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
					<small>总览</small><input id="menuId" type="hidden"value="${menuId}">
				</h1>
			</section>
			<section class="content">
				<!-- Your Page Content Here -->
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="form-inline">
								<div class="box-header">
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
							</div>

							<div class="box-body table-responsive" id="tableList">
								<div id="chartWrapper" style="width: 100%; position: relative;"></div>
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
	<div class="modal fade" tabindex="-1" role="dialog" id="addChartModal">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">新增图表</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">图表名称</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="etitle"
									placeholder="请输入图表名称">

							</div>
							<div class="checkbox checkbox-info">
							    <input type="checkbox" checked name="showTitle" id="showTitle">
							    <label for="showTitle">
							        	显示图表名称
							    </label>
							  </div>
						</div>
						
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">选择图表样式</label>
							<div class="col-sm-10">
								<div class="radio radio-info">
      								<input type="radio"	name="chartTypeOptions" id="eline" checked value="eline">
								      <label class="radio-inline">
								          	折线图
								      </label>
 							    </div>
								<!-- <label class="radio-inline"> <input type="radio"
									name="chartTypeOptions" id="eline" checked value="eline">
									折线图
								</label> -->
								<div class="radio radio-info">
      								<input type="radio"	name="chartTypeOptions" id="ebar" value="ebar">
								      <label class="radio-inline">
								          	柱状图
								      </label>
 							    </div>
 							    
 							    <div class="radio radio-info">
      								<input type="radio" name="chartTypeOptions" id="earea" value="earea">
								      <label class="radio-inline">
								          	面积图
								      </label>
 							    </div>
 							    
 							    <div class="radio radio-info">
      								<input type="radio"
									name="chartTypeOptions" id="eradar" value="eradar">
								      <label class="radio-inline">
								          	雷达图
								      </label>
 							    </div>
 							    
 							    <div class="radio radio-info">
      								<input type="radio"
									name="chartTypeOptions" id="efunnel" value="efunnel">
								      <label class="radio-inline">
								          	漏斗图
								      </label>
 							    </div>
 							    
 							    <div class="radio radio-info">
      								<input type="radio"
									name="chartTypeOptions" id="ecircle" value="ecircle">
								      <label class="radio-inline">
								          	环形图
								      </label>
 							    </div>
 							    <div class="radio radio-info">
      								<input type="radio"
									name="chartTypeOptions" id="egauge" value="egauge">
								      <label class="radio-inline">
								          	仪表图
								      </label>
 							    </div>
 							    
							</div>
						</div>
						<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">时间范围</label>
								<div class="col-sm-2">
									<select class="form-control" id="timeselect">
										<option value="now_date">当前时间</option>
										<option value="last_date">当前时间-1</option>
										<option value="custom_date">自定义</option>
										<option value="recent_years">时间段</option>
									</select>
								</div>
								<div class="col-sm-6 hide" id="timeRangeWrap">
										<label class="sr-only" for="timeRange">时间范围</label>
										<input id="timeRange" type="text"	name="timeRange" class="form-control date" readonly	placeholder="开始日期 ~ 结束日期" style="width: 220px; background-color: #fff">
								</div>
								<div class="col-sm-6 hide" id="timeWrap">
										<label class="sr-only" for="timePoint">时间范围</label>
										最近&nbsp;&nbsp;<input id="timePoint" type="number" min="1"	name="timePoint" class="form-control" style="width:80px;    display: inline-block;">
										<select id="timeUnit">
											<option value="y">年</option>
											<option value="m">月</option>
											<option value="d">日</option>
										</select>
								</div>
						</div>
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox checkbox-info">
							    <input type="checkbox" checked name="showDetail" id='showDetail'>
							    <label for="showDetail">
							        	显示图表详情信息
							    </label>
							  </div>
						</div>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">选择指标</label>
							<div class="col-sm-4 tree-wrap">
								<h5 class="tree-title">选择展示的指标</h5>
								<div class="update-dir">
								<div class="selected-title">已选展示指标：<a href="javascript:;" id="rechooseTree">重新选择</a></div>
								<ul class="selected-indicators indi-datas"></ul> </div>
								<ul id="indicatorTree" class="tree ztree"></ul>
							</div>
							<div class="col-sm-4 tree-wrap detail">
								<h5 class="tree-title">选择展示详情的指标</h5>
								<div class="update-detail-dir">
									<div class="selected-title">已选展示详情指标：<a href="javascript:;" id="rechooseDetailTree">重新选择</a></div>
									<ul class="selected-detail-indicators indi-datas"></ul>
									
									</div>
								<ul id="detailTree" class="tree ztree"></ul>
							</div>
						</div>
						<input type="hidden" id="updateChartId" />
						<input type="hidden" id="addOrUpdate" />
						<input type="hidden" id="location" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="addChartConfirm">确定</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<script src="<%=context_path%>/js/vm/index.js"></script>
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
