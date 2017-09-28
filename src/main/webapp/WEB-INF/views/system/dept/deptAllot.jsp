<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/dept/deptEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/dept/doEdit">
                        <input type="hidden" id="deptId" value="${id}" name="id"/>
                        <input type="hidden" id="deptLevel" value="${deptLevel}" name="deptLevel"/>
                        <input type="hidden" id="treeIndex" value="${treeIndex}" name="treeIndex"/>
                        <input type="hidden" id="treeCode" value="${treeCode}" name="treeCode"/>
                        <div class="box-body">

                            <div class="form-group">
                                <label for="regionCode" style='float:left;' class="col-sm-3 control-label">所属行政区域</label>
                                <div  class="col-sm-7">
                                    <input type="text" class="form-control"  id="regionCode"  readonly>

                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fid" style='float:left;' class="col-sm-3 control-label">父组织机构编码</label>
                                <div  class="col-sm-7">
                                    <input type="text" class="form-control"  id="fid"  readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="fname" style='float:left;' class="col-sm-3 control-label">父组织机构名称</label>
                                <div class="col-sm-3">
                                    <input type="text" class="form-control"  id="fname"  readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptName"  style='float:left;' class="col-sm-3 control-label">组织机构名称</label>
                                <div class="col-sm-7">
                                    <!-- <input type="text" class="form-control" id="sourceSelect" placeholder="组织机构名称" disabled> -->
                                    <input type="text" class="form-control" name="deptName" id="deptName" placeholder="组织机构名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptShortName" style='float:left;'  class="col-sm-3 control-label">组织机构简称</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptShortName"  id="deptShortName" placeholder="组织机构简称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptAlias" style='float:left;'  class="col-sm-3 control-label">组织机构别名</label>
                                <div name = "deptAlias" class="col-sm-7">
                                    <input type="text" class="form-control"  name="deptAlias"  id="deptAlias" placeholder="组织机构别名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptListingName" style='float:left;'  class="col-sm-3 control-label">组织机构挂牌名</label>
                                <div name = "deptListingName" class="col-sm-7">
                                    <input type="text" class="form-control" name="deptListingName" id="deptListingName" placeholder="组织机构挂牌名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptDesc" style='float:left;'  class="col-sm-3 control-label">组织机构描述</label>
                                <div name = "deptDesc"  class="col-sm-7">
                                    <textarea class="form-control" rows="3" name="deptDesc" id="deptDesc" placeholder="请输入组织机构描述"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="functionKeyword"  style='float:left;' class="col-sm-3 control-label">职能关键字</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="functionKeyword" id="functionKeyword" placeholder="职能关键字">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptFunction" style='float:left;'  class="col-sm-3 control-label">组织机构职能</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptFunction" id="deptFunction" placeholder="组织机构职能">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponseMan" style='float:left;'  class="col-sm-3 control-label">部门负责人</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptResponseMan" id="deptResponseMan" placeholder="部门负责人">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponsePhone" style='float:left;'  class="col-sm-3 control-label">部门负责人电话</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptResponsePhone" id="deptResponsePhone" placeholder="部门负责人电话">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponseEmail"  style='float:left;' class="col-sm-3 control-label">部门负责人邮箱</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptResponseEmail" id="deptResponseEmail" placeholder="部门负责人邮箱">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactMan" style='float:left;'  class="col-sm-3 control-label">联系人</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptContactMan" id="deptContactMan" placeholder="联系人">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactDept"  style='float:left;' class="col-sm-3 control-label">联系人所属部门</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptContactDept" id="deptContactDept" placeholder="联系人所属部门">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactPost" style='float:left;'  class="col-sm-3 control-label">联系人职务</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptContactPost" id="deptContactPost" placeholder="联系人职务">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactPhone" style='float:left;'  class="col-sm-3 control-label">联系人手机</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptContactPhone" id="deptContactPhone" placeholder="联系人手机">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactFixedPhone" style='float:left;'  class="col-sm-3 control-label">联系人座机</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptContactFixedPhone" id="deptContactFixedPhone" placeholder="联系人座机">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactEmail" style='float:left;'  class="col-sm-3 control-label">联系人邮箱</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptContactEmail" id="deptContactEmail" placeholder="联系人邮箱">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptAddress" style='float:left;'  class="col-sm-3 control-label">组织机构地址</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="deptAddress" id="deptAddress" placeholder="组织机构地址">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgLongitude" style='float:left;'  class="col-sm-3 control-label">组织位置经度</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="orgLongitude" id="orgLongitude" placeholder="组织位置经度">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgLatitude" style='float:left;'  class="col-sm-3 control-label">组织位置纬度</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="orgLatitude" id="orgLatitude" placeholder="组织位置纬度">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="orderNumber" style='float:left;'  class="col-sm-3 control-label">排序</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="orderNumber" id="orderNumber" placeholder="排序">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="validateFrom" style='float:left;'  class="col-sm-3 control-label">组织启用时间</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="validateFrom"  readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="validateTo" style='float:left;'  class="col-sm-3 control-label">组织停用时间</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="validateTo"  readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="status"  style='float:left;' class="col-sm-3 control-label">状态</label>
                                <div class="col-sm-7" >
                              <span class="radio-inline">
	                            <input type="radio" name="status" id="inlineRadio1" value="1">启用
	                          </span>
                                    <span class="radio-inline">
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
