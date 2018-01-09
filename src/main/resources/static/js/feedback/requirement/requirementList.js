/**
 * Created by GongJun on 2017/10/28.
 */
/**
 * [ugChange 选择获取值]
 * @return {[type]} [description]
 */

var tableSelector = '#requirementListTable';
var paramsObj;

jQuery(document).ready(function () {
    paramsObj = {};
    getData();
    initButtonClickEvent();
});


function getRequirementTable(dd) {
    $(tableSelector).customTable({
        url: basePathJS + '/feedback/drapRequirementResources/list',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        pagination: true, //分页
        pageSize: 10,
        columns: [
            {
                field: 'id', title: '序号', width: '5%', align: 'center', formatter: function (value, row, index) {
                return index + 1;
            }
            },
            {
                field: 'requirementDeptName',
                title: '需求组织',
                width: '15%',
                formatter:function(value){
                    if(value == undefined){
                        value="";
                    }
                    return '<p title="'+value+'">'+value+'</p>';
                }
            },
            {
                field: 'providerDeptName',
                title: '提供组织',
                width: '15%',
                formatter:function(value){
                    if(value == undefined){
                        value="";
                    }
                    return '<p title="'+value+'">'+value+'</p>';
                }
            },
            {
                field: 'requireName',
                title: '需求资源',
                width: '15%',
                formatter:function(value){
                    if(value == undefined){
                        value="";
                    }
                    return '<p title="'+value+'">'+value+'</p>';
                }
            },
            {
                field: 'requireType',
                title: '需求类型',
                width: '10%',
                formatter: function (value) {
                    if(1==value){
                        return '手填';
                    }
                    if(2==value){
                        return '资源';
                    }
                    if(3==value){
                        return '接口';
                    }
                }
            },
            {
                field: 'id',
                title: '操作',
                width: '10%',
                valign: 'middle',
                sortable: false,
                formatter: function (value) {
                    var detailBtn = ["<a class='btn btn-success btn-flat btn-xs' href='#' onclick='javascript:requirementDetail(\"" + value + "\",true)'><i class='fa fa-pencil'>&#160;</i>查看详情</a>&#160;"];
                    return detailBtn;
                }
            }
        ],
        data: dd
    });
}


/**
 * 获取表格数据
 * @param num 类型
 */
function getData() {
    var url = basePathJS + "/feedback/drapRequirementResources/list";
    $.get(url,paramsObj, function (d) {
        getRequirementTable(d.rows)
    })
}


function requirementDetail(id){
    show('需求资源详情', basePathJS + '/feedback/drapRequirementResources/loadDetailPage', id, 900, 700);
}


function initButtonClickEvent(){
    $("#queryButton").click(function () {
        setParams();
        reloadTable();
    });
}


function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function setParams() {
    var searchKeyVal = $('#editSearch').val();
    var regionCode = $.getSelectedRegionCode();
    paramsObj = {regionCode:regionCode, searchKey: searchKeyVal};
}







