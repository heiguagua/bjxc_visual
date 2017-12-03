<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <%@include file="/WEB-INF/views/common/head.jsp" %>
  <style>
    .pull-left{
      margin-right: 20px;
    }
  </style>
</head>

<section class="content">
  <div>
      <a class="btn btn-primary btn-flat dropdown-toggle btn-myself pull-left" href="/catalog/download" >含有目录分类的excel模板下载</a>
      <a class="btn btn-primary btn-flat dropdown-toggle  btn-myself pull-left" href="/catalog/downloadWithoutDir" >没有目录分类的excel模板下载</a>
  </div>
</section>

</body>

</html>
