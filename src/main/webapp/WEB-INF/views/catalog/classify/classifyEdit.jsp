<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="/js/catalog/classify/classifyEdit.js"></script>
    <script src="/js/system/dict/dictIcon.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <section class="content">
    <div class="row">
        <div class="col-md-12">
            <!-- form start -->
            <div class="row">
                <div class="col-md-6">
                    <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}" method="post" action="/dirClassify/doEdit">
                        <input id="classifyId" type="hidden" value="${id}" name="id" />
                        <div class="box-body">
                        	<div class="form-group">
                        	<div class="row">
                        	<div class="col-sm-6">
                                <label class="col-sm-3 control-label" for="classifyCode">目录编码</label>
                                <div class="col-sm-9">
                                <input type="text" id="EclassifyCode" name="classifyCode" readonly="readonly" class="form-control">
                            	</div>
                            </div>
                           <div class="col-sm-6">
                                <label class="col-sm-3 control-label" for="apiName">目录名称*</label>
                                <div class="col-sm-9">
                                <input type="text" id="Eclassify_name" name="classifyName" class="form-control"
                                       placeholder="请输入目录名称" data-rule="目录名称:required;classifyName;">
                           		 </div>
                            </div>
                            </div>
                            </div>
                            
                            
                            <div class="form-group">
                            <div class="row">
                            	<div class="col-sm-6">
	                                <label  class="col-sm-3 control-label" for="icon">选择图标</label>
	                                <div class="col-sm-9">
	                                <select id="Eicon" name="icon" class="form-control select2" style="width: 100%;" >             
	                                		  <!-- <option value =""></option>
	                                		  <option value ="volvo">Volvo</option>
											  <option value ="saab">Saab</option>
											  <option value="opel">Opel</option>
											  <option value="audi">Audi</option>   -->
	                                </select>
	                                </div>
                                </div>
                                
                                <div class="col-sm-6">
	                                <label  class="col-sm-3 control-label" for="orderNumber">排序号*</label>
	                                <div class="col-sm-9">
	                                 <input type="text" id="Eorder_number" name="orderNumber" class="form-control"
	                                       placeholder="请输入排序号" data-rule="排序号:required;orderNumber;remote(/dirClassify/CheckOrderNumber)">
                            		</div>
                            	</div>
                            	</div>
                            </div>
                            
                            
                            <div class="form-group">
			                    <div class="row">
			                        <!-- <div class="col-sm-6" >
			                            <label  class="col-sm-3 control-label"  for="icon">目录类别*</label>
			                            <div class="col-sm-9">
			                                <select id="Eclassify_type" name="classifyType" class="form-control select2" style="width: 100%;" data-rule="选择类别:required">                         		  
                                			</select>
			                            </div>
			                        </div> -->
			                        <div class="col-sm-6">
			                            <label  class="col-sm-3 control-label" for="EnationalCode">国家库</label>
			                            <div class="col-sm-9">
                        	
											<input type="text" id="EnationalCode"  class="form-control"
					                         placeholder="">
					                        <input type="hidden" id="EdictNationalCode" name="nationalCode">
					                        <div class="menu-wrap">
					                            <div id="EmenuNationalContent" class="menuContent" style="display:none;">
					                                <ul id="EtreeNational" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
					                            </div>
					                        </div>		                            
				                        </div>
			                        </div>
			                        
			                        <div class="col-sm-6 ">
		                                <label class="col-sm-3 control-label" for="leadDeptName">牵头部门</label>
		                                <div class="col-sm-9">
		                                    <%--<input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">--%>
		                                    <input type="text" id="EleadDeptName" required="required"
		                                           data-parsley-required-message="该项为必填" class="form-control">
		                                    <input type="hidden" id="EleadDeptId" name="leadDeptId">
		                                    <div class="menu-wrap">
		                                        <div id="menuContent23" class="menuContent" style="display:none;">
		                                            <ul id="treeDemo23" class="ztree"
		                                                style="margin-top:0;border: 1px solid #98b7a8;"></ul>
		                                        </div>
		                                    </div>
		                                   </div>
	                                   </div>
			                        
				                    </div>
				                </div>
                            
                            <div class="form-group" id="Edep">
                            	<div class="row">
                            	<div class="col-sm-6 ">
	                                <label class="col-sm-3 control-label" for="deptName">所属组织</label>
	                                <div class="col-sm-9">
	                                    <%--<input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">--%>
	                                    <input type="text" id="deptName" required="required"
	                                           data-parsley-required-message="该项为必填" class="form-control">
	                                    <input type="hidden" id="deptId" name="DeptId">
	                                    <div class="menu-wrap">
	                                        <div id="menuContent" class="menuContent" style="display:none;">
	                                            <ul id="treeDemo" class="ztree"
	                                                style="margin-top:0;border: 1px solid #98b7a8;"></ul>
	                                        </div>
	                                    </div>
	                                    </div>
	                                    </div>
                                   </div>
                            </div>
                            
                            
                            
                            <div class="form-group">
                            <div class="row">
                            <div class="col-sm-12">
                                <label class="col-sm-2 control-label" style="width:12.2%" for="apiDesc">目录描述:</label>
                                 <div class="col-sm-10"  style="width:87.8%">
                                <textarea class="form-control" 
									id="Eclassify_desc"  name="classifyDesc" data-rule=""></textarea>                                
                           		</div>
                            </div>
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
