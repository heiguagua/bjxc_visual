<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/user/userAdd.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/user/doAdd">
                        <div class="form-group">
                            <label for="userName">用户名</label>
                            <input type="text" id="userName" name="userName" class="form-control"
                                   placeholder="请输入用户名" autocomplete="false"
                                   data-rule="用户名:required;userName;remote(<%=basePath%>/system/user/insertCheckName)">
                        </div>
                        <div class="form-group">
                            <label for="password">密码</label>
                            <input type="text" style="display: none">
                            <input type="password" id="password" name="password" class="form-control" autocomplete="false"
                                   placeholder="请输入密码" data-rule="密码:required;password;">
                        </div>
                        <div class="form-group">
                            <label for="password2">确认密码</label>
                            <input type="password" id="password2" name="password2" class="form-control"
                                   placeholder="请再次输入密码" data-rule="确认密码:required;password; match(password)">
                        </div>
                        <div class="form-group">
                            <label for="regionName" style='float:left;'>所属区域 *</label>
                            <%--<input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">--%>
                            <input type="text" id="regionName" required="required"
                                   data-parsley-required-message="该项为必填" class="form-control" readonly style="background-color:#fff">
                            <input type="hidden" id="regionCode" name="regionCode">
                            <div class="menu-wrap">
                                <div id="menuRegionContent" class="menuRegionContent" style="display:none;">
                                    <ul id="treeRegionDemo" class="ztree"
                                        style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptName" style='float:left;'>所属组织机构 *</label>
                            <%--<input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">--%>
                            <input type="text" id="deptName" required="required"
                                   data-parsley-required-message="该项为必填" class="form-control" readonly style="background-color:#fff">
                            <input type="hidden" id="deptId" name="deptId">
                            <div class="menu-wrap">
                                <div id="menuContent" class="menuContent" style="display:none;">
                                    <ul id="treeDemo" class="ztree"
                                        style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="roleIds">添加角色</label>
                            <select id="roleIds" name="roleIds" class="form-control"></select>
                        </div>
                        <div class="form-group">
                            <label for="realName">真实姓名</label>
                            <input type="text" id="realName" name="realName" class="form-control"
                                   placeholder="请输入真实姓名" data-rule="真实姓名:required;realName;">
                        </div>
                        <div class="form-group">
                            <label for="userType">用户类型</label>
                            <select id="userType" name="userType" class="form-control select2"
                                    style="width: 100%;"></select>
                        </div>
                        <div class="form-group">
                            <label for="telephoneNumber">电话号码</label>
                            <input type="text" id="telephoneNumber" name="telephoneNumber" class="form-control"
                                   placeholder="请输入电话号码" data-rule="电话:tel;">
                        </div>
                        <div class="form-group">
                            <label for="cellPhoneNumber">手机号码</label>
                            <input type="text" id="cellPhoneNumber" name="cellPhoneNumber" class="form-control"
                                   placeholder="请输入手机号码" data-rule="电话:mobile;">
                        </div>
                        <div class="form-group">
                            <label for="email">邮箱</label>
                            <input type="text" id="email" name="email" class="form-control"
                                   placeholder="请输入邮箱">
                        </div>
                        <div class="form-group">
                            <label>用户描述</label>
                            <textarea class="form-control" name="userDesc" rows="3"
                                      placeholder="请输入描述，最多300个字符 ..."></textarea>
                        </div>

                        <div class="form-group">
                            <label>状态</label>
                            <div class="col-sm-10">
                                <label>
                                    <input name="status" type="radio" id="inlineRadio2" class="minimal" checked
                                           value="1"> 启用
                                </label>
                                <label>
                                    <input name="status" type="radio" id="inlineRadio3" class="minimal" value="-1"> 禁用
                                </label>
                            </div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
                            <%--<button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>--%>
                            <button type="submit" style="display:none;"/>
                        </div>
                    </form>
                </div>
            </div>
        </div><!--/.col (left) -->
    </div>
</section><!-- /.content -->
</body>
</html>
