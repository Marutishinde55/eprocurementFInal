<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>User Login</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>

<div id="wrapper">
<div id="header">
<h2>EprocureMent Login User</h2>
</div>
</div>

<div id="container">
<h3>User Login</h3>

${msg}
<form:form action="userPage" modelAttribute="customer" method="post" >
<table>
    <tbody>
		<tr>
		<td><label>UserName</label></td>
			<td><form:input path="userName"/></td>
			<td><form:errors path="userName" cssClass="error"/></td>
		</tr>
		<tr>
		<td><label>Password</label></td>
			<td><form:password path="password"/></td>
			<td><form:errors path="password" cssClass="error"/></td>
		</tr>
		<tr>
		<td><label></label></td>
			<td><input type="submit" value="Login" class="save"></td>
		</tr>
	</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/customer/forgotPassword">Forgot Password</a>
<a href="${pageContext.request.contextPath}/customer/showformadd">Register User</a><br>
<a href="${pageContext.request.contextPath}/customer/Admin">AdminLogin</a>
</div>
</body>

</html>