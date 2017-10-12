<%--
  Created by IntelliJ IDEA.
  User: Zhangm
  Date: 2017/10/9
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/system/dict/dataDictDetailEdit.js"></script>
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
                    <form  class="form-inline" role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=basePath%>/sysDict/detailDoEdit">
                        <input id="dictId" type="hidden" value="${dictId}" name="id" />
                        <div class="box-body box-bodyx">
                            <div class="form-group">
                                <label for="dictCode">配置项编码</label>
                                <div class="form-group">
                                <input type="text" id="dictCode" name="dictCode" class="form-control" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="dictName">配置项名称</label>
                                <div class="form-group">
                                <input type="text" id="dictName" name="dictName" class="form-control">
                                </div>
                            </div>
                            <div class="form-inline">
                                <label for="regionCode">适用范围</label>
                                <div class="form-group">
                                    <div class="form-group" style="float: right;width:270px;margin-right: 59px;">
                                        <input type="text" id="regionName" placeholder="选择所属区域" class="form-control"
                                               style="background-color:#fff;display: none" readonly>
                                        <input type="hidden" id="regionCode" name="regionCode">
                                        <div class="menu-wrap">
                                            <div id="menuContent" class="menuContent" style="display:none;">
                                                <ul id="treeDemo" class="ztree"
                                                    style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                            </div>
                                        </div>
                                    </div>
                                    <select id="regionCodes" class="form-control" style="width:110px;">
                                        <option  value="0">通用</option>
                                        <option  value="1">指定区域</option>
                                    </select>
                                </div>

                            </div>
                            <div class="form-group">
                                <label for="orderNumber">顺序</label>
                                <div class="form-group">
                                <input type="number" data-rule="integer(+0);" min="0" id="orderNumber" name="orderNumber" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="dictDesc" >描述</label>
                                <div class="form-group" name="dictDesc">
                                    <textarea class="form-control" rows="3" name="dictDesc" id="dictDesc"
                                              placeholder="请输入数据字典描述"></textarea>
                                </div>
                            </div>

                            <div class="form-group">
                                <label>状态</label>
                                <div class="col-sm-10">
                                <span class="radio-inline" style="padding: 4px 0 0 16px;">
                                    <input name="status" type="radio" class="minimal" value="1"> 启用
                                </span>
                                    <span  class="radio-inline pdl0">
                                    <input name="status" type="radio" class="minimal"  value="0"> 禁用
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