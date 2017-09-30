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
    $.initClassifyTreeSelect('treeDemo','classifyName','classifyId','menuContent'); //初始化信息资源分类下拉框
    $.initClassifyTreeSelect('relTreeDemo','relDatasetName','relDatasetCode','relMenuContent'); //初始化关联信息资源分类下拉框
    //信息资源格式下拉框初始化
    Dict.selects('dataSetStoreMedia',['#format_category']);
    //共享类型
    Dict.selects('dataSetShareType',['#shareType']);
    //共享方式
    Dict.selects('dataSetShareMethod',['#shareMethod']);
    //更新周期
    Dict.selects('setItemFrequency',['#updateFrequency']);
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
    $("#shareConditionDiv").hide();
    $("#shareType").on("change",function(){
        var selectedValue = $(this).children('option:selected').val();
        if(selectedValue=="2" || selectedValue==""){ //不予共享
            $("#shareConditionDiv").hide();
            $("#shareMethodDiv").hide();
        }else if(selectedValue=="0"){ //无条件共享
            $("#shareConditionDiv").hide();
            $("#shareMethodDiv").show();
        }else if(selectedValue=="1") { //有条件共享
            $("#shareConditionDiv").show();
            $("#shareMethodDiv").show();
        }
    });

    $("#format_category").on("change",function(){
        var selectedValue = $(this).children('option:selected').val();
        if(selectedValue!=""){
            Dict.cascadeSelects('dataSetStoreMedia', ['#format_type'], selectedValue);
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
                $("#belongDeptName").val(deptObj.deptName);
                $("#belongDepId").val(deptObj.id);
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

        /*$('#dataitemList').prepend('<tr id="tr_'+thisTrNum+'"><td><input trNum='+thisTrNum+' name="items['+thisTrNum+'].itemName" data-rule="信息项名称:required;" type="text" class="form-control"></td>'+
        '<td><select name="items['+thisTrNum+'].itemType" data-rule="类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType")+'</select></td>'+
        '<td><input name="items['+thisTrNum+'].itemLength" data-rule="integer(+);" type="number" min="1" type="text" class="form-control"></td>'+
        '<td><select name="items['+thisTrNum+'].shareType" data-rule="共享类型:required;" class="form-control">'+Dict.selectsDom("dataSetShareType")+'</select></td>'+
        '<td><input name="items['+thisTrNum+'].shareCondition" type="text" class="form-control" ></td>'+
        '<td><select name="items['+thisTrNum+'].shareMethod" data-rule="共享方式:required;" class="form-control">'+Dict.selectsDom("dataSetShareMethod")+'</select></td>'+
        '<td><select name="items['+thisTrNum+'].isOpen" class="form-control"><option value="1" selected>是</option><option value="0" >否</option></select></td>'+
        '<td><input name="items['+thisTrNum+'].openCondition" type="text" class="form-control" ></td>'+
        '<td><select name="items['+thisTrNum+'].storageMedium" data-rule="存储介质:required;" class="form-control">'+Dict.selectsDom("setItemStoreMedia")+'</select></td>'+
        '<td><select name="items['+thisTrNum+'].storageLocation" data-rule="存储位置:required;" class="form-control">'+Dict.selectsDom("setItemStoreLocation")+'</select></td>'+
        '<td><select name="items['+thisTrNum+'].storageLocation" data-rule="更新周期:required;" class="form-control">'+Dict.selectsDom("setItemFrequency")+'</select></td>'+
        '<td><input name="items['+thisTrNum+'].itemDesc" type="text" class="form-control" ></td>'+
        '<td><a class="btn btn-danger btn-flat btn-xs" href="javascript:;" onclick="javascript:infoTableDel(\''+thisTrNum+'\')"><i class="fa fa-close">&#160;</i>删除</a></td></tr>');*/
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