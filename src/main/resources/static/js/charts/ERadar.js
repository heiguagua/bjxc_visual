define(["jquery", "echarts3", "bootstrap"], function(jquery, echarts, bootstrap) {
	
	// constructor
	function ERadar(el_id, opts){		
		this.opts = $.extend({}, ERadar.DEFAULTS, opts);
		this.chart = echarts.init(document.getElementById(el_id));		
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
			    tooltip: {},
			    legend: {
			    	show:false,
			        data: this.legdXDataFormatter().legdData
			    },
			    radar: {
			        center: ['50%','60%'],
			        name: {
			            textStyle: {
			                color: '#fff',
			                backgroundColor: '#999',
			                borderRadius: 3,
			                padding: [3, 5]
			           }
			        },
			        indicator: this.legdXDataFormatter().indicator_data
			    },
			    series: this.legdXDataFormatter().data
		};
		
		// 显示详情
		if(this.opts.showDetail && this.opts.detail_info.data.length > 0) {
			var info_content = '<div class="detail_info">';
			for(var i=0; i<this.opts.detail_info.data.length; i++) {
				var item =  this.opts.detail_info.data[i];
				info_content += '<div class="info-item">' + item.name +': '+ item.valData + '</div>';
			}
			info_content += '</div>'
			var detail_info = $(info_content);
			$('#'+el_id).append(detail_info);
			option.radar.center = ['30%','60%'];
			option.radar.radius = '50%';
		}
		this.chart.clear();
		this.chart.setOption(option);
	}

	
	ERadar.prototype.serDataFormatter = function() {
		var serData = this.opts.serData;
		
		var ser_data_format = [{
			type: 'radar',
			itemStyle: {normal: {areaStyle: {type: 'default'}}},
			data:[]
		}];
		if(serData && serData.length > 0) {
			for(var i=0; i<serData.length; i++) {
				ser_data_format[0].data.push({
					name: this.opts.legend_data[i],
					value: serData[i]
				})
			}
		}
		return ser_data_format;
	}
	
	ERadar.prototype.indicatorFormatter = function() {
		var indicatorData = this.opts.x_data;
		var indicator_data_format = [];
		if(indicatorData && indicatorData.length > 0) {
			for(var i=0; i<indicatorData.length; i++) {
				indicator_data_format.push({
					name: indicatorData[i],
					max: Math.max.apply(null,this.opts.serData.transpose()[i]) + 0.5*Math.max.apply(null,this.opts.serData.transpose()[i])
				})
			}
		}
		return indicator_data_format;
	}
	
	// 图例和横坐标格式化
	ERadar.prototype.legdXDataFormatter = function() {
		var xData = this.opts.x_data;
		var legend_data = this.opts.legend_data;
		var legend_xAxis_data = {
				indicator_data: this.indicatorFormatter(),
				legdData: legend_data,
				data: this.serDataFormatter()
		};
		if(xData && xData.length == 1) {// 时间只有一个，则按指标来分类
			var datas = [];
			var indicator_datas = [];
			
			_.forEach(this.opts.serData, function(value,i) {
				datas.push(value[0]);
				indicator_datas.push({
					name: legend_data[i],
					max: value[0] + 0.5*value[0]
				});
			});
			console.log(datas);
			legend_xAxis_data.indicator_data = indicator_datas;
			legend_xAxis_data.legdData = xData;
			
			legend_xAxis_data.data = [{
				type: 'radar',
				itemStyle: {normal: {areaStyle: {type: 'default'}}},
				data:[{
					name: xData[0],
					value: datas
				}]
			}]
		}
		return legend_xAxis_data;
	}
	
	return {
		init: ERadar
	}
})