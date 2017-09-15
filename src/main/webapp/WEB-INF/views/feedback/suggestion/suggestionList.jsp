<%--
  Created by IntelliJ IDEA.
  User: GongJun
  Date: 2017/9/12
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/js/feedback/suggestion/suggestionList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <form action="http://localhost:8123/Dataset_getDatasetList" class="form-inline" method="post">
                            <div class="box-header">
                                <div class="input-group">
                                    用户咨询
                                </div>
                                <!--  <div class="input-group pull-right">
                                    <input class="form-control" id="editSearch" name="searchEdit" placeholder="资源名称" type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat" id="queryBtnEdit" type="button">
                                            <i class="fa fa-search">
                                                    </i> 搜索
                                        </button>
                                    </div>
                                    </input>
                                </div> -->
                            </div>
                        </form>
                        <div class="box-body table-responsive no-padding">
                            <!-- 表格 -->
                            <table class="layui-table" id="usersuggestTable" lay-even="" lay-skin="row">
                            </table>
                            <!-- 表格 end-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div><!-- /.content-wrapper -->

    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    <div class="control-sidebar-bg"></div>
</div>
<script type="text/javascript">
    $('#usersuggestTable').bootstrapTable({
        pagination: true, //分页
        columns: [
            { field: 'a', title: '序号', width: '5%' },
            { field: 'b', title: '标题' },
            { field: 'c', title: '内容' },
            { field: 'd', title: '邮箱', width: '15%' },
            { field: 'e', title: '联系电话', width: '10%' },
            { field: 'f', title: '提交时间', width: '10%' },
            {
                field: 'g',
                title: '操作',
                width: '10%',
                align: 'center',
                valign: 'middle',
                sortable: false,
                formatter: function(value) {
                    var editBtn = [
                        "<a class='btn btn-default btn-flat btn-xs' href='#' onclick='javascript:userSug(\"" + value + "\")'><i class='fa fa-close'>&#160;</i>删除</a>"
                    ].join('');
                    return editBtn;
                }
            }
        ],
        data: Mock.mock({ 'list|22': [{ 'a|+1': 1, 'b|1': '@CTITLE', 'c|1': '@CSENTENCE','d|1':'@EMAIL',  'e|1': /(13|14|15|17|18)\d{9}/, 'f|1': ['申请中', '等待申请'], 'g|+1': 1 }] }).list
    });
    /**
     * [userReg 同意/拒绝操作]
     * @param  {[type]} v [description]
     * @param  {[type]} b [description]
     * @return {[type]}   [description]
     */
    function userSug(v) {
        cmf('删除', v);
        console.log(v)
    }

    function cmf(tit, v) {
        layer.confirm('您确认要' + tit + '吗？', {
            btn: ['是', '否'] //按钮
        }, function() {
            layer.msg(tit + v, { icon: 1 });
        }, function() {
            layer.msg('取消' + v, { icon: 1 });
        });
    }
</script>
</body>
</html>
