define(["jquery", "echarts3", "bootstrap"], function(jquery, echarts, bootstrap) {
	
	// constructor
	function ECircle(el_id, opts){		
		this.opts = $.extend({}, ECircle.DEFAULTS, opts);
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
			    	top:'10%',
			    	show:true,
			        data: this.opts.legend_data
			    },
			    series:[{
			    	type: 'pie',
			        selectedMode: 'single',
			        radius: ['40%', '60%'],
			        center: ['50%', '60%'],
			        label: {
			            normal: {
			                position: 'inner',
			                formatter: '{d}%',

			                textStyle: {
			                    color: '#fff',
			                    fontWeight: 'bold',
			                    fontSize: 12
			                }
			            }
			        },
			        labelLine: {
			            normal: {
			                show: false
			            }
			        },
			        data: this.serDataFormatter()
			    }]
		};
		
		// 显示详情
		if(this.opts.showDetail && this.opts.detail_info.data.length > 0) {
			var info_content = '<div class="detail_info">';
			for(var i=0; i<this.opts.detail_info.data.length; i++) {
				var item =  this.opts.detail_info.data[i];
				info_content += '<div class="info-item">' + item.name +': '+ item.valData  + '</div>';
			}
			info_content += '</div>'
			var detail_info = $(info_content);
			$('#'+el_id).append(detail_info);
			option.series[0].center = ['30%', '60%']
		}
		console.log(option);
		this.chart.setOption(option);
	}

	
	ECircle.prototype.serDataFormatter = function() {
		var serData = this.opts.singleData;
		var ser_data_format = [];
		if(serData && serData.length > 0) {
			for(var i=0; i<serData.length; i++) {
				ser_data_format.push({
					name: this.opts.legend_data[i],
					value: serData[i]
				})
			}
		}
		return ser_data_format;
	}
	

	
	return {
		init: ECircle
	}
})