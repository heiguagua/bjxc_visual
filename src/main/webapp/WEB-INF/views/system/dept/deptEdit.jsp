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
                        <input type="hidden" id="deptId" value="${deptId}" name="id"/>
                        <div class="box-body">

                         <div class="form-group">
                            <label for="regionCode" style='float:left;' class="col-sm-3 control-label">所属行政区域 *</label>
                            <div  class="col-sm-7">
                                <input type="text" class="form-control" id="regionCode"  readonly>

                            </div>
                        </div>
                        <div class="form-group">
                            <label for="fcode" style='float:left;' class="col-sm-3 control-label">父组织机构编码</label>
                            <div  class="col-sm-7">
                                <input type="text" class="form-control" id="fcode"  readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="fname" style='float:left;' class="col-sm-3 control-label">父组织机构名称</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="fname"  readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptName"  style='float:left;' class="col-sm-3 control-label">组织机构名称 *</label>
                            <div class="col-sm-7">
                                <!-- <input type="text" class="form-control" id="sourceSelect" placeholder="组织机构名称" disabled> -->
                                <input type="text" class="form-control" name="deptName" id="deptName" placeholder="组织机构名称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptShortName" style='float:left;'  class="col-sm-3 control-label">组织机构简称</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptShortName" placeholder="组织机构简称">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptAlias" style='float:left;'  class="col-sm-3 control-label">组织机构别名</label>
                            <div name = "deptAlias" class="col-sm-7">
                                <input type="text" class="form-control" id="deptAlias" placeholder="组织机构别名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="listingName" style='float:left;'  class="col-sm-3 control-label">组织机构挂牌名</label>
                            <div name = "listingName" class="col-sm-7">
                                <input type="text" class="form-control" id="listingName" placeholder="组织机构挂牌名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptDesc" style='float:left;'  class="col-sm-3 control-label">组织机构描述</label>
                            <div name = "deptDesc"  class="col-sm-7">
                                <textarea class="form-control" rows="3" id="deptDesc" placeholder="请输入组织机构描述"></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="functionKeyword"  style='float:left;' class="col-sm-3 control-label">职能关键字</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="functionKeyword" placeholder="职能关键字">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptFunction" style='float:left;'  class="col-sm-3 control-label">组织机构职能</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptFunction" placeholder="组织机构职能">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptResponseMan" style='float:left;'  class="col-sm-3 control-label">部门负责人</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptResponseMan" placeholder="部门负责人">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptResponsePhone" style='float:left;'  class="col-sm-3 control-label">部门负责人电话</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptResponsePhone" placeholder="部门负责人电话">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptResponseEmail"  style='float:left;' class="col-sm-3 control-label">部门负责人邮箱</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptResponseEmail" placeholder="部门负责人邮箱">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptContactMan" style='float:left;'  class="col-sm-3 control-label">联系人</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptContactMan" placeholder="联系人">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptContactDept"  style='float:left;' class="col-sm-3 control-label">联系人所属部门</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptContactDept" placeholder="联系人所属部门">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptContactPost" style='float:left;'  class="col-sm-3 control-label">联系人职务</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptContactPost" placeholder="联系人职务">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptContactPhone" style='float:left;'  class="col-sm-3 control-label">联系人手机</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptContactPhone" placeholder="联系人手机">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptContactFixedPhone" style='float:left;'  class="col-sm-3 control-label">联系人座机</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptContactFixedPhone" placeholder="联系人座机">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptContactEmail" style='float:left;'  class="col-sm-3 control-label">联系人邮箱</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptContactEmail" placeholder="联系人邮箱">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="deptAddress" style='float:left;'  class="col-sm-3 control-label">组织机构地址</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="deptAddress" placeholder="组织机构地址">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="orgLongitude" style='float:left;'  class="col-sm-3 control-label">组织位置经度</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="orgLongitude" placeholder="组织位置经度">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="orgLatitude" style='float:left;'  class="col-sm-3 control-label">组织位置纬度</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="orgLatitude" placeholder="组织位置纬度">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="orderNumber" style='float:left;'  class="col-sm-3 control-label">排序</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="orderNumber" placeholder="排序">
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
	                            <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="1">启用
	                          </span>
                              <span class="radio-inline">
	                            <input type="radio" name="inlineRadioOptions" id="inlineRadio0" value="0" >停用
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
