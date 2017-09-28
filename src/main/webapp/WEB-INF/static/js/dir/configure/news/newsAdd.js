$(function(){
	
	$("#addPicDiv").html("");
    $("#addTitleDiv").html("");
    //富文本编辑器
    UE.getEditor('editor',{elementPathEnabled:false})
    UE.getEditor('editor').setContent('');
    
    
    
  //新增界面，选择图片绑定change事件
    $("#choosePic").on("change", function () {
        var picUrl = this.value;
        var picType = picUrl.split(".");
        picType = picType[picType.length - 1];
        if ("jpg" != picType && "png" != picType && "jpeg" != picType && "gif" != picType
            && "JPG" != picType && "PNG" != picType && "JPEG" != picType && "GIF" != picType) {
            $.bootstrapDialog.tip("非图片类型，请重新选择！！");
            $("#choosePic").val("");//防止将非图片类型上传
            return;
        }
        if (this.files && this.files[0]) {
            //验证图片的大小
            var fileSize = this.files[0].size;
            if(fileSize > 1024*1024*10){
                $.bootstrapDialog.tip("上传图片大小不能超过10M");
                $("#choosePic").val("");
                return;
            }
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要以下方式
            $("#imgDiv").css("display", "block");
            $("#showImg").attr("src", window.URL.createObjectURL(this.files[0]));
        } else {
            //IE下，使用滤镜
            this.select();
            var imgSrc = document.selection.createRange().text;
            //必须设置初始大小
            $("#imgDiv").css("width", "300px");
            $("#imgDiv").css("height", "200px");
            //图片异常的捕捉，防止用户修改后缀来伪造图片
            try {
                $("#imgDiv").attr("filter", "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)");
                $("#imgDiv").filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch (e) {
                $.bootstrapDialog.tip("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            $("#showImg").css("display", "none");
            document.selection.empty();
        }
        //$("#uploadButton").css("display", "block");
        $("#addPicDiv").html("");
        $("#picNote").css("display","none");
        return true;
    });
    
    
  //新增界面点击保存按钮，上传图片相关信息
    $('#uploadButton').on('click', function () {
        $('#uploadButton').attr("disabled", true);
        var form = $("#uploadPicForm");
        var options = {
            url: CONTEXT_PATH + '/admin/Pic_uploadPic',
            type: 'post',
            beforeSubmit : function(formData, jqForm, options){
                for(var i= 0,ii=formData.length;i<ii;i++){
                    var data = formData[i];
                    var fieldName = data["name"];
                    var fieldValue = data["value"];
                    if(fieldName == "file"){
                        if(fieldValue == ""){
                            var requireHtml='<ul class="parsley-errors-list filled" id="parsley-id-22"><li class="parsley-required">请上传图片</li></ul>';
                            $("#addPicDiv").html(requireHtml);
                            $('#uploadButton').removeAttr("disabled");
                            return false;
                        }
                    }else if(fieldName == "pic_title"){
                        if(fieldValue == ""){
                            var requireHtml='<ul class="parsley-errors-list filled" id="parsley-id-22"><li class="parsley-required">请填写标题</li></ul>';
                            $("#addTitleDiv").html(requireHtml);
                            $("#pic_title").focus();
                            $('#uploadButton').removeAttr("disabled");
                            return false;
                        }
                    }

                }
            },
            success: function (data) {
                var jsondata = eval("(" + data + ")");
                if (jsondata.code == "OK") {
                    $.bootstrapDialog.tip(jsondata.message);
                    $("#uploadButton").removeAttr("disabled");
                    $('#modal-add').modal('hide');
                    initPage();
                } else {
                    $.bootstrapDialog.tip(jsondata.message);
                    $("#uploadButton").removeAttr("disabled");
                }
            }
        };
        form.ajaxSubmit(options);
    });
    
});