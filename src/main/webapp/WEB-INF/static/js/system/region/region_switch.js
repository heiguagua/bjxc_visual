jQuery(document).ready(function () {
    initRegion();
});

function initRegion(){
	$.ajax({
        url: basePathJS+"/sysRegion/getRegionListForLoginUser",
//        data: $(form).serialize(),
        dataType: 'json',
        method: 'GET',
        success: function(result) {
        	if(result.state && result.content.selectData){
        		var data = result.content.selectData;
                if(data && data.length>0){
                    for(var i= 0,ii=data.length;i<ii;i++){
                        var regionCode = data[i].regionCode;
                        if(newRegionCode == regionCode){
                            $("a.citytitle span.defaultcity span.Defaultcity_span").text(data[i].regionName);
                        }
                    }
                }
                //添加内容
                var htmlArray = new Array();
                for(var i = 0 ; i <data.length;i++){
                    htmlArray.push("<li region_code="+data[i].regionCode+">"+data[i].regionName+"</li>");
                }
                $("#box1").html(htmlArray.join(""));
                regionSwitch();
    		}
        },
        error: function(xhr) {
             console.error('error:' + JSON.stringify(xhr));
         }
    });
}


function regionSwitch(){

    $(".citytitle .defaultcity img.changeAdress").click(function(){
        $(".citytitle .innerul").toggle(500);
    });

    $(".citytitle .innerul").delegate("li",'click',function(event){
        $(".citytitle .defaultcity span.Defaultcity_span").text($(this).text())
        event.stopPropagation();
        $(".citytitle .innerul").stop().slideUp();
        var regionCode = $(this).attr("region_code");
        $.commonAjax({
            url: basePathJS + "/sysRegion/changeSessionRegionValue",
            data: {regionCode: regionCode},
            success:function(result){
                window.location.reload();
            }
        });
    })
}



