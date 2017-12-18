/**
 * Created by lixy on 2017/6/15.
 */
$(function () {
    jQuery(document).ready(function(){
        initButtonClickEvent();
        addEnterListener();
    })

    function addEnterListener() {
        $(document).keydown(function (event) {
            if (event.keyCode == 13) {
                $("#loaded").click();
            }
        });
    }

    function initButtonClickEvent(){
        $("#loaded").on("click",function(){
            $("#fromid").isValid(function (ret) {
                if(ret){
                    var paramData = {userName:$("#userLoadName").val(),
                        password:$.md5($("#password").val()),
                        return_url:$("#return_url").val()};
                    if($("#captchaDiv").is(":visible")){
                        paramData["captcha"]=$("#captcha").val();
                    }
                    $.commonAjax({
                        url:basePathJS + "/login/doLogin",
                        data:paramData,
                        success:function(result){
                            if(result.state){
                                var index = basePathJS + result.content.return_url;
                                window.location = index;
                            }else{
                                $("#loginerror-message").text(result.msg);
                                $("#loginerror").show();
                                $('#change_code').click();
                            }
                        }
                    })
                }
            })

        });
    }

    /*$("form").submit(function () {
     $("input[name='password']").val($.md5($("#password").val()));
     });*/
});