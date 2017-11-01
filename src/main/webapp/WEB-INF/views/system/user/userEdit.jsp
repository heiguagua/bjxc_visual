<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1 -->
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/user/userEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <style>
                .box-body .pdl0{
                    padding-left: 0;
                }
                .box-bodyx label{
                    width: 120px;
                    float: left;
                }
                .box-bodyx .form-group>.form-group{
                    width: 70%;
                    float: left;}
                .form-group{
			            margin-bottom:25px;
			      }
            </style>
            <div class="row">
                <div class="col-md-6">
                    <form class="form-inline"  role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=basePath%>/system/user/doEdit">
                        <input id="userId" type="hidden" value="${id}" name="Id" />
                        <div class="box-body box-bodyx">
                            <div class="form-group">
                                <label for="userName">用户名</label>
                                <div class="form-group">
                                <input type="text" id="userName" name="userName" class="form-control" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>所属行政区域</label>
                                <div class="form-group">
                                <input type="text" class="form-control"  id="regionCode"  readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>所属组织机构</label>
                                <div class="form-group">
                                <input type="text" class="form-control"  id="deptName"  readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>用户接口验证码</label>
                                <div class="form-group">
                                    <input type="text" class="form-control"  id="token"  readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label></label>
                                <div class="form-group">
                                    <button type="button" class="btn btn_blue" id="createToken" disabled>
                                        重新生成用户接口验证码
                                    </button>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>角色</label>
                                <div class="form-group">
                                <select id="roleIds" name="roleIds" class="form-control select2" style="width: 100%;"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="realName">真实姓名</label>
                                <div class="form-group">
                                <input type="text" id="realName" name="realName" class="form-control"
                                       placeholder="请输入真实姓名" data-rule="真实姓名:required;realName;">
                                </div>
                            </div>
<!--                             <div class="form-group"> -->
<!--                                 <label for="userType">用户类型</label> -->
<!--                                 <div class="form-group"> -->
<!--                                 <select id="userType" name="userType" class="form-control select2" style="width: 100%;"></select> -->
<!--                                 </div> -->
<!--                             </div> -->
                            <div class="form-group">
                                <label for="telephoneNumber">固定电话</label>
                                <div class="form-group">
                                <input type="text" id="telephoneNumber" name="telephoneNumber" class="form-control"
                                       placeholder="请输入电话号码" data-rule="电话:tel;">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="cellPhoneNumber">手机号码</label>
                                <div class="form-group">
                                <input type="text" id="cellPhoneNumber" name="cellPhoneNumber" class="form-control"
                                       placeholder="请输入手机号码" data-rule="手机:mobile;">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email">邮箱</label>
                                <div class="form-group">
                                <input type="text" id="email" name="email" class="form-control"
                                       placeholder="请输入邮箱号码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>用户描述</label>
                                <div class="form-group">
                                <textarea class="form-control" id="userDesc" name="userDesc" rows="3"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>状态</label>
                                <div class="form-group">
                                    <span class="radio-inline" style="padding: 4px 0 0 16px;">
                                        <input id="status1" name="status" type="radio" class="minimal" value="1"> 启用
                                    </span>
                                    <span class="radio-inline pdl0">
                                        <input id="status0" name="status" type="radio" class="minimal" value="0"> 禁用
                                    </span>
                                </div>
                            </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
                            <%--<button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>--%>
                            <input type="submit" style="display:none;"/>
                        </div>
                    </form>
                </div>
            </div>
        </div><!--/.col (left) -->
    </div>
</section><!-- /.content -->

</body>
</html>
