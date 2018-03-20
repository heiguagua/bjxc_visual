<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1 -->
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=context_path%>/js/system/region/regionEdit.js"></script>
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
                .form-group{
			            margin-bottom:25px;
			      }
            </style>
            <div class="row">
                <div class="col-md-6">
                    <form class="form-horizontal"  role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=context_path%>/system/region/doEdit">
                        <input id="regionId" type="hidden" value="${id}" name="Id" />
                        <div class="box-body box-bodyx">
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label for="fname" class="control-label col-sm-5 col-xs-5">选择上级区域 <i style="color: red">*必选</i></label>
                                        <div class="col-sm-7 col-xs-7">
                                            <input type="text" id="fname" class="form-control" readonly >
                                            <input type="hidden" id="fcode" >
                                            <%--<div class="menu-wrap">--%>
                                                <%--<div id="menuRegionContent" class="menuContent" style="display:none;">--%>
                                                    <%--<ul id="treeRegionDemo" class="ztree"--%>
                                                        <%--style="margin-top:0;border: 1px solid #98b7a8;"></ul>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label for="regionName" class="control-label col-sm-5 col-xs-5">区域名 <i style="color: red">*必选</i></label>
                                        <div class="col-sm-7 col-xs-7">
                                            <input type="text" id="regionName" name="regionName" class="form-control"
                                                   autocomplete="false" data-rule="chinese" data-rule="行政区域名:regionName;required;length[~64, true]"
                                                   readonly>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label for="regionCode" class="control-label col-sm-5 col-xs-5">行政区划编号 <i style="color: red">*必选</i></label>
                                        <div class="col-sm-7 col-xs-7">
                                            <input type="text" id="regionCode" name="regionCode" class="form-control"
                                                   data-rule="行政区划编号:regionCode;required;length[~6, true]" data-rule="digits" readonly>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label for="pinyin" class="control-label col-sm-5 col-xs-5">拼音</label>
                                        <div class="col-sm-5 col-xs-5" style="padding-right:0">
                                            <input type="text" class="form-control" name="pinyin" id="pinyin" data-rule="letters">
                                        </div>
                                        <div class="col-sm-2 col-xs-2" style="padding-left:0">
                                            <input class="btn btn-primary form-control btn_blue" style="padding:0" type="button" value="生成" id="pinyinBtn" onclick="javascript:getPinyin()">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label class="control-label col-sm-5 col-xs-5">版本信息ID</label>
                                        <div class="col-sm-7 col-xs-7">
                                            <input type="number" class="form-control" name="versionId" id="versionId" data-rule="digits" min="1">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label for="regionLevelCode" class="control-label col-sm-5 col-xs-5">添加行政级别 <i style="color: red">*必选</i></label>
                                        <div class="col-sm-7 col-xs-7">
                                            <select id="regionLevelCode" name="regionLevelCode" class="form-control" data-rule="行政级别:required;regionLevelCode;"></select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label class="control-label col-sm-5 col-xs-5">状态 <i style="color: red">*必选</i></label>
                                        <div class="col-sm-7 col-xs-7">
			                                <span class="radio-inline" style="padding: 4px 0 0 16px;">
			                                    <input name="status" type="radio"  id="inlineRadio1" class="minimal" checked
                                                       value="1"> 启用
			                                </span>
                                            <span class="radio-inline pdl0">
			                                    <input name="status" type="radio" id="inlineRadio0" class="minimal" value="0"> 禁用
			                                </span>
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
