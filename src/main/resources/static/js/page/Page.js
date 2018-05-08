define(['./Plugin','./Util'], function(Plugins,Util) {
  function Page(pageId,pageName) {
    this.pageId = pageId || 'page_' + Util.guid()
    this.pageName = pageName || 'page1'
    this.$wrap = $('#chartWrapper')
    this.plugins = [] // 存储与当前页面相关的组件列表
  }

  Page.prototype = {
    constructor:Page,
    /**
     * [addPlugin 添加组件]
     * @param    {[String]}                 type             [组件类型]
     * @param    {[String]}                 name             [组件名称]
     * @param    {[String]}                 el               [组件容器]
     * @param    {[String]}                 echartInstnc     [charts实例对象]
     * @param    {[String]}                 pluginId         [组件ID]
     * @param    {[String]}                 chartId          [chartID]
     
     */
    addPlugin:function(type,name,el,echartInstnc,pluginId,chartId){
      var plugin = null
      if(!pluginId){
        pluginId = 'plugin_' + Util.guid()
      }

      try {
        plugin = new Plugins(pluginId, chartId,  type, name,el,echartInstnc);
        this.plugins.push(plugin); // 将组件投递到页面的组件列表中
      } catch (e) {
        console.error('Create plugin error : ' + e);
      }
    },
    /**
     * [delPlugin 删除组件]
     * @param    {[String]}                 pluginId [组件ID]
     */
    delPlugin:function(chartId){
      this.plugins = this.plugins.filter(function(item){return item.chartId !== chartId})
    },
    /**
     * [getPlugin 获取组件]
     * @param    {[String]}                 pluginId [组件ID]
     */
    getPlugin:function(pluginId){
      if(pluginId){
        return this.plugins.filter(function(item){return item.pluginId === pluginId})
      }

      return this.plugins
    },
    /**
     * [getPageConfig 获取页面信息]
     * @param    {[String]}                 pageId [页面ID]
     * @return   {[Obecjt]}                 [页面所有信息]
     */
    getPageConfig:function(pageId){
      return {
        pageId:this.pageId,
        pageName:this.pageName,
        plugins:this.plugins
      }
    },
    install:function(){
      this.plugins.forEach(function(item){
        item.install()
      })
    },
    uninstall:function(){
      this.plugins.forEach(function(item){
        item.uninstall()
      })
    }
  }
  return Page
});
