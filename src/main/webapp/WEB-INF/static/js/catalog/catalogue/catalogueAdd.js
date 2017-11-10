/**
 * Created by wuty on 2017/9/15
 */

jQuery(document).ready(function () {
    window.Dict=new dict();
    initAllSelect();  //初始化所有下拉框
    initInputValue(); //初始化所有需要设值的输入框的值
    initButtonClickEvent(); //初始化按钮点击事件
});

function initAllSelect(){
    var regionCode = $.getSelectedRegionCode();
    //$.initClassifyTreeSelect('treeDemo','classifyName','classifyId','menuContent'); //初始化目录分类下拉框
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
        url:basePathJS + "/system/dept/getDeptInfoForLoginUser",
        success: function (result) {
            if (result.state) {
                var deptObj = result.content.vo;
                $("#chargeDeptId").val(deptObj.id);
            }
        }
    });
}

function initButtonClickEvent(){
    //点击添加信息项按钮，新增一行表格
    $("#addItem").on("click",function(){
        var thisTrNum=0;
        var trNums=$('#dataitemList tr').length;
        if(trNums>0){
            $('#dataitemList tr').each(function(){
                var maxTrNum=$(this).find('input:first').attr('trNum');
                if(parseInt(maxTrNum)>thisTrNum){
                    thisTrNum=maxTrNum;
                }
            });
            thisTrNum++;
        }
        $('#dataitemList').prepend('<tr id="tr_'+thisTrNum+'">'+'<td><input trNum='+thisTrNum+' type="checkbox"></td>'
        +'<td><input trNum='+thisTrNum+' name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control"></td>'
        +'<td><select name="items['+thisTrNum+'].itemType" data-rule="类型:required;" class="form-control">'+Dict.selectsDom("dataitemType")+'</select></td>'
        +'<td><input name="items['+thisTrNum+'].itemLength" data-rule="长度:required;integer(+);" type="number"  min="1" class="form-control"></td>'
        +'<td><input type="text" id="deptName_'+thisTrNum+'" required="required"data-parsley-required-message="该项为必填" class="form-control"><input type="hidden" id="deptId_'+thisTrNum+'" name="items['+thisTrNum+'].belongDeptId" >' +
            '<div class="menu-wrap"><div id="menuContent_'+thisTrNum+'" class="menuContent" style="display:none;"><ul id="treeDemo_'+thisTrNum+'" class="ztree"style="margin-top:0;border: 1px solid #98b7a8;"></ul></div></div></td>'
        +'<td><select name="items['+thisTrNum+'].secretFlag" class="form-control"><option value="1">是</option><option value="0">否</option></select></td>'
        +'<td><select name="items['+thisTrNum+'].shareType" data-rule="共享类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType")+'</select></td>'
        +'<td><input class="form-control" type="text" name="items['+thisTrNum+'].shareCondition" ></td>'
        +'<td><select name="items['+thisTrNum+'].shareMethod" class="form-control">'+Dict.selectsDom("dataSetShareMethod")+'</select></td>'
        +'<td><select name="items['+thisTrNum+'].isOpen" data-rule="是否开放:required;" class="form-control"><option value="1" selected>是</option><option value="0" >否</option></select></td>'
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

    //点击确定按钮
    /*$('#addForm').on('form:submit',function(form) {
        // 获取触发提交表单的对象
        var formdata = form.$element.serialize();
        $.commonAjax({  //先验证数据集名称在选择的目录类别下是否重复
            url:basePathJS + "/catalog/checkDatasetName",
            data:{datasetName:$("#datasetName").val(),classifyIds:$("#classifyId").val()},
            success:function(result){
                if(result.state){
                    $.commonAjax({ //名称不重复，插入数据库
                        url:basePathJS + "/catalog/doAdd",
                        data:formdata,
                        success:function(result){
                            if(result.state){
                                successMsgTip("新增成功！！");
                            }else{
                                errorMsgTip(result.msg);
                            }
                        }
                    })
                }else{
                    errorMsgTip(result.msg);
                }
            }
        });
        var operate = "add";
        var url = CONTEXT_PATH+ '/admin/Dataset_addDataset';
        var tagArr = [];
        var set_name=form.fields[0].value;
        submitForm(url, formdata + '&tags=['+ tagArr + ']' + "&operate="+ operate
            ,'set', "modal-add","add",set_name);
        return false;
    });*/
}

function infoTableDel(trNum){
    var trId = "tr_"+trNum;
    if($("#"+trId) != undefined){
        $("#"+trId).remove();
    }
}


function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    /*$.commonAjax({  //先验证数据集名称在选择的目录类别下是否重复
        url:basePathJS + "/catalog/checkDatasetName",
        async:false,
        data:{datasetName:$("#datasetName").val(),classifyIds:$("#classifyId").val()},
        success:function(result){
            if(result.state){
                var hasThisName = result.content.hasThisName;
                if(hasThisName){
                    errorMsgTip("该分类下，已存在名称为："+$("#datasetName").val()+" 的信息资源！！");
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }
    });*/
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