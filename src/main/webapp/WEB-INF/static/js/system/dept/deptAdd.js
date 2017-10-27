/**
 * Created by zhanf on 2017/4/28. 1
 */
jQuery(document).ready(function () {
    initSelectData();
});

function initSelectData() {
    $.initRegionTreeSelect('treeDemo','regionName','regionCode','menuContent'); //初始化区域分类下拉框
    // initDeptSelectDataList();
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