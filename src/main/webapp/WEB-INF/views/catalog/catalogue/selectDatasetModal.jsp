<%--
  Created by IntelliJ IDEA.
  User: lianrongfa
  Date: 2017/9/20
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=basePath%>/plugins/treeview/bootstrap-treeview.js"></script>
    <script src="<%=basePath%>/plugins/treeview/data.treeview.js"></script>
</head>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 1000px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    选择数据集
                </h4>
            </div>
            <div class="modal-body" style="height: 250px;padding: 0px 1px 2px 1px;">
                <style>
                    .col_container{
                        border: solid #C3C3C3 1px;
                        height: 100%;
                        border-left: none;
                        padding: 0px;
                        padding-top: 35px;
                    }
                    .col_container:first-child{
                        border-left: solid #C3C3C3 1px;
                    }
                    .header_title{
                        background: #E0DEDE;
                        text-align: center;
                        padding: 5px 0px;
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        right: 0px;
                        width: 100%;
                    }
                    .content_scroll_item{
                        max-height: 100%;
                        overflow: auto;
                    }
                </style>
                <div class="col-md-12" style="/*height: 100%;*/padding: 0px;">
                    <div class="col-md-4 col_container">
                        <div class="header_title">组织</div>
                        <div class="content_scroll_item list-group">
                            <div id="group_tree" class=""></div>
                        </div>
                    </div>
                    <div class="col-md-4 col_container">
                        <div class="header_title">业务</div>
                        <div class="content_scroll_item list-group">
                            <div id="bus_tree" class=""></div>
                        </div>
                    </div>
                    <div class="col-md-4 col_container">
                        <div class="header_title">信息资源</div>
                        <div id="dataset_item_container" class="content_scroll_item list-group">
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    确认
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
