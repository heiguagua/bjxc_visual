jQuery(document).ready(function () {
//	 var parentId = $("#parentId").val();
//	 var fid = $("#fid").val();
//     initSelectData();
//     checkDep(fid);
	 window.DictData = new dict();
     initAllSelect();
     
});

function initAllSelect(){
	
//	$.initNationalQueryClassifyTreeSelect('treeNational','nationalCode','dictNationalCode','menuNationalContent');
//    Dict.selects('classify_icon',['#icon']);
    DictData.selects('categoryIntrude',['#category']);
    
}
$(function(){

    //富文本编辑器
    UE.getEditor('editor',{elementPathEnabled:false});
//    UE.getEditor('editor').setContent('');
    
});


function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    return true ;
}

function runAfterSubmitSuccess(response) {
    console.log("runAfterSubmitSuccess");
    //刷新主页面
//    parent.reloadTable();
}

function runAfterSubmit(response) {
    console.log("runAfterSubmit");
}