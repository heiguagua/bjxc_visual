/**
 * Created by zhanf on 2017/4/28.
 */
jQuery(document).ready(function () {
    var apiId = $("#apiId").val();

    initUserTypeList();
    initDeptSelectDataList();
    initRoleNameList();
    initFormerDate(apiId);
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
function initFormerDate(apiId) {
    $.commonAjax({
        url: basePathJS + "/dirDevelopApis/editLoad",
        data: {id:apiId},
        success: function (result) {
            if (result.state) {
                var vo = result.content.vo;
                if(vo){
                	if(vo.isShow==1){
                		$("#Eis_show").append("<div class='redio-box'>" +
                        "<input type='radio' name='isShow'  value='0' ><span></span>" +
	                    "</div>"+
	                    "<label style='display:inline-block'>否</label>" +
	                    "<div class='redio-box'>" +
	                    "<input type='radio' name='isShow'  value='1' checked><span></span>"+
						"</div>"+
	                    "<label style='display:inline-block'>是</label>")
                	}else{
                		$("#Eis_show").append("<div class='redio-box'>" +
                                "<input type='radio' name='isShow'  value='0' checked><span></span>" +
        	                    "</div>"+
        	                    "<label style='display:inline-block'>否</label>" +
        	                    "<div class='redio-box'>" +
        	                    "<input type='radio' name='isShow' value='1'><span></span>"+
        						"</div>"+
        	                    "<label style='display:inline-block'>是</label>")
                	}
              
                	
                    $("#Eapi_name").val(vo.apiName);
                    $("#Eapi_category").val(vo.apiCategory);
                    $("#Eapi_url").val(vo.apiUrl);
                    $("#Eorder_number").val(vo.orderNumber);
                    $("#Eapi_desc").val(vo.apiDesc);                 

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