<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/dict/dataDictDetailAdd.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/sysDict/detailDoAdd">
                        <div class="form-group">
                            <label for="dictCode">配置项编码</label>
                            <input type="text" id="dictCode" name="dictCode" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label for="dictName">配置项名称</label>
                            <input type="text" id="dictName" name="dictName" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="regionName">适用范围</label>
                            <input type="text" id="regionName" name="regionName" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="orderNumber">顺序</label>
                            <input type="number" data-rule="integer(+0);" min="0" id="orderNumber" name="orderNumber" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="dictDesc" >描述</label>
                            <div name="dictDesc">
                                    <textarea class="form-control" rows="3" name="dictDesc" id="dictDesc"
                                              placeholder="请输入数据字典描述"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <label>状态</label>
                            <div class="col-sm-10">
                                <span>
                                    <input name="status" type="radio" class="minimal" value="1" checked> 启用
                                </span>
                                <span>
                                    <input name="status" type="radio" class="minimal"  value="0"> 禁用
                                </span>
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
