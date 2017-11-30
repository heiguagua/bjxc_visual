/**
 * Created by zhanf on 2017/4/28.
 */
jQuery(document).ready(function () {
    var authAuditId = $("#authAuditId").val();
    initAuditPage(authAuditId);
});


//初始化用户信息
function initAuditPage(authAuditId) {
    $.commonAjax({
        url: basePathJS + "/system/deptAuthorityAudit/editLoad",
        data: {id:authAuditId},
        success: function (result) {
            if (result.state) {
                var vo = result.content.vo;
                if(vo){
                    $("#applicantName").html(vo.applicantName);
                    $("#deptName").html(vo.deptName);
                    $("#applyReason").html(vo.applyReason);
                    // $("#applicantName").val(vo.applicantName);
                    // $("#deptName").val(vo.deptName);
                    // $("#applyReason").val(vo.applyReason);
                }
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