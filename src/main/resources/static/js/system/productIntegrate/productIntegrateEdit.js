jQuery(document).ready(function () {
    var proIntId = $("#proIntId").val();
    initFormerDate(proIntId);
});



//初始化集成信息
function initFormerDate(id) {
    $.commonAjax({
        url: basePathJS + "/system/productIntegrate/editLoad",
        data: {id:id},
        success: function (result) {
            if (result.state) {
                var vo = result.content.vo;
                if(vo){
                    $("#productNo").val(vo.productNo);
                    $("#productName").val(vo.productName);
                    $("#productShowName").val(vo.productShowName);
                    $("#rootPath").val(vo.rootPath);
                    $("#ssoPath").val(vo.ssoPath);
                    $("#orderNumber").val(vo.orderNumber);
                    var integrateFlag = vo.integrateFlag;
                    if (integrateFlag == 1) {
                        $("#integrateFlag1").click();
                    }
                    if (integrateFlag == 0) {
                        $("#integrateFlag0").click();
                    }
                    var curOpenFlag = vo.curOpenFlag;
                    if (curOpenFlag == 1) {
                        $("#curOpenFlag1").click();
                    }
                    if (curOpenFlag == 0) {
                        $("#curOpenFlag0").click();
                    }
                    // var masterFlag = vo.masterFlag;
                    // if (masterFlag == 1) {
                    //     $("#masterFlag1").click();
                    // }
                    // if (masterFlag == 0) {
                    //     $("#masterFlag0").click();
                    // }
                    $.commonAjax({
                        url: basePathJS + "/system/productIntegrate/iconSelect",
                        success: function(json){
                            var selectData = json.content.selectData;
                            var data = [];
                            if(selectData && selectData.length > 0){
                                for(var i in selectData){
                                    var id = selectData[i].iconPath;
                                    if(id){
                                        data.push({id: id, text: id})
                                    }
                                }
                            }
                            $("#iconName").html("")
                            $("#iconName").select2({
                                data: data,
                                placeholder : '',
                                allowClear: true
                            });
                            $("#iconName").change(function(){
                                $("#icon").val($("#select2-iconName-container").attr("title"))
                            })
                            $("#iconName").val(vo.icon).trigger("change");
                        }
                    });
                }
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
