<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=basePath%>/system/user/doEdit">
                        <input id="userId" type="hidden" value="${id}" name="Id" />
                        <div class="box-body">
                            <div class="form-group">
                                <label for="userName">用户名</label>
                                <input type="text" id="userName" name="userName" class="form-control"
                                       placeholder="请输入用户名" data-rule="用户名:required;userName;remote(<%=basePath%>/system/user/editCheckName?userId=${id})">
                            </div>
                            <%--<div class="form-group">
                                <label for="password">密码</label>
                                <input type="password" id="password" name="password" value="********" disabled="disabled" class="form-control"
                                       placeholder="请输入密码" data-rule="密码:required;password;">
                            </div>--%>
                            <div class="form-group">
                                <label for="realName">真实姓名</label>
                                <input type="text" id="realName" name="realName" class="form-control"
                                       placeholder="请输入真实姓名" data-rule="真实姓名:required;realName;">
                            </div>
                            <div class="form-group">
                                <label for="userType">用户类型</label>
                                <select id="userType" name="userType" class="form-control select2" style="width: 100%;"></select>
                            </div>
                            <div class="form-group">
                                <label for="telephoneNumber">电话</label>
                                <input type="text" id="telephoneNumber" name="telephoneNumber" class="form-control"
                                       placeholder="请输入电话号码" data-rule="电话:tel;">
                            </div>
                            <div class="form-group">
                                <label for="cellPhoneNumber">手机</label>
                                <input type="text" id="cellPhoneNumber" name="cellPhoneNumber" class="form-control"
                                       placeholder="请输入手机号码" data-rule="手机:mobile;">
                            </div>
                            <div class="form-group">
                                <label for="email">邮箱</label>
                                <input type="text" id="email" name="email" class="form-control"
                                       placeholder="请输入手机号码">
                            </div>
                            <div class="form-group">
                                <label for="deptId">所属组织机构</label>
                                <select id="deptId" name="deptId" class="form-control select2" style="width: 100%;"></select>
                            </div>
                            <div class="form-group">
                                <label>用户描述</label>
                                <textarea class="form-control" id="userDesc" name="userDesc" rows="3"></textarea>
                            </div>
                            <div class="form-group">
                                <label>添加角色</label>
                                <select id="roleIds" name="roleIds" class="form-control select2" style="width: 100%;" multiple></select>
                            </div>
                            <div class="form-group">
                                <label>状态</label>
                                <div class="col-sm-10">
                                            <label>
                                                <input id="status1" name="status" type="radio" class="minimal" value="1"> 启用
                                            </label>
                                            <label>
                                                <input id="status2" name="status" type="radio" class="minimal" value="-1"> 禁用
                                            </label>
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
