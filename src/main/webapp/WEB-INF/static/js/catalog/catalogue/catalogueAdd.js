/**
 * Created by wuty on 2017/9/15
 */

jQuery(document).ready(function () {
    window.Dict=new dict();
    initAllSelect();
    initInputValue();

});

function initAllSelect(){
    $.initClassifyTreeSelect('treeDemo','classifyName','classifyId','menuContent'); //初始化信息资源分类下拉框
    $.initClassifyTreeSelect('relTreeDemo','relDatasetName','relDatasetCode','relMenuContent'); //初始化关联信息资源分类下拉框
    //信息资源格式下拉框初始化
    Dict.selects('dataSetStoreMedia',['#resourceFormat']);
    //共享类型
    Dict.selects('dataSetShareType',['#shareType']);
    //共享方式
    Dict.selects('dataSetShareMethod',['#shareMethod']);
    //是否向社会开放
    //Dict.selects('14',['#social_open_flag']);
    //信息资源主要来源
    //Dict.selects('24',['#info_Primary']);
    //服务中央、国务院决策部署
    //Dict.selects('25',['#service_main']);
    //服务省委、省政府决策部署
    //Dict.selects('26',['#service_provice']);
    //信息资源最小分级单元
    //Dict.selects('27',['#info_min_unit']);
    $("#shareConditionDiv").hide();
    $("#shareType").on("change",function(){
        var selectedValue = $(this).children('option:selected').val();
        if(selectedValue=="2" || selectedValue==""){
            $("#shareConditionDiv").hide();
        }else{
            $("#shareConditionDiv").show();
        }
        if(selectedValue=="3"){
            $("#share_method_div").hide();
        }else{
            $("#share_method_div").show();
        }
    });
}

function initInputValue(){
    //初始化资源提供方和提供方代码输入框的值
    $.ajax({
        url: CONTEXT_PATH+"/admin/Dataset_getProviderInfo",
        type:"post",
        data:{},
        dataType:"json",
        success:function(data){
            if(data.code == 'OK'){
                var provider = data.result;
                $("#resource_provider").val(provider.orgName);
                $("#resource_provider_code").val(provider.organizationCode);
                $("#org_code").val(provider.orgCode);
            }
        },
        error: function(xhr, c){}
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