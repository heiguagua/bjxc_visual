define(['jquery','jquery-ui','./Util'], function($,jqueryUi,Util) { //
  function Plugin(pluginId,pluginType,pluginName,el,echartInstnc) {
    this.pluginId = pluginId || 'plugin_' + Util.guid()
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
      var innerWidth = this.$el.parent().innerWidth();
      var innerHeight = this.$el.parent().innerHeight();
      $(this.$el).draggable({
        distance:1,
        start:function(e,ui){},
        drag:function(e,ui){},
        stop:function(e,ui){
          console.log('dragStop ====> ',ui)
          // _this.setConfig(ui.position)
          _this.setConfig({
            top: Number((ui.position.top / innerWidth)*100).toFixed(1) + '%',
            left: Number((ui.position.left / innerWidth)*100).toFixed(1) + '%',
          })
        }
      })
    },
    /**
     * [resize 组件拖拽缩放]
     */
    resize:function(){
      var _this = this;
      var innerWidth = this.$el.parent().innerWidth();
      var innerHeight = this.$el.parent().innerHeight();
      $(this.$el).resizable({
        handles: 'n, e, s, w, ne, se, sw, nw',
        disabled: false,
        start:function(e,ui){},
        resize:function(e,ui){
          _this.echartsInstnc.resize()
        },
        stop:function(e,ui){
          console.log('resizestop ====>',ui)
          // _this.setConfig(ui.originalSize)
          _this.setConfig({
            width: Number((ui.originalSize.width / innerWidth)*100).toFixed(1) + '%',
            height: Number((ui.originalSize.height / innerHeight)*100).toFixed(1) + '%'
          })
          
        }
      })
    }
  }
  return Plugin
});
