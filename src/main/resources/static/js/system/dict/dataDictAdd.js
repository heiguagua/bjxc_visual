/**
 * Created by Zhangm on 2017/10/10.
 */

function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    var  val = $("#categoryCode").val();
    if(!val){
        layer.msg("请输入类型编码");
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