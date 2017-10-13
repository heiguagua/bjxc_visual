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
                    配置数据项
                </h4>

            </div>
            <div class="modal-body" style="height: 380px;padding-bottom: 54px;">
                <style>
                    .col_container {
                        border: solid #C3C3C3 1px;
                        height: 100%;
                        border-left: none;
                        padding: 0px;
                        padding-top: 35px;
                    }

                    .col_container:first-child {
                        border-left: solid #C3C3C3 1px;
                    }

                    .header_title {
                        background: #E0DEDE;
                        text-align: center;
                        padding: 5px 0px;
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        right: 0px;
                        width: 100%;
                    }

                    .content_scroll_item {
                        max-height: 100%;
                        overflow: auto;
                    }
                </style>
                <p style="margin-bottom:15px;">选择数据项</p>
                <div class="col-md-12" style="/*height: 100%;*/padding: 0px;">
                    <div class="col-md-3 col_container">
                        <div class="header_title">选择组织</div>
                        <div class="content_scroll_item list-group">
                            <div id="group_tree" class=""></div>
                        </div>
                    </div>
                    <div class="col-md-3 col_container">
                        <div class="header_title">选择数据库</div>
                        <div class="content_scroll_item list-group">
                            <div id="bus_tree" class="" style="text-align:center">
                                <img class="selec_img" alt="" src="<%=basePath%>/images/addimg/orgcontainer.png">
                                <p class="img_p">请先选择数据库</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col_container">
                        <div class="header_title">选择表</div>
                        <div id="dataset_item_container" class="content_scroll_item list-group">

                            <div style="text-align:center">
                                <img class="selec_img" alt="" src="<%=basePath%>/images/addimg/dbmysql.png">
                                <p class="img_p">请先选择表</p>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-3 col_container">
                        <div class="header_title">选择字段</div>
                        <div id="field_tree" class="content_scroll_item list-group">
                            <div style="text-align:center">
                                <img class="selec_img" alt="" src="<%=basePath%>/images/addimg/predir.png">
                                <p class="img_p">请先选择字段</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-12">
                    <button type="button" id="add_to_container" class="btn pull-right">
                        添加
                    </button>
                </div>
                <div id="fieldTexts" class="col-md-12">
                    <h5>已选择字段列表</h5>
                    <style>
                        * {
                            margin: 0;
                            padding: 0;
                            list-style-type: none;
                        }

                        a, img {
                            border: 0;
                        }

                        .words-split {
                            vertical-align: middle;
                        }

                        .lbl-input {
                            display: inline-block;
                            width: 120px;
                            height: 26px;
                            line-height: 26px;
                            min-height: 26px;
                            text-indent: 1em;
                            border: 1px solid #ddd;
                            border-radius: 5px;
                            color: #fff;
                            vertical-align: middle;
                        }

                        .words-split a {
                            display: inline-block;
                            padding: 0 20px 0 8px;
                            position: relative;
                            margin: 0 4px;
                        }

                        .words-split a em {
                            display: none;
                            width: 16px;
                            height: 100%;
                            position: absolute;
                            background: #f60;
                            right: 0;
                            top: 0;
                        }

                        .words-split a em:after {
                            content: "x";
                            color: #fff;
                            font: bold 20px 'Microsoft Yahei';
                        }

                        .words-split a:hover em {
                            display: block;
                        }

                        a.words-split-add {
                            display: inline-block;
                            font: bold 20px 'Microsoft Yahei';
                            color: #4197f4
                        }

                        .fm-button {
                            display: inline-block;
                            text-align: center;
                            color: #fff;
                            height: 28px;
                            line-height: 28px;
                            font-size: 14px;
                            padding: 0 1em;
                            border-radius: 3px;
                            opacity: .9;
                            filter: alpha(opacity=90);
                            background: #4197f4;
                        }

                        a {
                            text-decoration: none;
                        }
                    </style>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default btn_quxiao" data-dismiss="modal">取消
                </button>
                <button type="button" id="field_add" class="btn btn-primary btn_blueinsure">
                    确认
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
