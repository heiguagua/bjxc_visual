/**
 * Created by lianrongfa on 2017/9/20.
 */
jQuery(document).ready(function () {
    window.Dict=new dict();
    window.fieldIds=[];
    initAllSelect();
    initInputValue();
});
function initAllSelect(){
    var regionCode = $.getSelectedRegionCode();
    //$.initClassifyTreeSelect('treeDemo','classifyName','classifyId','menuContent'); //初始化目录分类下拉框
    $.initRelClassifyTreeSelect('relTreeDemo','relDatasetName','relDatasetCode','relMenuContent','classifyId','regionCode');//初始化关联目录分类下拉框
    var initBelongDeptTypeTreeParam = ["belongDeptTreeDemo","belongDeptName","belongDeptId","belongDeptMenuContent"];
    $.initRegionDeptTreeSelect('belongDeptTypeTreeDemo','belongDeptTypeName','belongDeptType','belongDeptTypeMenuContent',initBelongDeptTypeTreeParam)//初始化资源提供方下拉框;
    //初始化科室
    var belongDeptTypeValue = $("#belongDeptType").val();
    if(belongDeptTypeValue){
        $.initSubDeptTreeSelect('belongDeptTreeDemo','belongDeptName','belongDeptId','belongDeptMenuContent',{fid:belongDeptTypeValue});
    }
    //$.initDeptTreeSelect('belongDeptTreeDemo','belongDeptName','belongDeptId','belongDeptMenuContent',false,{regionCode:regionCode});
    $('#datasetName').on('blur',function(){
        var datasetName=$('#datasetName').val();
        $(".dataset-name").each(function(idex,item){
            $(item).val(datasetName);
        })
    });
    //信息资源格式下拉框初始化
    Dict.selects('dataSetStoreMedia',['#resourceFormat']);
    //共享类型
    Dict.selects('dataSetShareType',['#shareType']);
    //共享方式
    Dict.selects('dataSetShareMethod',['#shareMethod']);
    Dict.selects('setItemFrequency',['#updateFrequency']);
    Dict.selects('resourceFormat',['#format_category']);
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
    $("#shareType").on("change",function(){
        var selectedValue = $(this).children('option:selected').val();
        if(selectedValue=="2" || selectedValue==""){ //不予共享
            $("#shareConditionLabel").html("不予共享说明");
            $("#shareConditionDesc").removeAttr("disabled");
            $("#shareMethod").attr("disabled","disabled");
            $("#shareMethod").css("background-color","#EEEEEE");
        }else if(selectedValue=="0"){ //无条件共享
            $("#shareConditionLabel").html("共享条件");
            $("#shareConditionDesc").attr("disabled","disabled");
            $("#shareConditionDesc").css("background-color","#EEEEEE");
            $("#shareMethod").removeAttr("disabled");
            $("#shareMethod").removeAttr("style");

        }else if(selectedValue=="1") { //有条件共享
            $("#shareConditionLabel").html("共享条件");
            $("#shareConditionDesc").removeAttr("disabled");
            $("#shareConditionDesc").removeAttr("style");
            $("#shareMethod").removeAttr("disabled");
            $("#shareMethod").removeAttr("style");
        }
    });
}

function initInputValue(){
    //初始化资源提供方和提供方代码输入框的值
    //$.commonAjax({
    //    url:basePathJS + "/system/dept/getDeptInfoForLoginUser",
    //    success: function (result) {
    //        if (result.state) {
    //            var deptObj = result.content.vo;
    //            $("#chargeDeptId").val(deptObj.id);
    //        }
    //    }
    //});
    if(loginUserDeptId && loginUserDeptId!=="null"){
        $("#chargeDeptId").val(loginUserDeptId);
        $.commonAjax({
            url:basePathJS + "/system/dept/belongTypeByDept",
            data:{deptId:loginUserDeptId},
            async:false,
            success: function (result) {
                if (result.state) {
                    var obj = result.content.vo;
                    $("#belongDeptType").val(obj.deptId);
                    $("#belongDeptTypeName").val(obj.deptName);
                    $("#belongDeptId").val(obj.subDeptId);
                    $("#belongDeptName").val(obj.subDeptName);
                }
            }
        });
    }
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
                }
            },
            bus:{
                tree: null,
                datas:[],
                select: null,
                reset: function(){
                    this.datas = [];
                    this.select = null;
                    $('#bus_tree').treeview({
                        data: [],
                        color: "#428bca",
                        nodeIcon: 'fa fa-tag',
                        showBorder: false
                    });
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
                        var str = "";
                        if(itm["relationCount"]==0){
                            str = "【未梳理关系】"
                        }else{
                            str = "【已梳理关系】"
                        }
                        html += '<a class="list-group-item no-border" data-id="'+itm.id+'">'+itm.dataset_name+str+'</a>';
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

                    var pool=fieldIds;
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
                                html += '<a class="list-group-item no-border disabled" data-id="'+itm.id+'">'+itm.itemName+'</a>';
                            }else{
                                html += '<a class="list-group-item no-border" data-id="'+itm.id+'">'+itm.itemName+'</a>';
                            }
                        } catch (e) {
                            html += '<a class="list-group-item no-border" data-id="'+itm.id+'" >'+itm.itemName+'</a>';
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
                this.item.reset();
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
                            cur.loadDataSet(n.dir_code);
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
            $.get(basePathJS+'/catalog/selectActivityByDeptId?dept_id='+(cur.cache.group.select?cur.cache.group.select.dir_code:""),null, function (data) {
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
        loadDataSet: function(dept_id){
            var cur = this;
            //cur.cache.bus.select
            if(dept_id){
                $.ajax({
                    url: basePathJS+"/catalog/selectDatasetByActivityId",
                    type: "post",
                    data: {
                        activity_id: dept_id
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
                    url: basePathJS+"/catalog/selectDatasetItemByDatasetId",
                    type: "post",
                    data: {
                        set_id: cur.cache.data.select.id
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
$(document).on("click", "button#field_add", function(){
    //提交
    var ids=[];
    var i=0;
    $.each($("#field_tree>a.active"), function(idx, itm){
        var id = $(itm).attr("data-id");
        if(id){
            ids.push(id);
            fieldIds.push(id);
        }
    });
    var dataset_id=$("#dataset_item_container>a.active").attr('data-id');

    //获取选中的数据集
    if(dataset_id){
        $.ajax({
            url: basePathJS+"/catalog/getDrapDatasetDetail",
            type:"get",
            data:{
                id:dataset_id
            },
            dataType:"json",
            success:function(data){
                if(data.state){
                    $('#sourceObjId').val(data.content.result.id);
                    //数据集
                    buildDataset(data.content.result);
                    //大普查
                    buildDataset(data.content.survey);
                    $('#myModal').modal('hide');
                }else{
                    $.bootstrapDialog.failure(data.message);
                }
            },
            error: function(xhr, c){

            }
        });
    }
    //获取选中的信息项
    if(ids){
        $.ajax({
            url: basePathJS+"/catalog/selectDatasetItemByIds",
            type:"get",
            data:{
                ids:ids.toString()
            },
            dataType:"json",
            success:function(data){
                if(data.state){
                    /*for(var i in ids){
                        $('a[column-id='+ids[i]+']').removeClass('active');
                        $('a[column-id='+ids[i]+']').addClass('disabled');
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
    }
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
    $('#dataitemList').prepend('<tr id="tr_'+thisTrNum+'"><td><input trNum='+thisTrNum+' name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control"></td>'+
        '<td><select name="items['+thisTrNum+'].itemType" data-rule="类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType")+'</select></td>'+
        '<td><input name="items['+thisTrNum+'].itemLength" data-rule="长度:required;integer(+);" type="number" min="1" type="text" class="form-control"></td>'+
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
            if(parseInt(i)>parseInt(maxNum)){
                maxNum=i;
                return false;
            }
        })
        thisTrNum=parseInt(maxNum)+1;
    }
    return thisTrNum;
}
function buildDataset(data){
    for(var key in data){
        if(key=='belongDeptId' || key=='belongDeptType'){
            continue;
        }else if(key=='isSecret'){
            $("input[name='secretFlag'][value='"+data[key]+"']").click();
        }else if(key=='isOpen'){
            $("input[name='isOpen'][value='"+data[key]+"']").click();
        }else if(key=='format_type'){
            $("#format_category").change();
            $('#'+key).val(data[key]);
        }
        else{
            $('#'+key).val(data[key]);
        }
    }

}
function buildItem(thisTrNum,data){
    var str='<tr id="tr_'+thisTrNum+'">'+'<td><input trNum='+thisTrNum+' data-id="'+data.id+'" type="checkbox"></td>'
        +'<td><input value="'+data.itemName+'" name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control"></td>'
        +'<td><select name="items['+thisTrNum+'].itemType" data-rule="类型:required;" class="form-control">'+Dict.selectsDom("dataitemType",data.itemType?data.itemType:'')+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemLength" data-rule="长度:required;integer(+);" type="number" value="'+(data.itemLength?data.itemLength:'')+'" min="1" type="text" class="form-control"></td>'
        +'<td><input type="hidden" name="items['+thisTrNum+'].belongDeptId" value="'+(data.belongDept?data.belongDept:'')+'"> <input class="form-control" type="text" disabled value="'+(data.dept_name?data.dept_name:'')+'" > </td>'
        //+'<td><input class="form-control dataset-name" type="text" disabled value="'+(data.dataset_name?data.dataset_name:'')+'"></td>'
        /*+'<td><input type="hidden" name="items['+thisTrNum+'].belongSystemId" value="'+(data.system_id?data.system_id:'')+'"> <input class="form-control" type="text" disabled value="'+(data.system_name?data.system_name:'')+'" > </td>'*/
        +'<td><select name="items['+thisTrNum+'].secretFlag" data-rule="涉密标识:required;" class="form-control"><option value="1">是</option><option value="0">否</option></select></td>'
        +'<td><select name="items['+thisTrNum+'].shareType" data-rule="共享类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType",data.shareType?data.shareType:'')+'</select></td>'
        +'<td><input class="form-control" type="text" name="items['+thisTrNum+'].shareCondition" value="'+(data.shareConditionDesc?data.shareConditionDesc:'')+'"></td>'
        +'<td><select name="items['+thisTrNum+'].shareMethod" data-rule="共享方式:required;" class="form-control">'+Dict.selectsDom("dataSetShareMethod",data.shareMethod?data.shareMethod:'')+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].isOpen" class="form-control"><option value="1" selected>是</option><option value="0" >否</option></select></td>'
        +'<td><input name="items['+thisTrNum+'].openCondition" type="text" class="form-control" value="'+(data.openCondition?data.openCondition:'')+'"></td>'
        +'<td><select name="items['+thisTrNum+'].storageLocation" data-rule="存储位置:required;" class="form-control">'+Dict.selectsDom("setItemStoreLocation",data.physicsStoreLocation?data.physicsStoreLocation:'')+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].updateFrequency" data-rule="更新周期:required;" class="form-control">'+Dict.selectsDom("setItemFrequency",data.updateFrequency?data.updateFrequency:'')+'</select></td>'
        +'<td><input type="hidden" name="sourceInfos['+thisTrNum+'].sourceObjId" value="'+data.id+'"><input name="items['+thisTrNum+'].itemDesc" type="text" class="form-control" value="'+(data.itemDesc?data.itemDesc:'')+'"></td></tr>';
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
        temp_json.text = v.activity_name;
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
        var id=$(this).attr('data-id');
        if(id){
            for (var i in fieldIds){
                if(fieldIds[i]==id){
                    fieldIds.splice(i,1);
                    break;
                }
            }
        }
    })
});
$(document).on("change","#format_category",function(){
    var selectedValue = $(this).children('option:selected').val();
    if(selectedValue!=""){
        Dict.cascadeSelects('resourceFormat', ['#format_type'], selectedValue);
    }
});