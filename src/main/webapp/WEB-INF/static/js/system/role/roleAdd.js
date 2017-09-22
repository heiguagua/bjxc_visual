/**
 * Created by lenovo on 2017/5/9.
 */

function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    var  val = $("#roleLevel").val();
    if(!val){
        alert("请选择角色级别");
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