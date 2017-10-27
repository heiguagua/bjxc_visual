<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1 -->
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/system/setting/settingEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=basePath%>/system/setting/doEdit">
                        <input type="hidden" id="settingId" value="${settingId}" name="id"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="settingCode">系统配置编码</label>
                                <input type="text" id="settingCode" name="settingCode" class="form-control"
                                       placeholder="请输入系统配置编码" data-rule="组织系统配置编码:required;" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="settingName">系统配置名称</label>
                                <input type="text" id="settingName" name="settingName" class="form-control"
                                       placeholder="请输入系统配置名称" data-rule="组织系统配置名称:required;" readonly="readonly">
                            </div>
                            <div class="form-group">
                                <label for="settingValue">系统配置值</label>
                                <input type="text" id="settingValue" name="settingValue" class="form-control"
                                       placeholder="请输入系统配置值" data-rule="组织系统配置值:length[1~300, true];required;">
                            </div>
                            <div class="form-group">
                                <label for="regionCode">所属行政区域</label>
                                <input type="text" id="regionCode" name="regionCode" class="form-control" readonly>
                            </div>
                            <div class="form-group">
                                <label>系统配置描述</label>
                                <textarea class="form-control" id="settingDesc" name="settingDesc" rows="3"
                                          placeholder="请输入描述，最多300个字符,1个汉字按2个字符计算 ..."
                                          data-rule="系统配置描述:length[0~300, true]"></textarea>
                            </div>
                            <div class="form-group">
                                <label>状态</label>
                                <div class="col-sm-10">
                                <span>
                                    <input name="status" type="radio" class="minimal" value="1"> 启用
                                </span>
                                    <span>
                                    <input name="status" type="radio" class="minimal"  value="-1"> 禁用
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
