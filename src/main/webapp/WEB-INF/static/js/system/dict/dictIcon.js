var dict = function () {

    var dicts = {};
    $.commonAjax({
        url:basePathJS + "/sysDict/dictIcon",
        async: false,
        success: function (result) {
            if (result.state) {
                dicts = result.content.vo;
            }
        }
    });

    window.dicts = dicts;

    return {
        dicts: dicts,
        selects: function (key, doms) {
            //敏感标识
            var option = "<option value=''>--请选择--</option>";
            var curThis = this;
            for (var itm in curThis.dicts[key]) {
                var item = dicts[key][itm];
                if(item.parentCode == undefined){ //父级code查出来为空，代表他是一级字典，如果不该为空，则为联动字典
                    option += "<option value=" + item.iconPath + " name=" + item.iconPath + ">" + item.iconName + "</option>";
                }
            }
            $.each(doms, function (idx, dom) {
                $(dom).empty();
                $(dom).append(option);
            });
        },
        cascadeSelects: function (key, doms, parentCode) { //级联下拉框
            //敏感标识
            var option = "<option value=''>--请选择--</option>";
            var curThis = this;
            for (var itm in curThis.dicts[key]) {
                var item = dicts[key][itm];
                if(item.parentCode == parentCode){ //根据父级code,获取其子联动字典
                    option += "<option value=" + item.dictCode + " name=" + item.dictName + ">" + item.dictName + "</option>";
                }
            }
            $.each(doms, function (idx, dom) {
                $(dom).empty();
                $(dom).append(option);
            });
        },
        selectsDom: function (key, selected) {
            //敏感标识
            var option = "<option value=''>--请选择--</option>";
            var curThis = this;
            for (var itm in curThis.dicts[key]) {
                var item = dicts[key][itm];
                option += "<option " + (selected == item.iconName ? "selected='selected'" : "") + " value=" + item.iconPath + " name=" + item.iconPath + ">" + item.iconName + "</option>"
            }
            return option;
        },
        label: function (key, code, id) {
            var items = this.dicts[key];
            if (code) {
                var it = items[code];
                return it && it.dictName || "";
            } else if (id) {
                for (var itm in dicts[key]) {
                    var item = dicts[key][itm];
                    if (id == item.ID) {
                        return item.dictName;
                    }
                }
            }
            return "";
        }
    };

}