/**
 * Created by Zhangm on 2017/10/10.
 */
jQuery(document).ready(function () {
    $("#regionCodse").change(function(){
        var value = $(this).val();
        if(value == '0'){
            $("#regionName").hide();
        }else if(value == '1'){
            $("#regionName").show();
        }
        $("#regionName").val("");
        $("#regionCode").val("");
    });
    initRegionSelect();  //初始化适用范围下拉框
});

function initRegionSelect() {
    $.initRegionTreeSelect('treeDemo','regionName','regionCode','menuContent'); //初始化区域分类下拉框
}
function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    var  val = $("#dictCode").val();
    var val1 = $("#dictName").val();
    var val2 = $("#orderNumber").val();
    if(!val){
        alert("配置项编码不能为空");
        return false;
    } else if (!val1){
        alert("配置项名称不能为空")
        return false;
    }else if (!val2){
        alert("顺序不能为空")
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