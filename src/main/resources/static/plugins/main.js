(function(w,XHR){
//	var hidden_style = document.createElement("style");
//    hidden_style.setAttribute("id", "body_hidden_style");
//    hidden_style.innerHTML = "body{visibility:hidden;}";
//    document.head.appendChild(hidden_style);
    
	w.WEB_RES_PATH = '/vm/plugins/';
	w.LOCAL_RES_PATH = '/vm/'
	w.pro_v = '1.0.1';
	
	requirejs.config({
		baseUrl:WEB_RES_PATH,
		waitSeconds: 30,
        urlArgs: 'v=' + pro_v,
        map: {
        	'*': {
        		'css':'css.min'
        	}
        },
        paths: {
        	'jquery':'jQuery/jquery-2.2.3.min',
        	'bootstrap':'bootstrap/js/bootstrap.min',
        	'app': LOCAL_RES_PATH +'app/js/app',
        	'echarts':'echarts-2.2.7/dist/echarts-all',
        	'echarts3':'echarts3/echarts.min',
        	'iCheck':'iCheck/icheck.min',
        	'validator':'nice-validator/jquery.validator',
        	'validator.lang':'nice-validator/local/zh-CN',
        	'jquery.form':'jquery-form/jquery.form',
        	'jquery-confirm':'jquery-confirm/jquery-confirm.min',
        	'select2':'select2/select2.full.min',
        	'select2.lang':'select2/i18n/zh-CN',
        	'moment':'daterangepicker/moment.min',
        	'daterangepicker':'daterangepicker/daterangepicker',
        	'jquery.cookie':'jquery.cookie',
        	'bootstrapTable':'bootstrap-table/bootstrap-table',
        	'bootstrapTable.lang':'bootstrap-table/locale/bootstrap-table-zh-CN.min',
        	'bootstrap-treeview':'treeview/bootstrap-treeview',
        	'data.treeview':'treeview/data.treeview',
        	'layui':'layui/layui',
        	'layer':'layer/layer',
        	'zTree':'zTree/js/jquery.ztree.all',
        	'jquery.md5':'jquery.md5',
        	'smartWizard':'smartWizard/js/jquery.smartWizard',
        	'global_custom':LOCAL_RES_PATH+'js/custom/global_custom',
        	'ajaxfileupload':'uploadFile/ajaxfileupload',
        	'UE':'ueditor/ueditor.all',
        	'UE.config':'ueditor/ueditor.config',
        	'UE.lang':'ueditor/lang/zh-cn/zh-cn',
            'jquery-ui': 'jquery-ui/jquery-ui.min',
            'lodash': 'lodash.min'
        },
        shim:{
        	'echarts': {
                echarts: "echarts"
            },
            'jquery-ui': "jquery-ui",
        	'bootstrap': ['jquery'
        	              
        	             //, 'css!' + WEB_RES_PATH + 'bootstrap/css/bootstrap.min.css'
        	             , 'css!font-awesome/css/font-awesome.min.css'
        	             , 'css!'+ WEB_RES_PATH +'bootstrap/css/awesome-bootstrap-checkbox.css'
        	             //, 'css!' + LOCAL_RES_PATH +'app/css/AdminLTE.css'
        	             //, 'css!' + LOCAL_RES_PATH +'app/css/skins/skin-blue'
        	             , 'css!' + LOCAL_RES_PATH +'css/load.css'
        	             //, 'css!' + WEB_RES_PATH +'layui/css/layui.css'
        	             
        	             ],
        	'app': [ 
        	         //'css!' + LOCAL_RES_PATH +'css/custom.css'
        	        //, 'css!' + LOCAL_RES_PATH +'css/Rebaseadmin1.css'
   	             	//, 'css!' + LOCAL_RES_PATH +'css/catalogue.css'
   	          	 	//, 'css!' + LOCAL_RES_PATH +'css/release.css'
        	         ],
        	'iCheck': ['jquery', 'css!' + WEB_RES_PATH + 'iCheck/all.css'],
        	'jquery.form':['jquery'],
        	'jquery.md5': ['jquery'],
        	'jquery-confirm': ['jquery', 'css!../' + WEB_RES_PATH + 'jquery-confirm/jquery-confirm.min.css'],
        	'validator': ['jquery', 'css!nice-validator/jquery.validator.css'],
        	'validator.lang': ['validator'],
        	'select2': ['jquery', 'css!' + WEB_RES_PATH + 'select2/select2.min.css'],
        	'select2.lang': ['select2'],
        	'daterangepicker': ['jquery', 'moment', 'css!'+ WEB_RES_PATH + 'daterangepicker/daterangepicker.css'],
        	'bootstrapTable': ['jquery', 'css!' + WEB_RES_PATH + 'bootstrap-table/bootstrap-table.min.css'],
        	'bootstrapTable.lang': ['bootstrapTable'],
        	'bootstrap-treeview':['jquery'],
        	'data.treeview':['jquery'],
        	'layui':['jquery','css!' + WEB_RES_PATH + 'layui/css/layui.css'],
        	'layer':['jquery','css!' + WEB_RES_PATH + 'layui/css/layui.css','css!' + WEB_RES_PATH + 'layer/skin/default/layer.css'],
        	'zTree': ['jquery', 'css!' + WEB_RES_PATH + 'zTree/css/zTreeStyle/zTreeStyle.css','css!' + LOCAL_RES_PATH + 'css/zTreeStyle/zTreeStyle.css'],
        	'smartWizard':['jquery', 'css!' + WEB_RES_PATH + 'smartWizard/css/smart_wizard.css'
        	               , 'css!' + WEB_RES_PATH + 'smartWizard/css/smart_wizard_theme_dots.css'],
        	'ajaxfileupload':['jquery'],
        	'UE':['UE.config'],
        	'UE.lang':['UE'],
            'jquery-ui':['jquery', 'css!' + WEB_RES_PATH + 'jquery-ui/jquery-ui.min.css'] 
        }
	});
    
	require(['jquery', 'bootstrap'], function ($) {
//        $(hidden_style).remove();
//        delete hidden_style;
    })
    require(['jquery','global_custom'],function($,global_custom){
		global_custom.initGlobalCustom(basePathJS);
	})
	
}(window,XMLHttpRequest));

/**
 * 初始化
 */
(function (w, d) {
	
	require(['jquery','layer'],function($,layer){
		console.log('main.js-2');
		window.layer = layer;
	})
	require(['jquery','validator','zTree', 'lodash'],function($,validator,zTree, _){
		console.log('main.js-1');
		window.$ = window.jQuery = $;
		window._ = _;
		$.validator = jQuery.validator = validator;
		require(['app',function(){
			
		}])
	})
	
}(window,document))
