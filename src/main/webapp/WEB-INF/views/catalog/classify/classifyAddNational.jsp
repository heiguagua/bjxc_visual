<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="/js/catalog/classify/classifyAddNational.js"></script>
 	<script src="/js/system/dict/dictIcon.js"></script>
</head>
<body>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-12">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
                          method="post" action="/dirClassify/doAddNational">
                        <div class="box-body">
                        	<input id=fid type="hidden" value="${fid}" name="fid" /> 
                        	<input id=classifyType type="hidden" value="${classifyType}" name="classifyType" />               
			                <div class="form-group">
			                    <div class="row">
			                        <div class="col-sm-6">
			                            <label  class="col-sm-3 control-label" for="nationalCode">国家库*</label>
			                            <div class="col-sm-9">
<!-- 			                            	<input type="text" id="national_code" name="nationalCode" class="form-control"
                                       		placeholder="" data-rule="排序号:required;nationalCode;">
			              -->               <div id="loading"></div>	
										 	<input type="text" id="nationalCode" data-rule="国家库:required;" class="form-control"
					                         placeholder="">
					                        <input type="hidden" id="dictNationalCode" name="nationalCode">
					                        <div class="menu-wrap">
					                            <div id="menuNationalContent" class="menuContent" style="display:none;">
					                                <ul id="treeNational" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
					                            </div>
					                        </div>	 		                            
				                        </div>
			                        </div>
			                        
			                        
			                    </div>
			                </div>
			                                     	
                  <!-- 上面为修改的 -->      	
                        <%-- 	<div class="form-group">
                                <label for="fname">父目录</label>
                                <input type="text" id="fname" name="fname" readonly="readonly" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="classifyName">目录名称*</label>
                                <input type="text" id="classify_name" name="classifyName" class="form-control"
                                       placeholder="请输入目录名称" data-rule="目录名称:required;classifyName;remote(/system/user/insertCheckName)">
                            </div>
                            <div class="form-group" id="Dep">
                            	<label for="classifyName">是否为部门节点*</label>
                            	<label><input name="depnode" type="radio" value="yes" />是</label>
								<label><input name="depnode" type="radio" value="no" checked/>否 </label>
                            </div>
                           <div class="form-group hidden" id="deptGroup">
                                <label for="deptName" style='float:left;'>所属组织机构 *</label>
                                    <input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">
                                    <input type="text" id="deptName" required="required"
                                           data-parsley-required-message="该项为必填" class="form-control">
                                    <input type="hidden" id="deptId" name="DeptId">
                                    <div class="menu-wrap">
                                        <div id="menuContent" class="menuContent" style="display:none;">
                                            <ul id="treeDemo" class="ztree"
                                                style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                        </div>
                                    </div>
                            </div> --%>
                            
                            <!-- <div class="form-group">
                                <label for="roleId" >选择图标</label>
                                    <select id="icon" name="icon" class="form-control" >
                                    	  <option value ="">--请选择--</option>
                                    	  <option value ="volvo">Volvo</option>
										  <option value ="saab">Saab</option>
										  <option value="opel">Opel</option>
										  <option value="audi">Audi</option>                                   	
                                    </select>
                            </div> -->
                          <%--   <div class="form-group">
                                <label for="icon">选择图标*</label>
                                <select id="icon" name="icon" class="form-control select2" style="width: 100%;" data-rule="选择图标:required">             
                                		  <<!-- option value =""></option>
                                		  <option value ="volvo">Volvo</option>
										  <option value ="saab">Saab</option>
										  <option value="opel">Opel</option>
										  <option value="audi">Audi</option> -->  
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="orderNumber">排序号*</label>
                                 <input type="text" id="order_number" name="orderNumber" class="form-control"
                                       placeholder="请输入排序号" data-rule="排序号:required;orderNumber;remote(/dirClassify/CheckOrderNumber)">
                            </div>
                            <div class="form-group">
                                <label for="classifyDesc">目录描述:</label>
                                <textarea class="form-control" 
									id="classify_desc"  name="classifyDesc" data-rule=""></textarea>                                
                            </div>   --%>                          

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
