define(["jquery", "echarts3", "bootstrap"], function(jquery, echarts, bootstrap) {
	
	// constructor
	function ERadar(el_id, opts){		
		this.opts = $.extend({}, ERadar.DEFAULTS, opts);
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
			    tooltip: {},
			    legend: {
			    	show:false,
			        data: this.opts.legend_data
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
			        indicator: this.indicatorFormatter()
			    },
			    series: this.serDataFormatter()
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
			option.radar.center = ['30%','60%'];
			option.radar.radius = '50%';
		}
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
		console.log(this.opts.serData.transpose());
		if(indicatorData && indicatorData.length > 0) {
			for(var i=0; i<indicatorData.length; i++) {
				console.log(Math.max.apply(null,this.opts.serData.transpose()[i]));
				indicator_data_format.push({
					name: indicatorData[i],
					max: Math.max.apply(null,this.opts.serData.transpose()[i]) + 0.5*Math.max.apply(null,this.opts.serData.transpose()[i])
				})
			}
		}
		return indicator_data_format;
	}
	
	// 二维数组矩阵转置
	Array.prototype.transpose = function() {
		console.log(this);
		var length = this.length;
		var arr_new = [];
		if(length != 0) {
			// 初始化，确定有多少行
			for(var i=0; i<this[0].length; i++) {
				arr_new[i] = [];
			}
			for(var i=0;i<this.length;i++){
		        for(var j=0;j<this[i].length;j++){
		            //动态添加数据到arr_new数组中
		        	arr_new[j][i]=this[i][j];
		        }
		    }
		}
		return arr_new;
	}
	
	return {
		init: ERadar
	}
})