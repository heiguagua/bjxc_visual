define(["jquery", "echarts3"], function(jquery, echarts) {
	
	// constructor
	function ELine(el_id, opts, etype){		
		this.opts = $.extend({}, ELine.DEFAULTS, opts);
		this.opts.isArea = etype;
		this.chart = echarts.init(document.getElementById(el_id));		
		var unit = this.opts.unit;
		
		
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
				    grid: {
				    	left: '10%',
				        top:'18%',
				        bottom: '8%'
				    },
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
		
		// 显示详情
		if(this.opts.showDetail) {
			var info_content = '<div class="detail_info">';
			for(var i=0; i<this.opts.detail_info.data.length; i++) {
				var item =  this.opts.detail_info.data[i];
				info_content += '<div class="info-item">' + item.name +': '+ item.value + item.unit + '</div>';
			}
			info_content += '</div>'
			var detail_info = $(info_content);
			$('#'+el_id).append(detail_info);
			
			option.grid = [{
		    	left: '10%',
		        right: '40%',
		        top:'18%',
		        bottom: '8%'
		    }, {
		        left: '60%'
		    }];
		}

		console.log(option);
		this.chart.setOption(option);
	}
	
	ELine.DEFAULTS = {
	}
	
	ELine.prototype.serDataFormatter = function() {
		var serData = this.opts.serData;
		var ser_data_format = [];
		if(serData && serData.length > 0) {
			for(var i=0; i<serData.length; i++) {
				var obj = {
						name: this.opts.legend_data[i],
						type: 'line',
						data: serData[i]
					};
				if(this.opts.isArea) {
					obj.areaStyle = {
							normal:{}
					};
				}
				ser_data_format.push(obj);
			}
		}
		return ser_data_format;
	}
	
	return {
		init: ELine
	}
})