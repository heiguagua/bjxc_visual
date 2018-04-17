/**
 * Created by zhanf on 2017/4/28. 1
 */
var isMaster={};
jQuery(document).ready(function () {
    var userId = $("#userId").val();
    isMaster=$("#masterId").val()
    initUserTypeList();
    initRoleNameList();
    initFormerDate(userId);

    if(isMaster==="true"){
        $.initUserRegionTreeSelect('treeRegionDemo','regionName','regionCode', 'menuRegionContent'); //初始化区域机构下拉框
    }
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

function getPinyin() {
    $.getPinyin("realName","pinyin");
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
                    var token = user.token;
                    $("#token").val(token);
                    if(token==undefined || token=="" || token==null){
                        $("#createToken").removeAttr("disabled");
                    }
                    $("#userName").val(user.userName);
                    $("#realName").val(user.realName);
                    $("#userType").val(user.userType).trigger("change");
                    $("#telephoneNumber").val(user.telephoneNumber);
                    $("#cellPhoneNumber").val(user.cellPhoneNumber);

                    $("#email").val(user.email);
                    // $("#deptId").val(user.deptId).trigger("change");
                    $("#roleIds").val(user.roleIds).trigger("change");

                    $("#userDesc").val(user.userDesc);
                    $("#pinyin").val(user.pinyin);

                    var status = user.status;
                    if (status == 1) {
                        $("#status1").click();
                    }
                    if (status == 0) {
                        $("#status0").click();
                    }


                        $('#regionName').val(user.regionName);
                        $('#regionCode').val(user.regionCode);
                    if(isMaster==="true") {
                        initDeptTreeSelect('treeDemo','deptName','deptId','menuContent',user.regionCode);


                    }else{
                        $("#realName,#userType,#telephoneNumber,#cellPhoneNumber,#email,#userDesc,#pinyin,#regionName,#regionCode,#deptName,#deptId").attr("readonly",true);
                        $("#status1,#status0").attr("disabled",true);
                        $("#pinyinBtn").attr("disabled",true);
                        // $("#deptName").val(user.deptName)
                        // $("#deptId").val(user.deptId);
                    }
                    $("#deptName").val(user.deptName);
                    $("#deptId").val(user.deptId);
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

function initDeptTreeSelect(treeDomId, nameInputDomId, codeInputDomId, treeDivDomId,dd, multiple) {
    $("#" + nameInputDomId).val("");
    $("#" + codeInputDomId).val("");
    var selectIds = "";
    var setting = {
        async: {
            enable: true,
            url: basePathJS + "/system/dept/getDeptSelectDataList?regionCode=" + dd + "&onlyLoginUserDept=1",
            autoParam: ["id", "deptLevel"],
            dataFilter: function (treeId, parentNode, childNodes) {//过滤数据库查询出来的数据为ztree接受的格式
                var params = [];
                var nodeObjs = childNodes.content.selectData;
                if (!nodeObjs) {
                    return null;
                }
                for (var i in nodeObjs) {
                    params[i] = {
                        'id': nodeObjs[i].id,
                        'name': nodeObjs[i].deptName,
                        'deptLevel': nodeObjs[i].deptLevel,
                        'isParent': (nodeObjs[i].isLeaf ? false : true),
                        'nocheck': nodeObjs[i].deptLevel == 1
                    }
                }
                return params;
            }
        },
        check: {enable: true,chkStyle: "radio",chkboxType: { "Y":"s","N":"s"},radioType: "all"},
        callback: {
            beforeClick: function (treeId, treeNode) { //如果点击的节点还有下级节点，则展开该节点
                var zTreeObj = $.fn.zTree.getZTreeObj(treeDomId);
                if (treeNode.isParent) {
                    if (treeNode.open) {
                        zTreeObj.expandNode(treeNode, false);
                    } else {
                        zTreeObj.expandNode(treeNode, true);
                    }
                    return false;
                } else {
                    return true;
                }
            },
            onCheck: function (e, treeId, treeNode) { //选中节点，获取区域类别的名称，显示到输入框中
                $('#' + nameInputDomId).val(treeNode.name);
                if(multiple){
                    if (selectIds == "") {
                        selectIds = treeNode.id;
                    } else {
                        selectIds += "," + treeNode.id;
                    }
                }else{
                    selectIds = treeNode.id;
                }
                $('#' + codeInputDomId).val(selectIds);
            }
        }
    };
    $.fn.zTree.init($("#" + treeDomId), setting);
    $('#' + nameInputDomId).click(function () {
        var cityOffset = $("#" + nameInputDomId).offset();
        $("#" + treeDivDomId).css({
            left: cityOffset.left + "px",
            top: cityOffset.top + $("#" + nameInputDomId).outerHeight() + "px"
        }).slideDown("fast");
        $("body").bind("mousedown", function (event) {
            if (!(event.target.id == "menuBtn" || event.target.id == treeDivDomId || $(event.target).parents("#" + treeDivDomId).length > 0)) {
                $("#" + treeDivDomId).fadeOut("fast");
                $("body").unbind("mousedown");
            }
        });
    })

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

$(function(){
    $("#createToken").click(function() {
        var id = $("#userId").val();
        var userName = $("#userName").val();
        $.commonAjax({
            url: basePathJS + "/system/user/createToken",
            data: {id:id,userName:userName},
            success: function (result) {
                if (result.state) {
                    var token = result.content.token;
                    $("#token").val(token);
                    $("#createToken").attr("disabled","disabled");
                }
            }
        });
    });
});