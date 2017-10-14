/**
 * Created by zhanf on 2017/4/28.
 */
jQuery(document).ready(function () {
    var classifyId = $("#classifyId").val();
    $.initDeptTreeSelect('treeDemo','deptName','deptId','menuContent');
//    initUserTypeList();
//    initDeptSelectDataList();
//    initRoleNameList();
    window.Dict1=new dict1();
    window.DictData = new dict();
    initFormerDate(classifyId);
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
function initFormerDate(classifyId) {
    $.commonAjax({
        url: basePathJS + "/dirClassify/editLoad",
        data: {id:classifyId},
        success: function (result) {
            if (result.state) {
                var vo = result.content.vo;
                if(vo){
                	$.initNationalQueryClassifyTreeSelect('EtreeNational','EnationalCode','EdictNationalCode','EmenuNationalContent');

                    $("#Eclassify_name").val(vo.classifyName);
                    if(vo.deptId == "" || vo.deptId==undefined){
                    	 $("#Edep").addClass('hidden');
                    }else{
                    	$("#Edep").removeClass('hidden');
                    }
                    $("#deptName").val(vo.deptName);
                    $("#Eorder_number").val(vo.orderNumber);
                    $("#deptId").val(vo.deptId);
                    $("#Eicon").append(Dict1.selectsDom("classify_icon",vo.iconName?vo.iconName:''));
//                    $("#Eclassify_type").append('<option value="'+vo.classifyType+'" >"'+vo.classifyType+'"</option>');
                    $("#EnationalCode").val(vo.nationalClassifyName);
                    $("#EdictNationalCode").val(vo.nationalCode);
                    $("#Eclassify_type").append(DictData.selectsDom("dirClassifyCategory",vo.classifyType?vo.classifyType:''));
                    
                    $("#Eclassify_desc").val(vo.classifyDesc);   
                    $("#EclassifyCode").val(vo.classifyCode);
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
function deleteUser(id) {
    var url = basePathJS + "/dirDevelopApis/delete";
    var parameter = {id: id};
    delObj(url , parameter) ;
}


function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    return true ;
}

function runAfterSubmitSuccess(response) {
    console.log("runAfterSubmitSuccess");
    //刷新主页面
//    parent.reloadTable();
}

function runAfterSubmit(response) {
    console.log("runAfterSubmit");
}