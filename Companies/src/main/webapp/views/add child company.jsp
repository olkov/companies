<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link rel="stylesheet" href=<c:url value="/resources/css/style.css"></c:url>>
		
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap-theme.min.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap-theme.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap.min.css"></c:url>>	
		
		<title>Add child "${company.companyName}" company</title>
	</head>
	<body class="center">
		<div class="content">
			<h3>Add child "${company.companyName}" company</h3>
			<form action="addChildCompany" method="post">
			<div class="input">
				<input type="text" class="form-control" name="companyName" placeholder="Company name" required>
				<input type="text" class="form-control" name="estimatedEarnings" placeholder="Estimated earnings" required>
				<input type="text" name="id" value="${id}" class="invisible" readonly>
			</div>
				<button type="submit" class="btn btn-default btn-lg" style="margin-top: -20px;">Add</button>
			</form>
		</div>
	</body>
</html>