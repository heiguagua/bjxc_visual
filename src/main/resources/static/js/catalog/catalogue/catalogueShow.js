/**
 * Created by wuty on 2017/9/15
 */

jQuery(document).ready(function () {
    window.Dict=new dict();
    initAllSelect();  //初始化所有下拉框
    initInputValue(); //初始化所有需要设值的输入框的值
});

function initAllSelect(){
    //$.initClassifyTreeSelect('treeDemo','classifyName','classifyId','menuContent'); //初始化目录分类下拉框
    //$.initClassifyTreeSelect('relTreeDemo','relDatasetName','relDatasetCode','relMenuContent'); //初始化关联目录分类下拉框
    //$.initRegionDeptTreeSelect('belongDeptTypeTreeDemo','belongDeptTypeName','belongDeptType','belongDeptTypeMenuContent','belongDeptTypeCode')//初始化资源提供方下拉框;
    //信息资源格式下拉框初始化
    // Dict.selects('resourceFormat',['#formatCategory']);
    //共享类型
    // Dict.selects('dataSetShareType',['#shareType']);
    //共享方式
    // Dict.selects('dataSetShareMethod',['#shareMethod']);
    //更新周期
    // Dict.selects('setItemFrequency',['#updateFrequency']);

    /*$("#formatCategory").on("change",function(){
        var selectedValue = $(this).children('option:selected').val();
        if(selectedValue!=""){
            Dict.cascadeSelects('resourceFormat', ['#formatType'], selectedValue);
        }
    });*/
}

function initInputValue(){
    //初始化资源提供方和提供方代码输入框的值
    $.commonAjax({
        url:basePathJS + "/catalog/showLoad",
        data:{id:$("#id").val()},
        success: function (result) {
            if (result.state) {
                var obj = result.content.vo;
                var dataStatus = obj.classifyStatus;
                if(dataStatus == '0'){
                    hideAllInfo();
                }else if(dataStatus == '1'){
                    initInfoForRegiste();
                }else if(dataStatus == '2' || dataStatus == '3' || dataStatus == '4'){
                    initInfoForAudit();
                }else if(dataStatus == '5'){
                    initInfoForRelease();
                }else{
                    initAllInfo();
                }
                $("#classifyName").val(obj.classifyName);
                $("#classifyName").attr("title",obj.classifyName);
                $("#relDatasetName").val(obj.relClassifyName);
                $("#relDatasetName").attr("title",obj.relClassifyName);
                $("#datasetName").val(obj.datasetName);
                $("#infoResourceCode").val(obj.infoResourceCode);
                $("#belongDeptTypeName").val(obj.regionDeptName);
                $("#belongDeptName").val(obj.belongDeptName);
                $("#belongDeptNo").val(obj.belongDeptNo);
                //$("#belongDeptId").val(obj.belongDeptId);
                if(obj.ext != undefined && obj.ext !=""){
                    $("#formatCategory").val(Dict.label("resourceFormat",obj.ext.formatCategory));
                    $("#formatType").val(Dict.label("resourceFormat",obj.ext.formatType));
                    // $("#formatCategory").val(obj.ext.formatCategory);
                    // $("#formatCategory").change();
                    // $("#formatType").val(obj.ext.formatType);
                }
                // $("input[name='secretFlag'][value="+obj.secretFlag+"]").attr("checked",true);
                $("#updateFrequency").val(Dict.label("setItemFrequency",obj.updateFrequency));
                $("#shareType").val(Dict.label("dataSetShareType",obj.shareType));
                $("#shareMethod").val(Dict.label("dataSetShareMethod",obj.shareMethod));
                $("#secretFlag").val(Dict.label("isSecret",obj.secretFlag));
                $("#isOpen").val(Dict.label("ordinary",obj.isOpen));

                // $("#updateFrequency").val(obj.updateFrequency);
                // $("#shareType").val(obj.shareType);
                // $("#shareMethod").val(obj.shareMethod);
                // $("input[name='isOpen'][value="+obj.isOpen+"]").attr("checked",true);
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
                if(obj.sourceType == '2' || obj.sourceType == '5'){
                    $("#firstTh").before("<th>字段名</th>");
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

function hideAllInfo() {
    $("#registeInfo").hide();
    $("#auditInfo").hide();
    $("#releaseInfo").hide();
    $("#offlineInfo").hide();
}

function initInfoForRegiste() {
    $("#auditInfo").hide();
    $("#releaseInfo").hide();
    $("#offlineInfo").hide();
    initRegisteValue();
}

function initInfoForAudit() {
    $("#releaseInfo").hide();
    $("#offlineInfo").hide();
    initRegisteValue();
    initAuditValue();
}

function initInfoForRelease() {
    $("#offlineInfo").hide();
    initRegisteValue();
    initAuditValue();
    initReleaseValue();
}

function initAllInfo() {
    initRegisteValue();
    initAuditValue();
    initReleaseValue();
    initOfflineValue();
}

//初始化注册信息
function initRegisteValue(){
    $.commonAjax({
        url:basePathJS + "/catalog/registeInfoById",
        data:{dcmId:$("#id").val()},
        success: function (result) {
            if (result.state) {
                var obj = result.content.vo;
                $("#registeUser").val(obj.registerName);
                $("#registeDate").val(obj.registerDate);
            }
        }
    });
}
//初始化审核信息
function initAuditValue(){
    $.commonAjax({
        url:basePathJS + "/catalog/auditInfoById",
        data:{dcmId:$("#id").val()},
        success: function (result) {
            if (result.state) {
                var obj = result.content.vo;
                $("#auditUser").val(obj.auditorName);
                $("#auditDate").val(obj.auditDate);
                $("#auditOpinion").val(obj.auditOpinion);
            }
        }
    });
}
//初始化发布信息
function initReleaseValue(){
    $.commonAjax({
        url:basePathJS + "/catalog/releaseInfoById",
        data:{dcmId:$("#id").val()},
        success: function (result) {
            if (result.state) {
                var obj = result.content.vo;
                $("#releaseUser").val(obj.publisherName);
                $("#releaseDate").val(obj.publishDate);
            }
        }
    });
}
//初始化下架信息
function initOfflineValue(){
    $.commonAjax({
        url:basePathJS + "/catalog/offlineInfoById",
        data:{dcmId:$("#id").val()},
        success: function (result) {
            if (result.state) {
                var obj = result.content.vo;
                $("#offlineUser").val(obj.offlineUserName);
                $("#offlineDate").val(obj.offlineTime);
            }
        }
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

function buildItem(thisTrNum,data,sourceType){
    var str2 = "";
    if(sourceType == '2' || sourceType == '5'){
        str2 = '<td><input readonly trNum='+thisTrNum+' value="'+(data.columnName?data.columnName:'')+'" data-rule="字段名:required;" disabled type="text" class="form-control"></td>';
    }
    var str1='<tr id="tr_'+thisTrNum+'">';
    var str3='<td><input readonly value="'+data.itemName+'" name="items['+thisTrNum+'].itemName" type="text" class="form-control"></input></td>'
        +'<td><input readonly title="'+Dict.label("dataitemType",data.itemType)+'" value="'+Dict.label("dataitemType",data.itemType)+'"  type="text" class="form-control"></input></td>'
        +'<td><input readonly name="items['+thisTrNum+'].itemLength"  type="number" value="'+(data.itemLength?data.itemLength:'')+'" min="1" type="text" class="form-control"></td>'
        +'<td><input type="hidden" name="items['+thisTrNum+'].belongDeptId" value="'+(data.belongDept?data.belongDept:'')+'"><input class="form-control" type="text" readonly title="'+(data.deptName?data.deptName:'')+'" value="'+(data.deptName?data.deptName:'')+'" ></td>'
        +'<td><input readonly title="'+Dict.label("isSecret",data.secretFlag == null ? "" : data.secretFlag.toString())+'" value="'+Dict.label("isSecret",data.secretFlag == null ? "" : data.secretFlag.toString())+'"  type="text" class="form-control"></input></td>'
        +'<td><input readonly title="'+Dict.label("dataSetShareType",data.shareType)+'" value="'+Dict.label("dataSetShareType",data.shareType)+'"  type="text" class="form-control"></input></td>'
        +'<td><input readonly class="form-control" type="text" name="items['+thisTrNum+'].shareCondition" value="'+(data.shareCondition?data.shareCondition:'')+'"></td>'
        +'<td><input readonly title="'+Dict.label("dataSetShareMethod",data.shareMethod)+'" value="'+Dict.label("dataSetShareMethod",data.shareMethod)+'"  type="text" class="form-control"></input></td>'
        +'<td><input readonly  value="'+Dict.label("ordinary",data.isOpen)+'"  type="text" class="form-control"></input></td>'
        +'<td><input readonly name="items['+thisTrNum+'].openCondition" type="text" class="form-control" value="'+(data.openCondition?data.openCondition:'')+'"></td>'
        +'<td><input readonly title="'+Dict.label("setItemStoreLocation",data.storageLocation)+'" value="'+Dict.label("setItemStoreLocation",data.storageLocation)+'"  type="text" class="form-control"></input></td>'
        +'<td><input readonly title="'+Dict.label("setItemFrequency",data.updateFrequency)+'" value="'+Dict.label("setItemFrequency",data.updateFrequency)+'"  type="text" class="form-control"></input></td>'
        +'<td><input readonly name="items['+thisTrNum+'].itemDesc" type="text" class="form-control" value="'+(data.itemDesc?data.itemDesc:'')+'"></input></td></tr>';
    if(str2 != ""){
        $('#dataitemList').prepend(str1+str2+str3);
    }else{
        $('#dataitemList').prepend(str1+str3);
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