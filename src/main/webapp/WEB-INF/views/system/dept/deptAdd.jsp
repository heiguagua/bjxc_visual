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
            <!-- <style>
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
            </style> -->
            <div class="row">
                <div class="col-md-6">
                    <form  class="form-inline" role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/dept/doAdd">
                        <div class="box-body box-bodyx">
                        
                
                        
                        
                        <!--11111111111111111111  -->
                            <div class="form-group">
                                <label for="regionName">所属行政区域
                                    *</label>
                                <div class="form-group">
                                    <%--<input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">--%>
                                    <input type="text" id="regionName" required="required"
                                           data-parsley-required-message="该项为必填" class="form-control" readonly
                                           style="background-color:#fff" placeholder="请选择所属行政区域">
                                    <input type="hidden" id="regionCode" name="regionCode">
                                    <div class="menu-wrap">
                                        <div id="menuContent" class="menuContent" style="display:none;">
                                            <ul id="treeDemo" class="ztree"
                                                style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="fid">父组织机构名称*</label>
                                <div class="form-group">
                                    <select id="fid" name="fid" class="form-control" >
                                        <option>请先选择所属区域</option>
                                    </select>
                                </div>
                                <input type="hidden" id="fname" name="fname">
                            </div>
                            <div class="form-group">
                                <label for="deptCode">组织机构编码*</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptCode" name="deptCode"
                                           placeholder="请输入组织机构编码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptName">组织机构名称
                                    *</label>
                                <div class="form-group">
                                    <!-- <input type="text" class="form-control" id="sourceSelect" placeholder="组织机构名称" disabled> -->
                                    <input type="text" class="form-control" id="deptName" name="deptName"
                                           placeholder="请输入组织机构名称"
                                           data-rule="组织机构名称:required;deptName;remote(<%=basePath%>/system/dept/checkDeptName, fid:#fid)">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptShortName">组织机构简称</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptShortName" name="deptShortName"
                                           placeholder="请输入组织机构简称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptAlias">组织机构别名</label>
                                <div name="deptAlias" class="form-group">
                                    <input type="text" class="form-control" id="deptAlias" name="deptAlias"
                                           placeholder="请输入组织机构别名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptListingName">组织机构挂牌名</label>
                                <div name="deptListingName" class="form-group">
                                    <input type="text" class="form-control" id="deptListingName" name="deptListingName"
                                           placeholder="请输入组织机构挂牌名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptDesc">组织机构描述</label>
                                <div name="deptDesc" class="form-group">
                                    <textarea class="form-control" rows="3" id="deptDesc" name="deptDesc"
                                              placeholder="请输入组织机构描述"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="functionKeyword">职能关键字</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="functionKeyword" name="functionKeyword"
                                           placeholder="请输入职能关键字">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptFunction">组织机构职能</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptFunction" name="deptFunction"
                                           placeholder="请输入组织机构职能">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponseMan">部门负责人</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptResponseMan" name="deptResponseMan"
                                           placeholder="请输入部门负责人">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponsePhone">部门负责人电话</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptResponsePhone"
                                           name="deptResponsePhone" placeholder="请输入部门负责人电话">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptResponseEmail">部门负责人邮箱</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptResponseEmail"
                                           name="deptResponseEmail" placeholder="请输入部门负责人邮箱">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactMan">联系人</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptContactMan" name="deptContactMan"
                                           placeholder="请输入联系人">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactDept">联系人所属部门</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptContactDept" name="deptContactDept"
                                           placeholder="请输入联系人所属部门">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactPost">联系人职务</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptContactPost" name="deptContactPost"
                                           placeholder="请输入联系人职务">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactPhone">联系人手机</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptContactPhone"
                                           name="deptContactPhone" placeholder="请输入联系人手机">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactFixedPhone">联系人座机</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptContactFixedPhone"
                                           name="deptContactFixedPhone" placeholder="请输入联系人座机">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptContactEmail">联系人邮箱</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptContactEmail"
                                           name="deptContactEmail" placeholder="请输入联系人邮箱">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="deptAddress">组织机构地址</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="deptAddress" name="deptAddress"
                                           placeholder="请输入组织机构地址">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgLongitude">组织位置经度</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="orgLongitude" name="orgLongitude"
                                           placeholder="请输入组织位置经度">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orgLatitude">组织位置纬度</label>
                                <div class="form-group">
                                    <input type="text" class="form-control" id="orgLatitude" name="orgLatitude"
                                           placeholder="请输入组织位置纬度">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="orderNumber">排序</label>
                                <div class="form-group">
                                <input type="text" class="form-control" id="orderNumber" name="orderNumber"
                                       placeholder="请输入排序">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="status">状态</label>
                                <div class="form-group">
                                    <span class="radio-inline" style="padding: 4px 0 0 16px;">
                                    <input type="radio" name="status" id="inlineRadio2" value="1" checked>启用
                                    </span>
                                    <span class="radio-inline pdl0">
                                    <input type="radio" name="status" id="inlineRadio3" value="0">停用
                                    </span>
                                </div>
                            </div>

                        </div><!-- /.box-body -->
                        <div class="box-footer">
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
