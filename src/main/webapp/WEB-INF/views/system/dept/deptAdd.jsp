<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/dept/deptAdd.js"></script>
    <style type="text/css">
        .menu-wrap {
            position: relative;

        }

        .menu-wrap .menuContent {
            top: 0 !important;
            display: block;
            position: absolute;
            left: 0 !important;
            z-index: 1999;
            background: #FFF;
            width: 100%;
        }
    </style>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/dept/doAdd">
                        <div class="box-body">
                            <div class="form-group">
                                <label for="regionName" style='float:left;' class="col-sm-2 control-label">所属行政区域
                                    *</label>
                                <div class="col-sm-10">
                                    <%--<input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">--%>
                                    <input type="text" id="regionName" required="required"
                                           data-parsley-required-message="该项为必填" class="form-control">
                                    <input type="hidden" id="regionCode" name="regionCode">
                                    <div class="menu-wrap">
                                        <div id="menuContent" class="menuContent" style="display:none;">
                                            <ul id="treeDemo" class="ztree"
                                                style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%-- <div class="form-group">
                                 <label for="fcode" style='float:left;' class="col-sm-3 control-label">父组织机构编码</label>
                                 <div id="fcode" name="fcode" class="col-sm-3">
                                     <select class="form-control">
                                         <option value="">--请选择--</option>
                                         <option value="">000001A</option>
                                         <option value="">000002B</option>
                                         <option value="">000003C</option>
                                     </select>
                                 </div>
                             </div>--%>
                            <div class="form-group">
                                <label for="fid" style='float:left;' class="col-sm-3 control-label">父组织机构名称</label>
                                <div class="col-sm-3">
                                    <select id="fid" name="fid" class="form-control">
                                    </select>
                                </div>
                                <input type="hidden" id="fname" name="fname">
                            </div>
                            <div class="form-group">
                                <label for="deptCode" style='float:left;' class="col-sm-3 control-label">组织机构编码</label>
                                <div class="col-sm-7">
                                    <!-- <input type="text" class="form-control" id="sourceSelect" placeholder="组织机构名称" disabled> -->
                                    <input type="text" class="form-control" id="deptCode" name="deptCode"
                                           placeholder="组织机构编码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptName" style='float:left;' class="col-sm-3 control-label">组织机构名称
                                    *</label>
                                <div class="col-sm-7">
                                    <!-- <input type="text" class="form-control" id="sourceSelect" placeholder="组织机构名称" disabled> -->
                                    <input type="text" class="form-control" id="deptName" name="deptName"
                                           placeholder="组织机构名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptShortName" style='float:left;'
                                       class="col-sm-3 control-label">组织机构简称</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptShortName" name="deptShortName"
                                           placeholder="组织机构简称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptAlias" style='float:left;' class="col-sm-3 control-label">组织机构别名</label>
                                <div name="deptAlias" class="col-sm-7">
                                    <input type="text" class="form-control" id="deptAlias" name="deptAlias"
                                           placeholder="组织机构别名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptListingName" style='float:left;'
                                       class="col-sm-3 control-label">组织机构挂牌名</label>
                                <div name="deptListingName" class="col-sm-7">
                                    <input type="text" class="form-control" id="deptListingName" name="deptListingName"
                                           placeholder="组织机构挂牌名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptDesc" style='float:left;' class="col-sm-3 control-label">组织机构描述</label>
                                <div name="deptDesc" class="col-sm-7">
                                    <textarea class="form-control" rows="3" id="deptDesc" name="deptDesc"
                                              placeholder="请输入组织机构描述"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="functionKeyword" style='float:left;'
                                       class="col-sm-3 control-label">职能关键字</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="functionKeyword" name="functionKeyword"
                                           placeholder="职能关键字">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptFunction" style='float:left;'
                                       class="col-sm-3 control-label">组织机构职能</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptFunction" name="deptFunction"
                                           placeholder="组织机构职能">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponseMan" style='float:left;'
                                       class="col-sm-3 control-label">部门负责人</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptResponseMan" name="deptResponseMan"
                                           placeholder="部门负责人">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponsePhone" style='float:left;' class="col-sm-3 control-label">部门负责人电话</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptResponsePhone"
                                           name="deptResponsePhone" placeholder="部门负责人电话">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponseEmail" style='float:left;' class="col-sm-3 control-label">部门负责人邮箱</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptResponseEmail"
                                           name="deptResponseEmail" placeholder="部门负责人邮箱">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactMan" style='float:left;'
                                       class="col-sm-3 control-label">联系人</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptContactMan" name="deptContactMan"
                                           placeholder="联系人">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactDept" style='float:left;'
                                       class="col-sm-3 control-label">联系人所属部门</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptContactDept" name="deptContactDept"
                                           placeholder="联系人所属部门">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactPost" style='float:left;'
                                       class="col-sm-3 control-label">联系人职务</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptContactPost" name="deptContactPost"
                                           placeholder="联系人职务">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactPhone" style='float:left;'
                                       class="col-sm-3 control-label">联系人手机</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptContactPhone"
                                           name="deptContactPhone" placeholder="联系人手机">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactFixedPhone" style='float:left;' class="col-sm-3 control-label">联系人座机</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptContactFixedPhone"
                                           name="deptContactFixedPhone" placeholder="联系人座机">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactEmail" style='float:left;'
                                       class="col-sm-3 control-label">联系人邮箱</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptContactEmail"
                                           name="deptContactEmail" placeholder="联系人邮箱">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptAddress" style='float:left;'
                                       class="col-sm-3 control-label">组织机构地址</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="deptAddress" name="deptAddress"
                                           placeholder="组织机构地址">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgLongitude" style='float:left;'
                                       class="col-sm-3 control-label">组织位置经度</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="orgLongitude" name="orgLongitude"
                                           placeholder="组织位置经度">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgLatitude" style='float:left;'
                                       class="col-sm-3 control-label">组织位置纬度</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="orgLatitude" name="orgLatitude"
                                           placeholder="组织位置纬度">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="orderNumber" style='float:left;' class="col-sm-3 control-label">排序</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="orderNumber" name="orderNumber"
                                           placeholder="排序">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="status" style='float:left;' class="col-sm-3 control-label">状态</label>
                                <div class="col-sm-7">
                    <span class="radio-inline">
	                      <input type="radio" name="status" id="inlineRadio2" value="1" checked>启用
	                    </span>
                                    <span class="radio-inline">
	                      <input type="radio" name="status" id="inlineRadio3" value="0" >停用
	                    </span>
                                </div>
                            </div>


                            <%-- <div class="form-group">
                                 <label for="pid">上级组织机构</label>
                                 <select id="pid" name="pid" class="form-control select2" style="width: 100%;"></select>
                             </div>
                             <div class="form-group">
                                 <label for="deptName">组织机构名称</label>
                                 <input type="text" id="deptName" name="deptName" class="form-control"
                                        placeholder="请输入组织机构名称" data-rule="组织机构名称:required;simpleName;remote(<%=basePath%>/system/dept/checkDeptName);">
                             </div>
                             <div class="form-group">
                                 <label for="deptName">组织机构简称</label>
                                 <input type="text" id="deptAlias" name="deptAlias" class="form-control"
                                        placeholder="请输入组织机构简称" data-rule="组织机构简称:simpleName;">
                             </div>
                             <div class="form-group">
                                 <label for="deptName">组织机构编码</label>
                                 <input type="text" id="deptCode" name="deptCode" class="form-control"
                                        placeholder="请输入组织机构编码" data-rule="组织机构编码:required;simpleCode;">
                             </div>
                             <div class="form-group">
                                 <label for="deptName">联系人</label>
                                 <input type="text" id="deptContactMan" name="deptContactMan" class="form-control"
                                        placeholder="请输入联系人" data-rule="联系人:simpleName;">
                             </div>
                             <div class="form-group">
                                 <label for="deptName">联系电话</label>
                                 <input type="text" id="deptContactNum" name="deptContactNum" class="form-control"
                                        placeholder="请输入联系电话" data-rule="mobile||tel">
                             </div>
                             <div class="form-group">
                                 <label for="deptName">地址</label>
                                 <input type="text" id="deptAddress" name="deptAddress" class="form-control"
                                        placeholder="请输入地址" data-rule="地址:address;">
                             </div>
                             <div class="form-group">
                                 <label>组织机构描述</label>
                                 <textarea class="form-control" name="deptDesc" rows="3"
                                           placeholder="请输入描述，最多300个字符 ..." data-rule="length(~300);"></textarea>
                             </div>--%>
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
