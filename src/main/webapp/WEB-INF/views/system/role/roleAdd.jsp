
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
                    <form class="form-inline"  id="form" role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/role/doAdd">
                        <div class="box-body box-bodyx">
                            <div class="form-group">
                                <label for="roleName">角色名称 <i style="color: red">*必填</i> </label>
                                <div class="form-group">
                                <input type="text" id="roleName" name="roleName" class="form-control" required
                                       placeholder="请输入角色名称"
                                       data-rule="角色名称:required;simpleName;remote(<%=basePath%>/system/role/checkRoleName);">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="roleLevel">角色级别 <i style="color: red">*必选</i></label>
                                <div class="form-group">
                                <select  id="roleLevel" name="roleLevel" class="form-control">
                                    <option value="">请选择角色级别</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>角色描述</label>
                                <div class="form-group">
                                <textarea class="form-control" name="roleDesc" rows="3"
                                          placeholder="请输入描述，最多300个字符 ..." data-rule="角色描述:length(~300);"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label>状态</label>
                                <div class="form-group">
                                <span class="radio-inline" style="padding: 4px 0 0 16px;">
                                    <input name="status" type="radio" class="minimal" checked value="1"> 启用
                                </span>
                                    <span  class="radio-inline pdl0">
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

