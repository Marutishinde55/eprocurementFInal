<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
<title>User Registration</title>
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
<h2>EprocureMent </h2>
</div>
</div>

<div id="container">
<h3>Registration Form </h3>
<form:form action="saveCustomer" modelAttribute="customer"  method="post">

<table>
    <tbody>
		<tr>
			<td><label>FirstName</label></td>
			<td><form:input path="firstName"/></td>
			<td><form:errors path="firstName" cssClass="error"/></td>
		</tr>
		<tr>
		<td><label>LastName</label></td>
			<td><form:input path="lastName"/></td>
			<td><form:errors path="lastName" cssClass="error"/></td>
		</tr>
		<tr>
		<td><label>Gender</label></td>
			<td><form:select path="gender">
			<form:option value="male" label="Male"></form:option>
			<form:option value="Female" label="Female"></form:option>
			</form:select></td>
		</tr>
		<tr>
		<td><label>UserName</label></td>
			<td><form:input path="userName"/></td>
			<td><form:errors path="userName" cssClass="error"/></td>
		</tr>
		<tr>
		<td><label>Password</label></td>
			<td><form:password path="password" placeholder="atleat 8 characters"/></td>
			<td><form:errors path="password" cssClass="error"/></td>
			
		</tr>
		<tr>
		<td><label>MobileNo</label></td>
			<td><form:input path="mobileNo" placeholder="10 Digit number"/></td>
			<td><form:errors path="mobileNo" cssClass="error"/></td>
		</tr>
		<tr>
		<td><label>Email</label></td>
			<td><form:input path="email"/></td>
			<td><form:errors path="email" cssClass="error"/></td>
		</tr>
		<tr>
		<td><label></label></td>
			<td><input type="submit" value="Save" class="save"></td>
		</tr>
	</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/customer/login">Back to Login Page</a>
</div>
</body>

</html>