(function () {
	require(['jquery','global_custom'],function($){
    initSelectData();
    })
}());


function initSelectData() {
    $.initRegionTreeSelect('treeRegionDemo','fname','fcode','menuRegionContent','','','region'); //初始化区域分类下拉框
}


function getPinyin() {
    $.getPinyin("regionName","pinyin");
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