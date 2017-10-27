<%--
  Created by IntelliJ IDEA. 1
  User: lenovo
  Date: 2017/5/9
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/role/roleEdit.js"></script>
     <style>
        .form-group{
            margin-bottom:25px;
        }
    </style>
</head>
<body>
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
            </style>
            <div class="row">
                <div class="col-md-6">
                    <form class="form-inline"  role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/role/doEdit">
                        <input type="hidden" id="roleId" value="${roleId}" name="id" />
                        <div class="box-body box-bodyx">
                            <div class="form-group">
                                <label for="roleName">角色名称</label>
                                <div class="form-group">
                                <input type="text" id="roleName" name="roleName" class="form-control"
                                       placeholder="请输入角色名称" data-rule="角色名称:simpleName;required;remote(<%=basePath%>/system/role/checkRoleName?roleId=${roleId});">
                                </div>
                            </div>
                            <div class="form-group">
                                <label>角色描述</label>
                                <div class="form-group">
                                <textarea class="form-control" id="roleDesc" name="roleDesc" rows="3"
                                          placeholder="请输入描述，最多512个字符,一个汉字算2个字符 ..." data-rule="角色描述:length[~512, true]" data-msg="最多输入256个汉字或512个字符"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="roleLevel">角色级别</label>
                                <div class="form-group">
                                <select  id="roleLevel" name="roleLevel" class="form-control">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>状态</label>
                                <div class="form-group">
                                <span class="radio-inline" style="padding: 4px 0 0 16px;">
                                    <input name="status" type="radio" class="minimal" value="1"> 启用
                                </span>
                                    <span  class="radio-inline pdl0">
                                    <input name="status" type="radio" class="minimal"  value="-1"> 禁用
                                </span>
                                </div>
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
