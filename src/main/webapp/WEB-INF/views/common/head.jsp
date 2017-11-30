<%@ page import="com.chinawiserv.dsp.base.entity.vo.system.SysUserVo" %>
<%@ page import="com.chinawiserv.dsp.base.common.SystemConst" %>
<%@ page import="org.springframework.util.StringUtils" %>
<%@ page import="org.springframework.util.ObjectUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    String regionCode = (String)request.getSession().getAttribute("regionCode");
    String context_path=request.getContextPath();
    SysUserVo loginUser = (SysUserVo)request.getSession().getAttribute(SystemConst.ME);
%>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${systemName}</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="<%=basePath%>/plugins/bootstrap/css/bootstrap.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="<%=basePath%>/plugins/font-awesome/css/font-awesome.min.css">
<!-- jquery-confirm -->
<link rel="stylesheet" href="<%=basePath%>/plugins/jquery-confirm/jquery-confirm.min.css">
<!-- nice-validator -->
<link rel="stylesheet" href="<%=basePath%>/plugins/nice-validator/jquery.validator.css">
<!-- Select2 -->
<link rel="stylesheet" href="<%=basePath%>/plugins/select2/select2.min.css">
<!-- daterange picker -->
<link rel="stylesheet" href="<%=basePath%>/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet" href="<%=basePath%>/plugins/iCheck/all.css">
<!-- bootstrap-table -->
<link rel="stylesheet" href="<%=basePath%>/plugins/bootstrap-table/bootstrap-table.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=basePath%>/app/css/AdminLTE.css">
<%-- <link rel="stylesheet" href="<%=basePath%>/app/css/skins/_all-skins.min.css"> --%>
<link rel="stylesheet" href="<%=basePath%>/app/css/skins/skin-blue.css">
<!-- zTree style -->
<link rel="stylesheet" href="<%=basePath%>/plugins/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<!-- slick style -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>/plugins/slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/plugins/slick/slick-theme.css"/>

<!-- 自定义 css -->
<link rel="stylesheet"  href="<%=basePath%>/plugins/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>/css/custom.css">
<link rel="stylesheet" href="<%=basePath%>/css/Rebaseadmin1.css">
<link rel="stylesheet" href="<%=basePath%>/css/catalogue.css">
<link rel="stylesheet" href="<%=basePath%>/css/release.css">

<%--boostrap-treeview--%>
<link rel="stylesheet" href="<%=basePath%>/plugins/treeview/bootstrap-treeview.css" type="text/css" />
<!-- REQUIRED JS SCRIPTS -->

<!--[if lt IE 9]>
<script src="<%=basePath%>/plugins/others/html5shiv.min.js"></script>
<script src="<%=basePath%>/plugins/others/respond.min.js"></script>
<![endif]-->

<!-- jQuery 2.2.3 -->
<script src="<%=basePath%>/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="<%=basePath%>/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck 1.0.1 -->
<script src="<%=basePath%>/plugins/iCheck/icheck.min.js"></script>
<!-- nice-validator -->
<script src="<%=basePath%>/plugins/nice-validator/jquery.validator.js"></script>
<script src="<%=basePath%>/plugins/nice-validator/local/zh-CN.js"></script>
<!--jquery-form  -->
<script src="<%=basePath%>/plugins/jquery-form/jquery.form.js"></script>
<!--jquery-confirm  -->
<script src="<%=basePath%>/plugins/jquery-confirm/jquery-confirm.min.js"></script>
<!-- Select2 -->
<script src="<%=basePath%>/plugins/select2/select2.full.min.js"></script>
<script src="<%=basePath%>/plugins/select2/i18n/zh-CN.js"></script>
<!-- date -->
<script src="<%=basePath%>/plugins/daterangepicker/moment.min.js"></script>
<script src="<%=basePath%>/plugins/daterangepicker/daterangepicker.js"></script>
<!-- jquery.cookie -->
<script src="<%=basePath%>/plugins/jquery.cookie.js"></script>

<!-- bootstrap-table -->
<script src="<%=basePath%>/plugins/bootstrap-table/bootstrap-table.js"></script>
<script src="<%=basePath%>/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<!-- layer -->
<script src="<%=basePath%>/plugins/layer/layer.js"></script>
<%-- <script src="<%=basePath%>/plugins/layui/layui.js"></script> --%>
<!-- ztree -->
<script src="<%=basePath%>/plugins/zTree/js/jquery.ztree.all.min.js"></script>

<!-- md5 -->
<script src="<%=basePath%>/plugins/jquery.md5.js"></script>

<!-- AdminLTE App -->
<script src="<%=basePath%>/app/js/app.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=basePath%>/app/js/demo.js"></script>


<!-- Include SmartWizard CSS -->
<link href="<%=basePath%>/plugins/smartWizard/css/smart_wizard.css" rel="stylesheet" type="text/css" />

<!-- Optional SmartWizard theme -->
<link href="<%=basePath%>/plugins/smartWizard/css/smart_wizard_theme_dots.css" rel="stylesheet" type="text/css" />

<script src="<%=basePath%>/plugins/smartWizard/js/jquery.smartWizard.js"></script>
<script src="<%=basePath%>/plugins/slick/slick.min.js"></script>
<!-- 自定义系统初始化话JS -->
<%--<script src="<%=basePath%>/plugins/layui/layui.all.js"></script>
<script src="<%=basePath%>/js/custom/mock.min.js"></script>--%>
<script src="<%=basePath%>/js/custom/global_custom.js"></script>
<script src="<%=basePath%>/js/custom/curdtools.js"></script>
<script src="<%=basePath%>/js/system/dict/dictSelect.js"></script>

<script type="text/javascript">
    var basePathJS = "<%=basePath%>";
    var newRegionCode = "<%=regionCode%>";
    var loginUserDeptId = '<%=loginUser!=null?loginUser.getDeptId():""%>';
    var loginUserDeptName = '<%=loginUser!=null?loginUser.getDeptName():""%>';
    initGlobalCustom(basePathJS);
</script>