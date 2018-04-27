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

	$('#addChartConfirm').click(function() {
		var chartType = $('input[name="chartTypeOptions"]:checked').val();
		var showDetail = $('input[name="showDetail"]:checked').val();
		// TODO send ajax for indicator data
		var title = '人口与机构分析一览表';
		var data_unit = '%';
		var legend_data = ['孕产妇建卡率','人口与妇幼保健院卫生人员数比','人口与医疗卫生机构妇产科床位数比','人口与妇产科执业医师数比','人口与妇幼保健机构数比'];;
		var x_data = ['2012年','2013年','2014年','2015年','2016年','2017年','2018年'];
		var serData = [[9,7,8,7.8,6.8,4.1,5.6],
		               [7,7.8,8.4,7.2,5.6,5,7],
		               [4.6,4.2,5,5.8,5.4,4.2,6.3],
		               [2,2,3,2.5,3.2,2.8,2.1],
		               [0.7,0.8,0.4,0.1,0.5,0.6,0.7]
					];
		var detail_info = {
				title: '2014年西城区',
				data:[{name:'孕妇建卡人数',value:1000,unit:'人'},
	                   {name:'妇幼保健卫生人员数',value:600,unit:'人'},
	                   {name:'妇产科职业医师数',value:200,unit:'人'},
	                   {name:'妇幼保健机构数',value:15,unit:'家'}]
		};
		
		ECategory.create(chartType,{
			title: title,
			unit: data_unit,
			legend_data: legend_data,
			x_data: x_data,
			serData: serData,
			showDetail: showDetail,
			detail_info:detail_info
		});
		$('#addChartModal').modal('hide');
	})

	require(['zTree'],function(zTree){
		$.fn.zTree.init($("#indicatorTree"), setting, zNodes);
		$.fn.zTree.init($("#statisticTree"), setting, zNodes);
	})
})