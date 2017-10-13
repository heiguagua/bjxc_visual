/**
 * Created by lenovo on 2017/5/9.
 */
$(document).ready(function(){
    $("#roleLevel").select2({
        data: [
            {id: "1", text: "1"},
            {id: "2", text: "2"},
            {id: "3", text: "3"},
            {id: "4", text: "4"},
            {id: "5", text: "5"}
        ]
    })
});
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