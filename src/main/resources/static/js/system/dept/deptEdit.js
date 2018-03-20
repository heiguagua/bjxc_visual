/**
 * Created by zhanf on 2017/4/28. 1
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

function getPinyin() {
    var deptName=$("#deptName").val();
    if(deptName){
        $.commonAjax({
            url: basePathJS + "/system/dept/getPinyin",
            data: {cnName: deptName},
            success: function (result) {
                $("#pinyin").val(result);
            }
        });
    }

}

//初始化编辑界面
function initEditPage(){
    var params = {id : $("#deptId").val()};
    $.post(basePathJS + "/system/dept/editLoad",
        params,
        function(data){
            debugger;
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
                $("#pinyin").val(vo.pinyin);
                $("#deptType").val(vo.deptType);
                // $("#icon").text(vo.icon);
                $("#inlineRadio"+vo.status).attr("checked", true);

                var items=vo.items;
                $.each(items, function(index, value) {
                    var select1=value.contactsType==="普通人"?"selected":"";
                    var select2=value.contactsType==="负责人"?"selected":"";
                    $("#dataitemList").append('<tr id="tr_'+index+'">' +
                        '<td><input type="checkbox" trNum='+index+' id="index" name="index" ></td>' +
                        '<td><select type="text" class="form-control" id="contactsType" name="items['+index+'].contactsType" data-rule="required"><option value="负责人" '+select2+'>负责人</option><option value="普通人" '+select1+'>普通人</option></select></td>' +
                        '<td><input type="text" class="form-control" id="contactsName" name="items['+index+'].contactsName" data-rule="length(~32)" value="'+value.contactsName+'"></td>' +
                        '<td><input type="text" class="form-control" id="contactsDept" name="items['+index+'].contactsDept" data-rule="length(~18)" value="'+value.contactsDept+'"></td>' +
                        '<td><input type="text" class="form-control" id="contactsPost" name="items['+index+'].contactsPost" data-rule="length(~18)" value="'+value.contactsPost+'"></td>' +
                        '<td><input type="text" class="form-control" id="contactsFixedPhone" name="items['+index+'].contactsFixedPhone" data-rule="tel" value="'+value.contactsFixedPhone+'"></td>' +
                        '<td><input type="text" class="form-control" id="contactsPhone" name="items['+index+'].contactsPhone" data-rule="mobile" value="'+value.contactsPhone+'"></td>' +
                        '<td><input type="text" class="form-control" id="contactsEmail" name="items['+index+'].contactsEmail" data-rule="email" value="'+value.contactsEmail+'"></td>' +
                        '<td><input type="hidden" class="form-control" id="id" name="items['+index+'].id"  value="'+value.id+'" ></td>' +
                        '<td><input type="hidden" class="form-control" id="curDeptId" name="items['+index+'].curDeptId"  value="'+value.curDeptId+'" ></td>' +
                        '</tr>')
                });
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