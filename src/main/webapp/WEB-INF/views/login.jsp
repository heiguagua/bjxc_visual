<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<%@include file="/WEB-INF/views/common/head.jsp" %>
	<style type="text/css">
		.has-feedback .form-control{
			height: 50px;
		}
		.form-control-feedback {
			top: 8px !important ;
		}
	</style>
	<link rel="stylesheet" href="<%=basePath%>/css/load.css">
</head>

<body class="hold-transition login-page">
  
  <div class="longin_content">
	<div class="top_cont">
		<section class="top_conttitle">
				<img class="logopng" src="<%=basePath%>/images/userImg/logo.png">
				<p>成都市大数据资源服务网</p>
				<div class="righttext">
					<!-- <p>成都市大数据资源服务网</p> -->
					<!-- <p class="entitle">Chengdu Open Government Data Platform</p> -->
				</div>
				<div class="section_bottom">
						<span class="left_span">
							登录
							<img src="<%=basePath%>/images/userImg/long_sanjiao.png" id="leftsan"/>
						</span>
						<!-- <span class="right_span active">
						注册
							<a href="/htm/applyAccount/userApplyAccount.jsp" target="_blank"></a>
							<img src="/static/new/images/load/long_sanjiao.png" id="rightsan"/>
						</span> -->
				</div>
		</section>
	</div>
	<div class="bottom_cont" id="country">
					<form class="form-horizontal" id="fromid" action="<%=basePath%>/login/doLogin" data-validator-option="{theme:'bootstrap', timely:2, theme:'simple_bottom'}" method="post">
					
						  <c:if test="${error != null}">
							  <div  class="alert alert-danger alert-dismissible">
								  <h4 style="margin-bottom: 0px;"><i class="fa fa-exclamation-triangle"></i> ${error}</h4>
							  </div>
						  </c:if>
					
						<div class="inputdiv reg-box">
							<span class="spanuser">
								<img src="<%=basePath%>/images/userImg/Username.png"/>
							</span
							><input type="text" id="userLoadName" class="account"  name="userName" placeholder="用户名" data-rule="用户名:required;username;"/>
							<input type="hidden" name="return_url" value="${return_url}">
						</div>
						<div class="inputdiv reg-box">
							<span class="spanuser">
								<img src="<%=basePath%>/images/userImg/Password.png"/>
							</span
							><input type="password" class="admin_pwd" id="userPassWord" name="password"  placeholder="密码"  data-rule="密码:required;password;"/>
						</div>
						<div class="inputdiv reg-box">
						
							
					      		<div style="width:409px;display:inline-block" >
						      		 <div class="has-feedback mg">
								         	<input type="text" class="form-control input_test" name="captcha" placeholder="验证码" data-rule="验证码:required;length(5);" size="5">
								         	 <!-- <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span> -->
								         	 <!--data-rule="验证码:required;length(5);"   -->
								        </div>
						      		
						      		
						      			<div class="form-group has-feedback mg_right">
									        <img id="codeimg" alt="如果看不清楚，请单击图片刷新！" class="pointer img" src="<%=basePath%>/login/captcha">
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
    $('#change_code').on('click', function () {
        var codeimg = $('#codeimg');
        codeimg.attr("src", basePathJS + '/login/captcha?'+ Math.random());
    });

</script>
</body>
</html>
