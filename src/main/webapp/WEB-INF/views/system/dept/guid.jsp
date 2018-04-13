<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=context_path%>/js/system/dept/guid.js"></script>
    <style>

        .box-body {
            padding: 40px 30px;
        }
    </style>
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
            </style>
            <div class="row">
                <div class="col-md-6">
                    <form  class="form-horizontal" role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=context_path%>/sysGuidDept/doGuid">
                        <input type="hidden" id="id"  name="id"/>
                        <input type="hidden" id="curDeptId" value="${id}" name="curDeptId"/>

                        <div class="box-body  box-bodyx">
							<div class="row">
                                    <div class="col-sm-12 col-xs-12">
                                        <div class="form-group">
                                            <label for="deptName" class="control-label col-sm-5 col-xs-5">指导部门 </label>
                                            <div class="col-sm-7 col-xs-7">
                                                <input type="text" id="deptName" data-rule="所属组织机构;deptId;" class="form-control" readonly style="background-color:#fff">
                                                <input type="hidden" id="deptId" name="guidDeptId">
                                                <div class="menu-wrap">
                                                    <div id="menuContent" class="menuContent" style="display:none;">
                                                        <ul id="treeDemo" class="ztree"
                                                            style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
							</div>
                        </div><!-- /.box-body -->
                        <div class="box-footer">
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
