/**
 * Created by zhanf on 2017/4/28.
 */
jQuery(document).ready(function () {
    var newsId = $("#newsId").val();
    
    initUserTypeList();
    initDeptSelectDataList();
    initRoleNameList();
    initFormerDate(newsId);
    $("#editPicName").css("display","inline-block");
    $("#editChoosePic").css("display","none");
    $("#editPicNote").css("display","none");
    
    $('#editChangePicButton').click(function () {
        $("#editPicName").css("display","none");
        $("#editChangePicButton").css("display","none");
        $("#editImgDiv").css("display","none");
        $("#editShowImg").attr("src", "");
        $("#editChoosePic").css("display","inline-block");
        $("#editPicNote").css("display","inline");
    });
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
function initFormerDate(newsId) {
    $.commonAjax({
        url: basePathJS + "/dirNews/editLoad",
        data: {id:newsId},
        success: function (result) {
            if (result.state) {
                var vo = result.content.vo;
                if(vo){
                	$("#editPicName").html(vo.picName);                	
                    $("#edit_pic_order").val(vo.picOrder);
                    $("#edit_pic_title").val(vo.title);
//                    $("#pic_content").val(vo.picContent);   
                    var ue = UE.getEditor('edit_pic_content');
                    ue.addListener("ready", function () { 
                    	 ue.setContent(vo.newsContent);
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