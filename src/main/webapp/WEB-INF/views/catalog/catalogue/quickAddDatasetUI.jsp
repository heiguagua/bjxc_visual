<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/plugins/treeview/bootstrap-treeview.js"></script>
    <script src="<%=basePath%>/plugins/treeview/data.treeview.js"></script>
    <script src="<%=basePath%>/js/catalog/catalogue/quickAddDatasetUI.js"></script>
    <style type="text/css">
        .menu-wrap{
            position:relative;

        }
        .menu-wrap .menuContent{
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
<section class="content">
    <div id="catalogueTableEditLayer">
        <div class="layer-boxs">
            <form class="form-horizontal" id="addForm" method="post" action="<%=basePath%>/catalog/quickAddDataset">
                <button id="deploy_dataset" class="btn btn-primary btn-flat pull-left" data-toggle="modal" data-target="#myModal">
                    配置数据集
                </button>
                <div class="form-group">
                    <label  class="col-sm-3 control-label">&#160;</label>
                    <div class="col-sm-9">
                        <p class="alertx alert-infox" role="alert">注：有缺失的数据，请联系相关管理员进行配置 * 为必填项</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="classifyName" class="col-sm-2 control-label">信息资源分类 *</label>
                    <div class="col-sm-10">
                        <%--<input type="text" class="form-control" id="i_dir_name" name="dir_codes" placeholder="信息资源名称">--%>
                        <input type="text" id="classifyName" data-rule="信息资源分类:required;" class="form-control">
                        <input type="hidden" id="classifyId" name="classifyId">
                        <div class="menu-wrap">
                            <div id="menuContent" class="menuContent" style="display:none;">
                                <ul id="treeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">信息资源名称 *</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="datasetName" name="datasetName" disabled>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">信息资源提供方</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="resourceProvider" placeholder="信息资源提供方" disabled>
                        <input type="hidden" id="belongDepId" name="belongDepId">
                    </div>
                    <label  class="col-sm-2 control-label">信息资源提供方代码</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="resourceProviderCode" placeholder="信息资源提供方代码"  disabled>
                    </div>
                </div>
                <div class="form-group">
                    <label for="datasetDesc" class="col-sm-2 control-label">信息资源摘要*</label>
                    <div class="col-sm-4">
                        <!-- <input type="text" class="form-control" id="sourceSelect" placeholder="信息资源摘要*" value="无"> -->
                        <textarea class="form-control" rows="3" id="datasetDesc" name="datasetDesc">无</textarea>
                        <p><span class="pull-right">(最多256个汉字)</span></p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="resourceFormat" class="col-sm-2 control-label">信息资源格式 *</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="resourceFormat" name="storageMedium">
                            <%--<option value="">--请选择--</option>
                            <option value="1" name="电子文件">电子文件</option>
                            <option value="2" name="电子表格">电子表格</option>
                            <option value="3" name="数据库类">数据库类</option>
                            <option value="4" name="图形图像类">图形图像类</option>
                            <option value="5" name="流媒体类">流媒体类</option>
                            <option value="6" name="自描述格式">自描述格式</option>--%>
                        </select>
                    </div>
                </div>
                <!-- 条件筛选 -->
                <div class="form-group">
                    <label for="shareType" class="col-sm-2 control-label">共享类型*</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="shareType" name="shareType">
                            <%--<option value="2">--请选择--</option>
                            <option value="1" name="有条件共享">有条件共享</option>
                            <option value="2" name="无条件共享">无条件共享</option>
                            <option value="3" name="不予共享">不予共享</option>--%>
                        </select>
                    </div>
                </div>
                <!-- 有条件共享 包含无条件共享和不予共享 -->
                <!-- 无条件共享 -->
                <div class="form-group shareType2">
                    <label for="shareMethod" class="col-sm-2 control-label">共享方式*</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="shareMethod" name="shareMethod">
                            <%--<option value="">--请选择--</option>
                            <option value="1" name="系统对接">系统对接</option>
                            <option value="5" name="共享平台">共享平台</option>
                            <option value="6" name="邮件">邮件</option>
                            <option value="7" name="拷盘">拷盘</option>
                            <option value="8" name="介质交换">介质交换</option>
                            <option value="9" name="其他">其他</option>--%>
                        </select>
                    </div>
                </div>
                <div class="form-group shareType2">
                    <label for="shareMethodDesc" class="col-sm-2 control-label">共享方式说明</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="shareMethodDesc" name="shareMethodDesc" placeholder="说明">
                    </div>
                </div>
                <!-- 无条件共享 end-->
                <!-- 不予共享 -->
                <div class="form-group shareType3" id="shareConditionDiv">
                    <label for="shareCondition" class="col-sm-2 control-label">共享条件 *</label>
                    <div class="col-sm-9">
                        <textarea class="form-control" rows="3" id="shareCondition" name="shareCondition"></textarea>
                    </div>
                </div>
                <!-- 不予共享 end-->
                <!-- 条件筛选 end-->
                <div class="form-group">
                    <label  class="col-sm-2 control-label">是否向社会开放 *</label>
                    <div class="col-sm-4">
                    <span class="radio-inline">
	                      <input type="radio" name="isOpen"  value="0" checked>否
	                    </span>
                    <span class="radio-inline">
	                      <input type="radio" name="isOpen"  value="1">是
	                    </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="openCondition" class="col-sm-2 control-label">开放条件</label>
                    <div class="col-sm-4">
                        <textarea class="form-control" rows="3" id="openCondition" name="openCondition">无</textarea>
                        <!-- <input type="text" class="form-control" id="sourceSelect" placeholder="开放条件" value="无"> -->
                        <p><span class="pull-right">(最多256个汉字)</span></p>
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">更新周期 *</label>
                    <div class="col-sm-4">
                        <span class="radio-inline"><input type="radio" name="updateFrequency" value="1">每年</span>
                        <span class="radio-inline"><input type="radio" name="updateFrequency" value="3">每季度</span>
                        <span class="radio-inline"><input type="radio" name="updateFrequency" value="4">每月</span>
                        <span class="radio-inline"><input type="radio" name="updateFrequency" value="6">每周</span>
                        <span class="radio-inline"><input type="radio" name="updateFrequency" value="7" checked>每日</span>
                        <span class="radio-inline"><input type="radio" name="updateFrequency" value="9">实时</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="relDatasetCode" class="col-sm-2 control-label">关联资源代码</label>
                    <div class="col-sm-4">
                        <%--<input type="text" class="form-control" id="relDatasetCode" name="relDatasetCode" placeholder="关联资源代码" disabled>--%>
                            <input type="text" id="relDatasetName" required="required" data-parsley-required-message="该项为必填" class="form-control">
                            <input type="hidden" id="relDatasetCode" name="relDatasetCode">
                            <div class="menu-wrap">
                                <div id="relMenuContent" class="menuContent" style="display:none;">
                                    <ul id="relTreeDemo" class="ztree" style="margin-top:0;border: 1px solid #98b7a8;"></ul>
                                </div>
                            </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">信息项列表</label>
                    <div class="col-sm-10">
                        <%--<p>
                            <a class="btn btn-primary btn-flat pull-right" id="add_item"><i class="fa fa-plus"></i> 添加信息项</a>
                        </p>--%>
                    </div>
                </div>
                <div class="form-group " style="overflow-x: auto;min-height:200px;">
                    <table style="width:140%">
                        <thead>
                        <tr>
                            <th>信息项名称</th>
                            <th>类型</th>
                            <th>长度</th>
                            <th>责任部门</th>
                            <th>共享类型</th>
                            <th>共享条件</th>
                            <th>共享方式</th>
                            <th>是否向社会开放</th>
                            <th>开放条件</th>
                            <th>存储介质</th>
                            <th>存储位置</th>
                            <th>更新周期</th>
                            <th>备注</th>
                            <th width="10%">操作</th>
                        </tr>
                        </thead>
                        <tbody id="dataitemList">

                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    </div>

    <%@include file="./selectDatasetModal.jsp" %>
</section><!-- /.content -->

</body>
</html>
