/**
 * Created by zhanf on 2017/4/28.
 */
jQuery(document).ready(function () {
    var policyId = $("#policyId").val();

    UE.getEditor('Eeditor',{elementPathEnabled:false})
    initUserTypeList();
    initDeptSelectDataList();
    initRoleNameList();
    initFormerDate(policyId);
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
function initFormerDate(policyId) {
    $.commonAjax({
        url: basePathJS + "/portalConfig/dirPolicy/editLoad",
        data: {id:policyId},
        success: function (result) {
            if (result.state) {
                var vo = result.content.vo;
                if(vo){

                    $("#Etitle").val(vo.title);
                    var l = vo.policyLevel;
                    $("#Etype-group").empty();
                    if(l=='G'){
                    	$("#Etype-group").append('<input type="radio" checked name="policyLevel" value="G">国家级</input><input type="radio" name="policyLevel" value="S">省级</input><input type="radio" name="policyLevel" value="C">市级</input>')
                    }else if(l=='S'){
                    	$("#Etype-group").append('<input type="radio" name="policyLevel" value="G">国家级</input><input type="radio" checked name="policyLevel" value="S">省级</input><input type="radio" name="policyLevel" value="C">市级</input>')                    	
                    }else if(l=='C'){                    	
                    	$("#Etype-group").append('<input type="radio" name="policyLevel" value="G">国家级</input><input type="radio" name="policyLevel" value="S">省级</input><input type="radio" checked name="policyLevel" value="C">市级</input>')
                    }
                    var ue = UE.getEditor('Eeditor');
                    ue.addListener("ready", function () { 
                    	 ue.setContent(vo.content);
                    });
                                                            

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