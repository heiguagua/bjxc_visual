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
</head>

<body class="hold-transition login-page">
  <div class="login-box">
	  <div class="login-logo">
	    <b>数据采集系统</b>
	  </div>
	  <!-- /.login-logo -->
	  <form action="<%=basePath%>/login/doLogin" data-validator-option="{theme:'bootstrap', timely:2, theme:'simple_bottom'}" method="post">
	  <div class="login-box-body">
	      <p class="login-box-msg">请输入用户名和密码登录</p>
		  <c:if test="${error != null}">
			  <div  class="alert alert-danger alert-dismissible">
				  <h4 style="margin-bottom: 0px;"><i class="fa fa-exclamation-triangle"></i> ${error}</h4>
			  </div>
		  </c:if>

	      <div class="form-group has-feedback mg">
	        <input type="hidden" name="return_url" value="${return_url}">
	        <input type="text" class="form-control"  name="userName" placeholder="用户名" data-rule="用户名:required;username;">
	        <span class="glyphicon glyphicon-user form-control-feedback"></span>
	      </div>
	      <div class="form-group has-feedback mg">
	        <input type="password" class="form-control" name="password"  placeholder="密码"  data-rule="密码:required;password;">
	        <span class="glyphicon glyphicon-lock form-control-feedback" ></span>
	      </div>
	      <div class="form-group has-feedback">
	      	<div class="row">
	      		<div class="col-lg-4">
	      			<div class="form-group has-feedback mg">
			         	<input type="text" class="form-control" name="captcha" placeholder="验证码" data-rule="验证码:required;length(5);" size="5">
			         	<span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
			        </div>
	      		</div>
	      		<div class="col-lg-8">
	      			<div class="form-group has-feedback">
				        <img id="codeimg" alt="如果看不清楚，请单击图片刷新！" class="pointer img" src="<%=basePath%>/login/captcha">
				        <a id="change_code" href="javascript:void(0);">点击刷新</a>
				      </div>
	      		</div>
	      	</div>
	      </div>
	      
	      <div class="row">
	        <div class="col-xs-8">
	          <div class="checkbox icheck">
	          </div>
	        </div>
	        <!-- /.col -->
	        <div class="col-xs-4">
	          <button type="submit" class="btn btn-primary btn-block btn-flat"><i class="fa fa-sign-in"></i> 登录</button>
	        </div>
	        <!-- /.col -->
	      </div>
	    <!-- /.social-auth-links -->
	  </div>
	  </form>
  <!-- /.login-box-body -->
</div>

<script type="text/javascript">
    $('#change_code').on('click', function () {
        var codeimg = $('#codeimg');
        codeimg.attr("src", basePathJS + '/login/captcha?'+ Math.random());
    });

</script>
</body>
</html>
