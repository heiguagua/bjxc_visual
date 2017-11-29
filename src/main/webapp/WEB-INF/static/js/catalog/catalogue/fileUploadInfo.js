var tableSelector = '#uploadInfoTable';
var paramsObj = {};

jQuery(document).ready(function () {
    initButtonClickEvent();
    initTable();
});


function initTable(){
    //paramsObj["regionCode"] = $("#searchRegionCode").val();
    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirDatasetAttachment/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        },{
            field: 'fileName',
            title: '文件名称',
            sortable: false,
            formatter:function(value, row, index){
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'fileSize',
            title: '文件大小',
            sortable: false,
            width: '20%',
            formatter:function(value, row, index){
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'uploadTime',
            title: '上传时间',
            sortable: false,
            width: '20%',
            formatter:function(value, row, index){
                return '<p title="'+value+'">'+value+'</p>';
            }
        }]
    });
}

var i =1;
function initButtonClickEvent(){
    //点击查询按钮
    $('#upload_add_btn').click(function () {
        $("#newUploadDiv").append('<div id="div_'+i+'"><input  name="file'+i+'" type="file"  /><input type="button" value="删除"  onclick="delUploadInput('+i+')"/></div>');
        i = i + 1;
    });
    //点击上传按钮
    $('#upload_btn').click(function () {
        var formData = new FormData(document.getElementById("upload_form"));
        $.commonAjax({
            url:basePathJS + "/catalog/upLoadFile",
            data:formData,
            processData:false,
            contentType:false,
            success:function(result){
                if(result.state){
                    successMsgTip("上传成功!!");
                    reloadTable();
                }else{
                    errorMsgTip(result.msg);
                }
            },
            error : function(result){
                alert(JSON.stringify(result));
            }
        });
        /*$("#upload_form").ajaxSubmit({
            url:basePathJS + "/catalog/upLoadFile",
            type:"post",
            dataType:"json",
            success:function(result){
                if(result.state){
                    successMsgTip("上传成功!!");
                }else{
                    errorMsgTip(result.msg);
                }
            }
        });*/
    });
}

function delUploadInput(num){
    $("#div_"+num).remove();
}


function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}


