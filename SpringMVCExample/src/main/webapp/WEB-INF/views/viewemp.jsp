<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Summary</title>
<link href="<c:url value='/resources/assets/table.css' />"
	rel="stylesheet"></link>
</head>
<body>

	<h1>Employees List</h1>


	<table class="layout display responsive-table">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Actions</th>
		</tr>
		<c:if test="${not empty list}">
			<c:forEach items="${list}" var="employee" varStatus="status">
				<tr>
					<td class="organisationnumber">${employee.id}</td>
					<td class="organisationname">${employee.name}</td>
					<td class="organisationnumber">${employee.salary}</td>
					<td class="actions"><a href="?" class="edit-item" title="Edit">Edit</a>
						<!-- a href="deleteemp/" <c:out value="${employee.id}"></c:out>
						class="remove-item" title="Remove">Remove</a--> 
						<c:url
							value="deleteemp" var="url"
							scope="request">
							<c:param name="empId" value='${employee.id}' />
						</c:url></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>


	<c:if test="${not empty list}">
		<c:forEach items="${list}" var="employee" varStatus="status">

		</c:forEach>
	</c:if>

	<c:set var="listsize" value=${list }/>

	Total Subscribed Users:
	<p>
		<c: out value="listsize" />
	</p>
	<a href="1">1</a>
	<a href="2">2</a>
	<a href="3">3</a>
</body>
</html>