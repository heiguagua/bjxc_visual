<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<aside class="main-sidebar">
 <!-- sidebar: style can be found in sidebar.less -->
 <section class="sidebar">
   <!-- Sidebar user panel (optional) -->
   <%-- <div class="user-panel">
     <div class="pull-left image">
       <img src="<%=basePath%>${me.userImg}" class="img-circle">
     </div>
     <div class="pull-left info">
       <p>${me.userName}</p>
       <!-- Status -->
       <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
     </div>
   </div> --%>

   <!-- Sidebar Menu -->
   <ul class="sidebar-menu">
     <!-- Optionally, you can add icons to the links -->
    <!--  <li class="header">菜单导航</li>
 -->
     <%--<c:if test="${treeMenus != null}">
        <c:forEach items="${treeMenus}" var="vo">

            <li class="treeview <c:if test="${res != null } && ${vo.sysMenu.id eq res}"> active  menu-open </c:if> ">
                <a href="#">
                    <i class="fa ${(vo.sysMenu.icon)}"></i>
                    <span>${(vo.sysMenu.menuName)}</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <c:forEach items="${vo.children}" var="ch" >
                        <li class="<c:if test="${cur != null } && ${ch.sysMenu.id eq cur}"> active </c:if>">
                            <a href="${(ch.sysMenu.url)}?res=${(vo.sysMenu.id)}&cur=${(ch.sysMenu.id)}">
                                <i class="fa ${(ch.sysMenu.icon)}"></i> ${(ch.sysMenu.menuName)}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </li>

        </c:forEach>

     </c:if>--%>
   </ul><!-- /.sidebar-menu -->
   <a href="#" class="sidebar-toggle trapezoid-1" data-toggle="offcanvas" role="button" style="top:300px">
	<img src="<%=basePath%>/images/userImg/sectionBack.png" id="smallImg"/>
	</a>
 </section>
 <!-- /.sidebar -->
</aside>

<script type="text/javascript">
    jQuery(document).ready(function () {
        loadMenuData();
        $(document).on('expanded.pushMenu',function(){
        	setTimeout(function(){
        		$("#smallImg").prop("src",basePathJS+"/images/userImg/sectionBack.png")
        		$("#smallImg").parent().css("right","-14px")
        		$("#smallImg").parent().css("top","300px")
        	},200);
        })
        $(document).on('collapsed.pushMenu',function(){
        	setTimeout(function(){
        		$("#smallImg").prop("src",basePathJS+"/images/userImg/BigsectionBackSmall.png")
        		$("#smallImg").parent().css("right","-14px")
        		$("#smallImg").parent().css("top","300px")
        	},200);
        	
        })
    });

    /**
     * 加载菜单数据
     */
    function loadMenuData(){
        var params = {id : $("#deptId").val()};
        $.post(basePathJS + "/system/menu/getLoginUserMenus",
            params,
            function(data){
                if(data && data.content){

                    var treeMenus = data.content.treeMenus ;
                    
                    var res = data.content.res ;
                    var cur = data.content.cur ;
                    for(var i = 0; i < treeMenus.length; i++ ) {
                        var parentMenu = treeMenus[i];
                        var childrenMenu = parentMenu.children ;
                        var hasChild = childrenMenu && childrenMenu.length > 0 && (parentMenu.sysMenu.url=="") ;


                        var treeviewLi = $('<li></li>').addClass('treeview');
                        if (res === parentMenu.sysMenu.id) {
                            treeviewLi.addClass('active menu-open');
                        }

                        var parentMenuUrl = '#';
                        if (!hasChild && parentMenu.sysMenu.url) {
                            parentMenuUrl = basePathJS + parentMenu.sysMenu.url + "?res=" + parentMenu.sysMenu.id;

                            treeviewLi.removeClass('treeview menu-open');
                        }

                        var treeviewLiA = $('<a></a>').attr("href" , parentMenuUrl);

                        var ai1 = $('<i></i>').addClass('fa').addClass(parentMenu.sysMenu.icon);
                        var aSpan = $('<span></span>').append(parentMenu.sysMenu.menuName);

                        var ai2 = '';
                        if (hasChild) {
                            ai2 =  $('<i></i>').addClass('fa fa-angle-left pull-right') ;
                        }

                        treeviewLiA.append(ai1).append(aSpan).append(ai2)

                        var treeviewLiUl = '';
                        if (hasChild) {
                            treeviewLiUl = $('<ul></ul>').addClass('treeview-menu');

                            for(var j = 0; j < childrenMenu.length; j++ ) {
                                var  childMenu = childrenMenu[j];

                                var treeviewMenuLi = $('<li></li>');
                                if (cur === childMenu.sysMenu.id ) {
                                    treeviewMenuLi.addClass('active');
                                }

                                var treeviewMenuLiA = $('<a></a>').attr("href" , basePathJS + childMenu.sysMenu.url + "?res=" + parentMenu.sysMenu.id + "&cur=" + childMenu.sysMenu.id );
                                var ai3 = $('<i></i>').addClass('fa').addClass(childMenu.sysMenu.icon);

                                treeviewMenuLiA.append(ai3).append(childMenu.sysMenu.menuName);
                                treeviewMenuLi.append(treeviewMenuLiA);

                                treeviewLiUl.append(treeviewMenuLi) ;
                            }
                        }

                        treeviewLi.append(treeviewLiA).append(treeviewLiUl);

                        $(".sidebar-menu").append(treeviewLi);
                    }

                }
            }
        );
    }

</script>