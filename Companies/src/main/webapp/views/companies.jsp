<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Companies</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link rel="stylesheet" href=<c:url value="/resources/css/style2.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/jquery/src/skin/ui.dynatree.css"></c:url>>
		
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap-theme.min.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap-theme.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap.min.css"></c:url>>	
		
		<script src="${pageContext.request.contextPath}/resources/jquery/jquery/jquery.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/resources/jquery/jquery/jquery-ui.custom.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/resources/jquery/src/jquery.dynatree.js" type="text/javascript"></script>
	</head>
	<body>
		<script type="text/javascript">
			$(function(){
			    $("#tree").dynatree({ 
			    	onActivate: function(node) {
			    		if (node.data.href)
			            	window.location.href = dtnode.data.href;
			          },
			    	children: ${companies}   
			    });
			});
	    </script>
		<div style="text-align: center; margin-bottom: 15px;">
			<h2 style="display: inline-block;">Companies</h2>
			<br>
			<a href="addCompany" style="font-size: 16px;">Add main company</a>
		</div>
		<div id="tree" style="width: 300px; margin: auto;"></div>
	</body>
</html>