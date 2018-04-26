define(["jquery", "../../js/charts/ELine",'echarts'], function(jquery, ELine, echarts) {

	// constructor
	function ECategory(etype, opts){
		this.opts = $.extend({}, ECategory.DEFAULTS, opts);
		var el_id = Date.parse(new Date());
		this.$el = $('<div id="'+ el_id +'" class="chart-box"></div>');		
		$('#chartWrapper').append(this.$el);
		this.instnc = {};
		switch(etype) {
			case 'line':
				this.instnc = new ELine.init(el_id, this.opts);
				break;
			case 'pie':
				this.instnc = new ELine.init(el_id, this.opts);
				break;	
			
			default:
				this.instnc = new ELine.init(el_id, this.opts);
		}
		
	}
	
	ECategory.DEFAULTS = {
		tooltip: {
		    trigger: 'axis'
		},
	}
	
	
	return {
		create: ECategory
	}
})