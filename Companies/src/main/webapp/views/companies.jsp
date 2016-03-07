<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html ng-app="myCompany">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Companies</title>
	
		<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular-route.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/vendor/upida.angular.js" />"></script>
	
		<script type="text/javascript" src="<c:url value="/resources/js/app.js" />"></script>
	
		<script type="text/javascript" src="<c:url value="/resources/js/controllers/allController.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/controllers/addController.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/controllers/addChildController.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/controllers/selectController.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/controllers/removeController.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/controllers/updateController.js" />"></script>
		
		<link rel="stylesheet" href=<c:url value="/resources/css/style.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/jquery/src/skin/ui.dynatree.css"></c:url>>
		
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap-theme.min.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap-theme.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap.min.css"></c:url>>
		
		<script src="<c:url value="/resources/jquery/jquery/jquery.js"/>" type="text/javascript"></script> 
		<script src="<c:url value="/resources/jquery/jquery/jquery-ui.custom.js"/>" type="text/javascript"></script> 
		<script src="<c:url value="/resources/jquery/src/jquery.dynatree.js"/>" type="text/javascript"></script> 
	</head>
	<body>
		<div style="border-bottom: 2px solid grey;">
			<h2 style="display: inline-block; margin-top: 10px;">Companies</h2> 
		</div>
		<ng-view></ng-view>
	</body>
</html>