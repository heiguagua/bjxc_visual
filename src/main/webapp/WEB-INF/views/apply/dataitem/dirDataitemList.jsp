<%--
  Created by IntelliJ IDEA.
  User: Zhangm
  Date: 2017/9/15
  Time: 15:50
  To change this template use File | Settings | File Templates.
  Update：2017-09-18 12:29:37 by Liuhb
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>
    <script src="<%=context_path%>/plugins/layui/layui.all.js"></script>
    <script src="<%=context_path%>/js/custom/mock.min.js"></script>
    <script src="<%=context_path%>/js/system/menu/menuList.js"></script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/menu.jsp" %>
    <div class="content-wrapper">
        <section class="content" id="hdtMg">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <form action="http://localhost:8123/Dataset_getDatasetList" class="form-inline" method="post">
                            <div class="box-header">
                                <div class="input-group">
                                    共享审核管理
                                </div>
                            </div>
                        </form>
                        <div class="box-body table-responsive ">
                            <!-- 表格 -->
                            <table class="layui-table" id="homeauditTable" lay-even="" lay-skin="row">
                            </table>
                            <!-- 表格 end-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="content" id="hdtMg-dd" class="hidden">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <form action="#" class="form-inline" method="post">
                            <div class="box-header">
                                <div class="input-group">
                                    <a class="btn btn-primary  btn-flat" onclick="javascript:retdcView()"> <i
                                            class="fa fa-reply">&#160;</i>返回上一页</a>
                                </div>
                                <div class="input-group">
                                    <ol class="breadcrumb mgb0">
                                        <li><a href="#" onclick="javascript:retdcView()">共享审核消息列表</a></li>
                                        <li class="active">信息项列表</li>
                                    </ol>
                                </div>
                                <div class="input-group pull-right">
                                    <a class="btn btn-primary  btn-flat" id="applyTo"> <i class="fa fa-plus">&#160;</i>审核</a>
                                </div>
                                <div class="input-group  pull-right">
                                    <select class="form-control" onchange="selApply(this)">
                                        <option value="1" selected>全部</option>
                                        <option value="2">待审核</option>
                                        <option value="3">同意</option>
                                        <option value="4">拒绝</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                        <div class="box-body table-responsive no-padding">
                            <!-- 表格 -->
                            <table class="layui-table" id="homeauditInfoTable" lay-even="" lay-skin="row">
                            </table>
                            <!-- 表格 end-->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- 弹窗 -->
        <div id="homeauditLayer" class="f-dn">
            <div class="layer-boxs">
                <form class="form-horizontal">
                    <div class="form-group">
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">目录名称:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">责任部门:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">共享类型:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">共享条件说明:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">开放条件:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">储存介质:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">储存位置:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">共享方式:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">共享条件说明:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">更新周期:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">是否开放:</label>
                        <div class="col-sm-7">
                            无
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div id="homeauditApplyLayer" class="f-dn">
            <div class="layer-boxs">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">申请通过:</label>
                        <div class="col-sm-7">
                             <span class="radio-inline">
	                      <input type="radio" name="halRO" id="halRO" value="true">通过
	                    </span>
                            <span class="radio-inline">
	                      <input type="radio" name="halRO" id="halR1" value="false" checked>不通过
	                    </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sourceSelect" class="col-sm-3 control-label">意见说明:</label>
                        <div class="col-sm-7">
                            <textarea class="form-control" rows="5" id="halTA">请输入角色描述</textarea>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- 弹窗 -->
    </div>
</div>
<script type="text/javascript">
    function loadDataItem() {
   var timestamp = Date.parse(new Date());
//   alert('/dir/dirDataitemApply/list?timestamp='+timestamp);
    $.get('/dir/dirDataitemApply/list?timestamp='+timestamp, function (dd) {
        $('#homeauditTable').bootstrapTable({
            pagination: true, //分页
            columns: [{
                field: 'stateName',
                title: '状态',
                width: '10%',
               /* formatter: function () {
                    return '待审核'
                }*/
            },
                {field: 'classifyName', title: '目录分类',alt:'classifyStructureName',  formatter: function (v,r) {
                    return '<a title="'+r.classifyStructureName+'">'+v+'</a>'
                }},
                {field: 'datasetName', title: '所属数据集', width: '15%'},
                {field: 'realName', title: '申请人', width: '10%'},
                {field: 'deptName', title: '申请人所属组织'},
                {field: 'applyDate', title: '提交时间'},
                {
                    field: 'datasetId',
                    title: '操作',
                    width: '10%',
                    align: 'center',
                    valign: 'middle',
                    sortable: false,
                    formatter: function (value,row) {
                        var editBtn = [
                            "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:startAudit(\""+value+"\",\""+row.realName+"\")'><i class='fa fa-edit'>&#160;</i>开始审核</a>"
                        ].join('');
                        return editBtn;
                    }
                }
            ],
            data: dd.rows
//          data: Mock.mock({ 'list|22': [{ 'a|1': [0, 1, 2, 3], 'b|1': '@CTITLE', 'c|1': '@CNAME', 'd|1': '@CSENTENCE', 'e|1': '@DATE @TIME', 'f|1': ['申请中', '等待申请'], 'g|+1': 1 }] }).list
        });
    })

    }
    loadDataItem();
    $('#hdtMg-dd').addClass('hidden');
    /**
     * [startAudit 点击查看]
     * @param  {[type]} v [description]
     * @return {[type]}   [description]
     */
    function startAudit(v,d) {
        sessionStorage.setItem("said",v)
        sessionStorage.setItem("sanm",d)
        dcViewTable(v,d);
        $('#hdtMg').addClass('hidden');
        $('#hdtMg .box-body').html('<table class="layui-table" id="homeauditTable" lay-even="" lay-skin="row"></table>');
        $('#hdtMg-dd').removeClass('hidden');
    }
    /**
     * [retdcView 返回]
     * @return {[type]} [description]
     */
    function retdcView() {
        loadDataItem();
        $('#hdtMg-dd').addClass('hidden');
        $('#hdtMg-dd .box-body').html('<table class="layui-table" id="homeauditInfoTable" lay-even="" lay-skin="row"></table>');
        $('#hdtMg').removeClass('hidden');
//        window.location.reload()
    }

    function dcViewTable(v,d) {
//        var ids=['116e177055c248079d9be21496d7b364','dac8d5f362924185a7ffa784aa5798c7'];
//        var v=ids[Math.floor(Math.random()*ids.length)];
//        console.log(v,d)
        $.get('/dir/dirDataitemApply/list/details?id='+v+'&realName='+ d,function(dd){
            getLlistDetails(dd);
        })
    }
    function getLlistDetails(dd){
         $('#homeauditInfoTable').bootstrapTable({
            pagination: true, //分页
            columns: [{
                field : 'checked',
                checkbox : true,
                width: '5%',
                formatter: function (alue, row, index) {
                    if (row.status != "0")
                        return {
                            disabled : true,//设置是否可用
                            checked : true//设置选中
                        };
                    return false;
                }
            },
                {
                    field: 'dataItemStateName', title: '状态', width: '10%'
                },
                {field: 'applyInfo', title: '信息项'},
                {field: 'sourceTypeName', title: '来源业务'},
//                {field: 'realName', title: '申请人', width: '5%'},
                {field: 'auditDate', title: '申请提交时间'},
                {field: 'auditOpinion', title: '审核意见'},
                {
                    field: 'd',
                    title: '操作',
                    width: '10%',
                    formatter: function (value) {
                        var editBtn = [
                            "<a class='btn btn-primary btn-flat btn-xs' href='#' onclick='javascript:ddAudit(\"" + value + "\")'><i class='fa fa-edit'>&#160;</i>详情</a>"
                        ].join('');
                        return editBtn;
                    }
                }
            ],
            data:dd.rows,
        });
        $("#applyTo").on('click',function(event){
//             event.preventDefault();
           var ckAll= $('#homeauditInfoTable') .bootstrapTable('getSelections'),arr=[];
            var total =$('#homeauditInfoTable').bootstrapTable('getOptions').totalRows;
//           console.log(ckAll,total)
            if(ckAll.length==0){
                layer.alert('请至少选择一条记录');
            }else{
                $.each(ckAll,function(i,d){
                    if(d&& d.status==="0")
                        arr.push(d.id)
                })
                //页面层
                var domHtml = $('#homeauditApplyLayer').html();
                layer.open({
                    title: '提交审核',
                    anim: 5,
                    type: 1,
                    top: 60,
                    offset: '30px',
                    area: ['600px','350px'], //宽高
                    content: $('#homeauditApplyLayer'),
                    btn: ['<i class="fa fa-save"></i> 提交', '<i class="fa fa-close"></i> 取消'],
                    btnAlign: 'r',
                    yes: function(index, layero) {
                        var ro=$("input[name='halRO']:checked").val();var halTA=$("#halTA").val();
//                    console.log(arr,ro,halTA)
                        doEditTo({"id":arr.join(","),"opration":ro,"auditOpinion":halTA},index)
                    },
                    btn2: function(index, layero) {
                        $('#homeauditApplyLayer').attr('style', '').html(domHtml)
                    },
                    cancel: function(index, layero) {
                        $("#homeauditApplyLayer").attr('style', '').html(domHtml)
                    }
                });
            }
        })
    }
    /**
     * [ddAudit 详情弹窗]
     * @param  {[type]} v [description]
     * @return {[type]}   [description]
     */
    function ddAudit(v) {
        openLayerNoBtn('#homeauditLayer', '信息项详情[' + v + ']', 650, 400, function (i, l) {
            console.log(i, l)
        });
    }
    function doEditTo(parms,index){
            $.ajax({
                url: '/dir/dirDataitemApply/doEdit',
                contentType: "application/json; charset=utf-8",
                type: 'PUT',
              data: JSON.stringify(parms),
            })
            .done(function(dd) {
                layer.msg(dd.msg || '未知信息');
                layer.close(index)
                selApply('3')
            });
    }

function selApply(that) {
        var v = sessionStorage.getItem("said"),d=sessionStorage.getItem("sanm");
   var val=$(that).val(),url="/dir/dirDataitemApply/list/details?id="+v+"&realName="+ d;

  if (val === "2"){
      url = url + "&status=0"
  }
  if (val === "3"){
      url = url + "&status=1"
  }
    if (val === "4"){
        url = url + "&status=2"
    }
    $.get(url,function (dd) {
        var strHtml = '<table class="layui-table" id="homeauditInfoTable" lay-even="" lay-skin="row"></table>';
        $("#hdtMg-dd .box-body").html(strHtml);
        getLlistDetails(dd);
    })

    console.log(val)
}
</script>
</body>
</html>
