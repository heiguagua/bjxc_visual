/**
 * 修改用户密码 1
 */
function changePassword(id) {
    update('修改密码', basePathJS + '/system/me/changePwd');
}
function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    return true ;
}

function runAfterSubmitSuccess(response) {
    console.log("runAfterSubmitSuccess");
    window.top.location.href = basePathJS + "/login/logout"
}

function runAfterSubmit(response) {
    console.log("runAfterSubmit");
}
