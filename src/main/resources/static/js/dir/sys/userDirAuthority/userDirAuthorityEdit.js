/**
 * Created by Zhangm on 2017/9/28.
 */
jQuery(document).ready(function () {
    initSelectData();
});

function initSelectData() {
    var authObjId = $("#authObjId").val();
    var selects = [];
    var all=[];
    $.get(basePathJS + "/system/userDirAuthority/editLoad?id=" + authObjId ,function(data){
        var dd = data.content.selected;
        all = data.content.selected2;
        if(dd.length){
            for(var i= 0;i < dd.length;i++){
                var obj = dd[i];
                selects.push({id: obj.classifyId, fid: obj.fid, name: obj.classifyName});
            }
        }
        $.initClassifyTreeSelect2('treeDemo','','classifyIds', 'menuContent', true, null, selects,all,"user",authObjId);
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
