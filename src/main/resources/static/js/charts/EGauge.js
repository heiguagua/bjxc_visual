define(["jquery", "echarts3", "bootstrap"], function(jquery, echarts, bootstrap) {
	
	// constructor
	function EGauge(el_id, opts){		
		this.opts = $.extend({}, EGauge.DEFAULTS, opts);
		this.chart = echarts.init(document.getElementById(el_id));		
		console.log(this.opts);

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
			    	show:false,
			        data: this.opts.legend_data
			    },
			    series: [
			             {
			                 name: this.opts.gauge_data.name,
			                 type: 'gauge',
			                 center: ['50%', '60%'],
			                 detail: {formatter:'{value}' },
			                 axisLine: {
			                     show: true,
			                     lineStyle: {
			                         width: 30,
			                         shadowBlur: 0,
			                         color: [
			                             [0.3, this.opts.theme.light[0]],
			                             [0.7, this.opts.theme.light[1]],
			                             [1, this.opts.theme.light[2]]
			                         ]
			                     }
			                 },
			                 data: [{value: this.opts.gauge_data[0]?this.opts.gauge_data[0].valData : ''}]
			             }
			         ]
		};
		
		// 显示详情
		if(this.opts.showDetail && this.opts.detail_info.data.length > 0) {
			var info_content = '<div class="detail_info">';
			for(var i=0; i<this.opts.detail_info.data.length; i++) {
				var item =  this.opts.detail_info.data[i];
				info_content += '<div class="info-item">'+ item.startTime + item.name +': '+ item.valData + '</div>';
			}
			info_content += '</div>'
			var detail_info = $(info_content);
			$('#'+el_id).append(detail_info);
			option.series[0].center = ['30%', '60%']
		}
		this.chart.clear();
		this.chart.setOption(option);
	}

	return {
		init: EGauge
	}
})