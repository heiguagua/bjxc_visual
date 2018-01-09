$(document).ready(function(){
    initPage();
});

//初始化详情界面
function initPage(){
    var params = {id : $("#requirementId").val()};
    $.commonAjax({
        url: basePathJS + "/feedback/drapRequirementResources/loadDetail",
        data: params,
        success: function (result) {
            if (result.state) {
                var vo = result.content.vo;
                $("#requireName").val(vo.otherInfo);
                $("#providerDeptName").val(vo.providerDeptName);
                $("#requirementDeptName").val(vo.requirementDeptName);
                $("#demanderName").val(vo.demanderName);
                var type;
                if(1 == vo.requireType){
                    type = '手填';
                }
                if(2 == vo.requireType){
                    type = '资源';
                }
                if(3 == vo.requireType){
                    type = '接口';
                }
                $("#requireType").val(type);
                $("#requirementDesc").html(vo.requirementDesc);
                $("#requireResource").val(vo.requireName);
            }
        }
    });

}