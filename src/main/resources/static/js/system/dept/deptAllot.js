/**
 * Created by zhanf on 2017/4/28.
 */
$(document).ready(function(){
    initEditPage();
});


//初始化编辑界面
function initEditPage(){
    var params = {id : $("#deptId").val()};
    $.post(basePathJS + "/system/dept/editLoad",
        params,
        function(data){
            if(data && data.content && data.content.vo){
                var vo = data.content.vo;
                $("#regionName").val(vo.regionName);
                $("#regionCode").val(vo.regionCode);
                $("#fname").val(vo.deptName);

            }
        }
    );
}

function getPinyin() {
    var deptName=$("#deptName").val();
    if(deptName){
        $.commonAjax({
            url: basePathJS + "/system/dept/getPinyin",
            data: {cnName: deptName},
            success: function (result) {
                $("#pinyin").val(result);
            }
        });
    }

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