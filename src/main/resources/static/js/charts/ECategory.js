define(["jquery", "../../js/charts/ELine", "../../js/charts/ERadar", "../../js/charts/EFunnel", "../../js/charts/ECircle", "../../js/charts/EGauge"], function(jquery, ELine, ERadar, EFunnel, ECircle, EGauge) {

	// constructor
	function ECategory(etype, opts, ADD_OR_UPDATE,id){
		this.opts = $.extend({}, ECategory.DEFAULTS, opts);
		var el_id
		if(id) {
			el_id = id
		} else {
			el_id = Date.parse(new Date());
		}
		this.$el = $('<div class="chart-item-wrap"><div id="'+ el_id +'" class="chart-box"></div><div class="tool-box"><span class="fa fa-edit ">编辑</span></div></div>');		
		$('#chartWrapper').append(this.$el);
		this.instnc = {};
		switch(etype) {
			case 'eline':
				this.instnc = new ELine.init(el_id, this.opts);
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
		this.$el.find('.fa-edit').click(function(){
			// TODO get data info of current chart
			console.log(instance.opts);
			$('#etitle').val(instance.opts.title);
			$('#showTitle').prop('checked',instance.opts.isNameShow);
			$("input:radio[name='chartTypeOptions'][value='" + instance.opts.chartType + "']").prop("checked",true);
			$('#timeselect').val(instance.opts.chartTimeType);
			$('#timeselect').trigger('change'); 
			$("#timeRange").val('');
			$('#timePoint').val('');
			$('#showDetail').prop('checked',instance.opts.showDetail);
			ADD_OR_UPDATE = 'update'; // 模态框类型为修改
			$('#addChartModal').modal('show');
		})
	}
	
	ECategory.DEFAULTS = {
	}

	
	return {
		create: ECategory
	}
})