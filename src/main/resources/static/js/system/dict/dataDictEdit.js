/**
 * Created by Zhangm on 2017/9/28.
 */

$(document).ready(function(){
    initEditPage();
});

//初始化编辑界面
function initEditPage(){
    var params = {id : $("#categoryId").val()};
    $.get(basePathJS + "/sysDict/editLoad?id="+params.id,
        function(data){
            if(data && data.content && data.content.vo){
                var vo = data.content.vo;
                $("#categoryCode").val(vo.categoryCode);
                $("#categoryName").val(vo.categoryName);
                $("#categoryDesc").val(vo.categoryDesc);
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
