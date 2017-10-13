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
                $("#regionName").val(vo.regionName);
                $("#regionCode").val(vo.regionCode);
                $("#fid").val(vo.fid);
                $("#deptCode").val(vo.deptCode);
                $("#fname").val(vo.fname);
                $("#deptName").val(vo.deptName);
                $("#deptShortName").val(vo.deptShortName)
                $("#deptAlias").val(vo.deptAlias)
                $("#deptListingName").val(vo.deptListingName);
                $("#deptDesc").val(vo.deptDesc);
                $("#functionKeyword").val(vo.functionKeyword);
                $("#deptFunction").val(vo.deptFunction);
                // $("#pid").val(vo.pid).trigger("change");
                $("#deptResponseMan").val(vo.deptResponseMan);
                $("#deptResponsePhone").val(vo.deptResponsePhone);
                $("#deptResponseEmail").val(vo.deptResponseEmail);
                $("#deptContactMan").val(vo.deptContactMan);
                $("#deptContactDept").val(vo.deptContactDept);
                $("#deptContactPost").val(vo.deptContactPost);
                $("#deptContactPhone").val(vo.deptContactPhone);
                $("#deptContactFixedPhone").val(vo.deptContactFixedPhone);
                $("#deptContactEmail").val(vo.deptContactEmail);
                $("#deptAddress").val(vo.deptAddress);
                $("#orgLongitude").val(vo.orgLongitude);
                $("#orgLatitude").val(vo.orgLatitude);
                $("#orderNumber").val(vo.orderNumber);
                $("#validateFrom").val(vo.validateFromStr);
                $("#validateTo").val(vo.validateToStr);
                // $("#icon").text(vo.icon);
                $("#inlineRadio"+vo.status).attr("checked", true);
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