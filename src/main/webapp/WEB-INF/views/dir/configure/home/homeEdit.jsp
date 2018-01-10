<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
<%--     <script type="text/javascript" src="<%=context_path%>/plugins/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="<%=context_path%>/plugins/ueditor/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="/plugins/ueditor/lang/zh-cn/zh-cn.js"></script>
 --%>    
 	<script src="<%=context_path%>/js/dir/configure/home/homeEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" enctype="multipart/form-data" action="<%=context_path%>/portalConfig/dirHome/doEdit">
                        <input id="homeId" type="hidden" value="${id}" name="id" />
                        <div class="box-body">
                           <div class="form-group col-md-12">
                                <label for="editChoosePic">图片<span class='require-sign'>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label>
                                <p style="display: inline-block" id="editPicName"></p>
                                <input style="display:inline-block;background-color:#27DC93" type="button" class="btn btn-save" value="重选图片"  id="editChangePicButton"/>                                
                                <div id="editPicDiv"></div>
                                <input style="display: inline-block" type="file" name="file" value="file" id="editChoosePic" data-rule="图片:required;file">
                                <label id="editPicNote" style="color: #ff0000">(注:上传图片的类型只能为 jpg,jpeg,png,gif ,且大小不超过5M)</label>                                
                            </div>
                            <div class="form-group col-md-12" style="display:none" align="center" id="editImgDiv">
                                <img alt="" src="" id="editShowImg" name="showImg" width="200" height="200">
                            </div> 
                            <div class="form-group col-md-12">
                                <label for="edit_pic_title">顺序<span class='require-sign'>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label>
                                <input type="text" class="form-control" id="edit_pic_order" name="picOrder" maxlength="5">
                                <div id="editOrderDiv"></div>
                            </div>
                           <!-- <div class="form-group col-md-12">
                                <label for="edit_pic_title">标题<span class='require-sign'>*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></label>
                                <input type="text" class="form-control" id="edit_pic_title" name="title" maxlength="100" data-rule="标题:required;title">
                                <div id="editTitleDiv"></div>
                            </div>  -->
                            <!-- <div class="form-group col-md-12">
                                <label for="edit_pic_content">内容</label>
                                    <textarea rows="3" cols="20" class="form-control" id="pic_content" name="pic_content"></textarea>
                                <script id="edit_pic_content" style="height:300px;display: block;"  name="newsContent" type="text/plain"></script>
                            </div>  -->  
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
