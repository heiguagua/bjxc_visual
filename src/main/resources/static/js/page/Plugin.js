define(['jquery','jquery-ui','./Util'], function($,jqueryUi,Util) { //
  function Plugin( pluginId,chartId,pluginType,pluginName,el,echartInstnc) {
    this.pluginId = pluginId || 'plugin_' + Util.guid()
    this.chartId = chartId
    this.pluginName = pluginName
    this.pluginType = pluginType
    this.config = {}
    this.$el = el
    this.echartsInstnc = echartInstnc.chart || {}
  }

  Plugin.prototype = {
    constructor:Plugin,
    /**
     * [install 初始化拖拽和缩放]
     */
    install:function(){
      this.drag()
      this.resize()
    },
     /**
     * [uninstall 屏蔽拖拽和缩放]
     */
    uninstall:function(){
      $(this.$el).draggable("destroy")
      $(this.$el).resizable("destroy")
    },
    /**
     * [setConfig 设置组件config属性]
     * @param    {[Object]}                 config [组件配置属性(width,height,top,left...)]
     */
    setConfig:function(config){
      $.extend(true,this.config,config)
    },
    /**
     * [getConfig 获取组件config属性]
     * @return   {[Object]}                 [config]
     */
    getConfig:function(){
      return $.extend(true,{},this.config)
    },
    /**
     * [drag 组件拖拽功能]
     */
    drag:function(){
      var _this = this;
      var innerWidth = _this.$el.parent().width();
      var innerHeight = _this.$el.parent().height();
      $(this.$el).draggable({
        distance:1,
        // containment: "parent", //限定拖动区域
        create:function(e,ui){
          _this.setConfig({
            top: ($(_this.$el).position().top).toFixed(1),
            left: ($(_this.$el).position().left / innerHeight*100).toFixed(1)
          })
        },
        start:function(e,ui){},
        drag:function(e,ui){
          _this.$el.css({'border-color': '#005dff73' })
        },
        stop:function(e,ui){
          // console.log('dragStop ====> ',ui)
          // _this.setConfig(ui.position)
          _this.$el.css({'border-color': '#ddd' })
          _this.setConfig({
            top: Number($(_this.$el).position().top).toFixed(1),
            left: Number(($(_this.$el).position().left / innerWidth)*100).toFixed(1),
          })
          _this.resizeContainerHeight();
        }
      })
    },
    /**
     * [resize 组件拖拽缩放]
     */
    resize:function(){
      var _this = this;
      var innerWidth = _this.$el.parent().width();
      var innerHeight = _this.$el.parent().height();
      $(this.$el).resizable({
        handles: 'n, e, s, w, ne, se, sw, nw',
        // containment: "parent", //限定缩放区域
        minWidth:325,
        minHeight:225,
        create:function(e,ui){
          _this.setConfig({
            width: ($(_this.$el).outerWidth()/innerWidth*100).toFixed(1),
            height: ($(_this.$el).outerHeight()).toFixed(1),
            top: Number($(_this.$el).position().top).toFixed(1),
            left: Number(($(_this.$el).position().left / innerWidth)*100).toFixed(1)
          })
        },
        start:function(e,ui){},
        resize:function(e,ui){
          _this.echartsInstnc.resize();
          _this.$el.css({'border-color': '#005dff73' });
          _this.$el.css({'position' : 'absolute'})
        },
        stop:function(e,ui){
          console.log('ui ====>',ui)
          var new_width = $(_this.$el).outerWidth();
          var new_height = $(_this.$el).outerHeight();
          console.log(new_width,new_height);
          // _this.setConfig(ui.originalSize) 
          _this.$el.css({'border-color': '#ddd' })
          _this.$el.css({'position' : null})
          _this.setConfig({
            width: Number((new_width / innerWidth)*100).toFixed(1),
            height: Number((new_height).toFixed(1))
          })
          _this.setConfig({
            top: Number($(_this.$el).position().top).toFixed(1),
            left: Number(($(_this.$el).position().left / innerWidth)*100).toFixed(1),
          })
          _this.resizeContainerHeight();
          
          
          
        }
      })
    },
    resizeContainerHeight: function(){
  		var tops = [];
  		$('#chartWrapper .chart-item-wrap').each(function(){
  			tops.push($(this).position().top + $(this).height());
  		})
  		$('#chartWrapper').css({height:_.max(tops)  + 'px'});
  	}
  }
  return Plugin
});
