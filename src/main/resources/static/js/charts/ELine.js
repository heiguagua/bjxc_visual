define(["jquery", "echarts3"], function(jquery, echarts) {
	
	// constructor
	function ELine(el_id, opts, etype){		
		this.opts = $.extend({}, ELine.DEFAULTS, opts);
		this.opts.isArea = etype;
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
				    	show: true,
				        data:this.legdXDataFormatter().legdData,
				        top:'8%'
				    },
				    grid: {
				    	left: '15%',
				        top:'18%',
				        bottom: '25%'
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: this.legdXDataFormatter().xData,
				        axisTick: {
			                alignWithLabel: true
			            },
				        axisLine: {
			                onZero: false
			            },
				        axisLabel:{
				        	interval: 0,
				        	rotate:40  
				        }
				    },
				    yAxis: {
				        type: 'value',
				        axisLabel: {
				        	formatter:function(value, index){
				        		return value 
				        	}
				        }
				    },
				    series:this.legdXDataFormatter().data
			};
		
		// 显示详情
		if(this.opts.showDetail) {
			var info_content = '<div class="detail_info">';
			for(var i=0; i<this.opts.detail_info.data.length; i++) {
				var item =  this.opts.detail_info.data[i];
				info_content += '<div class="info-item">' + item.name +': '+ item.valData + '</div>';
			}
			info_content += '</div>'
			var detail_info = $(info_content);
			$('#'+el_id).append(detail_info);
			
			option.grid = [{
		    	left: '15%',
		        right: '40%',
		        top:'18%',
		        bottom: '25%'
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
	
	// 图例和横坐标格式化
	ELine.prototype.legdXDataFormatter = function() {
		var xData = this.opts.x_data;
		var legend_xAxis_data = {
				xData: xData,
				legdData: this.opts.legend_data,
				data: this.serDataFormatter()
		};
		if(xData && xData.length == 1) {// 时间只有一个，则按指标来分类
			legend_xAxis_data.xData = this.opts.legend_data;
			legend_xAxis_data.legdData = xData;
			legend_xAxis_data.data = {
					name: xData[0],
					type: 'line',
					data: _.map(this.opts.gauge_data,'valData')
			} ;
			if(this.opts.isArea) {
				legend_xAxis_data.data.areaStyle = {
						normal:{}
				};
			}
		}
		return legend_xAxis_data;
	}
	return {
		init: ELine
	}
})