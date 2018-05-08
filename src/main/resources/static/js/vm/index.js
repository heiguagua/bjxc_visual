require([ 'jquery', 'echarts3','global_custom', '../js/charts/ECategory.js','../js/page/Page',
		'zTree', 'bootstrap' ], function($, echarts ,global_custom,  ECategory, Page, zTree) {
	

	
	var menuId = $('#menuId').val();
	getChart(menuId);

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
			}
	}
	
	function filter(treeId, parentNode, childNodes) {
		if (!childNodes) return null;
		
		var childNodes = childNodes.content.data;
		for (var i=0, l=childNodes.length; i<l; i++) {
			childNodes[i].isParent = childNodes[i].selectable == 0 ? true:false;
			childNodes[i].nocheck = childNodes[i].selectable == 0 ? true:false;
			//childNodes[i].children = [];
			
			
		}
		return childNodes;
	}
	require(['zTree'],function(zTree){
		$.fn.zTree.init($("#indicatorTree"), setting);
		var showDetail = $('input[name="showDetail"]:checked').val();
		if(showDetail) {// 显示详情
			// TODO send ajax request for detail indicator
			$.fn.zTree.init($("#detailTree"), setting);
		}
		
	})



	// 二维数组矩阵转置
	Array.prototype.transpose = function() {
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

	// 拖拽缩放---
	var pageInst = new Page()
	window.pageCtr = pageInst
	// ---
	
	$('#addChartConfirm').click(function() {
		ADD_OR_UPDATE = $('#addOrUpdate').val();
		var chartType = $('input[name="chartTypeOptions"]:checked').val();
		var showDetail = $('#showDetail').prop('checked');
		var isNameShow = $('#showTitle').prop('checked');
		var url = basePathJS + "/chartConf/addUsersChart";
		
		
		var location = '30 400 0 null'  ;
		
		var params = {
				chartName: $('#etitle').val(),
				isNameShow: isNameShow,
				chartType: chartType,
				chartTimeType: $('#timeselect').val(),
				chartTimeScope: getChartTimeScope(),
				hasSubIndictor: showDetail,
				location: location,
				indictors: JSON.stringify(getTreeNode('indicatorTree')),
				subIndictors: JSON.stringify(getTreeDetailNode('detailTree'))
		}
		
		if(ADD_OR_UPDATE == 'update') {//修改操作
			location = $('#location').val();
			params.id = $("#updateChartId").val();
			params.location = location;
			url = basePathJS + '/chartConf/editUsersChart ';
		}
		// send ajax for indicator data
		$.ajax({
            type : "post",
            url : url,
            async : false,
            data: params,
            success : function(res){
        		// response data
//        		var title = $('#etitle').val();
//        		var data_unit = '%';
//        		var legend_data = ['孕产妇建卡率','人口与妇幼保健院卫生人员数比','人口与医疗卫生机构妇产科床位数比','人口与妇产科执业医师数比','人口与妇幼保健机构数比'];
//        		var x_data = ['2012年','2013年','2014年','2015年'];
//        		var serData = [[9,7,8,7.8,6.8],
//        		               [7,7.8,8.4,7.2,5.6],
//        		               [4.6,4.2,5,5.8,5.4],
//        		               [3,3.2,4,4.5,5.2]
//        					];
            	var title = $('#etitle').val();
        		var data_all = res.content.basicData;
        		var serData = _.values(_.groupBy(data_all,'startTime'));
        		_.forEach(serData, function(item,index) {
        			item = _.map(item,'valData');
        			serData[index] = item;
        		});
        		var x_data = _.keys(_.groupBy(data_all,'startTime'));
        		var legend_data = _.keys(_.groupBy(data_all,'name'));

        		serData = serData.transpose();
        		var detail_info = {
        				title: title,
        				data:res.content.extendData
        		}
        		
        		var gauge_data = data_all;// 单个指标数据，用于仪表图
        		
        		
        		 var echarts = new ECategory.create(chartType,{
        			title: title,
        			isNameShow: isNameShow,
        			location: location,
        			legend_data: legend_data,
        			x_data: x_data,
        			serData: serData,
        			singleData: serData,
        			showDetail: showDetail,
        			detail_info:detail_info,
        			gauge_data: gauge_data,
        			chartType: chartType,
        			chartTimeType: $('#timeselect').val(),
        			chartTimeScope: getChartTimeScope(),
        		},ADD_OR_UPDATE,res.content.id);
        		
        		$('#addChartModal').modal('hide');
        		
        		// 拖拽缩放 ---
        		pageInst.addPlugin(chartType,chartType,echarts.$el,echarts.instnc,res.content.id);
        		 pageInst.install()
        		// ---
            }
        });



		
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
		$('#addOrUpdate').val('add');
		$('.update-dir').hide();
		$('.update-detail-dir').hide();
		$.fn.zTree.destroy("indicatorTree");
		$.fn.zTree.destroy("detailTree");
		$.fn.zTree.init($("#indicatorTree"), setting);
		$.fn.zTree.init($("#detailTree"), setting);
		clearModalInfo();
		$('#addChartModal').modal('show');
	})


	// 拖拽---
	// 保存
	$('#save').click(function() {
		var arr = pageInst.getPageConfig();
		console.log(arr);
		var locations = [];
		_.forEach(arr.plugins, function(item,index) {
			console.log(item.config);
			locations.push({
				id:item.pluginId,
            	location: '' + item.config.width + ' ' + item.config.height + ' ' + item.config.left + ' ' + item.config.top
			})
		});
		
		console.log(locations, JSON.stringify(locations));
		$.ajax({
            type : "post",
            url : basePathJS + '/chartMenuCustom/updateChartLocation',
            async : false,
            data: {
            	locationStr: JSON.stringify(locations)
            },
            success : function(res){
            	
            }
		})
	})
	// 编辑
  $('#edit').click(function(){
	  console.log(pageInst);
    pageInst.install()
  })
  // 浏览
  $('#preview').click(function(){
    pageInst.uninstall()
  })
  
 
  // ---

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
		var selectedNode = [];
		if(!$('.update-dir').is(':hidden')) {// 修改操作，且未重新选择指标
			$('#' + treeid).parent().find('.indi-datas li').each(function(){
				var indi_item = $(this);
				selectedNode.push({
					code: indi_item.attr('code'),
					name: indi_item.html()
				})
			})
			
		}
		else{
			var treeObj = $.fn.zTree.getZTreeObj(treeid), 
			nodes = treeObj.getCheckedNodes(true);
			for (var i = 0; i < nodes.length; i++) {
				selectedNode.push({
					code: nodes[i].indictorId,
					name: nodes[i].name
				})
			}
		}
		
		return selectedNode;
	}
	
	function getTreeDetailNode(treeid){
		var selectedNode = [];
		if(!$('.update-detail-dir').is(':hidden')) {// 修改操作，且未重新选择指标
			$('#' + treeid).parent().find('.indi-datas li').each(function(){
				var indi_item = $(this);
				selectedNode.push({
					code: indi_item.attr('code'),
					name: indi_item.html()
				})
			})
			
		}
		else{
			var treeObj = $.fn.zTree.getZTreeObj(treeid), 
			nodes = treeObj.getCheckedNodes(true);
			for (var i = 0; i < nodes.length; i++) {
				selectedNode.push({
					code: nodes[i].indictorId,
					name: nodes[i].name
				})
			}
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

	var pageInst = new Page();
	// 查询图表接口
	function getChart(menuId) {
    
    var chartArr
		$.ajax({
			type: 'post',
      async : false,
			url: basePathJS + '/chartMenuCustom/chartList',
			data: {
				menuId: menuId
			},
			success: function(res) {
				chartArr = res.content.data;
				chartArr.forEach(function(item) {
					var id = item.chartId;
					$.ajax({
						type: 'get',
            async : true,
						url: basePathJS + '/indictor/getIndictorDataByChartId',
						data: {
							id: id
						},
						success: function(res) {
             
                
                var data_all = res.content.basicData;
        		var serData = _.values(_.groupBy(data_all,'startTime'));
        		_.forEach(serData, function(item,index) {
        			item = _.map(item,'valData');
        			serData[index] = item;
        		});
        		var x_data = _.keys(_.groupBy(data_all,'startTime'));
        		var legend_data = _.keys(_.groupBy(data_all,'name'));

        		serData = serData.transpose();
        		var detail_info = {
        				title: item.chartName,
        				data:res.content.extendData
        		}
        		
        		var gauge_data = data_all;// 单个指标数据，用于仪表图
        		
        		
        		
//                var detail_info = {
//                  title: item.chartName,
//                  data: res.content.extendData
//                }
//                if(item.chartType == 'eline') {
//                  serData = [serData]
//                }
                var echarts = new ECategory.create(item.chartType, {
                  title: item.chartName,
                  isNameShow: item.isNameShow,
                  legend_data: legend_data,
                  x_data: x_data,
                  location: item.location,
                  serData: serData,
                  singleData: serData,
                  showDetail: item.hasSubIndictor,
                  detail_info: detail_info,
                  gauge_data: gauge_data,
                  chartType: item.chartType,
                  chartTimeType: item.chartTimeType,
                  chartTimeScope: item.chartTimeScope,
                }, ADD_OR_UPDATE,item.chartId);
                // 拖拽缩放 ---
                pageInst.addPlugin(item.chartType, item.chartType, echarts.$el, echarts.instnc,item.id);
               //  pageInst.install()
                // ---
              //}
						}
					})
				})
			}
		})
	}
	


})