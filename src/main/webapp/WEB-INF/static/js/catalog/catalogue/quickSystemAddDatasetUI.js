/**
 * Created by lianrongfa on 2017/9/20.
 */
jQuery(document).ready(function () {
    window.Dict=new dict();
    window.fieldIds=[];
    window.table_number=[];
    initAllSelect();

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
    Dict.selects('setItemFrequency',['#updateFrequency']);
    Dict.selects('setItemStoreMedia',['#storeMedia']);
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
    //$("#shareConditionDiv").hide();
    $("#shareType").on("change",function(){
        /*var selectedValue = $(this).children('option:selected').val();
        if(selectedValue=="2" || selectedValue==""){
            $("#shareConditionDiv").hide();
        }else{
            $("#shareConditionDiv").show();
        }
        if(selectedValue=="3"){
            $("#share_method_div").hide();
        }else{
            $("#share_method_div").show();
        }*/
    });
}
var tree=new Tree();
var Model = {
    business: {
        cache: {
            curDirId: null,
            group:{
                tree: null,
                datas:[],
                select: null,
                reset: function(){
                    this.datas = [];
                    this.select = null;
                    this.tree = tree;
                }
            },
            bus:{
                tree: null,
                datas:[],
                select: null,
                reset: function(){
                    this.datas = [];
                    this.select = null;
                    this.tree = tree;
                }
            },
            data:{
                datas:[],
                select:null,
                reset: function(){
                    this.datas = [];
                    this.select = null;
                    this.build();
                },
                build: function(){
                    $("#dataset_item_container").empty();
                    var html = '';
                    $.each(this.datas, function(idx, itm){
                        html += '<a class="list-group-item no-border" data-id="'+itm.id+'">'+itm.table_name+'</a>';
                    });
                    $("#dataset_item_container").html(html);
                }
            },
            item:{
                datas:[],
                existed: function(id,pool){
                    /*var pool = dataItemTable.api().data();*/
                    if(pool != null && pool.length >0){
                        for (var i = 0; i < pool.length; i++) {
                            if(pool[i] == id+""){
                                return true;
                            }
                        }
                        return false;
                    }else{
                        return false;
                    }
                },
                build: function(){
                    $("#field_tree").empty();
                    var html = '';
                    var cur = this;

                    var pool=[];
                    var setCode=$('#set_code').val();//操作的对象
                    /*$.ajax({
                        url: basePathJS+"/admin/SysBus_getDirBusinessBySetCode",
                        type:"post",
                        data:{
                            set_code:setCode
                        },
                        dataType:"json",
                        async:false,
                        success:function(data){
                            if(data.state){
                                pool=data.result;
                            }else{
                                $.bootstrapDialog.failure(data.message);
                            }

                        }
                    })*/

                    $.each(cur.datas, function(idx, itm){
                        try {
                            if(cur.existed(itm.id,pool)){
                                html += '<a class="list-group-item no-border disabled" data-id="'+itm.id+'">'+itm.column_en_name+'</a>';
                            }else{
                                html += '<a class="list-group-item no-border" data-id="'+itm.id+'">'+itm.column_en_name+'</a>';
                            }
                        } catch (e) {
                            html += '<a class="list-group-item no-border" data-id="'+itm.id+'" >'+itm.column_en_name+'</a>';
                        }

                    });
                    $("#field_tree").html(html);
                },
                selected: function(){
                    return [];
                },
                reset: function(){
                    this.datas = [];
                    this.build();
                }
            },
            reset: function(){
                this.group.reset();
                this.bus.reset();
                this.data.reset();
            }
        },
        open: function(dirId){
            this.cache.reset();
            this.curDirId = dirId;
            this.init();
        },
        init: function(){
            this.loadGroups();
        },
        loadGroups: function(success){
            this.cache.group.tree = tree;
            var cur = this;
            $.get(basePathJS+'/system/dept/getDeptByPrivilege',null, function (data) {
                var d=data.content;
                if(d.result!=null){
                    $('#group_tree').treeview({
                        data: formatOrg(d.result.childs),
                        color: "#428bca",
                        nodeIcon: 'fa fa-tag',
                        showBorder: false,
                        levels: 1,
                        searchResultColor: "",
                        onNodeSelected: function (e, n) {
                            cur.cache.group.select = n;
                            cur.loadBusiness(n.dir_code);
                        },
                        onNodeUnselected: function (e, n) {
                            cur.cache.item.reset();
                            cur.cache.data.reset();
                            cur.cache.bus.reset();
                        }
                    });
                }else{
                    $('#group_tree').html("暂无权限，请联系超级管理员！");
                }
            });
        },
        loadBusiness: function(success){
            this.cache.bus.tree = tree;
            var cur = this;
            $.get(basePathJS+'/DrapDb/selectDbByDeptId?dept_id='+(cur.cache.group.select?cur.cache.group.select.dir_code:""),null, function (data) {
                var d = data.content;
                if(d.list!=null){
                    $('#bus_tree').treeview({
                        data:formatTable(d.list),
                        color: "#428bca",
                        nodeIcon: 'fa fa-tag',
                        showBorder: false,
                        levels: 1,
                        searchResultColor: "",
                        onNodeSelected: function (e, n) {
                            cur.cache.bus.select = n;
                            cur.loadDataSet(n.dir_code);
                        },
                        onNodeUnselected: function (e, n) {
                            cur.cache.item.reset();
                            cur.cache.data.reset();
                        }
                    });
                }
            });
            /*this.cache.bus.tree.init({
                requestUrl: basePathJS+'/catalog/selectActivityByDeptId?dept_id='+(cur.cache.group.select?cur.cache.group.select.dir_code:""),
                treeId: 'bus_tree',
                nodeIcon: 'fa fa-tag',
                name: "ACTIVITY_NAME",
                code: 'ID',
                disabledNode:"____",
                firstNodeSelect: true,
                onSelected: function (e, n) {
                    cur.cache.bus.select = n;
                    cur.loadDataSet(n.dir_code);
                },
                onUnSelected: function (e, n) {
                    cur.cache.item.reset();
                    cur.cache.data.reset();
                }
            });*/
        },
        loadDataSet: function(success){
            var cur = this;
            if(cur.cache.bus.select){
                $.ajax({
                    url: basePathJS+"/DrapDb/selectTableByDbId",
                    type: "post",
                    data: {
                        db_id: cur.cache.bus.select.dir_code
                    },
                    dataType: "json",
                    success: function (data) {
                        if(data.state && data.content){
                            cur.cache.data.datas = data.content.list;
                            cur.cache.data.build();
                        }
                    },
                    error: function(xhr, c){

                    }
                });
            }
        },
        loadItems: function(success){
            var cur = this;
            if(cur.cache.data.select){
                $.ajax({
                    url: basePathJS+"/DrapDb/selectFieldByTableId",
                    type: "post",
                    data: {
                        table_id: cur.cache.data.select.id
                    },
                    dataType: "json",
                    success: function (data) {
                        if(data.state && data.content){
                            cur.cache.item.datas = data.content.list;
                            cur.cache.item.build();
                        }
                    },
                    error: function(xhr, c){
                    }
                });
            }
        }
    }
};

$(document).on('click','#deploy_dataset',function () {
    window.model = Model;
    window.model.business.open();
})
$(document).on("click", "#dataset_item_container>a", function(){
    var setId = $(this).attr("data-id");
    Model.business.cache.data.select = {
        id: setId
    };
    $("#dataset_item_container>a").removeClass("active");
    $(this).addClass("active");
    Model.business.cache.item.reset();
    Model.business.loadItems();
});
$(document).on("click", "em", function(){
    $(this).closest('span').remove();
    var id=$(this).attr('data-id');
    for (var i in fieldIds){
        if(fieldIds[i]==id){
            fieldIds.splice(i,1);
            break;
        }
    }
});
$(document).on("click", "#field_tree>a", function(){
    var disabled = $(this).hasClass("disabled");
    if(!disabled){
        var has = $(this).hasClass("active");
        if(has){
            $(this).removeClass("active");
        }else{
            $(this).addClass("active");
        }
    }
});

$(document).on("click", "button#add_to_container", function(){
    var table_id=$("#dataset_item_container>a.active").attr("data-id");
    var table_name=$("#dataset_item_container>a.active").text();
    var b=true;
    for (var i in table_number){
        if(table_number[i].table_id==table_id){
            b=false;
            break;
        }
    }
    if(b){
        var obj={'table_id':table_id,'table_name':table_name};
        table_number.push(obj);
    }
    $.each($("#field_tree>a.active"), function(idx, itm){
        var id = $(itm).attr("data-id");
        var text = $(itm).text();
        if(id&&text){
            var b=true;
            for (var i in  fieldIds){
                if(id==fieldIds[i]){
                    b=false;
                    break;
                }
            }
            if (b) {
                fieldIds.push(id);
                $('#fieldTexts').append('<span class="words-split"><a href="javascript:void(0)" class="fm-button">' + text + '<em data-id="' + id + '"> </em></a></span>');
            }
        }
    });
    for(var i in fieldIds){
        $('a[data-id='+fieldIds[i]+']').removeClass('active');
        $('a[data-id='+fieldIds[i]+']').addClass('disabled');
    }
});
$(document).on("click", "button#field_add", function(){

    $('#table_number').text(table_number.length);
    $('#link_number').text(table_number.length-1);

    //获取选中的数据项
    if(fieldIds.length>0){
        $.ajax({
            url: basePathJS+"/DrapDb/selectFieldByIds",
            type:"get",
            data:{
                list:fieldIds.toString()
            },
            dataType:"json",
            success:function(data){
                if(data.state){
                    /*for(var i in fieldIds){
                        $('a[column-id='+fieldIds[i]+']').removeClass('active');
                        $('a[column-id='+fieldIds[i]+']').addClass('disabled');
                    }*/
                    if(data.content.list){
                        var arr=data.content.list;
                        for (var i in arr){
                           var thisTrNum = getTrNum();
                           buildItem(thisTrNum,arr[i]);
                        }
                    }
                }else{
                    $.bootstrapDialog.failure(data.message);
                }
            },
            error: function(xhr, c){

            }
        });
        var trnum=$('#data_sys_link>tr').length;
        for (var i=0;i<table_number.length-1-trnum;i++){
            buildLinkSelect(table_number,getTrNum1(trnum),trnum+1);
        }
        $('#myModal').modal('hide');
    }else{
        layer.alert('请选择字段！')
    }
});
$(document).on("click", "#addLinks", function(){
    var trnum=$('#data_sys_link>tr').length;
    buildLinkSelect(table_number,getTrNum1(trnum),trnum+1);
});
function getTrNum1(thisTrNum){
    if(thisTrNum>0){
        var maxNum=0;
        $.each($('#data_sys_link>tr'),function(idx,item){
            var i= $(item).find('td:first').attr('trNum');
            if(i>maxNum){
                maxNum=i;
            }
        })
        thisTrNum=parseInt(maxNum)+1;
    }
    return thisTrNum;
}

function buildLinkSelect(data,trNum,i){
    var str='';
    for (var j in data){
        str+="<option value='"+data[j].table_id+"'>"+data[j].table_name+"</option>"
    }
    $("#data_sys_link").append("<tr id='se_"+trNum+"'>" +
        "<td trNum='"+trNum+"'>"+i+"</td>" +
        "<td style='text-align: right'><select id='sys_select' class='form-control' data-rule='表:required;' name='relations["+trNum+"].sourceTableId'><option value=''>请选择表</option>"+str+"</select></td>" +
        "<td><select name='relations["+trNum+"].sourceColumnId' class='form-control' data-rule='字段:required;'><option value=''>请选择字段</option></select></td>" +
        "<td>∞</td>" +
        "<td style='text-align: right'><select id='sys_select_f' class='form-control' data-rule='表:required;' name='relations["+trNum+"].targetTableId'><option value=''>请选择表</option>"+str+"</select></td>" +
        "<td><select name='relations["+trNum+"].targetColumnId' class='form-control' data-rule='字段:required;'><option value=''>请选择字段</option></select></td>" +
        "<td><a class='btn btn-xs btn-warning' onclick='javascript:deleteLinkHtml(\""+trNum+"\")'>删除</a></td>" +
        "</tr>");
}

function deleteLinkHtml(trNum) {
    $('#se_'+trNum).remove();
}

$(document).on("change", "select#sys_select", function(){
    var str=$(this).find("option:selected").val();
    var ids=[];
    var option=[];
    var options='';
    $.ajax({
        url: basePathJS+"/DrapDb/selectFieldByTableId",
        type: "post",
        data: {
            table_id:str
        },
        dataType: "json",
        success: function (data) {
            if(data.state && data.content.list){
                $.each(data.content.list, function(idx, itm){
                    ids.push(itm.id);
                    option.push(itm.column_en_name);
                })
            }
        },
        async:false,
        error: function(xhr, c){
        }
    });

    for (var i = 0; i < option.length; i++) {
        options+="<option value='"+ids[i]+"'>"+option[i]+"</option>"
    }
    $(this).parent().parent().children().eq(2).children().find("option").not(":first").remove();
    $(this).parent().parent().children().eq(2).children().append(options);
});
$(document).on("change", "select#sys_select_f", function(){
    var str=$(this).find("option:selected").val();
    var ids=[];
    var option=[];
    var options='';
    $.ajax({
        url: basePathJS+"/DrapDb/selectFieldByTableId",
        type: "post",
        data: {
            table_id:str
        },
        dataType: "json",
        success: function (data) {
            if(data.state && data.content.list){
                $.each(data.content.list, function(idx, itm){
                    ids.push(itm.id);
                    option.push(itm.column_en_name);
                })
            }
        },
        async:false,
        error: function(xhr, c){
        }
    });

    for (var i = 0; i < option.length; i++) {
        options+="<option value='"+ids[i]+"'>"+option[i]+"</option>"
    }
    $(this).parent().parent().children().eq(5).children().find("option").not(":first").remove();
    $(this).parent().parent().children().eq(5).children().append(options);
});
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
$(document).on('click','#add_item',function () {
    var thisTrNum=$('#dataitemList').find('tr').length;
    if(thisTrNum>0){
        var maxNum=0;
        $.each($('#dataitemList>tr'),function(idx,item){
           var i= $(item).find('input:first').attr('trNum');
            if(i>maxNum){
                maxNum=i;
            }
        })
        thisTrNum=parseInt(maxNum)+1;
    }
    $('#dataitemList').prepend('<tr id="tr_'+thisTrNum+'">' +
        '<td><input trNum='+thisTrNum+' data-rule="字段名:required;" type="text" class="form-control"></td>'+
        '<td><input trNum='+thisTrNum+' name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control"></td>'+
        '<td><select name="items['+thisTrNum+'].itemType" data-rule="类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType")+'</select></td>'+
        '<td><input name="items['+thisTrNum+'].itemLength" data-rule="integer(+);" type="number" min="1" type="text" class="form-control"></td>'+
        '<td></td>'+
        '<td><select name="items['+thisTrNum+'].shareType" data-rule="共享类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType")+'</select></td>'+
        '<td><input name="items['+thisTrNum+'].shareCondition" type="text" class="form-control" ></td>'+
        '<td><select name="items['+thisTrNum+'].shareMethod" data-rule="共享方式:required;" class="form-control">'+Dict.selectsDom("dataSetShareMethod")+'</select></td>'+
        '<td><select name="items['+thisTrNum+'].isOpen" class="form-control"><option value="1" selected>是</option><option value="0" >否</option></select></td>'+
        '<td><input name="items['+thisTrNum+'].openCondition" type="text" class="form-control" ></td>'+
        '<td><select name="items['+thisTrNum+'].storageMedium" data-rule="存储介质:required;" class="form-control">'+Dict.selectsDom("setItemStoreMedia")+'</select></td>'+
        '<td><select name="items['+thisTrNum+'].storageLocation" data-rule="存储位置:required;" class="form-control">'+Dict.selectsDom("setItemStoreLocation")+'</select></td>'+
        '<td><select name="items['+thisTrNum+'].updateFrequency" data-rule="更新周期:required;" class="form-control">'+Dict.selectsDom("setItemFrequency")+'</select></td>'+
        '<td><input name="items['+thisTrNum+'].itemDesc" type="text" class="form-control" ></td>'+
        '<td><a class="btn btn-danger btn-flat btn-xs" href="javascript:;" onclick="javascript:infoTableDel(\''+thisTrNum+'\')"><i class="fa fa-close">&#160;</i>删除</a></td></tr>');
})
function getTrNum(){
    var thisTrNum=$('#dataitemList').find('tr').length;
    if(thisTrNum>0){
        var maxNum=0;
        $.each($('#dataitemList>tr'),function(idx,item){
            var i= $(item).find('input:first').attr('trNum');
            if(i>maxNum){
                maxNum=i;
            }
        })
        thisTrNum=parseInt(maxNum)+1;
    }
    return thisTrNum;
}

function buildItem(thisTrNum,data){
    var str='<tr id="tr_'+thisTrNum+'">'+'<td><input trNum='+thisTrNum+' type="checkbox"></td>'
        +'<td><input value="'+(data.column_en_name?data.column_en_name:'')+'" data-rule="字段名:required;" type="text" class="form-control"></td>'
        +'<td><input value="'+(data.column_cn_name?data.column_cn_name:'')+'" name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control"></td>'
        +'<td><select name="items['+thisTrNum+'].itemType" data-rule="类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType",data.itemType?data.itemType:'')+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemLength" data-rule="integer(+);" type="number" value="'+(data.column_length?data.column_length:'')+'" min="1" type="text" class="form-control"></td>'
        +'<td><input type="hidden" name="items['+thisTrNum+'].belongDeptId" value="'+(data.dept_id?data.dept_id:'')+'"> <input class="form-control" type="text" disabled value="'+(data.dept_name?data.dept_name:'')+'" > </td>'
        +'<td><input class="form-control" type="text" disabled value="'+(data.dataset_name?data.dataset_name:'')+'"></td>'
        +'<td><input type="hidden" name="items['+thisTrNum+'].belongSystemId" value="'+(data.system_id?data.system_id:'')+'"> <input class="form-control" type="text" disabled value="'+(data.system_name?data.system_name:'')+'" > </td>'
        +'<td><input type="hidden" value="'+(data.table_id?data.table_id:'')+'"> <input class="form-control" type="text" disabled value="'+(data.table_name?data.table_name:'')+'" > </td>'
        +'<td><select name="items['+thisTrNum+'].secretFlag" data-rule="涉密标识:required;" class="form-control"><option value="1">是</option><option value="0">否</option></select></td>'
        +'<td><select name="items['+thisTrNum+'].shareType" data-rule="共享类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType",data.shareType?data.shareType:'')+'</select></td>'
        +'<td><input class="form-control" type="text" name="items['+thisTrNum+'].shareCondition" value="'+(data.shareConditionDesc?data.shareConditionDesc:'')+'"></td>'
        +'<td><select name="items['+thisTrNum+'].shareMethod" data-rule="共享方式:required;" class="form-control">'+Dict.selectsDom("dataSetShareMethod",data.shareMethodDesc?data.shareMethodDesc:'')+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].isOpen" class="form-control"><option value="1" selected>是</option><option value="0" >否</option></select></td>'
        +'<td><input name="items['+thisTrNum+'].openCondition" type="text" class="form-control" value="'+(data.openCondition?data.openCondition:'')+'"></td>'
        +'<td><select name="items['+thisTrNum+'].storageLocation" data-rule="存储位置:required;" class="form-control">'+Dict.selectsDom("setItemStoreLocation",data.physicsStoreLocation?data.physicsStoreLocation:'')+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].updateFrequency" data-rule="更新周期:required;" class="form-control">'+Dict.selectsDom("setItemFrequency",data.updateFrequency?data.updateFrequency:'')+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemDesc" type="text" class="form-control" value="'+(data.itemDesc?data.itemDesc:'')+'"></td></tr>';
    $('#dataitemList').prepend(str)}
function infoTableDel(thisTrNum){
    $('#tr_'+thisTrNum).remove();
}

function formatOrg(aaData) {
    if (aaData.length == 0) return null;
    var objArr = [];
    aaData.forEach(function (v, n) {

        var temp_json = {};
        temp_json.text = v.deptShortName;
        temp_json.dir_code = v.id;
        try {
            temp_json.nodes = formatOrg(v.childs);
        } catch (e) {
            temp_json.nodes = formatOrg([]);
        }
        if (temp_json.nodes) {
            temp_json.selectable = false;
        }
        objArr.push(temp_json);

    });
    return objArr;
}
function formatTable(aaData) {
    if (aaData.length == 0) return null;
    var objArr = [];
    aaData.forEach(function (v, n) {
        var temp_json = {};
        temp_json.text = v.db_name;
        temp_json.dir_code = v.id;
        temp_json.nodes=null;
        objArr.push(temp_json);
    });
    return objArr;
}
$(document).on('click','#selectAllItem',function(){
    if(this.checked){
        $("#dataitemList :checkbox").prop("checked", true);
    }else{
        $("#dataitemList :checkbox").prop("checked", false);
    }
});
$(document).on('click','#deleteItems',function(){
    $("#dataitemList").find('input[type="checkbox"]:checked').each(function(){
        var trNum=$(this).attr('trNum');
        infoTableDel(trNum);
    })
})