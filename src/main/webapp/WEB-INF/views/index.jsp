<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <link rel="stylesheet" href="<%=basePath%>/css/index.css" />
</head>
	
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="common/header.jsp" %>
    <%@include file="common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>  
             
                <small>统计</small>
          </h1>
        </section>

        <!-- Main content -->
        <section class="content">
			<div>
			<div class="row">
				<div class="col-md-12 TOngji">
					目录分类统计
				</div>
			</div>
			<div class="row docs-premium-template">
                 <div class="col-sm-12 col-md-4">
	                <div class="box box-solid"  style="background:#fff">
	                    <div class="box-body">
	                       
	                        <div id="countDatasetByDept" style="height:400px;"></div>
	                    </div>
	                </div>
            	</div>
                 <div class="col-sm-12 col-md-4">
	                <div class="box box-solid"  style="background:#fff">
	                    <div class="box-body">
	                       
	                        <div id="countDatasetByDept" style="height:400px;"></div>
	                    </div>
	                </div>
            	</div>
                 <div class="col-sm-12 col-md-4" >
	                <div class="box box-solid"  style="background:#fff">
	                    <div class="box-body">
	                      
	                        <div id="countDatasetByDept" style="height:400px;"></div>
	                    </div>
	                </div>
            	</div>
            </div>
		</div>
		<!--111  -->
			
            <div class="row" style="padding: 15px 10px;">
          
             	   <div class="col-lg-4 col-xs-6" style="padding-left: 4px;">
	             	   <div class="clear headtitle">
	                    		<span class="pull-left">信息资源统计</span>
	                    </div>
             	   
                    <!-- small box -->
                    <div class="left_content">
               					<div class="imgdiv">
               						<p class="chntile">已梳理信息资源</p>
               						<p class="num" id="datasetTotal">0</p>
               					</div>
               					<div class="imgdiv_title clear">
               						<div class="share pull-left">
               								<p style="font-family: PingFangSC-Medium;padding-top: 46px;font-size: 14px;color: #595959;line-height: 21px;">可共享受资源</p>
               								<p id="datasetTotalShare" style="font-family: PingFangSC-Medium;font-size: 24px;color: #595959;line-height: 21px;">0</p>
               								
               						</div>
               						<div class="open pull-right">
               							<p style="font-family: PingFangSC-Medium;padding-top: 46px;font-size: 14px;color: #595959;line-height: 21px;">可共享受资源</p>
               								<p id="datasetTotalOpen" style="font-family: PingFangSC-Medium;font-size: 24px;color: #595959;line-height: 21px;">0</p>	
               								
               						</div>
               					</div>
               				</div>
                </div><!-- ./col -->

                <div class="col-lg-4 col-xs-6" style="padding-right:0">
                		<div class="clear headtitle">
	                    		<span class="pull-left">信息资源统计</span>
	                    </div>
                    <!-- small box -->
                    <div class="small-box bg-white">
                         <div class="inner">
                          
                            <p>
                            	<span>
                            		<img src="<%=basePath%>/images/userImg/weizhuce.png"/>
                            	</span>
                            	
                            	<span class="spanDis">
                            		<a style="padding">未注册信息资源</a>
                            		<a class="num" id="businessTotal">0</a>
                            	</span>
                            </p>
                        </div>
                    </div>
                    <div class="small-box bg-white">
                         <div class="inner">
                          
                            <p>
                            	<span>
                            		<img src="<%=basePath%>/images/userImg/weifabu.png"/>
                            	</span>
                            	
                            	<span class="spanDis">
                            		<a style="padding">未发布信息资源</a>
                            		<a class="num" id="businessTotal">0</a>
                            	</span>
                            </p>
                        </div>
                    </div>
                </div><!-- ./col -->

                <div class="col-lg-4 col-xs-6"  style="padding-left:0;padding-right:4px;">
                <div class="clear headtitle">
	                    		<span class="pull-left">  &nbsp; </span>
	                    </div>
                    <!-- small box -->
                    <div class="small-box  bg-white">
                        <div class="inner">
                          
                            <p>
                            	<span>
                            		<img src="<%=basePath%>/images/userImg/weishenhe.png"/>
                            	</span>
                            	
                            	<span class="spanDis">
                            		<a style="padding">未审核信息资源</a>
                            		<a class="num" id="requirementTotal">0</a>
                            	</span>
                            </p>
                        </div>
                    </div>
                    <div class="small-box  bg-white">
                        <div class="inner">
                          
                            <p>
                            	<span>
                            		<img src="<%=basePath%>/images/userImg/yifabu.png"/>
                            	</span>
                            	
                            	<span class="spanDis">
                            		<a style="padding">已发布信息资源</a>
                            		<a class="num" id="requirementTotal">0</a>
                            	</span>
                            </p>
                        </div>
                    </div>
                </div><!-- ./col -->

                
                <!-- fix for small devices only -->
                <div class="clearfix visible-sm-block"></div>
             
             
            </div><!-- /.row -->

            <!-- div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">最近十二个月的收益趋势图(金额（单位:万元）/月)</h3>
                            <div class="box-tools pull-right">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="chart">
                                <canvas id="lineChart" style="height:400px"></canvas>
                            </div>
                        </div>/.box-body
                    </div>/.box
                </div>
            </div> -->

        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->


    <%@include file="common/footer.jsp" %>
    <div class="control-sidebar-bg"></div>
</div>

</body>
</html>

