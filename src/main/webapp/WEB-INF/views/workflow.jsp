<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .layui-layer-dialog {
            top: 20% !important;
        }

        .step-content {
            display: block !important;
            margin-top: 33% !important;
            width: 130px !important;
        }

        .step-content p {
            color: #464C5B !important;
        }

        .sw-theme-circles > ul.step-anchor > li.active > a > small {
            color: #464C5B !important;
            font-size: 20px !important;
            width: 130px !important;
            text-align: left;
        }
/*         #ulsdatas{
        	display: -webkit-flex;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
        }
        .sw-theme-circles > ul.step-anchor > li.active > a{
             margin: 0 auto; 
        }
         .step-content{
        	    width: 100% !important;
        } 
        .step-content p{
            font-size: smaller;
        }
        .sw-theme-circles > ul.step-anchor > li{
            width: 17%;
        }
        div.sw-container{
        	text-align:center;
        } */
        .box1{
            height: 370px;
        	 background:url("../images/userImg/Group27.png") no-repeat center 20px; 
        	background-size:contain;
        }
        .box2{
        	height: 370px;
        	background:url("../images/userImg/Group27min.png") no-repeat center 20px; 
        	background-size:contain;
        }
    </style>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <%--  <link rel="stylesheet"
          href="<%=context_path%>/plugins/smartWizard/css/smart_wizard_theme_circles.css"> --%>
   <script>
      /*   $('#smartwizard').smartWizard({
            selected: 0,
            keyNavigation: false,
            theme: 'circles',
            transitionEffect: 'fade',
            showStepURLhash: false,
            toolbarSettings: {
                toolbarPosition: 'middle'
            }
        }); */
        function cookiesave(n, v, mins, dn, path){  
            if(n)  
            {  
                  
                if(!mins) mins = 365 * 24 * 60;  
               //if(!mins) mins = 1;  
                if(!path) path = "/";  
                var date = new Date();  
                  
                date.setTime(date.getTime() + (mins * 60 * 1000));  
                  
                var expires = "; expires=" + date.toGMTString();  
                  
                if(dn) dn = "domain=" + dn + "; ";  
                document.cookie = n + "=" + v + expires + "; " + dn + "path=" + path;  
            }  
        }  
        function cookieget(n){  
            var name = n + "=";  
            var ca = document.cookie.split(';');  
            for(var i=0;i<ca.length;i++) {  
                var c = ca[i];  
                while (c.charAt(0)==' ') c = c.substring(1,c.length);  
                if (c.indexOf(name) == 0) return c.substring(name.length,c.length);  
            }  
            return "";  
        }  
        function closeclick(){  
            document.getElementById('note1').style.display='none';  
            cookiesave('closeclick','closeclick','','','');  
        }
        $(document).ready(function(){ 
       	    var screenWith = window.screen.width;
        	   if(screenWith < 1440){
        		   if($("div.boxContain").hasClass("box1")){
        			   $("div.boxContain").removeClass("box1").addClass("box2")
        		   }else{
        			   $("div.boxContain").addClass("box2")
        		   }
        	   }  
        	   
        $('#checkboxID').change(function() { 
        	
	        if($("input[type='checkbox']").prop('checked')) {
	        	
	        	cookiesave('close','close','','','');  
	        }else{
	        	
	        	cookiesave('close','continue','','','');
	        }     
        });
        if(cookieget('close')=='close'){
        	$("input[type=checkbox][id='checkboxID']").prop('checked', true);
        }else{
        	$("input[type=checkbox][id='checkboxID']").prop('checked', false);
        }
        
        });
    </script> 
</head>
<body>
<section class="content">
    <div class="continer">
        <div class="row-fluid">
            <div class="col-md-12">

                <div class="box-body" style="font-size: medium;">
                <div class="boxContain box1">
                	
                </div>

                    <div class="sw-container tab-content">

                            <div class="row pull-left">
                             <a style="color: #3c8dbc;" href="<%=context_path%>/welCommon/download">查看详细使用说明，请下载  “用户手册 ”  >></a>
                            
                            </div>
                            <div class="row pull-right">
	                            
		                            <ul ><li ><input id="checkboxID" type="checkbox" ckecked="false">  &nbsp;&nbsp;不再提示</li></ul>
		                           
	                           
							 </div>
                        </div>


                </div>
            </div>
        </div>
    </div>
    <!--/.col (left) -->
    </div>
</section>
</body>
</html>