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
		font-size:20px;
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
</style>

<header class="main-header">
 <!-- Logo -->
 <a href="<%=basePath%>/data/collectJob" class="logo">
   <!-- mini logo for sidebar mini 50x50 pixels -->
   <span class="logo-mini"><b>${systemSubName}</b></span>
   <!-- logo for regular state and mobile devices -->
   <span class="logo-lg"><span><img src="<%=basePath%>/images/addimg/logo.png"/>&nbsp;政务信息资源管理-${systemName}</span></span>
 </a>

 <!-- Header Navbar -->
 <nav class="navbar navbar-static-top" role="navigation">
   <!-- Sidebar toggle button-->
   <!-- <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"></a> -->
   <!-- Navbar Right Menu -->
   
   <div class="btn-group">
   	<ul class="nav_uls">
   		<li><i class="fa fa-institution (alias)"></i>&nbsp;资源梳理</li>
   		<li class="active"><i class="fa fa-list-alt"></i>&nbsp;目录管理</li>
   		<li><i class="fa fa-newspaper-o"></i>&nbsp;服务封装</li>
   		<li><i class="fa  fa-database"></i>&nbsp;采集系统</li>
   	</ul>
   </div>
   
   
   <div class="navbar-custom-menu">
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
       
        <li>
         <!-- Menu Toggle Button -->
          <a class="citytitle">
			<span class="defaultcity">成都</span>
			<ul class="innerul" id="box1">
			</ul>
		  </a>
       </li>
       
       <li class="dropdown user user-menu">
         <!-- Menu Toggle Button -->
         <a href="<%=basePath%>/system/me/page" class="dropdown-toggle" data-toggle="tooltip" title="Admnin" data-placement="bottom">
           <img src="<%=basePath%>${(me.userImg)}" class="user-image" alt="User Image">
           <span class="hidden-xs">${me.userName}</span>
         </a>
       </li>
       <li>
         <a href="<%=basePath%>/login/logout" class="dropdown-toggle" data-toggle="tooltip" title="退出" data-placement="bottom">
           <i class="fa fa-chevron-circle-down"></i>
         </a>
       </li>
       <li style="width: 30px;">
       </li>
      </ul>
    </div>
  </nav>
</header>


<script type="text/javascript">

$(".citytitle .defaultcity").click(function(){
	$(".citytitle .innerul").stop().toggle(500);
})
$(".citytitle .innerul").delegate("li",'click',function(event){
		var k =$(this).index();
		$(".citytitle .defaultcity").text($(this).text())
		event.stopPropagation();
		$(".citytitle .innerul").stop().slideUp();
		/* var click_region_code = $(this).attr("region_code");
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
		} */
})

</script>