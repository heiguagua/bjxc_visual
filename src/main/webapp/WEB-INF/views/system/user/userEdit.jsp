<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 1 -->
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=context_path%>/js/system/user/userEdit.js"></script>
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
                    <form class="form-horizontal"  role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="<%=context_path%>/system/user/doEdit">
                        <input id="userId" type="hidden" value="${id}" name="Id" />
                        <input id="masterId" type="hidden"  value="${master}" />
                        <div class="box-body box-bodyx">
                        	<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label for="userName" class="control-label col-sm-4 col-xs-4">用户名</label>
                                <div class="col-sm-7 col-xs-7">
                                <input type="text" id="userName" name="userName" class="form-control" readonly>
                                </div>
                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label class="control-label col-sm-4 col-xs-4">所属行政区域</label>
                                <div class="col-sm-7 col-xs-7">
                                    <c:if test="${master}">
                                    <input type="text" id="regionName" data-rule="所属区域:required;regionCode;" class="form-control" readonly style="background-color:#fff">
                                    <input type="hidden" id="regionCode" name="regionCode">
                                    <div class="menu-wrap">
                                        <div id="menuRegionContent" class="menuContent" style="display:none;">
                                            <ul id="treeRegionDemo" class="ztree"
                                                style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                        </div>
                                    </div>
                                    </c:if>
                                    <c:if test="${!master}">
                                    <input type="text" class="form-control"  id="regionName"  readonly>
                                    </c:if>
                                </div>
                            </div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label class="control-label col-sm-4 col-xs-4">所属组织机构</label>
                                <div class="col-sm-7 col-xs-7">
                                    <c:if test="${master}">
                                    <input type="text" id="deptName" data-rule="所属组织机构;deptId;" class="form-control" readonly style="background-color:#fff">
                                    <input type="hidden" id="deptId" name="deptId">
                                    <div class="menu-wrap">
                                        <div id="menuContent" class="menuContent" style="display:none;">
                                            <ul id="treeDemo" class="ztree"
                                                style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                        </div>
                                    </div>
                                    </c:if>
                                    <c:if test="${!master}">
                                    <input type="text" class="form-control"  id="deptName"  readonly>
                                    <input type="hidden" class="form-control"  id="deptId"  name="deptId">
                                    </c:if>
                                </div>
                            </div>
								</div>
                                <div class="col-sm-6 col-xs-6">
                                    <div class="form-group">
                                        <label for="pinyin" class="control-label col-sm-4 col-xs-4">拼音</label>
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
			                                <label class="control-label col-sm-4 col-xs-4">用户接口验证码</label>
			                                <div class="col-sm-7 col-xs-7">
			                                    <input type="text" class="form-control"  id="token"  readonly style="width:440px">
			                                </div>
			                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label class="control-label col-sm-5 col-xs-5"></label>
                                <div class="col-sm-4 col-xs-4">
                                    <button type="button" class="btn btn_blue" id="createToken" disabled>
                                        生成用户接口验证码
                                    </button>
                                </div>
                            </div>
								</div>
							</div>
							<div class="row">
								
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label class="control-label col-sm-4 col-xs-4">角色 <i style="color: red">*必选</i></label>
                                <div class="col-sm-7 col-xs-7">
                                <select id="roleIds" name="roleIds" class="form-control select2" style="width: 100%;" data-rule="角色:required;roleIds;"></select>
                                </div>
                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label for="realName" class="control-label col-sm-4 col-xs-4">真实姓名</label>
                                <div class="col-sm-7 col-xs-7">
                                <input type="text" id="realName" name="realName" class="form-control"
                                       placeholder="请输入真实姓名" data-rule="真实姓名:required;realName;">
                                </div>
                            </div>
								</div>
							</div>
							<div class="row">
								
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label for="telephoneNumber" class="control-label col-sm-4 col-xs-4">固定电话</label>
                                <div class="col-sm-7 col-xs-7">
                                <input type="text" id="telephoneNumber" name="telephoneNumber" class="form-control"
                                       placeholder="请输入电话号码" data-rule="电话:tel;">
                                </div>
                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label for="cellPhoneNumber" class="control-label col-sm-4 col-xs-4">手机号码</label>
                                <div class="col-sm-7 col-xs-7">
                                <input type="text" id="cellPhoneNumber" name="cellPhoneNumber" class="form-control"
                                       placeholder="请输入手机号码" data-rule="手机:mobile;">
                                </div>
                            </div>
								</div>
							</div>
							<div class="row">
								
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label for="email" class="control-label col-sm-4 col-xs-4">邮箱</label>
                                <div class="col-sm-7 col-xs-7">
                                <input type="text" id="email" name="email" class="form-control"
                                       placeholder="请输入邮箱号码" data-rule="邮箱:email">
                                </div>
                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label class="control-label col-sm-4 col-xs-4">状态</label>
                                <div class="col-sm-7 col-xs-7">
                                    <span class="radio-inline" style="padding: 4px 0 0 16px;">
                                        <input id="status1" name="status" type="radio" class="minimal" value="1"> 启用
                                    </span>
                                    <span class="radio-inline pdl0">
                                        <input id="status0" name="status" type="radio" class="minimal" value="0"> 禁用
                                    </span>
                                </div>
                            </div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
                                <label class="control-label col-sm-4 col-xs-4">用户描述</label>
                                <div class="col-sm-7 col-xs-7">
                                <textarea class="form-control" id="userDesc" name="userDesc" rows="3"
                                          placeholder="请输入描述，最多512个字符,1个汉字算2个字符 ..."
                                          data-rule="用户描述:length[~512, true]" data-msg="最多输入256个汉字或512个字符"></textarea>
                                </div>
                            </div>
								</div>
								
							</div>
                            
                            
                            
                            
                            
                            
                            
<!--                             <div class="form-group"> -->
<!--                                 <label for="userType">用户类型</label> -->
<!--                                 <div class="form-group"> -->
<!--                                 <select id="userType" name="userType" class="form-control select2" style="width: 100%;"></select> -->
<!--                                 </div> -->
<!--                             </div> -->
                            
                            
                            
                            
                            
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
