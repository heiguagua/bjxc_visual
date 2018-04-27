define(["jquery", "../../js/charts/ELine", "../../js/charts/ERadar", "../../js/charts/EFunnel", "../../js/charts/ECircle", "../../js/charts/EGauge"], function(jquery, ELine, ERadar, EFunnel, ECircle, EGauge) {

	// constructor
	function ECategory(etype, opts){
		this.opts = $.extend({}, ECategory.DEFAULTS, opts);
		var el_id = Date.parse(new Date());
		this.$el = $('<div id="'+ el_id +'" class="chart-box"></div>');		
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
		
	}
	
	ECategory.DEFAULTS = {
	}

	
	return {
		create: ECategory
	}
})