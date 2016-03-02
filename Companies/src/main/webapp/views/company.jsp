<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Company</title>
		
		<link rel="stylesheet" href=<c:url value="/resources/css/style.css"></c:url>>

		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap-theme.min.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap-theme.css"></c:url>>
		<link rel="stylesheet" href=<c:url value="/resources/bootstrap-3/css/bootstrap.min.css"></c:url>>	

		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<h4 style="margin-top: 20px;">
			<c:if test="${company.parentId == null}">
				This company is main.
			</c:if>
			<c:if test="${company.parentId != null}">
				This company is child "${company2.companyName}" company.
			</c:if>
		</h4>
		<table class="myTable myTable-hover" style="margin-bottom: 20px;">
			<thead>
				<tr>
					<th>Company name</th>
					<th>Estimated earnings</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>${company.companyName}</td>
						<td>${company.estimatedEarnings}</td>
						<td class="noHover">
							<a href="removeCompany?id=${company.idCompany}" class="remove"></a>
							<a href="updateCompany?id=${company.idCompany}" class="edit"></a>
						</td>
					</tr>
			</tbody>
		</table>
		<a href="companies">Back</a>
		<br/>
		<a href="addChildCompany?id=${company.idCompany}">Add child company</a>
	</body>
</html>