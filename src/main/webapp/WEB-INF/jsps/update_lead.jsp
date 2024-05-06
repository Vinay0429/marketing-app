<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create</title>
</head>
<body>
	<h2>Update Lead</h2>
	
	<form action="updateLead" method="post">
		<pre>
		     <input type="hidden" name="id" value="${lead.id}"/>
			First Name:<input type="test" name="firstName" value="${lead.firstName}"/>
			Last Name:<input type="test" name="lastName" value="${lead.lastName}"/>
			Email:<input type="test" name="email" value="${lead.email}"/>
			Mobile:<input type="test" name="mobile" value="${lead.mobile}"/>
			<input type="submit" value="update"/>
		</pre>
		
	</form>
	
	${msg}
</body>
</html>