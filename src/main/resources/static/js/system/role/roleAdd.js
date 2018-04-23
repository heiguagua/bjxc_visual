/**
 * Created by lenovo on 2017/5/9. 1
 */
(function () {
	require(['jquery','global_custom','select2','select2.lang'],function($){
    $.commonAjax({
        url: basePathJS + "/system/role/getRoleLevelList",
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                $("#roleLevel").select2({
                    data: selectData,
                    minimumResultsForSearch:-1
                });
            }
        }
    });
	})
}());

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
    parent.authRole(response.response.content.roleId);
}