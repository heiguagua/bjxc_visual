define(["jquery", "echarts3", "bootstrap"], function(jquery, echarts, bootstrap) {
	
	// constructor
	function ELine(el_id, opts){		
		this.opts = $.extend({}, ELine.DEFAULTS, opts);
		this.chart = echarts.init(document.getElementById(el_id));		
		console.log(this.opts.title)
		var option = {
			 title: {
			        text: this.opts.title,
			        left: 'center',
			        textStyle: {
			        	color: '#108EE9',
			        	fontWeight: 'normal',
			        	fontSize:16
			        }
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:this.opts.legend_data,
			        top:'8%'
			    },
			    grid: {
			    	top: '28%',
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			        data: this.opts.x_data
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series:this.serDataFormatter()
		};
		console.log(option);
		this.chart.setOption(option);
	}
	
	ELine.DEFAULTS = {
	}
	
	ELine.prototype.draw = function() {
		
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
		init: ELine
	}
})