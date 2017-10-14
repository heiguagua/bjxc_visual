
/**
 * 添加事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 * 
 */
function requirementAdd(title, addurl, width, height) {
    var options = _getDefaultWinOptionsList(title , addurl , width, height) ;
    createWindow(options);
}
/**
 * 添加事件打开窗口
 * @param title 编辑框标题
 * @param addurl//目标页面地址
 */
function add(title, addurl, width, height) {
    var options = _getDefaultWinOptions(title , addurl , width, height) ;
    createWindow(options);
}
function requirementEdit(title, url, id, width, height, isRestful){
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
    var options = _getDefaultWinOptionsList(title , url , width, height) ;
    createWindow(options);
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
function _getDefaultWinOptionsList(title , url , width, height) {
   var options = {
       title:title,
       width : width ,
       height : height ,
       content: url ,
       btn: ['<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
       success: _successLoad ,
       yes :function(index, layero){
    	   _submitRequirementForm(index , layero) ;
       }
   };

   return options ;
}

//var regionObj=null;
/**
 *
 * @param index
 * @param layero
 * @param options
 * @private
 */
function _submitRequirementForm(index, layero , options){
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
//	regionObj=jQuery.parseJSON(window.localStorage.getItem("regionObj"));
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
            var scmIdArr=$(form).find("*[name='scmIdArr']").val();
            var checkBoxArr=$(form).find("*[type='checkbox']");
            if (checkBoxArr==undefined||checkBoxArr.length==0){
            	tip("请选择上报内容。")
            	return false;
            }
            var uploadScope="";
            $(checkBoxArr).each(function(){
            	if ($(this).is(":checked")){
            		uploadScope=uploadScope+$(this).val();
            	}
            })
            if (uploadScope==""|| uploadScope==undefined){
            	tip("请选择上报内容。")
            	return false;
            }
            var uploadAddress=$(form).find("*[name='head']").val()+$(form).find("*[name='uploadAddress']").val();
            var json={scmId:scmIdArr,scope:uploadScope,uploadAddr:uploadAddress};
            $.ajax({
                url: action,
                data: json,
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
                        reloadTable();
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