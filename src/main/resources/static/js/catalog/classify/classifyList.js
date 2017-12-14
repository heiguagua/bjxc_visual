var tableSelector = '#classifyTable';
var paramsObj = {};

jQuery(document).ready(function () {
    initCss();
    initAllSelect();
    initButtonClickEvent();
    initTable();
});

function initCss(){
    /* 目录编目收缩小侧边栏,用的adminlte */
    $(function(){
        $("#forward").hide();
        $("#dir-Manger").parent("div.user-panel").css("text-align","center")
        $("#backward").click(function(){
            $("#min-aside").animate({
                width:"2%"
            },200);
            $("#dir-Manger").hide();
            //$("#regionDiv").hide();
            $("#forward").show(400);
            $("#backward").hide(500);
            $("#treeDemo").hide(200);
            $("#min-aside").css("border","none")
            $("div.box div.content_table").animate({
                width: "98%"
            })

            $(this).parents("div.user-panel").css("background","#f4f6f9");
        })
        $("#forward").click(function(){
            $("div.box div.content_table").animate({
                width: "86%"
            },400)
            $("#min-aside").animate({
                width:"14%"
            },500);
            $("#dir-Manger").show();
            //$("#regionDiv").show();
            $("#forward").hide(400);
            $("#backward").show(500);
            $("#treeDemo").show(200);
            $("#min-aside").css("border","1px solid #ddd");

            $(".user-panel").css("background","none");
        })
    })

}

function initTable(){
    //paramsObj["regionCode"] = $("#searchRegionCode").val();
    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirClassify/pageList',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
//        escape:true,
        columns: [
           {
            field: 'classifyName',
            title: '目录名称',
            sortable: false,
            width: '10%',
            formatter:function(value, row, index){            	
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'classifyType',
            title: '目录种类',
            width: '8%',
            sortable: false,
            formatter:function(value, row, index){            	
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'classifyStructureName',
            title: '目录结构',
            sortable: false,
            width: '20%',
            formatter:function(value, row, index){
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'icon',
            title: '图标',
            sortable: false,
            width: '10%'
        },{
            field: 'orderNumber',
            title: '排序号',
            sortable: false,
            width: '10%',
            formatter:function(value, row, index){
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'classifyDesc',
            title: '目录描述',
            width: '10%',
            sortable: false,
            formatter:function(value, row, index){
            	if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        }, {
            field: 'id',
            title: '操作',
            width: '170px',
            align: 'center',
            valign: 'middle',
            sortable: false,
            formatter: function(value, row, index) {
            	var editBtn ="";
            	var deleteBtn ="";
            	var addNBtn ="";
            	if(row.classifyType == "1" || row.classifyType == '2-3'){
            		 
            	}else if(row.classifyType=='2-1' || row.classifyType=='2-2' || row.classifyType=='3'){
            		 addNBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:addNational(\"" + value + "\",\"" + row.classifyType + "\")'><i class='fa fa-times'></i> 导入国家库目录</a>";           		
            	}else if(row.classifyType == '5' || row.classifyType == '6'|| row.classifyType == '7'){
            		 editBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:editNode(\"" + value + "\")'><i class='fa fa-times'></i> 编辑</a>";
            		 deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteNode(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
            		 addNBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:addNational(\"" + value + "\",\"" + row.classifyType + "\")'><i class='fa fa-times'></i>导入国家库目录</a>";
            		
            	}else{
            		
            	}
            	           	
            	//                if(row.classifyStatus==0 || row.classifyStatus==2 || row.classifyStatus==4 || row.classifyStatus==6){
//                    editBtn = [
//                        "<p><a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:catalogueTableUpload(\"" + value + "\")'><i class='fa fa-pencil'>&#160;</i>导入国家库</a>&#160;" +
//                        "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:catalogueTableEdit(\"" + value + "\")'><i class='fa fa-pencil'>&#160;</i>编辑</a>&#160;",
////                        "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-eye'>&#160;</i>查看</a></p>"
//                    ].join('');
//                }else{
//                    editBtn = [
//                        "<p><a class='btn btn-danger btn-flat btn-xs' style='opacity: 0.2'><i class='fa fa-pencil'>&#160;</i>导入国家库</a>&#160;" +
//                        "<a class='btn btn-danger btn-flat btn-xs' style='opacity: 0.2'><i class='fa fa-pencil'>&#160;</i>编辑</a>&#160;",
////                        "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:catalogueTableShow(\"" + value + "\")'><i class='fa fa-eye'>&#160;</i>查看</a></p>"
//                    ].join('');
//                }
//            	if( treeNode.classifyType=='2-3' && treeNode.isLocal=='1'){	
//					
//				}else if(treeNode.classifyType=='2-1' || treeNode.classifyType=='2-2' || treeNode.classifyType=='3'){
//					aObj.after(editStr5);					
//					aObj.after(editStr4);
//				}else if(treeNode.classifyType == '5' || treeNode.classifyType == '6'|| treeNode.classifyType == '7'){
//					aObj.after(editStr2);
//					aObj.after(editStr1);
//					aObj.after(editStr3);
//					aObj.after(editStr4);
//				}else{
//					
//				}		
            	return editBtn + deleteBtn + addNBtn;
            }
        }]
    });
}






function initAllSelect(){
    //区域下拉查询框
    /*var initClassifyTreeParam = ["treeDemo","searchClassifyId","","classifyType"];
    $.initRegionQueryTreeSelect('searchRegionTreeDemo','searchRegionName','searchRegionCode',
        'searchRegionMenuContent',false,newRegionCode,initClassifyTreeParam);*/
    //初始化中间目录分类树
    $.initClassifyTree('treeDemo','searchClassifyId','','classifyType',newRegionCode);
}


function initButtonClickEvent(){
    //点击查询按钮
    $('#queryBtn').click(function () {
        setParams();
        reloadTable();
    });
    //点击删除按钮
    $('#catalogueDeleteButton').click(function () {
        //获取已选择的资源目录的id
        var selectedIds="";
        var selectedRow = $(tableSelector).bootstrapTable('getSelections');
        if(selectedRow && selectedRow.length > 0) {
            var isDealing = false;
            for (var i = 0, ii = selectedRow.length; i < ii; i++) {
                var id = selectedRow[i].id;
                var classifyStatus = selectedRow[i].classifyStatus;
                if(classifyStatus==1 || classifyStatus==3 || classifyStatus==5){
                    isDealing = true;
                    break;
                }else{
                    selectedIds += i == 0 ? id : "," + id;
                }
            }
            if(isDealing){
                errorMsgTip("只能删除状态为：待注册、审核不通过、审核驳回、已下架 的信息资源！！")
            }else{
                layer.confirm("删除信息资源,同时会删除其所有的信息项,确认要删除吗?", {icon: 3, title:"确认信息", zIndex: layer.zIndex}, function(index){
                    $.commonAjax({
                        url:basePathJS + "/catalog/doDelete",
                        data:{id:selectedIds},
                        success:function(result){
                            if(result.state){
                                successMsgTip(result.msg);
                                reloadTable();
                            }else{
                                errorMsgTip(result.msg);
                            }
                        }
                    });
                    layer.close(index);
                });
            }
        }else{
            errorMsgTip("请先选择要删除的信息资源");
        }
    });
}


function setParams() {
    var searchClassifyId = $('#searchClassifyId').val();
    var classifyType = $('#classifyType').val();
    if(classifyType == '2-3' || classifyType=='1'){
    	$('#addSibling').addClass('hidden');
    	$('#addSon').addClass('hidden');
    }else if(classifyType=='2-1' || classifyType=='2-2' || classifyType=='3'){
    	$('#addSibling').addClass('hidden');
    	$('#addSon').removeClass('hidden');
    }else if(classifyType == '5' || classifyType == '6'|| classifyType == '7'){
    	$('#addSibling').removeClass('hidden');
    	$('#addSon').removeClass('hidden');
    }else{
    	
    }
//    var searchName = $('#searchName').val();
    //var regionCode = $('#searchRegionCode').val();
    //paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};
    
    paramsObj = {fid:searchClassifyId};
}

function editNode(id){
	

	updateApi('编辑目录',basePathJS + '/dirClassify/edit' , id,900,500);
	
}

function deleteNode(id){
	
	var id = id;
	var url = basePathJS + "/dirClassify/delete";
    var parameter = {id: id};
    delObjApi(url , parameter) ;
	
}

function addNational(id,classifyType){
	
	var fid = id
//	var classifyType = $('#classifyType').val();
	addDirNational('新增国家库目录--子级',basePathJS + '/dirClassify/addNational',fid,classifyType,800,500);
}

function addSibling() {
	
	var fid=$('#fid').val();
	//$('#parent_id').val(api_fcode);	
	if(fid=="root"){
		 tip("无权限添加初始目录类别，请联系管理员。" );
		 return false;
	 }
	addDir('新增目录--同级',basePathJS + '/dirClassify/add' , fid,900,500);
}


function addSon() {
	
	var fid = $('#searchClassifyId').val();
	//$('#parent_id').val(api_fcode);	
	addDir('新增目录--子级',basePathJS + '/dirClassify/add' , fid,900,500);
}

//var curThis=this;
//var fid=$(curThis).attr('data-id');
////$('#parent_id').val(api_fcode);
//addDir('新增目录--子级',basePathJS + '/dirClassify/add',fid,900,500);
////$('#api_name').val('');
////$('#api_category').val('');
////$('#api_url').val('');
////$('#order_number').val('');
////$('#api_desc').val('');
function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}

function addCustom() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    if(!checkClassifyType()){
        tip("不能在这个分类下添加资源!!",parent,null,null);
        return;
    }
    add('新增信息资源',basePathJS + '/catalog/catalogue/add'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}

function catalogueTableUpload(id){
    show('信息资源附件上传详情',basePathJS + '/catalog/uploadInfo' , id ,"70%",550);
}

function catalogueTableEdit(id) {
    update('编辑信息资源',basePathJS + '/catalog/edit' , id ,"70%",700);
}

function catalogueTableShow(id){
	
    show('信息资源详情',basePathJS + '/catalog/show' , id ,"70%",700);
}

function quickAddDatasetUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    if(!checkClassifyType()){
        tip("不能在这个分类下添加资源!!",parent,null,null);
        return;
    }
    add('从资源梳理添加',basePathJS + '/catalog/catalogue/quickAddDatasetUI'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}

function quickSystemAddDatasetUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    if(!checkClassifyType()){
        tip("不能在这个分类下添加资源!!",parent,null,null);
        return;
    }
    add('从系统梳理添加',basePathJS + '/catalog/catalogue/quickSystemAddDatasetUI'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}
function quickCsAddDatasetUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    if(!checkClassifyType()){
        tip("不能在这个分类下添加资源!!",parent,null,null);
        return;
    }
    add('从爬虫系统添加',basePathJS + '/catalog/catalogue/quickCsAddDatasetUI'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}
function quickDcmAddDatasetUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    if(!checkClassifyType()){
        tip("不能在这个分类下添加资源!!",parent,null,null);
        return;
    }
    add('从关系型采集系统添加',basePathJS + '/catalog/catalogue/quickDcmAddDatasetUI'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}
function quickNosqlDcmAddDatasetUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    if(!checkClassifyType()){
        tip("不能在这个分类下添加资源!!",parent,null,null);
        return;
    }
    add('从非关系型采集系统添加',basePathJS + '/catalog/catalogue/quickDcmNosqlAddDatasetUI'+(searchClassifyId?'?classifyId='+searchClassifyId:''),"70%",800);
}
function excelImportUI() {
    var searchClassifyId = $('#searchClassifyId').val();
    if(!checkClassfyId(searchClassifyId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
    if(!checkClassifyType()){
        tip("不能在这个分类下导入资源!!",parent,null,null);
        return;
    }
    detail('导入',basePathJS +'/catalog/catalogue/excelImportUI?classifyId='+ $('#searchClassifyId').val(),900,350,parent);
}
function excelDownloadUI() {
    detail('模板下载',basePathJS +'/catalog/catalogue/excelDownloadUI',900,350,parent);
}
function checkClassfyId(searchClassifyId){
    if(searchClassifyId){
        return true;
    }
    return false;
}

function checkClassifyType(){
    var checkResult = true;
    var classifyType = $('#classifyType').val();
    if(classifyType=='1' || classifyType=='2-1' || classifyType=='2-2' || classifyType=='2-3'
        || classifyType=='3' || classifyType=='4'){
        checkResult = false;
    }
    return checkResult
}




////var tableSelector = '#systemUserTableId';
//
//jQuery(document).ready(function () {
//    "use strict";
//    var paramsObj = {};
//    
//    var zTree;
//    $(document).ready(function(){
//    	  onLoadZTree();
//    	  
//    });
//    
//    function onLoadZTree(){
//	var treeNodes;
//	var setting = {
//		      view: {
//		        dblClickExpand: false,//双击节点时，是否自动展开父节点的标识
//		        showLine: false,//是否显示节点之间的连线
//		        fontCss:{},//字体样式函数
//		        selectedMulti: false, //设置是否允许同时选中多个节点
//		        addHoverDom: addHoverDom,
//		        removeHoverDom: removeHoverDom,
//		        showIcon:false
////		        Remove: Remove
//		      },
//		      async: {
//                  enable: true,
//                  url: basePathJS + "/dirClassify/authorityList",
//                  autoParam:["fid"],
//                  dataFilter: function(treeId, parentNode, childNodes){//过滤数据库查询出来的数据为ztree接受的格式
//                      var params=[];
//                      var nodeObjs = childNodes.content.vo;
//                      if (!nodeObjs){
//                          return null;
//                      }
//                      for ( var i in nodeObjs) {
//                          params[i]={'id':nodeObjs[i].id,
//                        		  'classifyCode':nodeObjs[i].classifyCode,
//                        		  'classifyName':nodeObjs[i].classifyName,
//                        		  'fid':nodeObjs[i].id,
//                        		  'type':nodeObjs[i].classifyType,
//                        		  'isLocal':nodeObjs[i].isLocal,
//                        		  'fidforadd':nodeObjs[i].fid,
//                        		  'classifyType':nodeObjs[i].classifyType,
//                        		  'isParent':(nodeObjs[i].hasLeaf=="1"?true:false)
//                          }
//                      }
//                      return params;
//                  }
//              },
////		      async: {
////			  		enable: true,
////			  		url: "/admin/Directory_loadZtree",
////			  		dataFilter: filter
////			  	  },
//		      check:{
////		      chkboxType: { "Y": "ps", "N": "ps" },
//		        chkStyle: "checkbox",//复选框类型
//		        enable: false //每个节点上是否显示 CheckBox 
//		      },
//		      data: {
//		        simpleData: {//简单数据模式
//		        	 enable:true,
//			         idKey: "id",
//			         pIdKey: "parentId",    				         
//			         rootPId: "root"
//		        },
//		      	key : {
//		    	  name : "classifyName"
//		    	}
//		      },
//		      callback: {
////		        beforeClick: function(treeId, treeNode) {
////		          zTree = $.fn.zTree.getZTreeObj("treeview");
////		          if (treeNode.isParent) {
////		            zTree.expandNode(treeNode);//如果是父节点，则展开该节点
////		          }else{
////		            zTree.checkNode(treeNode, !treeNode.checked, true, true);//单击勾选，再次单击取消勾选
////		          }
////		        }
////		    	 onClick: onClick
//		    	
//		      },
//		      
////		      zTreeObj:{
////		    	  
////		    	  expandAll(true);
////		    	  
////		      }
//			};
//	function addHoverDom(treeId, treeNode) {
//		var aObj = $("#" + treeNode.tId + "_a");
//		if ($("#diyBtn_"+treeNode.id).length>0) return;
////		var editStr1 = "<span id='diyBtn_space_" +treeNode.dir_code+ "' >&nbsp;</span><select class='selDemo ' id='diyBtn_" +treeNode.dir_code+ "'><option value=1>1</option><option value=2>2</option><option value=3>3</option></select>";
//		var editStr1 = "<span id='diyBtn_space_" +treeNode.id+ "'><a href='javascript:void(0)' class='btn btn-edit "+treeNode.classifyName+""+treeNode.id+"' id='diyBtn_" +treeNode.id+ "' data-id ="+treeNode.id+" data-name = "+treeNode.apiName+" data-desc= "+treeNode.apiDesc+" data-orderNumber= "+treeNode.orderNumber+" data-url= "+treeNode.apiUrl+" data-category= "+treeNode.apiCategory+">编辑</a></span>"
//		var editStr4 = "<span id='diyBtn_space5_" +treeNode.id+ "'><a href='javascript:void(0)' class='btn btn-addNational "+treeNode.type+""+treeNode.classifyName+"' id='diyBtn_" +treeNode.id+ "' data-type ="+treeNode.type+" data-id ="+treeNode.id+" >导入国家库目录</a></span>"
//		var editStr3 = "<span id='diyBtn_space4_" +treeNode.id+ "'><a href='javascript:void(0)' class='btn btn-delete "+treeNode.id+"S4' id='diyBtn_" +treeNode.id+ "' data-id ="+treeNode.id+" data-name = "+treeNode.apiName+" data-code = "+treeNode.classifyCode+" >删除</a></span>"
//		var editStr2 = "<div class='btn-group'>"
//				+"<button id='diyBtn_space2_" +treeNode.id+ "' type='button' class='btn btn-add dropdown-toggle'"
//	           +         "data-toggle='dropdown'>"
//			   +	"添加 <span class='caret'></span></button>"
//			   +	"<ul id='diyBtn_space3_" +treeNode.id+ "' class='dropdown-menu' role='menu' style='padding-bottom: 100px'>"
//
//				+"<li><a href='javascript:void(0)' class='"+treeNode.fidforadd+""+treeNode.classifyName+""+treeNode.id+"' id='addSibling'  data-pcode="+treeNode.fidforadd+" href='#'  >添加同级</a></li>"
//				+"<li><a href='javascript:void(0)' class='"+treeNode.id+"S' id='addSon' href='#' data-id ="+treeNode.id+" >添加下级</a></li></ul>"				
//				+"</div>"
//		var editStr5 = "<div class='btn-group'>"
//					+"<button id='diyBtn_space2_" +treeNode.id+ "' type='button' class='btn btn-add dropdown-toggle'"
//		           +         "data-toggle='dropdown'>"
//				   +	"添加 <span class='caret'></span></button>"
//				   +	"<ul id='diyBtn_space3_" +treeNode.id+ "' class='dropdown-menu' role='menu'>"
//
//					
//					+"<li><a href='javascript:void(0)' class='"+treeNode.id+"S' id='addSon' href='#' data-id ="+treeNode.id+" >添加下级</a></li></ul>"				
//					+"</div>"
//		
//				if( treeNode.classifyType=='2-3' && treeNode.isLocal=='1'){	
//					
//				}else if(treeNode.classifyType=='2-1' || treeNode.classifyType=='2-2' || treeNode.classifyType=='3'){
//					aObj.after(editStr5);					
//					aObj.after(editStr4);
//				}else if(treeNode.classifyType == '5' || treeNode.classifyType == '6'|| treeNode.classifyType == '7'){
//					aObj.after(editStr2);
//					aObj.after(editStr1);
//					aObj.after(editStr3);
//					aObj.after(editStr4);
//				}else{
//					
//				}				
//						
//		var btn = $("#diyBtn_"+treeNode.id);				
//		
//		
//		//删除
//		$("."+treeNode.id+"S4").on("click", function () {
//						        
//			var curThis=this;
//			var id=$(curThis).attr('data-id');
////			var apiDesc=$(curThis).attr('data-desc');
////			var apiUrl=$(curThis).attr('data-url');
////			var apiName=$(curThis).attr('data-name');
////			var apiCatgegory=$(curThis).attr('data-category');
////			var orderNumber=$(curThis).attr('data-orderNumber');
////			$('#parent_id').val(api_fcode);	
////			updateApi('新增api--同级',basePathJS + '/dirDevelopApis/edit' , id);
//			
//			
//			var url = basePathJS + "/dirClassify/delete";
//		    var parameter = {id: id};
//		    delObjApi(url , parameter) ;
//		    
////			$('#api_name').val(apiName);
////			$('#api_category').val(apiCatgegory);
////			$('#api_url').val(apiUrl);
////			$('#order_number').val(orderNumber);
////			$('#api_desc').val(apiDesc);
//		  
//		});
//		
//		
//		//编辑
//		$("."+treeNode.classifyName+""+treeNode.id+"").on("click", function () {
//						        
//			var curThis=this;
//			var id=$(curThis).attr('data-id');
////			var apiDesc=$(curThis).attr('data-desc');
////			var apiUrl=$(curThis).attr('data-url');
////			var apiName=$(curThis).attr('data-name');
////			var apiCatgegory=$(curThis).attr('data-category');
////			var orderNumber=$(curThis).attr('data-orderNumber');
////			$('#parent_id').val(api_fcode);	
//			updateApi('编辑目录',basePathJS + '/dirClassify/edit' , id,900,500);
////			$('#api_name').val(apiName);
////			$('#api_category').val(apiCatgegory);
////			$('#api_url').val(apiUrl);
////			$('#order_number').val(orderNumber);
////			$('#api_desc').val(apiDesc);
//			
//		});
//		//添加同级
//		$("."+treeNode.fidforadd+""+treeNode.classifyName+""+treeNode.id+"").on("click", function () {
//			var curThis=this;
//			var fid=$(curThis).attr('data-pcode');
////			$('#parent_id').val(api_fcode);	
//			if(fid=="root"){
//				 tip("无权限添加初始目录类别，请联系管理员。" );
//				 return false;
//			 }
//			addDir('新增目录--同级',basePathJS + '/dirClassify/add' , fid,900,500);
////			$('#api_name').val('');
////			$('#api_category').val('');
////			$('#api_url').val('');
////			$('#order_number').val('');
////			$('#api_desc').val('');
//							
//		});
//		//添加子级
//	    $("."+treeNode.id+"S").on("click", function () {
//	    	var curThis=this;
//			var fid=$(curThis).attr('data-id');
////			$('#parent_id').val(api_fcode);
//			addDir('新增目录--子级',basePathJS + '/dirClassify/add',fid,900,500);
////	    	$('#api_name').val('');
////			$('#api_category').val('');
////			$('#api_url').val('');
////			$('#order_number').val('');
////			$('#api_desc').val('');
//			
//	    });
//	    
//	  //添加国家库
//	    $("."+treeNode.type+""+treeNode.classifyName+"").on("click", function () {
//	    	var curThis=this;
//			var fid=$(curThis).attr('data-id');
//			var classifyType = $(curThis).attr('data-type');
////			$('#parent_id').val(api_fcode);
//			addDirNational('新增国家库目录--子级',basePathJS + '/dirClassify/addNational',fid,classifyType,800,500);
////	    	$('#api_name').val('');
////			$('#api_category').val('');
////			$('#api_url').val('');
////			$('#order_number').val('');
////			$('#api_desc').val('');
//			
//	    });
//
//		if (btn) btn.bind("change", function(){alert("diy Select value="+btn.attr("value")+" for " + treeNode.name);});
//
////		<button type="button" class="btn btn-add dropdown-toggle "
////            data-toggle="dropdown">
////		发布 <span class="caret"></span>
////	</button>
////	<ul class="dropdown-menu" role="menu">
////
////		<li><a id="releaseboth" href="#">同时发布</a></li>
////		<li><a id="releaseInternet" href="#">发布到互联网</a></li>
////		<li><a id="releaseInside" href="#">发布到电子政务外网</a></li>
////
////	</ul> 			
////		var editStr = "<button type='button' class='btn btn-add dropdown-toggle'"
////			           +         "data-toggle='dropdown'>"
////					   +	"发布 <span class='caret'></span></button>"
////					   +	"<ul class='dropdown-menu' role='menu'>"
////
////						+"<li><a id='releaseboth' href='#'>同时发布</a></li>"
////						+"<li><a id='releaseInternet' href='#'>发布到互联网</a></li>"
////						+"<li><a id='releaseInside' href='#'>发布到电子政务外网</a></li></ul>"							  
////			"<span id='diyBtn_space_" +treeNode.dir_code+ "' > </span>"
////			+ "<button type='button' class='diyBtn1' id='diyBtn_" + treeNode.dir_code
////			+ "' title='"+treeNode.dir_name+"' onfocus='this.blur();'></button>";
////		var btn = $("#diyBtn_"+treeNode.dir_code);
////		if (btn) btn.bind("click", function(){alert("diy Button for " + treeNode.dir_name);});
//		};
//		function removeHoverDom(treeId, treeNode) {
////			if (treeNode.parentTId && treeNode.getParentNode().id!=1) return;
//			
//				$("#diyBtn_"+treeNode.id).unbind().remove();
//				$("#diyBtn_space_" +treeNode.id).unbind().remove();
//				$("#diyBtn_space2_" +treeNode.id).unbind().remove();
//				$("#diyBtn_space3_" +treeNode.id).unbind().remove();
//				$("#diyBtn_space4_" +treeNode.id).unbind().remove();
//				$("#diyBtn_space5_" +treeNode.id).unbind().remove();
//				
//		};  
//		     			
////    $.ajax({
////    async:false,//是否异步
////    cache:false,//是否使用缓存
////    type:'POST',//请求方式：post
////    dataType:'json',//数据传输格式：json
////    url:'/dirDevelopApis/list',//请求的action路径
////    error:function(){
////      //请求失败处理函数
////      alert('亲，请求失败！');
////    },
////    success:function(data){
////       
////     
////      //console.log(data);
////      //请求成功后处理函数
////      treeNodes = data.data;//把后台封装好的简单Json格式赋给treeNodes
////    
////    }
////  });
////    var nodes = [
////             	{id:'1', pId:'0', name: "父节点1"},
////             	{id:'11', pId:'1', name: "子节点1"},
////             	{id:'12', pId:'1', name: "子节点2"},
////             	{id:'123123', pId:null, name: "子节点2"}
////             ];
//  var t = $("#treeview");
//  t = $.fn.zTree.init(t, setting);
//  
//  }
//
////    jQuery(tableSelector).customTable({
////        url: basePathJS + '/dirDevelopApis/list',
////        queryParams: function (params) {
////            return $.extend(params, paramsObj);
////        },
////        columns: [{
////            field: 'userName',
////            title: '用户名',
////            align: 'center',
////            valign: 'middle',
////            sortable: false
////        }, {
////            field: 'realName',
////            title: '真实姓名',
////            align: 'center',
////            valign: 'middle',
////            sortable: false
////        }, {
////            field: 'userType',
////            title: '用户类型',
////            align: 'center',
////            valign: 'middle',
////            sortable: false,
////            formatter : function (value) {
////                var ret = '';
////                if (value === 1 ) {
////                    ret = '管理员';
////                } else if (value === 2 ) {
////                    ret = '普通用户';
////                }
////                return ret ;
////            }
////        }, {
////            field: 'userDesc',
////            title: '描述',
////            align: 'center',
////            valign: 'middle',
////            sortable: false
////        }, {
////            field: 'deptName',
////            title: '组织机构名称',
////            align: 'center',
////            valign: 'middle',
////            sortable: false
////        }, {
////            field: 'status',
////            title: '用户状态',
////            align: 'center',
////            valign: 'middle',
////            sortable: false,
////            formatter : function (value) {
////                var res;
////                if(value === 1){
////                    res = "启用";
////                }
////                else {
////                    res = "禁用";
////                }
////                return res;
////            }
////        },{
////            field: 'createName',
////            title: '创建者',
////            align: 'center',
////            valign: 'middle',
////            sortable: false
////        },{
////            field: 'createTime',
////            title: '创建用户时间',
////            align: 'center',
////            valign: 'middle',
////            sortable: false
////        },{
////            field: 'id',
////            title: '操作',
////            align: 'center',
////            valign: 'middle',
////            sortable: false ,
////            formatter : function (value) {
////                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
////                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteUser(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
////
////                return editBtn + OPERATION_SEPARATOR +  deleteBtn ;
////            }
////        }]
////    });
//
//    jQuery('#queryBtnId').click(function () {
////        setParams();
////        reloadTable();
//    });
//
//    function setParams() {
//        var searchKeyVal = $('#searchKeyId').val();
//        paramsObj = {searchKey : searchKeyVal};
//    }
//    
//    
//    
//    
//
//});
//
////function reloadTable() {
////    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
////    $(tableSelector).data("bootstrap.table").refresh();
////}
//
//function addUser() {
//    add('新增api',basePathJS + '/dirDevelopApis/add' , id);
//}
//
//function editUser(id) {
//    update('编辑api',basePathJS + '/dirDevelopApis/edit' , id);
//}
//
//function deleteUser(id) {
//    var url = basePathJS + "/dirDevelopApis/delete";
//    var parameter = {id: id};
//    delObj(url , parameter) ;
//}