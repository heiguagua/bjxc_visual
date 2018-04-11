/**
 * @author tx
 *
 */

$(document).on('click','#selectAllItem',function(){
    if(this.checked){
        $("#dataitemList :checkbox").prop("checked", true);
    }else{
        $("#dataitemList :checkbox").prop("checked", false);
    }

});


$(document).on('click','#addItems',function(){
    var thisTrNum=$('#dataitemList').find('tr').length;
    if(thisTrNum>0){
        var maxNum=0;
        $.each($('#dataitemList>tr'),function(idx,item){
            var i= $(item).find('input:first').attr('trNum');
            if(parseInt(i)>maxNum){
                maxNum=i;
            }
        })
        thisTrNum=parseInt(maxNum)+1;
    }
    $("#dataitemList").append('<tr id="tr_'+thisTrNum+'">' +
        '<td><input type="checkbox" trNum='+thisTrNum+'  name="index" ></td>' +
        '<td><select type="text" class="form-control"  name="items['+thisTrNum+'].contactsType" data-rule="required"><option value="负责人">负责人</option><option value="普通人">普通人</option></select></td>' +
        '<td><input type="text" class="form-control"  name="items['+thisTrNum+'].contactsName" data-rule="length(~32)"></td>' +
        '<td><input type="text" class="form-control"  name="items['+thisTrNum+'].contactsDept" data-rule="length(~18)"></td>' +
        '<td><input type="text" class="form-control"  name="items['+thisTrNum+'].contactsPost" data-rule="length(~18)"></td>' +
        '<td><input type="text" class="form-control"  name="items['+thisTrNum+'].contactsFixedPhone" data-rule="tel"></td>' +
        '<td><input type="text" class="form-control"  name="items['+thisTrNum+'].contactsPhone" data-rule="mobile"></td>' +
        '<td><input type="text" class="form-control"  name="items['+thisTrNum+'].contactsEmail" data-rule="email"></td>' +
        '</tr>')
});


$(document).on('click','#deleteItems',function(){
    $("#dataitemList").find('input[type="checkbox"]:checked').each(function(){
        var trNum=$(this).attr('trNum');
        infoTableDel(trNum);
    })
});

function infoTableDel(thisTrNum){
    $('#tr_'+thisTrNum).remove();
}






