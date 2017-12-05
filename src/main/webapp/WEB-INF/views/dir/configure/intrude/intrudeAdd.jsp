<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script type="text/javascript" src="<%=context_path%>/plugins/ueditor/ueditor.config.js"></script>  
    <script type="text/javascript" src="<%=context_path%>/plugins/ueditor/ueditor.all.js"></script>
      
    <%-- <script type="text/javascript" charset="utf-8" src="/plugins/ueditor/lang/zh-cn/zh-cn.js"></script> --%>
    <script src="<%=context_path%>/js/dir/configure/intrude/intrudeAdd.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=context_path%>/dirIntrude/doAdd">
                        <div class="box-body">
                            
                           
                                <div class="form-group">
                                	<!-- <div class="col-sm-6" > -->
			                            <label  for="category">选择种类</label>
			                            <!-- <div class="col-sm-9"> -->
			                                 <select id="category" name="category" class="form-control select2" style="width: 100%;" >             
                                		  <<!-- option value =""></option>
                                		  <option value ="volvo">Volvo</option>
										  <option value ="saab">Saab</option>
										  <option value="opel">Opel</option>
										  <option value="audi">Audi</option> -->  
                               		 		</select>
			                        	<!-- </div> -->
			                      </div>
			                     
                           
                            <div class="form-group">
                                <label >内容:</label>
                                <script id="editor" style="height:300px;" name="content" type="text/plain">
								</script>										
                            </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
                            <%--<button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>--%>
                            <button type="submit" style="display:none;"/>
                        </div>
                    </form>
                </div>
            </div>
        </div><!--/.col (left) -->
    </div>
</section><!-- /.content -->
</body>
</html>
