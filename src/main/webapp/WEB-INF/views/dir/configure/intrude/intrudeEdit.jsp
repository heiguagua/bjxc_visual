<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script type="text/javascript" src="<%=context_path%>/plugins/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="<%=context_path%>/plugins/ueditor/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script src="<%=context_path%>/js/dir/configure/intrude/intrudeEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=context_path%>/dirIntrude/doEdit">
                        <input id="IntrudeId" type="hidden" value="${id}" name="id" />
                        <div class="box-body">
                        <div class="form-group">  
                        	
                                        
	                                <label  for="category">选择种类</label>	                                
	                                
	                                <select id="Ecategory" name="category" class="form-control select2" style="width: 100%;" >             
	                                		  <!-- <option value =""></option>
	                                		  <option value ="volvo">Volvo</option>
											  <option value ="saab">Saab</option>
											  <option value="opel">Opel</option>
											  <option value="audi">Audi</option>   -->
	                                </select>	
	                              
	                                
	                      			                                                        
                        	
                        </div>
                        <div class="form-group">                            
                                <label >内容</label>
                                <script id="Eeditor" style="height:300px;" name="content" type="text/plain">
								</script>																	
                        </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
                            <%--<button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>--%>
                            <input type="submit" style="display:none;"/>
                        </div>
                    </form>
                </div>
            </div>
        </div><!--/.col (left) -->
    </div>
</section><!-- /.content -->

</body>
</html>
