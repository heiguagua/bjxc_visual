define(["jquery", "bootstrap", "echarts"], function(jquery, bootstrap, echarts) {

	// constructor
	function ELine(el, opts){
		this.opts = $.extend({}, ELine.DEFAULTS, opts);
		this.$el = $(el);
		this.chart = echarts.init(this.$el);
	}
	
	ELine.DEFAULTS = {
		tooltip: {
		    trigger: 'axis'
		},
	}
	
	ELine.prototype.draw = function() {
		var option = {
				title: this.opts.title,
				legend: {
					data: this.opts.legend_data
				},
				 xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: this.opts.x_data
				 },
				 yAxis: {
		             type: 'value'
				 },
				 series: this.serDataFormatter()
		};
		
		this.chart.setOption(option);
	}
	
	ELine.prototype.serDataFormatter = function() {
		var serData = this.opts.serData;
		var ser_data_format = [];
		if(serData && serData.length > 0) {
			for(var i=0; i<serData.length; i++) {
				ser_data_format.push({
					name: this.opts.legend_data[i],
					type: 'line',
					data: serData[i]
				})
			}
		}
		return ser_data_format;
	}
	
	return {
		ELine: ELine
	}
})