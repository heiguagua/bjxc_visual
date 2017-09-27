<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/9
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/role/roleAdd.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form id="form" role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/role/doAdd">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="roleName">角色名称 <i style="color: red">*必填</i> </label>
                                <input type="text" id="roleName" name="roleName" class="form-control" required
                                       placeholder="请输入角色名称"
                                       data-rule="角色名称:required;simpleName;remote(<%=basePath%>/system/role/checkRoleName);">
                            </div>
                            <div class="form-group">
                                <label for="roleLevel">角色级别 <i style="color: red">*必选</i></label>
                                <select  id="roleLevel" name="roleLevel" class="form-control">
                                    <option value="">请选择角色级别</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>角色描述</label>
                                <textarea class="form-control" name="roleDesc" rows="3"
                                          placeholder="请输入描述，最多300个字符 ..." data-rule="角色描述:length(~300);"></textarea>
                            </div>

                            <div class="form-group">
                                <label>状态</label>
                                <div class="col-sm-10">
                                <span>
                                    <input name="status" type="radio" class="minimal" checked value="1"> 启用
                                </span>
                                    <span>
                                    <input name="status" type="radio" class="minimal" value="-1"> 禁用
                                </span>
                                </div>
                            </div>
                        </div><!-- /.box-body -->

                        <div class="box-footer">
                         <%--  <button type="submit" class="btn btn-success"><i class="fa fa-save"></i>  提 交</button>--%>
                            <button type="submit" style="display:none; " class="btn2" onclick="checkUser();"/>
                        </div>
                    </form>
                </div>
            </div>
        </div><!--/.col (left) -->
    </div>
</section><!-- /.content -->

</body>
<script  type="text/javascript">
   /* function checkUser(){
        alert("hahahaha")
        var val = $("#roleLevel").val();  //获取选中的项

        if(!val ){
            alert("请选择角色级别");
            return false;
        }
        document.getElementById("form").submit();
    }*/

     $(document).ready(function(){
             /*var val = $("#roleLevel").val();  //获取选中的项
             if (val === "") {
                 alert("请选择角色级别");
                 return false;
             }else {
                 return true;
             }*/
     });

</script>
</html>

