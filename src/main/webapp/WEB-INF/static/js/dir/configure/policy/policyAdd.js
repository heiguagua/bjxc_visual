$(function(){

    //富文本编辑器
    UE.getEditor('myEditor',{elementPathEnabled:false})

    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function(action){
        if(action == '/UEditorUploadAction/uploadImageToNative'){
            return basePath+'/UEditorUploadAction/uploadImageToNative';
        }else{
            return this._bkGetActionUrl.call(this, action);
        }
    }
});
