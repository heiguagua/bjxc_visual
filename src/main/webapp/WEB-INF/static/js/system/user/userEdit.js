/**
 * Created by zhanf on 2017/4/28. 1
 */
jQuery(document).ready(function () {
    var userId = $("#userId").val();

    initUserTypeList();
    initRoleNameList();
    initFormerDate(userId);
});

function initUserTypeList(){
    $.commonAjax({
        url: basePathJS + "/enums/UserType",
        async:false,
        success: function (result) {
            $("#userType").select2({data: result});
        }
    });
}

function initDeptSelectDataList(){
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

//初始化用户信息
function initFormerDate(userId) {
    $.commonAjax({
        url: basePathJS + "/system/user/loadEditData",
        data: {id:userId},
        success: function (result) {
            if (result.state) {
                var user = result.content.user;
                if(user){

                    $("#userName").val(user.userName);
                    $("#realName").val(user.realName);
                    $("#userType").val(user.userType).trigger("change");
                    $("#telephoneNumber").val(user.telephoneNumber);
                    $("#cellPhoneNumber").val(user.cellPhoneNumber);
                    $("#regionCode").val(user.regionCode);
                    $("#deptName").val(user.deptName);
                    $("#email").val(user.email);
                    // $("#deptId").val(user.deptId).trigger("change");
                    $("#roleIds").val(user.roleIds).trigger("change");

                    $("#userDesc").val(user.userDesc);

                    var status = user.status;
                    if (status == 1) {
                        $("#status1").click();
                    }
                    if (status == 0) {
                        $("#status0").click();
                    }
                }
            }
        }
    });
}
//加载角色菜单列表
function initRoleNameList(){
    $.commonAjax({
        url: basePathJS + "/system/role/getRoleNameList",
        success: function (result) {
            if (result.state) {
                var roleNames = result.content.selectData;
                $("#roleIds").select2({
                    data: roleNames
                });
            }
        }
    });
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