$(document).ready(function(){
    initPage();
});

//初始化详情界面
function initPage(){
    var params = {id : $("#requirementId").val()};
    $.commonAjax({
        url: basePathJS + "/drapRequirementResources/loadDetail",
        data: params,
        success: function (result) {
            if (result.state) {
                var vo = result.content.vo;
                $("#requireName").val(vo.requireName);
                $("#providerDeptName").val(vo.providerDeptName);
                $("#requirementDeptName").val(vo.requirementDeptName);
                $("#demanderName").val(vo.demanderName);
                var type;
                if(1 == vo.requireType){
                    type = '手动添加';
                }
                if(2 == vo.requireType){
                    type = '从信息资源添加';
                }
                if(3 == vo.requireType){
                    type = '从应用系统添加';
                }
                $("#requireType").val(type);
                $("#otherInfo").val(vo.otherInfo);
                $("#requirementDesc").html(vo.requirementDesc);
            }
        }
    });

}