<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/catalog/catalogue/catalogueShow.js"></script>
</head>
<body>
<section class="content">
    <div id="catalogueTableEditLayer">
        <div class="layer-boxs">
            <form class="form-horizontal" id="editForm" action="<%=basePath%>/catalog/doEdit">
                <div class="form-group">
                    <div class="row">
                        <input type="hidden" id="id" name="id" value="${id}">
                        <div class="col-sm-6">
                            <label for="classifyName" class="col-sm-3 control-label">信息资源分类 :</label>
                            <div class="col-sm-9">
                                <%--<input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">--%>
                                <input type="text" id="classifyName"  class="form-control" readonly>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="relDatasetName" class="col-sm-3 control-label">关联资源代码:</label>
                            <div class="col-sm-9">
                                <%--<input type="text" class="form-control" id="relDatasetCode" name="relDatasetCode" placeholder="关联资源代码" disabled>--%>
                                <input type="text" id="relDatasetName"  class="form-control" readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label">信息资源名称:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="datasetName" name="datasetName" readonly>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label">信息资源编码 :</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="datasetCode" name="datasetCode" readonly>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label">信息资源提供方:</label>
                            <div class="col-sm-9">
                                <%--<select class="form-control" data-rule="所属资源格式:required;" id="belongDeptType" name="belongDeptType"></select>--%>
                                <input type="text" class="form-control" id="belongDeptType" name="belongDeptType" readonly>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label">信息资源提供方代码:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="belongDeptName" readonly>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="formatCategory" class="col-sm-3 control-label">所属资源格式:</label>
                            <div class="col-sm-9">
                                <div class="col-sm-6" style="padding:0">
                                    <select class="form-control" id="formatCategory" name="ext.formatCategory" readonly>
                                    </select>
                                </div>
                                <div class="col-sm-6" style="padding:0">
                                    <select class="form-control" id="formatType" name="ext.formatType" readonly>
                                    </select>
                                </div>

                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label  class="col-sm-3 control-label" style="padding-left:0px">涉密标识：</label>
                            <div class="col-sm-9 control-label">
                                <div class="redio-box">
                                    <input type="radio" name="secretFlag" value="1" ><span></span>
                                </div>
                                <label style="display:inline-block">涉密</label>
                                <div class="redio-box">
                                    <input type="radio" name="secretFlag" value="0"><span></span>
                                </div>
                                <label style="display:inline-block">非涉密</label>
                                <span class="updatedate">更新周期：</span>
                                <select class="form-controls updateSelec" id="updateFrequency" name="updateFrequency" readonly>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <!--共享类型共享方式开始-->
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="shareType" class="col-sm-3 control-label">共享类型:</label>
                            <div class="col-sm-9">
                                <select class="form-control col-sm-4" id="shareType" name="shareType" style="width:25%" readonly>
                                </select>
                                <div id="shareMethodDiv">
                                    <label for="shareMethod" class="col-sm-4 control-label">共享方式:</label>
                                    <div class="col-sm-5" style="padding:0">
                                        <select class="form-control" id="shareMethod" name="shareMethod" readonly>
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
                            <label for="shareCondition" class="col-sm-3 control-label">共享条件:</label>
                            <div class="col-sm-9">
                                <textarea class="form-control" rows="2" id="shareCondition" name="shareCondition" readonly></textarea>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="openCondition" class="col-sm-3 control-label">开放条件:</label>
                            <div class="col-sm-9">
                                <textarea class="form-control" rows="2" id="openCondition" name="openCondition" placeholder="(最多256个汉字)" readonly></textarea>
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
                                <textarea class="form-control" rows="2" id="datasetDesc" name="datasetDesc" placeholder="(最多256个汉字)" readonly></textarea>
                                <%--<p><span class="pull-right">(最多256个汉字)</span></p>--%>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">信息项列表</label>
                    <div class="col-sm-10">
                        <%--<p>
                            <a class="btn btn-primary btn-flat pull-right" id="N_add_itemH"><i class="fa fa-plus"></i> 添加信息项</a>
                            <a class="btn btn-primary btn-flat pull-right" id="N_delete_itemH" style="margin-right: 10px;"><i class="fa fa-plus"></i> 删除</a>
                        </p>--%>
                    </div>
                </div>
                <div class="form-group " style="overflow-x: auto;min-height:200px;">
                    <table style="width:135%" class="table-striped">
                        <thead>
                        <tr class='table_title_tr'>
                            <th>信息项名称</th>
                            <th>类型</th>
                            <th>长度</th>
                            <th>责任部门</th>
                            <%--<th>所属信息资源</th>--%>
                            <%--<th>所属系统</th>--%>
                            <th>涉密标识</th>
                            <th>共享类型</th>
                            <th>共享条件</th>
                            <th>共享方式</th>
                            <th>是否向社会开放</th>
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
