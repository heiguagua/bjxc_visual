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
                var userRegionObj = result.content.userRegion;
    			var default_region = JSON.parse(window.localStorage.getItem("regionObj"));
    			if(!default_region){
                    if(userRegionObj){
                        default_region = {name:userRegionObj.regionName, code: userRegionObj.regionCode};
                    }else{
                        default_region = {name:data[0].regionName, code: data[0].regionCode};
                    }
    			}
    			$("a.citytitle span.defaultcity span.Defaultcity_span").text(default_region.name);
    			var default_region_str = JSON.stringify(default_region);
    			window.localStorage.setItem("regionObj",default_region_str);
                //添加内容
                var htmlArray = new Array();
                for(var i = 0 ; i <data.length;i++){
                    htmlArray.push("<li region_code="+data[i].regionCode+">"+data[i].regionName+"</li>");
                }
                $("#box1").html(htmlArray.join(""));
                //regionSwitch(data);
    		}
        	console.log("table",$(tableSelector));
        },
        error: function(xhr) {
             console.error('error:' + JSON.stringify(xhr));
         }
    });
}


/*function regionSwitch(regions){
	$(".citytitle .defaultcity img.changeAdress").click(function(){
		$(".citytitle .innerul").stop().toggle(500);
	})
	$(".citytitle .innerul").delegate("li",'click',function(event){
			var k =$(this).index();
			$(".citytitle .defaultcity").text($(this).text())
			event.stopPropagation();
			$(".citytitle .innerul").stop().slideUp();
			var click_region_code = $(this).attr("region_code");
			var regionObj = JSON.parse(window.localStorage.getItem("regionObj"));
			if(regionObj.code != click_region_code){
				for(var i = 0 ;i < regions.length; i++){
					if(regions[i].regionCode == click_region_code){
						var regionObj = {name:regions[i].regionName , code : regions[i].regionCode};
						var regionsi_str = JSON.stringify(regionObj);
						window.localStorage.setItem("regionObj", regionsi_str);
					}
				}
				console.log(JSON.parse(window.localStorage.getItem("regionObj")));
			}
			console.log($(tableSelector));
			if($(tableSelector)){
                $(tableSelector).data("bootstrap.table").options.pageNumber = 1;
                $(tableSelector).data("bootstrap.table").refresh();
			}
	})
}*/


