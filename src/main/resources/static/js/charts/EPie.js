define(["jquery", "echarts3", "bootstrap"], function(jquery, echarts, bootstrap) {
	
	// constructor
	function EPie(el_id, opts){		
		this.opts = $.extend({}, EPie.DEFAULTS, opts);
		this.chart = echarts.init(document.getElementById(el_id));		
		var unit = this.opts.unit;
		
		console.log(this.opts);
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
			    	show: false,
			        data:this.opts.legend_data,
			        top:'8%'
			    },
			    grid: [{
			    	left: '10%',
			        right: '40%',
			        top:'18%',
			        bottom: '8%'
			    }, {
			        left: '60%'
			    }],
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			        data: this.opts.x_data
			    },
			    yAxis: {
			        type: 'value',
			        axisLabel: {
			        	formatter:function(value, index){
			        		return value + unit
			        	}
			        }
			    },
			    series:this.serDataFormatter()
		};
		
		if(this.opts.showDetail) {
			var info_content = '<div class="detail_info">';
			for(var i=0; i<this.opts.detail_info.data.length; i++) {
				var item =  this.opts.detail_info.data[i];
				info_content += '<div class="info-item">' + item.name +': '+ item.value + item.unit + '</div>';
			}
			info_content += '</div>'
			var detail_info = $(info_content);
			$('#'+el_id).append(detail_info);
		}
		this.chart.setOption(option);
	}

	
	EPie.prototype.serDataFormatter = function() {
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
		init: EPie
	}
})