<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/catalog/catalogue/catalogueEdit.js"></script>
</head>
<body>
<section class="content">
    <div id="catalogueTableEditLayer">
        <div class="layer-boxs">
            <form class="form-horizontal" id="editForm" action="<%=basePath%>/catalog/doEdit">
                <div class="form-group">
                    <div class="row">
                        <input type="hidden" id="id" name="id" value="${id}">
                        <div class="col-sm-12">
                            <label for="classifyName" class="col-sm-2 control-label" style="width:12.2%">目录分类<span class="redStar">*</span>:</label>
                            <div class="col-sm-10"  style="width:87.8%">
                                <input type="text" id="classifyName" data-rule="目录分类:required;" class="form-control"
                                       placeholder="点击下拉选择" readonly style="background-color: #FFFFFF">
                                <input type="hidden" id="classifyId" name="classifyIds">
                                <div class="menu-wrap">
                                    <div id="menuContent" class="menuContent" style="display:none;">
                                        <ul id="treeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%--<div class="col-sm-6">
                            <label for="classifyName" class="col-sm-3 control-label">目录分类 :</label>
                            <div class="col-sm-9">
                                &lt;%&ndash;<input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">&ndash;%&gt;
                                <input type="text" id="classifyName" data-rule="目录分类:required;" class="form-control"
                                       placeholder="点击下拉选择" readonly style="background-color: #FFFFFF">
                                <input type="hidden" id="classifyId" name="classifyIds">
                                <div class="menu-wrap">
                                    <div id="menuContent" class="menuContent" style="display:none;">
                                        <ul id="treeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="relDatasetCode" class="col-sm-3 control-label">关联资源分类:</label>
                            <div class="col-sm-9">
                                &lt;%&ndash;<input type="text" class="form-control" id="relDatasetCode" name="relDatasetCode" placeholder="关联资源分类" disabled>&ndash;%&gt;
                                <input type="text" id="relDatasetName"  class="form-control" placeholder="点击下拉选择" readonly style="background-color: #FFFFFF">
                                <input type="hidden" id="relDatasetCode" name="relDatasetCode">
                                <div class="menu-wrap">
                                    <div id="relMenuContent" class="menuContent" style="display:none;">
                                        <ul id="relTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>--%>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label">信息资源名称<span class="redStar">*</span>:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="datasetName" name="datasetName" data-rule="信息资源名称:required;">
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label">信息资源编码 :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="infoResourceCode" readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="classifyName" class="col-sm-3 control-label">信息资源提供方<span class="redStar">*</span>:</label>
                            <div class="col-sm-9">
                                <div class="col-sm-6" style="padding:0;padding-right:15px;">
                                    <input type="text" id="belongDeptTypeName" data-rule="信息资源提供方:required;" class="form-control"
                                           placeholder="点击下拉选择" readonly style="background-color: #FFFFFF">
                                    <input type="hidden" id="belongDeptType" name="belongDeptType">
                                    <div class="menu-wrap">
                                        <div id="belongDeptTypeMenuContent" class="menuContent" style="display:none;">
                                            <ul id="belongDeptTypeTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6" style="padding:0;padding-left:15px;">
                                    <input type="text" id="belongDeptName" name="belongDeptName" class="form-control" placeholder="请输入提供方信息" >
                                    <%--<input type="text" id="belongDeptName" data-rule="信息资源提供方:required;" class="form-control"
                                           placeholder="点击下拉选择" readonly style="background-color: #FFFFFF">
                                    <input type="hidden" id="belongDeptId" name="belongDeptId">
                                    <div class="menu-wrap">
                                        <div id="belongDeptMenuContent" class="menuContent" style="display:none;">
                                            <ul id="belongDeptTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                        </div>
                                    </div>--%>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label" style="padding-left: 0px;padding-right: 13px;">信息资源提供方代码<span class="redStar">*</span>:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="belongDeptNo" name="belongDeptNo" data-rule="信息资源提供方代码:required;">
                                <input type="hidden" id="chargeDeptId" name="chargeDeptId">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="relDatasetCode" class="col-sm-2 control-label" style="width:12.2%">关联资源分类:</label>
                            <div class="col-sm-10"  style="width:87.8%">
                                <input type="text" id="relDatasetName" class="form-control" placeholder="点击下拉选择" readonly style="background-color: #FFFFFF">
                                <input type="hidden" id="relDatasetCode" name="relDatasetCode">
                                <div class="menu-wrap">
                                    <div id="relMenuContent" class="menuContent" style="display:none;">
                                        <ul id="relTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%--<div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="relDatasetCode" class="col-sm-3 control-label">关联资源分类:</label>
                            <div class="col-sm-9">
                                &lt;%&ndash;<input type="text" class="form-control" id="relDatasetCode" name="relDatasetCode" placeholder="关联资源分类" disabled>&ndash;%&gt;
                                <input type="text" id="relDatasetName" required="required" data-parsley-required-message="该项为必填" class="form-control">
                                <input type="hidden" id="relDatasetCode" name="relDatasetCode">
                                <div class="menu-wrap">
                                    <div id="relMenuContent" class="menuContent" style="display:none;">
                                        <ul id="relTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label" style="padding-left:0px">所属系统:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="system_name" placeholder="成都市公民信息管理系统">
                            </div>
                        </div>
                    </div>
                </div>--%>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="relDatasetCode" class="col-sm-3 control-label">所属资源格式<span class="redStar">*</span>:</label>
                            <div class="col-sm-9">
                                <div class="col-sm-6" style="padding:0;padding-right:15px;">
                                    <select class="form-control" data-rule="所属资源格式:required;" id="formatCategory" name="ext.formatCategory">
                                    </select>
                                </div>
                                <div class="col-sm-6" style="padding:0;padding-left:15px;">
                                    <select class="form-control" id="formatType" name="ext.formatType" data-rule="所属资源格式:required;">
                                    </select>
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label" style="padding-left:0px">涉密标识：</label>
                            <div class="col-sm-9 control-label" style="text-align:left">
                                <div class="redio-box">
                                    <input type="radio" name="secretFlag" value="1" ><span></span>
                                </div>
                                <label style="display:inline-block">涉密</label>
                                <div class="redio-box">
                                    <input type="radio" name="secretFlag" value="0"><span></span>
                                </div>
                                <label style="display:inline-block">非涉密</label>
                                <span class="updatedate">周期：</span>
                                <select class="form-controls updateSelec" id="updateFrequency" name="updateFrequency">
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <!--共享类型共享方式开始-->
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="shareType" class="col-sm-3 control-label">共享类型<span class="redStar">*</span>:</label>
                            <div class="col-sm-9">
                                <select class="form-control col-sm-4" id="shareType" name="shareType" style="width:25%" data-rule="共享类型:required;">
                                </select>
                                <div id="shareMethodDiv">
                                    <label for="shareMethod" class="col-sm-4 control-label">共享方式:</label>
                                    <div class="col-sm-5" style="padding:0">
                                        <select class="form-control" id="shareMethod" name="shareMethod">
                                        </select>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label">是否向社会开放:</label>
                            <div class="col-sm-9" style="padding-top: 7px;">
                                <div class="redio-box">
                                    <input type="radio" name="isOpen"  value="0" checked><span></span>
                                </div>
                                <label style="display:inline-block">否</label>
                                <div class="redio-box">
                                    <input type="radio" name="isOpen"  value="1"><span></span>

                                </div>
                                <label style="display:inline-block">是</label>
                            </div>
                        </div>
                    </div>
                </div>

                <!--共享条件和开放条件写在这里了  -->
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6 shareType3" id="shareConditionDiv">
                            <label for="shareCondition" class="col-sm-3 control-label" id="shareConditionLabel">共享条件:</label>
                            <div class="col-sm-9">
                                <textarea class="form-control" rows="2" id="shareCondition" name="shareCondition"></textarea>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="openCondition" class="col-sm-3 control-label">开放条件:</label>
                            <div class="col-sm-9">
                                <textarea class="form-control" rows="2" id="openCondition" name="openCondition" placeholder="(最多256个汉字)"></textarea>
                                <%--<p><span class="pull-right">(最多256个汉字)</span></p>--%>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-12">
                            <label for="datasetDesc" class="col-sm-2 control-label" style="width:12%">信息资源摘要:</label>
                            <div class="col-sm-10"  style="width:88%">
                                <textarea class="form-control" rows="2" id="datasetDesc" name="datasetDesc" placeholder="(最多256个汉字)"></textarea>
                                <%--<p><span class="pull-right">(最多256个汉字)</span></p>--%>
                            </div>
                        </div>
                    </div>
                </div>

                <%--大普查--%>
                <div class="checkh1">
                    <span class="checkspan">信息资源大普查</span>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-4">
                            <label  class="col-sm-6 control-label">数据存储总量:</label>
                            <div class="col-sm-6">
                                <input type="number" class="form-control" data-rule="integer(+0);" min="0" id="totalStorage" name="survey.totalStorage">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <label  class="col-sm-6 control-label">结构化信息记录总数:</label>
                            <div class="col-sm-6">
                                <input type="number" class="form-control" data-rule="integer(+0);" min="0" class="form-control" id="structureCount" name="survey.structureCount">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <label  class="col-sm-6 control-label">已共享的数据存储量:</label>
                            <div class="col-sm-6">
                                <input type="number" class="form-control" data-rule="integer(+0);" min="0" class="form-control" id="sharedStorage" name="survey.sharedStorage">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-4">
                            <label  class="col-sm-6 control-label">已共享的结构化记录数:</label>
                            <div class="col-sm-6">
                                <input type="number" class="form-control" data-rule="integer(+0);" min="0" class="form-control" id="sharedStructureCount" name="survey.sharedStructureCount">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <label  class="col-sm-6 control-label">已开放的数据存储量:</label>
                            <div class="col-sm-6">
                                <input type="number" class="form-control" data-rule="integer(+0);" min="0" class="form-control" id="openedStorage" name="survey.openedStorage">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <label  class="col-sm-6 control-label">已开放的结构化记录数:</label>
                            <div class="col-sm-6">
                                <input type="number" class="form-control" data-rule="integer(+0);" min="0" class="form-control" id="openedStructureCount" name="survey.openedStructureCount">
                            </div>
                        </div>
                    </div>
                </div>
                <%-- 信息大普查结束 --%>


                <div class="checkh1">
                    <span class="checkspan">信息项列表</span>
                </div>
                <div class="form-group">
                    <div class="col-sm-12">
                        <p>
                            <button type="button" class="btn btn-default btn-flat pull-right dropdown-toggle btn-myself"
                                    data-toggle="dropdown" id="N_add_itemH">
                                <img src="<%=basePath%>/images/userImg/addimg.png"/>添加信息项
                            </button>
                            <button type="button" class="btn btn-primary btn-flat pull-right dropdown-toggle btn-myself"
                                    data-toggle="dropdown" id="deleteItems" style="margin-right: 10px;">
                                <img src="<%=basePath%>/images/userImg/delImg.png"/>删除
                            </button>
                        </p>
                    </div>
                </div>
                <div class="form-group " style="overflow-x: auto;min-height:200px;">
                    <table style="width:135%" class="table-striped">
                        <thead>
                        <tr class='table_title_tr'>
                            <th id="firstTh"><input type="checkbox" id="selectAllItem"> 全选</th>
                            <th>信息项名称<span class="redStar">*</span></th>
                            <th>类型<span class="redStar">*</span></th>
                            <th>长度<span class="redStar">*</span></th>
                            <th style="width: 240px;">责任部门<span class="redStar">*</span></th>
                            <%--<th>所属信息资源</th>--%>
                            <%--<th>所属系统</th>--%>
                            <th>涉密标识</th>
                            <th>共享类型<span class="redStar">*</span></th>
                            <th>共享条件</th>
                            <th>共享方式</th>
                            <th>是否向社会开放<span class="redStar">*</span></th>
                            <th>开放条件</th>
                            <th>存储位置</th>
                            <th>更新周期</th>
                            <th>标签</th>
                        </tr>
                        </thead>
                        <tbody id="dataitemList">
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    </div>
</section><!-- /.content -->

</body>
</html>
