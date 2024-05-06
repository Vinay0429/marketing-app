<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create</title>
</head>
<body>
	<h2>Create Lead</h2>
	
	<form action="saveLead" method="post">
		<pre>
			First Name:<input type="test" name="firstName"/>
			Last Name:<input type="test" name="lastName"/>
			Email:<input type="test" name="email"/>
			Mobile:<input type="test" name="mobile"/>
			<input type="submit" value="save"/>
		</pre>
		
	</form>
	
	${msg}
</body>
</html>