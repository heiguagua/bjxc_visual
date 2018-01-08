<%--
  Created by IntelliJ IDEA.
  User: lianrongfa
  Date: 2017/9/20
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 1000px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                  配置信息项
                </h4>
                	
            </div>
            <div class="modal-body" style="height: 380px;padding-bottom: 54px;">
                <style>
                    .col_container{
                        border: solid #C3C3C3 1px;
                        height: 100%;
                        border-left: none;
                        padding: 0px;
                        padding-top: 35px;
                    }
                    .col_container:first-child{
                        border-left: solid #C3C3C3 1px;
                    }
                    .header_title{
                        background: #E0DEDE;
                        text-align: center;
                        padding: 5px 0px;
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        right: 0px;
                        width: 100%;
                    }
                    .content_scroll_item{
                        max-height: 100%;
                        overflow: auto;
                    }
                    
                </style>
                <p style="margin-bottom:15px;">选择信息项</p>
                <div class="col-md-12" style="/*height: 100%;*/padding: 0px;">
                    <div class="col-md-4 col_container">
                        <div class="header_title">选择项目</div>
                        <div class="content_scroll_item list-group">
                            <div id="group_tree" class=""></div>
                        </div>
                    </div>
                    <div class="col-md-4 col_container">
                        <div class="header_title">选择资源</div>
                        <div class="content_scroll_item list-group">
                            <div id="bus_tree" class="" style="text-align:center">
                            <img class="selec_img" alt="" src="<%=context_path %>/images/addimg/orgcontainer.png">
                            	<p class="img_p">请先选择项目</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col_container">
                        <div class="header_title">选择表</div>
                        <div id="dataset_item_container" class="content_scroll_item list-group">
                        
                        			<div style="text-align:center">
			                        			 <img class="selec_img"  alt="" src="<%=context_path %>/images/addimg/dbmysql.png">
			                            	<p class="img_p">请先选择资源</p>
                        			</div>
                         
                        </div>
                    </div>
                    <div class="col-md-3 col_container hide">
                        <div class="header_title">选择字段</div>
                        <div id="field_tree" class="content_scroll_item list-group">
	                        <div style="text-align:center">
	                          <img class="selec_img"  alt="" src="<%=context_path %>/images/addimg/predir.png">
	                            	<p class="img_p">请先选择表</p>
	                        </div>    	
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn_quxiao" data-dismiss="modal">取消
                </button>
                <button type="button" id="field_add" class="btn btn-primary btn_blueinsure">
                    确认
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
