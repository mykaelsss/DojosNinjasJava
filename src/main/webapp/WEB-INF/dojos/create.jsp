<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos/new" method="post" class="form" modelAttribute="dojo">
		<div>
			<form:label path="name">Name:</form:label>
			<form:input path="name"/>
		</div>
		<div>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</div>
	</form:form>
</body>
</html>