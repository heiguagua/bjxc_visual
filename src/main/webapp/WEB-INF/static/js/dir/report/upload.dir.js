var tableSelector = '#catalogueTable';
var paramsObj = {};

jQuery(document).ready(function () {
    initTable();
    initAllSelect();
    initButtonClickEvent();
});

function initTable(){
    var regionCode = $.getSelectedRegionCode();
    paramsObj["regionCode"] = regionCode;
    paramsObj["mstatus"]=3
    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirupload/catalogueList',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
        columns: [{
            checkbox: true,
            align: 'center',
            valign: 'middle',
            sortable: false
        },{
            field: 'datasetName',
            title: '信息资源名称',
            sortable: false,
            width: '20%',
            formatter:function(value, row, index){
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'classifyName',
            title: '所属目录分类',
            sortable: false,
            formatter:function(value, row, index){
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'serviceNum',
            title: '数据服务',
            sortable: false,
            width: '10%',
            formatter:function(value,row,index){
            	if (value!=null && value!=undefined && value!=0){
            		return "已封装";
            	}else{
            		return "未封装";
            	}
            }
        },{
            field: 'datasetSourceTypeName',
            title: '上报类型',
            sortable: false,
            width: '10%',
            formatter:function(value, row, index){
            	var SOURCE_DIR="";
        		var DATA_SERVICE="";
        		
//        		var DATA_SOURCE="<label class='radio no-radio'></label>数据资源<br>";
            	if (row.transfer==null || row.transfer.trasnferScope==undefined || row.transfer.trasnferScope==null){
            		SOURCE_DIR="<label class='radio no-radio'></label><span class='radio-text'>资源目录</span><br>";
            		DATA_SERVICE="<label class='radio no-radio'></label><span class='radio-text'>数据服务</span><br>";
//            		 DATA_SOURCE="<label class='radio no-radio'></label>数据资源<br>";
            	}else if (row.transfer.trasnferScope=='1'){
            		SOURCE_DIR="<label class='radio pass-radio'></label><span class='radio-text'>资源目录</span><br>";
            		DATA_SERVICE="<label class='radio no-radio'></label><span class='radio-text'>数据服务</span><br>";
//            		 DATA_SOURCE="<label class='radio no-radio'></label>数据资源<br>";
            	}else if (row.transfer.trasnferScope=='2'){
            		SOURCE_DIR="<label class='radio no-radio'></label><span class='radio-text'>资源目录</span><br>";
            		DATA_SERVICE="<label class='radio pass-radio'></label><span class='radio-text'>数据服务</span><br>";
//            		 DATA_SOURCE="<label class='radio no-radio'></label>数据资源<br>";
            	}else if (row.transfer.trasnferScope=='3'){
            		SOURCE_DIR="<label class='radio no-radio'></label><span class='radio-text'>资源目录</span><br>";
            		DATA_SERVICE="<label class='radio no-radio'></label><span class='radio-text'>数据服务</span><br>";
//            		DATA_SOURCE="<label class='radio pass-radio'></label>数据资源<br>";
            	}else if (row.transfer.trasnferScope=='12'){
            		SOURCE_DIR="<label class='radio pass-radio'></label><span class='radio-text'>资源目录</span><br>";
            		DATA_SERVICE="<label class='radio pass-radio'></label><span class='radio-text'>数据服务</span><br>";
//            		DATA_SOURCE="<label class='radio no-radio'></label>数据资源<br>";
            	}
            	else if (row.transfer.trasnferScope=='13'){
            		SOURCE_DIR="<label class='radio pass-radio'></label><span class='radio-text'>资源目录</span><br>";
            		DATA_SERVICE="<label class='radio no-radio'></label><span class='radio-text'>数据服务</span><br>";
//            		DATA_SOURCE="<label class='radio pass-radio'></label>数据资源<br>";
            	}else if (row.transfer.trasnferScope=='23'){
            		SOURCE_DIR="<label class='radio no-radio'></label><span class='radio-text'>资源目录</span><br>";
            		DATA_SERVICE="<label class='radio pass-radio'></label class='radio-text'><span>数据服务</span><br>";
//            		DATA_SOURCE="<label class='radio pass-radio'></label>数据资源<br>";
            	}
            	//console.log(row.transfer)
                return SOURCE_DIR+DATA_SERVICE;
            }
        }, {
            field: 'id',
            title: '操作',
            width: '10%',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter: function(value, row, index) {
                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-edit'>&#160;</i>查看</a>";
                return editBtn;
            }
        }]
    });
}


function initAllSelect(){
    //目录类别下拉查询框
    $.initQueryClassifyTreeSelect('searchClassifyTreeDemo','searchClassifyName','searchClassifyId','searchClassifyMenuContent');
}


function initButtonClickEvent(){
    //点击查询按钮
    $('#queryBtn').click(function () {
        setParams();
        reloadTable();
    });
   
}

function setParams() {
    var searchClassifyId = $('#searchClassifyId').val();
    var searchName = $('#searchName').val();
    var regionCode = $.getSelectedRegionCode();
    paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode,mstatus:3};
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

/**
 * 上传
 */
function uploadDir(){
	var ids=$(tableSelector).bootstrapTable('getSelections', 'none');
	var arr=getIdArray(ids);
	if (arr==null){
		return;
	}
	requirementAdd("目录上报", basePathJS+"/dirupload/uploadDirPage?scmIdArr="+arr, "60%", "500px")
}
/**
 * 获取ID数组
 * @param ids
 * @returns
 */
function getIdArray(ids){
	if (ids == undefined||ids.length<=0){
		tip("当前没有行被选中。");
		return null;
	}
	var idArr= "";
	
	for (var i=0;i<ids.length;i++){
		idArr=idArr+ids[i].transferId+","
	}
	return idArr;
}
function catalogueTableShow(id){
    show('信息资源详情',basePathJS + '/catalog/show' , id ,1300,700);
}

