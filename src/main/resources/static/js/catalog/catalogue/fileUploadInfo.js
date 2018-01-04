var tableSelector = '#uploadInfoTable';
var paramsObj = {};

jQuery(document).ready(function () {
    initInput();
    // initButtonClickEvent();
    initTable();
});

function initInput() {
    $("#fileInput").fileinput({
        language: 'zh', //设置语言
        uploadUrl: basePathJS + "/catalog/upLoadFile", //上传的地址
        allowedFileExtensions: ['jpg', 'gif', 'png','jpeg','pdf','xlsx','xls','xlsm','zip','rar','doc','docx'],//接收的文件后缀
        uploadExtraData:{"id": $("#id").val()},
        uploadAsync: true, //默认异步上传
        showUpload: true, //是否显示上传按钮
        showRemove : true, //显示移除按钮
        showPreview : true, //是否显示预览
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        dropZoneEnabled: false,//是否显示拖拽区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        maxFileSize: 50120,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        maxFileCount: 5, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
    });

    //异步上传失败返回结果处理
    $('#fileInput').on('fileerror', function(event, data, msg) {
        errorMsgTip(result.msg);
    });

    //异步上传成功返回结果处理
    $("#fileInput").on("fileuploaded", function (event, data, previewId, index) {
        successMsgTip("上传成功!!");
        setParam();
        reloadTable();
    });
}

function initTable(){
    //paramsObj["regionCode"] = $("#searchRegionCode").val();
    paramsObj["datasetId"] = $("#id").val();
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
    //点击增加一行按钮
    /*$('#upload_add_btn').click(function () {
     $("#newUploadDiv").append('<div id="div_'+i+'"><input  name="file'+i+'" type="file"  /><input type="button" value="删除"  onclick="delUploadInput('+i+')"/></div>');
     i = i + 1;
     });*/
    //点击上传按钮
    $('#upload_btn').click(function () {
        var formData = new FormData(document.getElementById("upload_form"));
        if($("#fileInput").val()){
            $.commonAjax({
                url:basePathJS + "/catalog/upLoadFile",
                data:formData,
                processData:false,
                contentType:false,
                success:function(result){
                    if(result.state){
                        successMsgTip("上传成功!!");
                        setParam();
                        reloadTable();
                    }else{
                        errorMsgTip(result.msg);
                    }
                },
                error : function(result){
                    alert(JSON.stringify(result));
                }
            });
        }
    });
}

function delUploadInput(num){
    $("#div_"+num).remove();
}

function setParam(){
    paramsObj["datasetId"] = $("#id").val();
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}


