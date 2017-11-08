/**
 * 统计页面
 */

var thisJs = this;


$(document).ready(function() {
    require.config({
        paths: {
            echarts: basePathJS + '/plugins/echarts-2.2.7/dist'
        }
    });
    initBasicDiv();
    initThemeDiv();
    initDeptDiv();
    initDatasetDiv();
    initStatusDiv();
})

function initBasicDiv(){
    $.commonAjax({
        url:basePathJS + "/catalog/basic/total",
        success:function(result){
            if(result.state){
                $("#basicCountDiv").html("政务基础信息资源目录  "+result.content.total);
            }
        }
    });
    $.commonAjax({
        url:basePathJS + "/catalog/basic/topCount",
        success:function(result){
            if(result.state){
                initPieChart(result.content.top,"basicCountPicDiv");
            }
        }
    });
}


function initThemeDiv(){
    $.commonAjax({
        url:basePathJS + "/catalog/theme/total",
        success:function(result){
            if(result.state){
                $("#themeCountDiv").html("政务主题信息资源目录  "+result.content.total);
            }
        }
    });
    $.commonAjax({
        url:basePathJS + "/catalog/theme/topCount",
        success:function(result){
            if(result.state){
                initBarChart(result.content.top,"themeCountPicDiv");
            }
        }
    });
}

function initDeptDiv(){
    $.commonAjax({
        url:basePathJS + "/catalog/dept/total",
        success:function(result){
            if(result.state){
                $("#deptCountDiv").html("部门政务信息资源目录  "+result.content.total);
            }
        }
    });
    $.commonAjax({
        url:basePathJS + "/catalog/dept/topCount",
        success:function(result){
            if(result.state){
            	console.log("result",result)
                initBarChart(result.content.top,"deptCountPicDiv");
            }
        }
    });
}

function initPieChart(dataArry,id){
    require(
        [
            'echarts',
            'echarts/chart/pie'
        ],
        function (ec,theme) {
            var myChart = ec.init(document.getElementById(id),theme);
            var option = {
                tooltip : {
                    trigger: 'item',
                    formatter: "{b} : {c} ({d}%)"
                },
                calculable : true,
                series : [
                    {
                        type:'pie',
                        radius : ['30%', '70%'],
                        itemStyle : {
                            normal : {
                                label : {
                                    show : false
                                },
                                labelLine : {
                                    show : false
                                }
                            },
                            emphasis : {
                                label : {
                                    show : true,
                                    position : 'center',
                                    textStyle : {
                                        fontSize : '30',
                                        fontWeight : 'bold'
                                    }
                                }
                            }
                        },
                        data:dataArry
                    }
                ]
            };
            myChart.setOption(option);
        }
    );
}

function initBarChart(dataArry,id){
    require(
        [
            'echarts',
            'echarts/chart/bar'
        ],
        function (ec,theme) {
            var myChart = ec.init(document.getElementById(id),theme);
            var nameArray=new Array();
            var valueArray=new Array();
            for(var i= 0,ii=dataArry.length;i<ii;i++){
                var data = dataArry[i];
                var dataName = data["name"];
                var dataValue = data["value"];
                nameArray.push(dataName);
                valueArray.push(dataValue);
            }
            var option = {
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                xAxis: {
                    type: 'category',
                    data: nameArray
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        name: "xx",
                        type: 'bar',
                        data: valueArray
                    }
                ]
            };
            myChart.setOption(option);
        }
    );
}


function initDatasetDiv(){
    $.commonAjax({
        url:basePathJS + "/catalog/dataset/total",
        success:function(result){
            if(result.state){
                $("#datasetTotal").html(result.content.total);
            }
        }
    });
    $.commonAjax({
        url:basePathJS + "/catalog/service/total",
        success:function(result){
            if(result.state){
                $("#serviceTotal").html(result.content.total);
            }
        }
    });
}

function initStatusDiv(){
    $.commonAjax({
        url:basePathJS + "/catalog/status/count",
        success:function(result){
            if(result.state){
                var statusDetail = result.content.statusCount;
                $("#unRegisteNum").html(statusDetail.unRegisteNum);
                $("#unAuditNum").html(statusDetail.unAuditNum);
                $("#unReleaseNum").html(statusDetail.unReleaseNum);
                $("#releasedNum").html(statusDetail.releasedNum);
            }
        }
    });
}



