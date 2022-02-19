<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
    <head>
		<title>javadevtools Admin</title>
        <jsp:directive.include file="commonHeaders.jsp" />
	</head>
	<body>
		<div id="header">
			<h1>Login</h1>
		</div>
		
		<c:if test="${param.error != null}">
		   <div>
		       Invalid username and password.
		   </div>
		</c:if>
		
		<c:if test="${param.logout != null}">
		   <div>
		       You have been logged out successfully.
		   </div>
		</c:if>		
		
		<form id="login" action="/login" method="post">
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    <div>
        		<label for="user">User</label>
		        <input name="username"
		               maxlength="100"
		               onclick="this.select()"/>
           </div>
           <div>
        		<label for="password">Password</label>
		        <input name="password"
		               type="password"
		               maxlength="100"
		               onclick="this.select()"/>
           </div>
           <div>
           		<input id="submit"
           		       type="submit"
           		       value="Submit" />
           </div>
		</form>
	</body>
</html>
