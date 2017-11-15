<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
	*{margin: 0;padding: 0;}
	.citytitle{
		position: relative;
/* 		margin: 0 21px; */
		display: inline-block;
		letter-spacing: 1px;
	}
	.citytitle .defaultcity{
		display: block;
		position: relative;
		color: #fff;
		text-align: center;
		font-size:14px;
		
		cursor: context-menu;
		font-family: PingFangSC-Regular;
	}
    .citytitle .defaultcity img.changeAdress{
        cursor: pointer;
    }
	.citytitle .innerul{width: 427px;
	/* height: 400px; */
	list-style: none;background: #fff; z-index: 999;
		position: absolute;
		/* left: 0; */
		right: 0;
		border: 1px solid #ccc;margin-top: 17px;border-radius: 7px;
		display: none;
	}
	.citytitle .innerul>li{width: 100px;height: 40px;text-align:center;float: left;line-height: 40px;
		cursor:pointer;color:#828689;background: #F5F5F5;margin: 3px;
	}
	.citytitle .innerul>li:nth-child(1){
		font-weight: bold;
	}
	.citytitle .innerul>li:hover{background:#56B4F8;color: #fff;}

    .btn-group a:link{ color:#ffffff}/* 链接默认为白色 */
    .btn-group a:hover{ color:#00a7d0}/* 鼠标悬停蓝色 */
</style>
<script src="<%=basePath%>/js/system/region/region_switch.js"></script>
<header class="main-header">
 <!-- Logo -->
  <%-- <div class="logo">
   <!-- mini logo for sidebar mini 50x50 pixels -->
   <span class="logo-mini"><b>${systemShortName}</b></span>
   <!-- logo for regular state and mobile devices -->
  <!-- <span class="logo-lg"><span><img src="<%=basePath%>/images/userImg/logoSmall.png"/>&nbsp;${systemName}-${systemSubName}</span></span> -->
   <a href="<%=basePath%>/index" style="color: #fff" ><span class="logo-lg"><span><img src="<%=basePath%>${defaultIcon}"/>&nbsp;
       <span id="logo" style="font-size: 12px">${systemName}-${systemSubName}</span></span></span></a>
 </div> --%>
    <input id="systemId" type="hidden" value="${integrateCurNo}">
 <!-- Header Navbar -->
 <nav class="navbar navbar-static-top" role="navigation">

 	<div class="col-sm-3 log">
        <a href="<%=basePath%>/index" title="${systemName}-${systemSubName}"><span style="color: #fff" ><img style="margin-top:-4px;" src="<%=basePath%>/images/userImg/logoSmall.png"/></span>${systemName}-${systemSubName}</a>
    </div>
   <!-- Sidebar toggle button-->
   <!-- <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"></a> -->
   <!-- Navbar Right Menu -->
   
   <div class="col-sm-5  btn-group">
   	<ul class="nav_uls" id="topTabs">
        <%--原tab--%>
        <%--<li>--%>
            <%--<img src="<%=basePath%>/images/userImg/sourceimgicon2.png"/>--%>
            <%--<a href="<%=basePath%>/jp:hk_drap" style="color: #FFFFFF;">&nbsp;资源梳理</a></li>--%>
        <%--<li class="active">--%>
            <%--<img src="<%=basePath%>/images/userImg/directimgicon1.png"/>&nbsp;<a href="###">目录管理</a>--%>
        <%--</li>--%>
        <%--<li>--%>
            <%--<img src="<%=basePath%>/images/userImg/collectimgicon2.png"/>--%>
            <%--<a target="_blank" href="<%=basePath%>/jp:hk_dcm" style="color: #FFFFFF;" >&nbsp;数据采集</a></li>--%>
        <%--<li>--%>
            <%--<img src="<%=basePath%>/images/userImg/serverimgicon1.png"/>--%>
            <%--<a href="<%=basePath%>/jp:hk_service" style="color: #FFFFFF;">&nbsp;服务封装</a></li>--%>
            <%--原tab--%>

     <%--    <li>
            <img src="<%=basePath%>/images/userImg/collectimgicon2.png"/>
            <a target="_blank" href="<%=basePath%>/jp:hk_cs" style="color: #FFFFFF;">&nbsp;;爬虫采集</a></li> --%>
		<%-- <li>
            <img src="<%=basePath%>/images/userImg/collectimgicon2.png"/>
            <a href="<%=basePath%>/jp:hk_analysis" style="color: #FFFFFF;">&nbsp;分析监管</a></li> --%>
        <%-- <li>
            <img src="<%=basePath%>/images/userImg/collectimgicon2.png"/>
            <a target="_blank" href="<%=basePath%>/jp:hk_portal" style="color: #FFFFFF;">&nbsp;门户</a></li> --%>
   	</ul>
   </div>
  <!--  navbar-custom-menu -->
   
   <div class="col-sm-4">
      <ul class="nav navbar-nav">
       <!-- Notifications Menu -->
       <%--<li class="dropdown notifications-menu">
         <!-- Menu toggle button -->
         <a href="#" class="dropdown-toggle" data-toggle="dropdown">
           <i class="fa fa-bell-o"></i>
           <span class="label label-warning">10</span>
         </a>
         <ul class="dropdown-menu">
           <li class="header">您有10条消息</li>
           <li>
             <!-- Inner Menu: contains the notifications -->
             <ul class="menu">
               <li><!-- start notification -->
                 <a href="#">
                   <i class="fa fa-comment-o"></i> 1 new members joined today
                 </a>
               </li><!-- end notification -->
             </ul>
           </li>
           <li class="footer"><a href="#"><i class="fa fa-angle-double-down"></i>查看全部</a></li>
         </ul>
       </li>--%>
       <!-- User Account Menu -->
   
       
       
        <li >
         <!-- Menu Toggle Button -->
          <a class="citytitle">
			<span class="defaultcity"><img src="<%=basePath%>/images/userImg/adress.png" />&emsp;<span class="Defaultcity_span"></span></span>
			<!-- <ul class="innerul" id="box1">
			</ul> -->
		  </a>
       </li>
       
     <li class="dropdown user user-menu">
         <!-- Menu Toggle Button -->
         <a href="<%=basePath%>/system/me/page" class="dropdown-toggle" data-toggle="tooltip" title="${me.realName}" data-placement="bottom">
           <img src="<%=basePath%>/images/userImg/avatar5.png" class="user-image" alt="User Image">
           <span class="hidden-xs">${me.userName}</span>
             <%-- <span class="hidden-xs"><%=basePath%>${(me.userImg)}</span> --%>
         </a>
       </li> 
         <%--  <li class="dropdown">
            <a href="javascript:;" data-toggle="dropdown" class="dropdown-toggle clear clearfix" aria-expanded="false">
                <span class="thumb-sm avatar m-t-n-sm m-b-n-sm m-l-sm">
                    <img id="userPortrait" src="<%=basePath%>${(me.userImg)}" alt="...">
                </span>
                <span id="userName" title="张三1">${me.userName}</span> <b class="caret"></b>
            </a>

             <ul class="dropdown-menu animated fadeInRight">
                <li>
                    <a href="<%=basePath%>/login/logout" class="text-center" ui-sref="access.signin">退出系统</a>
                </li>
            </ul> 

        </li> --%>
        
       <li>
         <a href="#" onclick="javascript:isOut()" class="dropdown-toggle" data-toggle="tooltip" title="退出" data-placement="bottom">
          <%--  <img src="<%=basePath%>/images/userImg/adminDeltimg.png" class="adminDeltimg"/> --%>
			<i class="fa fa-sign-out"></i>
         </a>
       </li> 
       
        
 
 </ul> 
    </div>
  </nav>
  <script type="text/javascript">
      $(document).ready(function(){
          if($('#logo').text().indexOf("-") == -1){
              $('#logo').css({"font-size":"16px"})
          }

          loadTabsData();
      })
    function isOut(){
      layer.confirm("是否退出系统", {icon: 3, title: "提示", offset: getOffset()}, function (index) {
          layer.close(index);
          window.location.href = '<%=basePath%>/login/logout';
        <%--window.location.href = '<%=basePath%>/login';--%>
      });
    }
    function loadTabsData() {
        var systemId=$("#systemId").val();
        var params = {integrateFlag : 1};
        $.post(basePathJS + "/system/productIntegrate/list",
            params,
            function(data){
               var rows= data.rows;
                var p=$("#topTabs");
                for(var i=0;i<rows.length;i++){
                    var row=rows[i];
                    var li=$('<li></li>');
                    var a=$('<a style="color: #FFFFFF;"></a>');
                    if(row.productNo==systemId){
                        li.addClass("active")
                        a.attr("href","###");
                    }else{
                        a.attr("href",basePathJS+row.jumpUrl);
                    }
                    var img=$('<img/>').attr("src",basePathJS+row.icon);
                    a.html("&nbsp;"+row.productShowName);
                    if(row.curOpenFlag !="1"){
                        //新页面打开
                        a.attr("target","_blank");
                    }
                    li.append(img).append(a);
                    p.append(li);
                }
            }
        );
    }

  </script>
</header>
