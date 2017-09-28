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
                // $("#fid").val(vo.fid);
                // $("#deptCode").val(vo.deptCode);
                $("#fname").val(vo.fname);

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