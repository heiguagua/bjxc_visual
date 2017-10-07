<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>  
    <script type="text/javascript" src="<%=basePath%>/plugins/ueditor/ueditor.all.js"></script> 
    <script type="text/javascript" src="<%=basePath%>/plugins/ueditor/ueditor.config.js"></script>   
    <script type="text/javascript" charset="utf-8" src="<%=basePath%>/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script src="<%=basePath%>/js/dir/configure/news/newsAdd.js"></script>    
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" 
                           action="<%=basePath%>/dirNews/doAdd" method="post" enctype="multipart/form-data" id="uploadNewsP">
                        <div class="box-body">
                            <div class="form-group col-md-12">
                                <label for="choosePic">图片<span class='require-sign'>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label>
                                <input style="display: inline-block" type="file" name="file" value="file" id="choosePic">
                                <label id="picNote" style="color: #ff0000">(注:上传图片的类型只能为 jpg,jpeg,png,gif ,且大小不超过10M)</label>
                                <div id="addPicDiv"></div>
                            </div>
                            <div class="form-group col-md-12" style="display:none" align="center" id="imgDiv">
                                <img alt="" src="" id="showImg" name="showImg" width="200" height="200">
                            </div> 
                           <div class="form-group col-md-12">
                                <label for="pic_title">标题<span class='require-sign'>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label>
                                <input type="text" class="form-control" id="pic_title" name="title" maxlength="100">
                                <div id="addTitleDiv"></div>
                            </div> 
                            <div class="form-group col-md-12">
                                <label>内容</label>
                                    <!-- <textarea rows="3" cols="20" class="form-control" id="pic_content" name="pic_content"></textarea> -->
                                <script id="pic_content" style="height:300px;display: block;"  name="newsContent" type="text/plain"></script>
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
