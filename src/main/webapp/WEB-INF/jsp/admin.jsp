<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <head>
		<title>Admin</title>
        <jsp:directive.include file="commonHeaders.jsp" />
	</head>
	<body>
		<div id="header">
			<h1>Admin</h1>
		</div>
		
        <form action="logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Logout"/>
        </form>		
	</body>
</html>
