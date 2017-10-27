/**
 * Created by ZS on 2017/10/25.
 */
jQuery(document).ready(function () {
    $("#excelFile").change(changeFile) ;
    $("#excelWithOutDir").change(changeFileWithOutDir) ;
    console.log($("#classifyCode").val());
});

function changeFile(){
    var path = $("#excelFile").val();
    if(path != "" && checkExcelFormat()){
        ajaxFileUpload(path);
    }
}


function checkExcelFormat(){
    var flag = false;
    if(/\.(xls|xlsx|XLS|XLSX)$/.test($("#excelFile").val())){
        flag = true;
    }else{
        errorMsgTip("请导入正确的excel文件",parent);
    }
    return flag;
}

function ajaxFileUpload(url){
    $.ajaxFileUpload({
        url:basePathJS + '/catalog/excelImport',
        data:{regionCode : $.getSelectedRegionCode()},
        secureuri:false,
        type:'post',
        fileElementId:'excelFile',      //文件选择框的id属性
        dataType: 'json',
        contentType: false,
        processData: false,
        success: function (data) {
            if(data.state){
                successMsgTip(data.msg,parent);
                parent.reloadTable();
            }else{
                errorMsgTip(data.msg,parent);
            }
        },
        error: function(data, status, e){
            errorMsgTip("系统错误！请重试！", parent);
        },
        complete: function (xml,status) {
        }
    });
}


function changeFileWithOutDir(){
    var path = $("#excelWithOutDir").val();
    if(path != "" && checkExcelFormatWithOutDir()){
        ajaxFileUploadWithOutDir(path);
    }
}

function checkExcelFormatWithOutDir(){
    var flag = false;
    if(/\.(xls|xlsx|XLS|XLSX)$/.test($("#excelWithOutDir").val())){
        flag = true;
    }else{
        errorMsgTip("请导入正确的excel文件",parent);
    }
    return flag;
}

function ajaxFileUploadWithOutDir(url){
    $.ajaxFileUpload({
        url:basePathJS + '/catalog/excelImportWithOutDir',
        data:{regionCode : $.getSelectedRegionCode(),classifyId:$("#classifyId").val()},
        secureuri:false,
        type:'post',
        fileElementId:'excelWithOutDir',      //文件选择框的id属性
        dataType: 'json',
        contentType: false,
        processData: false,
        success: function (data) {
            if(data.state){
                successMsgTip(data.msg,parent);
                parent.reloadTable();
            }else{
                errorMsgTip(data.msg,parent);
            }
        },
        error: function(data, status, e){
            errorMsgTip("系统错误！请重试！", parent);
        },
        complete: function (xml,status) {
        }
    });
}