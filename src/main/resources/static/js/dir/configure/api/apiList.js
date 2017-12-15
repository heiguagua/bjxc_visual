var tableSelector = '#apiTable';
var paramsObj = {};


jQuery(document).ready(function () {
//    var paramsObj = {};
    initCss();
    initAllSelect();
//    initButtonClickEvent();
    initTable();    
    
    var zTree;
    $(document).ready(function(){
    	  onLoadZTree();
    	  
    });
    
    function onLoadZTree(){
	var treeNodes;
	var setting = {
		      view: {
		        dblClickExpand: false,//双击节点时，是否自动展开父节点的标识
		        showLine: false,//是否显示节点之间的连线
		        fontCss:{},//字体样式函数
		        selectedMulti: false, //设置是否允许同时选中多个节点
//		        addHoverDom: addHoverDom,
//		        removeHoverDom: removeHoverDom,
		        showIcon:false
//		        Remove: Remove
		      },
//		      async: {
//			  		enable: true,
//			  		url: "/admin/Directory_loadZtree",
//			  		dataFilter: filter
//			  	  },
		      check:{
//		      chkboxType: { "Y": "ps", "N": "ps" },
		        chkStyle: "checkbox",//复选框类型
		        enable: false //每个节点上是否显示 CheckBox 
		      },
		      data: {
		        simpleData: {//简单数据模式
		        	 enable:true,
			         idKey: "id",
			         pIdKey: "parentId",    				         
			         rootPId: "root"
		        },
		      	key : {
		    	  name : "apiName"
		    	}
		      },
		      callback: {
//		        beforeClick: function(treeId, treeNode) {
//		          zTree = $.fn.zTree.getZTreeObj("treeview");
//		          if (treeNode.isParent) {
//		            zTree.expandNode(treeNode);//如果是父节点，则展开该节点
//		          }else{
//		            zTree.checkNode(treeNode, !treeNode.checked, true, true);//单击勾选，再次单击取消勾选
//		          }
//		        }
		    	  onClick: function (e, treeId, treeNode) { //点击节点，刷新表格
                      $('#Id').val(treeNode.id);
                      $('#fid').val(treeNode.parentId);
//                      if(classifyTypeInputDomId){
//                          $('#'+classifyTypeInputDomId).val(treeNode.classifyType);
//                      }
//                      if(releasePageFlag){
//                          if(releasePageFlag == "unRelease"){
//                              setUnReleaseParams();
//                          }else if(releasePageFlag == "released"){
//                              setReleasedParams();
//                          }
//                      }else{
                          setParams();
//                      }
                      reloadTable();
                  }
		    	
		      }
		      
//		      zTreeObj:{
//		    	  
//		    	  expandAll(true);
//		    	  
//		      }
			};
	function addHoverDom(treeId, treeNode) {
//		var aObj = $("#" + treeNode.tId + "_a");
//		if ($("#diyBtn_"+treeNode.id).length>0) return;
////		var editStr1 = "<span id='diyBtn_space_" +treeNode.dir_code+ "' >&nbsp;</span><select class='selDemo ' id='diyBtn_" +treeNode.dir_code+ "'><option value=1>1</option><option value=2>2</option><option value=3>3</option></select>";
//		var editStr1 = "<span id='diyBtn_space_" +treeNode.id+ "'><a class='btn btn-edit "+treeNode.apiName+""+treeNode.id+"' id='diyBtn_" +treeNode.id+ "' data-id ="+treeNode.id+" data-name = "+treeNode.apiName+" data-desc= "+treeNode.apiDesc+" data-orderNumber= "+treeNode.orderNumber+" data-url= "+treeNode.apiUrl+" data-category= "+treeNode.apiCategory+">编辑</a></span>"
//		var editStr3 = "<span id='diyBtn_space4_" +treeNode.id+ "'><a class='btn btn-edit "+treeNode.id+"S4' id='diyBtn_" +treeNode.id+ "' data-id ="+treeNode.id+" data-name = "+treeNode.apiName+" data-parentId = "+treeNode.parentId+" >删除</a></span>"
//		var editStr2 = "<div class='btn-group'>"
//				+"<button id='diyBtn_space2_" +treeNode.id+ "' type='button' class='btn btn-add dropdown-toggle'"
//	           +         "data-toggle='dropdown'>"
//			   +	"添加 <span class='caret'></span></button>"
//			   +	"<ul id='diyBtn_space3_" +treeNode.id+ "' class='dropdown-menu' role='menu'>"
//
//				+"<li><a class='"+treeNode.parentId+""+treeNode.apiName+""+treeNode.id+"' id='addSibling' data-id ="+treeNode.id+" data-pcode="+treeNode.parentId+" href='#'  >添加同级</a></li>"
//				+"<li><a class='"+treeNode.id+"S' id='addSon' href='#' data-id ="+treeNode.id+" >添加下级</a></li></ul>"				
//				+"</div>"	
//				aObj.after(editStr3);
//				aObj.after(editStr2);
//				aObj.after(editStr1);		
		var btn = $("#diyBtn_"+treeNode.id);				
		
		
		//删除
		$("."+treeNode.id+"S4").on("click", function () {
						        
			var curThis=this;
			var id=$(curThis).attr('data-id');
//			var apiDesc=$(curThis).attr('data-desc');
//			var apiUrl=$(curThis).attr('data-url');
//			var apiName=$(curThis).attr('data-name');
//			var apiCatgegory=$(curThis).attr('data-category');
//			var orderNumber=$(curThis).attr('data-orderNumber');
//			$('#parent_id').val(api_fcode);	
//			updateApi('新增api--同级',basePathJS + '/dirDevelopApis/edit' , id);
			
			
			var url = basePathJS + "/dirDevelopApis/delete";
		    var parameter = {id: id};
		    delObjApi(url , parameter) ;
		    
//			$('#api_name').val(apiName);
//			$('#api_category').val(apiCatgegory);
//			$('#api_url').val(apiUrl);
//			$('#order_number').val(orderNumber);
//			$('#api_desc').val(apiDesc);
		  
		});
		
		
		//编辑
		$("."+treeNode.apiName+""+treeNode.id+"").on("click", function () {
						        
			var curThis=this;
			var id=$(curThis).attr('data-id');
//			var apiDesc=$(curThis).attr('data-desc');
//			var apiUrl=$(curThis).attr('data-url');
//			var apiName=$(curThis).attr('data-name');
//			var apiCatgegory=$(curThis).attr('data-category');
//			var orderNumber=$(curThis).attr('data-orderNumber');
//			$('#parent_id').val(api_fcode);	
			updateApi('编辑api',basePathJS + '/dirDevelopApis/edit' , id);
//			$('#api_name').val(apiName);
//			$('#api_category').val(apiCatgegory);
//			$('#api_url').val(apiUrl);
//			$('#order_number').val(orderNumber);
//			$('#api_desc').val(apiDesc);
			
		});
		//添加同级
		$("."+treeNode.parentId+""+treeNode.apiName+""+treeNode.id+"").on("click", function () {
			var curThis=this;
			var parentId=$(curThis).attr('data-pcode');
//			$('#parent_id').val(api_fcode);	
			addApi('新增api--同级',basePathJS + '/dirDevelopApis/add' , parentId);
//			$('#api_name').val('');
//			$('#api_category').val('');
//			$('#api_url').val('');
//			$('#order_number').val('');
//			$('#api_desc').val('');
							
		});
		//添加子级
	    $("."+treeNode.id+"S").on("click", function () {
	    	var curThis=this;
			var parentId=$(curThis).attr('data-id');
//			$('#parent_id').val(api_fcode);
			addApi('新增api--子级',basePathJS + '/dirDevelopApis/add',parentId);
//	    	$('#api_name').val('');
//			$('#api_category').val('');
//			$('#api_url').val('');
//			$('#order_number').val('');
//			$('#api_desc').val('');
			
	    });

		if (btn) btn.bind("change", function(){alert("diy Select value="+btn.attr("value")+" for " + treeNode.name);});

//		<button type="button" class="btn btn-add dropdown-toggle "
//            data-toggle="dropdown">
//		发布 <span class="caret"></span>
//	</button>
//	<ul class="dropdown-menu" role="menu">
//
//		<li><a id="releaseboth" href="#">同时发布</a></li>
//		<li><a id="releaseInternet" href="#">发布到互联网</a></li>
//		<li><a id="releaseInside" href="#">发布到电子政务外网</a></li>
//
//	</ul> 			
//		var editStr = "<button type='button' class='btn btn-add dropdown-toggle'"
//			           +         "data-toggle='dropdown'>"
//					   +	"发布 <span class='caret'></span></button>"
//					   +	"<ul class='dropdown-menu' role='menu'>"
//
//						+"<li><a id='releaseboth' href='#'>同时发布</a></li>"
//						+"<li><a id='releaseInternet' href='#'>发布到互联网</a></li>"
//						+"<li><a id='releaseInside' href='#'>发布到电子政务外网</a></li></ul>"							  
//			"<span id='diyBtn_space_" +treeNode.dir_code+ "' > </span>"
//			+ "<button type='button' class='diyBtn1' id='diyBtn_" + treeNode.dir_code
//			+ "' title='"+treeNode.dir_name+"' onfocus='this.blur();'></button>";
//		var btn = $("#diyBtn_"+treeNode.dir_code);
//		if (btn) btn.bind("click", function(){alert("diy Button for " + treeNode.dir_name);});
		};
		function removeHoverDom(treeId, treeNode) {
//			if (treeNode.parentTId && treeNode.getParentNode().id!=1) return;
			
				$("#diyBtn_"+treeNode.id).unbind().remove();
				$("#diyBtn_space_" +treeNode.id).unbind().remove();
				$("#diyBtn_space2_" +treeNode.id).unbind().remove();
				$("#diyBtn_space3_" +treeNode.id).unbind().remove();
				$("#diyBtn_space4_" +treeNode.id).unbind().remove();
				
		};
    $.ajax({
    async:false,//是否异步
    cache:false,//是否使用缓存
    type:'POST',//请求方式：post
    dataType:'json',//数据传输格式：json
    url:basePathJS + '/dirDevelopApis/list',//请求的action路径
    error:function(){
      //请求失败处理函数
      alert('亲，请求失败！');
    },
    success:function(data){
       
     
      //console.log(data);
      //请求成功后处理函数
      treeNodes = data.data;//把后台封装好的简单Json格式赋给treeNodes
    
    }
  });
//    var nodes = [
//             	{id:'1', pId:'0', name: "父节点1"},
//             	{id:'11', pId:'1', name: "子节点1"},
//             	{id:'12', pId:'1', name: "子节点2"},
//             	{id:'123123', pId:null, name: "子节点2"}
//             ];
  var t = $("#treeDemo");
  t = $.fn.zTree.init(t, setting, treeNodes);
  
  }

//    jQuery(tableSelector).customTable({
//        url: basePathJS + '/dirDevelopApis/list',
//        queryParams: function (params) {
//            return $.extend(params, paramsObj);
//        },
//        columns: [{
//            field: 'userName',
//            title: '用户名',
//            align: 'center',
//            valign: 'middle',
//            sortable: false
//        }, {
//            field: 'realName',
//            title: '真实姓名',
//            align: 'center',
//            valign: 'middle',
//            sortable: false
//        }, {
//            field: 'userType',
//            title: '用户类型',
//            align: 'center',
//            valign: 'middle',
//            sortable: false,
//            formatter : function (value) {
//                var ret = '';
//                if (value === 1 ) {
//                    ret = '管理员';
//                } else if (value === 2 ) {
//                    ret = '普通用户';
//                }
//                return ret ;
//            }
//        }, {
//            field: 'userDesc',
//            title: '描述',
//            align: 'center',
//            valign: 'middle',
//            sortable: false
//        }, {
//            field: 'deptName',
//            title: '组织机构名称',
//            align: 'center',
//            valign: 'middle',
//            sortable: false
//        }, {
//            field: 'status',
//            title: '用户状态',
//            align: 'center',
//            valign: 'middle',
//            sortable: false,
//            formatter : function (value) {
//                var res;
//                if(value === 1){
//                    res = "启用";
//                }
//                else {
//                    res = "禁用";
//                }
//                return res;
//            }
//        },{
//            field: 'createName',
//            title: '创建者',
//            align: 'center',
//            valign: 'middle',
//            sortable: false
//        },{
//            field: 'createTime',
//            title: '创建用户时间',
//            align: 'center',
//            valign: 'middle',
//            sortable: false
//        },{
//            field: 'id',
//            title: '操作',
//            align: 'center',
//            valign: 'middle',
//            sortable: false ,
//            formatter : function (value) {
//                var editBtn = "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:editUser(\"" + value + "\")'><i class='fa fa-pencil-square-o'></i> 编辑</a>";
//                var deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteUser(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";
//
//                return editBtn + OPERATION_SEPARATOR +  deleteBtn ;
//            }
//        }]
//    });

    jQuery('#queryBtnId').click(function () {
//        setParams();
//        reloadTable();
    });

//    function setParams() {
//        var searchKeyVal = $('#searchKeyId').val();
//        paramsObj = {searchKey : searchKeyVal};
//    }
    
    
    
    

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


function checkApiId(apiId){
    if(apiId){
        return true;
    }
    return false;
}

function initTable(){
    //paramsObj["regionCode"] = $("#searchRegionCode").val();
    jQuery(tableSelector).customTable({
        url: basePathJS + '/dirDevelopApis/subList',
        queryParams: function (params) {
            return $.extend(params, paramsObj);
        },
//        escape:true,
        columns: [
           {
            field: 'apiName',
            title: '工具名称',
            sortable: false,
            width: '15%',
            formatter:function(value, row, index){            	
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'apiCategory',
            title: '工具种类',
            sortable: false,
            formatter:function(value, row, index){            	
                if(value == undefined){
                    value = "";
                }
                return '<p title="'+value+'">'+value+'</p>';
            }
        },{
            field: 'apiUrl',
            title: 'url地址',
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
            field: 'apiDesc',
            title: '工具描述',
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
	             	editBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:editNode(\"" + value + "\")'><i class='fa fa-times'></i> 编辑</a>";
	            	deleteBtn = "<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:deleteNode(\"" + value + "\")'><i class='fa fa-times'></i> 删除</a>";	
	            	return editBtn + deleteBtn;
            }
        }]
    });
}


function initAllSelect(){
//    //区域下拉查询框
//    /*var initClassifyTreeParam = ["treeDemo","searchClassifyId","","classifyType"];
//    $.initRegionQueryTreeSelect('searchRegionTreeDemo','searchRegionName','searchRegionCode',
//        'searchRegionMenuContent',false,newRegionCode,initClassifyTreeParam);*/
//    //初始化中间目录分类树
//    $.initClassifyTree('treeDemo','searchClassifyId','','classifyType',newRegionCode);
}

function setParams() {
    var id = $('#Id').val();
//    var searchName = $('#searchName').val();
    //var regionCode = $('#searchRegionCode').val();
    //paramsObj = {classifyId:searchClassifyId,datasetName:searchName,regionCode:regionCode};    
    
    paramsObj = {parentId:id};
}

function reloadTable() {
    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
    $(tableSelector).data("bootstrap.table").refresh();
}
//function reloadTable() {
//    $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
//    $(tableSelector).data("bootstrap.table").refresh();
//}

function editNode(id){
	
	updateApi('编辑api',basePathJS + '/dirDevelopApis/edit' , id);
	
}

function deleteNode(id){
	
	var url = basePathJS + "/dirDevelopApis/delete";
    var parameter = {id: id};
    delObjApi(url , parameter) ;
	
}


function addSibling() {
	
	var parentId=$('#fid').val();
	if(!checkApiId(parentId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
	
//	$('#parent_id').val(api_fcode);	
	addApi('新增api--同级',basePathJS + '/dirDevelopApis/add' , parentId);
}

function addSon() {
		
	var parentId=$('#Id').val();
	if(!checkApiId(parentId)){
        tip("请先选择目录分类!",parent,null,null);
        return;
    }
//	$('#parent_id').val(api_fcode);
	addApi('新增api--子级',basePathJS + '/dirDevelopApis/add',parentId);
}

//function addUser() {
//	addApi('新增api',basePathJS + '/dirDevelopApis/add' , id);
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