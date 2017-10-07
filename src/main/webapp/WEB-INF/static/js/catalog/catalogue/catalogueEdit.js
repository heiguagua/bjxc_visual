/**
 * Created by wuty on 2017/9/15
 */

jQuery(document).ready(function () {
    window.Dict=new dict();
    initAllSelect();  //初始化所有下拉框
    initButtonClickEvent(); //初始化按钮点击事件
    initInputValue(); //初始化所有需要设值的输入框的值
});

function initAllSelect(){
    $.initClassifyTreeSelect('treeDemo','classifyName','classifyId','menuContent'); //初始化信息资源分类下拉框
    $.initClassifyTreeSelect('relTreeDemo','relDatasetName','relDatasetCode','relMenuContent'); //初始化关联信息资源分类下拉框
    //信息资源格式下拉框初始化
    Dict.selects('resourceFormat',['#formatCategory']);
    //共享类型
    Dict.selects('dataSetShareType',['#shareType']);
    //共享方式
    Dict.selects('dataSetShareMethod',['#shareMethod']);
    //更新周期
    Dict.selects('setItemFrequency',['#updateFrequency']);
    $("#shareType").on("change",function(){
        var selectedValue = $(this).children('option:selected').val();
        if(selectedValue=="2" || selectedValue==""){ //不予共享
            $("#shareConditionLabel").html("不予共享说明");
            $("#shareCondition").removeAttr("disabled");
            $("#shareMethod").attr("disabled","disabled");
            $("#shareMethod").css("background-color","#EEEEEE");
        }else if(selectedValue=="0"){ //无条件共享
            $("#shareConditionLabel").html("共享条件");
            $("#shareCondition").attr("disabled","disabled");
            $("#shareCondition").css("background-color","#EEEEEE");
            $("#shareMethod").removeAttr("disabled");
            $("#shareMethod").removeAttr("style");

        }else if(selectedValue=="1") { //有条件共享
            $("#shareConditionLabel").html("共享条件");
            $("#shareCondition").removeAttr("disabled");
            $("#shareCondition").removeAttr("style");
            $("#shareMethod").removeAttr("disabled");
            $("#shareMethod").removeAttr("style");
        }
    });

    $("#formatCategory").on("change",function(){
        var selectedValue = $(this).children('option:selected').val();
        if(selectedValue!=""){
            Dict.cascadeSelects('resourceFormat', ['#formatType'], selectedValue);
        }
    });
}

function initInputValue(){
    //初始化资源提供方和提供方代码输入框的值
    $.commonAjax({
        url:basePathJS + "/catalog/editLoad",
        data:{id:$("#id").val()},
        success: function (result) {
            if (result.state) {
                var obj = result.content.vo;
                $("#classifyName").val(obj.classifyName);
                $("#classifyId").val(obj.classifyIds);
                $("#datasetName").val(obj.datasetName);
                $("#datasetCode").val(obj.datasetCode);
                $("#belongDeptType").val(obj.belongDeptType);
                $("#belongDeptName").val(obj.deptName);
                $("#belongDeptId").val(obj.belongDeptId);
                if(obj.ext != undefined && obj.ext !=""){
                    $("#formatCategory").val(obj.ext.formatCategory);
                    $("#formatType").val(obj.ext.formatType);
                }
                $("input[name='secretFlag'][value="+obj.secretFlag+"]").attr("checked",true);
                $("#updateFrequency").val(obj.updateFrequency);
                $("#shareType").val(obj.shareType);
                $("#shareMethod").val(obj.shareMethod);
                $("input[name='isOpen'][value="+obj.isOpen+"]").attr("checked",true);
                $("#shareCondition").val(obj.shareCondition);
                $("#openCondition").val(obj.openCondition);
                $("#datasetDesc").val(obj.datasetDesc);
                //大普查信息
                if(obj.survey != undefined && obj.survey !=""){
                    $("#totalStorage").val(obj.survey.totalStorage);
                    $("#structureCount").val(obj.survey.structureCount);
                    $("#sharedStorage").val(obj.survey.sharedStorage);
                    $("#sharedStructureCount").val(obj.survey.sharedStructureCount);
                    $("#openedStorage").val(obj.survey.openedStorage);
                    $("#openedStructureCount").val(obj.survey.openedStructureCount);
                }
                //生成信息项
                var itemList = obj.items;
                for (var i in itemList){
                    var thisTrNum = getTrNum();
                    buildItem(thisTrNum,itemList[i]);
                }
            }
        }
    });
}

function initButtonClickEvent(){
    //点击添加信息项按钮，新增一行表格
    $("#N_add_itemH").on("click",function(){
        var thisTrNum=0;
        var trNums=$('#dataitemList tr').length;
        if(trNums>0){
            $('#dataitemList tr').each(function(){
                var maxTrNum=$(this).find('input:first').attr('trNum');
                if(maxTrNum>thisTrNum){
                    thisTrNum=maxTrNum;
                }
            });
            thisTrNum++;
        }
        $('#dataitemList').prepend('<tr id="tr_'+thisTrNum+'">'+'<td><input trNum='+thisTrNum+' type="checkbox"></td>'
        +'<td><input trNum='+thisTrNum+' name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control"></td>'+
        +'<td><input name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control"></td>'
        +'<td><select name="items['+thisTrNum+'].itemType" data-rule="类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType")+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemLength" data-rule="integer(+);" type="number"  min="1" type="text" class="form-control"></td>'
        +'<td><input type="hidden" name="items['+thisTrNum+'].belongDeptId" > <input class="form-control" type="text" disabled > </td>'
        //+'<td><input class="form-control" type="text"  value="'+(data.dataset_name?data.dataset_name:'')+'"></td>'
        //+'<td><input type="hidden" name="items['+thisTrNum+'].belongSystemId" value="'+(data.system_id?data.system_id:'')+'"> <input class="form-control" type="text" disabled value="'+(data.system_name?data.system_name:'')+'" > </td>'
        +'<td><select name="items['+thisTrNum+'].secretFlag" data-rule="涉密标识:required;" class="form-control"><option value="1">是</option><option value="0">否</option></select></td>'
        +'<td><select name="items['+thisTrNum+'].shareType" data-rule="共享类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType")+'</select></td>'
        +'<td><input class="form-control" type="text" name="items['+thisTrNum+'].shareCondition" ></td>'
        +'<td><select name="items['+thisTrNum+'].shareMethod" data-rule="共享方式:required;" class="form-control">'+Dict.selectsDom("dataSetShareMethod")+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].isOpen" class="form-control"><option value="1" selected>是</option><option value="0" >否</option></select></td>'
        +'<td><input name="items['+thisTrNum+'].openCondition" type="text" class="form-control" ></td>'
        +'<td><select name="items['+thisTrNum+'].storageLocation" data-rule="存储位置:required;" class="form-control">'+Dict.selectsDom("setItemStoreLocation")+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].updateFrequency" data-rule="更新周期:required;" class="form-control">'+Dict.selectsDom("setItemFrequency")+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemDesc" type="text" class="form-control" ></td></tr>');
    });

    //点击信息项表格的全选框
    $(document).on('click','#selectAllItem',function(){
        if(this.checked){
            $("#dataitemList :checkbox").prop("checked", true);
        }else{
            $("#dataitemList :checkbox").prop("checked", false);
        }
    });

    //点击信息项的删除按钮
    $(document).on('click','#deleteItems',function(){
        $("#dataitemList").find('input[type="checkbox"]:checked').each(function(){
            var trNum=$(this).attr('trNum');
            infoTableDel(trNum);
        })
    });
}

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
        +'<td><input value="'+data.itemName+'" name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control">'
        +'<input type="hidden" name="items['+thisTrNum+'].id" value="'+data.id+'"></td>'
        +'<td><select name="items['+thisTrNum+'].itemType" data-rule="类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType",data.itemType?data.itemType:'')+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemLength" data-rule="长度:required;integer(+);" type="number" value="'+(data.itemLength?data.itemLength:'')+'" min="1" type="text" class="form-control"></td>'
        +'<td><input type="hidden" name="items['+thisTrNum+'].belongDeptId" value="'+(data.belongDept?data.belongDept:'')+'"> <input class="form-control" type="text" disabled value="'+(data.dept_short_name?data.dept_short_name:'')+'" > </td>'
        //+'<td><input class="form-control" type="text" disabled value="'+(data.dataset_name?data.dataset_name:'')+'"></td>'
        //+'<td><input type="hidden" name="items['+thisTrNum+'].belongSystemId" value="'+(data.system_id?data.system_id:'')+'"> <input class="form-control" type="text" disabled value="'+(data.system_name?data.system_name:'')+'" > </td>'
        +'<td><select name="items['+thisTrNum+'].secretFlag" class="form-control"><option value="1">是</option><option value="0">否</option></select></td>'
        +'<td><select name="items['+thisTrNum+'].shareType" data-rule="共享类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType",data.shareType?data.shareType:'')+'</select></td>'
        +'<td><input class="form-control" type="text" name="items['+thisTrNum+'].shareCondition" value="'+(data.shareCondition?data.shareCondition:'')+'"></td>'
        +'<td><select name="items['+thisTrNum+'].shareMethod" class="form-control">'+Dict.selectsDom("dataSetShareMethod",data.shareMethod?data.shareMethod:'')+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].isOpen" data-rule="是否开放:required;" class="form-control"><option value="1" selected>是</option><option value="0" >否</option></select></td>'
        +'<td><input name="items['+thisTrNum+'].openCondition" type="text" class="form-control" value="'+(data.openCondition?data.openCondition:'')+'"></td>'
        +'<td><select name="items['+thisTrNum+'].storageLocation" class="form-control">'+Dict.selectsDom("setItemStoreLocation",data.storageLocation?data.storageLocation:'')+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].updateFrequency" class="form-control">'+Dict.selectsDom("setItemFrequency",data.updateFrequency?data.updateFrequency:'')+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemDesc" type="text" class="form-control" value="'+(data.itemDesc?data.itemDesc:'')+'"></td></tr>';
    $('#dataitemList').prepend(str)
}

function infoTableDel(trNum){
    var trId = "tr_"+trNum;
    if($("#"+trId) != undefined){
        $("#"+trId).remove();
    }
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