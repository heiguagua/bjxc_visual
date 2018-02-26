<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=context_path%>/js/system/user/userAdd.js"></script>
    <style>
                .box-body .pdl0{
                    padding-left: 0;
                }
                
                 .form-group{
			            margin-bottom:25px;
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
                    <form class="form-horizontal"  role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=context_path%>/system/user/doAdd">
                        <div class="box-body box-bodyx" style="padding:0 30px 0 0">
                        	<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label for="userName" class="control-label col-sm-5 col-xs-5">用户名 <i style="color: red">*必选</i></label>
			                            <div class="col-sm-7 col-xs-7">
			                            <input type="text" id="userName" name="userName" class="form-control"
			                                   placeholder="请输入用户名" autocomplete="false"
			                                   data-rule="用户名:username;required;length[3~12];remote(<%=context_path%>/system/user/insertCheckName)">
			                            </div>
			                        </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label for="password" class="control-label col-sm-5 col-xs-5">密码 <i style="color: red">*必选</i></label>
			                            <div class="col-sm-7 col-xs-7">
			                            <input type="text" style="display: none">
			                            <input type="password" id="password" name="password" class="form-control" autocomplete="false"
			                                   placeholder="请输入密码" data-rule="密码:password;required;">
			                            </div>
			                        </div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label for="password2" class="control-label col-sm-5 col-xs-5">确认密码 <i style="color: red">*必选</i></label>
			                            <div class="col-sm-7 col-xs-7">
			                            <input type="password" id="password2" name="password2" class="form-control"
			                                   placeholder="请再次输入密码" data-rule="确认密码:password; match(password);required">
			                            </div>
			                        </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label for="regionName" class="control-label col-sm-5 col-xs-5">所属区域 <i style="color: red">*必选</i></label>
			                            <div class="col-sm-7 col-xs-7">
			                            <input type="text" id="regionName" data-rule="所属区域:required;regionCode;" class="form-control" readonly style="background-color:#fff">
			                            <input type="hidden" id="regionCode" name="regionCode">
			                            <div class="menu-wrap">
			                                <div id="menuRegionContent" class="menuContent" style="display:none;">
			                                    <ul id="treeRegionDemo" class="ztree"
			                                        style="margin-top:0;border: 1px solid #98b7a8;"></ul>
			                                </div>
			                            </div>
			                            </div>
			                        </div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label for="deptName" class="control-label col-sm-5 col-xs-5">所属组织机构 </label>
			                            <div class="col-sm-7 col-xs-7">
			                            <input type="text" id="deptName" data-rule="所属组织机构;deptId;" class="form-control" readonly style="background-color:#fff">
			                            <input type="hidden" id="deptId" name="deptId">
			                            <div class="menu-wrap">
			                                <div id="menuContent" class="menuContent" style="display:none;">
			                                    <ul id="treeDemo" class="ztree"
			                                        style="margin-top:0;border: 1px solid #98b7a8;"></ul>
			                                </div>
			                            </div>
			                            </div>
			                        </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label for="roleIds" class="control-label col-sm-5 col-xs-5">添加角色 <i style="color: red">*必选</i></label>
			                            <div class="col-sm-7 col-xs-7">
			                                <select id="roleIds" name="roleIds" class="form-control" data-rule="角色:required;roleIds;"></select>
			                            </div>
			                        </div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label for="realName" class="control-label col-sm-5 col-xs-5">真实姓名 <i style="color: red">*必选</i></label>
			                            <div class="col-sm-7 col-xs-7">
			                            <input type="text" id="realName" name="realName" class="form-control"
			                                   placeholder="请输入真实姓名" data-rule="真实姓名:realName;required;length[~36, true]">
			                            </div>
			                        </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label for="telephoneNumber" class="control-label col-sm-5 col-xs-5">固定电话</label>
			                            <div class="col-sm-7 col-xs-7">
			                            <input type="text" id="telephoneNumber" name="telephoneNumber" class="form-control"
			                                   placeholder="请输入固定电话号码(格式为0000-0000000)" data-rule="电话:tel;">
			                            </div>
			                        </div>
								</div>
							</div>
                        	<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label for="cellPhoneNumber" class="control-label col-sm-5 col-xs-5">手机号码</label>
			                            <div class="col-sm-7 col-xs-7">
			                            <input type="text" id="cellPhoneNumber" name="cellPhoneNumber" class="form-control"
			                                   placeholder="请输入手机号码" data-rule="电话:mobile;">
			                            </div>
			                        </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label for="email" class="control-label col-sm-5 col-xs-5">邮箱</label>
			                            <div class="col-sm-7 col-xs-7">
			                            <input type="text" id="email" name="email" class="form-control"
			                                   placeholder="请输入邮箱" data-rule="邮箱:email">
			                            </div>
			                        </div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
			                            <label class="control-label col-sm-5 col-xs-5">用户描述</label>
			                            <div class="col-sm-7 col-xs-7">
			                            <textarea class="form-control" name="userDesc" rows="3"
			                                      placeholder="请输入描述，最多512个字符,1个汉字算2个字符 ..."
			                                      data-rule="用户描述:length[~512, true]" data-msg="最多输入256个汉字或512个字符"></textarea>
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
										<label class="control-label col-sm-5 col-xs-5">状态 <i style="color: red">*必选</i></label>
										<div class="col-sm-7 col-xs-7">
			                                <span class="radio-inline" style="padding: 4px 0 0 16px;">
			                                    <input name="status" type="radio" id="inlineRadio1" class="minimal" checked
													   value="1"> 启用
			                                </span>
											<span class="radio-inline pdl0">
			                                    <input name="status" type="radio" id="inlineRadio0" class="minimal" value="0"> 禁用
			                                </span>
										</div>
									</div>
								</div>

							</div>
                        
                        
                        
                        
                        
<!--                         <div class="form-group"> -->
<!--                             <label for="userType">用户类型 <i style="color: red">*必选</i></label> -->
<!--                             <div class="form-group"> -->
<!--                             <select id="userType" name="userType" class="form-control select2" -->
<!--                                     style="width: 100%;"></select> -->
<!--                             </div> -->
<!--                         </div> -->
                        
                        
                        
                        

                       
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
