/**
 * Created by Zhangm on 2017/9/28.
 */
jQuery(document).ready(function () {
    initSelectData();
});

function initSelectData() {
    var authObjId = $("#authObjId").val();
    var authType = $("#authType").val();
    var selects = [];
    $.get(basePathJS + "/system/deptAuthority/editLoad?id=" + authObjId + "&authType=" + authType,function(data){
        var dd = data.content.selected;
        if(dd.length){
            for(var i= 0;i < dd.length;i++){
                if(authType === "dir"){
                    selects.push(dd[i].classifyId);
                }
                if(authType === "dept"){
                    selects.push(dd[i].deptId);
                }
            }
        }
        if(authType === 'dept'){
            $.initDeptTreeSelect('treeDemo','','deptIds', 'menuContent', true, {withoutDept: authObjId}, selects); //初始化组织机构下拉框
        }else if(authType === 'dir'){
            $.initClassifyTreeSelect2('treeDemo','','classifyIds', 'menuContent', true, null, selects);
        }
    });
}

function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    return true;
}

function runAfterSubmitSuccess(response) {
    console.log("runAfterSubmitSuccess");
    //刷新主页面
    parent.reloadTable();
}

function runAfterSubmit(response) {
    console.log("runAfterSubmit");
}
