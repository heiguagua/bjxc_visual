<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=context_path%>/js/system/dept/deptAdd.js"></script>
    <script src="<%=context_path%>/js/system/dept/deptContactEdit.js"></script>
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
        
         .form-group{
            margin-bottom:25px;
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
                    <form  class="form-horizontal" role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=context_path%>/system/dept/doAdd">
                        <div class="box-body box-bodyx">

                
                        
                        
                        <!--11111111111111111111  -->
                        <div class="row">
                        	<div class="col-sm-6 col-xs-6">
                        		<div class="form-group">
	                                <label for="regionName" class="control-label col-sm-4 col-xs-4">所属行政区域
	                                    <i style="color: red">*</i></label>
	                                <div class="col-sm-7 col-xs-7">
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
                        	</div>
                        	<div class="col-sm-6 col-xs-6">
                        		<div class="form-group">
	                                <label for="fid" class="control-label col-sm-4 col-xs-4">父组织机构名称<i style="color: red">*</i></label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <select id="fid" name="fid" class="form-control" >
	                                        <option>请先选择所属区域</option>
	                                    </select>
	                                </div>
	                                <input type="hidden" id="fname" name="fname">
	                            </div>
                        	</div>
                        </div>
                        <div class="row">
                        	<div class="col-sm-6 col-xs-6">
                        		<div class="form-group">
	                                <label for="deptCode" class="control-label col-sm-4 col-xs-4">组织机构编码<i style="color: red">*</i></label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <input type="text" class="form-control" id="deptCode" name="deptCode"
	                                           placeholder="请输入组织机构编码"
	                                           data-rule="组织机构编码:simpleCode;required;length[~64, true];remote(<%=context_path%>/system/dept/checkDeptCode, fname:#fname, deptId:#deptId)">
	                                </div>
	                            </div>
                        	</div>
                        	<div class="col-sm-6 col-xs-6">
                        		<div class="form-group">
	                                <label for="deptName" class="control-label col-sm-4 col-xs-4">组织机构名称
	                                    <i style="color: red">*</i></label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <!-- <input type="text" class="form-control" id="sourceSelect" placeholder="组织机构名称" disabled> -->
	                                    <input type="text" class="form-control" id="deptName" name="deptName"
	                                           placeholder="请输入组织机构名称"
	                                           data-rule="组织机构名称:required;deptName;remote(<%=context_path%>/system/dept/checkDeptName, fname:#fname)">
	                                </div>
	                            </div>
                        	</div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 col-xs-6">
                                <div class="form-group">
                                    <label for="deptShortName" class="control-label col-sm-4 col-xs-4">组织机构类型</label>
                                    <div class="col-sm-7 col-xs-7">
                                        <input type="text" class="form-control" name="deptType" id="deptType"
                                               placeholder="组织机构类型"
                                               data-rule="组织机构类型:letters">
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
	                                <label for="deptShortName" class="control-label col-sm-4 col-xs-4">组织机构简称<i style="color: red">*</i></label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <input type="text" class="form-control" id="deptShortName" name="deptShortName"
	                                           placeholder="请输入组织机构简称"
	                                           data-rule="组织机构简称:simpleName;length[~64, true];required;remote(<%=context_path%>/system/dept/checkDeptShortName, fname:#fname, deptId:#deptId)">
	                                </div>
	                            </div>
                        	</div>
                        	<div class="col-sm-6 col-xs-6">
                        		<div class="form-group">
	                                <label for="deptAlias" class="control-label col-sm-4 col-xs-4">组织机构别名</label>
	                                <div name="deptAlias" class="col-sm-7 col-xs-7">
	                                    <input type="text" class="form-control" id="deptAlias" name="deptAlias"
	                                           placeholder="请输入组织机构别名">
	                                </div>
	                            </div>
                        	</div>
                        </div>
                        
                        <div class="row">
                        	<div class="col-sm-6 col-xs-6">
	                        	<div class="form-group">
	                                <label for="deptListingName" class="control-label col-sm-4 col-xs-4">组织机构挂牌名</label>
	                                <div name="deptListingName" class="col-sm-7 col-xs-7">
	                                    <input type="text" class="form-control" id="deptListingName" name="deptListingName"
	                                           placeholder="请输入组织机构挂牌名">
	                                </div>
	                            </div>
                        	</div>
                        	<div class="col-sm-6 col-xs-6">
                        		<div class="form-group">
	                                <label for="functionKeyword" class="control-label col-sm-4 col-xs-4">职能关键字</label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <input type="text" class="form-control" id="functionKeyword" name="functionKeyword"
                                               placeholder="请输入职能关键字，并以、分割" data-rule="xxx" data-rule-xxx="[/^[^、][\S\s]*、?[^、]$/, '、分词，且不能用、开始或结尾']">
	                                </div>
	                            </div>
                        	</div>
                        </div>



                        <div class="row">
                        	<div class="col-sm-6 col-xs-6">
	                        	<div class="form-group">
	                                <label for="deptDesc" class="control-label col-sm-4 col-xs-4">组织机构描述</label>
	                                <div name="deptDesc" class="col-sm-7 col-xs-7">
	                                    <textarea class="form-control" rows="5" id="deptDesc" name="deptDesc"
	                                              placeholder="请输入描述，最多512个字符,一个汉字算2个字符 ..." data-rule="length[~512, true];" data-msg="最多输入256个汉字或512个字符"></textarea>
	                                </div>
	                            </div>
                        	</div>
                        	<div class="col-sm-6 col-xs-6">
	                        	<div class="form-group">
	                                <label for="deptFunction" class="control-label col-sm-4 col-xs-4">组织机构职能</label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <textarea  class="form-control" id="deptFunction" name="deptFunction" rows="5" data-rule="length[~4000, true];" data-msg="最多输入2000个汉字或4000个字符"
	                                           placeholder="请输入组织机构职能"></textarea>
	                                </div>
	                            </div>
                        	</div>
                        </div>
                            
						<div class="row">
                        	<div class="col-sm-6 col-xs-6">
	                        	<div class="form-group">
	                                <label for="deptResponseMan" class="control-label col-sm-4 col-xs-4">部门负责人</label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <input type="text" class="form-control" id="deptResponseMan" name="deptResponseMan"
	                                           placeholder="请输入部门负责人">
	                                </div>
	                            </div>
                        	</div>
                        	<div class="col-sm-6 col-xs-6">
	                        	<div class="form-group">
	                                <label for="deptResponsePhone" class="control-label col-sm-4 col-xs-4">部门负责人电话</label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <input type="text" class="form-control" id="deptResponsePhone"
	                                           name="deptResponsePhone" placeholder="请输入部门负责人电话" data-rule="tel|mobile">
	                                </div>
	                            </div>
                        	</div>
                        </div>
                        
                        <div class="row">
                        	<div class="col-sm-6 col-xs-6">
	                        	<div class="form-group">
	                                <label for="deptResponseEmail" class="control-label col-sm-4 col-xs-4">部门负责人邮箱</label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <input type="text" class="form-control" id="deptResponseEmail"
	                                           name="deptResponseEmail" placeholder="请输入部门负责人邮箱" data-rule="email">
	                                </div>
	                            </div>
                        	</div>
                        	<%--<div class="col-sm-6 col-xs-6">--%>
	                        	<%--<div class="form-group">--%>
	                                <%--<label for="deptContactMan" class="control-label col-sm-4 col-xs-4">联系人</label>--%>
	                                <%--<div class="col-sm-7 col-xs-7">--%>
	                                    <%--<input type="text" class="form-control" id="deptContactMan" name="deptContactMan"--%>
	                                           <%--placeholder="请输入联系人">--%>
	                                <%--</div>--%>
	                            <%--</div>--%>
                        	<%--</div>--%>
							<div class="col-sm-6 col-xs-6">
								<div class="form-group">
									<label for="deptAddress" class="control-label col-sm-4 col-xs-4">组织机构地址</label>
									<div class="col-sm-7 col-xs-7">
										<input type="text" class="form-control" id="deptAddress" name="deptAddress"
											   placeholder="请输入组织机构地址"
											   data-rule="地址:length[~256, true]" data-msg="最多输入128个汉字或256个字符">
									</div>
								</div>
							</div>
                        </div>
                        
                        <%--<div class="row">--%>
                        	<%--<div class="col-sm-6 col-xs-6">--%>
	                        	<%--<div class="form-group">--%>
	                                <%--<label for="deptContactDept" class="control-label col-sm-4 col-xs-4">联系人所属部门</label>--%>
	                                <%--<div class="col-sm-7 col-xs-7">--%>
	                                    <%--<input type="text" class="form-control" id="deptContactDept" name="deptContactDept"--%>
	                                           <%--placeholder="请输入联系人所属部门">--%>
	                                <%--</div>--%>
	                            <%--</div>--%>
                        	<%--</div>--%>
                        	<%--<div class="col-sm-6 col-xs-6">--%>
	                        	<%--<div class="form-group">--%>
	                                <%--<label for="deptContactPost" class="control-label col-sm-4 col-xs-4">联系人职务</label>--%>
	                                <%--<div class="col-sm-7 col-xs-7">--%>
	                                    <%--<input type="text" class="form-control" id="deptContactPost" name="deptContactPost"--%>
	                                           <%--placeholder="请输入联系人职务">--%>
	                                <%--</div>--%>
	                            <%--</div>--%>
                        	<%--</div>--%>
                        <%--</div>--%>
                        
                        <%--<div class="row">--%>
                        	<%--<div class="col-sm-6 col-xs-6">--%>
	                        	<%--<div class="form-group">--%>
	                                <%--<label for="deptContactPhone" class="control-label col-sm-4 col-xs-4">联系人手机</label>--%>
	                                <%--<div class="col-sm-7 col-xs-7">--%>
	                                    <%--<input type="text" class="form-control" id="deptContactPhone"--%>
	                                           <%--name="deptContactPhone" placeholder="请输入联系人手机" data-rule="mobile">--%>
	                                <%--</div>--%>
	                            <%--</div>--%>
                        	<%--</div>--%>
                        	<%--<div class="col-sm-6 col-xs-6">--%>
	                        	<%--<div class="form-group">--%>
	                                <%--<label for="deptContactFixedPhone" class="control-label col-sm-4 col-xs-4">联系人座机</label>--%>
	                                <%--<div class="col-sm-7 col-xs-7">--%>
	                                    <%--<input type="text" class="form-control" id="deptContactFixedPhone"--%>
	                                           <%--name="deptContactFixedPhone" placeholder="请输入联系人座机" data-rule="tel">--%>
	                                <%--</div>--%>
	                            <%--</div>--%>
                        	<%--</div>--%>
                        <%--</div>--%>
                        
                        <%--<div class="row">--%>
                        	<%--<div class="col-sm-6 col-xs-6">--%>
	                        	<%--<div class="form-group">--%>
	                                <%--<label for="deptContactEmail" class="control-label col-sm-4 col-xs-4">联系人邮箱</label>--%>
	                                <%--<div class="col-sm-7 col-xs-7">--%>
	                                    <%--<input type="text" class="form-control" id="deptContactEmail"--%>
	                                           <%--name="deptContactEmail" placeholder="请输入联系人邮箱" data-rule="email">--%>
	                                <%--</div>--%>
	                            <%--</div>--%>
                        	<%--</div>--%>

                        <%--</div>--%>
                        
                        <div class="row">
                        	<div class="col-sm-6 col-xs-6">
	                        	<div class="form-group">
	                                <label for="orgLongitude" class="control-label col-sm-4 col-xs-4">组织位置经度</label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <input type="text" class="form-control" id="orgLongitude" name="orgLongitude"
	                                           placeholder="请输入组织位置经度" data-rule="floatNumber;range(-180~180)">
	                                </div>
	                            </div>
                        	</div>
                        	<div class="col-sm-6 col-xs-6">
	                        	<div class="form-group">
	                                <label for="orgLatitude" class="control-label col-sm-4 col-xs-4">组织位置纬度</label>
	                                <div class="col-sm-7 col-xs-7">
	                                    <input type="text" class="form-control" id="orgLatitude" name="orgLatitude"
	                                           placeholder="请输入组织位置纬度" data-rule="floatNumber;range(-90~90)">
	                                </div>
	                            </div>
                        	</div>
                        </div>
                        <div class="row">
                        	<div class="col-sm-6 col-xs-6">
	                        	<div class="form-group">
	                                <label for="orderNumber" class="control-label col-sm-4 col-xs-4">排序</label>
	                                <div class="col-sm-7 col-xs-7">
	                                <input type="number" class="form-control" id="orderNumber" name="orderNumber"
	                                       placeholder="请输入排序" data-rule="digits" min="0">
	                                </div>
	                            </div>
                        	</div>
                        	<%--<div class="col-sm-6 col-xs-6">--%>
	                        	<%--<div class="form-group">--%>
	                                <%--<label for="status" class="control-label col-sm-4 col-xs-4">状态</label>--%>
	                                <%--<div class="col-sm-7 col-xs-7">--%>
	                                    <%--<span class="radio-inline" style="padding: 4px 0 0 16px;">--%>
	                                    <%--<input type="radio" name="status" id="inlineRadio2" value="1" checked>启用--%>
	                                    <%--</span>--%>
	                                    <%--<span class="radio-inline pdl0">--%>
	                                    <%--<input type="radio" name="status" id="inlineRadio3" value="0">停用--%>
	                                    <%--</span>--%>
	                                <%--</div>--%>
	                            <%--</div>--%>
                        	<%--</div>--%>
                        </div>
						<div class="checkh1">
							<span class="checkspan">联系人列表</span>
							<button type="button" class="btn btn-primary btn-flat pull-right dropdown-toggle btn-myself"
									data-toggle="dropdown" id="addItems" style="margin-right: 10px;">
								<img src="<%=context_path%>/images/userImg/addimg.png"/>添加
							</button>
							<button type="button" class="btn btn-primary btn-flat pull-right dropdown-toggle btn-myself"
									data-toggle="dropdown" id="deleteItems" style="margin-right: 10px;">
								<img src="<%=context_path%>/images/userImg/delImg.png"/>删除
							</button>
						</div>
						<div class="form-group " style="overflow-x: auto;min-height:200px;border: 1px solid #ddd;">
							<table style="width:100%" class="table-striped">
								<thead>
								<tr class='table_title_tr'>
									<th><input type="checkbox" id="selectAllItem"> 全选</th>
									<th>联系人类型</th>
									<th>联系人姓名</th>
									<th>联系人处室</th>
									<th>联系人职务</th>
									<th>联系人座机</th>
									<th>联系人手机</th>
									<th>联系人邮箱</th>
								</tr>
								</thead>
								<tbody id="dataitemList">
								</tbody>
							</table>
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
