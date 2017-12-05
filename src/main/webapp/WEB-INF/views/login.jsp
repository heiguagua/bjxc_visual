<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<%@include file="/WEB-INF/views/common/head.jsp" %>
	<script src="<%=context_path%>/js/login.js"></script>
	<style type="text/css">
		.has-feedback .form-control{
			height: 50px;
		}
		.form-control-feedback {
			top: 8px !important ;
		}
		 #change_code{
            color: #333;
        }
        #change_code:hover{
            color: #72afd2 !important;
        }
	</style>
	<link rel="stylesheet" href="<%=context_path%>/css/load.css">
</head>

<body class="hold-transition login-page">
  
  <div class="longin_content">
	<div class="top_cont">
		<section class="top_conttitle" style="text-align: center">
				<img class="logopng" src="<%=context_path %>/images/userImg/logo.png">
				<%--<p>${systemShowName}</p>--%>
                <p><%=request.getSession().getAttribute("systemShowName")%></p>
            	<div class="righttext">
            	</div>
				<div class="section_bottom">
						<span class="left_span">
							登录
							<img src="<%=context_path%>/images/userImg/long_sanjiao.png" id="leftsan"/>
						</span>
						<!-- <span class="right_span active">
						注册
							<a href="<%=context_path%>/htm/applyAccount/userApplyAccount.jsp" target="_blank"></a>
							<img src="<%=context_path%>/static/new/images/load/long_sanjiao.png" id="rightsan"/>
						</span> -->
				</div>
		</section>
	</div>
	<div class="bottom_cont" id="country">
					<form class="form-horizontal" id="fromid" action="<%=context_path%>/login/doLogin" data-validator-option="{theme:'bootstrap', timely:2, theme:'simple_bottom'}" method="post">
					
						  <c:if test="${error != null}">
							  <div  class="alert alert-danger alert-dismissible">
								  <h4 style="margin-bottom: 0px;"><i class="fa fa-exclamation-triangle"></i> ${error}</h4>
							  </div>
						  </c:if>
					
						<div class="inputdiv reg-box"><span class="spanuser">
								<img src="<%=context_path%>/images/userImg/Username.png"/>
							</span><input type="text" id="userLoadName" class="account"  name="userName" placeholder="用户名" data-rule="用户名:required;username;" value="${userName}"/>
							<input type="hidden" name="return_url" value="${return_url}">
						</div>
						<div class="inputdiv reg-box">
							<span class="spanuser">
								<img src="<%=context_path%>/images/userImg/Password.png"/>
							</span
							><input type="password" class="admin_pwd" id="password"  placeholder="密码"  data-rule="密码:required;password;"/>
                			<input type="hidden" name="password">
                			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						</div>
					 <div class="inputdiv reg-box">
						
							
					      		<div style="width:409px;display:inline-block" >
						      		 <div class="has-feedback mg">
								         	<input type="text" class="form-control input_test" name="captcha" placeholder="验证码" data-rule="验证码:required;length(5);" size="5">
								         	 <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
								        </div>
						      		
						      		
						      			<div class="form-group has-feedback mg_right">
									        <img id="codeimg" alt="如果看不清楚，请单击图片刷新！" class="pointer img" src="<%=context_path%>/login/captcha">
									        <a id="change_code" href="javascript:void(0);">点击刷新</a>
									      </div>     
								</div> 
						</div> 
						
						<div class="inputdiv">
								<button class="login_subtn" id="loaded" type="submit">登&emsp;录</button>
						</div>
					</form>
	</div>
</div>
  

<script type="text/javascript">
   /*  $('#change_code').on('click', function () {
        var codeimg = $('#codeimg');
        codeimg.attr("src", basePathJS + '/login/captcha?'+ Math.random());
    }); */

</script>
</body>
</html>
