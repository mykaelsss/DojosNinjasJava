<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" class="form" modelAttribute="ninja">
		<div>
			<form:select path="dojo">
				<c:forEach var="dojo" items="${allDojos}">
					<form:option path="dojo" value="${dojo.id}">
						<c:out value="${dojo.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</div>
 		<div>
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName"/>
		</div> 
 		<div>
			<form:label path="lastName">Last Name:</form:label>
			<form:input path="lastName"/>
		</div> 
 		<div>
			<form:label path="age">Age:</form:label>
			<form:input path="age" type="number"/>
		</div> 
		<div>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</div>
	</form:form>
</body>
</html>