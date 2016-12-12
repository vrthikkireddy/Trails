<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Summary</title>
<link href="<c:url value='resources/static/css/table.css' />"
	rel="stylesheet"></link>
</head>
<body>
	<div class="main-content">

		<h1>Employee Management</h1>

		<!-- 
  
  	<c:if test="${not empty empList}">

		<ul>
			<c:forEach var="listValue" items="${empList}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>

	</c:if>
	
	 -->

		<!-- input type="submit" value="Add Employee"></input-->
		
		<input type="button"  onclick="location.href='emp/save'" value="Add Employee" >

		<table class="layout display responsive-table">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Salary</th>
				<th>Actions</th>
			</tr>
			<c:if test="${not empty empList}">
				<c:forEach items="${empList}" var="employee" varStatus="status">
					<tr>
						<td class="organisationnumber">${employee.id}</td>
						<td class="organisationname">${employee.name}</td>
						<td class="organisationnumber">${employee.salary}</td>
						<td class="actions">
						<a href="emp/edit/${employee.id}" class="edit-item" title="Edit">Edit</a> 
						<a href="delete/${employee.id}" class="remove-item" title="Remove">Remove</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>

		<!-- End of custom tag  -->
	</div>
</body>
</html>