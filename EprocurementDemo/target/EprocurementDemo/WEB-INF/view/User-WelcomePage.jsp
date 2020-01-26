<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<title>Welcome User Page</title>
</head>
<body>
${message}
${firstname.firstName}
<br><br>
		<p>
        <a href="${pageContext.request.contextPath}/customer/login">Logout</a>
      </p> 
</body>


</html>

