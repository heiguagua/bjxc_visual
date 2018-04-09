$(document).ready(function(){
    initGuidDeptList();
});


function initGuidDeptList() {
    var ret=$("#curDeptId").val();
    var selects = [];
    $.get(basePathJS + "/sysGuidDept/guidLoad?curDeptId=" + ret,function(data){
        console.log(data);
        var dd = data.content.selected;
        if(dd.length){
            for(var i= 0;i < dd.length;i++){
                var obj = dd[i];
                selects.push({id: obj.guidDeptId});
            }
        }
        $.get({
            url: basePathJS + "/sysGuidDept/getfRegionCodeByDeptId?deptId="+ret,
            success: function (result) {
                console.log(result);
                $.initDeptTreeSelect('treeDemo','','deptIds', 'menuContent', true, {fRegionCode: result}, selects,'','','','');
            }
        });
    });

}
