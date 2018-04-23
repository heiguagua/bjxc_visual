/**
 * Created by Zhangm on 2017/9/28.
 */
(function () {
	require(['jquery','global_custom'],function($){
		initSelectData();
	})
}());

function initSelectData() {
    var authObjId = $("#authObjId").val();
    var authType = $("#authType").val();
    var selects = [];
    var all=[];
    var disabledSelectIds=[];
    $.get(basePathJS + "/system/userAuthority/editLoad?id=" + authObjId + "&authType=" + authType,function(data){
        var dd = data.content.selected;
        all = data.content.selected2;
        if(dd.length){
            for(var i= 0;i < dd.length;i++){
                var obj = dd[i];
                // if(authType === "dir"){
                //     selects.push({id: obj.classifyId, fid: obj.fid, name: obj.classifyName});
                // }
                // if(authType === "dept"){
                    selects.push({id: obj.deptId, fid: obj.fid, name: obj.deptName});
                // }
                if(obj.authObjType==='1'){
                    disabledSelectIds.push(obj.deptId);
                }
            }
        }
        // if(authType === 'dept'){
            $.initDeptTreeSelect('treeDemo','','deptIds', 'menuContent', true, {withoutUserDept: authObjId, withoutAuthDept: "1"}, selects,'','',all,disabledSelectIds); //初始化组织机构下拉框
        // }else if(authType === 'dir'){
        //     $.initClassifyTreeSelect2('treeDemo','','classifyIds', 'menuContent', true, null, selects);
        // }
    });
}



function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    return true;
}

function runAfterSubmitSuccess(response) {
    console.log("runAfterSubmitSuccess");
    //刷新主页面
    parent.reloadTable();
}

function runAfterSubmit(response) {
    console.log("runAfterSubmit");
}
