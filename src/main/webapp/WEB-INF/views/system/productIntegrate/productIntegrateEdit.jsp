<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1 -->
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="/js/system/productIntegrate/productIntegrateEdit.js"></script>
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
                    <form class="form-horizontal"  role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="/system/productIntegrate/doEdit">
                        <input id="proIntId" type="hidden" value="${id}" name="Id" />
                        <div class="box-body box-bodyx">
                        	<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                        <label for="productNo" class="control-label col-sm-4 col-xs-4">标识</label>
                                        <div class="col-sm-7 col-xs-7">
                                        <input type="text" id="productNo" name="productNo" class="form-control" readonly>
                                        </div>
                                    </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                        <label for="productName" class="control-label col-sm-4 col-xs-4">名称</label>
                                        <div class="col-sm-7 col-xs-7">
                                        <input type="text" class="form-control"  id="productName"  readonly>
                                        </div>
                                    </div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                        <label class="control-label col-sm-4 col-xs-4">显示名称</label>
                                        <div class="col-sm-7 col-xs-7">
                                        <input type="text" class="form-control"  id="productShowName"  >
                                        </div>
                                    </div>
								</div>
                                <div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                        <label class="control-label col-sm-4 col-xs-4">根路径</label>
                                        <div class="col-sm-7 col-xs-7">
                                            <input type="text" class="form-control"  id="rootPath"  >
                                        </div>
                                    </div>
								</div>
								
							</div>
							<div class="row">

                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label class="control-label col-sm-4 col-xs-4">单点登录地址</label>
                                        <div class="col-sm-7 col-xs-7">
                                            <input type="text" class="form-control"  id="ssoPath"  >
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label class="control-label col-sm-4 col-xs-4">顺序</label>
                                        <div class="col-sm-7 col-xs-7">
                                            <input type="text" class="form-control"  id="orderNumber"  >
                                        </div>
                                    </div>
                                </div>

                            </div>
							<div class="row">
								
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                        <label class="control-label col-sm-4 col-xs-4">集成否</label>
                                        <div class="col-sm-7 col-xs-7">
                                            <span class="radio-inline" style="padding: 4px 0 0 16px;">
                                                <input id="integrateFlag1" name="integrateFlag" type="radio" class="minimal" value="1"> 是
                                            </span>
                                            <span class="radio-inline pdl0">
                                                <input id="integrateFlag0" name="integrateFlag" type="radio" class="minimal" value="0"> 否
                                            </span>
                                        </div>
                                    </div>
								</div>
                                <div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                        <label class="control-label col-sm-4 col-xs-4">本页打开</label>
                                        <div class="col-sm-7 col-xs-7">
                                            <span class="radio-inline" style="padding: 4px 0 0 16px;">
                                                <input id="curOpenFlag1" name="curOpenFlag" type="radio" class="minimal" value="1"> 是
                                            </span>
                                            <span class="radio-inline pdl0">
                                                <input id="curOpenFlag0" name="curOpenFlag" type="radio" class="minimal" value="0"> 非
                                            </span>
                                        </div>
                                    </div>
								</div>
							</div>
							<div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label for="iconName">图标</label>
                                        <select id="iconName" name="iconName" class="form-control">
                                        </select>
                                        <input type="hidden" id="icon" name="icon">
                                    </div>
                                </div>

                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label class="control-label col-sm-4 col-xs-4">主属节点</label>
                                        <div class="col-sm-7 col-xs-7">
                                            <span class="radio-inline" style="padding: 4px 0 0 16px;">
                                                <input id="masterFlag1" name="masterFlag" type="radio" class="minimal" value="1">主
                                            </span>
                                            <span class="radio-inline pdl0">
                                                <input id="masterFlag0" name="masterFlag" type="radio" class="minimal" value="0">从
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
