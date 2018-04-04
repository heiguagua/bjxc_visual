<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=context_path%>/js/system/dept/deptEdit.js"></script>
	<script src="<%=context_path%>/js/system/dept/deptContactEdit.js"></script>
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
            </style>
            <div class="row">
                <div class="col-md-6">
                    <form  class="form-horizontal" role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="<%=context_path%>/system/dept/doEdit">
                        <input type="hidden" id="deptId" value="${id}" name="id"/>
                        <input type="hidden" id="regionCode" name="regionCode"/>
                        <input type="hidden" id="fid" name="fid"/>

                        <div class="box-body  box-bodyx">
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="regionCode" class="control-label col-sm-4 col-xs-4">所属行政区域
										<i style="color: red">*</i></label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" id="regionName" readonly>
		                                </div>
		                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="fname" class="control-label col-sm-4 col-xs-4">父组织机构名称<i style="color: red">*</i></label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" id="fname" readonly>
		                                </div>
		                            </div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="deptCode" class="control-label col-sm-4 col-xs-4">组织机构编码<i style="color: red">*</i></label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" id="deptCode" name="deptCode"
		                                    data-rule="组织机构编码:simpleCode;required;length[~64, true]">
		                                </div>
		                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="deptName" class="control-label col-sm-4 col-xs-4">组织机构名称
											<i style="color: red">*</i></label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" name="deptName" id="deptName"
		                                           placeholder="组织机构名称"
		                                           data-rule="组织机构名称:required;deptName;remote(<%=context_path%>/system/dept/checkDeptName, fname:#fname, deptId:#deptId)">
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
		                                    <input type="text" class="form-control" name="deptShortName" id="deptShortName"
		                                           placeholder="组织机构简称"
		                                           data-rule="组织机构简称:simpleName;length[~64, true];required">
		                                </div>
		                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="deptAlias" class="control-label col-sm-4 col-xs-4">组织机构别名</label>
		                                <div name="deptAlias" class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" name="deptAlias" id="deptAlias"
		                                           placeholder="组织机构别名">
		                                </div>
		                            </div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="deptListingName" class="control-label col-sm-4 col-xs-4">组织机构挂牌名</label>
		                                <div name="deptListingName" class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" name="deptListingName" id="deptListingName"
		                                           placeholder="组织机构挂牌名">
		                                </div>
		                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="functionKeyword" class="control-label col-sm-4 col-xs-4">职能关键字</label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" name="functionKeyword" id="functionKeyword"
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
		                                    <textarea class="form-control" rows="5" name="deptDesc" id="deptDesc"
		                                              placeholder="请输入组织机构描述"
		                                              placeholder="请输入描述，最多512个字符,一个汉字算2个字符 ..." data-rule="length[~512, true];" data-msg="最多输入256个汉字或512个字符"></textarea>
		                                </div>
		                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="deptFunction" class="control-label col-sm-4 col-xs-4">组织机构职能</label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <textarea  class="form-control" rows="5" name="deptFunction" id="deptFunction" data-rule="length[~4000, true];" data-msg="最多输入2000个汉字或4000个字符"
		                                           placeholder="组织机构职能"></textarea>
		                                </div>
		                            </div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="deptResponseMan" class="control-label col-sm-4 col-xs-4">部门负责人</label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" name="deptResponseMan" id="deptResponseMan"
		                                           placeholder="部门负责人">
		                                </div>
		                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="deptResponsePhone" class="control-label col-sm-4 col-xs-4">部门负责人电话</label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" name="deptResponsePhone"
		                                           id="deptResponsePhone" placeholder="部门负责人电话" data-rule="tel|mobile">
		                                </div>
		                            </div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="deptResponseEmail" class="control-label col-sm-4 col-xs-4">部门负责人邮箱</label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" name="deptResponseEmail"
		                                           id="deptResponseEmail" placeholder="部门负责人邮箱" data-rule="邮箱:email">
		                                </div>
		                            </div>
								</div>
								<%--<div class="col-sm-6 col-xs-6">--%>
									<%--<div class="form-group">--%>
		                                <%--<label for="deptContactMan" class="control-label col-sm-4 col-xs-4">联系人</label>--%>
		                                <%--<div class="col-sm-7 col-xs-7">--%>
		                                    <%--<input type="text" class="form-control" name="deptContactMan" id="deptContactMan"--%>
		                                           <%--placeholder="联系人">--%>
		                                <%--</div>--%>
		                            <%--</div>--%>
								<%--</div>--%>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
										<label for="deptAddress" class="control-label col-sm-4 col-xs-4">组织机构地址</label>
										<div class="col-sm-7 col-xs-7">
											<input type="text" class="form-control" name="deptAddress" id="deptAddress"
												   placeholder="组织机构地址"
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
		                                    <%--<input type="text" class="form-control" name="deptContactDept" id="deptContactDept"--%>
		                                           <%--placeholder="联系人所属部门">--%>
		                                <%--</div>--%>
		                            <%--</div>--%>
								<%--</div>--%>
								<%--<div class="col-sm-6 col-xs-6">--%>
									<%--<div class="form-group">--%>
		                                <%--<label for="deptContactPost" class="control-label col-sm-4 col-xs-4">联系人职务</label>--%>
		                                <%--<div class="col-sm-7 col-xs-7">--%>
		                                    <%--<input type="text" class="form-control" name="deptContactPost" id="deptContactPost"--%>
		                                           <%--placeholder="联系人职务">--%>
		                                <%--</div>--%>
		                            <%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
                            
                            <%--<div class="row">--%>
								<%--<div class="col-sm-6 col-xs-6">--%>
									<%--<div class="form-group">--%>
		                                <%--<label for="deptContactPhone" class="control-label col-sm-4 col-xs-4">联系人手机</label>--%>
		                                <%--<div class="col-sm-7 col-xs-7">--%>
		                                    <%--<input type="text" class="form-control" name="deptContactPhone"--%>
		                                           <%--id="deptContactPhone" placeholder="联系人手机" data-rule="mobile">--%>
		                                <%--</div>--%>
		                            <%--</div>--%>
								<%--</div>--%>
								<%--<div class="col-sm-6 col-xs-6">--%>
									<%--<div class="form-group">--%>
		                                <%--<label for="deptContactFixedPhone" class="control-label col-sm-4 col-xs-4">联系人座机</label>--%>
		                                <%--<div class="col-sm-7 col-xs-7">--%>
		                                    <%--<input type="text" class="form-control" name="deptContactFixedPhone"--%>
		                                           <%--id="deptContactFixedPhone" placeholder="联系人座机" data-rule="tel">--%>
		                                <%--</div>--%>
		                            <%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
							<%--<div class="row">--%>
								<%--<div class="col-sm-6 col-xs-6">--%>
									<%--<div class="form-group">--%>
		                                <%--<label for="deptContactEmail" class="control-label col-sm-4 col-xs-4">联系人邮箱</label>--%>
		                                <%--<div class="col-sm-7 col-xs-7">--%>
		                                    <%--<input type="text" class="form-control" name="deptContactEmail"--%>
		                                           <%--id="deptContactEmail" placeholder="联系人邮箱" data-rule="邮箱:email">--%>
		                                <%--</div>--%>
		                            <%--</div>--%>
								<%--</div>--%>

							<%--</div>--%>
							<div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="orgLongitude" class="control-label col-sm-4 col-xs-4">组织位置经度</label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" name="orgLongitude" id="orgLongitude"
		                                           placeholder="组织位置经度" data-rule="floatNumber;range(-180~180)">
		                                </div>
		                            </div>
								</div>
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="orgLatitude" class="control-label col-sm-4 col-xs-4">组织位置纬度</label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="text" class="form-control" name="orgLatitude" id="orgLatitude"
		                                           placeholder="组织位置纬度" data-rule="floatNumber;range(-90~90)">
		                                </div>
		                            </div>
								</div>
							</div>
                            <div class="row">
								<div class="col-sm-6 col-xs-6">
									<div class="form-group">
		                                <label for="orderNumber" class="control-label col-sm-4 col-xs-4" >排序</label>
		                                <div class="col-sm-7 col-xs-7">
		                                    <input type="number" class="form-control" name="orderNumber" id="orderNumber"
		                                           placeholder="排序" data-rule="digits" min="0">
		                                </div>
		                            </div>
								</div>
								<%--<div class="col-sm-6 col-xs-6">--%>
									<%--<div class="form-group">--%>
		                                <%--<label for="validateFrom" class="control-label col-sm-4 col-xs-4">组织启用时间</label>--%>
		                                <%--<div class="col-sm-7 col-xs-7">--%>
		                                    <%--<input type="text" class="form-control" id="validateFrom" readonly>--%>
		                                <%--</div>--%>
		                            <%--</div>--%>
								<%--</div>--%>

							</div>
							<%--<div class="row">--%>
								<%--<div class="col-sm-6 col-xs-6">--%>
									 <%--<div class="form-group">--%>
		                                <%--<label for="validateTo" class="control-label col-sm-4 col-xs-4">组织停用时间</label>--%>
		                                <%--<div class="col-sm-7 col-xs-7">--%>
		                                    <%--<input type="text" class="form-control" id="validateTo" readonly>--%>
		                                <%--</div>--%>
		                            <%--</div>--%>
								<%--</div>--%>
								<%--<div class="col-sm-6 col-xs-6">--%>
									<%--<div class="form-group">--%>
		                                <%--<label  for="status" class="control-label col-sm-4 col-xs-4">状态</label>--%>
		                                <%--<div class="col-sm-7 col-xs-7">--%>
		                              <%--<span class="radio-inline"  style="padding: 4px 0 0 16px;">--%>
			                            <%--<input type="radio" name="status" id="inlineRadio1" value="1">启用--%>
			                          <%--</span>--%>
		                                    <%--<span class="radio-inline  pdl0">--%>
			                            <%--<input type="radio" name="status" id="inlineRadio0" value="0">停用--%>
			                          <%--</span>--%>
		                                <%--</div>--%>
		                            <%--</div>--%>
								<%--</div>--%>
							<%--</div>--%>
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
