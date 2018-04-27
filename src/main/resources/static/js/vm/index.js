require([ 'jquery', 'echarts3','global_custom', '../js/charts/ECategory.js',
		'zTree' ], function($, echarts ,global_custom,  ECategory, zTree) {
	var setting = {
		check : {
			enable : true,
			chkboxType : {
				"Y" : 's',
				"N" : 'ps'
			}
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			onCheck : onCheck
		}
	};

	var zNodes = [ {
		id : 1,
		pId : 0,
		name : "随意勾选 1",
		open : true
	}, {
		id : 11,
		pId : 1,
		name : "随意勾选 1-1",
		open : true
	}, {
		id : 111,
		pId : 11,
		name : "随意勾选 1-1-1"
	}, {
		id : 112,
		pId : 11,
		name : "随意勾选 1-1-2"
	}, {
		id : 12,
		pId : 1,
		name : "随意勾选 1-2",
		open : true
	}, {
		id : 121,
		pId : 12,
		name : "随意勾选 1-2-1"
	}, {
		id : 122,
		pId : 12,
		name : "随意勾选 1-2-2"
	}, {
		id : 2,
		pId : 0,
		name : "随意勾选 2"
	}, {
		id : 21,
		pId : 2,
		name : "随意勾选 2-1"
	}, {
		id : 22,
		pId : 2,
		name : "随意勾选 2-2"
	}, {
		id : 221,
		pId : 22,
		name : "随意勾选 2-2-1"
	}, {
		id : 222,
		pId : 22,
		name : "随意勾选 2-2-2"
	}, {
		id : 23,
		pId : 2,
		name : "随意勾选 2-3"
	} ];
	
	function onCheck(e, treeId, treeNode) {
		var treeObj = $.fn.zTree.getZTreeObj("indicatorTree"), nodes = treeObj
				.getCheckedNodes(true), v = "";
		for (var i = 0; i < nodes.length; i++) {
			v += nodes[i].name + ",";
		}
		console.log(v);
	}

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
		var chartType = $('input[name="chartTypeOptions"]:checked').val();
		var showDetail = $('input[name="showDetail"]:checked').val();
		// TODO send ajax for indicator data
		var title = '人口与机构分析一览表';
		var data_unit = '%';
		var legend_data = ['孕产妇建卡率','人口与妇幼保健院卫生人员数比','人口与医疗卫生机构妇产科床位数比','人口与妇产科执业医师数比','人口与妇幼保健机构数比'];;
		var x_data = ['2012年','2013年','2014年','2015年','2016年','2017年','2018年'];
		var serData = [[9,7,8,7.8,6.8],
		               [7,7.8,8.4,7.2,5.6],
		               [4.6,4.2,5,5.8,5.4],
		               [3,3.2,4,4.5,5.2],
		               [2.7,3.8,3.4,3.1,3.5],
		               [6.1,6.2,6,5,4],
		               [4.7,5.8,6.4,3.1,4.5],
					];
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
			unit: data_unit,
			legend_data: legend_data,
			x_data: x_data,
			serData: serData,
			singleData: singleData,
			showDetail: showDetail,
			detail_info:detail_info,
			gauge_data: gauge_data
		});
		$('#addChartModal').modal('hide');
	})
	
	
	
	$('input[name="chartTypeOptions"]').click(function(){
		etypeChange();
	})
	
	
	// 日期选择change事件
	$('#timeselect').on("change", function (e) {
		etypeChange();
	});
	
	// 日期选择初始化
	$('#timeRange').customDateRangePicker({},'YYYY-MM-DD');
	$('#timePoint').customDatePicker({timePicker: false},'YYYY-MM-DD');
	
	// 下拉初始化
	$('#timeselect').select2({
		minimumResultsForSearch: -1
	});
	
	require(['zTree'],function(zTree){
		$.fn.zTree.init($("#indicatorTree"), setting, zNodes);
		var showDetail = $('input[name="showDetail"]:checked').val();
		if(showDetail) {// 显示详情
			// TODO send ajax request for detail indicator
			$.fn.zTree.init($("#detailTree"), setting, zNodes);
		}
		
	})
	
	function etypeChange() {
		var chartType = $('input[name="chartTypeOptions"]:checked').val();
		if($('#timeselect').val() == 1) {// 当前时间
			$('#timeWrap').addClass('hide');
			$('#timeRangeWrap').addClass('hide');
		}
		else{
			if(chartType == 'eline' || chartType == 'earea') {
				$('#timeWrap').addClass('hide');
				$('#timeRangeWrap').removeClass('hide');
			}
			else{
				$('#timeRangeWrap').addClass('hide');
				$('#timeWrap').removeClass('hide');
			}
		}
		
	}
})