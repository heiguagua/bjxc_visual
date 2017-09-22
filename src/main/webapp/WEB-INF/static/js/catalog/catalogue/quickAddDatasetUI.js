/**
 * Created by lianrongfa on 2017/9/20.
 */
jQuery(document).ready(function () {
    window.Dict=new dict();
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
                        html += '<a class="list-group-item no-border" data-id="'+itm.id+'" data-code="'+itm.dataset_code+'">'+itm.dataset_name+'</a>';
                    });
                    $("#dataset_item_container").html(html);
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
            $.get(CONTEXT_PATH+'/admin/Organize_getOrgnizeByPrivilege',null, function (data) {
                var d = JSON.parse(data);
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
            this.cache.bus.tree.init({
                requestUrl: CONTEXT_PATH+'/admin/Bus_getBusinessByPidAndOrgCode?org_code='+(cur.cache.group.select?cur.cache.group.select.dir_code:""),
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
            });
        },
        loadDataSet: function(success){
            var cur = this;
            if(cur.cache.bus.select){
                $.ajax({
                    url: CONTEXT_PATH+"/admin/Dataset_getBusinessDataset",
                    type: "post",
                    data: {
                        activity_id: cur.cache.bus.select.dir_code
                    },
                    dataType: "json",
                    success: function (data) {
                        if(data.code == 'OK' && data.result){
                            cur.cache.data.datas = data.result;
                            cur.cache.data.build();
                        }
                    },
                    error: function(xhr, c){

                    }
                });
            }
        }
    }
};
$('#deploy_dataset').click(function(){
    window.model = Model;
    window.model.business.open();
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
function infoTableDel(thisTrNum){
    $('#tr_'+thisTrNum).remove();
}

function formatOrg(aaData) {
    if (aaData.length == 0) return null;
    var objArr = [];
    aaData.forEach(function (v, n) {
        var temp_json = {};
        temp_json.text = v.org_shortname;
        temp_json.dir_code = v.org_code;
        temp_json.nodes = formatOrg(v.childs);
        if (temp_json.nodes) {
            temp_json.selectable = false;
        }
        objArr.push(temp_json);
    });
    return objArr;
}