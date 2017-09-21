/**
 * 增删改工具栏
 */

/**
 * 返回 window的 zIndex
 * @param parentWin
 */
function getzIndex(parentWin) {
    var zIndex = layer.zIndex ;
    if (parentWin) {
        zIndex = parentWin.layer.zIndex ;
    }

    return zIndex ;
}

/**
 * 添加事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 */
function add(title, addurl, gname, width, height) {
    var options = _getDefaultWinOptions(title , addurl , width, height) ;
    createWindow(options);
}

/**
 * 新建向导窗口
 * @param title
 * @param addurl
 * @param width
 * @param height
 */
function addWizardWin(title, addurl, width, height) {
    var wizardOptions = {
        btn: ['<i class="fa fa-chevron-left"></i> 上一步' , '<i class="fa fa-chevron-right"></i> 下一步' ,'<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
        success: _successLoad ,
        yes :_prevFunc,
        btn2 : _nextFunc,
        btn3: function(index, layero){
            _submitForm(index , layero) ;
            return false ;
        }
    };

    var defaultOptions = _getDefaultWinOptions(title , addurl , width, height) ;
    var options = $.extend(defaultOptions , wizardOptions);

    createWindow(options);
}

/**
 * 更新事件打开窗口
 * @param title 编辑框标题
 * @param url //目标页面地址
 * @param id//主键字段
 */
function update(title, url, id, width, height, isRestful) {

    if (id) {
        if(isRestful!='undefined'&&isRestful){
            url += '/'+id;
        }else{
            if (url.indexOf("?") == -1 ) {
                url += '?id='+id;
            } else {
                url += '&id='+id;
            }
        }
    }

    var options = _getDefaultWinOptions(title , url , width, height) ;

    createWindow(options);
}

function addApi(title, url, parentId, width, height, isRestful) {

    if (parentId) {
        if(isRestful!='undefined'&&isRestful){
            url += '/'+parentId;
        }else{
            if (url.indexOf("?") == -1 ) {
                url += '?parentId='+parentId;
            } else {
                url += '&parentId='+parentId;
            }
        }
    }

    var options = _getDefaultWinOptions(title , url , width, height) ;

    createWindow(options);
}



//updateapi customization
function updateApi(title, url, id, width, height, isRestful) {

    if (id) {
        if(isRestful!='undefined'&&isRestful){
            url += '/'+id;
        }else{
            if (url.indexOf("?") == -1 ) {
                url += '?id='+id;
            } else {
                url += '&id='+id;
            }
        }
    }

    var options = _getDefaultWinOptions(title , url , width, height) ;

    createWindow(options);
}

/**
 * 如果页面是详细查看页面，无效化所有表单元素，只能进行查看
 */
//todo
// $(function(){
// 	if(location.href.indexOf("load=detail")!=-1){
// 		$(":input").attr("disabled","true");
// 	}
// });

/**
 * 查看详细事件打开窗口
 * @param title 查看框标题
 * @param url 目标页面地址
 * @param width
 * @param height
 */
function detail(title, url, width, height , parentWin) {
    var detailOptions = {
        btn: ['<i class="fa fa-close"></i> 取消'],
        yes :null
    };

    var defaultOptions = _getDefaultWinOptions(title , url , width, height) ;
    var options = $.extend(defaultOptions , detailOptions);

    if (parentWin) {
        options.parentWin = parentWin ;
    }
    createWindow(options);
}

/**
 * 创建通用弹出窗口
 * @param options： 参考layer的配置，特别注意：
 *                  width ：窗口宽度，默认值700px；
 *                  height : 窗口高度，默认值400px；
 *                  needSubmitForm 是否需要支持表单提交 ，默认值为true；
 *                  parentWin : 弹出窗口的parent；
 *
 */
function openCommonWin(options) {

    var options = $.extend({
        btn: ['<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
        success: _successLoad ,
        yes : function (index, layero) {
            _yesCallbackFunc(index , layero ,options);
        },
        needSubmitForm : true
    } , options);

    createWindow(options);
}

/**
 * 打开子窗口
 * @param parentWin
 * @param title
 * @param addurl
 * @param width
 * @param height
 */
function openSubWin(parentWin , title, url, yesFunc , width, height) {
    var options = _getDefaultSubWinOptions(parentWin , title , url ,yesFunc , width, height) ;
    options.parentWin = parentWin ;

    createWindow(options);
}

/**
 * 多记录刪除请求
 * @param title
 * @param url
 * @param tableSelector
 * @param func 自定义函数
 * @param parentWin 父窗口
 * @return
 */
function deleteALLSelect(url, tableSelector, func, parentWin) {
    var idArr = getTableSelectedIdArr(tableSelector);
    if (idArr.length > 0) {
        delObj(url, {idArr: idArr}, func, parentWin)
    } else {
         tip("请选择需要删除的数据", parentWin);
    }
}

/**
 * 返回id数组
 * @param tableDom
 * @param singleFlag
 * @param allowEmpty
 */
function getTableSelectedIdArr(tableDom, singleFlag, allowEmpty) {
    var idArr = [] ;
    var items = $(tableDom).data("bootstrap.table").getSelections();
    var checkedNum = items.length;
    if (allowEmpty && checkedNum == 0) {
        return idArr;
    }
    if (checkedNum == 0) {
        tip('请选择要进行操作的数据！');
        return idArr;
    }
    if (singleFlag && singleFlag == true) {
        if (checkedNum > 1) {
            tip('只能选择一条数据进行操作！');
            return idArr;
        }
    }

    for (var i in items) {
        var item = items[i];
        idArr.push(item['id']) ;
    }

    return idArr;
}

/**
 * 返回id以逗号分隔的字符串
 * @param tableDom
 * @param singleFlag
 * @param allowEmpty
 */
function getTableSelectedIds(tableDom, singleFlag, allowEmpty) {
	var ids = "";
	var idArr = getTableSelectedIdArr(tableDom , singleFlag , allowEmpty) ;
	if ($.isArray(idArr)) {
        ids = idArr.join(',') ;
	}

	return ids ;
}

/**
 * 删除调用函数
 * @param url
 * @param parameter
 * @param func
 * @param parentWin
 */
function delObj(url,parameter, func, parentWin) {
    createDialog('删除确认', '您『确定』删除当前选中的记录吗？', url, parameter, func, parentWin);
}

// 普通询问操作调用函数
function confirm(url, content,name) {
	createDialog('提示信息 ', content, url,name);
}

/**
 * 提示信息
 * @param msg
 * @param parentWin
 * @param autoClose 是否自动关闭提示信息
 * @param time 自动关闭所需毫秒 , 默认为1200毫秒
 */
function tip(msg ,parentWin , autoClose , time) {
    var options = {title : '提示信息' , icon: 0 } ;
    if (autoClose) {
        if (time) {
            time = 1200 ;
        }
        options.time = time ;
    }

    if (parentWin) {
        options.zIndex = getzIndex(parentWin);
        parentWin.layer.alert(msg, options);
    } else {
        options.zIndex = getzIndex();
        layer.alert(msg, options);
    }

}

/**
 * 成功操作提示信息
 * @param msg
 */
function successMsgTip(msg , parentWin) {
    var options = {icon: 1, time: 1200} ;
    if (parentWin) {
        options.zIndex = getzIndex(parentWin);
        parentWin.layer.msg(msg, options);
    } else {
        options.zIndex = getzIndex();
        layer.msg(msg, options);
    }
}

/**
 * 错误消息提示
 * @param msg
 */
function errorMsgTip(msg , parentWin) {
    var options = {title : '错误' , icon: 2} ;
    if (parentWin) {
        options.zIndex = getzIndex(parentWin);
        parentWin.layer.alert(msg, options);
    } else {
        options.zIndex = getzIndex();
        layer.alert(msg, options);
    }

}

/**
 * 创建添加或编辑窗口
 * @param options
 */
function createWindow(options) {
    var width = options.width ? options.width : 700;
    var height = options.height ? options.height : 400;
    var parentWin = options.parentWin ;

    if (width == "100%" || height == "100%") {
        width = window.top.document.body.offsetWidth;
        height = window.top.document.body.offsetHeight - 100;
    }

    var options = $.extend({
        zIndex: getzIndex(),
        opacity : 0.3,
        cache:false,
        type: 2,
        area: [width, height],
        offset:'90px',
        fixed: false, //不固定
        maxmin: false
    } , options);

    if(parentWin){
        options.zIndex = parentWin.layer.zIndex

        parentWin.layer.open(options);
    } else{
        layer.open(options);
    }
}

/**
 *
 * @param title
 * @param url
 * @param width
 * @param height
 * @returns {{title: *, width: *, height: *, content: *, btn: [string,string], success: _successLoad, yes: yes}}
 * @private
 */
function _getDefaultWinOptions(title , url , width, height) {
    var options = {
        title:title,
        width : width ,
        height : height ,
        content: url ,
        btn: ['<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
        success: _successLoad ,
        yes :function(index, layero){
            _submitForm(index , layero) ;
        }
    };

    return options ;
}

/**
 *
 * @param parentWin
 * @param title
 * @param url
 * @param yesFunc
 * @param width
 * @param height
 * @returns {{title: *, width: *, height: *, content: *, btn: [string,string], success: success}}
 * @private
 */
function _getDefaultSubWinOptions(parentWin , title , url ,yesFunc , width, height) {
    //todo
    if (!parentWin) {
        throw 'parentWin未定义';
    }

    var options = {
        title:title,
        width : width ,
        height : height ,
        content: url ,
        btn: ['<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
        success: function(layero, index){
            var body = parentWin.layer.getChildFrame('body', index);
            var form = body.find( "form:first" );

            form.validator({
                ignore: ':hidden',
                valid: function(form) {
                    //todo
                }
            });
        }
    };

    options.parentWin = parentWin ;

    if  (yesFunc) {
        options.yes = yesFunc ;
    } else {
        options.yes = function (index, layero) {
            //todo
            _submitForm(index , layero , options) ;
        }
    }

    return options ;
}

var _successLoad = function(layero, index){
    var body = layer.getChildFrame('body', index);
    var form = body.find( "form:first" );
    if (!form) {
        return ;
    }

    form.validator({
        ignore: ':hidden',
        valid: function(form) {
            //todo
        }
    });
};

var _prevFunc = function (index, layero) {
    var iframeWin = window[layero.find('iframe')[0]['name']]; //
    if ($.isFunction(iframeWin.navigatePrev)) {
        iframeWin.navigatePrev();
    } else {
        errorMsgTip('未找到navigatePrev()方法');
    }

    return false;
} ;

var _nextFunc = function (index, layero) {
    var iframeWin = window[layero.find('iframe')[0]['name']]; //
    if ($.isFunction(iframeWin.navigateNext)) {
        iframeWin.navigateNext();
    } else {
        errorMsgTip('未找到navigateNext()方法');
    }

    return false;
} ;

function _yesCallbackFunc(index, layero , options) {
    var needSubmitForm = options.needSubmitForm ;

    if (needSubmitForm) {
        _submitForm(index , layero , options);
    } else {
        _customYesCallback(index , layero , options)
    }
}

/**
 *
 * @param index
 * @param layero
 * @param options
 * @private
 */
function _submitForm(index, layero , options){
    options = options || {};
    var body ;
    var parentWin = options.parentWin ;
    if (parentWin) {
        body = parentWin.layer.getChildFrame('body', index);
    } else {
        body = layer.getChildFrame('body', index);
    }

    var form = body.find( "form:first" );

    if (!form) {
        return ;
    }

    var parentIframeName = options.parentIframeName;
    var parentIframeWin ;

    if (parentIframeName) {
        if (parentWin) {
            parentIframeWin = parentWin.window[parentIframeName];
        } else {
            parentIframeWin = window[parentIframeName];
        }
    }

    form.isValid(function (ret) {
        // 检查表单
        if (ret) {
            //todo
            //验证通过后，才能提交
            var iframeWin ;
            if (parentWin) {
                iframeWin = parentWin.window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
            } else {
                iframeWin = window[layero.find('iframe')[0]['name']];
            }

            //runBeforeSubmit: 提交之前，可重写此方法以获取额外参数设置与数据校验
            if ($.isFunction(iframeWin.runBeforeSubmit)) {
                if (!iframeWin.runBeforeSubmit(form)) {
                    return ;
                }
            }

            // var me = this;
            // // 提交表单之前，hold住表单，防止重复提交
            // me.holdSubmit(true);

            var action = form.attr("action");
            var method = form.attr("method") || 'post';

            $.ajax({
                url: action,
                data: $(form).serialize(),
                type: method,
                success: function(response) {
                    /**
                     *  response : ajax请求的后台响应数据
                     *  options ：弹窗的配置信息
                     * @type {{response: *, options: *}}
                     */
                    var data = {response : response , options : options , parentIframeWin : parentIframeWin};

                    if (response.state) {
                        if ($.isFunction(iframeWin.runAfterSubmitSuccess)) {
                            iframeWin.runAfterSubmitSuccess(data);
                        }
                        //todo
                        parent.layer.close(index);
                        successMsgTip(response.msg , parentWin) ;
                    } else {
                        errorMsgTip(response.msg , parentWin);
                    }

                    //todo
                    if ($.isFunction(iframeWin.runAfterSubmit)) {
                        iframeWin.runAfterSubmit(data);
                    }

                    // 提交表单成功后，释放hold
                    // me.holdSubmit(false);
                }
            });

        } else {
            tip("表单校验未通过，请检查输入。" , parentWin);
        }
    }) ;

};

/**
 * 自定义确认按钮回调用函数
 * @param index
 * @param layero
 * @param options
 * @private
 */
function _customYesCallback(index, layero , options) {
    var parentWin = options.parentWin ;
    var iframeWin ;
    if (parentWin) {
        iframeWin = parentWin.window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
    } else {
        iframeWin = window[layero.find('iframe')[0]['name']];
    }

    var parentIframeName = options.parentIframeName;

    var parentIframeWin ;

    if (parentIframeName) {
        if (parentWin) {
            parentIframeWin = parentWin.window[parentIframeName];
        } else {
            parentIframeWin = window[parentIframeName];
        }
    }

    //runBeforeSubmit: 提交之前，可重写此方法以获取额外参数设置与数据校验
    if ($.isFunction(iframeWin.runAfterSubmit)) {
        var  data = {parentIframeWin : parentIframeWin};
        if (!iframeWin.runAfterSubmit(data)) {
            return ;
        }
    }

    parent.layer.close(index);
}
/**
 * 创建查询页面窗口
 * 
 * @param title
 * @param addurl
 * @param saveurl
 */
// function opensearchdwin(title, url, width, height) {
// 	$.dialog({
// 		content: 'url:'+url,
// 		zIndex: getzIndex(),
// 		title : title,
// 		lock : true,
// 		height : height,
// 		cache:false,
// 		width : width,
// 		opacity : 0.3,
// 		button : [ {
// 			name : '查询',
// 			callback : function() {
// 				iframe = this.iframe.contentWindow;
// 				iframe.searchs();
// 			},
// 			focus : true
// 		}, {
// 			name : '取消',
// 			callback : function() {
//
// 			}
// 		} ]
// 	});
// }

/**
 * 创建询问窗口
 * @param title
 * @param content
 * @param url
 */
function createDialog(title, content, url, parameter, func, parentWin) {
	//todo zIndex = getzIndex();
    var realLayer;
    if(parentWin){
        realLayer = parentWin.layer;
    } else{
        realLayer = layer;
    }
    realLayer.confirm(content, {icon: 3, title:title, zIndex: realLayer.zIndex}, function(index){
        if($.isFunction(func)){
            func();
        } else{
            doSubmit(url,parameter);
        }
        realLayer.close(index);
    });
}

/**
 * 执行操作
 * @param url
 * @param index
 */
function doSubmit(url, parameter) {
	var paramsData = parameter;
	//把URL转换成POST参数防止URL参数超出范围的问题
	if(!paramsData){
		paramsData = new Object();
		if (url.indexOf("&") != -1) {
			var str = url.substr(url.indexOf("&")+1);
			url = url.substr(0,url.indexOf("&"));
			var strs = str.split("&");
			for(var i = 0; i < strs.length; i ++) {
				paramsData[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
			}
		}      
	}

	$.ajax({
		async : false,
		cache : false,
		type : 'POST',
		data : paramsData,
		url : url,// 请求的action路径
		error : function() {// 请求失败处理函数
		},
		success : function(result) {
			if (result.state) {
                reloadTable();
                var msg = result.msg;
                tip(msg);
			} else {
				tip(result.msg);
			}
		}
	});

}

/**
 * 获取Cookie值
 * @param c_name
 * @returns {string}
 */
function getCookie(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=")
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1
			c_end = document.cookie.indexOf(";", c_start)
			if (c_end == -1)
				c_end = document.cookie.length
			return unescape(document.cookie.substring(c_start, c_end))
		}
	}
	return ""
}

/**
 * 设置 cookie
 * @param c_name
 * @param value
 * @param expiredays
 */
function setCookie(c_name, value, expiredays){
	var exdate=new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie=c_name+ "=" + escape(value) + ((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}



// 2017-09-14 10:44:34
/**
 * [相关参考]
 * @layer               [http://layer.layui.com/]
 * @bootstrao-table     [http://bootstrap-table.wenzhixin.net.cn/documentation/]
 */

/**
 * [openLayer description]
 * @param  {[type]} id [description]
 * @param  {[type]} w  [description]
 * @param  {[type]} h  [description]
 * @return {[type]}    [description]
 */
function openLayer(id,title,w, h,fn) {
    var domHtml=$(id).html();
    //页面层
    layer.open({
        title: title||'信息',
        anim: 5,
        type: 1,
        top: 100,
        offset: '110px',
        area: [(w || 420) + 'px', (h || 240) + 'px'], //宽高
        // content: $(id).html(),
        content: $(id),
        btn: ['<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
        btnAlign: 'c',
        yes: function(index, layero) {
            fn(index,layero)
        },
        btn2: function(index, layero){
            $(id).attr('style','').html(domHtml)
        },
        cancel: function(index, layero){
            $(id).attr('style','').html(domHtml)
        }
    });
}
//无按钮
function openLayerNoBtn(id,title,w, h,fn) {
    // var domHtml=$(id).prop('outerHTML');
    var domHtml=$(id).html();
    //页面层
    layer.open({
        title: title||'信息',
        anim: 5,
        type: 1,
        top: 100,
        offset: '110px',
        area: [(w || 420) + 'px', (h || 240) + 'px'], //宽高
        content: $(id),
        cancel: function(index, layero){
            $(id).attr('style','').html(domHtml)
        }
    });
}
