<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
</head>

<section class="content">
    <div id="catalogueTableEditLayer">
        <div class="layer-boxs">
            <form action="<%=basePath%>/catalog/excelImport" method="post" enctype="multipart/form-data" style="text-align:center">
            <!--原来的上传是 点提交按钮 form action  提交    现在layui提交  -->
           <!-- <input type="file" name="file" />  -->
           
           <a href="javascript:;" class="<%--a-upload--%>">
			    <input type="file" name="file" id="">
			</a>
			<input type="hidden" id="regionCodeId" name="regionCode">
           
           
          <!--  <a href="javascript:;" class="file">选择文件
			    <input type="file" name="file" id="">
			</a> -->
                 <!-- 	<label class="control-label">sdfsd</label>
                	<input id="input-1" type="file" class="file" /> -->
				<!--  <button type="button" class="layui-btn" id="test3"><i class="layui-icon"></i>上传文件</button> -->

					<!-- 
					<div class="layui-upload-drag" id="test10" name="file">
					  <i class="layui-icon"></i>
					  <p>点击上传，或将文件拖拽到此处</p>
					</div> -->

            </form>
        </div>
    </div>
</section>

</body>

<script>
    $(function(){
        $('#regionCodeId').val($.getSelectedRegionCode());
    })

 <%-- layui.use('upload', function(){
	  var $ = layui.jquery
	  ,upload = layui.upload;
	  
	  //普通图片上传
	  var uploadInst = upload.render({
	    elem: '#test10'
	    ,url: '<%=basePath%>/catalog/excelImport'
	    ,accept:"file"
	    ,before: function(obj){
	      //预读本地文件示例，不支持ie8
	      obj.preview(function(index, file, result){
	        $('#demo1').attr('src', result); //图片链接（base64）
	      });
	    }
	    ,done: function(res){
	      //如果上传失败
	      if(res.code > 0){
	        return layer.msg('上传失败');
	      }
	      //上传成功
	    }
	    ,error: function(){
	      //演示失败状态，并实现重传
	      var demoText = $('#demoText');
	      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
	      demoText.find('.demo-reload').on('click', function(){
	        uploadInst.upload();
	      });
	    }
	  });
});  --%>
</script>
</html>
