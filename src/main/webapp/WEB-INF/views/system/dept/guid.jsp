<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=context_path%>/js/system/dept/guid.js"></script>
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
								<div class="form-group">
									<ul id="treeDemo" class="ztree" style="margin-top:0;"></ul>
									<input type="hidden" id="deptIds" name="deptIds">
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
