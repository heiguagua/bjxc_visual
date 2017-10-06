<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

    <script src="<%=basePath%>/js/apply/data/dirDataApplyEdit.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
    <div>
        <div class="row form-group">
            <div class="col-sm-4">
                <label class="control-label">申请人：</label>
                <span id="applicant">-</span>
            </div>

            <div class="col-sm-4">
                <label class="control-label">所属组织：</label>
                <span id="deptName">-</span>
            </div>
            <div class="col-sm-4">
                <label class="control-label">期望使用次数：</label>
                <span id="limitVisitCnt">-</span>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-sm-12">
                <label class="control-label">期望使用时限：</label>
                <span id="limitVisitDatePeriod">-</span>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-sm-12">
                <label class="control-label">申请理由：</label>
                <span id="applyInfo">-</span>
            </div>
        </div>
        <form role="form" data-validator-option="{theme:'bootstrap', timely:2, stopOnError:true}"
              method="post" action="<%=basePath%>/dirDataApply/doEdit">
            <input type="hidden" id="dirDataApplyId" value="${id}" name="id"/>
            <div class="toolbar">
                <div class="form-inline">
                    <label class="control-label">审核状态：</label>
                    <select class="form-control" name="status" style="width: 150px">
                        <option value="0">请选择</option>
                        <option value="1">同意</option>
                        <option value="2">拒绝</option>
                    </select>
                </div>
            </div>
            <div class="box-body table-responsive no-padding" style="margin-top:-15px">
                <table id="dirDataItemApplyTableId" class="table table-hover">
                </table>
            </div>
            <div class="form-inline form-group">
                <label class="control-label col-sm-2" style="text-align: left;padding-left:0">批复使用时间：</label>
                <input id="auditVisitDatePeriod" type="text" name="auditVisitDatePeriod" class="form-control date" readonly
                       placeholder="批复使用开始时间~批复使用结束时间" style="width: 320px;">
            </div>
            <div class="form-inline form-group">
                <label class="control-label col-sm-2" style="text-align: left;padding-left:0">批复使用次数：</label>
                <input id="auditVisitCnt" type="text" name="auditVisitCnt" class="form-control" placeholder=""
                       style="width: 120px;">
                <span>次</span>
            </div>
            <div class="form-inline form-group">
                <label class="control-label col-sm-2" style="text-align: left;padding-left:0">意见说明：</label>
                <textarea id="auditOpinion" name="auditOpinion" class="form-control" style="width: 500px;"></textarea>
            </div>
            <div class="box-footer">
                <input type="submit" style="display:none;"/>
            </div>
        </form>
    </div>
</section><!-- /.content -->

</body>
</html>
