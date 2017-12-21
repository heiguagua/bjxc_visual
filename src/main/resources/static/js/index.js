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
                initReverseBarChart(result.content.top,"deptCountPicDiv");
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
                title:{
                    text:'Top10',
                    x:'center'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                grid:{
                    x:'30px',
                    y:'15%',
                    x2:'10%',
                    y2:'60px'
                },
                xAxis: {
                    type: 'category',
                    data: nameArray,
                    axisLabel:{
                        interval:0,
                        rotate:35,//倾斜度 -90 至 90 默认为0
                        margin:2
                        /*textStyle:{
                            fontWeight:"bolder",
                            color:"#000000"
                        }*/
                    }
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        name: "资源数",
                        type: 'bar',
                        data: valueArray
                    }
                ]
            };
            myChart.setOption(option);
        }
    );
}
//x轴和y轴反转的柱状图
function initReverseBarChart(dataArry,id){
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
                title:{
                    text:'Top10',
                    x:'center'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                grid:{
                    x:'30%',
                    y:'15%',
                    x2:'3%',
                    y2:'60px'
                },
                axis:{
                    splitLine:{
                        show:false
                    }
                },
                xAxis: {
                    type: 'value'
                },
                yAxis: {
                    type: 'category',
                    data: nameArray
                },
                series: [
                    {
                        name: "资源数",
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



