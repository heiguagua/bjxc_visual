<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/js/dir/configure/api/apiAdd.js"></script>
 	<script src="<%=context_path%>/js/system/dict/dictIcon.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" enctype="multipart/form-data" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=context_path%>/dirDevelopApis/doAdd">
                        <div class="box-body">
                        	<input id="parentId" type="hidden" value="${parentId}" name="parentId" />
                            <div class="form-group">
                                <label for="apiName">api名称</label>
                                <input type="text" id="api_name" name="apiName" class="form-control"
                                       placeholder="请输入api名称" data-rule="api名称:required;api_name;">
                            </div>
                            <div class="form-group">
                                <label for="apiCategory">开发者工具种类:</label>
                                <input type="text" id="api_category" name="apiCategory" class="form-control"
                                       placeholder="请输入api种类" data-rule="api种类:required;api_category;">
                            </div>
                            <div class="form-group">
                                <label for="apiUrl">url_adress</label>
                                <input type="text" id="api_url" name="apiUrl" class="form-control"
                                       placeholder="请输入url地址" data-rule="url地址:required;api_url; ">
                            </div>
                            <div class="form-group">
                                <label for="orderNumber">排序号</label>
                                <input type="text" id="order_number" name="orderNumber" class="form-control"
                                       placeholder="请输入排序号" data-rule="排序号:required;order_number;">
                            </div>
                            <div class="form-group">
                                <label for="choosePic">图片<span class='require-sign'>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label>
                                <input style="width:32%" type="file" name="file" value="file" id="choosePic" data-rule="图片:required;file">
                                <span id="picNote" style="color: #ff0000">(注:上传图片的类型只能为 jpg,jpeg,png,gif ,且大小不超过5M)</span>
                                <div id="addPicDiv"></div>
                            </div>
                            <div class="form-group">
                            	<label  class="" for="isShow">是否显示到首页</label>
                                <div class="redio-box">
			                        <input type="radio" name="isShow"  value="0" ><span></span>
			                    </div>
			                         <label style="display:inline-block">否</label>
			                    <div class="redio-box">
			                          <input type="radio" name="isShow"  value="1" checked><span></span>
								</div>
			                    <label style="display:inline-block">是</label>
                            </div>
                            <div class="form-group">
                            	<label  class="" for="isShow">是否显示到开发者工具管理</label>
                                <div class="redio-box">
			                        <input type="radio" name="isUse"  value="0" ><span></span>
			                    </div>
			                         <label style="display:inline-block">否</label>
			                    <div class="redio-box">
			                          <input type="radio" name="isUse"  value="1" checked><span></span>
								</div>
			                    <label style="display:inline-block">是</label>
                            </div>
                            <div class="form-group">
                                <label for="apiDesc">api描述:</label>
                                <textarea class="form-control" 
									id="api_desc"  name="apiDesc" data-rule="目录类别描述:required;order_number;"></textarea>                                
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
