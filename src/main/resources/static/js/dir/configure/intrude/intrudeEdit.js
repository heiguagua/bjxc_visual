/**
 * Created by zhanf on 2017/4/28.
 */
jQuery(document).ready(function () {
    var IntrudeId = $("#IntrudeId").val();

    UE.getEditor('Eeditor',{elementPathEnabled:false})
//    initUserTypeList();
//    initDeptSelectDataList();
//    initRoleNameList();
    window.DictData = new dict();
    initFormerDate(IntrudeId);
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
function initFormerDate(IntrudeId) {
  $.commonAjax({
      url: basePathJS + "/dirIntrude/editLoad",
      data: {id:IntrudeId},
      success: function (result) {
          if (result.state) {
              var vo = result.content.vo;
              if(vo){
            	  
            	  var ue = UE.getEditor('Eeditor');
                  ue.addListener("ready", function () { 
                  	 ue.setContent(vo.content);
                  });              
                  $("#Ecategory").append(DictData.selectsDom("categoryIntrude",vo.category?vo.category:''));                 
              
              }
          }
      }
  });
}
//加载角色菜单列表
//function initRoleNameList(){
//    $.commonAjax({
//        url: basePathJS + "/system/role/getRoleNameList",
//        success: function (result) {
//            if (result.state) {
//                var roleNames = result.content.selectData;
//                $("#roleIds").select2({
//                    data: roleNames
//                });
//            }
//        }
//    });
//}

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