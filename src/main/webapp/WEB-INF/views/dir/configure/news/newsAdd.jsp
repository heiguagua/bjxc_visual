<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/dir/configure/specialapp/specialappAdd.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/dirNews/doAdd">
                        <div class="box-body">
                            <div class="form-group col-md-12">
                                <label for="choosePic">图片<span class='require-sign'>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label>
                                <input style="display: inline-block" type="file" name="file" value="file" id="choosePic">
                                <label id="picNote" style="color: #ff0000">(注:上传图片的类型只能为 jpg,jpeg,png,gif ,且大小不超过10M)</label>
                                <div id="addPicDiv"></div>
                            </div>
                            <!-- <div class="form-group col-md-12" style="display:none" align="center" id="imgDiv">
                                <img alt="" src="" id="showImg" name="showImg" width="200" height="200">
                            </div> -->
                            <div class="form-group col-md-12">
                                <label for="pic_title">标题<span class='require-sign'>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label>
                                <input type="text" class="form-control" id="pic_title" name="pic_title" maxlength="100">
                                <div id="addTitleDiv"></div>
                            </div>
                            <div class="form-group col-md-12">
                                <label>内容&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                                    <%--<textarea rows="3" cols="20" class="form-control" id="pic_content" name="pic_content"></textarea>--%>
                                <script id="pic_content" style="height:300px;" name="pic_content" type="text/plain"></script>
                            </div>
                            <!-- <div class=" text-center top12" style="margin-left:-25px;width:102.8%;margin-bottom: -60px;">
                                <div class="btn-group">
                                    <input type="button" class="btn btn-save" value="保存"  id="uploadButton"
                                            style="background-color: #27DC93;border-radius: 0.5rem;width: 240px;font-size: 14px;color: #FFFFFF"/>
                                </div>
                            </div>  -->              
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
