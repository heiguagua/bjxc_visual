<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1 -->
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    
	<style>
		#indicatorTree{
			height: auto;
		}
		form .form-group label{
			display:inline-block;
		}
		.chart-box{
			display:inline-block;
			width:500px;
			height:400px;
			border: 1px solid #DDD; 
			margin: 10px;
			padding:10px; 
			background: #f9f9f9;
		}
	</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <small>总览</small>
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
                                            <a class="btn btn-primary btn-flat btn-myself" data-toggle="modal" data-target="#addChartModal" >
                                                <img src="<%=context_path%>/images/userImg/addimg.png"/>
                                                	新增图表
                                            </a>
                                        </div>
     

                                </div><!-- /.box-header -->
                            </div>

                            <div class="box-body table-responsive" id="tableList">
                                <div id="chartWrapper" style="width:100%;min-height:500px;"></div>
                            </div><!-- /.box-body -->

                        </div><!-- /.box -->
                    </div>
                </div>
            </section><!-- /.content -->
        
    </div><!-- /.content-wrapper -->

    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <div class="control-sidebar-bg"></div>
</div>
<div class="modal fade" tabindex="-1" role="dialog" id="addChartModal">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">新增图表</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">图表标题</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" id="etitle" placeholder="请输入标题">
		      
		    </div>
		    <label>
	          <input type="checkbox"  checked name="showDate"> 显示标题
	        </label>
		  </div>
		  <div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
		    <label>
	          <input type="checkbox" name="showDate"> 显示时间
	        </label>
	        </div>
		  </div>
		  <div class="form-group">
		  	<label for="inputEmail3" class="col-sm-2 control-label">选择图表样式</label>
			<div class="col-sm-10">
			    <label class="radio-inline">
				  <input type="radio" name="chartTypeOptions" id="eline" value="eline"> 折线图
				</label>
				<label class="radio-inline">
				  <input type="radio" name="chartTypeOptions" id="earea" value="earea"> 面积图
				</label>
				<label class="radio-inline">
				  <input type="radio" name="chartTypeOptions" id="eradar" value="eradar"> 雷达图
				</label>
				<label class="radio-inline">
				  <input type="radio" name="chartTypeOptions" id="efunnel" value="efunnel"> 漏斗图
				</label>
				<label class="radio-inline">
				  <input type="radio" name="chartTypeOptions" id="etemp" value="etemp"> 温度表
				</label>
				<label class="radio-inline">
				  <input type="radio" name="chartTypeOptions" id="edash" value="edash"> 仪表图
				</label>
			</div>
		  </div>
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">选择指标</label>
		    <div class="col-sm-10">
		      <ul id="indicatorTree" class="ztree"></ul>
		    </div>
		  </div>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" id="addChartConfirm">确定</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script src="<%=context_path%>/js/vm/index.js"></script>
<script src="<%=context_path%>/plugins/echarts3/echarts.min.js"></script>
</body>
</html>
