/**
 * Created by zhanf on 2017/4/28. 1
 */
(function () {
	require(['jquery','global_custom'],function($){
    var regionId = $("#regionId").val();
    initFormerDate(regionId);
    // initSelectData();
    })
}());


function initSelectData() {
    $.initRegionTreeSelect('treeRegionDemo','fname','fcode','menuRegionContent','','','region'); //初始化区域分类下拉框
}

function getPinyin() {
    $.getPinyin("regionName","pinyin");
}

//初始化用户信息
function initFormerDate(regionId) {
    $.commonAjax({
        url: basePathJS + "/system/region/editLoad",
        data: {id:regionId},
        success: function (result) {
            if (result.state) {
                var region = result.content.vo;
                if(region){

                    $("#fname").val(region.fname);
                    $("#fcode").val(region.fcode);
                    $("#regionName").val(region.regionName);
                    $("#regionCode").val(region.regionCode);
                    initRegionLevelDataList(region.fcode);
                    $("#pinyin").val(region.pinyin);

                    $("#versionId").val(region.versionId);

                    var status = region.status;

                    if (status == 1) {
                        $("#inlineRadio1").click();
                    }
                    if (status == 0) {
                        $("#inlineRadio0").click();
                    }
                    $("#regionLevelCode").val(region.regionLevelCode).trigger("change");

                }
            }
        }
    });
}


function initRegionLevelDataList(dd) {
    $.commonAjax({
        url: basePathJS + "/system/regionLevel/findByRegionLevelValueGreaterThan",
        data:{
            regionCode : dd
        },
        success: function (result) {
            if (result.state) {
                var selectData = result.content.selectData;
                var data = [];
                if(selectData && selectData.length > 0){
                    for(var i in selectData){
                        var id = selectData[i].regionLevelCode;
                        var text = selectData[i].regionLevelName;
                        if(id && text){
                            data.push({id: id, text: text})
                        }
                    }
                }
                $("#regionLevelCode").html("")
                $("#regionLevelCode").select2({
                    data: data,
                    placeholder : '',
                    allowClear: true
                });
                // $("#fid").change(function(){
                //     $("#fname").val($("#select2-fid-container").attr("title"))
                // })
                // $("#regionLevelCode").val("30").trigger("change");
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

