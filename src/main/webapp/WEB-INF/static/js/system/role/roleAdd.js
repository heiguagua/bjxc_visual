/**
 * Created by lenovo on 2017/5/9. 1
 */
$(document).ready(function(){
    $.commonAjax({
        url: basePathJS + "/system/role/getRoleLevelList",
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                $("#roleLevel").select2({
                    data: selectData
                });
            }
        }
    });

});
function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    var  val = $("#roleLevel").val();
    if(!val){
        layer.msg("请选择角色级别");
        return false;
    }
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