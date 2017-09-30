<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script type="text/javascript" src="<%=basePath%>/plugins/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="<%=basePath%>/plugins/ueditor/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script src="<%=basePath%>/js/dir/configure/policy/policyAdd.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/dirPolicy/doAdd">
                        <ddiv class="box-body">
                            <div class="form-group">
                                <label for="title">标题</label>
                                <input type="text" id="title" name="title" class="form-control"
                                       placeholder="请输入标题" data-rule="标题:required;title">
                            </div>
                            <div class="form-group">
                                <label>类型</label>
                                <div id='type-group' class="btn-group">
                                    <input type="radio" checked name="policyLevel" value="G">国家级</input>
                                    <input type="radio" name="policyLevel" value="S">省级</input>
                                    <input type="radio" name="policyLevel" value="C">市级</input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label >内容</label>
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
