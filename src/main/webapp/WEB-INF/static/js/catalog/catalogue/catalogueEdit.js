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
    var regionCode = $.getSelectedRegionCode();
    $.initClassifyTreeSelect('treeDemo','classifyName','classifyId','menuContent'); //初始化目录分类下拉框
    $.initRelClassifyTreeSelect('relTreeDemo','relDatasetName','relDatasetCode','relMenuContent','classifyId'); //初始化关联目录分类下拉框
    $.initRegionDeptTreeSelect('belongDeptTypeTreeDemo','belongDeptTypeName','belongDeptType','belongDeptTypeMenuContent')//初始化资源提供方下拉框;
    //$.initDeptTreeSelect('belongDeptTreeDemo','belongDeptName','belongDeptId','belongDeptMenuContent',false,{regionCode:regionCode});
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
                $("#relDatasetName").val(obj.relClassifyName);
                $("#relDatasetCode").val(obj.relDatasetCode);
                $("#datasetName").val(obj.datasetName);
                $("#infoResourceCode").val(obj.infoResourceCode);
                $("#belongDeptType").val(obj.belongDeptType);
                $("#belongDeptTypeName").val(obj.regionDeptName);
                //$("#belongDeptId").val(obj.belongDeptId);
                $("#belongDeptName").val(obj.belongDeptName);
                $("#belongDeptNo").val(obj.belongDeptNo);
                $("#chargeDeptId").val(obj.chargeDeptId);
                if(obj.ext != undefined && obj.ext !=""){
                    $("#formatCategory").val(obj.ext.formatCategory);
                    $("#formatCategory").change();
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
                if(obj.sourceType != "1" && obj.sourceType != "7"){
                    $("#N_add_itemH").hide();
                }
                if(obj.sourceType == '4' || obj.sourceType == '6'|| obj.sourceType == '8'){
                    $("#deleteItems").hide();
                }
                if(obj.sourceType == '2' || obj.sourceType == '5'){
                    $("#firstTh").after("<th>字段名</th>");
                }
                var itemList = obj.items;
                for (var i in itemList){
                    var thisTrNum = getTrNum();
                    buildItem(thisTrNum,itemList[i],obj.sourceType);
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
                if(parseInt(maxTrNum)>parseInt(thisTrNum)){
                    thisTrNum=maxTrNum;
                }
            });
            thisTrNum++;
        }
        $('#dataitemList').prepend('<tr id="tr_'+thisTrNum+'">'+'<td><input trNum='+thisTrNum+' type="checkbox"></td>'
        +'<td><input trNum='+thisTrNum+' name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control"></td>'+
        +'<td><input name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control"></td>'
        +'<td><select name="items['+thisTrNum+'].itemType" data-rule="类型:required;" class="form-control">'+Dict.selectsDom("dataitemType")+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemLength" data-rule="长度:required;integer(+);" type="number"  min="1" type="text" class="form-control">'
        +'<td><input type="text" id="deptName_'+thisTrNum+'" data-rule="责任部门:required;" readonly="readonly" class="form-control" style="background-color: #FFFFFF;"><input type="hidden" id="deptId_'+thisTrNum+'" name="items['+thisTrNum+'].belongDeptId" >' +
            '<div class="menu-wrap"><div id="menuContent_'+thisTrNum+'" class="menuContent" style="display:none;"><ul id="treeDemo_'+thisTrNum+'" class="ztree"style="margin-top:0;border: 1px solid #98b7a8;"></ul></div></div></td>'
            //+'<td><input class="form-control" type="text"  value="'+(data.dataset_name?data.dataset_name:'')+'"></td>'
        //+'<td><input type="hidden" name="items['+thisTrNum+'].belongSystemId" value="'+(data.system_id?data.system_id:'')+'"> <input class="form-control" type="text" disabled value="'+(data.system_name?data.system_name:'')+'" > </td>'
        +'<td><select name="items['+thisTrNum+'].secretFlag" class="form-control"><option value=1>是</option><option value=0>否</option></select></td>'
        +'<td><select name="items['+thisTrNum+'].shareType" data-rule="共享类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType")+'</select></td>'
        +'<td><input class="form-control" type="text" name="items['+thisTrNum+'].shareCondition" ></td>'
        +'<td><select name="items['+thisTrNum+'].shareMethod" data-rule="共享方式:required;" class="form-control">'+Dict.selectsDom("dataSetShareMethod")+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].isOpen" class="form-control"><option value="1" selected>是</option><option value="0" >否</option></select></td>'
        +'<td><input name="items['+thisTrNum+'].openCondition" type="text" class="form-control" ></td>'
        +'<td><select name="items['+thisTrNum+'].storageLocation" class="form-control">'+Dict.selectsDom("setItemStoreLocation")+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].updateFrequency" class="form-control">'+Dict.selectsDom("setItemFrequency")+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemDesc" type="text" class="form-control" ></td></tr>');

        //数据集与信息项共有的属性,如果数据集已经设值了,那新增一行时,就把这些值带入信息项
        $.initDeptTreeSelect('treeDemo_'+thisTrNum,'deptName_'+thisTrNum,'deptId_'+thisTrNum,'menuContent_'+thisTrNum,false,{regionCode: $.getSelectedRegionCode()},null,null,null);
        $("select[name='items["+thisTrNum+"].secretFlag']").val($("input[name='secretFlag']:checked").val());
        $("select[name='items["+thisTrNum+"].shareType']").val($("#shareType").val());
        $("select[name='items["+thisTrNum+"].shareMethod']").val($("#shareMethod").val());
        $("select[name='items["+thisTrNum+"].isOpen']").val($("input[name='isOpen']:checked").val());
        $("select[name='items["+thisTrNum+"].updateFrequency']").val($("#updateFrequency").val());
        $("input[name='items["+thisTrNum+"].shareCondition']").val($("#shareCondition").val());
        $("input[name='items["+thisTrNum+"].openCondition']").val($("#openCondition").val());
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
            if(parseInt(i)>parseInt(maxNum)){
                maxNum=i;
            }
        })
        thisTrNum=parseInt(maxNum)+1;
    }
    return thisTrNum;
}

function buildItem(thisTrNum,data,sourceType){
    var str2 = "";
    var str4 = "";
    if(sourceType == '2' || sourceType == '5'){
        str2 = '<td><input trNum='+thisTrNum+' value="'+(data.columnName?data.columnName:'')+'" data-rule="字段名:required;" disabled type="text" class="form-control"></td>';
    }
    if(sourceType == '1' || sourceType == '4'){
        str4 = '<td><input type="text" id="deptName_'+thisTrNum+'" data-rule="责任部门:required;" readonly="readonly" class="form-control" style="background-color: #FFFFFF;"><input type="hidden" id="deptId_'+thisTrNum+'" name="items['+thisTrNum+'].belongDeptId" >' +
        '<div class="menu-wrap"><div id="menuContent_'+thisTrNum+'" class="menuContent" style="display:none;"><ul id="treeDemo_'+thisTrNum+'" class="ztree"style="margin-top:0;border: 1px solid #98b7a8;"></ul></div></div></td>';
    }else{
        str4 = '<td><input type="hidden" name="items['+thisTrNum+'].belongDeptId" value="'+(data.belongDeptId?data.belongDeptId:'')+'"><input class="form-control" type="text" disabled value="'+(data.deptName?data.deptName:'')+'" ></td>';
    }
    var str1='<tr id="tr_'+thisTrNum+'">'+'<td><input trNum='+thisTrNum+' type="checkbox"></td>';
    var str3='<td><input value="'+data.itemName+'" name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control">'
        +'<input type="hidden" name="items['+thisTrNum+'].id" value="'+data.id+'"></td>'
        +'<td><select name="items['+thisTrNum+'].itemType" data-rule="类型:required;" class="form-control">'+Dict.selectsDom("dataitemType",data.itemType?data.itemType:'')+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemLength" data-rule="长度:required;integer(+);" type="number" value="'+(data.itemLength?data.itemLength:'')+'" min="1" type="text" class="form-control"></td>';
    var str5='<td><select name="items['+thisTrNum+'].secretFlag" class="form-control">'+Dict.selectsDom("ordinary",data.isOpen?data.isOpen:'')+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].shareType" data-rule="共享类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType",data.shareType?data.shareType:'')+'</select></td>'
        +'<td><input class="form-control" type="text" name="items['+thisTrNum+'].shareCondition" value="'+(data.shareCondition?data.shareCondition:'')+'"></td>'
        +'<td><select name="items['+thisTrNum+'].shareMethod" class="form-control">'+Dict.selectsDom("dataSetShareMethod",data.shareMethod?data.shareMethod:'')+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].isOpen" data-rule="是否开放:required;" class="form-control">'+Dict.selectsDom("ordinary",data.isOpen?data.isOpen:'')+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].openCondition" type="text" class="form-control" value="'+(data.openCondition?data.openCondition:'')+'"></td>'
        +'<td><select name="items['+thisTrNum+'].storageLocation" class="form-control">'+Dict.selectsDom("setItemStoreLocation",data.storageLocation?data.storageLocation:'')+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].updateFrequency" class="form-control">'+Dict.selectsDom("setItemFrequency",data.updateFrequency?data.updateFrequency:'')+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemDesc" type="text" class="form-control" value="'+(data.itemDesc?data.itemDesc:'')+'"></td></tr>';
    if(str2 != ""){
        $('#dataitemList').prepend(str1+str2+str3+str4+str5);
    }else{
        $('#dataitemList').prepend(str1+str3+str4+str5);
    }
    if(sourceType == '1' || sourceType == '4'){
        $("#deptName_"+thisTrNum).val(data.deptName?data.deptName:'');
        $.initDeptTreeSelect('treeDemo_'+thisTrNum,'deptName_'+thisTrNum,'deptId_'+thisTrNum,'menuContent_'+thisTrNum,false,{regionCode: $.getSelectedRegionCode()},data.belongDeptId?[{id:data.belongDeptId}]:null,null,null);
    }
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