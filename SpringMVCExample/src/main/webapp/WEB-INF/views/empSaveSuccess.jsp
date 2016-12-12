<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>
<html>
<head>
	<title>Employee Saved Successfully</title>
</head>
<body>
<a href="..">Home</a><br/>
<h3>
	Employee Saved Successfully.
</h3>

<strong>Employee ID:${employee.id}</strong><br>
<strong>Employee Name:${employee.name}</strong><br>
<strong>Employee Salary:${employee.salary}</strong><br>
<!-- strong>Customer Gender:${customer.gender}</strong><br>
<strong>Customer Birthday:<fmt:formatDate value="${customer.birthday}" type="date" /></strong><br-->

</body>
</html>
