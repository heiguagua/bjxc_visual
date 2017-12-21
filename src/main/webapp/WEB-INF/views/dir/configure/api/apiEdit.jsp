<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=context_path%>/js/dir/configure/api/apiEdit.js"></script>
    <script src="<%=context_path%>/js/system/dict/dictIcon.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-12">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=context_path%>/dirDevelopApis/doEdit">
                        <input id="apiId" type="hidden" value="${id}" name="id" />
                        <div class="box-body">
                           <div class="form-group">
                                <label for="apiName">api名称</label>
                                <input type="text" id="Eapi_name" name="apiName" class="form-control"
                                       placeholder="请输入api名称" data-rule="api名称:required;api_name;">
                            </div>
                            <div class="form-group">
                                <label for="apiCategory">开发者工具种类:</label>
                                <input type="text" id="Eapi_category" name="apiCategory" class="form-control"
                                       placeholder="请输入api种类" data-rule="api种类:required;api_category;">
                            </div>
                            <div class="form-group">
                                <label for="apiUrl">url_adress</label>
                                <input type="text" id="Eapi_url" name="apiUrl" class="form-control"
                                       placeholder="请输入url地址" data-rule="url地址:required;api_url; ">
                            </div>
                            <div class="form-group">
                                <label for="orderNumber">排序号</label>
                                <input type="text" id="Eorder_number" name="orderNumber" class="form-control"
                                       placeholder="请输入排序号" data-rule="排序号:required;order_number;">
                            </div>
                            
                            <div class="form-group">
                                <label for="editChoosePic">图片<span class='require-sign'>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label>
                                <p style="display: inline-block" id="editPicName"></p>
                                <input style="display:inline-block;background-color:#27DC93" type="button" class="btn btn-save" value="重选图片"  id="editChangePicButton"/>                                
                                <div id="editPicDiv"></div>
                                <input style="width:32%" type="file" name="file" value="file" id="editChoosePic" data-rule="图片:required;file">
                                <span id="editPicNote" style="color: #ff0000">(注:上传图片的类型只能为 jpg,jpeg,png,gif ,且大小不超过5M)</span>                                
                            </div>
                            <div class="form-group">
                            	<label  class="" for="isShow" id="Eis_show">是否显示到首页</label>
                                
                            </div>
                            <div class="form-group">
                            	<label  class="" for="isUse" id="Eis_use">是否显示到开发者工具</label>
                                
                            </div>
                            <div class="form-group">
                                <label for="apiDesc">api描述:</label>
                                <textarea class="form-control" 
									id="Eapi_desc"  name="apiDesc" data-rule="目录类别描述:required;order_number;"></textarea>                                
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
