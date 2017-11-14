<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/dept/deptAllot.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div class="row">
        <div class="col-md-12">
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
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form class="form-inline"  role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/dept/doAdd">
                        <input type="hidden" id="deptId" value="${id}" name="id"/>
                        <input type="hidden" id="fid" value="${id}" name="fid"/>
                        <input type="hidden" id="regionCode" name="regionCode"/>

                        <div class="box-body box-bodyx">

                            <%--<div class="form-group">--%>
                                <%--<label for="regionName" >所属行政区域</label>--%>
                                <%--<div  class="form-group">--%>
                                    <%--<input type="text" class="form-control"  id="regionName"  name="regionName" readonly>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <div class="form-group">
                                <label for="fname" >父组织机构名称</label>
                                <div class="form-group">
                                    <input type="text" class="form-control"  id="fname" name="fname" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptCode"  >组织机构编码<i style="color: red">*</i></label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptCode" name="deptCode" placeholder="请输入组织机构编码" data-rule="组织机构编码:simpleCode;required;length[~64, true]">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptName"  >组织机构名称<i style="color: red">*</i></label>
                                <div class="form-group">
                                    <!-- <input type="text" class="form-control" id="sourceSelect" placeholder="组织机构名称" disabled> -->
                                    <input type="text" class="form-control" name="deptName" id="deptName" placeholder="请输入组织机构名称" data-rule="组织机构名称:required;deptName;remote(<%=basePath%>/system/dept/checkDeptName, fid:#fid)">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptShortName"   >组织机构简称<i style="color: red">*</i></label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptShortName"  id="deptShortName" placeholder="请输入组织机构简称" data-rule="组织机构简称:simpleName;length[~64, true];required;">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptAlias"   >组织机构别名</label>
                                <div name = "deptAlias" class="form-group">
                                    <input type="text" class="form-control"  name="deptAlias"  id="deptAlias" placeholder="请输入组织机构别名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptListingName"   >组织机构挂牌名</label>
                                <div name = "deptListingName" class="form-group">
                                    <input type="text" class="form-control" name="deptListingName" id="deptListingName" placeholder="请输入组织机构挂牌名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptDesc"   >组织机构描述</label>
                                <div name = "deptDesc"  class="form-group">
                                    <textarea class="form-control" rows="3" name="deptDesc" id="deptDesc" placeholder="请输入组织机构描述"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="functionKeyword"  >职能关键字</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="functionKeyword" id="functionKeyword" placeholder="请输入职能关键字">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptFunction"   >组织机构职能</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptFunction" id="deptFunction" placeholder="请输入组织机构职能">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponseMan"   >部门负责人</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptResponseMan" id="deptResponseMan" placeholder="请输入部门负责人">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponsePhone"   >部门负责人电话</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptResponsePhone" id="deptResponsePhone" placeholder="部门负责人电话">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponseEmail"  >部门负责人邮箱</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptResponseEmail" id="deptResponseEmail" placeholder="请输入部门负责人邮箱">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactMan"   >联系人</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptContactMan" id="deptContactMan" placeholder="请输入联系人">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactDept"  >联系人所属部门</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptContactDept" id="deptContactDept" placeholder="请输入联系人所属部门">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactPost"   >联系人职务</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptContactPost" id="deptContactPost" placeholder="请输入联系人职务">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactPhone"   >联系人手机</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptContactPhone" id="deptContactPhone" placeholder="请输入联系人手机">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactFixedPhone"   >联系人座机</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptContactFixedPhone" id="deptContactFixedPhone" placeholder="请输入联系人座机">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactEmail"   >联系人邮箱</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptContactEmail" id="deptContactEmail" placeholder="请输入联系人邮箱">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptAddress"   >组织机构地址</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="deptAddress" id="deptAddress" placeholder="请输入组织机构地址">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgLongitude"   >组织位置经度</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="orgLongitude" id="orgLongitude" placeholder="请输入组织位置经度">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgLatitude"   >组织位置纬度</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="orgLatitude" id="orgLatitude" placeholder="请输入组织位置纬度">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="orderNumber"   >排序</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="orderNumber" id="orderNumber" placeholder="请输入排序">
                                </div>
                            </div>
                            <div class="form-group">
                                <label  >状态</label>
                                <div class="form-group" >
                              <span class="radio-inline"  style="padding: 4px 0 0 16px;">
	                            <input type="radio" name="status" id="inlineRadio1" value="1" checked>启用
	                          </span>
                                    <span class="radio-inline pd10">
	                            <input type="radio" name="status" id="inlineRadio0" value="0" >停用
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
