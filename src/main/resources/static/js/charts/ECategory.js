define(["jquery", "../../js/charts/ELine", "../../js/charts/ERadar", "../../js/charts/EFunnel", "../../js/charts/ECircle", "../../js/charts/EGauge"], function(jquery, ELine, ERadar, EFunnel, ECircle, EGauge) {

	// constructor
	function ECategory(etype, opts, opType,id){// opType为ADD_OR_UPDATE，表示新增或修改
		this.opts = $.extend({}, ECategory.DEFAULTS, opts);
		var el_id = id;
		console.log(opType,id);
		if(opType == 'update') {
			this.$el = $('#'+el_id).parent();
		}
		else{
			this.$el = $('<div class="chart-item-wrap"><div id="'+ el_id +'" class="chart-box"></div><div class="tool-box"><span class="fa fa-edit ">编辑</span>&nbsp;&nbsp;<span class="fa fa-trash ">删除</span></div></div>');		
			$('#chartWrapper').append(this.$el);
		}
		console.log(this.$el);
		
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
			// get data info of current chart
			$.ajax({
	            type : "post",
	            url : basePathJS + "/chartConf/loadChartDetail",
	            async : false,
	            data:{
	            	id: el_id
	            },
	            success : function(res){
	            	console.log(res);
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
		    			
		    			$('#showDetail').prop('checked',instance.opts.showDetail);
		    			$('#addOrUpdate').val('update'); // 模态框类型为修改
		    			$("#updateChartId").val(el_id); // 将要修改的图表id赋给隐藏输入框
		    			$('#addChartModal').modal('show');
	            	}
	            	else{
	            		alert(res.msg);
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

	
	return {
		create: ECategory
	}
})