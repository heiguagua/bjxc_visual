<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="main-header">
 <!-- Logo -->
 <a href="<%=basePath%>/data/collectJob" class="logo">
   <!-- mini logo for sidebar mini 50x50 pixels -->
   <span class="logo-mini"><b>${systemSubName}</b></span>
   <!-- logo for regular state and mobile devices -->
   <span class="logo-lg"><span><img src="../../static/images/addimg/favicon@2x.ICO"/>政务信息资源管理-${systemName}</span></span>
 </a>

 <!-- Header Navbar -->
 <nav class="navbar navbar-static-top" role="navigation">
   <!-- Sidebar toggle button-->
   <!-- <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"></a> -->
   <!-- Navbar Right Menu -->
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
       <li class="dropdown user user-menu">
         <!-- Menu Toggle Button -->
         <a href="<%=basePath%>/system/me/page" class="dropdown-toggle" data-toggle="tooltip" title="Admnin" data-placement="bottom">
           <img src="<%=basePath%>${(me.userImg)}" class="user-image" alt="User Image">
           <span class="hidden-xs">${me.userName}</span>
         </a>
       </li>
       <li>
         <a href="<%=basePath%>/login/logout" class="dropdown-toggle" data-toggle="tooltip" title="退出" data-placement="bottom">
           <i class="fa fa-sign-out"></i>
         </a>
       </li>
       <li style="width: 30px;">
       </li>
      </ul>
    </div>
  </nav>
</header>