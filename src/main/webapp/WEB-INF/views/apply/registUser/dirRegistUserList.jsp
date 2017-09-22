<%--
  Created by IntelliJ IDEA.
  User: Zhangm
  Date: 2017/9/12
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=basePath%>/plugins/layui/layui.all.js"></script>
    <script src="<%=basePath%>/js/custom/mock.min.js"></script>
    <script src="<%=basePath%>/js/system/menu/menuList.js"></script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>
    <div class="content-wrapper">
        <section class="content" id="userRegBox">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <form action="http://localhost:8123/Dataset_getDatasetList" class="form-inline" method="post">
                            <div class="box-header">
                                <div class="input-group">
                                    用户注册申请
                                </div>
                                <div class="input-group pull-right">
                                    <input class="form-control" id="editSearch" name="searchEdit" placeholder="资源名称"
                                           type="text">
                                    <div class="input-group-btn">
                                        <button class="btn btn-primary btn-flat" id="queryBtnEdit" type="button">
                                            <i class="fa fa-search">
                                            </i> 搜索
                                        </button>
                                    </div>
                                    </input>
                                </div>
                                <div class="input-group  pull-right">
                                    <select class="form-control" id="ugChangeSearch">
                                        <option value="login_name" selected>用户名</option>
                                        <option value="real_name">姓名</option>
                                    </select>
                                </div>
                                <div class="input-group  pull-right mgr15">
                                    <select class="form-control" id="ugChangeSel" onchange="ugChange(this)">
                                        <option value="100">全部</option>
                                        <option value="0">申请中</option>
                                        <option value="1">已通过</option>
                                        <option value="2">已拒绝</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                        <div class="box-body table-responsive no-padding" id="userregisterBox">
                            <!-- 表格 -->
                            <table class="layui-table" id="userregisterTable" lay-even="" lay-skin="row"></table>
                            <!-- 表格 end-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<script type="text/javascript">
    /**
     * [ugChange 选择获取值]
     * @return {[type]} [description]
     */
    function ugChange(d) {
        var val = $(d).children('option:selected').val();
        $("#userregisterBox").html('<table class="layui-table" id="userregisterTable" lay-even="" lay-skin="row"></table>');
        if (val === "100") {
            getData()
        } else {
            getData(val)
        }
    }
    function getuserregisterTable(dd) {
        $("#userRegBox .box-body").html(' <table class="layui-table" id="userregisterTable" lay-even="" lay-skin="row"></table>');
        $('#userregisterTable').bootstrapTable({
            pagination: true, //分页
            pageSize: 15,
            columns: [
                {
                    field: 'id', title: '序号', width: '5%', align: 'center', formatter: function (value, row, index) {
                    return index + 1;
                }
                },
                {field: 'realName', title: '姓名', width: '10%'},
                {field: 'loginName', title: '用户名', width: '10%'},
                {field: 'phone', title: '电话号码'},
                {field: 'belongDep', title: '所属组织'},
                {field: 'stateName', title: '状态', width: '8%'},
                {
                    field: 'id',
                    title: '操作',
                    width: '15%',
                    valign: 'middle',
                    sortable: false,
                    formatter: function (value, row, idx) {
                        var editBtn = [];
                        if (row.status === "0") {
                            editBtn = ["<a class='btn btn-success btn-flat btn-xs' href='#' onclick='javascript:userReg(\"" + value + "\",true)'><i class='fa fa-check'>&#160;</i>同意</a>&#160;", "<a class='btn btn-default btn-flat btn-xs' href='#' onclick='javascript:userReg(\"" + value + "\",false)'><i class='fa fa-close'>&#160;</i>拒绝</a>"];
                        }
                        if (row.status === "1" || row.status === "2") {
                            editBtn = ["<a class='btn btn-danger btn-flat btn-xs' href='#' onclick='javascript:userReg(\"" + value + "\",0)'><i class='fa fa-check'>&#160;</i>删除</a>&#160;"];
                        }
                        return editBtn.join('');
                    }
                }
            ],
            data: dd
//          data: Mock.mock({ 'list|22': [{ 'a|+1': 1, 'b|1': '@CNAME', 'c|1': '@NAME', 'd|1': /(13|14|15|17|18)\d{9}/, 'e|1': ['办公室', '酒店', '学校', '会展'], 'f|1':isStatus, 'g|+1': 1 }] }).list
        });
    }
    /**
     * [userReg 同意/拒绝操作]
     * @param  {[type]} v [description]
     * @param  {[type]} b [description]
     * @return {[type]}   [description]
     */
    function userReg(v, b) {
        if (v && b === true) {
            cmf('同意注册', function () {
                console.log(v, b)
                putStatus({"id": v, "opration": true}, function (dd) {
                    layer.msg(dd.msg || '未知信息', {icon: 1})
                    getData('1')
                })
            }, '操作');

        }
        if (v && b === false) {
            cmf('拒绝注册', function () {
                console.log(v, b)
                putStatus({"id": v, "opration": false}, function (dd) {
                    layer.msg(dd.msg || '未知信息', {icon: 1})
                    getData('2')
                })
            }, '操作');
        }
        if (v && b === 0) {
            cmf('删除操作', function () {
                $.ajax({
                    url: '/dir/dirRegistUser/delete?id=' + v || '',
                    contentType: "application/json; charset=utf-8",
                    type: 'DELETE',
                    success: function (dd) {
                        layer.msg(dd.msg || '未知信息', {icon: 1})
                        getData()
                        $('#ugChangeSel').eq(0).attr('selected', true)
                    }
                });
            }, '删除操作');
            console.log(v, b)
        }
    }

    function cmf(tit, fn, v) {
        var v = v || '';
        layer.confirm('您确认要' + tit + '吗？', {
            btn: ['是', '否'] //按钮
        }, function () {
            fn()
        }, function () {
            layer.msg('取消' + v, {icon: 1});
        });
    }
</script>
<script>
    //默认show
    getData()
    /**
     * 获取表格数据
     * @param num 类型
     */
    function getData(num) {
        var url = "/dir/dirRegistUser/list";
        if (num) {
            url = "/dir/dirRegistUser/list?status=" + num;
        }
        $.get(url, function (d) {
            if (d.rows.length) {
                getuserregisterTable(d.rows)
            }
        })
    }

    /**
     *  同意拒绝操作
     * @param parms
     * @param fn
     */
    function putStatus(parms, fn) {
        $.ajax({
            url: '/dir/dirRegistUser/doEdit',
            contentType: "application/json; charset=utf-8",
            type: 'PUT',
            data: JSON.stringify(parms),
            success: function (d) {
                fn(d)
            }
        });
    }

    $("#queryBtnEdit").on("click", function () {
        var val = $('#ugChangeSel').children('option:selected').val();//选择类型
        var soKey = $('#ugChangeSearch').children('option:selected').val();//搜索下拉
        var serVal = $("#editSearch").val();//搜索框
        var url = "/dir/dirRegistUser/list";
        if (serVal != "") {
            if (val === "100") {
                url = url + '?' + soKey + '=' + serVal;
            } else {
                url = url + "?status=" + val + '&' + soKey + '=' + serVal;
            }
        }
        else {
            if (val != "100") {
                url = url + "?status=" + val
            }
        }
        $.get(url, function (d) {
            if (d.rows.length) {
                getuserregisterTable(d.rows)
            } else {
                getuserregisterTable(d.rows)
            }
        })
    })
</script>
</body>
</html>
