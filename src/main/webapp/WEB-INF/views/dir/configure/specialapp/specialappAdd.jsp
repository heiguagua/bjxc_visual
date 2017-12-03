<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="/js/dir/configure/specialapp/specialappAdd.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form"  enctype="multipart/form-data"  data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="/dirSpecialApps/doAdd">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="appName">应用名称</label>
                                <input type="text" id="app_name" name="appName" class="form-control"
                                       placeholder="请输入应用名称" data-rule="应用名称:required;appName;">
                            </div>
                            <div class="form-group">
                                <label for="appCategory">应用种类</label>
                                <input type="text" id="appCategory" data-rule="应用分类:required;" class="form-control"
		                         placeholder="">
		                        <input type="hidden" id="dictCode" name="appCategory">
		                        <div class="menu-wrap">
		                            <div id="menuContent" class="menuContent" style="display:none;">
		                                <ul id="treeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
		                            </div>
		                        </div>
                            </div>
                            <div class="form-group">
                                <label for="appUrl">url地址</label>
                                <input type="text" id="api_url" name="appUrl" class="form-control"
                                       placeholder="请输入url地址" data-rule="url地址:required;appUrl; ">
                            </div>
                            <div class="form-group">
                                <label for="orderNumber">排序号</label>
                                <input type="text" id="order_number" name="orderNumber" class="form-control"
                                       placeholder="请输入排序号" data-rule="排序号:required;orderNumber;">
                            </div>
                            <div class="form-group">
                                <label for="choosePic">图片<span class='require-sign'>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label>
                                <input style="display: inline-block" type="file" name="file" value="file" id="choosePic" data-rule="图片:required;file">
                                <label id="picNote" style="color: #ff0000">(注:上传图片的类型只能为 jpg,jpeg,png,gif ,且大小不超过5M)</label>
                                <div id="addPicDiv"></div>
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
