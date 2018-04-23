<%@ page import="com.chinawiserv.dsp.base.entity.vo.system.SysUserVo" %>
<%@ page import="com.chinawiserv.dsp.base.common.SystemConst" %>
<%@ page import="org.springframework.util.StringUtils" %>
<%@ page import="org.springframework.util.ObjectUtils" %>
<%@ page import="java.util.Date" %>
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
    Long nowDate = new Date().getTime();
    request.setAttribute("nowDate", nowDate);
%>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${systemName}</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="<%=context_path%>/plugins/bootstrap/css/bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=context_path%>/app/css/AdminLTE.css">
<link rel="stylesheet" href="<%=context_path%>/app/css/skins/skin-blue.css">

<!-- 自定义 css -->
<link rel="stylesheet"  href="<%=context_path%>/plugins/layui/css/layui.css">
<link rel="stylesheet" href="<%=context_path%>/css/custom.css">
<link rel="stylesheet" href="<%=context_path%>/css/linkage.css" />
<link rel="stylesheet" href="<%=context_path%>/css/Rebaseadmin1.css">
<link rel="stylesheet" href="<%=context_path%>/css/catalogue.css">
<link rel="stylesheet" href="<%=context_path%>/css/release.css">

<!-- REQUIRED JS SCRIPTS -->

<!--[if lt IE 9]>
<script src="<%=context_path%>/plugins/others/html5shiv.min.js"></script>
<script src="<%=context_path%>/plugins/others/respond.min.js"></script>
<![endif]-->


<script src="<%=context_path%>/plugins/requirejs/require.js" ></script>
<script src="<%=context_path%>/plugins/main.js" ></script>


<script src="<%=context_path%>/js/custom/curdtools.js"></script>
<script src="<%=context_path%>/js/system/dict/dictSelect.js"></script>

<script type="text/javascript">
    var basePathJS = location.protocol + '//' + location.host + "<%=context_path%>";
    var newRegionCode = "<%=regionCode%>";
    var loginUserDeptId = '<%=loginUser!=null?loginUser.getDeptId():""%>';
    var loginUserDeptName = '<%=loginUser!=null?loginUser.getDeptName():""%>';
    //initGlobalCustom(basePathJS);
</script>