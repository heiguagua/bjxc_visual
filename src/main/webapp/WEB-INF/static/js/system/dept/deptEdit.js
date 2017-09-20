/**
 * Created by zhanf on 2017/4/28.
 */
$(document).ready(function(){
    // initSelectData();
    initEditPage();
});

function initSelectData() {
    initDeptSelectDataList();
}

function initDeptSelectDataList(){
    $.commonAjax({
        url: basePathJS + "/system/dept/getDeptSelectDataList",
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                $("#pid").select2({
                    data: selectData,
                    allowClear: true
                });
            }
        }
    });
}

//初始化编辑界面
function initEditPage(){
    var params = {id : $("#deptId").val()};
    $.post(basePathJS + "/system/dept/editLoad",
        params,
        function(data){
            if(data && data.content && data.content.vo){
                var vo = data.content.vo;
                $("#regionCode").val(vo.regionCode);
                $("#fcode").val(vo.fcode);
                $("#deptCode").val(vo.deptCode);
                $("#fname").val(vo.fname);
                $("#deptName").val(vo.deptName);
                $("#deptShortName").val(vo.deptShortName)
                $("#deptAlias").val(vo.deptAlias)
                $("#listingName").val(vo.listingName);
                $("#deptDesc").val(vo.deptDesc);
                $("#functionKeyword").val(vo.functionKeyword);
                $("#deptFunction").text(vo.deptFunction);
                // $("#pid").val(vo.pid).trigger("change");
                $("#deptResponseMan").text(vo.deptResponseMan);
                $("#deptResponseEmail").val(vo.deptResponseEmail);
                $("#deptContactMan").val(vo.deptContactMan);
                $("#deptContactDept").text(vo.deptContactDept);
                $("#deptContactPost").text(vo.deptContactPost);
                $("#deptContactPhone").text(vo.deptContactPhone);
                $("#deptContactFixedPhone").val(vo.deptContactFixedPhone);
                $("#deptContactEmail").val(vo.deptContactEmail);
                $("#deptAddress").text(vo.deptAddress);
                $("#orgLongitude").text(vo.orgLongitude);
                $("#orgLatitude").text(vo.orgLatitude);
                // $("#icon").text(vo.icon);
                $("#inlineRadio"+$("#status").text(vo.status)).attr("checked", true);
            }
        }
    );
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