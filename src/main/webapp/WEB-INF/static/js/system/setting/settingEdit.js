$(document).ready(function(){
    initEditPage();
});

//初始化编辑界面
function initEditPage(){
    var params = {id : $("#settingId").val()};
    $.post(basePathJS + "/system/setting/editLoad",
        params,
        function(data){
            if(data && data.content && data.content.vo){
                var vo = data.content.vo;
                $("#settingCode").val(vo.settingCode);
                $("#settingName").val(vo.settingName);
                $("#settingValue").val(vo.settingValue);
                $("#regionCode").val(vo.regionCode);
                $("#settingDesc").val(vo.settingDesc);
                var status_selector = $("input[name='status']");
                vo.status == 1 ? status_selector.get(0).checked=true : status_selector.get(1).checked=true;
            }
        }
    );
}
function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    return true ;
}

function runAfterSubmitSuccess(response) {
    console.log("runAfterSubmitSuccess");
    //刷新主页面
    parent.reloadTable();
}

function runAfterSubmit(response) {
    console.log("runAfterSubmit");
}