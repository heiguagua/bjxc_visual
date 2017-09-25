<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/catalog/classify/classifyEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=basePath%>/dirClassify/doEdit">
                        <input id="classifyId" type="hidden" value="${id}" name="id" />
                        <div class="box-body">
                           <div class="form-group">
                                <label for="apiName">目录名称</label>
                                <input type="text" id="Eclassify_name" name="classifyName" class="form-control"
                                       placeholder="请输入目录名称" data-rule="api名称:required;classifyName;remote(<%=basePath%>/system/user/insertCheckName)">
                            </div>
                            
                            <div class="form-group">
                                <label for="apiDesc">目录描述:</label>
                                <textarea class="form-control" 
									id="Eclassify_desc"  name="classifyDesc" data-rule="目录类别描述:required;classifyDesc;"></textarea>                                
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
