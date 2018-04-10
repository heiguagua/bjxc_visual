$(document).ready(function(){
    initGuidDeptList();
});


function initGuidDeptList() {
    var ret=$("#curDeptId").val();
    $.get(basePathJS + "/sysGuidDept/guidLoad?curDeptId=" + ret,function(data){
        var dd = data.content.selected;
        var selectedDept = data.content.selectedDept;
        $.get({
            url: basePathJS + "/sysGuidDept/getfRegionCodeByDeptId?deptId="+ret,
            success: function (result) {
                initDeptTreeSelect('treeDemo','deptName','deptId','menuContent',result);
                if(dd){
                    $("#id").val(dd.id);
                    $("#deptId").val(dd.guidDeptId);
                    $("#deptName").val(selectedDept.deptName);
                }

            }
        });
    });

}

function initDeptTreeSelect(treeDomId, nameInputDomId, codeInputDomId, treeDivDomId,dd, multiple) {
    $("#" + nameInputDomId).val("");
    $("#" + codeInputDomId).val("");
    var selectIds = "";
    var setting = {
        async: {
            enable: true,
            url: basePathJS + "/system/dept/getDeptSelectDataList?fRegionCode=" + dd ,
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


