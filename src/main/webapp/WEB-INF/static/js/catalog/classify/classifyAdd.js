/**
 * Created by zhanf on 2017/4/28.
 */

jQuery(document).ready(function () {
//	 var parentId = $("#parentId").val();
	 var fid = $("#fid").val();
     initSelectData();
     checkDep(fid);
     window.Dict=new dict1();
     window.DictData = new dict();
     initAllSelect();
     
});

function initAllSelect(){
	
	$.initNationalQueryClassifyTreeSelect('treeNational','nationalCode','dictNationalCode','menuNationalContent');
    Dict.selects('classify_icon',['#icon']);
    DictData.selects('dirClassifyCategory',['#classify_type']);
    
}
//	$(function(){
//		$(":radio").click(function(){
//		 	var val_depnode = $('#Dep input[name="depnode"]:checked').val();
//		     if(val_depnode == "yes"){
//		         $("#deptGroup").removeClass('hidden');
//		     }else if(val_depnode == "no"){   	
//		     	 $("#deptGroup").addClass('hidden');
//		     }
//		
//		 });
//		
//	 });
	
function initSelectData() {
	$.initDeptTreeSelect('treeDemo','deptName','deptId','menuContent');
    initUserTypeList();
    
//    initDeptSelectDataList();
//    initRoleNameList();
    
    
}



function initUserTypeList(){
    $.commonAjax({
        url: basePathJS + "/enums/UserType",
        async:false,
        success: function (result) {
            $("#userType").select2({data: result});
        }
    });
}

function checkDep(fid){
	$.commonAjax({	
        url: basePathJS + "/dirClassify/editLoad",
        data: {id:fid},
        success: function (result) {
            if (result.state) {
                var vo = result.content.vo;
                if(vo){                	
                	var ss = vo.classifyStructureName;
					if(ss.substr(0,10)=='政务部门信息资源目录'){
						 $("#deptGroup").removeClass('hidden');
						 $("#fname").val(vo.classifyName);
						 
					}else{
						$("#fname").val(vo.classifyName);
					}
					
                }
            }
        }
    	});
}
function initDeptSelectDataList(){
    $.commonAjax({
        url: basePathJS + "/system/dept/getDeptSelectDataList",
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                $("#DeptId").select2({
                    data: selectData
                });
            }
        }
    });
}

function initRoleNameList(){
    $.commonAjax({
        url: basePathJS + "/system/role/getRoleNameList",
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                $("#roleIds").select2({
                    data: selectData
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
//    parent.reloadTable();
}

function runAfterSubmit(response) {
    console.log("runAfterSubmit");
}