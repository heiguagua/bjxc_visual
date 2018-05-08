define(["jquery", "../../js/charts/ELine", "../../js/charts/ERadar", "../../js/charts/EFunnel", "../../js/charts/ECircle", "../../js/charts/EGauge"], function(jquery, ELine, ERadar, EFunnel, ECircle, EGauge) {
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
	// constructor
	function ECategory(etype, opts, opType,id){// opType为ADD_OR_UPDATE，表示新增或修改
		this.opts = $.extend({}, ECategory.DEFAULTS, opts);
		var el_id = id;
		if(opType == 'update') {
			this.$el = $('#'+el_id).parent();
			this.$el.find('.detail_info').remove();
		}
		else{
			var chart_location = '';
			if(opts.location) {
				var location_coords = opts.location.split(' ');
				var width = location_coords[0]/100*$('#chartWrapper').width();
				var height = location_coords[1];
				var left = location_coords[2]/100*$('#chartWrapper').width();
				var top = location_coords[3];
				if($('#chartWrapper').children('.chart-item-wrap').length > 0 && top == 'null') {
					top = $('#chartWrapper').height();
				}
				chart_location = 'width:' + width + 'px;height:' + height + 'px;left:' + left +'px;top:' + top +'px;';
			}
			
			this.$el = $('<div class="chart-item-wrap" style="position:absolute;'+ chart_location +
					'"><div id="'+ el_id +'" class="chart-box"></div><div class="tool-box"><span class="fa fa-edit ">编辑</span>&nbsp;&nbsp;<span class="fa fa-trash ">删除</span></div></div>');		
			$('#chartWrapper').append(this.$el);
			resizeContainerHeight(); //重置容器高度
		}
		
		this.instnc = {};
		switch(etype) {
			case 'eline':
				this.instnc = new ELine.init(el_id, this.opts);
				break;
			case 'ebar':
				this.instnc = new ELine.init(el_id, this.opts, etype);
				break;
			case 'earea':
				this.instnc = new ELine.init(el_id, this.opts, etype);
				break;
			case 'eradar':
				this.instnc = new ERadar.init(el_id, this.opts);
				break;
			case 'efunnel':
				this.instnc = new EFunnel.init(el_id, this.opts);
				break;
			case 'ecircle':
				this.instnc = new ECircle.init(el_id, this.opts);
				break;
			case 'egauge':
				this.instnc = new EGauge.init(el_id, this.opts);
				break;
			default:
				//this.instnc = new ELine.init(el_id, this.opts);
		}
		var instance = this.instnc;
		
		// 编辑图表配置
		this.$el.find('.fa-edit').click(function(){
			$.fn.zTree.destroy("indicatorTree");
			$.fn.zTree.destroy("detailTree");
			
			$('.update-dir').show();
			$('.update-detail-dir').show();
			
			 // 编辑配置时，重新选择指标
			  $('#rechooseTree').click(function(){
				  $.fn.zTree.init($("#indicatorTree"), setting);
				  $('.update-dir').hide();
			  })
			  
			  //编辑配置时，重新选择详情指标
			  $('#rechooseDetailTree').click(function(){
				  $.fn.zTree.init($("#detailTree"), setting);
				  $('.update-detail-dir').hide();
			  })
			// get data info of current chart
			$.ajax({
	            type : "post",
	            url : basePathJS + "/chartConf/loadChartDetail",
	            async : false,
	            data:{
	            	id: el_id
	            },
	            success : function(res){
	            	if(res.state){
	            		var resData = res.content.data;
		    			$('#etitle').val(instance.opts.title);
		    			$('#showTitle').prop('checked',instance.opts.isNameShow);
		    			$("input:radio[name='chartTypeOptions'][value='" + instance.opts.chartType + "']").prop("checked",true);
		    			$('#timeselect').val(instance.opts.chartTimeType);
		    			$('#timeselect').trigger('change'); 
		    			$("#timeRange").val('');
		    			$('#timePoint').val('');
		    			if(instance.opts.chartTimeType == CUSTOM_DATE) {// 自定义时间段
		    				$("#timeRange").val(resData.chartTimeScope);
		    			}
		    			if(instance.opts.chartTimeType == RECENT_YEARS) { // 最近xx年/月/日
		    				$('#timePoint').val(resData.split(' ')[0]);
		    				$('#timeUnit').val(resData.split(' ')[1]);
		    			}
		    			
		    			var selectedIndicators = resData.listClassifyIndictorMap;
		    			var selectedDetailIndicators = resData.listChartDescIndictorMap;
		    			$('.selected-indicators').html(getSelectedIndicators(selectedIndicators));
		    			$('.selected-detail-indicators').html(getSelectedIndicators(selectedDetailIndicators));
		    			
		    			$('#showDetail').prop('checked',instance.opts.showDetail);
		    			$('#addOrUpdate').val('update'); // 模态框类型为修改
		    			$("#updateChartId").val(el_id); // 将要修改的图表id赋给隐藏输入框
		    			$('#location').val(resData.location); // 保存要修改图表的location
		    			$('#addChartModal').modal('show');
	            	}
	            	else{
	            		if(res.msg) {
	            			layer.alert(res.msg);
	            		}
	            	}
	            	
	            }
			})
			
		})
		
		// 删除图表
		this.$el.find('.fa-trash').click(function(){
			layer.confirm('确认要删除这个图表吗？', {
	            btn : [ '确定', '取消' ]//按钮
	        }, function(index) {
	            layer.close(index);
	            $.ajax({
		            type : "post",
		            url : basePathJS + "/chartConf/deleteByChartId",
		            async : false,
		            data:{
		            	id: el_id
		            },
		            success : function(res){
		            	if(res.state) {
							$('#'+el_id).parent().remove();
							window.pageCtr.delPlugin(el_id);
							console.log(pageCtr);
		            		resizeContainerHeight();
		            	}
		            	else{
		            		alert(res.msg);
		            	}
		            }
				})
	        }); 
		})
	}
	
	ECategory.DEFAULTS = {
	}

	function resizeContainerHeight(){
		var tops = [];
  		$('#chartWrapper .chart-item-wrap').each(function(){
  			tops.push($(this).position().top + $(this).height());
  		})
  		$('#chartWrapper').css({height:_.max(tops) + 42 + 'px'});
	}
	
	function getSelectedIndicators(selectedIndicators) {
		var tmp ='';
		_.forEach(selectedIndicators, function(item,index) {
			tmp += '<li code="'+item.indictorCode+'">'+item.indictorShowName+'</li>';
		});
		return tmp;
	}
	
	return {
		create: ECategory
	}
})