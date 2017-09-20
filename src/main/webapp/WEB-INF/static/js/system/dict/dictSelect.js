var dict = function () {

    var dicts = {};
    $.commonAjax({
        url:basePathJS + "/sysDict/dictDataForSelect",
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
                option += "<option value=" + item.dictCode + " name=" + item.dictName + ">" + item.dictName + "</option>"
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
                option += "<option " + (selected == item.dictCode ? "selected='selected'" : "") + " value=" + item.dictCode + " name=" + item.dictName + ">" + item.dictName + "</option>"
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