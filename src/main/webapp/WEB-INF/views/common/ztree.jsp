<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<style>
	#treeview .list-group {
		-webkit-user-select: none;
		-moz-user-select: none;
		-ms-user-select: none;
		user-select: none;
	}
	#treeview{
		/*overflow-y: scroll;*/
	}
	.tree {
		width: 100%;
		clear: both;
		z-index: 9999;
		position: absolute;
		top: 41px;
		height: 330px;
		overflow-y: scroll;
		box-shadow: 8px 6px 10px 4px;
		background-color: #fff;
	}

	.tree .list-group-item {
		position: relative;
		display: block;
		padding: 0px 5px;
		margin-bottom: -1px;
		background-color: #fff;
		border: 1px solid #ddd;
	}

	.tree-search {
		position: absolute;
		right: 34px;
		top: 4px;
	}
    #aside {
		position: absolute;
		top: 181px;
		bottom: 145px;
    }
    #aside .aside-wrap{
        height: 100%;
    }
    #aside .navi-wrap{
        height: 100%;
        min-height: 300px;
        overflow-y: auto;
        border: 1px solid #dee5e7;
    }
    .tab-pane{
        min-height: 300px;
    }

</style>
<div id="treeview" class="ztree"></div>
<script type="text/javascript">

    
    
</script>
