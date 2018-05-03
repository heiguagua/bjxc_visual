require([ 'jquery', 'echarts3','global_custom', '../js/charts/ECategory.js',
		'zTree', 'bootstrap' ], function($, echarts ,global_custom,  ECategory, zTree) {
	
	// 全局变量
	window.NOW_DATE = 'now_date';		  // 当前时间,  传参：""
	window.LAST_DATE = 'last_date';		  // 当前时间-1,	传参：""
	window.CUSTOM_DATE = 'custom_date';   // 自定义时间段 ,  传参如：2018-05-08 ~ 2018-06-19
	window.RECENT_YEARS = 'recent_years'; // 最近x年/月/日 , 传参如："3 Y", "3 M", "3 D"
	window.ADD_OR_UPDATE = 'add';
	
	var setting = {
			check : {
				enable : true,
				chkboxType : {
					"Y" : 's',
					"N" : 's'
				}
			},
			data : {
				simpleData : {
					enable : true
				}
			},
			async: {
				enable: true,
				url:basePathJS + "/indictorCategory/subCategoryList",
				autoParam:["id=fid"],
				otherParam:{},
				dataFilter: filter
			},
			callback: {  
				beforeClick: function (treeId, treeNode) { //如果点击的节点还有下级节点，则展开该节点
					console.log(treeNode);
//					if(treeNode.selectable == 0) {// 还有子节点
//						$.ajax({
//		                    type : "get",
//		                    url : basePathJS + "/indictorCategory/subCategoryList?fid=" + treeNode.id,
//		                    async : false,
//		                    success : function(res){
//		                        var dd = res.content.data;
//		                        treeNode.children = [];
//	                        	treeNode.children = dd.concat(treeNode.children_old);
//		    					var zTreeObj = $.fn.zTree.getZTreeObj(treeId);
//		                        if (treeNode.isParent) {
//		                            if (treeNode.open) {
//		                                zTreeObj.expandNode(treeNode, false);
//		                            } else {
//		                                zTreeObj.expandNode(treeNode, true);
//		                            }
//		                            return false;
//		                        } else {
//		                            return true;
//		                        }
//		                    }
//		                });
//					}
					
                },
//		        onCheck: onCheck, //用于捕获 checkbox / radio 被勾选 或 取消勾选的事件回调函数  
//		        onClick: onClick, //用于捕获节点被点击的事件回调函数  
//		        beforeExpand: beforeExpand, //用于捕获父节点展开之前的事件回调函数，并且根据返回值确定是否允许展开操作  
//		        onExpand: onExpand//用于捕获节点被展开的事件回调函数  
		    }
	}
	require(['zTree'],function(zTree){
		$.fn.zTree.init($("#indicatorTree"), setting);
		var showDetail = $('input[name="showDetail"]:checked').val();
		if(showDetail) {// 显示详情
			// TODO send ajax request for detail indicator
			$.fn.zTree.init($("#detailTree"), setting);
		}
		
	})
	function filter(treeId, parentNode, childNodes) {
		if (!childNodes) return null;
		
		var childNodes = childNodes.content.data;
		for (var i=0, l=childNodes.length; i<l; i++) {
			console.log(childNodes[i].hasLeaf);
			childNodes[i].isParent = childNodes[i].selectable == 0 ? true:false;
			childNodes[i].nocheck = childNodes[i].selectable == 0 ? true:false;
			//childNodes[i].children = [];
			
			
		}
		return childNodes;
	}

//	var zNodes = [ {
//		id : 1,
//		pId : 0,
//		name : "随意勾选 1",
//		open : true
//	}, {
//		id : 11,
//		pId : 1,
//		name : "随意勾选 1-1",
//		open : true
//	}, {
//		id : 111,
//		pId : 11,
//		name : "随意勾选 1-1-1"
//	}, {
//		id : 112,
//		pId : 11,
//		name : "随意勾选 1-1-2"
//	}, {
//		id : 12,
//		pId : 1,
//		name : "随意勾选 1-2",
//		open : true
//	}, {
//		id : 121,
//		pId : 12,
//		name : "随意勾选 1-2-1"
//	}, {
//		id : 122,
//		pId : 12,
//		name : "随意勾选 1-2-2"
//	}, {
//		id : 2,
//		pId : 0,
//		name : "随意勾选 2"
//	}, {
//		id : 21,
//		pId : 2,
//		name : "随意勾选 2-1"
//	}, {
//		id : 22,
//		pId : 2,
//		name : "随意勾选 2-2"
//	}, {
//		id : 221,
//		pId : 22,
//		name : "随意勾选 2-2-1"
//	}, {
//		id : 222,
//		pId : 22,
//		name : "随意勾选 2-2-2"
//	}, {
//		id : 23,
//		pId : 2,
//		name : "随意勾选 2-3"
//	} ];


	// 二维数组矩阵转置
	Array.prototype.transpose = function() {
		console.log(this);
		var length = this.length;
		var arr_new = [];
		if(length != 0) {
			// 初始化，确定有多少行
			for(var i=0; i<this[0].length; i++) {
				arr_new[i] = [];
			}
			for(var i=0;i<this.length;i++){
		        for(var j=0;j<this[i].length;j++){
		            //动态添加数据到arr_new数组中
		        	arr_new[j][i]=this[i][j];
		        }
		    }
		}
		return arr_new;
	}
	

	
	$('input[name="showDetail"]').click(function(){
		$('.tree-wrap.detail').toggleClass('hide');
	})
	
	$('#addChartConfirm').click(function() {
		console.log('modal type:' + ADD_OR_UPDATE);

		var chartType = $('input[name="chartTypeOptions"]:checked').val();
		var showDetail = $('#showDetail').prop('checked');
		var isNameShow = $('#showTitle').prop('checked');
		// TODO send ajax for indicator data
		var params = {
				chartName: $('#etitle').val(),
				isNameShow: isNameShow,
				chartType: chartType,
				chartTimeType: $('#timeselect').val(),
				chartTimeScope: getChartTimeScope(),
				hasSubIndictor: showDetail,
				location: '',
				indicators: JSON.stringify(getTreeNode('indicatorTree')),
				subIndicators: JSON.stringify(getTreeNode('detailTree'))
		}
		console.log(params.indicators);
		$.ajax({
            type : "post",
            url : basePathJS + "/chartConf/addUsersChart",
            async : false,
            data: params,
            success : function(res){
                console.log(res);
            }
        });
		
		// response data
		var title = '人口与机构分析一览表';
		var data_unit = '%';
		var legend_data = ['孕产妇建卡率','人口与妇幼保健院卫生人员数比','人口与医疗卫生机构妇产科床位数比','人口与妇产科执业医师数比','人口与妇幼保健机构数比'];
		var x_data = ['2012年','2013年','2014年','2015年'];
		var serData = [[9,7,8,7.8,6.8],
		               [7,7.8,8.4,7.2,5.6],
		               [4.6,4.2,5,5.8,5.4],
		               [3,3.2,4,4.5,5.2]
					];
		var data_all = [{name: '孕产妇建卡率', date: '2012年', value: '9', unit: '%'},
		                {name: '人口与妇幼保健院卫生人员数比', date: '2012年', value: '7', unit: '%'},
		                {name: '人口与医疗卫生机构妇产科床位数比', date: '2012年', value: '8', unit: '%'},
		                {name: '人口与妇产科执业医师数比', date: '2012年', value: '6.9', unit: '%'},
		                {name: '人口与妇幼保健机构数比', date: '2012年', value: '8.4', unit: '%'},
		                {name: '孕产妇建卡率', date: '2013年', value: '4.8', unit: '%'},
		                {name: '人口与妇幼保健院卫生人员数比', date: '2013年', value: '7.8', unit: '%'},
		                {name: '人口与医疗卫生机构妇产科床位数比', date: '2013年', value: '9.4', unit: '%'},
		                {name: '人口与妇产科执业医师数比', date: '2013年', value: '8.9', unit: '%'},
		                {name: '人口与妇幼保健机构数比', date: '2013年', value: '7.4', unit: '%'},
		                {name: '孕产妇建卡率', date: '2014年', value: '8.5', unit: '%'},
		                {name: '人口与妇幼保健院卫生人员数比', date: '2014年', value: '6.7', unit: '%'},
		                {name: '人口与医疗卫生机构妇产科床位数比', date: '2014年', value: '5.9', unit: '%'},
		                {name: '人口与妇产科执业医师数比', date: '2014年', value: '8.9', unit: '%'},
		                {name: '人口与妇幼保健机构数比', date: '2014年', value: '7.4', unit: '%'},
		                {name: '孕产妇建卡率', date: '2015年', value: '7.5', unit: '%'},
		                {name: '人口与妇幼保健院卫生人员数比', date: '2015年', value: '6.4', unit: '%'},
		                {name: '人口与医疗卫生机构妇产科床位数比', date: '2015年', value: '8.9', unit: '%'},
		                {name: '人口与妇产科执业医师数比', date: '2015年', value: '9.1', unit: '%'},
		                {name: '人口与妇幼保健机构数比', date: '2015年', value: '6.4', unit: '%'},];
//		console.log(_.groupBy(data_all,'name'),_.keys(_.groupBy(data_all,'name')),_.values(_.groupBy(data_all,'name')));
//		console.log(_.groupBy(data_all,'date'),_.keys(_.groupBy(data_all,'date')),_.values(_.groupBy(data_all,'date')));
		var singleData = [60,40,20,80,100];
		serData = serData.transpose();
		var detail_info = {
				title: '2014年西城区',
				data:[{name:'孕妇建卡人数',value:1000,unit:'人'},
	                   {name:'妇幼保健卫生人员数',value:600,unit:'人'},
	                   {name:'妇产科职业医师数',value:200,unit:'人'},
	                   {name:'妇幼保健机构数',value:15,unit:'家'}]
		};
		
		var gauge_data = {name:'完成率', value:50};// 单个指标数据，用于仪表图
		
		ECategory.create(chartType,{
			title: title,
			isNameShow: isNameShow,
			unit: data_unit,
			legend_data: legend_data,
			x_data: x_data,
			serData: serData,
			singleData: singleData,
			showDetail: showDetail,
			detail_info:detail_info,
			gauge_data: gauge_data,
			chartType: chartType,
			chartTimeType: $('#timeselect').val(),
			chartTimeScope: getChartTimeScope(),
		},ADD_OR_UPDATE);
		
		$('#addChartModal').modal('hide');
	})
	
	
	// 图表类型change事件
	$('input[name="chartTypeOptions"]').click(function(){
		etypeChange();
	})
	
	
	// 日期选择change事件
	$('#timeselect').on("change", function (e) {
		etypeChange();
	});
	
	// 日期选择初始化
	$('#timeRange').customDateRangePicker({ranges:{},showCustomRangeLabel:false,autoApply:true},'YYYY-MM-DD');
	
	
	// 下拉初始化
	$('#timeselect').select2({
		minimumResultsForSearch: -1
	});
	$('#timeUnit').select2({
		minimumResultsForSearch: -1
	});
	
	// 新增图表按钮点击事件
	$('#addChartBtn').click(function(){
		ADD_OR_UPDATE = 'add';
		clearModalInfo();
		$('#addChartModal').modal('show');
	})

	// 时间类型change事件
	function etypeChange() {
		var chartType = $('input[name="chartTypeOptions"]:checked').val();
		var timeType = $('#timeselect').val();
		if(timeType == NOW_DATE || timeType == LAST_DATE) {// 当前时间或者当前时间-1
			$('#timeWrap').addClass('hide');
			$('#timeRangeWrap').addClass('hide');
		}
		else{
			if(timeType == CUSTOM_DATE) {
				$('#timeWrap').addClass('hide');
				$('#timeRangeWrap').removeClass('hide');
			}
			else{
				$('#timeRangeWrap').addClass('hide');
				$('#timeWrap').removeClass('hide');
			}
		}
		
	}
	
	// 格式化所选时间
	function getChartTimeScope(){
		var timeScope = '';
		var timeType = $('#timeselect').val();
		if(timeType == NOW_DATE) {
			timeScope = '';
		}
		else if(timeType == LAST_DATE) {
			timeScope = '';
		}
		else if(timeType == CUSTOM_DATE) {
			timeScope = $('#timeRange').val();
		}
		else{
			timeScope = '' + $('#timePoint').val() + ' ' + $('#timeUnit').val();
		}
		return timeScope;
	}
	
	function getTreeNode(treeid){
		var treeObj = $.fn.zTree.getZTreeObj(treeid), 
		nodes = treeObj.getCheckedNodes(true), 
		selectedNode = [];
		for (var i = 0; i < nodes.length; i++) {
			selectedNode.push({
				code: nodes[i].code,
				name: nodes[i].name
			})
		}
		return selectedNode;
	}
	
	// 清空模态框
	function clearModalInfo(){
		$('#etitle').val('');
		$('#showTitle').prop('checked',true);
		$("input:radio[name='chartTypeOptions']").prop("checked",false);
		$("input:radio[name='chartTypeOptions']").eq(0).prop("checked",'checked');
		$('#timeselect').val(NOW_DATE); // Select the option with a value of '1'
		$('#timeselect').trigger('change'); 
		//$("timeselect").trigger("change");
		$("#timeRange").val('');
		$('#timePoint').val('');
		$('#showDetail').prop('checked',true);
		$('.tree-wrap.detail').removeClass('hide').show();
	}
})