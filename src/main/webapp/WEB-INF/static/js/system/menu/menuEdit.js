var tableSelector = '#systemMenuTableId';
//1
jQuery(document).ready(function () {

    var menuId = $("#id").val();
    initFormData(menuId);
});

function initFormData(menuId){
    $.commonAjax({
        url: basePathJS + "/system/menu/editData",
        data: {id:menuId},
        success: function (json) {
            if (json.state) {
                var menu = json.content.sysMenu;
                if(menu){
                    var menuType = menu.menuType;
                    $("#menuName").val(menu.menuName);
                    $("#code").val(menu.code);
                    $("#sort").val(menu.sort);
                    if(menuType == 1 || menuType == 2){
                        if(menuType == 2){
                            $("#url").val(menu.url);
                            initCatalogSelect(menuId);
                        }
                        $.commonAjax({
                            url: basePathJS + "/system/menu/menuIconSelect",
                            success: function(json){
                                var selectData = json.content.selectData;
                                var data = [];
                                if(selectData && selectData.length > 0){
                                    for(var i in selectData){
                                        var id = selectData[i].iconCssClass;
                                        var text = selectData[i].iconName;
                                        if(id && text){
                                            data.push({id: id, text: text})
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
                                $("#iconName").val(menu.icon).trigger("change");
                            }
                        });
                    }else if(menuType == 3){
                        $("#resourceName").val(menu.resourceName);
                        initCatalogSelect(menuId);
                        initMenuSelect(menuId);
                        bindChangeEvent();
                    }
                }
            }
        }
    });
}


function initCatalogSelect(menuId){
    $.commonAjax({
        url: basePathJS + "/system/menu/menuSelect",
        data: {id:menuId,menuType:1},
        success: function (json) {
            if (json.state) {
                var catalogData = json.content.selectData;
                $("#catalog").select2({
                    data: catalogData
                });
            }
        }
    });
}

function initMenuSelect(menuId){
    $.commonAjax({
        url: basePathJS + "/system/menu/menuSelect",
        data: {id:menuId},
        success: function (json) {
            if (json.state) {
                var menuData = json.content.selectData;
                $("#pid").select2({
                    data: menuData
                });
            }
        }
    });
}

function bindChangeEvent(){
    $("#catalog").on('change',function(){
        var pid = $(this).val();
        $.post(basePathJS + '/system/menu/menuSelect',{pid:pid},function(response){
            if(response.state){
                $("#pid").empty();
                $("#pid").select2({
                    data:response.content.selectData
                });
            }
        });
    });
}


function runAfterSubmitSuccess(response) {
    //刷新主页面
    parent.reloadTable();
}
