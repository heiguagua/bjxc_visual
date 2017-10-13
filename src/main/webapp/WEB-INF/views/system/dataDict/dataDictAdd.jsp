<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/dict/dataDictAdd.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <style>
                .box-body .pdl0{
                    padding-left: 0;
                }
                .box-bodyx label{
                    width: 120px;
                    float: left;
                }
                .box-bodyx .form-group>.form-group{
                    width: 70%;
                    float: left;}
            </style>
            <div class="row">
                <div class="col-md-6">
                    <form  class="form-inline" role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/sysDict/doAdd">
                        <div class="box-body box-bodyx">
                        <div class="form-group">
                            <label for="categoryCode">类型编码 <i style="color: red">*必填</i></label>
                            <div class="form-group">
                            <input type="text" id="categoryCode" name="categoryCode" class="form-control"
                                   placeholder="请输入类型编码" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="categoryName">类型名称</label>
                            <div class="form-group">
                            <input type="text" style="display: none">
                            <input type="categoryName" id="categoryName" name="categoryName" class="form-control"
                                   placeholder="请输入类型名称" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="categoryDesc" >描述</label>
                            <div class="form-group">
                            <div name="categoryDesc">
                                    <textarea class="form-control" rows="3" name="categoryDesc" id="categoryDesc"
                                              placeholder="请输入数据字典描述"></textarea>
                            </div>
                            </div>
                        </div>
                        </div>
                       <!-- /.box-body -->
                        <div class="box-footer">
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
