<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee</title>
 <link href="<c:url value='/resources/assets/demo.css' />" rel="stylesheet"></link>
 <link href="<c:url value='/resources/assets/form-basic.css' />" rel="stylesheet"></link>
</head>
<body>
  <div class="main-content">

        <!-- You only need this form and the form-basic.css -->

        <form class="form-basic" method="get" action="empsave">

            <div class="form-title-row">
                <h1>Create Employee</h1>
            </div>

            <div class="form-row">
                <label>
                    <span>Full Name</span>
                    <input type="text" name="name">
                </label>
            </div>

            <div class="form-row">
                <label>
                    <span>Salary</span>
                    <input type="text" name="salary">
                </label>
            </div>

            <div class="form-row">
                <button type="submit">Create Employee</button>
            </div>

        </form>

    </div>
</body>
</html>