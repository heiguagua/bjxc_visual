/**
 * Created by zhanf on 2017/4/28.
 */
$(document).ready(function(){
    initEditPage();
    initTable();
});


//初始化编辑界面
function initEditPage(){
    var params = {id : $("#dirDataApplyId").val()};
    $.commonAjax({
        url: basePathJS + "/dirDataApply/editLoad",
        data: params,
        success: function (result) {
            if (result.state) {
                var vo = result.content.vo;
                $("#applicant").html(vo.realName + "[" + vo.userName + "]");
                $("#deptName").html(vo.deptName);
                $("#limitVisitCnt").html(vo.limitVisitCnt);
                $("#limitVisitDatePeriod").html(vo.limitVisitDatePeriod);
                $("#applyInfo").html(vo.applyInfo);
            }
        }
    });
    $("select[name='status']").change(function(){
        var status = $(this).val();
        $(".dirDataItemApplyList").val(status);
        if(status == '1'){
            $(".dirDataItemApplyList").enable();
        }else{
            $(".dirDataItemApplyList").attr("disabled", true);
        }
    });
    $('#auditVisitDatePeriod').customDateRangePicker();
}

function initTable(){
    var tableSelector = '#dirDataItemApplyTableId';
    var paramsObj = {dataApplyId : $("#dirDataApplyId").val()};
    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirDataApply/listItem',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 5,
        height: 360,
        columns: [{
            title: '序号',
            width: '50',
            formatter: function (value, row, index) {
                return index+1;
            }
        }, {
            field: 'itemName',
            title: '数据项',
            align: 'center',
            valign: 'middle',
            sortable: false
        }, {
            field: 'status',
            title: '审核情况',
            align: 'center',
            valign: 'middle',
            width: '100',
            sortable: false,
            formatter : function (value) {
                var result = "待审核";
                if(value == "1"){
                    result = "<font > 同意</font>"
                } else if (value == "2"){
                    result = "<font > 同意</font>"
                }
                return result;
            }
        }, {
            field: 'id',
            title: '操作',
            align: 'center',
            valign: 'middle',
            width: '150',
            sortable: false,
            formatter : function (value, row, index) {
                var id = '<input type="hidden" name="dirDataItemApplyList['+index+'].id" value="' + value + '">'
                var status = '<select class="form-control dirDataItemApplyList" name="dirDataItemApplyList['+index+'].status"><option value="1">同意</option><option value="2">拒绝</option></select>';
                return id + status;
            }
        }
        ]
    });
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