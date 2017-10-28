/**
 * Created by lixy on 2017/6/15.
 */
$(function () {
    $("form").submit(function () {
        $("input[name='password']").val($.md5($("#password").val()));
    });
});