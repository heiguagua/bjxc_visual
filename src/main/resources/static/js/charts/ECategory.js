define(["jquery", "../../js/charts/ELine", "../../js/charts/ERadar"], function(jquery, ELine, ERadar) {

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