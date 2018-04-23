/**
 * Created by zhanf on 2017/4/28. 1
 */
(function () {
	require(['jquery','global_custom'],function($){
		initSelectData();
	})
}());


// $(document).on('click','#selectAllItem',function(){
//     if(this.checked){
//         $("#dataitemList :checkbox").prop("checked", true);
//     }else{
//         $("#dataitemList :checkbox").prop("checked", false);
//     }
//
// });


// $(document).on('click','#addItems',function(){
//     var thisTrNum=$('#dataitemList').find('tr').length;
//     if(thisTrNum>0){
//         var maxNum=0;
//         $.each($('#dataitemList>tr'),function(idx,item){
//             var i= $(item).find('input:first').attr('trNum');
//             if(parseInt(i)>maxNum){
//                 maxNum=i;
//             }
//         })
//         thisTrNum=parseInt(maxNum)+1;
//     }
//     $("#dataitemList").append('<tr id="tr_'+thisTrNum+'">' +
//         '<td><input type="checkbox" trNum='+thisTrNum+' id="index" name="index" ></td>' +
//         '<td><select type="text" class="form-control" id="contactsType" name="items['+thisTrNum+'].contactsType" data-rule="required"><option value="负责人">负责人</option><option value="普通人">普通人</option></select></td>' +
//         '<td><input type="text" class="form-control" id="contactsName" name="items['+thisTrNum+'].contactsName" data-rule="length(~32)"></td>' +
//         '<td><input type="text" class="form-control" id="contactsDept" name="items['+thisTrNum+'].contactsDept" data-rule="length(~18)"></td>' +
//         '<td><input type="text" class="form-control" id="contactsPost" name="items['+thisTrNum+'].contactsPost" data-rule="length(~18)"></td>' +
//         '<td><input type="text" class="form-control" id="contactsFixedPhone" name="items['+thisTrNum+'].contactsFixedPhone" data-rule="tel"></td>' +
//         '<td><input type="text" class="form-control" id="contactsPhone" name="items['+thisTrNum+'].contactsPhone" data-rule="mobile"></td>' +
//         '<td><input type="text" class="form-control" id="contactsEmail" name="items['+thisTrNum+'].contactsEmail" data-rule="email"></td>' +
//         '</tr>')
// });


// $(document).on('click','#deleteItems',function(){
//     $("#dataitemList").find('input[type="checkbox"]:checked').each(function(){
//         var trNum=$(this).attr('trNum');
//         infoTableDel(trNum);
//     })
// });

// function infoTableDel(thisTrNum){
//     $('#tr_'+thisTrNum).remove();
// }


function initSelectData() {
    $.initRegionTreeSelect('treeDemo','regionName','regionCode','menuContent'); //初始化区域分类下拉框
    // initDeptSelectDataList();
}


function getPinyin() {
    var deptName=$("#deptName").val();
    if(deptName){
        $.commonAjax({
            url: basePathJS + "/system/dept/getPinyin",
            data: {cnName: deptName},
            success: function (result) {
                $("#pinyin").val(result);
            }
        });
    }

}






function runBeforeSubmit(form) {
    console.log("runBeforeSubmit");
    return true ;
}

function runAfterSubmitSuccess(response) {
    console.log("runAfterSubmitSuccess");
    //刷新主页面
    parent.reloadTable();
}

function runAfterSubmit(response) {
    console.log("runAfterSubmit");
}