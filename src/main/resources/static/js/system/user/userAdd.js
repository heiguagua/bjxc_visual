/**
 * Created by zhanf on 2017/4/28. 1
 */

jQuery(document).ready(function () {
    $(window).load(function(){
        $("#userName").val("");
        $("#password").val("");
    });
    initSelectData();
});

function initSelectData() {

    $.initUserRegionTreeSelect('treeRegionDemo','regionName','regionCode', 'menuRegionContent'); //初始化区域机构下拉框
    initUserTypeList();
    initRoleNameList();

}

function getPinyin() {
    $.getPinyin("realName","pinyin");
}

function initUserTypeList() {
    $.commonAjax({
        url: basePathJS + "/enums/UserType",
        async: false,
        success: function (result) {
            $("#userType").select2({data: result});
        }
    });
}

function initDeptSelectDataList() {
    $.commonAjax({
        url: basePathJS + "/system/dept/getDeptSelectDataList",
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                $("#deptId").select2({
                    data: selectData
                });
            }
        }
    });
}

function initRoleNameList() {
    $.commonAjax({
        url: basePathJS + "/system/role/getRoleNameList",
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                $("#roleIds").select2({
                    data: selectData
                });
            }
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