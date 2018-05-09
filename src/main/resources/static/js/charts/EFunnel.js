define(["jquery", "echarts3", "bootstrap"], function(jquery, echarts, bootstrap) {
	
	// constructor
	function EFunnel(el_id, opts){		
		this.opts = $.extend({}, EFunnel.DEFAULTS, opts);
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
			    	show:false,
			        data: this.opts.legend_data
			    },
			    calculable: true,
			    series: [{
			    	type:'funnel',
		            left: '10%',
		            top: 60,
		            //x2: 80,
		            bottom: 60,
		            width: '80%',
		            // height: {totalHeight} - y - y2,
		            min: 0,
//		            max: 100,
		            minSize: '0%',
		            maxSize: '100%',
		            sort: 'descending',
		            gap: 2,
		            label: {
		                normal: {
		                    show: true,
		                    position: 'inside'
		                },
		                emphasis: {
		                    textStyle: {
		                        fontSize: 20
		                    }
		                }
		            },
		            labelLine: {
		                normal: {
		                    length: 10,
		                    lineStyle: {
		                        width: 1,
		                        type: 'solid'
		                    }
		                }
		            },
		            itemStyle: {
		                normal: {
		                    borderColor: '#fff',
		                    borderWidth: 1
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
				info_content += '<div class="info-item">' + item.startTime + item.name +': '+ item.valData + '</div>';
			}
			info_content += '</div>'
			var detail_info = $(info_content);
			$('#'+el_id).append(detail_info);
			option.series[0].left = '5%';
			option.series[0].width = '50%';
		}
		this.chart.clear();
		this.chart.setOption(option);
	}

	
	EFunnel.prototype.serDataFormatter = function() {
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
		init: EFunnel
	}
})