define(["jquery", "echarts3", "bootstrap"], function(jquery, echarts, bootstrap) {
	
	// constructor
	function ECircle(el_id, opts){		
		this.opts = $.extend({}, ECircle.DEFAULTS, opts);
		
		
		console.log(this.chart);
		this.chart = echarts.init(document.getElementById(el_id));		
		
		var option = {
				color: this.opts.theme.light,
				title: {
			        text: this.opts.title,
			        show: this.opts.isNameShow,
			        left: 'center',
			        textStyle: {
			        	color: '#108EE9',
			        	fontWeight: 'normal',
			        	fontSize:16
			        }
			    },
			    tooltip: {},
			    legend: {
			    	top:'8%',
			    	show:false,
			        data: this.opts.legend_data
			    },
			    series:[{
			    	type: 'pie',
			        selectedMode: 'single',
			        radius: ['20%', '50%'],
			        center: ['50%', '55%'],
//			        label: {
//			            normal: {
//			                position: 'inner',
//			                formatter: '{d}%',
//
//			                textStyle: {
//			                    color: '#fff',
//			                    fontWeight: 'bold',
//			                    fontSize: 12
//			                }
//			            }
//			        },
			        data: this.serDataFormatter()
			    }]
		};
		
		// 显示详情
		if(this.opts.showDetail && this.opts.detail_info.data.length > 0) {
			var info_content = '<div class="detail_info">';
			for(var i=0; i<this.opts.detail_info.data.length; i++) {
				var item =  this.opts.detail_info.data[i];
				info_content += '<div class="info-item"><div class="info-item-name">' + item.name +' </div><div class="info-item-num">'+ item.valData  + '<span class="info-item-unit">' + item.unit + '</span></div></div>';
			}
			info_content += '</div>'
			var detail_info = $(info_content);
			$('#'+el_id).append(detail_info);
//			option.series[0].center = ['30%', '60%']
		}
		
		console.log(option);
		this.chart.clear();
		this.chart.resize();
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