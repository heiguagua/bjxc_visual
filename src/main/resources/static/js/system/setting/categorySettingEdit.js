(function () {
	require(['jquery','global_custom'],function($){
    initEditPage();
    })
}());


//初始化编辑界面 1
function initEditPage(){
    var params = {categoryCode : $("#categoryCode").val()};
    $.post(basePathJS + "/system/setting/categoryEditLoad",
        params,
        function(data){
            if(data && data.content && data.content.vo){
                var vo = data.content.vo;
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